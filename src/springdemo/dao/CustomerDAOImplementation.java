package springdemo.dao;

import springdemo.entity.Customer;
import java.util.List; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bassey Oddy
 */

//@Repository tells spring that this class is the data access object
@Repository
public class CustomerDAOImplementation implements CustomerDAO{
    
    
    //injecting the session factory object
    @Autowired
    private SessionFactory sessionFactory;

    //@Transactional automatically enables sprg handles the creation of sessions
    @Override 
    public List<Customer> getCustomers() {
        
        //ToDo
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        //create the query
        Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
        
        //execute the query
        List<Customer> customers = query.getResultList();
        
        //return the result
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        
        currentSession.saveOrUpdate(customer);
    }
    
    @Override
    public Customer getCustomer(int id) {
        
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        //retrieve the object from the database using the provided id
        Customer customer = currentSession.get(Customer.class, id);
        
        return customer;
    }
    
    @Override
    public void deleteCustomer(int id) {
        
        //get the current session
        Session currentSession = sessionFactory.getCurrentSession();
        
        //delete the customer based on the id
        Query deleteQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        deleteQuery.setParameter("customerId", id);
          
        deleteQuery.executeUpdate();
    }
}
