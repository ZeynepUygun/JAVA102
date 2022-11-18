package com.patikadev.Helper;

public interface Query {

    //Tüm listeyi sorgulama
    String all = "SELECT * FROM ";
    String orderBY = " ORDER BY id";
    //************************************************************
    //SQL listeleme sorguları.
    String facilityListQuery = all + "facility " + orderBY;
    String hostelListQuery = all + "hostel" + orderBY;
    String hotelListQuery = all + "hotel" + orderBY;
    String customerListQuery = all + "customer" + orderBY;
    String roomListQuery = all + "room" + orderBY;
    String reservationListQuery = all + "reservation" + orderBY;
    //************************************************************
    //SQL arama sorguları.
    String hostelWhereID = "Select * From hostel WHERE id = ?";
    String hostelWhereType = "Select * From hostel WHERE type = ?";
    String hotelWhereID = "SELECT * FROM hotel WHERE id = ?";
    String hotelWhereName = "SELECT * FROM hotel WHERE name = ?";
    String facilityWhereID = "SELECT * FROM facility WHERE id = ?";
    String facilityWhereFeature = "SELECT * FROM facility WHERE feature = ?";
    String roomWhereID = "SELECT * FROM room WHERE id = ?";
    String reservationWhereID = "SELECT * FROM reservation WHERE id = ?";
    String reservationWhereCommunation_id = "SELECT * FROM reservation WHERE communication_id = ?";
    String reservationWhereReserve = "SELECT * FROM reservation WHERE room_id = ? AND reservation='YES'";
    String customerWhereID = "SELECT * FROM customer WHERE id = ?";
    String customerWhereReservationID = "SELECT * FROM customer WHERE reservation_id = ?";
    String communicationWhereID = "SELECT * FROM communication WHERE id = ?";
    String communicationWhere = "SELECT * FROM communication WHERE name_surname=? AND e_mail=? AND phone=? AND note=?";


    //**************************************************************
    //SQL veri ekleme sorguları.
    String hotelAdd = "INSERT INTO hotel (name,country,city,address,e_mail,phone,facilitys,star) VALUES (?,?,?,?," +
            "?,?,?,?)";
    String roomAdd = "INSERT INTO room (hotel_id,hostel_id,bed,piece,type,firstseason,thenseason) VALUES (?,?," +
            "?,?,?,?,?)";
    String reservationAdd = "INSERT INTO reservation (room_id,reservation,input,output,child,adult,communication_id) " +
            "VALUES (?,?,?,?,?,?,?)";
    String customerAdd = "INSERT INTO customer (firstname,lastname, reservation_id,uyruk, tc_pasaport) " +
            "VALUES (?,?,?,?,?)";
    String communicationAdd = "INSERT INTO communication (name_surname, e_mail, phone,note) " +
            "VALUES (?,?,?,?)";
    //***************************************************************
    //SQL veri güncelleme sorguları.
    String hotelUpdate = "UPDATE hotel SET name=?, country=?,city=?,address=?,e_mail=?,phone=?,facilitys=?,star=?  " +
            "WHERE id = ?";
    String roomUpdate = "UPDATE room SET hotel_id=?, hostel_id=?,bed=?,piece=?,type=?,firstseason=?,thenseason=?  " +
            "WHERE id = ?";
    String reservationUpdate = "UPDATE reservation SET id=?, room_id=?,reservation=?, input=?, output=?,child=?, " +
            "adult=?, " +
            "communication_id=? WHERE id = ?";
    //***************************************************************
    //SQL count sorguları.
    String reservationCountRoom = "SELECT Count(*) FROM reservation WHERE room_id = ? AND reservation ='YES'";
    //***************************************************************
    String delete ="DELETE FROM reservation where id=?";

}
