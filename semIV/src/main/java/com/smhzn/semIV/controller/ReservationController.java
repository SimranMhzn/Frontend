package com.smhzn.semIV.controller;

import com.smhzn.semIV.model.Reservation;
import com.smhzn.semIV.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/list") //http method aksto use garne bhanera define gareko
    public List<Reservation> getAllReservation() {
        return reservationService.getAll();
    }

    @PostMapping("/add")
    public Reservation add(@RequestBody Reservation reservation) {
        reservationService.add(reservation);
        return reservation;
    }

    @GetMapping("/list/{id}")
    public Reservation getById(@PathVariable int id) {
        return reservationService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Reservation deleteById(@PathVariable int id) {
        reservationService.deleteById(id);
        return null;
    }

    @PutMapping("/update/{id}")
    public Reservation updateUser(@RequestBody Reservation reservation, @PathVariable int id) {
        return reservationService.updateReservation(reservation, id);
    }

}
