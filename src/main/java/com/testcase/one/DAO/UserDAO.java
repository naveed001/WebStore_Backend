package com.testcase.one.DAO;

import com.testcase.one.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User , Integer> {
    Optional<User> findByUserName(String username);
    User findByUserId(int id);
}
