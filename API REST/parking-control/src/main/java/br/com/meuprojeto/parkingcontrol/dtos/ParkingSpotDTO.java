package br.com.meuprojeto.parkingcontrol.dtos;

import jakarta.validation.constraints.NotBlank;

public record ParkingSpotDTO(

        @NotBlank(message = "O Número da vaga não pode estar vazio.")
        String parkingSpotNumber,

        @NotBlank(message = "O nome do responsável não pode estar em branco.")
        String responsibleName,

        @NotBlank(message = "O número do apartamento não pode estar vazio.")
        String apartment,

        @NotBlank(message = "O número do bloco não pode estar vazio.")
        String block,

        @NotBlank(message = "A placa do carro não pode estar em branco.")
        String licensePlateCar,

        @NotBlank(message = "A marca do carro não pode estar em branco.")
        String brandCar,

        @NotBlank(message = "O modelo do carro não pode estar em branco.")
        String modelCar,

        @NotBlank(message = "A cor do carro não pode estar em branco.")
        String colorCar
) {
}
