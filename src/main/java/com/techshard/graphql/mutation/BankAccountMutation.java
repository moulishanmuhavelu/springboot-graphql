package com.techshard.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.techshard.graphql.dao.entity.BankAccount;
import com.techshard.graphql.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMutation implements GraphQLMutationResolver {

    @Autowired
    private BankAccountService bankAccountService;

    public BankAccount createBankAccount(final String name, final String address, final String balance, final String dateOfBirth) {
        return this.bankAccountService.createBankAccount(name, address, balance, dateOfBirth);
    }
}
