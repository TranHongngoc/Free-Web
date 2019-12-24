package com.project.datngoc.controller;

import com.project.datngoc.model.Model1;
import com.project.datngoc.service.Model1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Model1Controller {

    @Autowired
    private Model1Service model1Service;

    @GetMapping("/allName")
    public List<Model1> getAll() {
        try {
            List<Model1> model1s = model1Service.findAll();
            if(model1s != null){
                return model1s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/getById/{id}")
    public Model1 getById(@PathVariable(value = "id") Integer id) throws Exception {
        Model1 mo = model1Service.getByIid(id);
        return mo;
    }
}
