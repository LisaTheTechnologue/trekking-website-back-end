package com.ngantcb.trekking.repository;

import com.ngantcb.trekking.entity.User;
import com.ngantcb.trekking.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findFirstByEmail(String email);

    User findByRole(UserRole userRole);
}