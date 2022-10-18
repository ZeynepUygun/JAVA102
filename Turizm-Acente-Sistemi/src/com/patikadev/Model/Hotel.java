package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Query;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Hotel implements Query {
    private static String address;
    private int id;
    private String name;
    private String country;
    private String city;
    private String e_mail;
    private String phone;
    private String facilitys;
    private int star;


    //Constructor.
    public Hotel(int id, String name, String country, String city, String address, String e_mail, String phone, String facilitys, int star) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.e_mail = e_mail;
        this.phone = phone;
        this.facilitys = facilitys;
        this.star = star;
    }

    public Hotel() {

    }

    //Otelleri listeler.
    public static ArrayList<Hotel> getList() {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        Hotel obj;

        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(hotelListQuery);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                obj = new Hotel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("e_mail"),
                        rs.getString("phone"),
                        rs.getString("facilitys"),
                        rs.getInt("star"));
                hotelList.add(obj);
            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotelList;

    }

    //**************************************************
    //id'ye sahip oteli getirir.
    public static Hotel getFetch(int id) {
        Hotel obj = null;


        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(hotelWhereID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Hotel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("e-mail"),
                        rs.getString("phone"),
                        rs.getString("facilitys"),
                        rs.getInt("star"));

            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    //**************************************************

    //Otel ekler.
    public static Boolean add(String name, String country, String city, String address, String e_mail, String phone,
                              String facilitys, int star) {
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(hotelAdd);
            pr.setString(1, name);
            pr.setString(2, country);
            pr.setString(3, city);
            pr.setString(4, address);
            pr.setString(5, e_mail);
            pr.setString(6, phone);
            pr.setString(7, facilitys);
            pr.setInt(8, star);


            int response = pr.executeUpdate();

            pr.getConnection().close();

            return response != -1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }

    //**************************************************
    //Otel verisi günceller.
    public static boolean update(int id, String name, String country, String city, String address, String e_mail,
                                 String phone,
                                 String facilitys, int star) {
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(hotelUpdate);
            pr.setString(1, name);
            pr.setString(2, country);
            pr.setString(3, city);
            pr.setString(4, address);
            pr.setString(5, e_mail);
            pr.setString(6, phone);
            pr.setString(7, facilitys);
            pr.setInt(8, star);
            pr.setInt(9, id);
            pr.executeUpdate();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    //**************************************************
    //Otel özelliklerinin id'lerini String değişkene atar.
    public static String facility(JCheckBox carPark, JCheckBox wifi, JCheckBox natatorium, JCheckBox fitness,
                                  JCheckBox concierge,
                                  JCheckBox spa, JCheckBox roomService) {
        String facilityAll = "";

        if (carPark.isSelected()) {
            int id = Facility.getFetch(carPark.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (wifi.isSelected()) {
            int id = Facility.getFetch(wifi.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (natatorium.isSelected()) {
            int id = Facility.getFetch(natatorium.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (fitness.isSelected()) {
            int id = Facility.getFetch(fitness.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (concierge.isSelected()) {
            int id = Facility.getFetch(concierge.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (spa.isSelected()) {
            int id = Facility.getFetch(spa.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (roomService.isSelected()) {
            int id = Facility.getFetch(roomService.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        facilityAll = facilityAll.trim();
        return facilityAll;

    }

    //************************************************
    //Arayüzdeki otel verilerini değişkene atar.
    public static boolean dataPanel(JTextField name, JTextField country, JTextField city, JTextField address,
                                    JTextField e_mail,
                                    JTextField phone, JComboBox star) {
        Hotel otel = new Hotel();
        otel.setName(name.getText().trim().toUpperCase());
        otel.setCountry(country.getText().trim().toUpperCase());
        otel.setCity(city.getText().trim().toUpperCase());
        String addressAll = "";
        String[] addressEdit = address.getText().trim().split(" ");
        for (int i = 0; i < addressEdit.length; i++) {

            addressEdit[i] = addressEdit[i].substring(0, 1).toUpperCase() + addressEdit[i].substring(1).toLowerCase() + " ";
            addressAll = addressAll.concat(addressEdit[i]);
        }
        otel.setAddress(addressAll);

        otel.setE_mail(e_mail.getText().trim());
        otel.setPhone(phone.getText().trim());

        otel.setStar(Integer.parseInt(star.getSelectedItem().toString()));
        return true;

    }

    //************************************************
    //Arayüzdeki otel verilerini siler.
    public static boolean dataPanelClear(JTextField name, JTextField country, JTextField city, JTextField address,
                                         JTextField e_mail,
                                         JTextField phone, JComboBox star, JCheckBox carPark, JCheckBox wifi, JCheckBox natatorium, JCheckBox fitness,
                                         JCheckBox concierge,
                                         JCheckBox spa, JCheckBox roomService) {
        name.setText("");
        country.setText("");
        city.setText("");
        address.setText("");
        e_mail.setText("");
        phone.setText("");
        star.setSelectedIndex(0);

        carPark.setSelected(false);
        wifi.setSelected(false);
        natatorium.setSelected(false);
        fitness.setSelected(false);
        concierge.setSelected(false);
        spa.setSelected(false);
        roomService.setSelected(false);
        return true;

    }

    public static String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        Hotel.address = address;
    }

    //************************************************
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFacilitys() {
        return facilitys;
    }

    public void setFacilitys(String facilitys) {
        this.facilitys = facilitys;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
