package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Educator;

import javax.swing.*;

public class LessonGUI extends JFrame{
    private JPanel wrapper;
    private JLabel lbl_educator_name;
    private JLabel lbl_patika_name;
    private JLabel lbl_course_name;
    private JPanel pnl_lesson_list;
    private JScrollPane scrl_pnl_lessonList;
    private JTable table1;
    private Educator educator;


    public LessonGUI(Educator educator) {

        this.educator=educator;
        add(wrapper);
        setSize(600, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);


    }

    public JLabel getLbl_educator_name() {
        return lbl_educator_name;
    }

    public void setLbl_educator_name(JLabel lbl_educator_name) {
        this.lbl_educator_name = lbl_educator_name;
    }

    public JLabel getLbl_patika_name() {
        return lbl_patika_name;
    }

    public void setLbl_patika_name(JLabel lbl_patika_name) {
        this.lbl_patika_name = lbl_patika_name;
    }

    public JLabel getLbl_course_name() {
        return lbl_course_name;
    }

    public void setLbl_course_name(JLabel lbl_course_name) {
        this.lbl_course_name = lbl_course_name;
    }
}
