package com.example.demoecommerce;
//import demoecommerce.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AccountServiceRestTemplate {
    RestTemplate restTemplate;

    @Autowired
    public AccountServiceRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public  String getMyPetWithStatus(String status) {
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity("/v2/pet/findByStatus?status="+status,Object.class);
        return String.valueOf(responseEntity.getBody());
    }

}
