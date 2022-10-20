package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Hostel;
import com.patikadev.Model.Hotel;
import com.patikadev.Model.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AcenteGUI extends JFrame {
    protected int[] facilityAll;
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
    //private JComboBox<String> cmb_update_hotelName;
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
    private JComboBox cmb_update_roomhotel;
    private JScrollPane scrl_room_list;
    private JPanel pnl_sh_room;
    private JPanel pnl_sh_reservation;
    private JLabel lbl_sh_reservationName;
    private JTextField fld_sh_reservationName;
    private JLabel lbl_sh_adult;
    private JTextField fld_sh_adult;
    private JTextField fld_sh_child;
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
    private JScrollPane pnl_reservation_list;
    private DefaultTableModel mdl_hotel_list;
    private Object[] row_hotel_list;
    private DefaultTableModel mdl_room_list;
    private Object[] row_room_list;
    private int selected_hotelID;
    private int selected_roomID;


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
                        int id = Integer.valueOf(String.valueOf(hotel.getFacilitys().charAt(i)));
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

        //***********************************************
        btn_hotel_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                    Hotel otel = new Hotel(getSelected_hotelID(), fld_hotel_name.getText(),
                            fld_hotel_country.getText(),
                            fld_hotel_city.getText(),
                            fld_hotel_address.getText(),
                            fld_hotel_email.getText(),
                            fld_hotel_phone.getText(),
                            Hotel.facility(facilityAll),
                            cmb_hotel_star.getSelectedIndex());

                    otel.dataPanel(fld_hotel_name, fld_hotel_country, fld_hotel_city, fld_hotel_address, fld_hotel_email
                            , fld_hotel_phone, cmb_hotel_star);

                    if (Helper.confirm("sure")) {

                        if (otel.add(otel.getName(), otel.getCountry(), otel.getCity(), otel.getAddress(), otel.getE_mail(),
                                otel.getPhone(),
                                otel.facility(facilityAll), otel.getStar())) {
                            Helper.showMsg("done");
                            cmb_hotel_name.addItem(otel.getName());

                            Hotel.dataPanelClear(fld_hotel_name, fld_hotel_country, fld_hotel_city, fld_hotel_address, fld_hotel_email
                                    , fld_hotel_phone, cmb_hotel_star, chck_carPark, chck_wifi, chck_natatorium, chck_fitness, chck_concierge, chck_spa,
                                    chck_roomService);

                            loadHotelModel();

                        }
                    } else {
                        Helper.showMsg("Ekleme işlemi iptal edildi.");
                    }

                }


            }

        });
        btn_update_hotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                    Hotel otel = new Hotel(getSelected_hotelID(), fld_update_hotelName.getText(),
                            fld_update_hotelCountry.getText(),
                            fld_update_hotelCity.getText(),
                            fld_update_hotelAddress.getText(),
                            fld_update_hotelEmail.getText(),
                            fld_update_hotelPhone.getText(),
                            Hotel.facility(facilityAll),
                            cmb_update_hotelStar.getSelectedIndex());

                    otel.dataPanel(fld_update_hotelName, fld_update_hotelCountry, fld_update_hotelCity,
                            fld_update_hotelAddress, fld_update_hotelEmail, fld_update_hotelPhone,
                            cmb_update_hotelStar);


                    if (Helper.confirm("sure")) {


                        if (otel.update(getSelected_hotelID(), otel.getName(), otel.getCountry(), otel.getCity(),
                                otel.getAddress(),
                                otel.getE_mail(),
                                otel.getPhone(),
                                otel.getFacilitys(), otel.getStar())) {
                            Helper.showMsg("done");


                            pnl_update_hotel.setVisible(false);

                            loadHotelModel();

                        }

                    }
                }
            }
        });
        btn_update_hotelShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });

        btn_room_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                        int hotel_id = Hotel.getFetch(cmb_hotel_name.getSelectedItem().toString()).getId();
                        int hostel_id = Hostel.getFetch(cmb_hostel.getSelectedItem().toString()).getId();
                        int bed = Integer.parseInt(fld_bed_count.getText());
                        int piece = Integer.parseInt(fld_room_piece.getText());
                        int first = Integer.parseInt(fld_room_firstSeason.getText());
                        int then = Integer.parseInt(fld_roo_thenSeason.getText());
                        System.out.println(first);
                        if (Room.add(hotel_id, hostel_id, bed, piece,
                                cmb_room_type.getSelectedItem().toString(), first, then)) {
                            Helper.showMsg("done");
                            loadRoomModel();
                            pnl_room_table.setVisible(true);
                        }
                    }


                }
            }
        });
        btn_update_room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                        int hotel_id = Hotel.getFetch(cmb_update_roomhotel.getSelectedItem().toString()).getId();
                        int hostel_id = Hostel.getFetch(cmb_update_roomhostel.getSelectedItem().toString()).getId();
                        int bed = Integer.valueOf(fld_update_roombed.getText());
                        int piece = Integer.valueOf(fld_update_roomPiece.getText());
                        String type = cmb_update_roomType.getSelectedItem().toString();
                        int firstSeason = Integer.valueOf(fld_update_roomfirstSeason.getText());
                        int thenSeason = Integer.valueOf(fld_update_roomthenSeason.getText());
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
            }
        });
        btn_update_roomShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pnl_room_update.isVisible()) {
                    pnl_room_update.setVisible(false);
                } else {
                    Helper.showMsg("Tablodan güncellenecek veriyi seçiniz.");
                    Room.pnlRoomClear(cmb_update_roomhotel, cmb_update_roomhostel, fld_update_roombed,
                            fld_update_roomPiece, cmb_update_roomType, fld_update_roomfirstSeason, fld_update_roomthenSeason);
                    pnl_room_update.setVisible(true);

                }
            }
        });
        btn_hotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tbpnl_hotel.isVisible() == false) {
                    tbpnl_reservation.setVisible(false);
                    tbpnl_room.setVisible(false);
                    tbpnl_hotel.setVisible(true);

                }
            }
        });
        btn_room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tbpnl_room.isVisible() == false) {
                    tbpnl_hotel.setVisible(false);
                    tbpnl_reservation.setVisible(false);
                    tbpnl_room.setVisible(true);
                }
            }
        });
        btn_reservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tbpnl_reservation.isVisible() == false) {
                    tbpnl_hotel.setVisible(false);
                    tbpnl_room.setVisible(false);
                    tbpnl_reservation.setVisible(true);
                }
            }
        });
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

            row_room_list[i++] = obj.getHotel_id();
            row_room_list[i++] = obj.getHostel().getType();
            row_room_list[i++] = obj.getPiece();
            row_room_list[i++] = obj.getType();
            row_room_list[i++] = obj.getFirstSeason();
            row_room_list[i++] = obj.getThenSeason();

            mdl_room_list.addRow(row_room_list);
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


}
