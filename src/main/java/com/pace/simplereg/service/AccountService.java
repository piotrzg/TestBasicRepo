package com.pace.simplereg.service;

import com.pace.simplereg.domain.Account;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.pace.simplereg.domain.Account.class })
public interface AccountService {

    public Account findByUsername(String username);
}
