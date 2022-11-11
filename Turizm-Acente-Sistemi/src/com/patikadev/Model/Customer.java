package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customer implements Query {
    private int id;
    private String firstName;
    private String lastName;
    private int reservation_id;
    private Reservation reservation;
    private String phone;
    private String e_mail;

    public Customer(int id, String firstName, String lastName, int reservation_id, String phone, String e_mail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reservation_id = reservation_id;
        this.phone = phone;
        this.e_mail = e_mail;

        this.reservation = Reservation.getFetch(reservation_id);
    }
    //Müşterilari listeler.
    public static ArrayList<Customer> getList() {
        ArrayList<Customer> customerList = new ArrayList<>();
        Customer obj = null;
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(customerListQuery);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                obj = new Customer(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("reservation_id"),
                        rs.getString("phone"),
                        rs.getString("e_mail"));
                customerList.add(obj);
            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
    //******************************************************
    //id'ye sahip müşteriyi getirir.
    public static Customer getFetch(int id){
        Customer obj=null;
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(customerWhereID);
            pr.setInt(1,id);
            ResultSet rs =pr.executeQuery();
            if(rs.next()){
                obj = new Customer(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("reservation_id"),
                        rs.getString("phone"),
                        rs.getString("e_mail"));
            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }
    //******************************************************
    public static Boolean add(String firstName, String lastName, int reservation_id, String phone, String e_mail) {
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(customerAdd);
            pr.setString(1, firstName);
            pr.setString(2, lastName);
            pr.setInt(3, reservation_id);
            pr.setString(4, phone);
            pr.setString(5, e_mail);




            int response = pr.executeUpdate();

            pr.getConnection().close();

            return response != -1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
}
