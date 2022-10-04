package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Course;
import com.patikadev.Model.Educator;
import com.patikadev.Model.Quiz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class QuizGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_quiz_title;
    private JButton btn_quiz_add;
    private JLabel lbl_educator_name;
    private JLabel lbl_quiz_patikaName;
    private JLabel lbl_quiz_contentsName;
    private JPanel pnl_educator_quiz;
    private JScrollPane scrl_quiz_list;
    private JTable tbl_quiz_list;
    private JButton btn_quiz_update;
    private JButton btn_quiz_delete;
    private JButton btn_sh_quiz;
    private JPanel pnl_button;
    private Object[] row_quiz_list;
    private DefaultTableModel mdl_quiz_list;
    private int user_id = 3;
    private int select_id=0;

    public QuizGUI(int user_id) {
        this.user_id = user_id;

        add(wrapper);
        setSize(900, 400);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        mdl_quiz_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1 || column == 2) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };


        Object[] col_quiz_list = {"Quiz ID", "İçerik Adı", "Quiz Adı", "Soru"};// Kolon isimleri Object
        // dizisine
        // atılır.
        mdl_quiz_list.setColumnIdentifiers(col_quiz_list);//tabloya kolon isimleri işlenir.
        row_quiz_list = new Object[col_quiz_list.length];

        loadEducatorModel();


        tbl_quiz_list.setModel(mdl_quiz_list);
        tbl_quiz_list.getTableHeader().setReorderingAllowed(false);
        tbl_quiz_list.getColumnModel().getColumn(0).setMaxWidth(75);

        tbl_quiz_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_quiz_list.rowAtPoint(point);
                tbl_quiz_list.setRowSelectionInterval(selected_row, selected_row);
                setSelect_id(Integer.parseInt(tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 0).toString()));
            }
        });


        btn_quiz_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuizAddGUI newQuiz = new QuizAddGUI(getUser_id());


            }
        });
        btn_quiz_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(getSelect_id()!=0) {
                    QuizUpdateGUI update = new QuizUpdateGUI(select_id);
                    dispose();
                }else {
                    Helper.showMsg("Secim");
                }

            }

        });
        btn_quiz_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getSelect_id()!=0) {
                    if (Helper.confirm("ID = " + getSelect_id() + " olan soruyu silmek istediğinize emin misiniz ? ")) {
                        Quiz.delete(getSelect_id());
                        Helper.showMsg("fill");
                        loadEducatorModel();
                    }
                }else {
                    Helper.showMsg("Secim");
                }

            }
        });
    }

    public static void main(String[] args) {
        QuizGUI quiz = new QuizGUI(3);

    }

    private void loadEducatorModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_quiz_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Quiz lst : Quiz.getList(getUser_id())) {
            i = 0;


            row_quiz_list[i++] = lst.getId();
            row_quiz_list[i++] = Educator.getFetchAll(lst.getLesson_id()).getContents();
            row_quiz_list[i++] = lst.getName();
            row_quiz_list[i++] = lst.getQuestion();


            mdl_quiz_list.addRow(row_quiz_list);


        }

    }
    private void loadEducatorModel(ArrayList<Quiz> searchQuizList) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_quiz_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Quiz lst : searchQuizList) {
            i = 0;
            row_quiz_list[i++] = lst.getId();
            row_quiz_list[i++] = Educator.getFetchAll(lst.getLesson_id()).getContents();
            row_quiz_list[i++] = lst.getName();
            row_quiz_list[i++] = lst.getQuestion();


            mdl_quiz_list.addRow(row_quiz_list);


        }

    }

    public int getSelect_id() {
        return select_id;
    }

    public void setSelect_id(int select_id) {
        this.select_id = select_id;
    }

    public JLabel getLbl_educator_name() {
        return lbl_educator_name;
    }

    public void setLbl_educator_name(JLabel lbl_educator_name) {
        this.lbl_educator_name = lbl_educator_name;
    }

    public JLabel getLbl_quiz_patikaName() {
        return lbl_quiz_patikaName;
    }

    public void setLbl_quiz_patikaName(JLabel lbl_quiz_patikaName) {
        this.lbl_quiz_patikaName = lbl_quiz_patikaName;
    }


    public JLabel getLbl_quiz_contentsName() {
        return lbl_quiz_contentsName;
    }

    public void setLbl_quiz_contentsName(JLabel lbl_quiz_contentsName) {
        this.lbl_quiz_contentsName = lbl_quiz_contentsName;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

}
