package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Facility;
import com.patikadev.Model.Hostel;
import com.patikadev.Model.Hotel;
import com.patikadev.Model.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcenteGUI extends JFrame {
    protected String facilityAll;
    private JPanel wrapper;
    private JPanel pnl_acente;
    private JScrollPane scrl_acente;
    private JPanel pnl_information;
    private JLabel lbl_image;
    private JTabbedPane tabbedPane1;
    private JPanel tbpnl_hotel_table;
    private JPanel tbpnl_room_table;
    private JPanel tbpnl_add;
    private JTabbedPane tabbedPane2;
    private JTable tbl_room_list;
    private JScrollPane scrl_hotel_Add;
    private JPanel pnl_hotel_Add;
    private JScrollPane scrl_room_add;
    private JPanel pnl_room_add;
    private JTextField fld_hotel_name;
    private JLabel lbl_hotel_country;
    private JTextField fld_hotel_country;
    private JLabel lbl_hotel_city;
    private JTextField fld_hotel_city;
    private JLabel lbl_hotel_address;
    private JTextField fld_hotel_address;
    private JTextField fld_hotel_email;
    private JLabel lbl_hotel_email;
    private JLabel lbl_hotel_phone;
    private JTextField fld_hotel_phone;
    private JCheckBox chck_carPark;
    private JCheckBox chck_wifi;
    private JLabel lbl_hotel_facility;
    private JCheckBox chck_natatorium;
    private JCheckBox chck_fitness;
    private JCheckBox chck_concierge;
    private JCheckBox chck_spa;
    private JCheckBox chck_roomService;
    private JLabel lbl_hotel_name;
    private JComboBox cmb_hotel_name;
    private JLabel lbl_hotel;
    private JLabel lbl_hostel;
    private JComboBox cmb_hostel;
    private JLabel lbl_room_piece;
    private JTextField fld_room_piece;
    private JTextField fld_bed_count;
    private JLabel lbl_bed_count;
    private JLabel lbl_room_type;
    private JComboBox cmb_room_type;
    private JLabel lbl_firsSeason;
    private JLabel lbl_thenSeason;
    private JTextField textField1;
    private JTextField textField2;
    private JButton btn_room_add;
    private JButton btn_hotel_add;
    private JPanel pnl_edit;
    private JLabel lbl_edit_hotelName;
    private JLabel lbl_edit_hostel_type;
    private JLabel lbl_edit_bedCount;
    private JLabel lbl_edit_roomPiece;
    private JLabel lbl_edit_roomtype;
    private JComboBox cmb_edit_hotelName;
    private JComboBox cmb_edit_hostelType;
    private JTextField fld_edit_bedCount;
    private JComboBox cmb_edit_roomType;
    private JLabel lbl_edit_firstSeason;
    private JLabel lbl_edit_thenSeason;
    private JTextField fld_edit_firstSeason;
    private JTextField fld_edit_thenSeason;
    private JButton btn_edit_update;
    private JScrollPane scrl_hotel_list;
    private JPanel pnl_hotel_list;
    private JTable tbl_hotel_list;
    private JPanel pnl_hotel_search;
    private JLabel lbl_sh_hotelName;
    private JTextField fld_sh_hotelName;
    private JButton btn_sh_hotel;
    private JTextField fld_sh_hotelCity;
    private JLabel lbl_sh_hotelCity;
    private JComboBox cmb_hotel_star;
    private JLabel lbl_hotel_star;
    private DefaultTableModel mdl_hotel_list;
    private Object[] row_hotel_list;
    private DefaultTableModel mdl_room_list;
    private Object[] row_room_list;


    public AcenteGUI() {
        add(wrapper);
        setSize(900, 1000);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.project_title);
        setVisible(true);

        //Combobox'lara veriler atılır.
        for (Hostel obj : Hostel.getList()) {

            cmb_hostel.addItem(obj.getType());
            cmb_edit_hostelType.addItem(obj.getType());
        }
        for (Hotel obj : Hotel.getList()) {
            cmb_edit_hotelName.addItem(obj.getName());
            cmb_hotel_name.addItem(obj.getName());
        }
        //**********************************************

        //Tablo kolonlarının düzenlenmesi engellenir.
        mdl_hotel_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        mdl_room_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

        //***********************************************
        //Otel tablosu için kolon isimleri verilir.
        Object[] col_hotel_list = {"ID", "Otel Adı", "Bölge", "Şehir", "Telefon", "Yıldız"};
        mdl_hotel_list.setColumnIdentifiers(col_hotel_list);
        row_hotel_list = new Object[col_hotel_list.length];

        loadHotelModel();

        tbl_hotel_list.setModel(mdl_hotel_list);
        tbl_hotel_list.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_hotel_list.getTableHeader().setReorderingAllowed(false);

        //***********************************************
        //Oda tablosu için kolon isimleri verilir.
        Object[] col_room_list = {"ID", "Pansiyon Tipi", "Stok", "Tipi", "Ocak-Mayıs (TL)", "Nisan-Aralik (TL)"};
        mdl_room_list.setColumnIdentifiers(col_room_list);
        row_room_list = new Object[col_room_list.length];

        loadRoomModel();

        tbl_room_list.setModel(mdl_room_list);
        tbl_room_list.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_room_list.getTableHeader().setReorderingAllowed(false);
        //***********************************************
        btn_hotel_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chckbox();

                if (Helper.isFieldEmpty(fld_hotel_name) ||
                        Helper.isFieldEmpty(fld_hotel_country) ||
                        Helper.isFieldEmpty(fld_hotel_city) ||
                        Helper.isFieldEmpty(fld_hotel_address) ||
                        Helper.isFieldEmpty(fld_hotel_email) ||
                        Helper.isFieldEmpty(fld_hotel_phone) ||
                        facilityAll.isEmpty() ||
                        cmb_hotel_star.getSelectedItem()=="")
                {

                    Helper.showMsg("empty");

                }else {
                    System.out.println("girdi");
                    String name=fld_hotel_name.getText().trim().toUpperCase();
                    String country=fld_hotel_country.getText().trim().toUpperCase();
                    String city =fld_hotel_city.getText().trim().toUpperCase();
                    String address="";
                    String[] addressEdit=fld_hotel_address.getText().trim().split(" ");
                    for(int i=0;i<addressEdit.length;i++){

                        addressEdit[i]=addressEdit[i].substring(0,1).toUpperCase()+addressEdit[i].substring(1).toLowerCase()+" ";
                        address=address.concat(addressEdit[i]);
                    }
                    System.out.println(address+"  "+addressEdit.toString());

                    String e_mail=fld_hotel_email.getText().trim();
                    String phone=fld_hotel_phone.getText().trim();

                    int star= Integer.parseInt(cmb_hotel_star.getSelectedItem().toString());
                    if(Helper.confirm("sure")){
                        if(Hotel.add(name,country,city,address,e_mail,phone,facilityAll,star)){
                            Helper.showMsg("done");
                            loadHotelModel();

                        }
                    }else {
                        Helper.showMsg("Ekleme işlemi iptal edildi.");
                    }

                }


            }

        });
        //************************************************


    }

    public static void main(String[] args) {
        Helper.setLayout();
        AcenteGUI acente = new AcenteGUI();
    }

    public void loadHotelModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_hotel_list.getModel();
        clearModel.setRowCount(0);

        int i;
        for (Hotel obj : Hotel.getList()) {
            i = 0;
            row_hotel_list[i++] = obj.getId();
            row_hotel_list[i++] = obj.getName();
            row_hotel_list[i++] = obj.getCountry();
            row_hotel_list[i++] = obj.getCity();
            row_hotel_list[i++] = obj.getPhone();
            row_hotel_list[i++] = obj.getStar();

            mdl_hotel_list.addRow(row_hotel_list);
        }


    }

    public void loadRoomModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_room_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Room obj : Room.getList()) {
            i = 0;
            row_room_list[i++] = obj.getId();
            row_room_list[i++] = obj.getHostel().getType();
            row_room_list[i++] = obj.getPiece();
            row_room_list[i++] = obj.getType();
            row_room_list[i++] = obj.getFirstSeason();
            row_room_list[i++] = obj.getThenSeason();

            mdl_room_list.addRow(row_room_list);
        }
    }

    //Checkbox işlemleri.
    public void chckbox() {
        facilityAll = "";
        if (chck_carPark.isSelected()) {
            int id = Facility.getFetch(chck_carPark.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (chck_wifi.isSelected()) {
            int id = Facility.getFetch(chck_wifi.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (chck_natatorium.isSelected()) {
            int id = Facility.getFetch(chck_natatorium.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (chck_fitness.isSelected()) {
            int id = Facility.getFetch(chck_fitness.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (chck_concierge.isSelected()) {
            int id = Facility.getFetch(chck_concierge.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (chck_spa.isSelected()) {
            int id = Facility.getFetch(chck_spa.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        if (chck_roomService.isSelected()) {
            int id = Facility.getFetch(chck_roomService.getText()).getId();
            facilityAll = facilityAll + Integer.valueOf(id);
        }
        facilityAll = facilityAll.trim();

    }
    //************************************************


}
