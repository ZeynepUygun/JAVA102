package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Educator;
import com.patikadev.Model.Quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class QuizAddGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_quiz_information;
    private JLabel lbl_educator_name;
    private JPanel pnl_quiz_add;
    private JLabel lbl_patika_name;
    private JComboBox cmb_contents_name;
    private JTextField fld_questions;
    private JLabel lbl_questions;
    private JCheckBox chckbx_A;
    private JTextField fld_answer_A;
    private JCheckBox chckbx_B;
    private JTextField fld_answer_B;
    private JCheckBox chckbx_C;
    private JTextField fld_answer_C;
    private JButton btn_quiz_add;
    private JTextField fld_answer_D;
    private JCheckBox chckbx_D;
    private JLabel lbl_quiz_name;
    private JTextField fld_quiz_name;
    private int user_id;
    private int lesson_id = 0;


    public QuizAddGUI(int user_id) {
        this.user_id = user_id;

        add(wrapper);
        setSize(600, 400);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        cmb_contents_name.addItem("Seçiniz...");
        for (Educator obj : Educator.getList(getUser_id())) {

            cmb_contents_name.addItem(obj.getContents());

        }


        cmb_contents_name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Quiz obj : Quiz.getList(getUser_id())) {


                    if (Objects.equals(cmb_contents_name.getSelectedItem().toString(),
                            obj.getEducator().getContents()))
                            {

                        fld_quiz_name.setText(obj.getName());
                        fld_quiz_name.setEditable(false);
                        setLesson_id(obj.getId());
                        break;
                    } else {
                        fld_quiz_name.setEditable(true);
                        fld_quiz_name.setText(null);
                    }

                }


            }
        });
        btn_quiz_add.addActionListener(new ActionListener() {
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
                if (!Helper.isFieldEmpty(fld_quiz_name) &&
                        !Helper.isFieldEmpty(fld_questions) &&
                        !Helper.isFieldEmpty(fld_answer_A) &&
                        !Helper.isFieldEmpty(fld_answer_B) &&
                        !Helper.isFieldEmpty(fld_answer_C) &&
                        !Helper.isFieldEmpty(fld_answer_D) &&
                        answer != "null" &&
                        getLesson_id() != 0) {

                    if (Quiz.addContents(fld_quiz_name.getText(), fld_questions.getText(), fld_answer_A.getText(),
                            fld_answer_B.getText(), fld_answer_C.getText(), fld_answer_D.getText(), answer, getLesson_id(),
                            getUser_id())) {
                        Helper.showMsg("done");
                        dispose();
                        QuizGUI quiz = new QuizGUI(getUser_id());
                        quiz.setUser_id(getUser_id());


                    }
                } else {
                    Helper.showMsg("fill");
                }
            }
        });
    }

    public static void main(String[] args) {
        QuizAddGUI quiz = new QuizAddGUI(3);

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
}
