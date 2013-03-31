package com.mmoscene.h4j.persistence.dao.impl;


import com.mmoscene.h4j.persistence.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

public class HibernateDao<T,ID extends Serializable> implements IDao<T,ID> {


    @SuppressWarnings("unchecked")
    @Override
    public T findById(T item,ID id) {
        return (T)HibernateUtils.getCurrentSession().load(getType(item),id);
    }


    @Override
    public Class<? extends Object> getType(T item) {
        return item.getClass();
    }

    @Override
    public void create(T item) {
        HibernateUtils.getCurrentSession().save(item);
    }

    @Override
    public void update(T item) {
        HibernateUtils.getCurrentSession().update(item);
    }

    @Override
    public void destroy(T item) {
        HibernateUtils.getCurrentSession().delete(item);
    }

    @Override
    public List<T> findAll(T item,Criterion... criterion) {

        Session session = HibernateUtils.getCurrentSession();

        Criteria criteriaObj = session.createCriteria(getType(item));

        for(Criterion c : criterion) {

            criteriaObj.add(c);

        }

        return criteriaObj.list();

    }
}
