package com.patikadev.Model;

import com.patikadev.Helper.CountHelper;
import com.patikadev.Helper.DbConnecter;
import com.patikadev.Helper.Helper;

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

    private Course course;
    private Patika patika;
    private User user;



    private int user_id;


    public Educator(int id, int patika_id, int course_id, String contents, String explanation, String link, int user_id) {
        this.id = id;
        this.patika_id = patika_id;
        this.course_id = course_id;
        this.contents = contents;
        this.explanation = explanation;
        this.link = link;


        this.course = Course.getFetch(course_id);
        this.patika = Patika.getFetch(patika_id);
        this.user = User.getFetch(user_id);


    }

    public Educator() {

    }

    public static ArrayList<Educator> getList(int user_id) {
        ArrayList<Educator> educatorList = new ArrayList<>();
        Educator obj;

        Statement st = null;
        try {
            st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lesson WHERE user_id=" + user_id + " ORDER BY course_id");

            while (rs.next()) {
                int id = rs.getInt("id");
                int patika_id = rs.getInt("patika_id");
                int course_id = rs.getInt("course_id");
                String contents = rs.getString("contents");
                String explanation = rs.getString("explanation");
                String link = rs.getString("link");
                int user_ID = rs.getInt("user_id");


                obj = new Educator(id, patika_id, course_id, contents, explanation, link, user_ID);
                educatorList.add(obj);
            }
            rs.close();
            st.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educatorList;
    }
    public static ArrayList<Educator> getListID(int id) {
        ArrayList<Educator> educatorList = new ArrayList<>();
        Educator obj;

        Statement st = null;
        try {
            st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lesson WHERE id=" + id + " ORDER BY course_id");

            while (rs.next()) {
                int ID = rs.getInt("id");
                int patika_id = rs.getInt("patika_id");
                int course_id = rs.getInt("course_id");
                String contents = rs.getString("contents");
                String explanation = rs.getString("explanation");
                String link = rs.getString("link");
                int user_ID = rs.getInt("user_id");


                obj = new Educator(ID, patika_id, course_id, contents, explanation, link, user_ID);
                educatorList.add(obj);
            }
            rs.close();
            st.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educatorList;
    }

    public static ArrayList<Educator> getList() {
        ArrayList<Educator> educatorList = new ArrayList<>();
        Educator obj;

        Statement st = null;
        try {
            st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lesson  ORDER BY course_id");

            while (rs.next()) {
                int id = rs.getInt("id");
                int patika_id = rs.getInt("patika_id");
                int course_id = rs.getInt("course_id");
                String contents = rs.getString("contents");
                String explanation = rs.getString("explanation");
                String link = rs.getString("link");
                int user_ID = rs.getInt("user_id");


                obj = new Educator(id, patika_id, course_id, contents, explanation, link, user_ID);
                educatorList.add(obj);
            }
            rs.close();
            st.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educatorList;
    }

    public static ArrayList<Educator> getListCourse(int course_ID) {
        ArrayList<Educator> educatorList = new ArrayList<>();
        Educator obj;

        Statement st = null;
        try {
            st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lesson WHERE course_id=" + course_ID);

            while (rs.next()) {
                int id = rs.getInt("id");
                int patika_id = rs.getInt("patika_id");
                int course_id = rs.getInt("course_id");
                String contents = rs.getString("contents");
                String explanation = rs.getString("explanation");
                String link = rs.getString("link");
                int user_ID = rs.getInt("user_id");


                obj = new Educator(id, patika_id, course_id, contents, explanation, link, user_ID);
                educatorList.add(obj);
            }
            rs.close();
            st.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educatorList;
    }

    public static ArrayList<Educator> getList(int user_id, int patika_id) {
        ArrayList<Educator> educatorList = new ArrayList<>();
        Educator obj;

        Statement st = null;
        try {
            st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lesson WHERE user_id=" + user_id + "AND patika_id = " + patika_id);

            while (rs.next()) {
                int id = rs.getInt("id");
                int patika_Id = rs.getInt("patika_id");
                int course_id = rs.getInt("course_id");
                String contents = rs.getString("contents");
                String explanation = rs.getString("explanation");
                String link = rs.getString("link");
                int user_ID = rs.getInt("user_id");


                obj = new Educator(id, patika_Id, course_id, contents, explanation, link, user_ID);
                educatorList.add(obj);
            }
            rs.close();
            st.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educatorList;
    }


    public static ArrayList<Educator> getList(String contents_name) {
        ArrayList<Educator> educatorList = new ArrayList<>();
        Educator obj;

        Statement st = null;
        try {
            st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lesson WHERE contents='" + contents_name + "'");

            while (rs.next()) {
                int id = rs.getInt("id");
                int patika_Id = rs.getInt("patika_id");
                int course_id = rs.getInt("course_id");
                String contents = rs.getString("contents");
                String explanation = rs.getString("explanation");
                String link = rs.getString("link");
                int user_ID = rs.getInt("user_id");


                obj = new Educator(id, patika_Id, course_id, contents, explanation, link, user_ID);
                educatorList.add(obj);
            }
            rs.close();
            st.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educatorList;
    }

    public static ArrayList<CountHelper> getListCountcontents(int patika_id) {
        ArrayList<CountHelper> countList = new ArrayList<>();
        CountHelper obj;

        Statement st = null;
        try {
            st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT course_id, COUNT(contents) FROM lesson where patika_id=" + patika_id +
                    " GROUP BY course_id " +

                    " ORDER BY COUNT(contents) DESC");

            while (rs.next()) {


                int id = rs.getInt("course_id");
                int contentsCount = rs.getInt("count");


                obj = new CountHelper(id, contentsCount);
                countList.add(obj);
            }
            rs.close();
            st.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return countList;
    }
    public static ArrayList<Educator> searchLessonList(String query) {
        ArrayList<Educator> lessonList = new ArrayList<>();
        Educator obj;


        try {
            Statement st = DbConnecter.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Educator(rs.getInt("id"),
                        rs.getInt("patika_id"),
                        rs.getInt("course_id"),
                        rs.getString("contents"),
                        rs.getString("explanation"),
                        rs.getString("link"),
                        rs.getInt("user_id"));

                lessonList.add(obj);
            }
            rs.close();
            st.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lessonList;
    }
    public static int getFetchCountContents(int course_id) {

        Educator obj = null;
        String query = "Select count(*) From lesson WHERE course_id=?";
        int count = 0;
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, course_id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
            try {
                rs.close();
                pr.getConnection().close();

                DbConnecter.getInstance().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


            DbConnecter.getInstance().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public static Educator getFetchPatikaID(int patika_id, int user_id) {
        Educator obj = null;
        String query = "Select * From lesson WHERE patika_id = ? AND user_id = " + user_id;

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, patika_id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Educator(rs.getInt("id"),
                        rs.getInt("patika_id"),
                        rs.getInt("course_id"),
                        rs.getString("contents"),
                        rs.getString("explanation"),
                        rs.getString("link"),
                        rs.getInt("user_id"));

            }
            try {
                rs.close();
                pr.getConnection().close();

                DbConnecter.getInstance().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    public static Educator getFetch(int user_id) {
        Educator obj = null;
        String query = "Select * From lesson WHERE user_id = ?";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, user_id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Educator(rs.getInt("id"),
                        rs.getInt("patika_id"),
                        rs.getInt("course_id"),
                        rs.getString("contents"),
                        rs.getString("explanation"),
                        rs.getString("link"),
                        rs.getInt("user_id"));

            }
            pr.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static Educator getFetch(String contents) {
        Educator obj = null;
        String query = "Select * From lesson WHERE contents = ?";

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setString(1, contents);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Educator(rs.getInt("id"),
                        rs.getInt("patika_id"),
                        rs.getInt("course_id"),
                        rs.getString("contents"),
                        rs.getString("explanation"),
                        rs.getString("link"),
                        rs.getInt("user_id"));

            }
            pr.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static Educator getFetch(int course_id, int user_id) {


        Educator obj = null;
        String query = "SELECT * FROM lesson WHERE course_id = ? AND user_id= " + user_id;

        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, course_id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Educator(
                        rs.getInt("id"),
                        rs.getInt("patika_id"),
                        rs.getInt("course_id"),
                        rs.getString("contents"),
                        rs.getString("explanation"),
                        rs.getString("link"),
                        rs.getInt("user_id"));


            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;

    }

    public static Educator getFetchAll(int id) {

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
                        rs.getInt("user_id"));


            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;

    }


    public static boolean addContents(int patika_id, int course_id, String contents, String explanation, String link,

                                      int user_id) {
        String query = "INSERT INTO lesson (patika_id, course_id,contents,explanation,link,user_id) VALUES " +
                "(?,?,?,?," +
                "?,?)";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setInt(1, patika_id);
            pr.setInt(2, course_id);
            pr.setString(3, contents);
            pr.setString(4, explanation);
            pr.setString(5, link);
            pr.setInt(6, user_id);

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

    public static boolean update(int id, String contents, String explanation, String link) {
        String query = "UPDATE lesson SET contents = ?, explanation = ?,link = ?  WHERE id = ?";
        try {
            PreparedStatement pr = DbConnecter.getInstance().prepareStatement(query);
            pr.setString(1, contents);
            pr.setString(2, explanation);
            pr.setString(3, link);
            pr.setInt(4, id);
            pr.executeUpdate();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }

    public static boolean delete(int id) {
        String query = "DELETE FROM lesson WHERE id = ?";
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
