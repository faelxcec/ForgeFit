package com.fael.ForgeFit.services;

import com.fael.ForgeFit.entity.User;
import com.fael.ForgeFit.entity.Workout;
import com.fael.ForgeFit.repository.UserRepository;
import com.fael.ForgeFit.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;

    public WorkoutService(
            WorkoutRepository workoutRepository,
            UserRepository userRepository
    ) {
        this.workoutRepository = workoutRepository;
        this.userRepository = userRepository;
    }

    public void createWorkout(String workoutName, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        Workout workout = new Workout();

        workout.setName(workoutName);
        workout.setUser(user);

        workoutRepository.save(workout);
    }
}

