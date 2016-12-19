package com.jjx.daos.iDaos;

import com.jjx.beans.Customer;

/**
 * Created by TandTV on 2016/12/19.
 */
public interface ICustomerDao {

    public Boolean validateCustomer(String first_name);

    public Customer findCustermerByFName(String first_name);
}
