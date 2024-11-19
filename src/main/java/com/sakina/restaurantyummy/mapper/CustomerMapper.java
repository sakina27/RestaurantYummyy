package com.sakina.restaurantyummy.mapper;

import com.sakina.restaurantyummy.dto.CustomerRequest;
import com.sakina.restaurantyummy.dto.CustomerResponse;
import com.sakina.restaurantyummy.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .addr(request.addr())
                .city(request.city())
                .pinCode(request.pinCode())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
}
