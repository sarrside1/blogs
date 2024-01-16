package com.bourguiba.myblolg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bourguiba.myblolg.entiy.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
