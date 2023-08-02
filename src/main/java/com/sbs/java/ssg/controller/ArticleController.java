package com.sbs.java.ssg.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.dto.Article;
import com.sbs.java.ssg.dto.ArticleReply;
import com.sbs.java.ssg.dto.Board;
import com.sbs.java.ssg.dto.FoodProduct;
import com.sbs.java.ssg.dto.Member;
import com.sbs.java.ssg.dto.WearProduct;
import com.sbs.java.ssg.service.ArticleReplyService;
import com.sbs.java.ssg.service.ArticleService;
import com.sbs.java.ssg.service.MemberService;

public class ArticleController extends Controller {
	private Scanner sc;
	private String command;
	private ArticleService articleService;
	private MemberService memberService;
	private Session session;
	private ArticleReplyService articleReplyService;

	public ArticleController() {
		sc = Container.getScanner();
		session = Container.getSession();
		articleService = Container.articleService;
		memberService = Container.memberService;
		articleReplyService = Container.articleReplyService;
	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;

		switch (actionMethodName) {
		case "list":
			showList();
			break;
		case "detail":
			showDetail();
			break;
		case "write":
			doWrite();
			break;
		case "modify":
			doModify();
			break;
		case "delete":
			doDelete();
			break;
		case "changeBoard":
			doChangeBoard();
			break;
		case "currentBoard":
			doCurrentBoard();
			break;
		case "allWearProduct":
			doWearProduct();
			break;
		case "allFoodProduct":
			doFoodProduct();
			break;
		default:
			System.out.println("존재하지 않는 명령어 입니다.");
			break;
		}
	}

	private void doFoodProduct() {
		List<FoodProduct> foundFoodProduct = articleService.getFoodProducts();
		
		int foundFoodProductSize = foundFoodProduct.size();
		FoodProduct arrFood[] = foundFoodProduct.toArray(new FoodProduct[foundFoodProductSize]);
		
		System.out.println("|=====================================================================================================================================|");
		for (int i = 0; i <= arrFood.length - 1; i++) {
			System.out.println((arrFood[i]));
			System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------|");
		}	
		String Buy;
		String answer;
		System.out.println("=======================================");
		System.out.println("|                                     |");
		System.out.println("|      상품을 구매 하시겠습니까?      |");
		System.out.println("|                                     |");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println("|                  |                  |");
		System.out.println("|      1. 예       |     2. 아니오    |");
		System.out.println("|                  |                  |");
		System.out.println("=======================================");
		answer = sc.nextLine();
			if(answer.equals("1")) {
				System.out.printf("구매 하실 상품명을 적어주세요. : ");
				Buy = sc.nextLine();
				System.out.println("==================================================================================");
				System.out.println();
				System.out.printf ("     감사합니다. 선택하신 \"%s\" 상품이 정상적으로 구매 되었습니다.\n",Buy);   
				System.out.println();
				System.out.println("==================================================================================");
			}
			else if(answer.equals("2")) {
				System.out.println("=======================================");
				System.out.println("|                                     |");
				System.out.println("|      이용해 주셔서 감사합니다.      |");
				System.out.println("|                                     |");
				System.out.println("=======================================");
			}
			else {
				System.err.println("잘못 입력하셨습니다.");
			}
	}
	
	
	private void doWearProduct() {
		List<WearProduct> foundFProduct = articleService.getFProducts();
		List<WearProduct> foundMProduct = articleService.getMProducts();

		int foundFProductSize = foundFProduct.size();
		WearProduct arrF[] = foundFProduct.toArray(new WearProduct[foundFProductSize]);

		int foundMProductSize = foundMProduct.size();
		WearProduct arrM[] = foundMProduct.toArray(new WearProduct[foundMProductSize]);
		System.out.println("=================================");
		System.out.println("|    1. 여자    |    2. 남자    |");
		System.out.println("=================================");
		String sex = sc.nextLine();

		
		System.out.println("|=======================================================================================================================================|");
		if (sex.equals("1")) {
			for (int i = 0; i <= arrF.length - 1; i++) {
				System.out.println((arrF[i]));
				System.out.println("|---------------------------------------------------------------------------------------------------------------------------------------|");		
			}
		} else if (sex.equals("2")) {
			for (int i = 0; i <= arrM.length - 1; i++) {
				System.out.println((arrM[i]));
				System.out.println("|---------------------------------------------------------------------------------------------------------------------------------------|");
			}
		}
		String Buy;
		String answer;
		System.out.println("=======================================");
		System.out.println("|                                     |");
		System.out.println("|      상품을 구매 하시겠습니까?      |");
		System.out.println("|                                     |");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println("|                  |                  |");
		System.out.println("|      1. 예       |     2. 아니오    |");
		System.out.println("|                  |                  |");
		System.out.println("=======================================");
		answer = sc.nextLine();
			if(answer.equals("1")) {
				System.out.printf("구매 하실 상품명을 적어주세요. : ");
				Buy = sc.nextLine();
				System.out.println("==================================================================================");
				System.out.println();
				System.out.printf ("     감사합니다. 선택하신 \"%s\" 상품이 정상적으로 구매 되었습니다.\n",Buy);   
				System.out.println();
				System.out.println("==================================================================================");
			}
			else if(answer.equals("2")) {
				System.out.println("=======================================");
				System.out.println("|                                     |");
				System.out.println("|      이용해 주셔서 감사합니다.      |");
				System.out.println("|                                     |");
				System.out.println("=======================================");
			}
			else {
				System.err.println("잘못 입력하셨습니다.");
			}
		
	}
	

