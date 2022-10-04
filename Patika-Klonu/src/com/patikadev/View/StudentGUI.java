package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.CountHelper;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class StudentGUI extends JFrame {
    private DefaultTableModel mdl_patika_list;
    private DefaultTableModel mdl_contents_list;
    private JPanel wrapper;
    private JPanel pnl_student_patikaList;
    private JScrollPane scrl_student_patikaList;
    private JTable tbl_student_patikaList;
    private JPanel pnl_student_welcome;
    private JLabel lbl_title;
    private JPanel pnl_patika_list;
    private JLabel lbl_educatorName;
    private JLabel lbl_patikaName;
    private JButton btn_profil;
    private JButton patikaButton;
    private JPanel pnl_btn;
    private JButton btn_patikaLoginUp;
    private JTable tbl_contentsList;
    private Object[] row_patika_list;
    private Object[] row_content_list;
    private int user_id;
    private int select_CourseID;

    public StudentGUI(int user_id) {
        this.user_id = user_id;
        add(wrapper);
        setSize(700, 700);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        mdl_contents_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };


        mdl_patika_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        tbl_student_patikaList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_student_patikaList.rowAtPoint(point);
                tbl_student_patikaList.setRowSelectionInterval(selected_row, selected_row);


            }
        });

        loadStudentCourseModel();


        tbl_student_patikaList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btn_patikaLoginUp.setText("Kursa Katıl");
                String userUname =
                        tbl_student_patikaList.getValueAt(tbl_student_patikaList.getSelectedRow(), 1).toString();
                String patikaName_CourseName =
                        tbl_student_patikaList.getValueAt(tbl_student_patikaList.getSelectedRow(), 0).toString();
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {


                    lbl_educatorName.setText("Eğitmen Adı : " + userUname);
                    if (User.getFetch(userUname) != null) {
                        int user_id = User.getFetch(userUname).getId();


                        loadStudentContents(Patika.getFetch(patikaName_CourseName).getId());
                        userUname = "";

                    }


                }
                if (Student.getFetchCourse(getSelect_CourseID(),
                        getUser_id()) == null) {
                    if (Course.getFetch(patikaName_CourseName) != null) {


                        loadContentsList(Course.getFetch(patikaName_CourseName).getId());
                        setSelect_CourseID(Course.getFetch(patikaName_CourseName).getId());
                        btn_patikaLoginUp.setEnabled(true);
                        btn_patikaLoginUp.setBorderPainted(true);


                        patikaName_CourseName = "";


                    }
                } else {
                    btn_patikaLoginUp.setText("Katıldın");
                    btn_patikaLoginUp.setEnabled(false);
                    btn_patikaLoginUp.setBorderPainted(false);
                }
            }
        });

        patikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadStudentCourseModel();
                btn_patikaLoginUp.setEnabled(true);
                btn_patikaLoginUp.setBorderPainted(true);
            }
        });
        btn_patikaLoginUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Course.getFetch(getSelect_CourseID()) != null && Student.getFetchCourse(getSelect_CourseID(),
                        getUser_id()) == null) {
                    for (Educator obj : Educator.getListCourse(getSelect_CourseID())) {
                        Student.addContents(getUser_id(), obj.getCourse_id(), obj.getId());
                        btn_patikaLoginUp.setEnabled(false);
                        Helper.showMsg("Kaydınız yapıldı.");
                    }


                }
            }
        });

        btn_profil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(getUser_id());
                StudentProfilGUI pr = new StudentProfilGUI(getUser_id());
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        StudentGUI ed = new StudentGUI(30);

    }

    public void loadStudentContents(int patika_id) {

        Object[] col_course_list = {"Kurs Adı", "İçerik Sayısı"};
        mdl_patika_list.setColumnIdentifiers(col_course_list);

        row_patika_list = new Object[col_course_list.length];
        tbl_student_patikaList.setModel(mdl_patika_list);

        tbl_student_patikaList.getTableHeader().setReorderingAllowed(false);
        lbl_patikaName.setText("Patika Adı : " + Patika.getFetch(patika_id).getName());

        DefaultTableModel clearModel = (DefaultTableModel) tbl_student_patikaList.getModel();
        clearModel.setRowCount(0);
        int i = 0;

        for (CountHelper obj : Educator.getListCountcontents(patika_id)) {

            row_patika_list[i++] = Course.getFetch(obj.getId()).getName();
            row_patika_list[i++] = obj.getCount();

            mdl_patika_list.addRow(row_patika_list);
        }

    }

    public void loadStudentCourseModel() {

        Object[] col_patika_list = {"Patika Adı", "Eğitmen"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);
        row_patika_list = new Object[col_patika_list.length];

        tbl_student_patikaList.setModel(mdl_patika_list);
        tbl_student_patikaList.getTableHeader().setReorderingAllowed(false);
        lbl_patikaName.setText("Patika Adı : ");
        lbl_educatorName.setText("Eğitmen Adı : ");
        DefaultTableModel clearModel = (DefaultTableModel) tbl_student_patikaList.getModel();
        clearModel.setRowCount(0);
        HashSet<String> result = new HashSet<>();
        for (Educator obj : Educator.getList()) {

            result.add(obj.getPatika().getName());

        }
        Iterator<String> itr = result.iterator();
        int i;
        Boolean isControl = false;
        for (Educator obj : Educator.getList()) {

            i = 0;
            while (itr.hasNext()) {
                if (Objects.equals(itr.next(), obj.getPatika().getName())) {
                    isControl = false;
                    break;
                } else {
                    isControl = true;
                }
            }
            if (isControl) {

                row_patika_list[i++] = obj.getPatika().getName();
                row_patika_list[i++] = User.getFetch(obj.getCourse().getUser().getId()).getUname();
                mdl_patika_list.addRow(row_patika_list);
            }


        }


    }

    public void loadContentsList(int course_id) {


        Object[] col_content_list = {"İçerikler", ""};

        mdl_patika_list.setColumnIdentifiers(col_content_list);
        row_patika_list = new Object[col_content_list.length];


        tbl_student_patikaList.setModel(mdl_patika_list);

        //tbl_student_patikaList.getTableHeader().setReorderingAllowed(false);

        DefaultTableModel clearModel = (DefaultTableModel) tbl_student_patikaList.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Educator obj : Educator.getListCourse(course_id)) {
            i = 0;

            row_patika_list[i++] = obj.getContents();
            if (Quiz.getFetchLessonID(obj.getId()) != null) {
                row_patika_list[i++] = "Test";
            } else {
                row_patika_list[i++] = "";
            }


            mdl_patika_list.addRow(row_patika_list);


        }


    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSelect_CourseID() {
        return select_CourseID;
    }

    public void setSelect_CourseID(int select_CourseID) {
        this.select_CourseID = select_CourseID;
    }
}

