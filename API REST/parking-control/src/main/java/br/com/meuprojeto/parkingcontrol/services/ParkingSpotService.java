package br.com.meuprojeto.parkingcontrol.services;

import br.com.meuprojeto.parkingcontrol.dtos.ParkingSpotDTO;
import br.com.meuprojeto.parkingcontrol.models.ParkingSpot;
import br.com.meuprojeto.parkingcontrol.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ParkingSpotService {

    @Autowired
    ParkingSpotRepository repository;

    @Transactional
    public ResponseEntity<String> validation(ParkingSpotDTO dto) {
        if (repository.existsByParkingSpotNumber(dto.parkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A vaga ja está em uso!");
        }
        if (repository.existsByLicensePlateCar(dto.licensePlateCar())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A placa do carro ja foi registrada!");
        }
        if (repository.existsByBlockAndApartment(dto.block(), dto.apartment())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe uma vaga cadastrada para esse Bloco e apartamento!");
        }
        repository.save(new ParkingSpot(dto));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Cadastrado com sucesso!");
    }

    public Page<ParkingSpot> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public ResponseEntity<Object> findById(Long id) {
        if (repository.existsById(id)){
            return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id informado não existe!");
    }

    @Transactional
    public ResponseEntity<String> delete(Long id) {
        if(repository.existsById(id)){
         repository.deleteById(id);
         return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado!");
    }

    @Transactional
    public ResponseEntity<String> update(Long id, ParkingSpotDTO dto) {
        if (repository.existsById(id)){
            var parkingSpot = repository.getReferenceById(id);


            parkingSpot.update(dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Atualizado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado!");
    }
}
