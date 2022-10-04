package com.patikadev.Model;

import com.patikadev.Helper.DbConnecter;
import com.patikadev.Helper.Helper;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Comment {
    private int id;
    private int user_id;
    private int lesson_id;
    private String comment;
    private User user;
    private Educator educator;

    public Comment(int id, int user_id, int lesson_id,String comment) {
        this.id = id;
        this.user_id = user_id;
        this.lesson_id = lesson_id;
        this.comment=comment;

        this.user = User.getFetch(user_id);
        this.educator = Educator.getFetchAll(lesson_id);

    }

    public static ArrayList<Comment> getList(int lesson_id) {
        ArrayList<Comment> commentList = new ArrayList<>();
        String query = "SELECT * FROM comment WHERE lesson_id=" + lesson_id;
        Comment obj;
        try {
            Statement st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Comment(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("lesson_id"),
                        rs.getString("comment")

                );

                commentList.add(obj);
            }
            rs.close();
            st.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return commentList;
    }

    public static boolean addContents(int user_id, int lesson_id,String comment) {
        String query = "INSERT INTO comment(user_id,lesson_id,comment) VALUES " +
                "(?,?,?)";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, user_id);
            pr.setInt(2, lesson_id);
            pr.setString(3, comment);


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

    public static Comment getFetch(int lesson_id) {

        Comment obj = null;
        String query = "SELECT * FROM comment WHERE lesson_id = ? ";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, lesson_id);

            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Comment(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("lesson_id"),
                        rs.getString("comment")
                );


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

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Educator getEducator() {
        return educator;
    }

    public void setEducator(Educator educator) {
        this.educator = educator;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
