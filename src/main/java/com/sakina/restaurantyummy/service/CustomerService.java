package com.sakina.restaurantyummy.service;

import com.sakina.restaurantyummy.dto.CustomerRequest;
import com.sakina.restaurantyummy.dto.CustomerResponse;
import com.sakina.restaurantyummy.dto.LoginRequest;
import com.sakina.restaurantyummy.entity.Customer;
import com.sakina.restaurantyummy.exception.CustomerNotFoundException;
import com.sakina.restaurantyummy.helper.EncryptionService;
import com.sakina.restaurantyummy.mapper.CustomerMapper;
import com.sakina.restaurantyummy.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final EncryptionService encryptionService;
    //private final JWTHelper jwtHelper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer Created Successfully";
    }

    public Customer getCustomer(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }

    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return customerMapper.toCustomerResponse(customer);
    }

    public String login(LoginRequest request) {
        Customer customer = getCustomer(request.email());
        if(!encryptionService.validates(request.password(), customer.getPassword())) {
            return "Wrong Password or Email";
        }

        //return jwtHelper.generateToken(request.email());
        return "Login Successful";
    }
}