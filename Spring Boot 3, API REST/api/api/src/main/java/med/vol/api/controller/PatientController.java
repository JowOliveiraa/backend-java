package med.vol.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.patient.*;
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
        return repository.findAllByActiveTrue(pagination).map(PatientListingData::new); // criando automaticamente um metodo de acesso ao banco com findAllBy+Nome_do_atributo+Condicional
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid PatientUpdateData data) {
        var patient = repository.getReferenceById(data.id());
        patient.updateData(data);
    }

    @DeleteMapping("/{id}") // recebendo o parametro id na URL
    @Transactional
    public void delete(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.inactive(); //inativando o paciente no banco
    }

//    deletando o paciente no banco
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void delete(@PathVariable Long id) {
//        repository.deleteById(id);
//    }

}
