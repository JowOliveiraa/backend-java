package med.vol.api.domain.patient;

import med.vol.api.address.Address;

public record PatientUpdateDetails(Long id, String nome, String email, String telefone, String cpf, Address endereco) {
    public PatientUpdateDetails(Patient patient){
        this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getTelefone(), patient.getCpf(), patient.getEndereco());
    }
}
