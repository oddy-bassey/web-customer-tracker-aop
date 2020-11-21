/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springdemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springdemo.dao.CustomerDAO;
import springdemo.entity.Customer;

/**
 *
 * @author Bassey Oddy
 */
@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;
    
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }
    
    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }
    
    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }
}
