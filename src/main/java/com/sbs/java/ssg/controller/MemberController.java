package com.sbs.java.ssg.controller;

import java.util.Scanner;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.dto.Member;
import com.sbs.java.ssg.service.MemberService;

public class MemberController extends Controller {
	private Scanner sc;
	private MemberService memberService;
	private Session session;
	private SportsWearRecommendedProductController sportsWearRecommendedProductController;
	private FoodRecommendedProductController foodRecommendedProductController;

	public MemberController() {
		sc = Container.getScanner();
		session = Container.getSession();
		memberService = Container.memberService;
		sportsWearRecommendedProductController = Container.sportsWearRecommendedProductController;
		foodRecommendedProductController = Container.foodRecommendedProductController;
	}

	public void doAction(String command, String actionMethodName) {
		switch (actionMethodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		case "logout":
			doLogout();
			break;
		case "delete":
			doDelete();
			break;
		case "mypage":
			doMypage();
			break;
		case "recommendedProduct":
			doRecommendedProduct();
			break;
		default:
			System.err.println("존재하지 않는 명령어 입니다.");
			break;
		}
	}

	private boolean isJoinableLoginId(String loginId) {
		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			return true;
		}

		return false;
	}

	private boolean isJoinablenickName(String nickName) {
		Member member = memberService.getMemberBynickName(nickName);

		if (member == null) {
			return true; // 중복이 아니다
		}

		return false; // 중복이다
	}

	public void doJoin() {
		String loginId = null;

		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();

			if (isJoinableLoginId(loginId) == false) {
				System.err.printf("%s(은)는 이미 사용중인 아이디입니다.\n", loginId);
				continue;
			}

			break;
		}

		String loginPw = null;
		String loginPwConfirm = null;

		while (true) {
			System.out.printf("로그인 비번 : ");
			loginPw = sc.nextLine();
			System.out.printf("로그인 비번확인 : ");
			loginPwConfirm = sc.nextLine();

			if (loginPw.equals(loginPwConfirm) == false) {
				System.err.println("비밀번호를 다시 입력해주세요.");
				continue;
			}

			break;
		}

		System.out.printf("이름 : ");
		String name = sc.nextLine();

		System.out.printf("닉네임 : ");
		String nickName = sc.nextLine();
		
		System.out.printf("이메일 : ");
		String e_mail = sc.nextLine();


		System.out.printf("성별(M/F) : ");
		String sex = sc.nextLine();
		if (sex.equals("m") || sex.equals("M")) {
			sex = "남자";
		} else if (sex.equals("f") || sex.equals("F")) {
			sex = "여자";
		} else {
			System.err.println("잘못 입력하셨습니다.");

		}
		System.out.printf("생년월일(6글자) : ");
		String birth = sc.nextLine();

		System.out.printf("키 : ");
		double height = sc.nextDouble();

		System.out.printf("몸무게 : ");
		double weight = sc.nextDouble();
		sc.nextLine();

		double bmi = weight / (height * height / 10000);

		String bmi_level;

		if (weight / (height * height / 10000) > 25) {
			bmi_level = "과체중";
		} else if (weight / (height * height / 10000) > 18.5) {
			bmi_level = "표준";
		} else {
			bmi_level = "저체중";
		}

		System.out.printf("bmi : %.1f\n", bmi);
		System.out.printf("bmi_level : %s\n", bmi_level);

		System.out.println("===================================================");
		System.out.println("|  1) 5kg 감량  |  2) 10kg 감량  |  3) 15kg 감량  |");
		System.out.println("===================================================");
		System.out.printf("감량 선택 : ");
		String loss = sc.nextLine();
		if (loss.equals("1")) {
			loss = "5kg 감량";

		} else if (loss.equals("2")) {
			loss = "10kg 감량";

		} else if (loss.equals("3")) {
			loss = "15kg 감량";

		} else {
			System.err.println("잘못 입력하셨습니다.");
		}

		System.out.println("===============================================");
		System.out.println("|  1) 1~3개월  |  2) 3~6개월  | 3)  6~12개월  |");
		System.out.println("===============================================");
		System.out.printf("개월 선택 : ");
		String months = sc.nextLine();
		if (months.equals("1")) {
			months = "1~3개월";
		} else if (months.equals("2")) {
			months = "3~6개월";
		} else if (months.equals("3")) {
			months = "6~12개월";
		} else {
			System.err.println("잘못 입력하셨습니다.");
		}

		System.out.println("==============================================");
		System.out.println("|    1.헬스   |    2.요가   |   3.필라테스   |");
		System.out.println("==============================================");
		System.out.printf("운동종목 선택 : ");
		String category = sc.nextLine();
		String category_level = "";
		if (category.equals("1")) {
			category = "헬스";
			System.out.println("=========================================================================");
			System.out.println("| 1.헬린이 :  (초보자들이 부담없이 운동할수있도록 도와줍니다.)          |");
			System.out.println("|-----------------------------------------------------------------------|");
			System.out.println("| 2.헬중이 :  (중급자들이 적극적으로 운동할수있게 도와줍니다.)          |");
			System.out.println("|-----------------------------------------------------------------------|");
			System.out.println("| 3.헬창이 :  (상급자들이 자신의 한계치까지 도달할수있도록 도와줍니다.) |");
			System.out.println("=========================================================================");
			System.out.printf("운동난이도 선택 : ");
			category_level = sc.nextLine();
			if (category_level.equals("1")) {
				category_level = "헬린이";
			} else if (category_level.equals("2")) {
				category_level = "헬중이";
			} else if (category_level.equals("3")) {
				category_level = "헬창이";
			} else {
				System.err.println("잘못 입력하셨습니다.");

			}
		} else if (category.equals("2")) {
			category = "요가";
			System.out.println("=============================================================================");
			System.out.println("| 1.요린이 : (초보자들이 부담없이 요가를 할수있도록 도와줍니다.)            |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("| 2.요중이 : (중급자들이 적극적으로 요가를 할수있게 도와줍니다.)            |");
			System.out.println("|---------------------------------------------------------------------------|");
			System.out.println("| 3.요른이 : (상급자들이 자신의 한계치까지 유연헤질수 있도록 도와줍니다.)   |");
			System.out.println("=============================================================================");
			System.out.printf("운동난이도 선택 : ");
			category_level = sc.nextLine();
			if (category_level.equals("1")) {
				category_level = "요린이";
			} else if (category_level.equals("2")) {
				category_level = "요중이";
			} else if (category_level.equals("3")) {
				category_level = "요른이";
			} else {
				System.err.println("잘못 입력하셨습니다.");
			}
		}

		else if (category.equals("3")) {
			category = "필라테스";
			System.out.println("=================================================================================");
			System.out.println("| 1.필린이 :  (초보자들이 부담없이 코어운동을 할수있도록 도와줍니다.)           |");
			System.out.println("|-------------------------------------------------------------------------------|");
			System.out.println("| 2.필중이 :  (중급자들이 적극적으로 코어운동을 할수있게 도와줍니다.)           |");
			System.out.println("|-------------------------------------------------------------------------------|");
			System.out.println("| 3.필른이 :  (상급자들이 자신의 한계치까지 코어운동을 할수있도록 도와줍니다.)  |");
			System.out.println("=================================================================================");
			System.out.printf("운동난이도 선택 : ");
			category_level = sc.nextLine();
			if (category_level.equals("1")) {
				category_level = "필린이";

			} else if (category_level.equals("2")) {
				category_level = "필중이";

			} else if (category_level.equals("3")) {
				category_level = "필른이";

			} else {
				System.err.println("잘못 입력하셨습니다.");
			}
		}

		memberService.join(loginId, loginPw, name, nickName, e_mail, sex, birth, height, weight, bmi, bmi_level, loss,
				months, category, category_level);

		System.out.printf("회원가입이 완료되었습니다. [%s] 님 환영합니다^^\n", nickName);
	}

	private void doLogin() {
		System.out.printf("로그인 아이디 : ");
		String loginId = sc.nextLine();

		System.out.printf("로그인 비번 : ");
		String loginPw = sc.nextLine();

		// 입력받은 아이디에 해당하는 회원이 존재하는지
		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			System.err.println("해당 회원은 존재하지 않습니다.");
			return;
		}

		if (member.loginPw.equals(loginPw) == false) {
			System.err.println("비밀번호가 맞지 않습니다.");
			return;
		}

		session.setLoginedMember(member);
		Member loginedMember = session.getLoginedMember();

		System.out.printf("로그인 성공! %s님 환영합니다!\n", loginedMember.nickName);
	}

	private void doLogout() {
		session.setLoginedMember(null);

		System.out.println("로그아웃 되었습니다.");
	}

	private void doDelete() {

	      Member member = session.getLoginedMember();
	      System.out.printf("로그인 비번 : ");
	      String loginPw = sc.nextLine();

	      if (member.loginPw.equals(loginPw) == false) {
	         System.out.println("비밀번호가 틀렸습니다.");
	         return;
	      }

	      System.out.println("정말 회원탈퇴를 하시겠습니까? Y/N");

	      String deleteAnswer = sc.nextLine();

	      if (deleteAnswer.equals("Y") || deleteAnswer.equals("y")) {
	         memberService.remove(member.id);
	         System.out.println("그동안 이용해 주셔서 감사합니다.");
	         session.setLoginedMember(null);
	         return;
	      }
	      if (deleteAnswer.equals("N") || deleteAnswer.equals("n")) {
	         return;
	      }
	   }

	public void adminDelete() {
		Member loginedMember = session.getLoginedMember();
		if (loginedMember.id == 1) {
			doDelete();
		}
	}

	private void doRecommendedProduct() {
		System.out.println("=========================================");
		System.out.printf("| 추천 받으실 제품의 번호를 입력하세요  |\n");
		System.out.println("|=======================================|");
		System.out.println("|  1. 운동복 추천                       |");
		System.out.println("|---------------------------------------|");
		System.out.println("|  2. 식품 추천                         |");
		System.out.println("=========================================");
		String recommendedProductAnswer = sc.nextLine();

		if (recommendedProductAnswer.equals("1")) {
			sportsWearRecommendedProductController.sportsWearRecommendedProduct();
		} else if (recommendedProductAnswer.equals("2")) {
			foodRecommendedProductController.foodRecommendedProduct();
		}
	}

	private void doMypage() {

		while (true) {
			System.out.println("==============================");
			System.out.println("|        명령어 목록 	     |");
			System.out.println("|============================|");
			System.out.println("|   1. 닉네임 설정           |");
			System.out.println("|----------------------------|");
			System.out.println("|   2. 나의 신체정보	     |");
			System.out.println("|----------------------------|");
			System.out.println("|   3. 나의 목표설정         |");
			System.out.println("|----------------------------|");
			System.out.println("|   4. 운동종목 및 레벨선택  |");
			System.out.println("|----------------------------|");
			System.out.println("|   5. 나의 정보보기         |");
			System.out.println("|----------------------------|");
			System.out.println("|   6. 마이페이지 나가기     |");
			System.out.println("==============================");

			System.out.printf("원하시는 목록의 번호를 입력하세요. : ");
			String Mypage = sc.nextLine();

			if (Mypage.equals("1")) {
				System.out.printf("닉네임을 변경 하시겠습니까? (Y/N) ");
				String answer = sc.nextLine();
				if (answer.equals("y") || answer.equals("Y")) {
					System.out.printf("변경할 닉네임을 적어주세요 : ");
					String nickName = sc.nextLine();
					if (isJoinablenickName(nickName) == false) {
						System.err.printf("%s(은)는 이미 사용중인 닉네임입니다.\n", nickName);
						continue;
					}

					int memberId = session.getLoginedMember().getId();
					memberService.nickName(memberId, nickName);
					System.out.println("===변경 완료===");

					System.out.printf("닉네임이 %s (으)로 변경되었습니다.\n", nickName);

					continue;
				} else if (answer.equals("n") || answer.equals("N")) {
					System.out.println("닉네임을 유지합니다.");
					continue;
				} else {
					System.err.println("잘못 입력하셨습니다.");
					continue;
				}
			} else if (Mypage.equals("2")) {

				String bmi_level;
				System.out.printf("나의 신체정보를 변경 하시겠습니까? (Y/N) ");
				String answer = sc.nextLine();
				if (answer.equals("y") || answer.equals("Y")) {
					System.out.printf("성별(M or F) : ");
					String sex = sc.nextLine();
					if (sex.equals("m") || sex.equals("M")) {
						sex = "남자";
					} else if (sex.equals("f") || sex.equals("F")) {
						sex = "여자";
					} else {
						System.out.println("잘못 입력하셨습니다.");
						continue;
					}
					System.out.printf("신장(cm) : ");
					double height = sc.nextDouble();
					sc.nextLine();

					System.out.printf("몸무게(kg) : ");
					double weight = sc.nextDouble();
					sc.nextLine();

					if (weight / (height * height / 10000) > 25) {
						bmi_level = "과체중";
					} else if (weight / (height * height / 10000) > 18.5) {
						bmi_level = "표준";
					} else {
						bmi_level = "저체중";
					}
					double bmi = weight / (height * height / 10000);

					int memberId = session.getLoginedMember().getId();
					memberService.body_info(memberId, sex, height, weight, bmi, bmi_level);

					System.out.printf("성별 : %s\n신장 : %.1fcm\n몸무게 : %.1fkg\nBMI 수치 : %.1f\nBMI : %s\n", sex, height,
							weight, bmi, bmi_level);
					System.out.println("===변경 완료===");
					continue;

				} else if (answer.equals("n") || answer.equals("N")) {
					System.out.println("신체정보를 유지합니다.");
					continue;
				} else {
					System.err.println("잘못 입력하셨습니다.");
					continue;
				}
			} else if (Mypage.equals("3")) {
				System.out.printf("나의 목표를 변경 하시겠습니까? (Y/N) ");
				String answer = sc.nextLine();
				if (answer.equals("y") || answer.equals("Y")) {
					System.out.println("===================================================");
					System.out.println("|             변경할 목표를 적어주세요.           |");
					System.out.println("|-------------------------------------------------|");
					System.out.println("|  1) 5kg 감량  |  2) 10kg 감량  |  3) 15kg 감량  |");
					System.out.println("===================================================");
					String loss = sc.nextLine();
					if (loss.equals("1")) {
						loss = "5kg 감량";

					} else if (loss.equals("2")) {
						loss = "10kg 감량";

					} else if (loss.equals("3")) {
						loss = "15kg 감량";

					} else {
						System.err.println("잘못 입력하셨습니다.");
						continue;
					}

					System.out.println("===============================================");
					System.out.println("|          목표 기간을 선택해주세요.          |");
					System.out.println("|---------------------------------------------|");
					System.out.println("|  1) 1~3개월  |  2) 3~6개월  | 3)  6~12개월  |");
					System.out.println("===============================================");

					String months = sc.nextLine();
					if (months.equals("1")) {
						months = "1~3개월";
					} else if (months.equals("2")) {
						months = "3~6개월";
					} else if (months.equals("3")) {
						months = "6~12개월";
					} else {
						System.err.println("잘못 입력하셨습니다.");
						continue;
					}
					System.out.println("===변경 완료===");

					int memberId = session.getLoginedMember().getId();
					memberService.object(memberId, loss, months);

					System.out.printf("나의 목표\n%s동안 목표량 %s을 할것입니다.\n", months, loss);
					continue;

				} else if (answer.equals("n") || answer.equals("N")) {
					System.out.println("나의 목표를 유지합니다.");
					continue;
				} else {
					System.err.println("잘못 입력하셨습니다.");
					continue;
				}
			} else if (Mypage.equals("4")) {

				System.out.printf("운동종목 및 레벨을 변경 하시겠습니까? (Y/N) ");
				String answer = sc.nextLine();
				String category = "";
				String category_level = "";

				if (answer.equals("y") || answer.equals("Y")) {
					System.out.println("==============================================");
					System.out.println("|   변경할 운동종목의 번호를 적어주세요.     |");
					System.out.println("|--------------------------------------------|");
					System.out.println("|    1.헬스   |    2.요가   |   3.필라테스   |");
					System.out.println("==============================================");
					category = sc.nextLine();
					if (category.equals("1")) {
						category = "헬스";
						System.out.println("=========================================================================");
						System.out.println("|           자신에게 맞는 헬스 난이도의 번호를 선택해주세요.            |");
						System.out.println("|-----------------------------------------------------------------------|");
						System.out.println("| 1.헬린이 :  (초보자들이 부담없이 운동할수있도록 도와줍니다.)          |");
						System.out.println("|-----------------------------------------------------------------------|");
						System.out.println("| 2.헬중이 :  (중급자들이 적극적으로 운동할수있게 도와줍니다.)          |");
						System.out.println("|-----------------------------------------------------------------------|");
						System.out.println("| 3.헬창이 :  (상급자들이 자신의 한계치까지 도달할수있도록 도와줍니다.) |");
						System.out.println("=========================================================================");
						category_level = sc.nextLine();
						if (category_level.equals("1")) {
							category_level = "헬린이";
						} else if (category_level.equals("2")) {
							category_level = "헬중이";
						} else if (category_level.equals("3")) {
							category_level = "헬창이";
						} else {
							System.err.println("잘못 입력하셨습니다.");
							continue;
						}
					} else if (category.equals("2")) {
						category = "요가";
						System.out.println(
								"=============================================================================");
						System.out.println("|            자신에게 맞는 요가 난이도의 번호를 선택해주세요.               |");
						System.out.println(
								"|---------------------------------------------------------------------------|");
						System.out.println("| 1.요린이 : (초보자들이 부담없이 요가를 할수있도록 도와줍니다.)            |");
						System.out.println(
								"|---------------------------------------------------------------------------|");
						System.out.println("| 2.요중이 : (중급자들이 적극적으로 요가를 할수있게 도와줍니다.)            |");
						System.out.println(
								"|---------------------------------------------------------------------------|");
						System.out.println("| 3.요른이 : (상급자들이 자신의 한계치까지 유연헤질수 있도록 도와줍니다.)   |");
						System.out.println(
								"=============================================================================");
						category_level = sc.nextLine();
						if (category_level.equals("1")) {
							category_level = "요린이";
						} else if (category_level.equals("2")) {
							category_level = "요중이";
						} else if (category_level.equals("3")) {
							category_level = "요른이";
						} else {
							System.err.println("잘못 입력하셨습니다.");
							continue;
						}
					}

					else if (category.equals("3")) {
						category = "필라테스";
						System.out.println(
								"=================================================================================");
						System.out.println("|           자신에게 맞는 필라테스 난이도의 번호를 선택해주세요.                |");
						System.out.println(
								"|-------------------------------------------------------------------------------|");
						System.out.println("| 1.필린이 :  (초보자들이 부담없이 코어운동을 할수있도록 도와줍니다.)           |");
						System.out.println(
								"|-------------------------------------------------------------------------------|");
						System.out.println("| 2.필중이 :  (중급자들이 적극적으로 코어운동을 할수있게 도와줍니다.)           |");
						System.out.println(
								"|-------------------------------------------------------------------------------|");
						System.out.println("| 3.필른이 :  (상급자들이 자신의 한계치까지 코어운동을 할수있도록 도와줍니다.)  |");
						System.out.println(
								"=================================================================================");
						category_level = sc.nextLine();
						if (category_level.equals("1")) {
							category_level = "필린이";

						} else if (category_level.equals("2")) {
							category_level = "필중이";

						} else if (category_level.equals("3")) {
							category_level = "필른이";

						} else {
							System.err.println("잘못 입력하셨습니다.");
							continue;
						}
					}
					int memberId = session.getLoginedMember().getId();
					memberService.category_level(memberId, category, category_level);

					System.out.println("===변경 완료===");
					System.out.printf("운동종목 : %s\n운동 난이도 : %s\n", category, category_level);
					continue;
				} else if (answer.equals("n") || answer.equals("N")) {
					System.out.println("운동종목 및 레벨을 유지합니다.");
					continue;
				} else {
					System.err.println("잘못 입력하셨습니다.");
					continue;
				}
			} else if (Mypage.equals("5")) {
				int id = session.getLoginedMember().getId();
				Member foundMember = memberService.getForPrintMember(id);

				System.out.println("======================================================================");
				System.out.println("|                              나의 정보                             |");
				System.out.println("|====================================================================|");
				System.out.printf("|      이름      |  %s\n", foundMember.name);
				System.out.println("|----------------|---------------------------------------------------|");
				System.out.printf("|      닉네임    |  %s\n", foundMember.nickName);
				System.out.println("|----------------|---------------------------------------------------|");
				System.out.printf("|     이메일     |  %s\n", foundMember.e_mail);
				System.out.println("|----------------|---------------------------------------------------|");
				System.out.printf("|      성별      |  %s\n", foundMember.sex);
				System.out.println("|----------------|---------------------------------------------------|");
				System.out.printf("|    생년월일    |  %s\n", foundMember.birth);
				System.out.println("|----------------|---------------------------------------------------|");
				System.out.printf("|    신장(cm)    |  %.1f\n", foundMember.height);
				System.out.println("|----------------|---------------------------------------------------|");
				System.out.printf("|   몸무게(kg)   |  %.1f\n", foundMember.weight);
				System.out.println("|----------------|---------------------------------------------------|");
				System.out.printf("|       bmi      |  %.1f\n", foundMember.bmi);
				System.out.println("|----------------|---------------------------------------------------|");
				System.out.printf("|    bmi 비만도  |  %s\n", foundMember.bmi_level);
				System.out.println("|----------------|---------------------------------------------------|");
				System.out.printf("|    나의목표    |  %s동안 %s를 감량할 것이다.\n", foundMember.months, foundMember.loss);
				System.out.println("|----------------|---------------------------------------------------|");
				System.out.printf("|    운동종목    |  %s\n", foundMember.category);
				System.out.println("|----------------|---------------------------------------------------|");
				System.out.printf("|     난이도     |  %s\n", foundMember.category_level);
				System.out.println("======================================================================");

				continue;
			} else if (Mypage.equals("6")) {
				break;
			} else {
				System.err.println("잘못 입력하셨습니다.");
			}
		}
	}

}