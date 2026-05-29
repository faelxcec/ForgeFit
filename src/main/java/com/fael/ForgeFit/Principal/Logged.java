package com.fael.ForgeFit.Principal;

import com.fael.ForgeFit.entity.User;
import com.fael.ForgeFit.repository.UserRepository;
import com.fael.ForgeFit.repository.WorkoutRepository;
import com.fael.ForgeFit.services.WorkoutService;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class Logged {
    private final Scanner scanner = new Scanner(System.in);
    private final WorkoutService workoutService;
    public Logged(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }


    public void menu(User loggedUser) {
        System.out.println("" +
                "1 - Criar Treino" +
                "2 - Acessar Treino" +
                "0 - Sair");
        int response = scanner.nextInt();
        switch (response){
            case 1 -> {
                workoutService.createWorkout("Primeiro Treino", loggedUser.getId());
            }
            case 0 -> System.exit(0);

        }

    }
}