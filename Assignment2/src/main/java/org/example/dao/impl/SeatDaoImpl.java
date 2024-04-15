package org.example.dao.impl;

import org.example.dao.SeatDao;
import org.example.util.HibernateUtils;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class SeatDaoImpl implements SeatDao {
    @Override
    public List<SeatDao> getAll() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("FROM SeatDao", SeatDao.class)
                    .setCacheable(true).setCacheMode(CacheMode.REFRESH); // Query Cache
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public SeatDao getById(long id) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            SeatDao seatDao = session.get(SeatDao.class, id);
            return seatDao;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public long save(SeatDao data) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Serializable result = session.save(data);
            transaction.commit();
            return (long) result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return 0;
    }

    @Override
    public boolean update(SeatDao data, long id) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(data);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
           SeatDao seatDao = session.get(SeatDao.class, id);
            if (seatDao == null) {
                return false;
            }
            session.delete(seatDao);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
}
