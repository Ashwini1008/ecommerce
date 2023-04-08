package com.example.demoecommerce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service

public class AccountService {
    AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository employeeRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createNewAccount(Account account){
        return accountRepository.save(account);
    }


    public List<Account> getallAccountHolders() {

            return   accountRepository.findAll();

    }

    public void editAccount(Account a) throws Exception{

            if (accountRepository.existsById(a.getId())) {
                accountRepository.save(a);
            }
            else
            {
                throw new Exception("Account does not exist:cannot edit");
            }


    }

    public void deleteAccountbyid(Integer id) throws Exception {

        if (accountRepository.existsById(id)) {
                accountRepository.deleteById(id);
            }
            else
            {
                throw new Exception("Account does not exist:cannot Delete");
            }

        }
}
