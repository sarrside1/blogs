package com.bourguiba.myblolg.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourguiba.myblolg.entiy.Comment;
import com.bourguiba.myblolg.repositories.CommentRepository;
import com.bourguiba.myblolg.services.IComment;

@Service
public class CommentImp implements IComment{

	@Autowired
	private CommentRepository commentRepo;
	@Override
	public void createComment(Comment comment) {
		commentRepo.save(comment);
		
	}

	@Override
	public Iterable<Comment> getComments() {
		return commentRepo.findAll();
	}

}
