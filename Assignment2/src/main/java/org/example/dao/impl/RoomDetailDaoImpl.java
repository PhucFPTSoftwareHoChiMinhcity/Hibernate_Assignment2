package org.example.dao.impl;

import org.example.dao.RoomDetailDao;
import org.example.util.HibernateUtils;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class RoomDetailDaoImpl implements RoomDetailDao {
    @Override
    public List<RoomDetailDao> getAll() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("FROM RoomDetailDao", RoomDetailDao.class)
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
    public RoomDetailDao getById(long id) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            RoomDetailDao roomDetailDao = session.get(RoomDetailDao.class, id);
            return roomDetailDao;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public long save(RoomDetailDao data) {
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
    public boolean update(RoomDetailDao data, long id) {
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
           RoomDetailDao roomDetailDao = session.get(RoomDetailDao.class, id);
            if (roomDetailDao == null) {
                return false;
            }
            session.delete(roomDetailDao);
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
