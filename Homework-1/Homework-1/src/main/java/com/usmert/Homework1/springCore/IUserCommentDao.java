package com.usmert.Homework1.springCore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserCommentDao extends JpaRepository<UserComment,Long> {


}
