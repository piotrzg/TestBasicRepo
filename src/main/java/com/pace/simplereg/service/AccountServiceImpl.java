package com.pace.simplereg.service;

import com.pace.simplereg.domain.Account;
import com.pace.simplereg.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    MongoTemplate mongoTemplate;

    public Account findByUsername(String username)
    {
        Account acc =  mongoTemplate.findOne(Query.query(Criteria.where("username").is(username)), Account.class);
        System.out.println(acc);
        return acc;
    }
}
