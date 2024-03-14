package org.example.service;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class CrudService<T> {
    protected Session getSession() {
        return HibernateUtil.getInstance().getSessionFactory().openSession();
    }

    public void create(T entity) {
        try (Session session = getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        }
    }

    public T read(Class<T> entityClass, Object id) {
        try (Session session = getSession()) {
            return session.get(entityClass, id);
        }
    }

    public void update(T entity) {
        try (Session session = getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        }
    }

    public void delete(T entity) {
        try (Session session = getSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        }
    }
}
