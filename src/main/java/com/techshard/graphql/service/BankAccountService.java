package com.techshard.graphql.service;

import com.techshard.graphql.dao.entity.BankAccount;
import com.techshard.graphql.dao.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(final BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Transactional
    public BankAccount createBankAccount(final String name, final String address, final String balance, final String dateOfBirth) {
        final BankAccount bankAccount = new BankAccount();
        bankAccount.setName(name);
        bankAccount.setAddress(address);
        bankAccount.setBalance(Long.valueOf(balance));
        bankAccount.setDateOfBirth(LocalDate.parse(dateOfBirth));
        return this.bankAccountRepository.save(bankAccount);
    }

    @Transactional(readOnly = true)
    public List<BankAccount> getAllBankAccounts(final int count) {
        return this.bankAccountRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<BankAccount> getBankAccount(final int id) {
        return this.bankAccountRepository.findById(id);
    }
}
