package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_educator_name;
    private JLabel lbl_patika_name;
    private JLabel lbl_course_name;


    private JTextPane txt_lesson_explanation;
    private JTextField fld_lesson_quizName;
    private JButton btn_lesson_clear;
    private JButton btn_lesson_update;
    private JButton btn_lesson_delete;
    private JButton btn_lesson_new_add;
    private JTextField fld_lesson_link;
    private JTextField fld_lesson_contents;
    private JLabel lbl_lesson_explanation;
    private JLabel lbl_lesson_link;
    private JLabel lbl_lesson_quizName;
    private JButton btn_lesson_quizDelete;
    private JTabbedPane tbpnl_Lesson_list;
    private JPanel pnl_contentsList;
    private JPanel pnl_allContents;
    private JScrollPane scr_Lesson_list;
    private JTable tbl_lesson_list;
    private JLabel lbl_sh_course;
    private JTextField fld_search;
    private JButton btn_shearch;
    private JPanel pnl_sh_allContents;
    private JButton btn_back;
    private JPanel pnl_lesson_data;
    private JLabel lbl_lesson_name;
    private JButton btn_updateTable;
    private JCheckBox chck_course;
    private JCheckBox chck_contents;


    private DefaultTableModel mdl_lesson_list;


    private Object[] row_lesson_list;

    private Course course;
    private Patika patika;
    private int user_id;

    private int select_id = 0;


    public EducatorGUI(int user_id) {
        this.user_id = user_id;
        Helper.setLayout();


        gui();
        start();


    }

    public static void main(String[] args) {
        Helper.setLayout();
        EducatorGUI ed = new EducatorGUI(3);

    }

    private void gui() {
        Helper.setLayout();


        add(wrapper);
        setSize(1000, 500);
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


    }

    private void start() {


        Object[] col_alllesson_list = {"id", "Patika Adı", "Kurs Adı", "İçerikler", "Quiz Adı"};
        mdl_lesson_list.setColumnIdentifiers(col_alllesson_list);
        row_lesson_list = new Object[col_alllesson_list.length];

        loadLessonModel();
        tbl_lesson_list.setModel(mdl_lesson_list);
        tbl_lesson_list.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_lesson_list.getTableHeader().setReorderingAllowed(false);


        btn_updateTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadLessonModel();
                fld_search.setText(null);
            }
        });

        btn_shearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chck_course.isSelected() == true || chck_contents.isSelected() == true) {
                    if (chck_course.isSelected() == true) {
                        String query = "SELECT lesson.id,lesson.patika_id,lesson.course_id,lesson.contents,lesson.Explanation,lesson.link\n" +
                                "FROM lesson LEFT JOIN course " +
                                "ON course.id=lesson.COURSE_id " +
                                "where course.name ILIKE '%" + fld_search.getText() + "%'";
                        loadLessonModel(Educator.searchLessonList(query));


                    } else {
                        String query =
                                "SELECT * FROM lesson WHERE contents ILIKE '%{{contents}}%' AND user_id=" + getUser_id();
                        query = query.replace("{{contents}}", fld_search.getText());
                        loadLessonModel(Educator.searchLessonList(query));
                    }
                } else {
                    Helper.showMsg("Kriter seçimi yapınız.");
                }
            }
        });


        tbl_lesson_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_lesson_list.rowAtPoint(point);
                tbl_lesson_list.setRowSelectionInterval(selected_row, selected_row);
                setSelect_id(Integer.parseInt(tbl_lesson_list.getValueAt(tbl_lesson_list.getSelectedRow(), 0).toString()));
                text(getSelect_id());


            }
        });
        btn_lesson_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_course_name.setText(null);
                fld_lesson_contents.setText(null);
                txt_lesson_explanation.setText(null);
                fld_lesson_link.setText(null);
                fld_lesson_quizName.setText(null);
                setSelect_id(0);
            }
        });
        btn_lesson_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (getSelect_id() != 0) {
                    if (Helper.confirm("İçeriğe ait Quizlerde silinecektir!")) {
                        Quiz.deleteLessonID(getSelect_id());
                        Educator.delete(select_id);
                        loadLessonModel();
                    } else {
                        Helper.showMsg("Silme işlemi iptal edildi.");
                    }
                } else {
                    Helper.showMsg("Seçiminiz form üzerinde gözükmelidir. Lütfen yeniden seçim yapınız.");
                }

            }
        });

        btn_lesson_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.confirm("İçerik bilgileri güncellenecektir.Onaylıyor musunuz? ")) {
                    if (Educator.update(getSelect_id(), fld_lesson_contents.getText(), txt_lesson_explanation.getText()
                            , fld_lesson_link.getText())) {
                        Helper.showMsg("done");
                        loadLessonModel();

                    }

                } else {
                    Helper.showMsg("Güncelleme işlemi iptal edildi.");
                }
            }
        });
        btn_lesson_new_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EducatorAddGUI add = new EducatorAddGUI();
                add.setUser_id(getUser_id());
                dispose();
            }
        });
        btn_lesson_quizDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuizGUI quiz = new QuizGUI(getUser_id());
                quiz.setLbl_educator_name(getLbl_educator_name());


            }
        });


    }

    protected void text(int select_id) {
        lbl_course_name.setText(Educator.getFetchAll(select_id).getCourse().getName());
        fld_lesson_contents.setText(Educator.getFetchAll(select_id).getContents());
        txt_lesson_explanation.setText(Educator.getFetchAll(select_id).getExplanation());
        fld_lesson_link.setText(Educator.getFetchAll(select_id).getLink());
        if (Quiz.getFetchLessonID(select_id) != null) {
            fld_lesson_quizName.setText(Quiz.getFetchLessonID(select_id).getName());
        }
    }

    private void loadLessonModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_lesson_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Educator obj : Educator.getList(getUser_id())) {
            i = 0;
            row_lesson_list[i++] = obj.getId();
            row_lesson_list[i++] = obj.getPatika().getName();
            row_lesson_list[i++] = obj.getCourse().getName();
            row_lesson_list[i++] = obj.getContents();
            if (Quiz.getFetchLessonID(obj.getId()) != null) {
                row_lesson_list[i++] = Quiz.getFetchLessonID(obj.getId()).getName();
            } else {
                row_lesson_list[i++] = "";
            }

            mdl_lesson_list.addRow(row_lesson_list);
        }
    }

    public void loadLessonModel(ArrayList<Educator> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_lesson_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Educator obj : list) {
            i = 0;
            row_lesson_list[i++] = obj.getId();
            row_lesson_list[i++] = obj.getPatika().getName();
            row_lesson_list[i++] = obj.getCourse().getName();
            row_lesson_list[i++] = obj.getContents();
            if (Quiz.getFetchLessonID(obj.getId()) != null) {
                row_lesson_list[i++] = Quiz.getFetchLessonID(obj.getId()).getName();
            } else {
                row_lesson_list[i++] = "";
            }

            mdl_lesson_list.addRow(row_lesson_list);

        }
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }

    public JLabel getLbl_educator_name() {
        return lbl_educator_name;
    }


    public JLabel getLbl_patika_name() {
        return lbl_patika_name;
    }

    public JLabel getLbl_course_name() {
        return lbl_course_name;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public int getSelect_id() {
        return select_id;
    }

    public void setSelect_id(int select_id) {
        this.select_id = select_id;
    }

    public JTextField getFld_lesson_contents() {
        return fld_lesson_contents;
    }

    public JTabbedPane getTbpnl_Lesson_list() {
        return tbpnl_Lesson_list;
    }

    public void setTbpnl_Lesson_list(JTabbedPane tbpnl_Lesson_list) {
        this.tbpnl_Lesson_list = tbpnl_Lesson_list;
    }

    public JPanel getPnl_contentsList() {
        return pnl_contentsList;
    }

    public void setPnl_contentsList(JPanel pnl_contentsList) {
        this.pnl_contentsList = pnl_contentsList;
    }

}
