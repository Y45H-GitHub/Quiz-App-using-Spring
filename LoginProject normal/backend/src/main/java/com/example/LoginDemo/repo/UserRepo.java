package com.example.LoginDemo.repo;

import com.example.LoginDemo.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, String> {
    UserDetails findByEmail(String email);
    UserDetails findByUsername(String username);
}
