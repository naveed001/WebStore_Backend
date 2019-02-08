package com.testcase.one.Service;

import com.testcase.one.DAO.UserDAO;
import com.testcase.one.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> getUserList(){
        return userDAO.findAll();
    }

    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    public User getUserByUsername(String username) {
        return userDAO.findByUserName(username).get();
    }
    public boolean checkuser(String username){
        return userDAO.findByUserName(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = getUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("user" + username + "does not exist");
        }

        String role = user.getRole();

        List<GrantedAuthority> grantList = new ArrayList<>();

        GrantedAuthority authority = new SimpleGrantedAuthority(role);

        grantList.add(authority);


        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), true, true,
                true, true, grantList);
    }

    public int CurrentUser(){
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = userDetails.getUsername();
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String username = loggedInUser.getName();
            return getUserByUsername(username).getUserId();
    }

    public User getUserProfiles(int id){
        return userDAO.findByUserId(id);
    }
}

