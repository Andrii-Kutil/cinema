package com.gmail.kutilandrej.cinema.dao.impl;

import com.gmail.kutilandrej.cinema.dao.TicketDao;
import com.gmail.kutilandrej.cinema.exception.DataProcessingException;
import com.gmail.kutilandrej.cinema.lib.Dao;
import com.gmail.kutilandrej.cinema.model.Ticket;
import com.gmail.kutilandrej.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class TicketDaoImpl implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Ticket entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
