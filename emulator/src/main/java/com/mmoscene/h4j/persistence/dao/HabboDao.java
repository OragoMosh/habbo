package com.mmoscene.h4j.persistence.dao;


import com.mmoscene.h4j.habbohotel.user.Habbo;
import com.mmoscene.h4j.persistence.HibernateUtils;
import com.mmoscene.h4j.persistence.dao.impl.HibernateDao;
import org.hibernate.criterion.Restrictions;

public class HabboDao extends HibernateDao<Habbo,Long> {

    public Habbo findBySso(String ssoTicket) {
        Habbo habbo;

        habbo = (Habbo)HibernateUtils.getCurrentSession().createCriteria(Habbo.class).add(Restrictions.eq("client_key",Habbo.class)).uniqueResult();

        if(habbo != null) {
            return habbo;
        }

        return null;
    }

}
