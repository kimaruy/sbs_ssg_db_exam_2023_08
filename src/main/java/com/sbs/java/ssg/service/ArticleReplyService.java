package com.sbs.java.ssg.service;

import java.util.List;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.dao.ArticleReplyDao;
import com.sbs.java.ssg.dto.Article;
import com.sbs.java.ssg.dto.ArticleReply;
import com.sbs.java.ssg.dto.Member;

public class ArticleReplyService {
	private ArticleReplyDao articleReplyDao;

	public ArticleReplyService() {
		articleReplyDao = Container.articleReplyDao;
	}

	public int articleReplyWrite(int memberId, int articleId, String name, String body) {
		ArticleReply articleReply = new ArticleReply(memberId, articleId, name, body);
		return articleReplyDao.articleReplyWrite(articleReply);
	}
	
	public void delete(int id) {
		articleReplyDao.delete(id);
	}
	
	public void likeDelete(int id) {
		articleReplyDao.likeDelete(id);
	}
	
	public List<ArticleReply> getReplies(int id) {
		return articleReplyDao.getReplies(id);
	}

	public void increaseLike(ArticleReply articleReply, Member member) {
		articleReplyDao.increaseLike(articleReply, member);
	}
	
	public ArticleReply getForPrintArticleReply(int id) {
		return articleReplyDao.getForPrintArticleReply(id);
	}
}