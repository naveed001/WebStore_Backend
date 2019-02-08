package com.testcase.one.Controller;

import com.testcase.one.DAO.RoleDAO;
import com.testcase.one.Model.User;
import com.testcase.one.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleDAO roleDAO;

    @PostMapping("/login")
    @ResponseBody
    public User login(@RequestParam("username") String username, @RequestParam("password") String password){
        int userid = userService.CurrentUser();
        return userService.getUserProfiles(userid);
    }

    @RequestMapping(value = "/saveuserdetails", method = RequestMethod.POST)
    @ResponseBody
    public int  saveUserDetails(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("address") String address){

        if(userService.checkuser(username)){
            return 1;
        }

        else {
            User user = new User(username, password, email, address, "USER");
            userService.saveUser(user);
            return 0;
        }
    }

    @RequestMapping("/getprofile")
    @ResponseBody
    public User getUserProfiles(){
       int userid = userService.CurrentUser();
        return userService.getUserProfiles(userid);
    }

    @RequestMapping("/checkUser")
    @ResponseBody
    public int checkUser(){
        int userid = userService.CurrentUser();
           return userid;
    }

    @RequestMapping("/checkUserRole")
    @ResponseBody
    public String checkUserRole(){
        int userid = userService.CurrentUser();
        return userService.getUserProfiles(userid).getRole();
    }

    @RequestMapping("/updateuserprofile")
    @ResponseBody
    public void updateProfiles( @RequestParam("email") String email,@RequestParam("address")String address ){
        int userid = userService.CurrentUser();
        User user = userService.getUserProfiles(userid);
        user.setAddress(address);
        user.setEmail(email);
        userService.saveUser(user);
    }

    @RequestMapping(value = "/updateuserpassword", method = RequestMethod.POST)
    @ResponseBody
    public int updatepassword(@RequestParam("username")String username, @RequestParam("password")String password) {

         if(userService.checkuser(username)) {
             User user = userService.getUserByUsername(username);
             user.setPassword(password);
             userService.saveUser(user);
             return 0;
         }
         else {
          return 1;
         }
    }
}
