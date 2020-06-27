package covid19testing.service;

// patient test center

import covid19testing.dao.PatientRepository;
import covid19testing.dao.TestCenterRepository;
import covid19testing.dao.TestRepository;
import covid19testing.model.Patient;
import covid19testing.model.TestCenter;
import covid19testing.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TestService {
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	TestCenterRepository testCenterRepository;
	@Autowired
	TestRepository testRepository;

	@Transactional
	public Test 
