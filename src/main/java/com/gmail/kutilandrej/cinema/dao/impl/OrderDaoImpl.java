package com.gmail.kutilandrej.cinema.dao.impl;

import com.gmail.kutilandrej.cinema.dao.OrderDao;
import com.gmail.kutilandrej.cinema.exception.DataProcessingException;
import com.gmail.kutilandrej.cinema.model.Order;
import com.gmail.kutilandrej.cinema.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Order add(Order order) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
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
    public List<Order> getByUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Order O JOIN FETCH O.tickets AS T JOIN FETCH T.movieSession AS MS "
                    + "JOIN FETCH MS.movie JOIN FETCH MS.cinemaHall "
                    + "JOIN FETCH T.user WHERE O.user = :user";
            Query<Order> query = session.createQuery(hql, Order.class);
            query.setParameter("user", user);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find Orders", e);
        }
    }
}
