package com.peregud.shoppingcenter.util;

import com.peregud.shoppingcenter.model.DiscountStatistics;
import lombok.experimental.UtilityClass;

import javax.persistence.EntityManager;

@UtilityClass
public class DiscountListenerUtil {

    public DiscountStatistics save(String discount) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        DiscountStatistics discountStatistics = null;
        try {
            entityManager.getTransaction().begin();
            discountStatistics = DiscountStatistics.builder()
                    .discount(discount)
                    .build();
            entityManager.merge(discountStatistics);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return discountStatistics;
    }
}
