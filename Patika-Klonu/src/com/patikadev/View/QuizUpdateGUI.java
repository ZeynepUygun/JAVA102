package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Educator;
import com.patikadev.Model.Quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class QuizUpdateGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_quiz_information;
    private JLabel lbl_educator_name;
    private JLabel lbl_patika_name;
    private JLabel lbl_quiz_name;
    private JPanel pnl_quiz_add;
    private JLabel lbl_questions;
    private JCheckBox chckbx_A;
    private JCheckBox chckbx_B;
    private JCheckBox chckbx_C;
    private JButton btn_quiz_update;
    private JCheckBox chckbx_D;
    private JTextPane txt_answer_A;
    private JTextPane txt_answer_B;
    private JTextPane txt_answer_C;
    private JTextPane txt_answer_D;
    private JTextField fld_contentsName;
    private JLabel lbl_courseName;
    private JTextField fld_courseNAme;
    private JComboBox cmb_quizName;
    private JTextField fld_quizName;
    private JButton eskiHaliButton;
    private JTextPane txt_quizQuestion;
    private JCheckBox chck_quizName;
    private JButton vazgeçButton;
    private int quiz_id;
    private String quiz_NewName;
    private HashSet<String> quizName;

    public QuizUpdateGUI(int quiz_id) {
        this.quiz_id = quiz_id;
        add(wrapper);
        setSize(800, 600);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        quizName = new HashSet<>();

        Quiz quiz = Quiz.getFetch(getQuiz_id());
        Educator educator = Educator.getFetchAll(quiz.getLesson_id());
        for (Quiz obj : Quiz.getList(quiz.getUser_id())) {

            quizName.add(obj.getName());

        }
        for (String itr : quizName) {

            cmb_quizName.addItem(itr);

        }


        search(quiz, educator);

        eskiHaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search(quiz, educator);
            }
        });
        btn_quiz_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String answer = "null";
                if (chckbx_A.isSelected()) {
                    answer = "A";
                }
                if (chckbx_B.isSelected()) {
                    answer = "B";
                }
                if (chckbx_C.isSelected()) {
                    answer = "C";
                }
                if (chckbx_D.isSelected()) {
                    answer = "D";
                }
                if(chck_quizName.isSelected()){
                    setQuiz_NewName(cmb_quizName.getSelectedItem().toString());
                }else {
                    setQuiz_NewName(fld_quizName.getText());
                }




                if ((getQuiz_NewName() != null) &&
                        (txt_quizQuestion.getText() != null) &&
                        (txt_answer_A.getText() != null) &&
                        (txt_answer_B.getText() != null) &&
                        (txt_answer_C.getText() != null) &&
                        (txt_answer_D.getText() != null) &&
                        (answer != "null")
                ) {
                    System.out.println("girdi güncellemeye");


                    if (Helper.confirm("İçerik bilgileri güncellenecektir.Onaylıyor musunuz? ")) {
                        if (Quiz.update(quiz.getId(),getQuiz_NewName(),
                                txt_quizQuestion.getText(),
                                txt_answer_A.getText(),
                                txt_answer_B.getText(),
                                txt_answer_C.getText(),
                                txt_answer_D.getText(),
                                answer,
                                quiz.getLesson_id(),
                                quiz.getUser_id())
                        ) {
                            Helper.showMsg("done");
                            dispose();
                            QuizGUI quizGUI = new QuizGUI(quiz.getUser_id());


                        }

                    } else {
                        Helper.showMsg("Güncelleme işlemi iptal edildi.");
                    }
                }
            }
        });
        chck_quizName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            if(cmb_quizName.getSelectedItem()!=null) {
                if (chck_quizName.isSelected()) {
                    if (Helper.confirm("\" " + fld_quizName.getText() + "\" olan quiz ismi \" " + cmb_quizName.getSelectedItem().toString() + "\" olarak değiştirilecektir. Onaylıyor musunuz? Bu işlem form üzerinde olacaktır güncelle butonuna tıklamadan kesin olarak değişmeyecektir !!")) {


                        chck_quizName.setSelected(true);
                        fld_quizName.setEditable(false);


                    } else {
                        cmb_quizName.setSelectedItem(null);
                        chck_quizName.setSelected(false);
                        fld_quizName.setEditable(true);


                    }
                } else {

                    fld_quizName.setText(quiz.getName());

                    cmb_quizName.setSelectedItem(null);
                    chck_quizName.setSelected(false);
                    fld_quizName.setEditable(true);


                }
            }else{
                Helper.showMsg("Secim");
            }
            }
        });
        vazgeçButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                QuizGUI quizGUI = new QuizGUI(quiz.getUser_id());

            }
        });
    }

    public void search(Quiz quiz, Educator educator) {
        chck_quizName.setSelected(false);
        cmb_quizName.setSelectedIndex(0);

        fld_courseNAme.setText(educator.getCourse().getName());
        fld_contentsName.setText(educator.getContents());
        fld_quizName.setText(quiz.getName());

        txt_quizQuestion.setText(quiz.getQuestion());
        txt_answer_A.setText(quiz.getCheck_A());
        txt_answer_B.setText(quiz.getCheck_B());
        txt_answer_C.setText(quiz.getCheck_C());
        txt_answer_D.setText(quiz.getCheck_D());

        String selected = quiz.getAnswer();
        switch (selected) {
            case "A":
                chckbx_A.setSelected(true);
                break;
            case "B":
                chckbx_B.setSelected(true);
                break;
            case "C":
                chckbx_C.setSelected(true);
                break;
            case "D":
                chckbx_D.setSelected(true);
            default:


        }

    }

    public String getQuiz_NewName() {
        return quiz_NewName;
    }

    public void setQuiz_NewName(String quiz_NewName) {
        this.quiz_NewName = quiz_NewName;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public JCheckBox getChckbx_A() {
        return chckbx_A;
    }

    public void setChckbx_A(JCheckBox chckbx_A) {
        this.chckbx_A = chckbx_A;
    }

    public JCheckBox getChckbx_B() {
        return chckbx_B;
    }

    public void setChckbx_B(JCheckBox chckbx_B) {
        this.chckbx_B = chckbx_B;
    }

    public JCheckBox getChckbx_C() {
        return chckbx_C;
    }

    public void setChckbx_C(JCheckBox chckbx_C) {
        this.chckbx_C = chckbx_C;
    }

    public JCheckBox getChckbx_D() {
        return chckbx_D;
    }

    public void setChckbx_D(JCheckBox chckbx_D) {
        this.chckbx_D = chckbx_D;
    }

    public JTextPane getTxt_answer_A() {
        return txt_answer_A;
    }

    public void setTxt_answer_A(JTextPane txt_answer_A) {
        this.txt_answer_A = txt_answer_A;
    }

    public JTextPane getTxt_answer_B() {
        return txt_answer_B;
    }

    public void setTxt_answer_B(JTextPane txt_answer_B) {
        this.txt_answer_B = txt_answer_B;
    }

    public JTextPane getTxt_answer_C() {
        return txt_answer_C;
    }

    public void setTxt_answer_C(JTextPane txt_answer_C) {
        this.txt_answer_C = txt_answer_C;
    }

    public JTextPane getTxt_answer_D() {
        return txt_answer_D;
    }

    public void setTxt_answer_D(JTextPane txt_answer_D) {
        this.txt_answer_D = txt_answer_D;
    }

    public JTextField getFld_contentsName() {
        return fld_contentsName;
    }

    public void setFld_contentsName(JTextField fld_contentsName) {
        this.fld_contentsName = fld_contentsName;
    }

    public JTextField getFld_courseNAme() {
        return fld_courseNAme;
    }

    public void setFld_courseNAme(JTextField fld_courseNAme) {
        this.fld_courseNAme = fld_courseNAme;
    }
}