	private void doCurrentBoard() {
		Board board = session.getCurrentBoard();
		System.out.printf("현재 게시판 : %s게시판\n", board.getName());
	}

	private void doChangeBoard() {
		System.out.println("==============================================");
		System.out.println("|             1. 공지사항 게시판             |");
		System.out.println("|--------------------------------------------|");
		System.out.println("|               2. 자유 게시판               |");
		System.out.println("|--------------------------------------------|");
		System.out.println("|             3. 식품 후기 게시판            |");
		System.out.println("|--------------------------------------------|");
		System.out.println("|            4. 운동복 후기 게시판           |");
		System.out.println("==============================================");
		System.out.printf("게시판 번호를 입력하세요 :  ");

		int boardCode = checkScNum();

		if (boardCode == 0) {
			return;
		}

		Board board = articleService.getBoard(boardCode);

		if (board == null) {
			System.err.println("해당 게시판이 존재하지 않습니다.");
		} else {
			System.out.printf("[%s 게시판]으로 변경되었습니다.\n", board.getName());
			session.setCurrentBoard(board);
		}

	}

	public void doWrite() {
		int memberId = session.getLoginedMember().getId();
		int boardId = session.getCurrentBoard().getId();
		String nickname = session.getLoginedMember().nickName;
		Board board = session.getCurrentBoard();
		Member loginedMember = session.getLoginedMember();

		if (boardId == 1) {
			if (loginedMember.id != 1) {
				System.err.println("공지게시판은 관리자만 작성할 수 있습니다.");
				return;
			}
		}

		System.out.printf("제목 : ");
		String title = sc.nextLine();
		System.out.printf("내용 : ");
		String body = sc.nextLine();

		int newId = articleService.articleWrite(memberId, boardId, nickname, title, body);

		System.out.printf("%d번 글이 생성되었습니다.\n", newId);
	}

	public void showList() {
		String searchKeyword = command.substring("article list".length()).trim();

		String boardCode = Container.getSession().getCurrentBoard().getCode();

		List<Article> forPrintArticles = articleService.getForPrintArticles(boardCode, searchKeyword);

		if (forPrintArticles.size() == 0) {
			System.err.println("검색결과가 존재하지 않습니다.");
			return;
		}

		String boardName = Container.getSession().getCurrentBoard().getName();

		System.out.printf("[%s 게시판]\n", boardName);
		System.out.println("|===========================================|");
		System.out.println("| 번호 |   작성자   | 조회 |      제목      |");
		System.out.println("|-------------------------------------------|");
		for (int i = 0; i <= forPrintArticles.size() - 1; i++) {
			Article article = forPrintArticles.get(i);
			Member member = memberService.getMember(article.memberId);

			System.out.printf("|  %d   |  %s  |  %d  | %s\n", article.id, member.nickName, article.hit, article.title);
		}
		System.out.println("|===========================================|");
	}

	public int checkScNum() {
		int id = 0;

		try {
			id = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.err.println("잘못 입력하셨습니다.");
			sc.nextLine();
			return 0;
		}

		return id;
	}

