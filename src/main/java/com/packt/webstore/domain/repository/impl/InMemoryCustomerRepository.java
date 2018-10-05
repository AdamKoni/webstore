package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    public InMemoryCustomerRepository() {
        Customer customerFist = new Customer("C1234", "Jan Kowalski");
        Customer customerSecond = new Customer("C1235", "Michał Nowak");
        Customer customerThird = new Customer("C1236", "Anna Krawczyk");
        customerList.add(customerFist);
        customerList.add(customerSecond);
        customerList.add(customerThird);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerList;
    }
}
