package com.project.datngoc.repo.impl;

import com.project.datngoc.model.Model1;
import com.project.datngoc.repo.Model1Repo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class Model1RepoImpl implements Model1Repo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Object[]> getAll() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from table_test");
        Query query = entityManager.createNativeQuery(stringBuilder.toString());
        return query.getResultList();
    }

    @Override
    public Object[] getById(Integer id) throws Exception {
        try{
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select * from table_test m where m.id= :modelId");
            Query query = entityManager.createNativeQuery(stringBuilder.toString());
            query.setParameter("modelId", id);
            return (Object[]) query.getSingleResult();
        } catch (NoResultException no) {
                no.printStackTrace();
            return null;
        }

    }


}
