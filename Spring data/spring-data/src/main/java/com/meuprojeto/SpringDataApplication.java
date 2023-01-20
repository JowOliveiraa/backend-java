package com.meuprojeto;

import com.meuprojeto.orm.Role;
import com.meuprojeto.service.EmployeeService;
import com.meuprojeto.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	@Autowired
	private RoleService roleService;

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var teclado = new Scanner(System.in);

		while(system) {
			System.out.println("Qual ação você quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargos");
			System.out.println("2 - Funcionários");

			int action = teclado.nextInt();

			switch (action) {
				case 0 -> system = false;
				case 1 -> roleService.roleStart(teclado);
				case 2 -> employeeService.employeeStart(teclado);
				default -> System.out.println("Essa opção não é valida");
			}
		}

	}
}
