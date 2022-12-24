package med.vol.api.patient;

public record PatientListingData(Long id, String nome, String email, String cpf) {

    public PatientListingData(Patient patient) {
        this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getCpf());
    }
}
