package com.peregud.shoppingcenter.dao;

import com.peregud.shoppingcenter.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> {

    public T save(T t) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return t;
    }

    public T getById(Class<T> clazz, int id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        T t = null;
        try {
            t = entityManager.find(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return t;
    }

    public void delete(Class<T> clazz, int id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM " + clazz.getName() + " WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public List<?> getAll(Class<T> clazz) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        List<?> list = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            list = entityManager
                    .createQuery("FROM " + clazz.getName())
                    .getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<?> selectIdForSet(T t, int id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        t = (T) entityManager.find(t.getClass(), id);
        List<?> list = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            list = entityManager
                    .createQuery("SELECT " + id + " FROM " + t.getClass().getName() + " WHERE " + t + " = :" + t)
                    .setParameter("t", t)
                    .getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return list;
    }
}
