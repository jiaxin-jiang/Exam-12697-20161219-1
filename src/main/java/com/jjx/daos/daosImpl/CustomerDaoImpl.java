package com.jjx.daos.daosImpl;

import com.jjx.beans.Customer;
import com.jjx.daos.iDaos.ICustomerDao;
import com.jjx.db.DbcpConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TandTV on 2016/12/19.
 */
public class CustomerDaoImpl implements ICustomerDao {

    public Boolean validateCustomer(String first_name) {

        boolean bool = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DbcpConnection.getConnection();
            String sql = "select * from customer WHERE first_name = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, first_name);
            rs = pst.executeQuery();
            while (rs.next()) {
                bool = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bool;
    }

    public Customer findCustermerByFName(String first_name) {

        Customer customer = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DbcpConnection.getConnection();
            String sql = "select * from customer WHERE first_name = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, first_name);
            rs = pst.executeQuery();

            while (rs.next()) {
                customer = new Customer();
                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setStore_id(rs.getString("store_id"));
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress_id(rs.getString("address_id"));
                customer.setActive(rs.getString("active"));
                customer.setCreate_date(rs.getDate("create_date"));
                customer.setLast_update(rs.getDate("last_update"));
                System.out.println(customer.toString());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return customer;
    }
}
