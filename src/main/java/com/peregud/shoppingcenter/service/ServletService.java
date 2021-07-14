package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.dao.AbstractDAO;

import java.util.List;

public class ServletService<T> extends AbstractDAO<T> {

    public T save(T t) {
        return super.save(t);
    }

    public T getById(Class<T> clazz, int id) {
        return super.getById(clazz, id);
    }

    public List<?> getList(Class<T> clazz) {
        return super.getAll(clazz);
    }

    public void delete(Class<T> clazz, int id) {
        super.delete(clazz, id);
    }

    public void deleteList(Class<T> clazz, String[] idList) {
        String i;
        for (String id : idList) {
            i = id;
            super.delete(clazz, Integer.parseInt(i));
        }
    }

    public List<?> selectIdForSet(T t, int id) {
        return super.selectIdForSet(t, id);
    }
}
