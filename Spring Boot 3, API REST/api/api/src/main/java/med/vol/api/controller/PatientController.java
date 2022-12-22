package med.vol.api.controller;

import med.vol.api.patient.PatientRecordData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PatientController {

    @PostMapping
    public void register(@RequestBody PatientRecordData data){
        System.out.println("Dados recebidos " + data);
    }
}
