package com.meuprojeto.service;

import com.meuprojeto.SpringDataApplication;
import com.meuprojeto.orm.Employee;
import com.meuprojeto.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Scanner;

@Service
public class EmployeeService {

    @Autowired
    SpringDataApplication application;

    @Autowired
    EmployeeRepository repository;

    public void employeeStart(Scanner teclado) throws Exception {
        System.out.println("O que você deseja fazer?");
        System.out.println("0 - Voltar");
        System.out.println("1 - Salvar um novo funcionário");
        System.out.println("2 - Editar um funcionário");
        System.out.println("3 - Mostrar todos os funcionários");
        System.out.println("4 - Apagar um funcionário");

        int action = teclado.nextInt();

        switch (action) {
            case 0 -> application.run();
            case 1 -> save(teclado);
            case 2 -> update(teclado);
            default -> System.out.println("Opção invalida");
        }

    }

    @Transactional
    private void update(Scanner teclado) {
        boolean run = true;

        while (run) {
            System.out.println("Digite o ID do funcionário:");
            int id = teclado.nextInt();

            if (repository.existsById(id)) {

                var employee = repository.getReferenceById(id);
               // var updateEmployee = new Employee(employee.getId(), employee.getName(), employee.getCpf(), employee.getSalary(), employee.getHiringDate());

                System.out.println("Só é possível editar o salário do funcionário");
                System.out.println("Digite o salário:");

                Double salary = teclado.nextDouble();

                employee.update(salary);

                run = false;
            }
        }
    }

    @Transactional
    private void save(Scanner teclado) {
        System.out.println("Nome do funcionário?");
        String name = teclado.next();

        System.out.println("CPF do funcionário?");
        String cpf = teclado.next();

        System.out.println("Salário do funcionário?");
        Double salary = teclado.nextDouble();

        System.out.println("Data de contratação do funcionário?");
        LocalDateTime hiringDate = LocalDateTime.now();

        var employee = new Employee(name, cpf, salary, hiringDate);

        repository.save(employee);

        System.out.println("Salvo com sucesso!");
    }
}
