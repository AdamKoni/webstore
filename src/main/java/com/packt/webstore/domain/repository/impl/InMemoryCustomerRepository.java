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
        customerFist.setAddress("Pod mostem");
        customerFist.setNoOfOrdersMade(0);
        Customer customerSecond = new Customer("C1235", "Michał Nowak");
        customerSecond.setAddress("Na ulicy");
        customerSecond.setNoOfOrdersMade(1);
        Customer customerThird = new Customer("C1236", "Anna Krawczyk");
        customerThird.setAddress("Pod budką z piwem");
        customerThird.setNoOfOrdersMade(2);
        customerList.add(customerFist);
        customerList.add(customerSecond);
        customerList.add(customerThird);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerList;
    }
}
