package com.patikadev.Model;

import com.patikadev.Helper.DbConnecter;
import com.patikadev.Helper.Helper;
import com.patikadev.View.StudentGUI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Student {
    private int user_id;
    private int id;
    private int course_id;
    private int point;
    private String state;
    private int lesson_id;


    private Educator educator;


    public Student(int id, int user_id, int course_id, int point, String state, int lesson_id) {
        this.id = id;
        this.user_id = user_id;
        this.course_id = course_id;
        this.point = point;
        this.state = state;
        this.lesson_id = lesson_id;

        this.educator = Educator.getFetchAll(lesson_id);

    }

    public static ArrayList<Student> getList(int user_id) {
        ArrayList<Student> studentList = new ArrayList<>();
        String query = "SELECT * FROM student WHERE user_id=" + user_id;
        Student obj;
        try {
            Statement st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Student(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("course_id"),
                        rs.getInt("point"),
                        rs.getString("state"),
                        rs.getInt("lesson_id")


                );

                studentList.add(obj);
            }
            rs.close();
            st.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    public static boolean addContents(int user_id, int course_id, int lesson_id) {
        String query = "INSERT INTO student(user_id,course_id,point,state,lesson_id) VALUES " +
                "(?,?,?,?,?)";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, user_id);
            pr.setInt(2, course_id);
            pr.setInt(3, -1);
            pr.setString(4, "");
            pr.setInt(5, lesson_id);


            int response = pr.executeUpdate();
            if (response == -1) {
                Helper.showMsg("error");
            }

            pr.getConnection().close();
            return response != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;

    }

    public static boolean delete(int id) {
        String query = "DELETE FROM student WHERE course_id = ?";
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

    public static boolean update(int id, int user_id, int course_id, int point, String state, int lesson_id) {
        String query = "UPDATE student SET user_id=?, course_id=?,point=?,state=?,lesson_id=? " +
                "WHERE id = ?";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, user_id);
            pr.setInt(2, course_id);
            pr.setInt(3, point);
            pr.setString(4, state);
            pr.setInt(5, lesson_id);
            pr.setInt(6, id);
            pr.executeUpdate();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }

    public static Student getFetchCourse(int course_id, int user_id) {

        Student obj = null;
        String query = "SELECT * FROM student WHERE course_id = ? AND user_id = ?";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, course_id);
            pr.setInt(2, user_id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Student(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("course_id"),
                        rs.getInt("point"),
                        rs.getString("state"),
                        rs.getInt("lesson_id")
                );


            }
            rs.close();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;

    }

    public static Student getFetchLesson(int lesson_id, int user_id) {

        Student obj = null;
        String query = "SELECT * FROM student WHERE lesson_id = ? AND user_id = ?";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, lesson_id);
            pr.setInt(2, user_id);

            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Student(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("course_id"),
                        rs.getInt("point"),
                        rs.getString("state"),
                        rs.getInt("lesson_id")
                );


            }
            rs.close();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public Educator getEducator() {
        return educator;
    }

    public void setEducator(Educator educator) {
        this.educator = educator;
    }


}
