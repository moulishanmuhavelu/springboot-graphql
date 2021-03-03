package com.techshard.graphql.mutation;

import com.techshard.graphql.dao.entity.BankAccount;
import com.techshard.graphql.service.BankAccountService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

@Component
@Validated
public class BankAccountMutation implements GraphQLMutationResolver {

    @Autowired
    private BankAccountService bankAccountService;

    public BankAccount createBankAccount(@Valid final String name, final String address, final String balance, final String dateOfBirth) {
        return this.bankAccountService.createBankAccount(name, address, balance, dateOfBirth);
    }
}
