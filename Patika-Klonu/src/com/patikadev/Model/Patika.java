package com.patikadev.Model;

import com.patikadev.Helper.DbConnecter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {
    private int id;
    private String name;

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Patika() {

    }

    public static ArrayList<Patika> getList() {
        ArrayList<Patika> patikaList = new ArrayList<>();
        Patika obj;

        try {
            Statement st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patika");
            while (rs.next()) {
                obj = new Patika(rs.getInt("id"), rs.getString("name"));

                patikaList.add(obj);

            }
            rs.close();
            st.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return patikaList;

    }

    public static boolean add(String name) {
        String query = "INSERT INTO patika (name) VALUES (?)";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setString(1, name);

            pr.getConnection().close();
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }

    public static boolean update(int id, String name) {
        String query = "UPDATE patika SET name = ? WHERE id = ?";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setInt(2, id);

            pr.getConnection().close();
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }


    public static Patika getFetch(int id) {

        Patika obj = null;
        String query = "SELECT * FROM patika WHERE id = ?";

        try {

            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Patika(rs.getInt("id"), rs.getString("name"));


            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return obj;

    }

    public static Patika getFetch(String patika_name) {
        Patika obj = null;
        String query = "SELECT * FROM patika WHERE name ILIKE '%{{name}}%'";
        query = query.replace("{{name}}", patika_name);

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);

            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Patika();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));


            }

            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM patika WHERE id = ?";
        ArrayList<Course> courseList = Course.getList();
        for (Course obj : courseList) {
            if (obj.getPatika().getId() == id) {
                Course.delete(obj.getId());
            }
        }
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, id);

            pr.getConnection().close();
            return pr.executeUpdate() != -1;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
