package com.springbootacademy.batch8.pos.service.impl;

import com.springbootacademy.batch8.pos.dto.CustomerDTO;
import com.springbootacademy.batch8.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch8.pos.entity.Customer;
import com.springbootacademy.batch8.pos.repo.CustomerRepo;
import com.springbootacademy.batch8.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {

        Customer customer=new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive()

        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + " Updated Successful normally";
        }else {
            throw new RuntimeException("no data find for that id");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);

            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;

        }else {
            throw new RuntimeException("No customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCustomers){                  //For each loop
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "Deleted Successfully " + customerId;
        }else {
            throw new RuntimeException("No customer Found In That Id");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCustomers){                  //For each loop
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}
