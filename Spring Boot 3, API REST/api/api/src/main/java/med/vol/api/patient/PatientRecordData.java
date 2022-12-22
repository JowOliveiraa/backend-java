package med.vol.api.patient;

import med.vol.api.address.AddressData;

public record PatientRecordData(String nome, String email, String telefone, AddressData endereco) {
}
