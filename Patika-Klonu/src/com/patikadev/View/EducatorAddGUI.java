package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Course;
import com.patikadev.Model.Educator;
import com.patikadev.Model.Patika;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

public class EducatorAddGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_name;
    private JComboBox<String> cmb_educator_patika;
    private JComboBox<String> cmb_educator_course;
    private JTextField fld_educator_title;
    private JTextField fld_educator_explanation;
    private JTextField fld_educator_youtube;
    private JButton btn_add_content;
    private JPanel pnl_lesson_add;
    private JButton vazgeçButton;
    private int user_id;


    public EducatorAddGUI() {
        Helper.setLayout();

        add(wrapper);
        setSize(800, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        for (Course obj : Course.getListByUser(getUser_id())) {
            cmb_educator_patika.addItem(obj.getPatika().getName());

        }


        cmb_educator_patika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmb_educator_course.removeAllItems();
                String patikaItem = cmb_educator_patika.getSelectedItem().toString();
                if (Patika.getFetch(patikaItem) != null) {
                    int patika_id = Patika.getFetch(patikaItem).getId();

                    ArrayList<Course> sh = Course.getList(getUser_id(), patika_id);
                    for (Course obj : sh) {
                        cmb_educator_course.addItem(obj.getName());

                    }
                } else {
                    cmb_educator_course.removeAllItems();
                    cmb_educator_course.addItem("Seçiniz...");


                }
            }
        });
        btn_add_content.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String patikaItem = cmb_educator_patika.getSelectedItem().toString();
                String courseItem = cmb_educator_course.getSelectedItem().toString();
                if (patikaItem != "Seçiniz..." || courseItem != "Seçiniz...") {
                    int course_id = Course.getFetch(courseItem).getId();
                    int patika_id = Patika.getFetch(patikaItem).getId();


                    boolean isControl = true;
                    ArrayList<Educator> sh = Educator.getList(getUser_id(), patika_id);
                    for (Educator obj : sh) {
                        cmb_educator_course.addItem(obj.getCourse().getName());
                        if (Objects.equals(obj.getContents(), fld_educator_title.getText())) {
                            isControl = false;

                        }
                    }
                    if (isControl) {
                        if (Objects.equals(patikaItem, "Seçiniz...") || Objects.equals(courseItem, "Seçiniz...") || Helper.isFieldEmpty(fld_educator_title) || Helper.isFieldEmpty(fld_educator_explanation) || Helper.isFieldEmpty(fld_educator_youtube)) {
                            Helper.showMsg("fill");
                        } else {
                            if (Educator.addContents(patika_id, course_id, fld_educator_title.getText(),
                                    fld_educator_explanation.getText(), fld_educator_youtube.getText(), getUser_id())) {
                                Helper.showMsg("done");
                                dispose();
                                EducatorGUI ed = new EducatorGUI(getUser_id());


                            }


                        }
                    } else {
                        Helper.showMsg("Başlık ismi daha önce kullanılmış. Lütfen yeni bir başlık ismi giriniz.");
                    }
                } else {
                    Helper.showMsg("Lütfen tüm alanları doldurunuz!");
                }

            }
        });
        pnl_name.addMouseListener(new MouseAdapter() {
        });
        vazgeçButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EducatorGUI ed = new EducatorGUI(getUser_id());

                dispose();
            }
        });
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


}
