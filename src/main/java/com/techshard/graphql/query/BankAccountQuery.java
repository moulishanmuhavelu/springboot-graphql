package com.techshard.graphql.query;

import com.techshard.graphql.dao.entity.BankAccount;
import com.techshard.graphql.exception.CustomRuntimeException;
import com.techshard.graphql.service.BankAccountService;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BankAccountQuery implements GraphQLQueryResolver {

    @Autowired
    private BankAccountService bankAccountService;

    public List<BankAccount> getBankAccounts(final int count) {
        if (count > 10 && count < 50) {
            throw new GraphQLException("My custom backend query exception");
        } else if (count > 50) {
            throw new CustomRuntimeException("Our backend DB is down. Please try again after some time");
        }

        return this.bankAccountService.getAllBankAccounts(count);
    }

    public Optional<BankAccount> getBankAccount(final int id) {
        return this.bankAccountService.getBankAccount(id);
    }
}
