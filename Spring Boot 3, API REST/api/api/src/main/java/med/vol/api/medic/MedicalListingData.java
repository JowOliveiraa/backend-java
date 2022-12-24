package med.vol.api.medic;

public record MedicalListingData(Long id, String nome, String email, String crm, Specialty especialidade) {

    public MedicalListingData(Medic medic) {
        this(medic.getId(), medic.getNome(), medic.getEmail(), medic.getCrm(), medic.getEspecialidade());
    }
}
