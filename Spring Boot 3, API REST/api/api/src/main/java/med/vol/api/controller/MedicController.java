package med.vol.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.medic.Medic;
import med.vol.api.medic.MedicRepository;
import med.vol.api.medic.MedicalListingData;
import med.vol.api.medic.MedicalRecordData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return repository.findAll(pagination).map(MedicalListingData::new);
    }
}
