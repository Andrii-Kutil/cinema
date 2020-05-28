package com.gmail.kutilandrej.cinema.dao.impl;

import com.gmail.kutilandrej.cinema.dao.OrderDao;
import com.gmail.kutilandrej.cinema.exception.DataProcessingException;
import com.gmail.kutilandrej.cinema.lib.Dao;
import com.gmail.kutilandrej.cinema.model.Order;
import com.gmail.kutilandrej.cinema.model.Ticket;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class OrderDaoImpl implements OrderDao {

    @Override
    public Order add(Order order) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Order entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Order O LEFT JOIN FETCH O.tickets AS t JOIN FETCH t.movieSession "
                    + "JOIN FETCH t.user WHERE O.user = :user";
            Query<Order> query = session.createQuery(hql, Order.class);
            query.setParameter("user", user);
            List<Order> orders = query.getResultList();
            fillTickets(orders);
            return orders;
        } catch (Exception e) {
            throw new DataProcessingException("Can't find Orders", e);
        }
    }

    void fillTickets(List<Order> orders) {
        for (Order order : orders) {
            List<Ticket> tickets = order.getTickets();
            for (int j = 0; j < order.getTickets().size(); j++) {
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    String hql = "FROM Ticket T WHERE T.id = :id";
                    Query<Ticket> query = session.createQuery(hql, Ticket.class);
                    query.setParameter("id", tickets.get(j).getId());
                    tickets.set(j, query.uniqueResult());
                } catch (Exception e) {
                    throw new DataProcessingException("Can't fill Tickets", e);
                }
            }
        }
    }
}