	public void showDetail() {
		System.out.print("게시물 번호를 입력하세요) ");

		int id = checkScNum();

		if (id == 0) {
			return;
		}

		Article foundArticle = articleService.getForPrintArticle(id);

		if (foundArticle == null) {
			System.err.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}

		articleService.increaseHit(id, foundArticle);
		System.out.println("|==============================================|");
		System.out.printf("|   번호 : %d\n", foundArticle.id);
		System.out.println("|----------------------------------------------|");
		System.out.printf("|   날짜 : %s\n", foundArticle.regDate);
		System.out.println("|----------------------------------------------|");
		System.out.printf("|   작성자 : %s\n", foundArticle.nickname);
		System.out.println("|----------------------------------------------|");
		System.out.printf("|   제목 : %s\n", foundArticle.title);
		System.out.println("|----------------------------------------------|");
		System.out.printf("|   내용 : %s\n", foundArticle.body);
		System.out.println("|----------------------------------------------|");
		System.out.printf("|   조회 : %d\n", foundArticle.hit + 1);
		System.out.println("|----------------------------------------------|");
		System.out.printf("|   추천 : %d\n", foundArticle.like);
		System.out.println("|==================== 댓글 ====================|");

		List<ArticleReply> forPrintReplies = articleReplyService.getReplies(id);

		for (int i = 0; i <= forPrintReplies.size() - 1; i++) {
			ArticleReply reply = forPrintReplies.get(i);

			System.out.printf("댓글 번호: %d\n작성자 : %s\n내용 : %s\n추천 : %d\n", reply.id, reply.nickname, reply.body,
					reply.like);
			System.out.println("|----------------------------------------------|");
		}


		Member member = Container.session.getLoginedMember();
		System.out.println("|==========================================|");
		System.out.println("|            1. 게시글 추천/취소           |");
		System.out.println("|------------------------------------------|");
		System.out.println("|                 2. 댓글                  |");
		System.out.println("|------------------------------------------|");
		System.out.println("|            3. 댓글 추천/취소             |");
		System.out.println("|------------------------------------------|");
		System.out.println("|               4. 댓글 삭제               |");
		System.out.println("|------------------------------------------|");
		System.out.println("|                5. 나가기                 |");
		System.out.println("|==========================================|");
		System.out.printf("번호를 입력하세요 : ");
		String feature = sc.nextLine();

		if (feature.equals("1")) {
			articleService.increaseLike(foundArticle, member);
		} else if (feature.equals("2")) {
			System.out.printf("내용 : ");
			String body = sc.nextLine();

			int memberId = session.getLoginedMember().getId();
			int articleId = foundArticle.id;
			String name = session.getLoginedMember().nickName;

			int newId = articleReplyService.articleReplyWrite(memberId, articleId, name, body);

			System.out.printf("%d번째 댓글이 생성되었습니다.\n", newId);
		} else if (feature.equals("3")) {
			System.out.print("댓글 번호를 입력하세요) ");

			int replyId = checkScNum();

			if (replyId == 0) {
				return;
			}

			ArticleReply foundReply = articleReplyService.getForPrintArticleReply(replyId);

			if (foundReply == null) {
				System.err.printf("%d번 댓글은 존재하지 않습니다.\n", replyId);
			}

			articleReplyService.increaseLike(foundReply, member);
		} else if (feature.equals("4")) {
			System.out.print("삭제할 댓글 번호를 입력하세요) ");

			int replyId = checkScNum();

			if (replyId == 0) {
				return;
			}

			ArticleReply foundReply = articleReplyService.getForPrintArticleReply(replyId);

			if (foundReply == null) {
				System.err.printf("%d번 댓글은 존재하지 않습니다.\n", replyId);
				return;
			}

			Member loginedMember = session.getLoginedMember();

			if (foundReply.memberId != loginedMember.id) {
				if (loginedMember.id == 1) {
					articleReplyService.likeDelete(foundReply.id);
					articleReplyService.delete(foundReply.id);
					System.out.printf("%d번 댓글이 삭제되었습니다.\n", foundReply.id);
					return;
				}
				System.err.println("권한이 없습니다.");
				return;
			}

			articleReplyService.likeDelete(foundReply.id);
			articleReplyService.delete(foundReply.id);
			System.out.printf("%d번 댓글이 삭제되었습니다.\n", foundReply.id);
		} else if (feature.equals("5")) {
			return;
		}
	}

	public void doModify() {
		System.out.print("수정할 게시물 번호를 입력하세요) ");

		int id = checkScNum();

		if (id == 0) {
			return;
		}

		Article foundArticle = articleService.getArticle(id);

		if (foundArticle == null) {
			System.err.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}

		Member loginedMember = session.getLoginedMember();

		if (foundArticle.memberId != loginedMember.id) {
			System.err.println("권한이 없습니다.");
			return;
		}

		System.out.printf("제목 : ");
		String title = sc.nextLine();
		System.out.printf("내용 : ");
		String body = sc.nextLine();

		articleService.Likemodify(foundArticle.id);
		articleService.modify(foundArticle.id, title, body);

		System.out.printf("%d번 게시물이 수정되었습니다.\n", foundArticle.id);
	}

	public void doDelete() {
		System.out.print("삭제할 게시물 번호를 입력하세요) ");

		int id = checkScNum();

		if (id == 0) {
			return;
		}

		Article foundArticle = articleService.getArticle(id);

		if (foundArticle == null) {
			System.err.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}

		Member loginedMember = session.getLoginedMember();

		if (foundArticle.memberId != loginedMember.id) {
			if (loginedMember.id == 1) {
				articleService.likeDelete(foundArticle.id);
				articleService.delete(foundArticle.id);
				System.out.printf("%d번 게시물이 삭제되었습니다.\n", foundArticle.id);
				return;
			}
			System.err.println("권한이 없습니다.");
			return;
		}

		articleService.likeDelete(foundArticle.id);
		articleService.delete(foundArticle.id);
		System.out.printf("%d번 게시물이 삭제되었습니다.\n", foundArticle.id);
	}

}