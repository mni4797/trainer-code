package com.revature.springaop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.springaop.dao.SomerDao;

@Service
public class SomerService {
    @Autowired
    private SomerDao dao;

    public String getSomething() {
        return dao.getSomething();
    }
}
