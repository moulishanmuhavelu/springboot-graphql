package com.techshard.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.techshard.graphql.dao.entity.BankAccount;
import com.techshard.graphql.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BankAccountQuery implements GraphQLQueryResolver {

    @Autowired
    private BankAccountService bankAccountService;

    public List<BankAccount> getBankAccounts(final int count) {
        return this.bankAccountService.getAllBankAccounts(count);
    }

    public Optional<BankAccount> getBankAccount(final int id) {
        return this.bankAccountService.getBankAccount(id);
    }
}
