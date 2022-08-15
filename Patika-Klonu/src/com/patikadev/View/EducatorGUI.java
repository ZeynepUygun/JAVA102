package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.Educator;
import com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_educator_name;
    private JTabbedPane tb_educator_list;
    private JTable tbl_educator_list;
    private JPanel pnl_educator_list;
    private JTextField fld_sh_courseName;
    private JButton btn_sh_educator;
    private JTextField fld_sh_patikaName;

    private Object[] row_educator_list;
    private DefaultTableModel mdl_educator_list;
    private JPopupMenu educatorMenu;
    private int user_id = 3;
    private int patika_id = 1;

    public EducatorGUI() {

        add(wrapper);
        setSize(600, 400);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        mdl_educator_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1 || column == 2) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

        //educator tablosu.

        Object[] col_educator_list = {"ID", "Patika Adı", "Kurs Adı", "Içerik Adedi"};// Kolon isimleri Object
        // dizisine
        // atılır.
        mdl_educator_list.setColumnIdentifiers(col_educator_list);//tabloya kolon isimleri işlenir.
        row_educator_list = new Object[col_educator_list.length];


        loadEducatorModel();


        tbl_educator_list.setModel(mdl_educator_list);
        tbl_educator_list.getTableHeader().setReorderingAllowed(false);


        // PopMenu
        educatorMenu = new JPopupMenu();
        JMenuItem add_contents_menu = new JMenuItem("İçerik listele");
        educatorMenu.add(add_contents_menu);

        add_contents_menu.addActionListener(e -> {
            int select_id = Integer.parseInt(tbl_educator_list.getValueAt(tbl_educator_list.getSelectedRow(), 0).toString());
            LessonGUI ls = new LessonGUI(Educator.getFetch(select_id));

            ls.getLbl_educator_name().setText("KULLANICI ADI : "+User.getFetch(getUser_id()).getName());//Kullanıcı Adı
            ls.getLbl_course_name().setText("Kurs Adı : "+Educator.getFetch(select_id).getCourse().getName());//Kurs adı
            ls.getLbl_patika_name().setText(Educator.getFetch(select_id).getPatika().getName()+" Patikası");// Patika adı




            ls.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadEducatorModel();
                }
            });

        });
        //PpoMenü dahil ediliyor
        tbl_educator_list.setModel(mdl_educator_list);
        tbl_educator_list.setComponentPopupMenu(educatorMenu);
        tbl_educator_list.getTableHeader().setReorderingAllowed(false);
        //PopMenü dahil edildi

        //Mause dinleniyor tıklama yeri
        tbl_educator_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_educator_list.rowAtPoint(point);
                tbl_educator_list.setRowSelectionInterval(selected_row, selected_row);
            }
        });
        //Mause tıklama yeri dinlendi.

        btn_sh_educator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String course_name = fld_sh_courseName.getText();
                String patika_name = fld_sh_patikaName.getText();

                String query = Educator.searchQuery(course_name, getUser_id(), patika_name);
                loadEducatorModel(Educator.searchUserList(query));
                System.out.println("ok");


            }
        });


    }

    public static void main(String[] args) {
        Helper.setLayout();
        EducatorGUI ed = new EducatorGUI();

    }

    private void loadEducatorModel(ArrayList<Educator> searchUserList) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_educator_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Educator lst : searchUserList) {
            i = 0;

            row_educator_list[i++] = lst.getId();
            row_educator_list[i++] = lst.getPatika().getName();
            row_educator_list[i++] = lst.getCourse().getName();


            mdl_educator_list.addRow(row_educator_list);


        }

    }

    private void loadEducatorModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_educator_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Educator lst : Educator.getList(getUser_id())) {
            i = 0;

            row_educator_list[i++] = lst.getId();
            row_educator_list[i++] = lst.getPatika().getName();
            row_educator_list[i++] = lst.getCourse().getName();


            mdl_educator_list.addRow(row_educator_list);


        }

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

    public int getPatika_id() {
        return patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
    }


}
