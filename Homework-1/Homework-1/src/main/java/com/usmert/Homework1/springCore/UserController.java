package com.usmert.Homework1.springCore;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

   private final IUserDao userDao;

    @PostMapping("/newUser")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        user = userDao.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/findAllUser")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> userList = userDao.findAll();

        return ResponseEntity.ok(userList);
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity findUser(@PathVariable Long id){

        User user = userDao.findById(id).orElseThrow();

        return ResponseEntity.ok(user);
    }



    @PatchMapping("/makePassive/{id}")
    public ResponseEntity makePassive(@PathVariable Long id){

        User user = userDao.findById(id).orElseThrow();

        user.setActive(Boolean.FALSE);

        user = userDao.save(user);

        return ResponseEntity.ok(user);
    }


    @PatchMapping("/updateUser/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, String userName, String userLastName, String userEmail, String userTelephoneNumber){

        User user = userDao.findById(id).orElseThrow();

        user.setUserName(userName);
        user.setUserLastName(userLastName);
        user.setUserEmail(userEmail);
        user.setUserTelephoneNumber(userTelephoneNumber);


        user = userDao.save(user);

        return ResponseEntity.ok(user);
    }

}
