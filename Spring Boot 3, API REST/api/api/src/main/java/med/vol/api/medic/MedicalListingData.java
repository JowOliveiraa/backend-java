package med.vol.api.medic;

public record MedicalListingData(String nome, String email, String crm, Specialty especialidade) {

    public MedicalListingData(Medic medic) {
        this(medic.getNome(), medic.getEmail(), medic.getCrm(), medic.getEspecialidade());
    }
}
