package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.MyDateChooser;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class AcenteGUI extends JFrame {
    private final DefaultTableModel mdl_hotel_list;
    private final Object[] row_hotel_list;
    private final DefaultTableModel mdl_room_list;
    private final Object[] row_room_list;
    private final DefaultTableModel mdl_resevation_list;
    private final Object[] row_reservation_list;
    private final Object[] row_reservation_list_YES;
    protected int[] facilityAll;
    private DefaultTableModel mdl_resevation_list_Yes;
    private JPanel wrapper;
    private JPanel pnl_acente;
    private JScrollPane scrl_acente;
    private JPanel pnl_information;
    private JLabel lbl_image;
    private JTabbedPane tbpnl_reservation;
    private JPanel pnl_hotel_table;
    private JPanel pnl_room_table;
    private JTable tbl_room_list;
    private JScrollPane scrl_hotel_Add;
    private JPanel pnl_hotel_Add;
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
    private JComboBox<String> cmb_hotel_name;
    private JLabel lbl_hotel;
    private JLabel lbl_hostel;
    private JComboBox<String> cmb_hostel;
    private JLabel lbl_room_piece;
    private JTextField fld_room_piece;
    private JTextField fld_bed_count;
    private JLabel lbl_bed_count;
    private JLabel lbl_room_type;
    private JComboBox cmb_room_type;
    private JLabel lbl_firsSeason;
    private JLabel lbl_thenSeason;
    private JTextField fld_roo_thenSeason;
    private JTextField fld_room_firstSeason;
    private JButton btn_room_add;
    private JButton btn_hotel_add;
    private JPanel pnl_room_update;
    private JLabel lbl_edit_hotelName;
    private JLabel lbl_edit_hostel_type;
    private JLabel lbl_edit_bedCount;
    private JLabel lbl_edit_roomPiece;
    private JLabel lbl_edit_roomtype;

    private JComboBox<String> cmb_update_roomhostel;
    private JTextField fld_update_roombed;
    private JComboBox cmb_update_roomType;
    private JLabel lbl_edit_firstSeason;
    private JLabel lbl_edit_thenSeason;
    private JTextField fld_update_roomfirstSeason;
    private JTextField fld_update_roomthenSeason;
    private JButton btn_update_room;
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
    private JLabel lbl_update_hoteName;
    private JTextField fld_update_hotelName;
    private JLabel lbl_update_hotelCountry;
    private JTextField fld_update_hotelCountry;
    private JLabel lbl_update_hotelCity;
    private JTextField fld_update_hotelCity;
    private JLabel lbl_update_hotelAddress;
    private JTextField fld_update_hotelAddress;
    private JLabel lbl_update_hotelEmail;
    private JTextField fld_update_hotelEmail;
    private JLabel lbl_update_hotelPhone;
    private JTextField fld_update_hotelPhone;
    private JLabel lbl_update_hotelStar;
    private JComboBox cmb_update_hotelStar;
    private JLabel lbl_update_facility;
    private JCheckBox chck_update_carPark;
    private JCheckBox chck_update_wifi;
    private JCheckBox chck_update_fitnessCenter;
    private JCheckBox chck_update_natatorium;
    private JCheckBox chck_update_hotelConcierge;
    private JCheckBox chck_update_spa;
    private JCheckBox chck_update_roomService;
    private JButton btn_update_hotel;
    private JPanel pnl_update_hotel;
    private JPanel pnl_update_button;
    private JButton btn_update_exit;
    private JButton btn_update_hotelShow;
    private JButton btn_update_roomShow;
    private JTextField fld_update_roomPiece;
    private JComboBox<String> cmb_update_roomhotel;
    private JScrollPane scrl_room_list;
    private JPanel pnl_sh_room;
    private JPanel pnl_reservation;
    private JLabel lbl_sh_reservationName;
    private JTextField fld_sh_reservationName;
    private JLabel lbl_sh_adult;
    private JLabel lbl_sh_child;
    private JLabel lbl_sh_inputDate;
    private JTextField fld_sh_inputDate;
    private JLabel lbl_sh_outDate;
    private JTextField fld_sh_outDate;
    private JButton btn_sh_rezervation;
    private JPanel pnl_menu;
    private JButton btn_hotel;
    private JButton btn_room;
    private JButton btn_reservation;
    private JTabbedPane tbpnl_hotel;
    private JTabbedPane tbpnl_room;
    private JTable tbl_rezervation_list;
    private JButton btn_inputDate;
    private JButton btn_outDate;
    private JPanel pnl_sh_reservation;
    private JPanel pnl_rezervation_information;
    private JLabel lbl_rezervation_hotelName;
    private JLabel lbl_rezervation_hotelName_information;
    private JLabel lbl_rezervation_address;
    private JLabel lbl_rezervation_address_information;
    private JLabel lbl_rezervation_email;
    private JLabel lbl_rezervation_email_information;
    private JLabel lbl_rezervation_phone;
    private JLabel lbl_rezervation_phone_information;
    private JLabel lbl_rezervation_star;
    private JLabel lbl_rezervation_star_information;
    private JLabel lbl_rezervation_hostel;
    private JLabel lbl_rezervation_hostel_information;
    private JLabel lbl_rezervation_facility;
    private JLabel lbl_rezervation_facility_information;
    private JLabel lbl_rezervation_bed;
    private JLabel lbl_rezervation_bed_information;
    private JLabel lbl_rezervation_roomType;
    private JLabel lbl_rezervation_roomType_information;
    private JButton btn_addRezervasyon;
    private JPanel pnl_customer_add;
    private JTextField fld_customer_phone;
    private JTextField fld_customer_nameSurname;
    private JTextField fld_customer_mail;
    private JTextField fld_customer_note;
    private JPanel pnl_cutomerChild_1;
    private JTextField customer_name3;
    private JTextField customer_surname3;
    private JTextField customer_uyruk3;
    private JTextField customer_kimlik3;
    private JPanel pnl_cutomerChild_2;
    private JTextField customer_name4;
    private JTextField customer_surname4;
    private JTextField customer_uyruk4;
    private JTextField customer_kimlik4;
    private JPanel pnl_cutomerAdult_1;
    private JTextField customer_name1;
    private JTextField customer_surname1;
    private JTextField customer_uyruk1;
    private JTextField customer_kimlik1;
    private JPanel pnl_cutomerAdult_2;
    private JTextField customer_name2;
    private JTextField customer_surname2;
    private JTextField customer_uyruk2;
    private JTextField customer_kimlik2;
    private JButton btn_customer_add;
    private JComboBox cmb_adult;
    private JComboBox cmb_child;
    private JPanel pnl_reservation_room;
    private JScrollPane scrl_reservation_room;
    private JTable tbl_reservation_room;
    private JPanel pnl_change;
    private JButton btn_out;
    private JPanel pnl_communation_inf;
    private JLabel lbl_communation_phone;
    private JLabel lbl_communation_email;

    private JLabel lbl_communation_name;
    private JButton btn_communition_inf;
    private JPanel pnl_friend;
    private JScrollPane scrl_friend;
    private JTable tbl_friend;
    private final Object[] row_friend_list;
    private final DefaultTableModel mdl_friend_list;
    private int selected_hotelID;
    private int selected_roomID;
    private Date last_date;
    private int rezervation_room = 0;
    private int reservation_id;


    public AcenteGUI() {
        add(wrapper);
        setSize(900, 1000);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.project_title);
        setVisible(true);


        cmbAddItem();
        JCheckBox[] chck_update_facility = {chck_update_carPark, chck_update_wifi, chck_update_natatorium,
                chck_update_fitnessCenter,
                chck_update_hotelConcierge, chck_update_spa, chck_update_roomService};

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
        mdl_resevation_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        mdl_resevation_list_Yes = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        mdl_friend_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {

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
        Object[] col_room_list = {"ID", "Otel", "Pansiyon Tipi", "Stok", "Tipi", "Ocak-Mayıs (TL)", "Nisan-Aralik (TL)"};
        mdl_room_list.setColumnIdentifiers(col_room_list);
        row_room_list = new Object[col_room_list.length];

        loadRoomModel();

        tbl_room_list.setModel(mdl_room_list);
        tbl_room_list.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_room_list.getColumnModel().getColumn(1).setMaxWidth(50);
        tbl_room_list.getTableHeader().setReorderingAllowed(false);
        //***********************************************
        //Reservation tablosu (boş odalar için) için kolon isimleri verilir.
        Object[] col_reservation_list = {"ID", "Otel", "Pansiyon Tipi", "Kalan Stok", "Tipi", "Ocak-Mayıs (TL)",
                "Nisan" +
                        "-Aralik (TL)"};
        mdl_resevation_list.setColumnIdentifiers(col_reservation_list);
        row_reservation_list = new Object[col_reservation_list.length];


        tbl_rezervation_list.setModel(mdl_resevation_list);
        tbl_rezervation_list.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_rezervation_list.getColumnModel().getColumn(1).setMaxWidth(50);
        tbl_rezervation_list.getTableHeader().setReorderingAllowed(false);
        //***********************************************
        //Reservation tablosu (reserve odalar için) için kolon isimleri verilir.


        Object[] col_reservation_list_YES = {"ID", "Müşteri ismi",
                "Yetişkin Sayısı", "Çocuk Sayısı", "Giriş Tarihi", "Çıkış Tarihi", "Rezervasyon No"};
        mdl_resevation_list_Yes.setColumnIdentifiers(col_reservation_list_YES);
        row_reservation_list_YES = new Object[col_reservation_list_YES.length];

        reservationRoom();

        tbl_reservation_room.setModel(mdl_resevation_list_Yes);
        tbl_reservation_room.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_reservation_room.getTableHeader().setReorderingAllowed(false);
        //***********************************************
        Object[] col_friend_list = {"Adı", "Soyadı", "Kimlik", "Uyruk"};
        mdl_friend_list.setColumnIdentifiers(col_friend_list);
        row_friend_list = new Object[col_friend_list.length];


        tbl_friend.setModel(mdl_friend_list);
        tbl_friend.getTableHeader().setReorderingAllowed(false);
        //***********************************************

        //Otel tablosu mause dinleme.
        tbl_hotel_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Hotel.dataPanelClear(fld_update_hotelName, fld_update_hotelCountry, fld_update_hotelCity,
                        fld_update_hotelAddress, fld_update_hotelEmail
                        , fld_update_hotelPhone, cmb_update_hotelStar, chck_update_facility[0], chck_update_facility[1], chck_update_facility[2],
                        chck_update_facility[3],
                        chck_update_facility[4], chck_update_facility[5], chck_update_facility[6]);
                if (pnl_update_hotel.isVisible()) {
                    Point point = e.getPoint();
                    int selected_hotel_row = tbl_hotel_list.rowAtPoint(point);
                    tbl_hotel_list.setRowSelectionInterval(selected_hotel_row, selected_hotel_row);
                    setSelected_hotelID(Integer.parseInt(tbl_hotel_list.getValueAt(tbl_hotel_list.getSelectedRow(), 0).toString()));

                    Hotel hotel = Hotel.getFetch(getSelected_hotelID());
                    fld_update_hotelName.setText(hotel.getName());
                    fld_update_hotelCountry.setText(hotel.getCountry());
                    fld_update_hotelCity.setText(hotel.getCity());
                    fld_update_hotelAddress.setText(hotel.getAddress());
                    fld_update_hotelEmail.setText(hotel.getE_mail());
                    fld_update_hotelPhone.setText(hotel.getPhone());
                    cmb_update_hotelStar.setSelectedIndex(hotel.getStar());


                    for (int i = 0; i < hotel.getFacilitys().length(); i++) {
                        int id = Integer.parseInt(String.valueOf(hotel.getFacilitys().charAt(i)));
                        chck_update_facility[id - 1].setSelected(true);


                    }


                }
            }
        });
        //***********************************************
        //Oda tablosu mause dinleme.
        tbl_room_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (pnl_room_update.isVisible()) {

                    Point point = e.getPoint();
                    int selected_room_row = tbl_room_list.rowAtPoint(point);
                    tbl_room_list.setRowSelectionInterval(selected_room_row, selected_room_row);
                    setSelected_roomID(Integer.parseInt(tbl_room_list.getValueAt(tbl_room_list.getSelectedRow(), 0).toString()));

                    Room room = Room.getFetch(getSelected_roomID());
                    cmb_update_roomhotel.setSelectedItem(Hotel.getFetch(room.getHotel_id()).getName());
                    cmb_update_roomhostel.setSelectedItem(Hostel.getFetch(room.getHostel_id()).getType());
                    fld_update_roombed.setText(String.valueOf(room.getBed()));
                    fld_update_roomPiece.setText(String.valueOf(room.getPiece()));
                    cmb_update_roomType.setSelectedItem(room.getType());
                    fld_update_roomfirstSeason.setText(String.valueOf(room.getFirstSeason()));
                    fld_update_roomthenSeason.setText(String.valueOf(room.getThenSeason()));
                }


            }
        });
        //**********************************************************************
        tbl_reservation_room.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (pnl_communation_inf.isVisible()) {

                    Point point = e.getPoint();
                    int selected_row = tbl_reservation_room.rowAtPoint(point);
                    tbl_reservation_room.setRowSelectionInterval(selected_row, selected_row);
                    setReservation_id(Integer.parseInt(tbl_reservation_room.getValueAt(tbl_reservation_room.getSelectedRow(),
                            0).toString()));


                    Communication communication =
                            Communication.getFetchID(Reservation.getFetch(getReservation_id()).getCommunication_id());
                    lbl_communation_phone.setText(communication.getPhone());
                    lbl_communation_email.setText(communication.getE_mail());
                    lbl_communation_name.setText(communication.getName_surname());
                   loadFriend(getReservation_id());


                }


            }
        });
        tbl_rezervation_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_room_row = tbl_rezervation_list.rowAtPoint(point);
                tbl_rezervation_list.setRowSelectionInterval(selected_room_row, selected_room_row);
                setRezervation_room(Integer.parseInt(tbl_rezervation_list.getValueAt(tbl_rezervation_list.getSelectedRow(), 0).toString()));

                Room room = Room.getFetch(getRezervation_room());

                lbl_rezervation_hotelName_information.setText(room.getHotel().getName());
                lbl_rezervation_star_information.setText(String.valueOf(room.getHotel().getStar()));
                lbl_rezervation_email_information.setText(room.getHotel().getE_mail());
                lbl_rezervation_phone_information.setText(room.getHotel().getPhone());
                lbl_rezervation_address_information.setText(room.getHotel().getAddress());


                lbl_rezervation_facility_information.setText(room.getHotel().getAllFacilitiy());

                lbl_rezervation_hostel_information.setText(room.getHostel().getType());
                lbl_rezervation_bed_information.setText(String.valueOf(room.getBed()));
                lbl_rezervation_roomType_information.setText(room.getType());


            }
        });

        //***********************************************
        btn_hotel_add.addActionListener(e -> {

            facilityAll = Hotel.facility(chck_carPark, chck_wifi, chck_natatorium, chck_fitness, chck_concierge,
                    chck_spa,
                    chck_roomService);

            if (Helper.isFieldEmpty(fld_hotel_name) ||
                    Helper.isFieldEmpty(fld_hotel_country) ||
                    Helper.isFieldEmpty(fld_hotel_city) ||
                    Helper.isFieldEmpty(fld_hotel_address) ||
                    Helper.isFieldEmpty(fld_hotel_email) ||
                    Helper.isFieldEmpty(fld_hotel_phone) ||
                    facilityAll == null ||
                    (cmb_hotel_star.getSelectedItem() == "")) {

                Helper.showMsg("empty");

            } else {

                String otel_name = fld_hotel_name.getText();
                String country = fld_hotel_country.getText();
                String city = fld_hotel_city.getText();
                String address = fld_hotel_address.getText();
                String email = fld_hotel_email.getText();
                String phone = fld_hotel_phone.getText();
                String facility = Hotel.facility(facilityAll);
                int star = cmb_hotel_star.getSelectedIndex();

                Hotel otel = new Hotel();
                otel.dataPanel(fld_hotel_name, fld_hotel_country, fld_hotel_city, fld_hotel_address,
                        fld_hotel_email
                        , fld_hotel_phone, cmb_hotel_star);

                if (Helper.confirm("sure")) {

                    if (Hotel.add(otel_name, country, city, address, email, phone, facility, star)) {
                        Helper.showMsg("done");
                        cmb_hotel_name.addItem(otel_name);

                        Hotel.dataPanelClear(fld_hotel_name, fld_hotel_country, fld_hotel_city, fld_hotel_address, fld_hotel_email
                                , fld_hotel_phone, cmb_hotel_star, chck_carPark, chck_wifi, chck_natatorium, chck_fitness, chck_concierge, chck_spa,
                                chck_roomService);

                        loadHotelModel();

                    }
                } else {
                    Helper.showMsg("Ekleme işlemi iptal edildi.");
                }

            }


        });
        btn_update_hotel.addActionListener(e -> {

            facilityAll = Hotel.facility(chck_update_facility[0], chck_update_facility[1], chck_update_facility[2],
                    chck_update_facility[3],
                    chck_update_facility[4], chck_update_facility[5], chck_update_facility[6]);

            if (Helper.isFieldEmpty(fld_update_hotelName) ||
                    Helper.isFieldEmpty(fld_update_hotelCountry) ||
                    Helper.isFieldEmpty(fld_update_hotelCity) ||
                    Helper.isFieldEmpty(fld_update_hotelAddress) ||
                    Helper.isFieldEmpty(fld_update_hotelEmail) ||
                    Helper.isFieldEmpty(fld_update_hotelPhone) ||
                    facilityAll == null ||
                    cmb_update_hotelStar.getSelectedItem() == "") {
                Helper.showMsg("empty");
            } else {
                int otel_id = getSelected_hotelID();
                String otel_name = fld_update_hotelName.getText();
                String country = fld_update_hotelCountry.getText();
                String city = fld_update_hotelCity.getText();
                String address = fld_update_hotelAddress.getText();
                String email = fld_update_hotelEmail.getText();
                String phone = fld_update_hotelPhone.getText();
                String facility = Hotel.facility(facilityAll);
                int star = cmb_update_hotelStar.getSelectedIndex();

                Hotel otel = new Hotel();
                otel.dataPanel(fld_update_hotelName, fld_update_hotelCountry, fld_update_hotelCity,
                        fld_update_hotelAddress, fld_update_hotelEmail, fld_update_hotelPhone,
                        cmb_update_hotelStar);


                if (Helper.confirm("sure")) {


                    if (Hotel.update(otel_id, otel_name, country, city, address, email, phone, facility, star)) {
                        Helper.showMsg("done");


                        pnl_update_hotel.setVisible(false);

                        loadHotelModel();

                    }

                }
            }
        });
        btn_update_hotelShow.addActionListener(e -> {
            if (pnl_update_hotel.isVisible()) {
                pnl_update_hotel.setVisible(false);
            } else {
                Helper.showMsg("Tablodan güncellenecek veriyi seçiniz.");

                Hotel.dataPanelClear(fld_update_hotelName, fld_update_hotelCountry, fld_update_hotelCity,
                        fld_update_hotelAddress, fld_update_hotelEmail
                        , fld_update_hotelPhone, cmb_update_hotelStar, chck_update_facility[0], chck_update_facility[1], chck_update_facility[2],
                        chck_update_facility[3],

                        chck_update_facility[4], chck_update_facility[5], chck_update_facility[6]);
                pnl_update_hotel.setVisible(true);
            }
        });

        btn_room_add.addActionListener(e -> {
            if (cmb_hotel_name.getSelectedIndex() == 0 ||
                    cmb_hostel.getSelectedIndex() == 0 ||
                    Helper.isFieldEmpty(fld_bed_count) ||
                    Helper.isFieldEmpty(fld_room_piece) ||
                    cmb_room_type.getSelectedIndex() == 0 ||
                    Helper.isFieldEmpty(fld_room_firstSeason) ||
                    Helper.isFieldEmpty(fld_roo_thenSeason)
            ) {
                Helper.showMsg("empty");
            } else {
                if (Helper.confirm("sure")) {
                    int hotel_id = Hotel.getFetch(Objects.requireNonNull(cmb_hotel_name.getSelectedItem()).toString()).getId();
                    int hostel_id = Hostel.getFetch(Objects.requireNonNull(cmb_hostel.getSelectedItem()).toString()).getId();
                    int bed = Integer.parseInt(fld_bed_count.getText());
                    int piece = Integer.parseInt(fld_room_piece.getText());
                    int first = Integer.parseInt(fld_room_firstSeason.getText());
                    int then = Integer.parseInt(fld_roo_thenSeason.getText());
                    System.out.println(first);
                    if (Room.add(hotel_id, hostel_id, bed, piece, Objects.requireNonNull(cmb_room_type.getSelectedItem()).toString(), first, then)) {
                        Helper.showMsg("done");
                        loadRoomModel();
                        pnl_room_table.setVisible(true);
                    }
                }


            }
        });
        btn_update_room.addActionListener(e -> {
            if (cmb_update_roomhotel.getSelectedIndex() == 0 ||
                    cmb_update_roomhostel.getSelectedIndex() == 0 ||
                    Helper.isFieldEmpty(fld_update_roombed) ||
                    Helper.isFieldEmpty(fld_update_roomPiece) ||
                    cmb_update_roomType.getSelectedIndex() == 0 ||
                    Helper.isFieldEmpty(fld_update_roomfirstSeason) ||
                    Helper.isFieldEmpty(fld_update_roomthenSeason)
            ) {
                Helper.showMsg("empty");
            } else {
                if (Helper.confirm("sure")) {
                    int hotel_id = Hotel.getFetch(Objects.requireNonNull(cmb_update_roomhotel.getSelectedItem()).toString()).getId();
                    int hostel_id = Hostel.getFetch(Objects.requireNonNull(cmb_update_roomhostel.getSelectedItem()).toString()).getId();
                    int bed = Integer.parseInt(fld_update_roombed.getText());
                    int piece = Integer.parseInt(fld_update_roomPiece.getText());
                    String type = Objects.requireNonNull(cmb_update_roomType.getSelectedItem()).toString();
                    int firstSeason = Integer.parseInt(fld_update_roomfirstSeason.getText());
                    int thenSeason = Integer.parseInt(fld_update_roomthenSeason.getText());
                    if (Room.update(getSelected_roomID(), hotel_id, hostel_id, bed, piece, type, firstSeason, thenSeason)) {
                        Helper.showMsg("done");
                        loadRoomModel();


                        pnl_room_update.setVisible(false);
                    } else {
                        Helper.showMsg("İstenmeyen bir hata oluştu.");
                    }
                } else {
                    Helper.showMsg("iptal");
                }
            }
        });
        btn_update_roomShow.addActionListener(e -> {
            if (pnl_room_update.isVisible()) {
                pnl_room_update.setVisible(false);
            } else {
                Helper.showMsg("Tablodan güncellenecek veriyi seçiniz.");
                Room.pnlRoomClear(cmb_update_roomhotel, cmb_update_roomhostel, fld_update_roombed,
                        fld_update_roomPiece, cmb_update_roomType, fld_update_roomfirstSeason, fld_update_roomthenSeason);
                pnl_room_update.setVisible(true);

            }
        });
        btn_hotel.addActionListener(e -> {
            if (!tbpnl_hotel.isVisible()) {
                tbpnl_reservation.setVisible(false);
                pnl_rezervation_information.setVisible(false);
                tbpnl_room.setVisible(false);
                tbpnl_hotel.setVisible(true);


            }
        });
        btn_room.addActionListener(e -> {
            if (!tbpnl_room.isVisible()) {
                tbpnl_hotel.setVisible(false);
                tbpnl_reservation.setVisible(false);
                pnl_rezervation_information.setVisible(false);
                tbpnl_room.setVisible(true);
            }
        });
        btn_reservation.addActionListener(e -> {
            if (!tbpnl_reservation.isVisible()) {
                tbpnl_hotel.setVisible(false);
                tbpnl_room.setVisible(false);
                tbpnl_reservation.setVisible(true);
                pnl_rezervation_information.setVisible(true);
            }
        });
        fld_sh_inputDate.addActionListener(e -> {


        });
        btn_inputDate.addActionListener(e -> {

            MyDateChooser ch = new MyDateChooser(new JFrame(), 0, 10);


            Date now = new Date();
            Date select;
            select = ch.select();
            if (select != null) {
                last_date = new Date(select.getTime());

                if (now.getTime() > last_date.getTime()) {
                    Helper.showMsg("Gelecek zamana ait tarih bilgisi girmelisiniz!");

                } else {
                    fld_sh_inputDate.setText(ch.getSelectedDay() + "." + ch.getSelectedMonth() + "." + ch.getSelectedYear());
                }

            }
        });
        btn_outDate.addActionListener(e -> {

            if (Objects.equals(fld_sh_inputDate.getText(), " Tarih Seçiniz.    ")) {
                Helper.showMsg("Önce giriş tarihini seçiniz!");
            } else {
                MyDateChooser ch = new MyDateChooser(new JFrame(), 10, 10);
                if (last_date.getTime() > ch.select().getTime()) {
                    Helper.showMsg("Gelecek zamana ait tarih bilgisi girmelisiniz!");

                } else {
                    fld_sh_outDate.setText(ch.getSelectedDay() + "." + ch.getSelectedMonth() + "." + ch.getSelectedYear());
                }
            }
        });
        btn_addRezervasyon.addActionListener(e -> {
            if (Objects.equals(fld_sh_inputDate.getText(), "Tarih Seçiniz.    ") || Objects.equals(fld_sh_outDate.getText(), "Tarih Seçiniz.    ") || getRezervation_room() == 0) {
                if (getRezervation_room() == 0) {
                    Helper.showMsg("Lütfen listeden seçim yapınız!");
                } else {
                    Helper.showMsg("empty");
                }
            } else {
                if (lbl_rezervation_hotelName_information.getText() == "") {
                    Helper.showMsg("Lütfen listeden seçim yapını!");
                } else {

                    if (cmb_adult.getSelectedIndex() == 0) {
                        Helper.showMsg("En az 1 yetişkin olmalıdır!");
                    } else {
                        pnl_customer_add.setVisible(true);
                        pnl_cutomerAdult_1.setVisible(true);

                        if (cmb_adult.getSelectedIndex() == 2) {
                            pnl_cutomerAdult_2.setVisible(true);
                        }
                        if (cmb_child.getSelectedIndex() == 1) {
                            pnl_cutomerChild_1.setVisible(true);
                        }
                        if (cmb_child.getSelectedIndex() == 2) {
                            pnl_cutomerChild_1.setVisible(true);
                            pnl_cutomerChild_2.setVisible(true);
                        }


                    }

                }

            }
        });

        btn_sh_rezervation.addActionListener(e -> {

            System.out.println(fld_sh_inputDate.getText());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            Date inputDate;
            Date outDate;
            try {
                inputDate = simpleDateFormat.parse(fld_sh_inputDate.getText());
                outDate = simpleDateFormat.parse(fld_sh_outDate.getText());
                loadReservationModel(inputDate, outDate);
            } catch (ParseException k) {
                throw new RuntimeException(k);
            }


        });
        btn_customer_add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_customer_nameSurname) ||
                        Helper.isFieldEmpty(fld_customer_phone) ||
                        Helper.isFieldEmpty(fld_customer_mail)) {
                    Helper.showMsg("empty");
                } else if (Helper.isFieldEmpty(customer_name1) ||
                        Helper.isFieldEmpty(customer_surname1) ||
                        Helper.isFieldEmpty(customer_uyruk1) ||
                        customer_kimlik1.getText() == "Kimlik/Pasaport") {
                    Helper.showMsg("empty");
                } else if (pnl_cutomerAdult_2.isVisible() && (
                        Helper.isFieldEmpty(customer_name2) ||
                                Helper.isFieldEmpty(customer_surname2) ||
                                Helper.isFieldEmpty(customer_uyruk2) ||
                                customer_kimlik2.getText() == "Kimlik/Pasaport")) {

                    Helper.showMsg("empty");
                } else if (pnl_cutomerChild_1.isVisible() && (
                        Helper.isFieldEmpty(customer_name3) ||
                                Helper.isFieldEmpty(customer_surname3) ||
                                Helper.isFieldEmpty(customer_uyruk3) ||
                                customer_kimlik3.getText() == "Kimlik/Pasaport")) {

                    Helper.showMsg("empty");
                } else if (pnl_cutomerChild_2.isVisible() && (
                        Helper.isFieldEmpty(customer_name4) ||
                                Helper.isFieldEmpty(customer_surname4) ||
                                Helper.isFieldEmpty(customer_uyruk4) ||
                                customer_kimlik4.getText() == "Kimlik/Pasaport")) {

                    Helper.showMsg("empty");
                } else {

                    if (Communication.add(fld_customer_nameSurname.getText(), fld_customer_mail.getText(),
                            fld_customer_phone.getText(), fld_customer_note.getText())) {

                        int communication_id = Communication.getFetch(fld_customer_nameSurname.getText(), fld_customer_mail.getText(),
                                fld_customer_phone.getText(), fld_customer_note.getText()).getId();

                        if (Reservation.add(getRezervation_room(), "YES", fld_sh_inputDate.getText(),
                                fld_sh_outDate.getText(), cmb_child.getSelectedIndex(),
                                cmb_adult.getSelectedIndex(), communication_id)) {

                            if (pnl_cutomerAdult_1.isVisible()) {
                                if (Customer.add(customer_name1.getText(), customer_surname1.getText(),
                                        Reservation.getFetchCommunation(communication_id).getId(), customer_uyruk1.getText(),
                                        customer_kimlik1.getText())) {

                                }
                            }
                            if (pnl_cutomerAdult_2.isVisible()) {
                                if (Customer.add(customer_name2.getText(), customer_surname2.getText(),
                                        Reservation.getFetchCommunation(communication_id).getId(),
                                        customer_uyruk2.getText(),
                                        customer_kimlik2.getText())) {

                                }
                            }
                            if (pnl_cutomerChild_1.isVisible()) {
                                if (Customer.add(customer_name3.getText(), customer_surname3.getText(),
                                        Reservation.getFetchCommunation(communication_id).getId(),
                                        customer_uyruk3.getText(),
                                        customer_kimlik3.getText())) {

                                }
                            }
                            if (pnl_cutomerChild_2.isVisible()) {
                                if (Customer.add(customer_name4.getText(), customer_surname4.getText(),
                                        Reservation.getFetchCommunation(communication_id).getId(),
                                        customer_uyruk4.getText(),
                                        customer_kimlik4.getText())) {

                                }
                            }
                            Helper.showMsg("Rezervasyon işlemi tamamlandı.");
                        }


                    }


                }


            }
        });
        btn_communition_inf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pnl_communation_inf.isVisible()) {
                    pnl_communation_inf.setVisible(false);
                } else {
                    pnl_communation_inf.setVisible(true);
                }
            }
        });
        tbpnl_reservation.addMouseListener(new MouseAdapter() {
        });
        tbpnl_reservation.addMouseListener(new MouseAdapter() {
        });
        btn_out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reservation reservation =Reservation.getFetch(getReservation_id());
                if(Reservation.update(getReservation_id(),reservation.getRoom_id(),reservation.getInput(),
                        reservation.getOutput(),reservation.getChild(),reservation.getAdult(),
                        reservation.getCommunication_id())){
                    Helper.showMsg("done");
                    reservationRoom();
                }
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();

        MyDateChooser ch = new MyDateChooser(new JFrame(), 0, 10);
        //ch.select();
        //GregorianCalendar calendar = new GregorianCalendar();
        System.out.println(ch.getSelectedDay());
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

            row_room_list[i++] = obj.getHotel_id();
            row_room_list[i++] = obj.getHostel().getType();
            row_room_list[i++] = obj.getPiece();
            row_room_list[i++] = obj.getType();
            row_room_list[i++] = obj.getFirstSeason();
            row_room_list[i++] = obj.getThenSeason();

            mdl_room_list.addRow(row_room_list);
        }
    }

    public void loadReservationModel(Date input, Date out) throws ParseException {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_rezervation_list.getModel();
        clearModel.setRowCount(0);
        if (Reservation.getList().isEmpty()) {
            loadReservation();

        } else {
            int i;

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");

            Date inputRecord;
            Date outRecord;

            for (Room obj : Room.getList()) {

                if (obj.getPiece() - Reservation.getFetchRemaining(obj.getId()) == 1) {

                    for (Reservation res : Reservation.getList()) {
                        inputRecord = simpleDateFormat.parse(res.getInput());
                        outRecord = simpleDateFormat.parse(res.getOutput());

                        if (inputRecord.getTime() >= input.getTime() && (outRecord.getTime() <= out.getTime())) {
                            System.out.println("girdi");
                        } else {
                            if (obj.getPiece() - Reservation.getFetchRemaining(obj.getId()) == 0) {

                            } else {
                                i = 0;

                                row_reservation_list[i++] = obj.getId();
                                row_reservation_list[i++] = obj.getHotel().getName();
                                row_reservation_list[i++] = obj.getHostel().getType();
                                row_reservation_list[i++] = obj.getPiece() - Reservation.getFetchRemaining(obj.getId());
                                row_reservation_list[i++] = obj.getType();
                                row_reservation_list[i++] = obj.getFirstSeason();
                                row_reservation_list[i++] = obj.getThenSeason();

                                mdl_resevation_list.addRow(row_reservation_list);

                            }

                        }

                    }

                } else {
                    if (obj.getPiece() - Reservation.getFetchRemaining(obj.getId()) == 0) {

                    } else {
                        i = 0;
                        System.out.println(obj.getId() + "girmedi");
                        row_reservation_list[i++] = obj.getId();
                        row_reservation_list[i++] = obj.getHotel().getName();
                        row_reservation_list[i++] = obj.getHostel().getType();
                        row_reservation_list[i++] = obj.getPiece() - Reservation.getFetchRemaining(obj.getId());
                        row_reservation_list[i++] = obj.getType();
                        row_reservation_list[i++] = obj.getFirstSeason();
                        row_reservation_list[i++] = obj.getThenSeason();

                        mdl_resevation_list.addRow(row_reservation_list);
                    }
                }


            }
        }
    }


    public void loadReservation() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_rezervation_list.getModel();
        clearModel.setRowCount(0);

        int i;


        for (Room obj : Room.getList()) {


            i = 0;
            if (obj.getPiece() - Reservation.getFetchRemaining(obj.getId()) != 0) {
                row_reservation_list[i++] = obj.getId();
                row_reservation_list[i++] = obj.getHotel().getName();
                row_reservation_list[i++] = obj.getHostel().getType();
                row_reservation_list[i++] = obj.getPiece() - Reservation.getFetchRemaining(obj.getId());
                row_reservation_list[i++] = obj.getType();
                row_reservation_list[i++] = obj.getFirstSeason();
                row_reservation_list[i++] = obj.getThenSeason();

                mdl_resevation_list.addRow(row_reservation_list);
            }

        }
    }

    public void loadFriend(int reservation_id) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_friend.getModel();
        clearModel.setRowCount(0);

        int i;

        for (Customer obj : Customer.getListReservationID(reservation_id)) {
            i = 0;

            row_friend_list[i++] = obj.getFirstName();
            row_friend_list[i++] = obj.getLastName();
            row_friend_list[i++] = obj.getPasaport();
            row_friend_list[i++] = obj.getUyruk();

            mdl_friend_list.addRow(row_friend_list);
        }

    }

    public void reservationRoom() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_reservation_room.getModel();
        clearModel.setRowCount(0);

        int i;


        for (Reservation obj : Reservation.getList()) {


            i = 0;

            if (Objects.equals(obj.getReservation(), "YES")) {
                row_reservation_list_YES[i++] = obj.getId();
                row_reservation_list_YES[i++] = Communication.getFetchID(obj.getCommunication_id()).getName_surname();
                row_reservation_list_YES[i++] = obj.getAdult();
                row_reservation_list_YES[i++] = obj.getChild();
                row_reservation_list_YES[i++] = obj.getInput();
                row_reservation_list_YES[i++] = obj.getOutput();
                row_reservation_list_YES[i++] = obj.getReservation();


                mdl_resevation_list_Yes.addRow(row_reservation_list_YES);
            }

        }
    }


    //Combobox'lara veriler atılır.
    public void cmbAddItem() {

        for (Hostel obj : Hostel.getList()) {

            cmb_hostel.addItem(obj.getType());
            cmb_update_roomhostel.addItem(obj.getType());
        }
        for (Hotel obj : Hotel.getList()) {
            String name = obj.getName();

            cmb_hotel_name.addItem(name);
            cmb_update_roomhotel.addItem(name);
        }

    }
    //**********************************************


    public int getSelected_hotelID() {
        return selected_hotelID;
    }

    public void setSelected_hotelID(int selected_hotelID) {
        this.selected_hotelID = selected_hotelID;
    }

    public int getSelected_roomID() {
        return selected_roomID;
    }

    public void setSelected_roomID(int selected_roomID) {
        this.selected_roomID = selected_roomID;
    }

    public Date getLast_date() {
        return last_date;
    }

    public void setLast_date(Date last_date) {
        this.last_date = last_date;
    }

    public int getRezervation_room() {
        return rezervation_room;
    }

    public void setRezervation_room(int rezervation_room) {
        this.rezervation_room = rezervation_room;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }
}
