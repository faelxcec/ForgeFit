package com.fael.ForgeFit.services;

import com.fael.ForgeFit.entity.User;
import com.fael.ForgeFit.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;

import javax.sound.midi.Soundbank;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AuthService {
    private Scanner scanner = new Scanner(System.in);

    public void register(UserRepository userRepository) {
        LocalDateTime createdAt;
        System.out.println("Digite seu nome: ");
        String name = scanner.nextLine();
        String pedidoEmail = "Email: ";
        String email;

        int contador = 1;
        do {
            System.out.println(pedidoEmail);
            if (contador > 0) pedidoEmail="Digite um email válido: ";
            email = scanner.nextLine();
            contador++;
        } while (email.isEmpty() || !email.contains("@"));
        String password;
        String confirmPassword;
        boolean valido = true;
        do{
            System.out.println("Senha: ");
            password = scanner.nextLine();
            if (password.length() < 8) {
                System.out.println("Sua senha deve conter ao menos 8 dígitos!");
                continue;
            };
            System.out.println("Confirme sua senha: ");
            confirmPassword = scanner.nextLine();
            if (!confirmPassword.equals(password)) {
                System.out.println("Senhas não coincidem!");
                continue;
            }else  {
                valido = false;
            }
        } while (valido);

        User user = new User(name, email, password);

        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            String erro = e.getStackTrace().toString();
            if (erro.contains("already exists") && erro.contains("email")) {
                System.out.println("O email já existe! Faça login");
            }
        }
    }
    public void login(){
    }
}
