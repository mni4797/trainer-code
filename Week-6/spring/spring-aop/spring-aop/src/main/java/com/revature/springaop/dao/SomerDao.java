package com.revature.springaop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class SomerDao {

    public String getSomething() {
        return "something";
    }

}
