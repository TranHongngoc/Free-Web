package com.project.datngoc.service;

import com.project.datngoc.model.Model1;
import com.project.datngoc.repo.Model1Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Model1Service {

    List<Model1> findAll() throws Exception;

    Model1 getByIid(Integer id) throws  Exception;
}
