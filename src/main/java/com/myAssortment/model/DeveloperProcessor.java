package com.myAssortment.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeveloperProcessor {
    public DeveloperProcessor() {}
    public DeveloperDao developerDao;

    @Autowired
    public DeveloperProcessor (DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    public List<Developer> findAll() throws Exception {
        return developerDao.findAll();
    }

    public Developer findById(long id) throws Exception {
        return developerDao.findById(id);
    }

    public Developer create(Developer developer) throws Exception {
        return developerDao.create(developer);
    }

    public Developer update(Developer developer) throws Exception {
        return developerDao.update(developer);
    }
    public void delete(long id) throws Exception {
        developerDao.delete(id);
    }


}
