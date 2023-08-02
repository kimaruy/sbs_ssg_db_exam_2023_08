package com.sbs.java.ssg.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.db.DBConnection;
import com.sbs.java.ssg.dto.Article;
import com.sbs.java.ssg.dto.ArticleReply;
import com.sbs.java.ssg.dto.Member;

public class ArticleReplyDao {
	public List<ArticleReply> replies;
	private DBConnection dbConnection;

	public ArticleReplyDao() {
		replies = new ArrayList<>();
		dbConnection = Container.getDBConnection();
	}
	
	public int articleReplyWrite(ArticleReply articleReply) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("INSERT INTO articleReply "));
		sb.append(String.format("SET regDate = NOW(), "));
		sb.append(String.format("updateDate = NOW(), "));
		sb.append(String.format("`body` = '%s', ", articleReply.body));
		sb.append(String.format("nickname = '%s', ", articleReply.nickname));
		sb.append(String.format("memberId = '%d', ", articleReply.memberId));
		sb.append(String.format("articleId = '%d', ", articleReply.articleId));
		sb.append(String.format("`like` = '%d' ", articleReply.like));

		return dbConnection.insert(sb.toString());
	}

	public int delete(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("DELETE FROM articleReply "));
		sb.append(String.format("WHERE id = '%d' ", id));

		return dbConnection.delete(sb.toString());
	}
	
	public int likeDelete(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("DELETE FROM articleReplyLike "));
		sb.append(String.format("WHERE articleReplyId = '%d' ", id));

		return dbConnection.delete(sb.toString());
	}

	public List<ArticleReply> getReplies(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT R.* "));
		sb.append(String.format("FROM articleReply AS R "));
		sb.append(String.format("INNER JOIN `article` AS A "));
		sb.append(String.format("ON R.articleId = A.id "));
		sb.append(String.format("WHERE A.id = %d ", id));

		List<ArticleReply> replies = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

		for (Map<String, Object> row : rows) {
			replies.add(new ArticleReply(row));
		}

		return replies;
	}
	
	public int increaseReplyLike(int id, ArticleReply articleReply) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("UPDATE articleReply "));
		sb.append(String.format("SET `like` = '%d' ", articleReply.like + 1));
		sb.append(String.format("`like` = '%d' ", articleReply.like + 1));
		sb.append(String.format("WHERE id = '%d' ", id));

		return dbConnection.update(sb.toString());
	}
	
	public ArticleReply getForPrintArticleReply(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * FROM articleReply "));
		sb.append(String.format("WHERE articleReply.id = '%d' ", id));

		Map<String, Object> row = dbConnection.selectRow(sb.toString());

		if (row.isEmpty()) {
			return null;
		}

		return new ArticleReply(row);
	}
	
	public void increaseLike(ArticleReply articleReply, Member member) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM articleReplyLike "));
		sb.append(String.format("WHERE memberId = '%d' ", member.id));
		sb.append(String.format("and "));
		sb.append(String.format("articleReplyId = '%d' ", articleReply.id));

		Map<String, Object> row = dbConnection.selectRow(sb.toString());

		if (row.isEmpty()) {
			StringBuilder sbs = new StringBuilder();

			// 트랜잭션 필수
			sbs.append(String.format("INSERT INTO articleReplyLike "));
			sbs.append(String.format("SET regDate = NOW(), "));
			sbs.append(String.format("memberId = '%d', ", member.id));
			sbs.append(String.format("articleReplyId = '%d' ", articleReply.id));

			dbConnection.insert(sbs.toString());

			StringBuilder sbsb = new StringBuilder();

			sbsb.append(String.format("UPDATE articleReply "));
			sbsb.append(String.format("SET updateDate = NOW(), "));
			sbsb.append(String.format("`like` = '%d' ", articleReply.like + 1));
			sbsb.append(String.format("WHERE id = '%d' ", articleReply.id));

			dbConnection.update(sbsb.toString());

			System.out.println("댓글이 추천되었습니다.");
		} else {
			StringBuilder sbs = new StringBuilder();

			// 트랜잭션 필수
			sbs.append(String.format("DELETE FROM articleReplyLike "));
			sbs.append(String.format("WHERE id = '%d' ", articleReply.id));

			dbConnection.delete(sbs.toString());

			StringBuilder sbsb = new StringBuilder();

			sbsb.append(String.format("UPDATE articleReply "));
			sbsb.append(String.format("SET updateDate = NOW(), "));
			sbsb.append(String.format("`like` = '%d' ", articleReply.like - 1));
			sbsb.append(String.format("WHERE id = '%d' ", articleReply.id));

			dbConnection.update(sbsb.toString());

			System.out.println("댓글 추천이 취소되었습니다.");
		}
	}
}