package com.patikadev.Model;

import com.patikadev.Helper.DbConnecter;
import com.patikadev.View.EducatorGUI;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Educator {

    private int id;
    private int patika_id;
    private int course_id;
    private String contents;
    private String explanation;
    private String link;
    private String quiz_name_id;
    private Patika patika;
    private Course course;
    private int user_id;

    public Educator(int id, int patika_id, int course_id, String contents, String explanation, String link, String quiz_name_id) {
        this.id = id;
        this.patika_id = patika_id;
        this.course_id = course_id;
        this.contents = contents;
        this.explanation = explanation;
        this.link = link;
        this.quiz_name_id = quiz_name_id;
        this.patika = Patika.getFetch(patika_id);
        this.course = Course.getFetch(course_id);

    }

    public Educator() {

    }

    public static Educator getFetch(int id) {

        Educator obj = null;
        String query = "SELECT * FROM lesson WHERE id = ?";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Educator(
                        rs.getInt("id"),
                        rs.getInt("patika_id"),
                        rs.getInt("course_id"),
                        rs.getString("contents"),
                        rs.getString("explanation"),
                        rs.getString("link"),
                        rs.getString("quiz_name_id")

                );


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
            ResultSet rs = st.executeQuery("SELECT * FROM lesson where user_id = " + id);
            while (rs.next()) {

                int course_id = rs.getInt("course_id");
                int ID = rs.getInt("id");
                int patika_id = rs.getInt("patika_id");


                String contents = rs.getString("contents");
                String explanation = rs.getString("explanation");
                String link = rs.getString("link");
                String quiz_name_id = rs.getString("quiz_name_id");

                obj = new Educator(ID, patika_id, course_id, contents, explanation, link, quiz_name_id);
                educatorList.add(obj);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educatorList;

    }

    public static String searchQuery(String courseName, int user_id, String patika_name) {


        String query =
                "SELECT * FROM lesson WHERE user_id =" + user_id;


        System.out.println(query);
        if (!patika_name.isEmpty()) {
            int patika = getFetchPatikaID(patika_name).getId();
            System.out.println(patika + " patika_id");
            query += " AND patika_id =" + patika;
            System.out.println(query);
        }
        if (!courseName.isEmpty()) {
            int course=getFetchCourseID(courseName).getId();
            query += " AND course_id ="+course;

            System.out.println(query);
        }


        return query;
    }

    public static Patika getFetchPatikaID(String patika_name) {
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }
    public static Course getFetchCourseID(String course_name) {
        Course obj = null;
        String query = "SELECT * FROM course WHERE name ILIKE '%{{name}}%'";
        query = query.replace("{{name}}", course_name);

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);

            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Course();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setPatika_id(rs.getInt("patika_id"));
                obj.setUser_id(rs.getInt("user_id"));



            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }



    public static ArrayList<Educator> searchUserList(String query) {
        ArrayList<Educator> educatorList = new ArrayList<>();

        Educator obj;
        try {
            Statement st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Educator();


                obj.setId(rs.getInt("id"));

                obj.setPatika(Patika.getFetch(rs.getInt("patika_id")));
                obj.setCourse(Course.getFetch(rs.getInt("course_id")));




                educatorList.add(obj);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return educatorList;
    }

    public static Educator getFetchCourse(int course_id) {
        Educator obj = null;
        String query = "SELECT * FROM lesson WHERE course_id = ?";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, course_id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Educator(rs.getInt("id"),
                        rs.getInt("patika_id"),
                        rs.getInt("course_id"),
                        rs.getString("contents"),
                        rs.getString("explanation"),
                        rs.getString("link"),
                        rs.getString("quiz_name_id"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return obj;
    }


    public int getPatika_id() {
        return patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getQuiz_name_id() {
        return quiz_name_id;
    }

    public void setQuiz_name_id(String quiz_name_id) {
        this.quiz_name_id = quiz_name_id;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
