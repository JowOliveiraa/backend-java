package br.com.meuprojeto.parkingcontrol.models;

import br.com.meuprojeto.parkingcontrol.dtos.ParkingSpotDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Getter
@Entity
@Table(name = "parking_spots")
@NoArgsConstructor
public class ParkingSpot implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Length(max = 5)
    private String parkingSpotNumber;

    private LocalDateTime registrationDate;

    @Length(max = 30)
    private String responsibleName;

    @Length(max = 10)
    private String apartment;

    @Length(max = 10)
    private String block;

    @Length(max = 7)
    private String licensePlateCar;

    @Length(max = 30)
    private String brandCar;

    @Length(max = 30)
    private String modelCar;

    @Length(max = 20)
    private String colorCar;

    public ParkingSpot(ParkingSpotDTO dto) {
        this.parkingSpotNumber = dto.parkingSpotNumber();
        this.registrationDate = LocalDateTime.now(ZoneId.of("UTC"));
        this.responsibleName = dto.responsibleName();
        this.apartment = dto.apartment();
        this.block = dto.block();
        this.licensePlateCar = dto.licensePlateCar();
        this.brandCar = dto.brandCar();
        this.modelCar = dto.modelCar();
        this.colorCar = dto.colorCar();
    }

    public void update(ParkingSpotDTO dto) {
        if (!Objects.equals(dto.parkingSpotNumber(), this.parkingSpotNumber)){
            this.parkingSpotNumber = dto.parkingSpotNumber();
        }
        if (!Objects.equals(dto.responsibleName(), this.responsibleName)){
            this.responsibleName = dto.responsibleName();
        }
        if (!Objects.equals(dto.apartment(), this.apartment)) {
            this.apartment = dto.apartment();
        }
        if (!Objects.equals(dto.block(), this.block)) {
            this.block = dto.block();
        }
        if (!Objects.equals(dto.licensePlateCar(), this.licensePlateCar)){
            this.licensePlateCar = dto.licensePlateCar();
        }
        if (!Objects.equals(dto.brandCar(), this.brandCar)){
            this.brandCar = dto.brandCar();
        }
        if (!Objects.equals(dto.modelCar(), this.modelCar)){
            this.modelCar = dto.modelCar();
        }
        if (!Objects.equals(dto.colorCar(), this.colorCar)){
            this.colorCar = dto.colorCar();
        }
    }
}
