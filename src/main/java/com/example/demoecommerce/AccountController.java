package com.example.demoecommerce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:8090")

public class AccountController {
    @PostMapping("/init_db")
    public void initDB(){

        Account a1 = Account.builder().withName("Ashwini").withEmail("ashwini@gmail.com").withPhone("1234523456").withAddress("Pune").build();
        Account a2 = Account.builder().withName("Aaradhya").withEmail("aaradhya@gmail.com").withPhone("3454676543").withAddress("Sus").build();
        Account a3 = Account.builder().withName("Arhat").withEmail("arhat@gmail.com").withPhone("4565676897").withAddress("Bavdhan").build();
        createNewAccount(a1);
        createNewAccount(a2);
        createNewAccount(a3);
    }

    @Autowired
    AccountService  Accountservice;

    @Autowired
    AccountServiceRestTemplate accountServiceRestTemplate;

    @GetMapping("/Account")
    public List<Account> getallAccountHolders() {
        return Accountservice.getallAccountHolders();}

    @PostMapping("/Account")
    public void createNewAccount(@RequestBody Account a) {
        Accountservice.createNewAccount(a);

    }

    @PutMapping("/Account")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> editAccount(@RequestBody Account a)  {
        try {
            Accountservice.editAccount(a);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account  edited:" + a);
        }catch (Exception ee){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ee.getMessage());
        }
    }

    @DeleteMapping("/Account/{id}")

    public  ResponseEntity<String> deleteAccount(@PathVariable Integer id)  {
        try {
            Accountservice.deleteAccountbyid(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account deleted with id:" + id);
        }catch (Exception ee){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ee.getMessage());
        }

    }
    @GetMapping("/pet/{status}")
    public String getMyPet(@PathVariable String status){
        return accountServiceRestTemplate.getMyPetWithStatus(status);
    }

}
