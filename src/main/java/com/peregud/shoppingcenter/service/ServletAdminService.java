package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.model.Admin;
import com.peregud.shoppingcenter.util.HibernateUtil;

import javax.persistence.EntityManager;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class ServletAdminService extends ServletService<Admin> {

    public boolean findAdmin(String name, String password) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        long result = 0;
        try {
            result = (Long) entityManager.createQuery("SELECT count(*) FROM Admin WHERE name = :name and " +
                    "password = :password")
                    .setParameter(PARAM_NAME, name)
                    .setParameter(PARAM_PASSWORD, password)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return result > 0;
    }
}
