package covid19testing.service;

import covid19testing.dao.AppointmentRepository;
import covid19testing.dao.TestCenterRepository;
import covid19testing.dao.TestRepository;
import covid19testing.model.Appointment;
import covid19testing.model.Patient;
import covid19testing.model.Test;
import covid19testing.model.TestCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestCenterService {
    @Autowired
    TestCenterRepository testCenterRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    TestRepository testRepository;

    @Transactional
    public TestCenter createTestCenter(String name, String address, String city, String province) {
        TestCenter center = new TestCenter();
        center.setAddress(address);
        center.setCity(city);
        center.setName(name);
        center.setProvince(province);
        testCenterRepository.save(center);
        return center;
    }

    @Transactional
    public void deleteTestCenter(String name) {
        TestCenter center = testCenterRepository.findTestCenterByName(name);
        if (center == null) {
            throw new IllegalArgumentException("Test Center Cannot be null!");
        }
        for (Test t : center.getTests()) {
            testRepository.deleteTestByTestID(t.getTestID());
        }
        for (Appointment a : center.getAppointments()) {
            appointmentRepository.deleteAppointmentByAppointmentID(a.getAppointmentID());
        }
        testCenterRepository.deleteTestCenterByName(name);
    }

    @Transactional
    public List<Test> getAllTestsForTestCenter(TestCenter center) {
        if (center == null) {
            throw new IllegalArgumentException("Test Center Cannot be null!");
        }
        List<Test> tests = new ArrayList<>();
        for(Test t: testRepository.findAll()){
            if(t.getTestSite().getName() == center.getName()){
                tests.add(t);
            }
        }
        return tests;
    }
}
