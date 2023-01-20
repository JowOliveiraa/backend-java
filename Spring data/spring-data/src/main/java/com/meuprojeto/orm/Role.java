package com.meuprojeto.orm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "roles")
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String description;

    public Role(Role role) {
        this.id = role.getId();
        this.description = role.getDescription();
    }

    public String toString() {
        return "Descrição do cargo: " + this.description + ", ID do cargo: " + this.id;
    }

}
