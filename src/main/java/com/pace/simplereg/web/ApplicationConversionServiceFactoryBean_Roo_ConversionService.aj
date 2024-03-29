// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.pace.simplereg.web;

import com.pace.simplereg.domain.Account;
import com.pace.simplereg.repository.AccountRepository;
import com.pace.simplereg.web.ApplicationConversionServiceFactoryBean;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    @Autowired
    AccountRepository ApplicationConversionServiceFactoryBean.accountRepository;
    
    public Converter<Account, String> ApplicationConversionServiceFactoryBean.getAccountToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.pace.simplereg.domain.Account, java.lang.String>() {
            public String convert(Account account) {
                return new StringBuilder().append(account.getUsername()).append(' ').append(account.getPassword()).toString();
            }
        };
    }
    
    public Converter<BigInteger, Account> ApplicationConversionServiceFactoryBean.getIdToAccountConverter() {
        return new org.springframework.core.convert.converter.Converter<java.math.BigInteger, com.pace.simplereg.domain.Account>() {
            public com.pace.simplereg.domain.Account convert(java.math.BigInteger id) {
                return accountRepository.findOne(id);
            }
        };
    }
    
    public Converter<String, Account> ApplicationConversionServiceFactoryBean.getStringToAccountConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.pace.simplereg.domain.Account>() {
            public com.pace.simplereg.domain.Account convert(String id) {
                return getObject().convert(getObject().convert(id, BigInteger.class), Account.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getAccountToStringConverter());
        registry.addConverter(getIdToAccountConverter());
        registry.addConverter(getStringToAccountConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
