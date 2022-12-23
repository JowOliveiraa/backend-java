package med.vol.api.patient;

public record PatientListingData(String nome, String email, String cpf) {

    public PatientListingData(Patient patient) {
        this(patient.getNome(), patient.getEmail(), patient.getCpf());
    }
}
