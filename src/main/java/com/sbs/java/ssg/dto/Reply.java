package com.sbs.java.ssg.dto;

import java.util.Map;

import lombok.Data;

@Data
public class Reply extends Dto {
	public int articleId;
	public int memberId;
	public String body;
	public String name;
	public int like;

	public Reply(int memberId, int articleId, String name, String body) {
		this(memberId, articleId, name, body, 0);
	}

	public Reply(int memberId, int articleId, String name, String body, int like) {
		this.articleId = articleId;
		this.memberId = memberId;
		this.name = name;
		this.body = body;
		this.like = like;
	}

	public Reply(Map<String, Object> row) {
		super(row);
		this.memberId = (int) row.get("memberId");
		this.articleId = (int) row.get("articleId");
		this.name = (String) row.get("name");
		this.body = (String) row.get("body");
		this.like = (int) row.get("like");
	}
	
	public void increaseLike() {
		like++;
	}
}