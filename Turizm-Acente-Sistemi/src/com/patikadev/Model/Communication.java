package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;

public class Communication implements Query {
private int id;
private String name_surname;
private String e_mail;
private String phone;
private String note;

    public Communication(int id, String name_surname, String e_mail, String phone, String note) {
        this.id = id;
        this.name_surname = name_surname;
        this.e_mail = e_mail;
        this.phone = phone;
        this.note = note;
    }
    public static Boolean add(String name_surname, String e_mail, String phone, String note) {
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(communicationAdd);
            pr.setString(1, name_surname);
            pr.setString(2, e_mail);
            pr.setString(3, phone);
            pr.setString(4, note);





            int response = pr.executeUpdate();

            pr.getConnection().close();

            return response != -1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }
    public static Communication getFetch(String name_surname, String e_mail, String phone, String note){
        Communication obj=null;
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(communicationWhere);
            pr.setString(1,name_surname);
            pr.setString(2,e_mail);
            pr.setString(3,phone);
            pr.setString(4,note);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj=new Communication(rs.getInt("id"),
                        rs.getString("name_surname"),
                        rs.getString("e_mail"),
                        rs.getString("phone"),
                        rs.getString("note"));
            }
            rs.close();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }
    public static Communication getFetchID(int id){
        Communication obj=null;
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(communicationWhereID);
            pr.setInt(1,id);

            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj=new Communication(rs.getInt("id"),
                        rs.getString("name_surname"),
                        rs.getString("e_mail"),
                        rs.getString("phone"),
                        rs.getString("note"));
            }
            rs.close();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_surname() {
        return name_surname;
    }

    public void setName_surname(String name_surname) {
        this.name_surname = name_surname;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
