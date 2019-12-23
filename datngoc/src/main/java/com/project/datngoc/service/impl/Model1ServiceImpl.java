package com.project.datngoc.service.impl;

import com.project.datngoc.model.Model1;
import com.project.datngoc.repo.Model1Repo;
import com.project.datngoc.service.Model1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Model1ServiceImpl implements Model1Service {

    @Autowired
    private Model1Repo model1Repo;

    @Override
    public List<Model1> findAll() throws Exception {
        List<Object[]> model1s = model1Repo.getAll();
        List<Model1> list = new ArrayList<>();
        for(Object[] model1 : model1s) {
            Model1 model11 = new Model1();
            model11.setId((Integer) model1[0]);
            model11.setName((String) model1[1]);
            list.add(model11);
        }
        return list;
    }

    @Override
    public Model1 getByIid(Integer id) throws Exception {
        Object[] models = model1Repo.getById(id);
        Model1 model1 = new Model1();
        model1.setId((Integer) models[0]);
        model1.setName((String) models[1]);
        return model1;
    }
}
