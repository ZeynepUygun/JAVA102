package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Course;
import com.patikadev.Model.Educator;
import com.patikadev.Model.Quiz;
import com.patikadev.Model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.HashSet;

public class StudentProfilGUI extends JFrame {
    DefaultTableModel mdl_lesson_list;
    Object[] row_lesson_list;
    private JPanel wrapper;
    private JPanel pnl_information;
    private JPanel pnl_lesson;
    private JScrollPane scrl_lesson;
    private JTable tbl_lesson;
    private JComboBox<String> cmb_course;
    private JLabel lbl_studentName;
    private JLabel lbl_course_name;
    private JLabel lbl_contents_name;
    private JButton btn_lesson;
    private int user_id;
    private int lesson_id;

    public StudentProfilGUI(int user_id) {
        setUser_id(user_id);
        add(wrapper);
        setSize(600, 600);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);


        mdl_lesson_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1 || column == 2) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };


        Object[] col_content_list = {"Kurslar", "İçerikler", "Test","Puan"};

        mdl_lesson_list.setColumnIdentifiers(col_content_list);
        row_lesson_list = new Object[col_content_list.length];


        tbl_lesson.setModel(mdl_lesson_list);


        loadProfil();


        cmb_course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int course_ID = Course.getFetch(cmb_course.getSelectedItem().toString()).getId();
                loadCombobox(course_ID);
            }
        });


        tbl_lesson.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {

                    String contents =
                            tbl_lesson.getValueAt(tbl_lesson.getSelectedRow(), 1).toString();
                    lbl_contents_name.setText(contents);

                    int resault_lesson_id = Educator.getFetch(lbl_contents_name.getText()).getId();
                    setLesson_id(resault_lesson_id);
                    System.out.println(getLesson_id());
                    StudentContentsGUI st = new StudentContentsGUI(getLesson_id(), getUser_id());


                }
            }
        });


        btn_lesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StudentGUI st = new StudentGUI(30);
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        StudentProfilGUI prof = new StudentProfilGUI(30);

    }

    public void loadProfil() {
        HashSet<String> cmbCourse = new HashSet<>();

        DefaultTableModel clearModel = (DefaultTableModel) tbl_lesson.getModel();
        clearModel.setRowCount(0);
        int i;
        for(Student obj : Student.getList(getUser_id())){
            i=0;
            cmbCourse.add(obj.getEducator().getCourse().getName());

            row_lesson_list[i++] = obj.getEducator().getCourse().getName();
            row_lesson_list[i++] = obj.getEducator().getContents();

            if (Quiz.getFetchLessonID(obj.getLesson_id()) != null) {
                row_lesson_list[i++] = "Test";
            } else {
                row_lesson_list[i++] = "-";
            }

            if(obj.getPoint()!=-1) {
                row_lesson_list[i++] = obj.getPoint();
            }else {
                row_lesson_list[i++]="-";
            }

            mdl_lesson_list.addRow(row_lesson_list);
        }

        for (String s : cmbCourse) {
            cmb_course.addItem(s);
        }
    }

    public void loadCombobox(int course_id) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_lesson.getModel();
        clearModel.setRowCount(0);
        int i;


        for (Educator ed : Educator.getListCourse(course_id)) {
            i = 0;

            row_lesson_list[i++] = ed.getCourse().getName();
            row_lesson_list[i++] = ed.getContents();


            mdl_lesson_list.addRow(row_lesson_list);
        }


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

