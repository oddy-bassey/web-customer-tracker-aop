package springdemo.controller;

import springdemo.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import springdemo.service.CustomerService;
 
/**
 *
 * @author Bassey Oddy
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    //injecting the customer DAO into the CustomerController
    @Autowired
    private CustomerService customerService;
    
    //refactor from the @RequestMapping to @GetMapping
    //@RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomers(Model theModel){
        
        //get the customer from the DAO
        List<Customer> customer = customerService.getCustomers();
        
        //pass the cutsomer data into the front view(.jsp page)
        theModel.addAttribute("customers", customer);
        
        return "list-customers";
    }
    
    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        
        //create new model attribute to bind the data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        
        return "customer-form";
    }
    
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("addedCustomer")Customer customer){
        
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId")int id, Model theModel){
        
        //get the customer from the service
        Customer theCustomer = customerService.getCustomer(id);
        
        //set the customer as the model attribute to prepopulate the form
        theModel.addAttribute("customer", theCustomer);
        
        //send over to our form
        return "customer-form";
    }
    
    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId")int id){
        
        //delete customer
        customerService.deleteCustomer(id);
        
        return "redirect:/customer/list";
    }
}
