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
    private int communication_id;



    public Reservation(int id, int room_id, String reservation, String input, String output, int child, int adult,
                       int communication_id) {
        this.id = id;
        this.room_id = room_id;
        this.reservation = reservation;
        this.input = input;
        this.output = output;
        this.child = child;
        this.adult = adult;
        this.communication_id=communication_id;

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
                        rs.getInt("adult"),
                        rs.getInt("communication_id"));
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
    //Reserve odaları listeler.
    public static ArrayList<Reservation>getList(int room_id){
        ArrayList<Reservation> reservationList=new ArrayList<>();
        Reservation obj;
        try {
            PreparedStatement pr= DBConnecter.getInstance().prepareStatement(reservationWhereReserve);
            pr.setInt(room_id,1);
            ResultSet rs =pr.executeQuery();
            while (rs.next()){
                obj=new Reservation(rs.getInt("id"),
                        rs.getInt("room_id"),
                        rs.getString("reservation"),
                        rs.getString("input"),
                        rs.getString("output"),
                        rs.getInt("child"),
                        rs.getInt("adult"),
                        rs.getInt("communication_id"));
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
    public static Boolean update(int id, int room_id, String input, String output, int child, int adult,
                                 int communication_id) {
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(reservationUpdate);
            pr.setInt(1, id);
            pr.setInt(2, room_id);
            pr.setString(3, "NO");
            pr.setString(4, input);
            pr.setString(5, output);
            pr.setInt(6, child);
            pr.setInt(7, adult);
            pr.setInt(8, communication_id);
            pr.setInt(9, id);


            int response = pr.executeUpdate();

            pr.getConnection().close();

            return response != -1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }

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
                        rs.getInt("adult"),
                        rs.getInt("communication_id"));
            }
            rs.close();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }
    public static Reservation getFetchCommunation(int communication_id){
        Reservation obj=null;
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(reservationWhereCommunation_id);
            pr.setInt(1,communication_id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj=new Reservation(rs.getInt("id"),
                        rs.getInt("room_id"),
                        rs.getString("reservation"),
                        rs.getString("input"),
                        rs.getString("output"),
                        rs.getInt("child"),
                        rs.getInt("adult"),
                        rs.getInt("communication_id"));
            }
            rs.close();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }
    //********************************************************
    //id'ye sahip reservasyonu getirir.
    public static int getFetchRemaining(int room_id){
        int value=0;
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(reservationCountRoom);
            pr.setInt(1,room_id);

            ResultSet rs = pr.executeQuery();
            if (rs.next()){
               value= rs.getInt("count");
            }
            rs.close();
            pr.getConnection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return value;
    }
    //********************************************************
    public static Boolean add(int room_id, String reservation, String input, String output, int child, int adult,int communication_id) {
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(reservationAdd);
            pr.setInt(1, room_id);
            pr.setString(2, reservation);
            pr.setString(3, input);
            pr.setString(4, output);
            pr.setInt(5, child);
            pr.setInt(6, adult);
            pr.setInt(7,communication_id);



            int response = pr.executeUpdate();

            pr.getConnection().close();

            return response != -1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }
    public static Boolean delete(int id) {
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(delete);
            pr.setInt(1, id);




            int response = pr.executeUpdate();

            pr.getConnection().close();

            return response != -1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }


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

    public int getCommunication_id() {
        return communication_id;
    }

    public void setCommunication_id(int communication_id) {
        this.communication_id = communication_id;
    }
}
