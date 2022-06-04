package com.usmert.Homework1.springCore;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/userComments")
public class UserCommentController {

    private final IUserCommentDao userCommentDao;

    @PostMapping("/saveComment")
    public ResponseEntity<UserComment> saveComment(@RequestBody UserComment userComment){

        userComment = userCommentDao.save(userComment);
        return new ResponseEntity<>(userComment, HttpStatus.CREATED);
    }


    @GetMapping("/getAllComment")
    public ResponseEntity<List<UserComment>> getAllUserComments(){

        List<UserComment> userCommentList = userCommentDao.findAll();

        return ResponseEntity.ok(userCommentList);
    }


    @DeleteMapping("deleteComment/{id}")
    public void delete(@PathVariable Long id){
        userCommentDao.deleteById(id);
    }


    @PatchMapping("/updateComment/{id}")
    public ResponseEntity updateComment(@PathVariable Long id,String comment){

        UserComment userComment = userCommentDao.findById(id).orElseThrow();

        userComment.setUserComment(comment);

        userComment = userCommentDao.save(userComment);

        return ResponseEntity.ok(userComment);
    }





}
