package com.sbs.java.ssg.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.db.DBConnection;
import com.sbs.java.ssg.dto.Article;
import com.sbs.java.ssg.dto.Board;
import com.sbs.java.ssg.dto.FoodProduct;
import com.sbs.java.ssg.dto.Member;
import com.sbs.java.ssg.dto.WearProduct;

public class ArticleDao extends Dao {
	public List<Article> articles;
	private DBConnection dbConnection;

	public ArticleDao() {
		articles = new ArrayList<>();
		dbConnection = Container.getDBConnection();
	}

	public int write(Article article) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("INSERT INTO article "));
		sb.append(String.format("SET regDate = NOW(), "));
		sb.append(String.format("updateDate = NOW(), "));
		sb.append(String.format("title = '%s', ", article.title));
		sb.append(String.format("body = '%s', ", article.body));
		sb.append(String.format("nickname = '%s', ", article.nickname));
		sb.append(String.format("memberId = '%d', ", article.memberId));
		sb.append(String.format("boardId = '%d', ", article.boardId));
		sb.append(String.format("hit = '%d', ", article.hit));
		sb.append(String.format("`like` = '%d' ", article.like));

		return dbConnection.insert(sb.toString());
	}

	public List<Article> getArticles() {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * FROM article"));

		List<Article> articles = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

		for (Map<String, Object> row : rows) {
			articles.add(new Article(row));
		}

		return articles;
	}

	public List<Article> getForPrintArticles(String boardCode, String searchkeyword) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT A.* "));
		sb.append(String.format("FROM `article` AS A "));
		sb.append(String.format("INNER JOIN `board` AS B "));
		sb.append(String.format("ON A.boardId = B.id "));
		sb.append(String.format("WHERE B.`code` = '%s' ", boardCode));
		if (searchkeyword.length() > 0) {
			sb.append(String.format("AND A.title LIKE '%%%s%%' ", searchkeyword));
		}
		sb.append(String.format("ORDER BY A.id DESC "));

		List<Article> articles = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

		for (Map<String, Object> row : rows) {
			articles.add(new Article(row));
		}

		return articles;
	}

	public Article getArticle(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM article "));
		sb.append(String.format("WHERE id = '%d' ", id));

		Map<String, Object> row = dbConnection.selectRow(sb.toString());

		if (row.isEmpty()) {
			return null;
		}

		return new Article(row);
	}

	public Article getForPrintArticle(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT A.*, M.nickname AS extra__writerName "));
		sb.append(String.format("FROM article AS A "));
		sb.append(String.format("INNER JOIN `member` as M "));
		sb.append(String.format("ON A.memberId = M.id "));
		sb.append(String.format("WHERE A.id = '%d' ", id));

		Map<String, Object> row = dbConnection.selectRow(sb.toString());

		if (row.isEmpty()) {
			return null;
		}

		return new Article(row);
	}

	public int modify(int id, String title, String body) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("UPDATE article "));
		sb.append(String.format("SET updateDate = NOW(), "));
		sb.append(String.format("title = '%s', ", title));
		sb.append(String.format("body = '%s' ", body));
		sb.append(String.format("WHERE id = '%d' ", id));

		return dbConnection.update(sb.toString());
	}
	
	public int Likemodify(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("UPDATE articleLike "));
		sb.append(String.format("SET regDate = NOW() "));
		sb.append(String.format("WHERE id = '%d' ", id));

		return dbConnection.update(sb.toString());
	}

	public int delete(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("DELETE FROM article "));
		sb.append(String.format("WHERE id = '%d' ", id));

		return dbConnection.delete(sb.toString());
	}

	public int likeDelete(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("DELETE FROM articleLike "));
		sb.append(String.format("WHERE articleId = '%d' ", id));

		return dbConnection.delete(sb.toString());
	}

	public Board getBoard(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM `board` "));
		sb.append(String.format("WHERE id = '%d' ", id));

		Map<String, Object> row = dbConnection.selectRow(sb.toString());

		if (row.isEmpty()) {
			return null;
		}

		return new Board(row);
	}

	public int increaseHit(int id, Article article) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("UPDATE article "));
		sb.append(String.format("SET updateDate = NOW(), "));
		sb.append(String.format("hit = '%d' ", article.hit + 1));
		sb.append(String.format("WHERE id = '%d' ", id));

		return dbConnection.update(sb.toString());
	}

	public void increaseLike(Article article, Member member) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM articleLike "));
		sb.append(String.format("WHERE memberId = '%d' ", member.id));
		sb.append(String.format("and "));
		sb.append(String.format("articleId = '%d' ", article.id));

		Map<String, Object> row = dbConnection.selectRow(sb.toString());

		if (row.isEmpty()) {
			StringBuilder sbs = new StringBuilder();

			// 트랜잭션 필수
			sbs.append(String.format("INSERT INTO articleLike "));
			sbs.append(String.format("SET regDate = NOW(), "));
			sbs.append(String.format("memberId = '%d', ", member.id));
			sbs.append(String.format("articleId = '%d' ", article.id));

			dbConnection.insert(sbs.toString());

			StringBuilder sbsb = new StringBuilder();

			sbsb.append(String.format("UPDATE article "));
			sbsb.append(String.format("SET updateDate = NOW(), "));
			sbsb.append(String.format("`like` = '%d' ", article.like + 1));
			sbsb.append(String.format("WHERE id = '%d' ", article.id));

			dbConnection.update(sbsb.toString());

			System.out.println("게시글이 추천되었습니다.");
		} else {
			StringBuilder sbs = new StringBuilder();

			// 트랜잭션 필수
			sbs.append(String.format("DELETE FROM articleLike "));
			sbs.append(String.format("WHERE id = '%d' ", article.id));

			dbConnection.delete(sbs.toString());

			StringBuilder sbsb = new StringBuilder();

			sbsb.append(String.format("UPDATE article "));
			sbsb.append(String.format("SET updateDate = NOW(), "));
			sbsb.append(String.format("`like` = '%d' ", article.like - 1));
			sbsb.append(String.format("WHERE id = '%d' ", article.id));

			dbConnection.update(sbsb.toString());

			System.out.println("게시글이 추천이 취소되었습니다.");
		}
	}
	
	public List<WearProduct> getFProducts() {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * FROM sportsrecommend "));
		sb.append(String.format("WHERE sex = '여자' "));

		List<WearProduct> products = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

		for (Map<String, Object> row : rows) {
			products.add(new WearProduct(row));
		}

		return products;
	}
	
	public List<WearProduct> getMProducts() {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * FROM sportsrecommend "));
		sb.append(String.format("WHERE sex = '남자' "));

		List<WearProduct> products = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

		for (Map<String, Object> row : rows) {
			products.add(new WearProduct(row));
		}

		return products;
	}
	
	public List<FoodProduct> getFoodProducts() {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * FROM foodRecommend "));

		List<FoodProduct> products = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

		for (Map<String, Object> row : rows) {
			products.add(new FoodProduct(row));
		}

		return products;
	}
}