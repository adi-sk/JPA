package com.zycus.service;

import java.util.Date;
import java.util.Set;

import com.zycus.dao.GenericD;
import com.zycus.entity.Booking;
import com.zycus.entity.Passenger;
import com.zycus.entity.Train;

public class TrainReservationService {

	GenericD genericD = new GenericD();

	public void book(Set<Passenger> passengers, int trainNo) {
		Booking booking = new Booking();
		booking.setPassenger(passengers);
		booking.setBookingDate(new Date());

		Train train = genericD.fetchById(trainNo, Train.class);

		booking.setTrain(train);

		genericD.create(booking);

	}
}
