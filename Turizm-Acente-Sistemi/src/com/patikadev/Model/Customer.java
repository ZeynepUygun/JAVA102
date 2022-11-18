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
    private String uyruk;
    private String pasaport;

    public Customer(int id, String firstName, String lastName, int reservation_id, String uyruk, String
    tc_pasaport) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reservation_id = reservation_id;
        this.uyruk = uyruk;
        this.pasaport = tc_pasaport;

        this.reservation = Reservation.getFetch(reservation_id);
    }
    //Müşterilari listeler.
    public static ArrayList<Customer> getList() {
        ArrayList<Customer> customerList = new ArrayList<>();
        Customer obj;

        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(customerListQuery);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                obj = new Customer(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("reservation_id"),
                        rs.getString("uyruk"),
                        rs.getString("tc_pasaport"));
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
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("reservation_id"),
                        rs.getString("tc_pasaport"),
                        rs.getString("uyruk"));
            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }
    //******************************************************

    public static ArrayList<Customer> getListReservationID(int reservation_id) {
        ArrayList<Customer> customerList = new ArrayList<>();
        Customer obj;
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(customerWhereReservationID);
            pr.setInt(1,reservation_id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                obj = new Customer(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("reservation_id"),
                        rs.getString("uyruk"),
                        rs.getString("tc_pasaport"));
                customerList.add(obj);
            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
    public static Boolean add(String firstName, String lastName, int reservation_id, String uyruk, String tc_pasaport) {
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(customerAdd);
            pr.setString(1, firstName);
            pr.setString(2, lastName);
            pr.setInt(3, reservation_id);
            pr.setString(4, uyruk);
            pr.setString(5, tc_pasaport);




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

    public String getUyruk() {
        return uyruk;
    }

    public void setUyruk(String uyruk) {
        this.uyruk = uyruk;
    }

    public String getPasaport() {
        return pasaport;
    }

    public void setPasaport(String pasaport) {
        this.pasaport = pasaport;
    }
}
