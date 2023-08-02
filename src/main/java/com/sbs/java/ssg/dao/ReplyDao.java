package com.sbs.java.ssg.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.db.DBConnection;
import com.sbs.java.ssg.dto.Article;
import com.sbs.java.ssg.dto.Reply;

public class ReplyDao {
	public List<Reply> replies;
	private DBConnection dbConnection;

	public ReplyDao() {
		replies = new ArrayList<>();
		dbConnection = Container.getDBConnection();
	}

	public int ReplyWrite(Reply reply) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("INSERT INTO articleReply "));
		sb.append(String.format("SET regDate = NOW(), "));
		sb.append(String.format("updateDate = NOW(), "));
		sb.append(String.format("`body` = '%s', ", reply.body));
		sb.append(String.format("`name` = '%s', ", reply.name));
		sb.append(String.format("memberId = '%d', ", reply.memberId));
		sb.append(String.format("articleId = '%d', ", reply.articleId));
		sb.append(String.format("`like` = '%d' ", reply.like));

		return dbConnection.insert(sb.toString());
	}

	public int delete(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("DELETE FROM articleReply "));
		sb.append(String.format("WHERE id = '%d' ", id));

		return dbConnection.delete(sb.toString());
	}

	public List<Reply> getReplies(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT R.* "));
		sb.append(String.format("FROM articleReply AS R "));
		sb.append(String.format("INNER JOIN `article` AS A "));
		sb.append(String.format("ON R.articleId = A.id "));
		sb.append(String.format("WHERE A.id = %d ", id));

		List<Reply> replies = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

		for (Map<String, Object> row : rows) {
			replies.add(new Reply(row));
		}

		return replies;
	}
}