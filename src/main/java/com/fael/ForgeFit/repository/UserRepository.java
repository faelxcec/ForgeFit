package com.fael.ForgeFit.repository;

import com.fael.ForgeFit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
