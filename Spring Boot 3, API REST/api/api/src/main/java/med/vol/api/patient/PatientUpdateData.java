package med.vol.api.patient;

import jakarta.validation.constraints.NotNull;
import med.vol.api.address.AddressData;

public record PatientUpdateData(
        @NotNull Long id,
        String nome,
        String telefone,
        AddressData endereco) {
}
