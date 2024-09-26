package com.nisac.orders.service;


import com.nisac.orders.model.Customers;
import com.nisac.orders.model.Orders;
import com.nisac.orders.repos.CustomersRepo;
import com.nisac.orders.repos.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;


@Transactional
@Service(value = "customerService")
public class CustomersServiceImpl implements CustomersService
{
    @Autowired
    private CustomersRepo restCustomerRepo;
    private OrdersRepo restOrderRepo;

    @Override
    public ArrayList<Customers> findAll()
    {
        ArrayList<Customers> list = new ArrayList<>();
        restCustomerRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomersByName(String name) throws EntityNotFoundException
    {
        Customers customer = restCustomerRepo.findByCustName(name);

        if(customer == null)
        {
            throw new EntityNotFoundException("Customer " + name + " not found.");
        }
        return customer;
    }

    @Override
    public void delete(long custCode) throws EntityNotFoundException
    {

        if (restCustomerRepo.findById(custCode).isPresent())
        {
            restCustomerRepo.deleteById(custCode);
        } else
        {
            throw new EntityNotFoundException(Long.toString(custCode));
        }
    }

    @Transactional
    @Override
    public Customers save(Customers customer)
    {
        Customers newCustomer = new Customers();

        newCustomer.setCustName(customer.getCustName());
        newCustomer.setCustCity(customer.getCustCity());
        newCustomer.setCustCountry(customer.getCustCountry());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setWorkingArea(customer.getWorkingArea());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningAmt(customer.getOpeningAmt());
        newCustomer.setOutstandingAmt(customer.getOutstandingAmt());
        newCustomer.setReceiveAmt(customer.getReceiveAmt());
        newCustomer.setPaymentAmt(customer.getPaymentAmt());

        return restCustomerRepo.save(newCustomer);
    }

    @Transactional
    @Override
    public Customers update(Customers customer, long custCode)
    {
       Customers currentCustomer = restCustomerRepo.findById(custCode).orElseThrow(()
               -> new EntityNotFoundException((Long.toString(custCode))));
       if(customer.getOrders().size() > 0)
       {
           for ( Orders o : customer.getOrders())
           {
               currentCustomer.getOrders().add(new Orders(o.getOrdAmount(),
                       o.getAdvanceAmount(),
                       o.getCustomer(),
                       o.getOrdDescription()));
           }
       }
        if(customer.getCustCity() != null)
        {
            currentCustomer.setCustCity(customer.getCustCity());
        }
        if(customer.getCustCountry() != null)
        {
            currentCustomer.setCustCountry(customer.getCustCountry());
        }

        if(customer.getCustName() != null)
        {
            currentCustomer.setCustName(customer.getCustName());
        }

        if(customer.getWorkingArea() != null)
        {
            currentCustomer.setWorkingArea(customer.getWorkingArea());
        }

        if(customer.getGrade() != null)
        {
            currentCustomer.setGrade(customer.getGrade());
        }

        if(customer.getOpeningAmt() != currentCustomer.getOpeningAmt())
        {
            currentCustomer.setOpeningAmt(customer.getOpeningAmt());
        }
        if(customer.getReceiveAmt() != currentCustomer.getReceiveAmt())
        {
            currentCustomer.setReceiveAmt(customer.getReceiveAmt());
        }

        if(customer.getPaymentAmt() != currentCustomer.getPaymentAmt())
        {
            currentCustomer.setPaymentAmt(customer.getPaymentAmt());
        }

        if(customer.getOutstandingAmt() != currentCustomer.getOutstandingAmt())
        {
            currentCustomer.setOutstandingAmt(customer.getOutstandingAmt());
        }

        if(customer.getPhone() != null)
        {
            currentCustomer.setPhone(customer.getPhone());
        }
        return restCustomerRepo.save(currentCustomer);
    }
}
