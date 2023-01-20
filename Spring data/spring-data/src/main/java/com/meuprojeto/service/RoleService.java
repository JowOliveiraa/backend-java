package com.meuprojeto.service;

import com.meuprojeto.SpringDataApplication;
import com.meuprojeto.orm.Role;
import com.meuprojeto.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class RoleService {

    @Autowired
    RoleRepository repository;
    @Autowired
    SpringDataApplication application;

    public void roleStart(Scanner teclado) throws Exception {
        System.out.println("O que você deseja fazer?");
        System.out.println("0 - Voltar");
        System.out.println("1 - Salvar um novo cargo");
        System.out.println("2 - Editar um cargo");
        System.out.println("3 - Mostrar todos os cargos");
        System.out.println("4 - Apagar um cargo");

        int option = teclado.nextInt();

        switch (option) {
            case 0 -> application.run();
            case 1 -> save(teclado);
            case 2 -> update(teclado);
            case 3 -> list();
            case 4 -> delete(teclado);
            default -> System.out.println("Opção invalida");
        }

    }

    @Transactional
    private void delete(Scanner teclado) {
        boolean run = true;

        while (run) {
            System.out.println("Digite o ID do cargo que você quer apagar:");

            int id = teclado.nextInt();

            if (repository.existsById(id)) {
                repository.deleteById(id);

                System.out.println("Apagado com sucesso!");

                run = false;
            } else {
                System.out.println("ID não encontrado");
                System.out.println("Se deseja tentar novamente digite 1");
                int action = teclado.nextInt();
                if (action != 1) run = false;
            }
        }
    }

    @Transactional
    private void update(Scanner teclado) {
        boolean run = true;

        while (run) {
            System.out.println("Digite o ID do cargo que você quer editar:");
            int id = teclado.nextInt();

            if (repository.existsById(id)) {

                System.out.println("Descreva a mudança no nome do cargo:");
                String descriptionUpdate = teclado.next();

                var role = new Role();
                role.setId(id);
                role.setDescription(descriptionUpdate);

                repository.save(role);
                run = false;

                System.out.println("Editado com sucesso");
            } else {
                System.out.println("ID não encontrado");
                System.out.println("Se deseja tentar novamente digite 1");
                int action = teclado.nextInt();

                if (action != 1 ) run = false;
            }
        }
    }

    @Transactional
    public void save(Scanner teclado) {
        System.out.println("Descrição do cargo:");
        String description = teclado.next();
        var role = new Role();
        role.setDescription(description);
        repository.save(role);
        System.out.println("Salvo com sucesso");
    }

    public void list() {
        var roles = repository.findAll();
        roles.forEach(System.out::println);
    }

}
