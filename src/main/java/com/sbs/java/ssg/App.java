package com.sbs.java.ssg;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.controller.ArticleController;
import com.sbs.java.ssg.controller.Controller;
import com.sbs.java.ssg.controller.ExportController;
import com.sbs.java.ssg.controller.MemberController;
import com.sbs.java.ssg.db.DBConnection;

public class App {
	public App() {
		DBConnection.DB_NAME = "sbs_proj";
		DBConnection.DB_USER = "sbsst";
		DBConnection.DB_PASSWORD = "sbs123414";
		DBConnection.DB_PORT = 3306;
		
		Container.getDBConnection().connect();
		
		// 현재 게시판을 1번 게시판으로 선택
		Container.getSession().setCurrentBoard(Container.articleService.getBoard(1));
	}
	
	public void start() {
		

		MemberController memberController = new MemberController();
		ArticleController articleController = new ArticleController();
		ExportController exportController = new ExportController();
		
		while (true) {
			System.out.println("=============================================================================");
			System.out.println("|                                                                           |");
			System.out.println("|                               명령어 모음                                 |");
			System.out.println("|                                                                           |");
			System.out.println("|===========================================================================|");
			System.out.println("|  1. 회원가입 : member join                                                |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  2. 로그인 : member login                                                 |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  3. 로그아웃 : member logout                                              |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  4. 회원탈퇴 : member delete                                              |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  5. 현재 게시판 확인 : article currentBoard                               |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  6. 게시판 변경 : article changeBoard                                     |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  7. 게시물 리스트 : article list                                          |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  8. 게시물 상세 : article detail                                          |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  9. 게시물 작성(로그인 후 이용가능) : article write                       |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  10. 게시물 수정(로그인 후 이용가능) : article modify                     |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  11. 게시물 삭제(로그인 후 이용가능) : article delete                     |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  12. 마이페이지 이동(로그인 후 이용가능) : member mypage                  |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  13. 제품 추천(로그인 후 이용가능) : member recommendedProduct            |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  14. 모든 운동복 구매정보(로그인 후 이용가능) : article allWearProduct    |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("|  15. 모든 식품 구매정보(로그인 후 이용가능) : article allFoodProduct      |");
			System.out.println("=============================================================================");
			
			System.out.printf("명령어 입력 : ");
			String command = Container.getScanner().nextLine();
			command = command.trim();

			if (command.length() == 0) {
				continue;
			}

			if (command.equals("종료")) {
				break;
			}
			
			String[] commandBits = command.split(" "); // article detail
			
			if ( commandBits.length == 1 ) {
				System.out.println("존재하지 않는 명령어 입니다.");
				continue;
			}
			
			String controllerName = commandBits[0]; // article 
			String actionMethodName = commandBits[1]; // detail
			
			Controller controller = null;
			
			if ( controllerName.equals("article") ) {
				controller = articleController;
			} else if ( controllerName.equals("member") ) {
				controller = memberController;
			} else if ( controllerName.equals("export") ) {
				controller = exportController;
			} else {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}
			
			String actionName = controllerName + "/" + actionMethodName;
			// article/list
			
			switch (actionName) {
			case "article/write":
			case "article/delete":
			case "article/modify":
			case "member/logout":
			case "member/mypage":
			case "member/recommendedProduct":
				if ( Container.getSession().isLogined() == false ) {
					System.out.println("로그인 후 이용해주세요.");
					continue;
				}
				break;
			}
			
			switch (actionName) {
			case "member/login":
			case "member/join":
				if ( Container.getSession().isLogined() ) {
					System.out.println("로그아웃 후 이용해주세요.");
					continue;
				}
				break;
			}
			
			
			controller.doAction(command, actionMethodName);
		}

		Container.getDBConnection().close();
		Container.getScanner().close();
		
		System.out.println("== 프로그램 끝 ==");
	}
}