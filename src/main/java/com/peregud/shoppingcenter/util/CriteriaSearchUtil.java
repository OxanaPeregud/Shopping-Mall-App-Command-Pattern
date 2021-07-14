package com.peregud.shoppingcenter.util;

import com.peregud.shoppingcenter.dto.DiscountDto;
import com.peregud.shoppingcenter.dto.DiscountStatisticsDto;
import com.peregud.shoppingcenter.dto.ShopDiscountDto;
import com.peregud.shoppingcenter.dto.ShopDto;
import com.peregud.shoppingcenter.model.*;
import com.sun.istack.NotNull;
import lombok.experimental.UtilityClass;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CriteriaSearchUtil {

    public List<ShopDto> shopKeywords(String search) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shop> criteriaQuery = criteriaBuilder.createQuery(Shop.class);
        Root<Shop> root = criteriaQuery.from(Shop.class);
        Predicate predicate1 = criteriaBuilder
                .like(criteriaBuilder.lower(root.get(Shop_.NAME)), "%" + search.toLowerCase() + "%");
        Predicate predicate2 = criteriaBuilder
                .like(criteriaBuilder.lower(root.get(Shop_.DESCRIPTION)), "%" + search.toLowerCase() + "%");
        criteriaQuery.select(root)
                .where(criteriaBuilder.or(predicate1, predicate2));
        TypedQuery<Shop> query = entityManager.createQuery(criteriaQuery);
        List<Shop> resultList = query.getResultList();
        List<ShopDto> shopDtoList = new ArrayList<>();
        resultList.forEach(shop -> {
            ShopDto shopDto = new ShopDto();
            shopDto.setId(shop.getId());
            shopDto.setName(shop.getName());
            shopDto.setDescription(shop.getDescription());
            shopDto.setLocation(shop.getLocation());
            shopDtoList.add(shopDto);
        });
        entityManager.close();
        return shopDtoList;
    }

    public List<DiscountDto> minimumDiscount(int minimumDiscount) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Discount> criteriaQuery = criteriaBuilder.createQuery(Discount.class);
        Root<Discount> root = criteriaQuery.from(Discount.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.gt(root.get(Discount_.DISCOUNT), minimumDiscount - 1));
        TypedQuery<Discount> query = entityManager.createQuery(criteriaQuery);
        List<Discount> resultList = query.getResultList();
        List<DiscountDto> discountDtoList = new ArrayList<>();
        resultList.forEach(discount -> {
            DiscountDto discountDto = new DiscountDto();
            discountDto.setId(discount.getId());
            discountDto.setDiscount(discount.getDiscount());
            discountDto.setDiscountStartDate(discount.getDiscountStartDate());
            discountDto.setDiscountEndDate(discount.getDiscountEndDate());
            discountDtoList.add(discountDto);
        });
        entityManager.close();
        return discountDtoList;
    }

    public List<?> discountStatistics() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
        Root<DiscountStatistics> discountStatisticsRoot = query.from(DiscountStatistics.class);
        query.groupBy(discountStatisticsRoot.get(DiscountStatistics_.DISCOUNT));
        query.multiselect(discountStatisticsRoot.get(DiscountStatistics_.DISCOUNT),
                criteriaBuilder.count(discountStatisticsRoot));
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(query);
        List<Object[]> resultList = typedQuery.getResultList();
        List<DiscountStatisticsDto> discountStatisticsDtoList = new ArrayList<>();
        resultList.forEach(objects -> {
            DiscountStatisticsDto discountStatisticsDto = new DiscountStatisticsDto();
            discountStatisticsDto.setDiscount((String) objects[0]);
            discountStatisticsDto.setCount((Long) objects[1]);
            discountStatisticsDtoList.add(discountStatisticsDto);
        });
        entityManager.close();
        return discountStatisticsDtoList;
    }

    public List<?> joinTablesShopDiscounts(Integer id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
        Root<Shop> root = criteriaQuery.from(Shop.class);
        Join<Shop, Discount> join = root.join(Shop_.DISCOUNT, JoinType.LEFT);
        criteriaQuery.multiselect(root, join);
        criteriaQuery.where(criteriaBuilder.equal(root.get(Shop_.ID), id));
        TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        List<Tuple> shopDiscount = query.getResultList();
        List<ShopDiscountDto> shopDiscountDtoList = new ArrayList<>();
        shopDiscount.forEach(tuple -> {
            ShopDiscountDto shopDiscountDto = new ShopDiscountDto();
            shopDiscountDto.setName(((Shop) tuple.get(0)).getName());
            shopDiscountDto.setLocation(((Shop) tuple.get(0)).getLocation());
            shopDiscountDto.setDiscount(((Discount) tuple.get(1)).getDiscount());
            shopDiscountDto.setDiscountStartDate(((Discount) tuple.get(1)).getDiscountStartDate());
            shopDiscountDto.setDiscountEndDate(((Discount) tuple.get(1)).getDiscountEndDate());
            shopDiscountDtoList.add(shopDiscountDto);
        });
        entityManager.close();
        return shopDiscountDtoList;
    }

    public List<?> joinTablesMinimumDiscount(int minimumDiscount) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
        Root<Discount> root = criteriaQuery.from(Discount.class);
        Join<Discount, Shop> join = root.join(Discount_.SHOP, JoinType.LEFT);
        criteriaQuery.multiselect(root, join);
        criteriaQuery.where(criteriaBuilder.gt(root.get(Discount_.DISCOUNT), minimumDiscount - 1));
        return getObjects(entityManager, criteriaQuery);
    }

    public List<?> joinTablesActualDiscounts() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
        Root<Discount> root = criteriaQuery.from(Discount.class);
        Join<Discount, Shop> join = root.join(Discount_.SHOP, JoinType.LEFT);
        criteriaQuery.multiselect(root, join);
        criteriaQuery.where(criteriaBuilder.greaterThan(root.get(Discount_.DISCOUNT_END_DATE), LocalDate.now()));
        return getObjects(entityManager, criteriaQuery);
    }

    @NotNull
    private static List<?> getObjects(EntityManager entityManager, CriteriaQuery<Tuple> criteriaQuery) {
        TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        List<Tuple> shopDiscount = query.getResultList();
        List<ShopDiscountDto> shopDiscountDtoList = new ArrayList<>();
        shopDiscount.forEach(tuple -> {
            ShopDiscountDto shopDiscountDto = new ShopDiscountDto();
            shopDiscountDto.setName(((Shop) tuple.get(1)).getName());
            shopDiscountDto.setLocation(((Shop) tuple.get(1)).getLocation());
            shopDiscountDto.setDiscount(((Discount) tuple.get(0)).getDiscount());
            shopDiscountDto.setDiscountStartDate(((Discount) tuple.get(0)).getDiscountStartDate());
            shopDiscountDto.setDiscountEndDate(((Discount) tuple.get(0)).getDiscountEndDate());
            shopDiscountDtoList.add(shopDiscountDto);
        });
        entityManager.close();
        return shopDiscountDtoList;
    }
}
