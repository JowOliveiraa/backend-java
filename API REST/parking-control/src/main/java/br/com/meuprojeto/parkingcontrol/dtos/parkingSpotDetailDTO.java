package br.com.meuprojeto.parkingcontrol.dtos;

import br.com.meuprojeto.parkingcontrol.models.ParkingSpot;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record parkingSpotDetailDTO(
        Long id,
        String parkingSpotNumber,
        LocalDateTime registrationDate,
        String responsibleName,
        String apartment,
        String block,
        String licensePlateCar,
        String brandCar,
        String modelCar,
        String colorCar) {

    public parkingSpotDetailDTO(ParkingSpot parkingSpot) {
        this(
                parkingSpot.getId(),
                parkingSpot.getParkingSpotNumber(),
                parkingSpot.getRegistrationDate(),
                parkingSpot.getResponsibleName(),
                parkingSpot.getApartment(),
                parkingSpot.getBlock(),
                parkingSpot.getLicensePlateCar(),
                parkingSpot.getBrandCar(),
                parkingSpot.getModelCar(),
                parkingSpot.getColorCar());
    }
}
