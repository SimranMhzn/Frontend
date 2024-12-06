package com.smhzn.semIV.service;

import com.smhzn.semIV.model.Reservation;

import java.util.List;

public interface ReservationService{//METHODS HARU DEFINE GAREKO
    Reservation add (Reservation reservation);
    List<Reservation> getAll();
    void deleteById(int id);
    Reservation updateReservation(Reservation reservation,int id);
    Reservation getById(int id);
}