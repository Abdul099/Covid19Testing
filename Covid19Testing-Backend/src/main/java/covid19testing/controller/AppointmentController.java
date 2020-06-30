package covid19testing.controller;

import covid19testing.dto.AppointmentDto;
import covid19testing.dto.PatientDto;
import covid19testing.model.Appointment;
import covid19testing.model.Patient;
import covid19testing.service.AppointmentService;
import covid19testing.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    PatientService patientService;

    @PostMapping(value = {"/appointments/create", "/appointments/create/"})
    public AppointmentDto createAppointment(@RequestParam Date date, @RequestParam Time time, @RequestParam String centerName) {
        Appointment appointment = appointmentService.createAppointment(date, time);
        appointmentService.assignAppointmentToTestCenter(centerName, appointment);
        AppointmentDto appointmentDto = convertToDto(appointment);
        return appointmentDto;
    }

    @DeleteMapping(value = {"/appointments/delete/{appointmentID}", "/appointments/delete/{appointmentID}/"})
    public void deleteAppointment(@PathVariable("appointmentID") String appointmentID){
        appointmentService.deleteAppointment(appointmentID);
    }

    @PutMapping(value = {"/appointments/cancel/{appointmentID}", "/appointments/cancel/{appointmentID}/"})
    public AppointmentDto cancelAppointmentForPatient(@PathVariable("appointmentID") String appointmentID){
        Appointment apt = appointmentService.getPatientByAppointmentID(appointmentID);
        appointmentService.cancelAppointmentForPatient(appointmentID);
        return convertToDto(apt);
    }

    @GetMapping(value = {"/appointments/getAllAppointments", "/appointments/getAllAppointments/"})
    public List<AppointmentDto> getAllAppointments(){
        List<AppointmentDto> list = new ArrayList<>();
        for (Appointment apt : appointmentService.getAllAppointments()) {
            list.add(convertToDto(apt));
        }
        return list;
    }

    @PutMapping(value = {"/appointments/assignCenter", "/appointments/assignCenter/"})
    public AppointmentDto assignTestCenter(@RequestParam String appointmentID, @RequestParam String centerName){
        Appointment apt = appointmentService.getPatientByAppointmentID(appointmentID);
        appointmentService.assignAppointmentToTestCenter(centerName, apt);
        return convertToDto(apt);
    }

    @PutMapping(value = {"/appointments/bookPatient", "/appointments/bookPatient/"})
    public AppointmentDto bookPatient(@RequestParam String appointmentID, @RequestParam String patientInsuranceNumber){
        Appointment apt = appointmentService.getPatientByAppointmentID(appointmentID);
        Patient p = patientService.getPatientByInsuranceNumber(patientInsuranceNumber);
        appointmentService.bookAppointmentForPatient(p, apt);
        return convertToDto(apt);
    }
//    private Date date;
//    private Time time;
//    private String patientInsuranceNumber;
//    private String testCenterName;
//    private String appointmentID;
//    public boolean available;

    private AppointmentDto convertToDto(Appointment a) {
        AppointmentDto appointmentDto = new AppointmentDto(a.getDate(), a.getTime(), a.getappointmentPatient().getInsuranceNumber(),
                a.getLocation().getName(), a.getAppointmentID(), a.isAvailable());
        return appointmentDto;
    }
}
