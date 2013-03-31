package com.mmoscene.h4j.persistence.dao;


import java.io.Serializable;
import java.util.List;

public interface IDao<T, ID extends Serializable> {

    public T findById(ID id);
    public boolean create(T object);
    public boolean update(T object);
    public void destroy(ID id, T object);
    public List<T> findAll(T object);

}
