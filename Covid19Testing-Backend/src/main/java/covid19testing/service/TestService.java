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
	public Test createTest(Date date, Time time){
		Test newTest = new Test();
		newTest.setDate(date);
		newTest.setTime(time);
		newTest.setTestID();
		newTest.setResult();
		newTest.setStatus();
		testRepository.save(newTest);
		return newTest;
	}

	@Transactional
	public void deleteTest(String testID){
		Test test = testRepository.findTestByTestID(testID);
	if (test == null) {
            throw new IllegalArgumentException("Test with ID: " + testID + " does not exist");
        }
	testRepository.deleteTestByTestID(testID);
	}

	@Transactional
	public Test updateTest(Date date, Time time, String testID){
		Test test = testRepository.findTestByTestID(testID);
		if (test == null) {
            	throw new IllegalArgumentException("Test with ID: " + testID + " does not exist");
        	}
		test.setDate(date);
        	test.setTime(time);
		test.setStatus(status);
		test.setResult(result);
                testRepository.save(test);
                return test;
	}
	
	@Transactional
	public Test getAllTests(){
		List<Test> allTests = new ArrayList<>();
		for(Test t: testRepository.findAll()){
			tests.add(t);
		}
		return allTests.length;
	}
	
	@Transactional
	public Test getPositiveTests(){
		List<Test> positiveTests = new ArrayList<>();
		for(Test t: testRepository.findAll()){
			if(t.getResult() == "Positive"){
				positiveTests.add(t);
			}
		}
	return positiveTests.length;
	}

	@Transactional
        public Test getNegativeTests(){
                List<Test> negativeTests = new ArrayList<>();
                for(Test t: testRepository.findAll()){
                        if(t.getResult() == "Negative"){
                                negativeTests.add(t);
                        }
                }
        return negativeTests.length;
}
