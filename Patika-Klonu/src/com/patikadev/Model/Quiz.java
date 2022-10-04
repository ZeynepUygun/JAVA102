package com.patikadev.Model;

import com.patikadev.Helper.DbConnecter;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Quiz {
    private int id;
    private String name;
    private String question;
    private String check_A;
    private String check_B;
    private String check_C;
    private String check_D;
    private String answer;
    private int lesson_id;
    private Educator educator;
    private int user_id=3;

    public Quiz(int id, String name, String question, String check_A, String check_B, String check_C, String check_D,
                String answer, int lesson_id) {
        this.id = id;
        this.name = name;
        this.question = question;
        this.check_A = check_A;
        this.check_B = check_B;
        this.check_C = check_C;
        this.check_D = check_D;
        this.answer = answer;
        this.lesson_id = lesson_id;




    }

    public Educator getEducator() {
        return educator;
    }

    public void setEducator(Educator educator) {
        this.educator = educator;
    }

    public static ArrayList<Quiz> getList(int user_id) {
        ArrayList<Quiz> quizList = new ArrayList<>();
        Quiz obj;

        Statement st = null;
        try {
            st = DbConnecter.getInstance().createStatement();
            ResultSet rs =
                    st.executeQuery("SELECT * FROM quiz WHERE user_id=" + user_id );

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String question = rs.getString("question");
                String select_a = rs.getString("a");
                String select_b = rs.getString("b");
                String select_c = rs.getString("c");
                String select_d = rs.getString("d");
                String answer = rs.getString("answer");
                int lesson_id = rs.getInt("lesson_id");

                obj = new Quiz(id, name,question,select_a,select_b,select_c,select_d,answer,lesson_id);
                quizList.add(obj);
            }
            rs.close();
            st.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return quizList;
    }
    public static ArrayList<Quiz> getListStudent(int lesson_id) {
        ArrayList<Quiz> quizList = new ArrayList<>();
        Quiz obj;

        Statement st = null;
        try {
            st = DbConnecter.getInstance().createStatement();
            ResultSet rs =
                    st.executeQuery("SELECT * FROM quiz WHERE lesson_id=" + lesson_id );

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String question = rs.getString("question");
                String select_a = rs.getString("a");
                String select_b = rs.getString("b");
                String select_c = rs.getString("c");
                String select_d = rs.getString("d");
                String answer = rs.getString("answer");
                int lesson_ID = rs.getInt("lesson_id");

                obj = new Quiz(id, name,question,select_a,select_b,select_c,select_d,answer,lesson_ID);
                quizList.add(obj);
            }
            rs.close();
            st.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return quizList;
    }
    public static Quiz getFetch(int id) {


        Quiz obj = null;
        String query = "SELECT * FROM quiz WHERE id = ? ";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Quiz(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("question"),
                        rs.getString("a"),
                        rs.getString("b"),
                        rs.getString("c"),
                        rs.getString("d"),
                        rs.getString("answer"),
                        rs.getInt("lesson_id"));


            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;

    }
    public static Quiz getFetchLessonID(int lesson_id) {


        Quiz obj = null;
        String query = "SELECT * FROM quiz WHERE lesson_id = ? ";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, lesson_id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Quiz(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("question"),
                        rs.getString("a"),
                        rs.getString("b"),
                        rs.getString("c"),
                        rs.getString("d"),
                        rs.getString("answer"),
                        rs.getInt("lesson_id"));


            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;

    }
    public static boolean addContents( String name, String question, String check_A, String check_B, String check_C, String check_D,
                                      String answer, int lesson_id,int user_id) {
        String query = "INSERT INTO quiz(name, question,a,b,c,d,answer,lesson_id,user_id) VALUES " +
                "(?,?,?,?," +
                "?,?,?,?,?)";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, question);
            pr.setString(3, check_A);
            pr.setString(4, check_B);
            pr.setString(5, check_C);
            pr.setString(6, check_D);
            pr.setString(7, answer);
            pr.setInt(8, lesson_id);
            pr.setInt(9, user_id);

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
    public static boolean update(int id,String name, String question, String check_A, String check_B, String check_C,
                                 String check_D,
                                 String answer, int lesson_id,int user_id) {
        String query = "UPDATE quiz SET name=?, question=?,a=?,b=?,c=?,d=?,answer=?,lesson_id=?,user_id=?  WHERE id" +
                " = ?";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, question);
            pr.setString(3, check_A);
            pr.setString(4, check_B);
            pr.setString(5, check_C);
            pr.setString(6, check_D);
            pr.setString(7, answer);
            pr.setInt(8,lesson_id);
            pr.setInt(9,user_id);
            pr.setInt(10,id);
            pr.executeUpdate();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }
    public static boolean delete(int id) {
        String query = "DELETE FROM quiz WHERE id = ?";
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
    public static boolean deleteLessonID(int lesson_id) {
        String query = "DELETE FROM quiz WHERE lesson_id = ?";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, lesson_id);
            pr.executeUpdate();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCheck_A() {
        return check_A;
    }

    public void setCheck_A(String check_A) {
        this.check_A = check_A;
    }

    public String getCheck_B() {
        return check_B;
    }

    public void setCheck_B(String check_B) {
        this.check_B = check_B;
    }

    public String getCheck_C() {
        return check_C;
    }

    public void setCheck_C(String check_C) {
        this.check_C = check_C;
    }

    public String getCheck_D() {
        return check_D;
    }

    public void setCheck_D(String check_D) {
        this.check_D = check_D;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }


}
