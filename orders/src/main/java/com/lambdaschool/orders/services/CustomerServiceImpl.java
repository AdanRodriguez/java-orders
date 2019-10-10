package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepo customerRepos;

    @Override
    public List<Customer> findAll()
    {
        List<Customer> rtnList = new ArrayList<>();
        customerRepos.findAll()
                     .iterator()
                     .forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    public Customer findById(long id)
    {
        return null;
    }

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        Customer newCustomer = new Customer();

        newCustomer.setCustomerName(customer.getCustomerName());
        newCustomer.setCustomerCity(customer.getCustomerCity());
        newCustomer.setWorkingArea(customer.getWorkingArea());
        newCustomer.setCustomerCountry(customer.getCustomerCountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningAtm(customer.getOpeningAtm());
        newCustomer.setReceiveAtm(customer.getReceiveAtm());
        newCustomer.setPaymentAtm(customer.getPaymentAtm());
        newCustomer.setOutstandingAtm(customer.getOutstandingAtm());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setAgent(customer.getAgent());

        for (Order o : customer.getOrders())
        {
            newCustomer.getOrders().add(new Order(o.getOrderAmount(), o.getAdvanceAmount(), newCustomer, o.getOrderDescription()));
        }

        return customerRepos.save(newCustomer);
    }

    @Override
    public Customer update(Customer customer, long id)
    {
        return customerRepos.save(customer);
    }

    @Override
    public void delete(long id)
    {
        customerRepos.deleteById(id);
    }
}
