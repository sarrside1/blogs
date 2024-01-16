package com.bourguiba.myblolg.services;

import com.bourguiba.myblolg.entiy.Comment;

public interface IComment {

	void createComment(Comment comment);
	Iterable<Comment> getComments();
}
