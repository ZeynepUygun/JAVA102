package com.patikadev.Model;

import com.patikadev.Helper.DbConnecter;

import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Educator {


    private int patika_id;

    private String educations_name;

    public Educator( int patika_id, String educations_name) {

        this.educations_name = educations_name;
        this.patika_id = patika_id;


    }

    public Educator() {

    }
    public static Educator getFetch(int id) {

        Educator obj = null;
        String query = "SELECT * FROM course WHERE id = ?";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if(rs.next()) {
                obj = new Educator(rs.getInt("patika_id"),rs.getString("name") );



            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;

    }


    public static ArrayList<Educator> getList(int id) {
        ArrayList<Educator> educatorList = new ArrayList<>();
        Educator obj;

        try {
            Statement st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM course where user_id = "+id);
            while (rs.next()) {


                int patika_id = rs.getInt("patika_id");
                String name = rs.getString("name");
                obj = new Educator( patika_id, name);
                educatorList.add(obj);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educatorList;

    }
    public static String searchQuery(String name,int user_id){
        String query ="SELECT * FROM course WHERE name LIKE '%{{name}}%' AND id="+user_id;

        query=query.replace("{{name}}",name);



        return query;
    }
    public static ArrayList<Educator> searchUserList(String query) {
        ArrayList<Educator> educatorList = new ArrayList<>();

        Educator obj;
        try {
            Statement st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Educator();
                obj.setPatika_id(rs.getInt("patika_id"));

                obj.setEducations_name(rs.getString("uname"));

                educatorList.add(obj);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
        return educatorList;
    }




    public int getPatika_id() {
        return patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
    }



    public String getEducations_name() {
        return educations_name;
    }

    public void setEducations_name(String educations_name) {
        this.educations_name = educations_name;
    }
}
