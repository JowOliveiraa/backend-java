package br.com.meuprojeto.parkingcontrol.controllers;

import br.com.meuprojeto.parkingcontrol.dtos.ParkingSpotDTO;
import br.com.meuprojeto.parkingcontrol.models.ParkingSpot;
import br.com.meuprojeto.parkingcontrol.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/parking-spot")
@CrossOrigin(origins = "*")
public class ParkingSpotController {

    @Autowired
    ParkingSpotService service;

    @PostMapping
    public ResponseEntity<Object> register(@RequestBody @Valid ParkingSpotDTO dto) {
        return service.validation(dto);
    }

    @GetMapping
    public Page<ParkingSpot> list(@PageableDefault(page = 0, size = 10, sort = {"responsibleName"}) Pageable pageable) {
        return service.list(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> finById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ParkingSpotDTO dto) {
        return service.update(id, dto);
    }
}
