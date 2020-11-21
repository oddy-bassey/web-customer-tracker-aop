/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springdemo.service; 

import java.util.List;
import springdemo.entity.Customer;

/**
 *
 * @author Bassey Oddy
 */
public interface CustomerService {
    
    public List<Customer> getCustomers();
    
    public void saveCustomer(Customer customer);
    
    public Customer getCustomer(int id);
    
    public void deleteCustomer(int id);
}
