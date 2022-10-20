package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Hostel implements Query {
    private int id;
    private String type;

    public Hostel(int id, String type) {
        this.id = id;
        this.type = type;
    }

    //pansiyon tiplerini listeler.
    public static ArrayList<Hostel> getList() {
        ArrayList<Hostel> hostelList = new ArrayList<>();
        Hostel obj;

        try {
            Statement st = DBConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery(hostelListQuery);

            while (rs.next()) {

                int id = rs.getInt("id");
                String type = rs.getString("type");

                obj = new Hostel(id, type);
                hostelList.add(obj);
            }
            //SQL sorgusunu kapatılır.
            rs.close();
            st.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hostelList;
    }

    //**************************************************
    //id'ye sahip pansiyon tipini getirir.
    public static Hostel getFetch(int id) {
        Hostel obj = null;


        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(hostelWhereID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Hostel(rs.getInt("id"), rs.getString("type"));
            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    //**************************************************
    //Pansiyon tipine sahip id'yi getirir.
    public static Hostel getFetch(String type) {
        Hostel obj = null;


        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(hostelWhereType);
            pr.setString(1, type);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Hostel(rs.getInt("id"), rs.getString("type"));
            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    //**************************************************
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
