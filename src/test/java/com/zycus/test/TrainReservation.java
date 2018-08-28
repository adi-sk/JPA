package com.zycus.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.zycus.dao.GenericD;
import com.zycus.entity.Passenger;
import com.zycus.entity.Train;
import com.zycus.service.TrainReservationService;

public class TrainReservation {

	TrainReservationService service = new TrainReservationService();

	GenericD genericD = new GenericD();

	@Test
	public void addTrain() {

		Train train = new Train();
		train.setName("Rajdhani");
		train.setSource("A");
		train.setDestination("B");

		System.out.println(train);

		genericD.create(train);
	}

	@Test
	public void book() {

		Set<Passenger> passengers = new HashSet<Passenger>();
		Passenger pas1 = new Passenger();
		pas1.setName("Aditya");
		pas1.setAge(22);
		passengers.add(pas1);

		Passenger pas2 = new Passenger();
		pas2.setName("adi");
		pas2.setAge(22);
		passengers.add(pas2);

		service.book(passengers, 1);

	}

}
