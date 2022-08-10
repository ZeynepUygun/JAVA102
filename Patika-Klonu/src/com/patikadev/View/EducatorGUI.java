package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Educator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_educator_name;
    private JTabbedPane tb_educator_list;
    private JTable tbl_educator_list;
    private JPanel pnl_educator_list;
    private JTextField fld_sh_educator;
    private JButton btn_sh_educator;
    private JTabbedPane tabbedPane1;
    private JComboBox cmb_educator_patika;
    private JComboBox cmb_educator_course;
    private JTextField fld_educator_title;
    private JTextField fld_educator_explanation;
    private JTextField fld_educator_youtube;
    private JButton btn_add_content;
    private JPanel pnl_quiz;
    private JTextField fld_quiz_num;
    private JTextField fld_quiz_soru;
    private Object[] row_educator_list;
    private DefaultTableModel mdl_educator_list;
    private int user_id;

    public EducatorGUI() {

        add(wrapper);
        setSize(700, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);


        //educator tablosu.
        mdl_educator_list =new DefaultTableModel(); //Tablo için nesne üretilir.
        Object[] col_educator_list = {"Patika ID", "Eğitim Adı", "Içerik Adedi"};// Kolon isimleri Object dizisine
        // atılır.
        mdl_educator_list.setColumnIdentifiers(col_educator_list);//tabloya kolon isimleri işlenir.
        row_educator_list = new Object[col_educator_list.length];

        loadEducatorModel();

        tbl_educator_list.setModel(mdl_educator_list);
        tbl_educator_list.getTableHeader().setReorderingAllowed(false);

        // ## educator tablosu


        btn_sh_educator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patika_name = fld_sh_educator.getText();


                String query =Educator.searchQuery(patika_name,getUser_id());
                loadEducatorModel(Educator.searchUserList(query));

            }
        });
    }

    public JLabel getLbl_educator_name() {
        return lbl_educator_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public static void main(String[] args) {
        Helper.setLayout();
        EducatorGUI ed = new EducatorGUI();
    }
    private void loadEducatorModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_educator_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Educator lst : Educator.getList(3)) {
            i = 0;

            row_educator_list[i++] = lst.getPatika_id();
            row_educator_list[i++] =lst.getEducations_name();

            mdl_educator_list.addRow(row_educator_list);


        }

    }
    private void loadEducatorModel(ArrayList<Educator> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_educator_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Educator obj : list) {
             i = 0;
            row_educator_list[i++] = obj.getPatika_id();
            row_educator_list[i++] = obj.getEducations_name();

            mdl_educator_list.addRow(row_educator_list);


        }
    }
}
