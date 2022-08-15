package com.patikadev.Model;

import com.patikadev.Helper.DbConnecter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Lesson {
    private int id;
    private int patika_id;
    private int course_id;
    private String contents;
    private String explanation;
    private String link;
    private String quiz_name_id;
    private Course course;
    private Patika patika;

    public Lesson(int id, int patika_id, int course_id, String contents, String explanation, String link, String quiz_name_id) {

        this.id = id;
        this.patika_id = patika_id;
        this.course_id=course_id;
        this.contents = contents;
        this.explanation = explanation;
        this.link = link;
        this.quiz_name_id = quiz_name_id;

        this.course = Course.getFetch(course_id);
        this.patika=Patika.getFetch(patika_id);
    }
    public static ArrayList<Lesson> getList(){
        ArrayList<Lesson>  lessonList =new ArrayList<>();
        Lesson obj;

        Statement st = null;
        try {
            st = DbConnecter.getInstance().createStatement();
            ResultSet rs =st.executeQuery("SELECT * FROM lesson ");

            while (rs.next()){
                int id =rs.getInt("id");
                int patika_id=rs.getInt("patika_id");
                int course_id=rs.getInt("course_id");
                String contents=rs.getString("contents");
                String explanation =rs.getString("explanation");
                String link=rs.getString("link");
                String quiz_name_id=rs.getString("quiz_name_id");

                obj =new Lesson(id,patika_id,course_id,contents,explanation,link,quiz_name_id);
                lessonList.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lessonList;
    }
    public static Lesson getFetch(int course_id){
        Lesson obj =null;
        String query = "Select * From lesson WHERE course_id = ? ";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1,course_id);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                obj=new Lesson(rs.getInt("id"),
                        rs.getInt("patika_id"),
                        rs.getInt("course_id"),
                        rs.getString("contents"),
                        rs.getString("explanation"),
                        rs.getString("link"),
                        rs.getString("quiz_name_id"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatika_id() {
        return patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }
}
