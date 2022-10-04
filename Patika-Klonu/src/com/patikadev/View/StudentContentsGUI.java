package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

public class StudentContentsGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_video;
    private JLabel lbl_video;
    private JPanel pnl_comment;
    private JScrollPane scrl_comment;
    private JTable tbl_comment;
    private JPanel pnl_userComment;
    private JTextPane txt_user_comment;
    private JButton btn_send;
    private JPanel pnl_information;
    private JLabel lbl_patikaName;
    private JLabel lbl_courseName;
    private JLabel lbl_educatorName;
    private JLabel lbl_contentsName;
    private JPanel pnl_commentText;
    private JPanel pnl_Contents;
    private JPanel pnl_quiz;
    private JButton btn_quiz_login;
    private JButton dersiTamamladımButton;
    private JTextPane txt_question;
    private JCheckBox chck_A;
    private JCheckBox chck_B;
    private JCheckBox chck_C;
    private JCheckBox chck_D;
    private JTextPane txt_A;
    private JTextPane txt_B;
    private JTextPane txt_C;
    private JTextPane txt_D;
    private JButton btn_next;
    private JTextPane txt_point;
    private JButton btn_finaled;
    private JButton btn_profil;
    private DefaultTableModel mdl_comment;
    private Object[] row_comment;
    private int user_id;
    private int lesson_id;
    private int count;
    private ArrayList<Quiz> quizList;
    private int point;
    private int commen_count = 0;
    private Educator educator;

    public StudentContentsGUI(int lesson_id, int user_id) {
        this.lesson_id = lesson_id;
        this.user_id = user_id;
        Student student = Student.getFetchLesson(getLesson_id(), getUser_id());
        System.out.println("lesson id" + lesson_id);
        this.educator = Educator.getFetchAll(lesson_id);


        add(wrapper);
        setSize(830, 800);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        pnl_quiz.setVisible(false);
        txt_point.setVisible(false);
        mdl_comment = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_contents = {"YORUMLAR"};
        mdl_comment.setColumnIdentifiers(col_contents);
        row_comment = new Object[col_contents.length];

        loadComment();
        if (getCommen_count() == 0) {
            scrl_comment.setVisible(false);
        }

        tbl_comment.setModel(mdl_comment);

        tbl_comment.getTableHeader().setReorderingAllowed(false);

        if (student.getPoint() != -1) {
            txt_point.setVisible(true);
            txt_point.setText("Başarı puanınız : " + student.getPoint() + "\nPes etmek yok yola devam.");
        }
        System.out.println(student.getState());
        if (student.getState() != "") {
            btn_finaled.setEnabled(true);

        }else {
            btn_finaled.setEnabled(true);
        }

        lbl_patikaName.setText(educator.getPatika().getName());
        lbl_courseName.setText(educator.getCourse().getName());
        lbl_educatorName.setText(User.getFetch(educator.getUser().getId()).getName());
        lbl_contentsName.setText(educator.getContents());


        if (Quiz.getFetchLessonID(getLesson_id()) != null) {
            if (Student.getFetchCourse(educator.getCourse_id(), getUser_id()).getPoint() == -1) {
                setQuizList(new ArrayList<>());
                for (Quiz obj : Quiz.getListStudent(getLesson_id())) {
                    getQuizList().add(obj);

                }
                btn_quiz_login.setVisible(true);
            } else {
                System.out.println("quiz yok");
                btn_quiz_login.setVisible(false);
            }

        } else {
            System.out.println("quiz yok");
            btn_quiz_login.setVisible(false);

        }

        btn_send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txt_user_comment.getText().isEmpty()) {
                    Helper.showMsg("fill");
                } else {
                    if (Comment.addContents(getUser_id(), getLesson_id(), txt_user_comment.getText())) {
                        Helper.showMsg("done");
                        scrl_comment.setVisible(true);
                        loadComment();


                    }
                }
            }


        });
        btn_quiz_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setCount(0);
                System.out.println(getQuizList().size());
                txt_question.setText(quizList.get(getCount()).getQuestion());
                txt_A.setText(quizList.get(getCount()).getCheck_A());
                txt_B.setText(quizList.get(getCount()).getCheck_B());
                txt_C.setText(quizList.get(getCount()).getCheck_C());
                txt_D.setText(quizList.get(getCount()).getCheck_D());
                pnl_quiz.setVisible(true);
                btn_quiz_login.setVisible(false);
                setCount(getCount() + 1);
                if (getQuizList().size() >= getCount()) {
                    btn_next.setText("SONUÇ");
                }
            }
        });
        btn_finaled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Student.update(student.getId(), getUser_id(), student.getCourse_id(), getPoint(), "Tamamlandı",
                        getLesson_id())) {
                    Helper.showMsg("Tebrikler.");
                    btn_finaled.setEnabled(false);
                } else {
                    Helper.showMsg("Lütfen testi çözünüz.");
                }
            }
        });
        btn_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!chck_A.isSelected() && !chck_B.isSelected() && !chck_B.isSelected() && !chck_C.isSelected() && !chck_D.isSelected()) {
                    Helper.showMsg("Cevabı işaretleyiniz.");
                } else {

                    if (chck_A.isSelected()) {
                        if (Objects.equals("A", quizList.get(getCount() - 1).getAnswer())) {
                            setPoint(getPoint() + 1);
                        }
                    }
                    if (chck_B.isSelected()) {
                        if (Objects.equals("B", quizList.get(getCount() - 1).getAnswer())) {
                            setPoint(getPoint() + 1);
                        }
                    }
                    if (chck_C.isSelected()) {
                        if (Objects.equals("C", quizList.get(getCount() - 1).getAnswer())) {
                            setPoint(getPoint() + 1);
                        }
                    }
                    if (chck_D.isSelected()) {
                        if (Objects.equals("D", quizList.get(getCount() - 1).getAnswer())) {
                            setPoint(getPoint() + 1);
                        }
                    }
                }

                if (quizList.size() > getCount()) {
                    txt_question.setText(quizList.get(getCount()).getQuestion());
                    txt_A.setText(quizList.get(getCount()).getCheck_A());
                    txt_B.setText(quizList.get(getCount()).getCheck_B());
                    txt_C.setText(quizList.get(getCount()).getCheck_C());
                    txt_D.setText(quizList.get(getCount()).getCheck_D());



                    setCount(getCount() + 1);
                } else {
                    btn_next.setText("SONUÇ");
                }


                if (Objects.equals(btn_next.getText(), "SONUÇ")) {
                    pnl_quiz.setVisible(false);
                    point(getLesson_id());
                    txt_point.setVisible(true);
                    txt_point.setText("Başarı puanınız : " + getPoint() + "\nPes etmek yok yola devam.");
                }


            }
        });


    }

    public static void main(String[] args) {
        Helper.setLayout();
        StudentContentsGUI st = new StudentContentsGUI(24, 30);

    }

    public void loadComment() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_comment.getModel();
        clearModel.setRowCount(0);
        int i;

        for (Comment obj : Comment.getList(getLesson_id())) {
            i = 0;
            setCommen_count(getCommen_count() + 1);

            row_comment[i] = obj.getUser().getName();
            mdl_comment.addRow(row_comment);

            row_comment[i] = "    " + obj.getComment();
            mdl_comment.addRow(row_comment);


        }

    }

    public void point(int lesson_id) {
        setPoint(getPoint() * 100 / getQuizList().size());
        System.out.println("point = " + point);

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(ArrayList<Quiz> quizList) {
        this.quizList = quizList;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getCommen_count() {
        return commen_count;
    }

    public void setCommen_count(int commen_count) {
        this.commen_count = commen_count;
    }
}
