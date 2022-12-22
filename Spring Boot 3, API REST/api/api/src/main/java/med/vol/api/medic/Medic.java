package med.vol.api.medic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.vol.api.address.Address;

@Table(name = "medics")
@Entity(name = "medic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String nome;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty especialidade;
    @Embedded
    private Address endereco;

    public Medic(MedicalRecordData data) {
        this.nome = data.nome();
        this.email = data.email();
        this.crm = data.crm();
        this.especialidade = data.especialidade();
        this.endereco = new Address(data.endereco());
    }
}
