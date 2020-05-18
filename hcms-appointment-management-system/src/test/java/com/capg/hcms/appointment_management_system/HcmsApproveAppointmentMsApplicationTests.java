package com.capg.hcms.appointment_management_system;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.hcms.appointment_management_system.controller.ApproveAppointmentController;
import com.capg.hcms.appointment_management_system.repository.IAppointmentMSRepository;
import com.capg.hcms.appointment_management_system.service.AppointmentMSServiceImp;

@SpringBootTest(classes = HcmsAppointmentMsApplication.class)
public class HcmsApproveAppointmentMsApplicationTests {

	@Autowired
	AppointmentMSServiceImp service;
	@Autowired
	IAppointmentMSRepository repo;
	@Autowired
	ApproveAppointmentController approveAppointment;

	@Test
	void testGetAllAppointments() {
		assertEquals(true, !repo.findAll().isEmpty());
	}

	@Test
	void testApproveAppointmentException() {

		Assertions.assertThrows(LazyInitializationException.class, () -> {

			approveAppointment.approveAppoinment(BigInteger.valueOf(1), true);
		});

	}
}
