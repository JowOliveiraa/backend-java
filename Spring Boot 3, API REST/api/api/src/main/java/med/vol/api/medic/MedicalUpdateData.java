package med.vol.api.medic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.vol.api.address.AddressData;

public record MedicalUpdateData(
        @NotNull Long id,
        String nome,
        String telefone,
        AddressData endereco) {
}
