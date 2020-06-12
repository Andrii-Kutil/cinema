package com.gmail.kutilandrej.cinema.dao.impl;

import com.gmail.kutilandrej.cinema.dao.MovieSessionDao;
import com.gmail.kutilandrej.cinema.exception.DataProcessingException;
import com.gmail.kutilandrej.cinema.model.MovieSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl implements MovieSessionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM MovieSession MS JOIN FETCH MS.movie "
                    + "JOIN FETCH MS.cinemaHall WHERE MS.movie.id = :id "
                    + "AND MS.showTime > :date1 AND MS.showTime < :date2";
            Query<MovieSession> query = session.createQuery(hql, MovieSession.class);
            query.setParameter("id", movieId);
            query.setParameter("date1", date.atStartOfDay());
            query.setParameter("date2", date.atTime(LocalTime.MAX));
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find MovieSession", e);
        }
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert MovieSession entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public MovieSession get(Long sessionId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM MovieSession MS JOIN FETCH MS.movie "
                    + "JOIN FETCH MS.cinemaHall WHERE MS.id = :id";
            Query<MovieSession> query = session.createQuery(hql, MovieSession.class);
            query.setParameter("id", sessionId);
            return query.uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get MovieSession", e);
        }
    }
}
