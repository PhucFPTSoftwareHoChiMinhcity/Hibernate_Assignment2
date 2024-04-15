package org.example.dao.impl;

import org.example.dao.RoomDao;
import org.example.util.HibernateUtils;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    @Override
    public List<RoomDao> getAll() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("FROM RoomDao", RoomDao.class)
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
    public RoomDao getById(long id) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            RoomDao roomDao = session.get(RoomDao.class, id);
            return roomDao;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public long save(RoomDao data) {
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
    public boolean update(RoomDao data, long id) {
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
            RoomDao roomDao = session.get(RoomDao.class, id);
            if (roomDao == null) {
                return false;
            }
            session.delete(roomDao);
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
