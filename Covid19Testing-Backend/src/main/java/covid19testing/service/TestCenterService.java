package covid19testing.service;

import covid19testing.dao.AppointmentRepository;
import covid19testing.dao.TestCenterRepository;
import covid19testing.dao.TestRepository;
import covid19testing.model.Appointment;
import covid19testing.model.TestCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TestCenterService {
    @Autowired
    TestCenterRepository testCenterRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    TestRepository testRepository;

    @Transactional
    public TestCenter createTestCenter(String name, String address, String city, String province){
        TestCenter center = new TestCenter();
        center.setAddress(address);
        center.setCity(city);
        center.setName(name);
        center.setProvince(province);
        testCenterRepository.save(center);
        return center;
    }
}
