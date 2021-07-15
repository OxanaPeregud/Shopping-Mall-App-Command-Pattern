package com.peregud.shoppingcenter.util;

import lombok.experimental.UtilityClass;

import javax.persistence.EntityManager;

import static com.peregud.shoppingcenter.command.CommandConstant.PARAM_NAME;
import static com.peregud.shoppingcenter.command.CommandConstant.PARAM_PASSWORD;

@UtilityClass
public class CheckAdminUtil {

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
