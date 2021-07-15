package com.peregud.shoppingcenter.service;

import java.util.List;

public interface ServletService<T> {
    T save(T t);
    T getById(Class<T> clazz, int id);
    List<T> getList(Class<T> clazz);
    void delete(Class<T> clazz, int id);
    void deleteList(Class<T> clazz, String[] idList);
}
