package com.springbootacademy.batch8.pos.service;

import com.springbootacademy.batch8.pos.dto.CustomerDTO;
import com.springbootacademy.batch8.pos.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);
}
