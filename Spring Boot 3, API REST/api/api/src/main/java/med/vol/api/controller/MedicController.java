package med.vol.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.medic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medics")
public class MedicController {

    @Autowired
    private MedicRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid MedicalRecordData data) {
       repository.save(new Medic(data));
    }

    @GetMapping
    public Page<MedicalListingData> list(@PageableDefault(size=10, sort={"nome"}) Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(MedicalListingData::new); // criando automaticamente um metodo de acesso ao banco com findAllBy+Nome_do_atributo+Condicional
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid MedicalUpdateData data) {
        var medic = repository.getReferenceById(data.id());
        medic.updateData(data);
    }

    @DeleteMapping("/{id}") // recebendo o id na URL
    @Transactional
    public void delete(@PathVariable Long id) {
        var medic = repository.getReferenceById(id);
        medic.inactive(); // inativando o paciente no banco
    }

//    deletando o usuario no banco
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void delete(@PathVariable Long id) {
//        repository.deleteById(id);
//    }

}
