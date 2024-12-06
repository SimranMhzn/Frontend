package com.smhzn.semIV.service.Impl;

import com.smhzn.semIV.model.Reservation;
import com.smhzn.semIV.repository.ReservationRepository;
import com.smhzn.semIV.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation add(Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        getById(id);
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation updateReservation(Reservation reservation, int id) {
        getById(id);
        reservation.setReservationId(id);
        return null;
    }

    @Override
    public Reservation getById(int id) { //database bata value lincha, cha bhane value dincha, chaina bhane error faldincha
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        Reservation reservation = optionalReservation.orElseThrow((() -> new RuntimeException("Reservation not found")));
        return reservation;
    }

}