package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Facility implements Query {
    private int id;
    private String feature;

    public Facility(int id, String feature) {
        this.id = id;
        this.feature = feature;
    }
    //Tesis özelliklerini listeler.
    public static ArrayList<Facility> getList() {
        ArrayList<Facility> facilityList = new ArrayList<>();
        Facility obj = null;

        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(facilityListQuery);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                obj = new Facility(rs.getInt("id"),
                        rs.getString("feature"));
                facilityList.add(obj);

            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return facilityList;
    }
    //**************************************************
    //id'ye sahip tesis özelliğni getirir.
    public static Facility getFetch(int id) {
        Facility obj = null;


        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(facilityWhereID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                obj = new Facility(rs.getInt("id"),
                        rs.getString("feature"));

            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;

    }
    //**************************************************
    //özelliğin id'sini getirir.
    public static Facility getFetch(String facility) {
        Facility obj = null;


        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(facilityWhereFeature);
            pr.setString(1, facility);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                obj = new Facility(rs.getInt("id"),
                        rs.getString("feature"));

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

    public String getFeature() {
        return feature;
    }


}
