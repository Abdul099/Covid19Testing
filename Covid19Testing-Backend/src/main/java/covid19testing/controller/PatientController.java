package covid19testing.controller;

import covid19testing.dto.PatientDto;
import covid19testing.model.Patient;
import covid19testing.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping(value = {"/patients/create", "/patients/create/"})
    public PatientDto createPatient(@RequestBody PatientDto p) throws IllegalAccessException {
        Patient patient = patientService.createPatient(p.getName(), p.getSurname(), p.getAddress(), p.getCity(),
                p.getProvince(), p.getInsuranceNumber(), p.getAge(), p.getTravel(), p.getPreCondition(), p.getMedication());
        return convertToDto(patient);
    }
    @PostMapping(value = {"/patients/{insuranceNumber}", "/patients/{insuranceNumber}/"})
    public PatientDto createPatient(@PathVariable("insuranceNumber") String insuranceNumber) throws IllegalArgumentException, IllegalAccessException {
        // @formatter:on
        Patient patient = patientService.createPatient(insuranceNumber);
        return convertToDto(patient);
    }


    private PatientDto convertToDto(Patient patient) {
        PatientDto patientDto = new PatientDto(patient.getInsuranceNumber());
        return patientDto;
    }

}
