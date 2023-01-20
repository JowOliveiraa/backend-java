package com.meuprojeto.orm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String name;
    private String cpf;
    private Double salary;
    private LocalDateTime hiringDate;

    public void update(Double update) {
        setSalary(update);
    }

    public Employee(String name, String cpf, Double salary, LocalDateTime hiringDate) {
        this.name = name;
        this.cpf = cpf;
        this.salary = salary;
        this.hiringDate = hiringDate;
    }

    public Employee(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.cpf = employee.getName();
        this.salary = employee.getSalary();
        this.hiringDate = employee.getHiringDate();
    }
}
