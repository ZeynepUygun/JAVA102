package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Reservation implements Query {
    private int id;
    private int room_id;
    private Room room;
    private String reservation;
    private String input;
    private String output;
    private int child;
    private int adult;

    public Reservation(int id, int room_id, String reservation, String input, String output, int child, int adult) {
        this.id = id;
        this.room_id = room_id;
        this.reservation = reservation;
        this.input = input;
        this.output = output;
        this.child = child;
        this.adult = adult;

        this.room=Room.getFetch(room_id);
    }
    //Reserve odaları listeler.
    public static ArrayList<Reservation>getList(){
        ArrayList<Reservation> reservationList=new ArrayList<>();
        Reservation obj;
        try {
            PreparedStatement pr= DBConnecter.getInstance().prepareStatement(reservationListQuery);
            ResultSet rs =pr.executeQuery();
            while (rs.next()){
                obj=new Reservation(rs.getInt("id"),
                        rs.getInt("room_id"),
                        rs.getString("reservation"),
                        rs.getString("input"),
                        rs.getString("output"),
                        rs.getInt("child"),
                        rs.getInt("adult"));
                reservationList.add(obj);
            }
            rs.close();
            pr.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reservationList;
    }
    //********************************************************

    //id'ye sahip reservasyonu getirir.
    public static Reservation getFetch(int id){
        Reservation obj=null;
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(reservationWhereID);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj=new Reservation(rs.getInt("id"),
                        rs.getInt("room_id"),
                        rs.getString("reservation"),
                        rs.getString("input"),
                        rs.getString("output"),
                        rs.getInt("child"),
                        rs.getInt("adult"));
            }
            rs.close();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }
    //********************************************************


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }
}
