package com.testcase.one.DAO;

import com.testcase.one.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {

    @Query(value = "insert into user_role values ( ?1, 2 )  ",nativeQuery = true)
    void saveUserRole(String userid);

}

