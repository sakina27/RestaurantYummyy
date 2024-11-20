package com.sakina.restaurantyummy.mapper;

import com.sakina.restaurantyummy.dto.CustomerRequest;
import com.sakina.restaurantyummy.dto.CustomerResponse;
import com.sakina.restaurantyummy.entity.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest.CustomerCreateRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .addr(request.addr())
                .city(request.city())
                .updatedOn(LocalDateTime.now())
                .pinCode(request.pinCode())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
}
