package br.com.meuprojeto.parkingcontrol.repositories;

import br.com.meuprojeto.parkingcontrol.models.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

    boolean existsByParkingSpotNumber(String parkingSpotNumber);

    boolean existsByLicensePlateCar(String licensePlateCar);

    boolean existsByBlockAndApartment(String block, String apartment);

}

