package com.fael.ForgeFit.Principal;

import com.fael.ForgeFit.repository.UserRepository;
import com.fael.ForgeFit.services.AuthService;

import java.util.Scanner;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private AuthService authService = new AuthService();
    UserRepository userRepository;
    public Principal (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void start(){
        System.out.println("\n----------------------------------------------------------------------------------\n" +
                "                               FORGE FIT INIT\n" +
                "----------------------------------------------------------------------------------"
        );
        var options = -1;
        var menu = "Escolha uma opção:\n" +
                "1 - Registrar\n" +
                "2 - Login\n" +
                "0 - Sair\n";
        while(options != 0){
            System.out.printf(menu);
            options = sc.nextInt();
            switch(options){
                case 1 -> authService.register(userRepository);
                case 2 -> authService.login();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção Inválida");
            }
        }
    }

}
