package med.vol.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.patient.Patient;
import med.vol.api.patient.PatientListingData;
import med.vol.api.patient.PatientRecordData;
import med.vol.api.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PatientRecordData data){
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<PatientListingData> list(@PageableDefault(size=10, sort={"nome"}) Pageable pagination) {
        return repository.findAll(pagination).map(PatientListingData::new);
    }
}
