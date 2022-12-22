package med.vol.api.medic;

import med.vol.api.address.AddressData;

public record MedicalRecordData(String nome, String email, String crm, Specialty especialidade, AddressData endereco) {
}
