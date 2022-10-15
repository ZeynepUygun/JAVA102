package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Room implements Query {
    private int id;
    private int hotel_id;
    private Hotel hotel;
    private int hostel_id;
    private Hostel hostel;
    private int bed;
    private int piece;
    private String type;
    private int firstSeason;
    private int thenSeason;

    public Room(int id, int hotel_id, int hostel_id, int bed, int piece, String type, int firstSeason, int thenSeason) {
        this.id = id;
        this.hotel_id = hotel_id;
        this.hostel_id = hostel_id;
        this.bed = bed;
        this.piece = piece;
        this.type = type;
        this.firstSeason = firstSeason;
        this.thenSeason = thenSeason;

        this.hotel = Hotel.getFetch(hotel_id);
        this.hostel = Hostel.getFetch(hostel_id);
    }

    //Odaları listeler.
    public static ArrayList<Room> getList() {
        ArrayList<Room> roomList = new ArrayList<>();
        Room obj;

        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(roomListQuery);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                obj = new Room(rs.getInt("id"),
                        rs.getInt("hotel_id"),
                        rs.getInt("hostel_id"),
                        rs.getInt("bed"),
                        rs.getInt("piece"),
                        rs.getString("type"),
                        rs.getInt("firstSeason(TL)"),
                        rs.getInt("thenSeason(TL)"));
                roomList.add(obj);
            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomList;
    }

    //************************************************
    //id'ye sahip odaları getirir.
    public static Room getFetch(int id) {
        Room obj = null;

        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(roomWhereID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Room(rs.getInt("id"),
                        rs.getInt("hotel_id"),
                        rs.getInt("hostel_id"),
                        rs.getInt("bed"),
                        rs.getInt("piece"),
                        rs.getString("type"),
                        rs.getInt("firstSeason(TL)"),
                        rs.getInt("thenSeason(TL)"));
            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;

    }
    //************************************************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(int hostel_id) {
        this.hostel_id = hostel_id;
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFirstSeason() {
        return firstSeason;
    }

    public void setFirstSeason(int firstSeason) {
        this.firstSeason = firstSeason;
    }

    public int getThenSeason() {
        return thenSeason;
    }

    public void setThenSeason(int thenSeason) {
        this.thenSeason = thenSeason;
    }
}
