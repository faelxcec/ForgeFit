package com.fael.ForgeFit;

import com.fael.ForgeFit.Principal.Principal;
import com.fael.ForgeFit.repository.UserRepository;
import com.fael.ForgeFit.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForgeFitApplication implements CommandLineRunner {

	private Principal principal;
	public ForgeFitApplication(Principal principal) {
		this.principal = principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(ForgeFitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.start();
	}
}
