package med.vol.api.domain.medic;

import med.vol.api.address.Address;

public record MedicalUpdateDetails(Long id, String nome, String email, String crm, String telefone, Specialty especialidade, Address endereco) {
    public MedicalUpdateDetails(Medic medic) {
        this(medic.getId(), medic.getNome(), medic.getEmail(), medic.getCrm(), medic.getTelefone(), medic.getEspecialidade(), medic.getEndereco());
    }
}
