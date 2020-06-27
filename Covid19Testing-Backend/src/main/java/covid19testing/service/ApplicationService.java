package covid19testing.service;

import covid19testing.dao.ApplicationRepository;
import covid19testing.dao.PatientRepository;
import covid19testing.model.Application;
import covid19testing.model.Patient;
import covid19testing.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    PatientRepository patientRepository;

    @Transactional
    public Application createApplication(double fever, boolean cough, boolean shortnessBreath,
                                         String otherSymptoms) {
        if (fever < 34.0 || (fever > 43.0 && fever < 93.0) || fever > 109.0) { //if out of range both in celsius and fahrenheit
            throw new IllegalArgumentException("Invalid Body Temperature!");
        }
        Application application = new Application();
        application.setApplicationID();
        application.setFever(fever);
        application.setCough(cough);
        application.setShortnessBreath(shortnessBreath);
        application.setOtherSymptoms(otherSymptoms);
        application.setStatus(Status.InProcess);
        applicationRepository.save(application);
        return application;
    }
    
    @Transactional
    public void deleteApplication(String applicationID) {
        Application app = applicationRepository.findApplicationByApplicationID(applicationID);
        if (app == null) {
            throw new IllegalArgumentException("Application with invalid ID!");
        }
        applicationRepository.deleteApplicationByApplicationID(applicationID);
    }

    @Transactional
    public Application updateApplication(double fever, boolean cough, boolean shortnessBreath,
                                         String otherSymptoms, Status status, String applicationID) {
        Application application = applicationRepository.findApplicationByApplicationID(applicationID);
        if(application == null){
            throw new IllegalArgumentException("Application cannot be null!");
        }
        application.setFever(fever);
        application.setCough(cough);
        application.setShortnessBreath(shortnessBreath);
        application.setOtherSymptoms(otherSymptoms);
        application.setStatus(status);
        applicationRepository.save(application);
        return application;
    }

    @Transactional
    public Application evaluateApplication(String applicationID, boolean result) {//true = accepted false = rejected
        Application app = applicationRepository.findApplicationByApplicationID(applicationID);
        if(app == null){
            throw new IllegalArgumentException("Application cannot be null!");
        }
        app.setResult(result);
        applicationRepository.save(app);
        return app;
    }

}
