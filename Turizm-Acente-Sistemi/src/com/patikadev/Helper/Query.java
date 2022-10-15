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
    String hotelWhereID = "SELECT * FROM hotel WHERE id = ?";
    String facilityWhereID = "SELECT * FROM facility WHERE id = ?";
    String roomWhereID = "SELECT * FROM room WHERE id = ?";
    String reservationWhereID = "SELECT * FROM reservation WHERE id = ?";
    String customerWhereID = "SELECT * FROM customer WHERE id = ?";
    //**************************************************************
    String hotelAdd="INSERT INTO hotel (name,country,city,address,e-mail,phone,facilitys,star) VALUES (?,?,?,?," +
            "?,?,?,?)";
}
