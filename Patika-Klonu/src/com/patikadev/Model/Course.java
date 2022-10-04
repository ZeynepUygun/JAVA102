package com.patikadev.Model;

import com.patikadev.Helper.DbConnecter;
import com.patikadev.Helper.Helper;


import java.sql.*;
import java.util.ArrayList;

public class Course {
    private int id;
    private int user_id;
    private int patika_id;
    private String name;
    private String lang;

    private Patika patika;

    private User user;


    public Course(int id, int user_id, int patika_id, String name, String lang) {
        this.id = id;
        this.user_id = user_id;
        this.patika_id = patika_id;
        this.name = name;
        this.lang = lang;
        this.patika = Patika.getFetch(patika_id);

        this.user=User.getFetch(user_id);
    }

    public Course() {

    }

    public static ArrayList<Course> getList() {
        ArrayList<Course> courseList = new ArrayList<>();
        Course obj;

        try {
            Statement st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM course ORDER BY patika_id ");
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int patika_id = rs.getInt("patika_id");
                String name = rs.getString("name");
                String lang = rs.getString("lang");

                obj = new Course(id, user_id, patika_id, name, lang);
                courseList.add(obj);


            }



            rs.close();
            st.getConnection().close();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseList;

    }



    public static ArrayList<Course> getList(int user_id, int patika_id) {
        ArrayList<Course> courseList = new ArrayList<>();
        Course obj;

        try {
            Statement st = DbConnecter.getInstance().createStatement();
            ResultSet rs =
                    st.executeQuery("SELECT * FROM course WHERE user_id = " + user_id + " AND patika_id = " + patika_id);
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_Id = rs.getInt("user_id");
                int patika_Id = rs.getInt("patika_id");
                String name = rs.getString("name");
                String lang = rs.getString("lang");

                obj = new Course(id, user_Id, patika_Id, name, lang);
                courseList.add(obj);


            }
            rs.close();
            st.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseList;

    }


    public static boolean add(int user_id, int patika_id, String name, String lang) {
        String query = "INSERT INTO course (user_id,patika_id,name,lang) VALUES (?,?,?,?)";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, user_id);
            pr.setInt(2, patika_id);
            pr.setString(3, name);
            pr.setString(4, lang);

            pr.getConnection().close();

            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }

    public static ArrayList<Course> getListByUser(int user_id) {
        ArrayList<Course> courseList = new ArrayList<>();
        Course obj;

        try {
            Statement st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM course WHERE user_id = " + user_id);
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_ID = rs.getInt("user_id");
                int patika_id = rs.getInt("patika_id");
                String name = rs.getString("name");
                String lang = rs.getString("lang");

                obj = new Course(id, user_ID, patika_id, name, lang);
                courseList.add(obj);


            }
            rs.close();
            st.getConnection().close();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseList;

    }

    public static ArrayList<Course> searchQueryList(String courseName, int user_id) {
        ArrayList<Course> courseList = new ArrayList<>();
        String query =
                "SELECT * FROM course WHERE user_id =" + user_id+" AND name ILIKE '%{{name}}%'";
        query = query.replace("{{name}}", courseName);

        Course obj;
        try {
            Statement st = DbConnecter.getInstance().createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Course();
                obj.setId(rs.getInt("id"));
                obj.setPatika(Patika.getFetch(rs.getInt("patika_id")));
                obj.setName(rs.getString("name"));

                courseList.add(obj);
            }
            st.getConnection().close();
            rs.close();


        } catch (SQLException e) {


        }
        return courseList;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM course WHERE id = ?";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            pr.executeUpdate();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public static Course getFetch(int id) {

        Course obj = null;
        String query = "SELECT * FROM course WHERE id = ?";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Course(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("patika_id"),
                        rs.getString("name"),
                        rs.getString("lang"));


            }
            rs.close();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;

    }

    public static Course getFetch(int id, int user_id) {

        Course obj = null;
        String query = "SELECT * FROM course WHERE id = ? AND user_id = ?";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            pr.setInt(2, user_id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Course(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("patika_id"),
                        rs.getString("name"),
                        rs.getString("lang"));


            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;

    }

    public static Course getFetch(String course_name) {
        Course obj = null;
        String query = "SELECT * FROM course WHERE name ILIKE '%{{name}}%'";
        query = query.replace("{{name}}", course_name);

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);

            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Course();
                obj.setId(rs.getInt("id"));
                obj.setUser_id(rs.getInt("user_id"));
                obj.setPatika_id(rs.getInt("patika_id"));
                obj.setName(rs.getString("name"));
                obj.setLang(rs.getString("lang"));




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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPatika_id() {
        return patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
