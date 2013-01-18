package com.pace.simplereg.repository;

import com.pace.simplereg.domain.Account;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Account.class)
public interface AccountRepository {

    List<com.pace.simplereg.domain.Account> findAll();
}
