package com.peregud.shoppingcenter.dao;

import java.util.List;

public interface DAO<T> {
    T save(T t);
    T getById(Class<T> clazz, int id);
    void delete(Class<T> clazz, int id);
    List<?> getAll(Class<T> clazz);
}
