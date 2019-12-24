package com.project.datngoc.repo;

import com.project.datngoc.model.Model1;

import java.util.List;

public interface Model1Repo {

    List<Object[]> getAll() throws Exception;

    Object[] getById(Integer id) throws Exception;

}
