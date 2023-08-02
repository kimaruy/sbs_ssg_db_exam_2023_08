package com.sbs.java.ssg.controller;

import java.util.Scanner;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.dto.Member;
import com.sbs.java.ssg.service.MemberService;

public class FoodRecommendedProductController {
	private Scanner sc;
	private Session session;
	private MemberService memberService;

	public FoodRecommendedProductController() {
		session = Container.getSession();
		memberService = Container.memberService;
		sc = Container.getScanner();
	}

	public void foodRecommendedProduct() {
		int id = session.getLoginedMember().getId();
		Member foundMember = memberService.getForPrintMember(id);

		while (true) {
			// 식품(제목)변수명 ㅎㅎ
			String[] menu = { "닭가슴살", "프로틴", "샐러드", "다이어트도시락", "소세지(닭가슴살)", "한입큐브(닭가슴살)" };

			// =====닭찌찌=================================================================
			// 닭가슴살 식품 추천
			String bardak = "바르닭";
			String heodak = "허닭";
			String kokobil = "꼬꼬빌";
			String rangkingdakcom = "랭킹닭컴";

			// 바르닭-닭찌찌
			String[] bardakChickenBreast = { "소스품은 닭가슴살 화이트어니언", "소스품은 닭가슴살 청양마요", "소스품은 닭가슴살 리얼커리", "소스품은 닭가슴살 사천짜장맛",
					"소스품은 닭가슴살 찜닭맛" };
			String[] bardakSteamChickenBreast = { "스팀 조각 닭가슴살 매콤칠리", "스팀 닭가슴살 오리지널", "스팀 닭가슴살 블랙페퍼", "스팀 닭가슴살 허브바베큐",
					"스팀 닭가슴살 6종 골라담기" };
			String[] bardakSmokedChickenBreast = { "훈제 닭가슴살 할라피뇨", "훈제 닭가슴살 오리지널", "훈제 닭가슴살 저염", "훈제 닭가슴살 페퍼",
					"훈제 닭가슴살 6종 골라담기" };

			// 바르닭-소세지
			String[] bardakSosejiSet = { "닭가슴살 후랑크 소시지 5종 세트", "닭가슴살 후랑크 꼬치 5종 세트", "닭가슴살 방울소시지 3종 세트" };
			String[] bardakFrankSoseji = { "닭가슴살 후랑크 소시지 오리지널", "닭가슴살 후랑크 소시지 치즈", "닭가슴살 후랑크 소시지 알싸청양",
					"닭가슴살 후랑크 소시지 불닭", "닭가슴살 후랑크 소시지 매콤갈비" };
			String[] bardakFrankStick = { "닭가슴살 후랑크 꼬치 오리지널", "닭가슴살 후랑크 꼬치 치즈", "닭가슴살 후랑크 꼬치 알싸청양", "닭가슴살 후랑크 꼬치 커리",
					"닭가슴살 후랑크 꼬치 페퍼" };
			String[] bardakBellSoSeji = { "닭가슴살 방울소시지 오리지널", "닭가슴살 방울소시지 알싸청양", "닭가슴살 방울소시지 치즈" };

			// 허닭-닭찌찌
			String[] heodakSauceChickenBreast = { "[허닭]소스 슬라이스 닭가슴살 120g 화이트머쉬룸 10팩", "[허닭]스팀 소스 닭안심 120g 바베큐",
					"[허닭]스팀 소스 닭안심 120g 핫바베큐", "[오빠닭]소스 슬라이스 닭가슴살 레드크림커리 120g" };
			String[] heodakSteamChickenBreast = { "[바디닭]소프트 저염 닭가슴살", "[허닭]스팀 닭가슴살 100g 마늘맛", "[허닭]스팀 닭가슴살 100g 고추맛",
					"[허닭]스팀 닭가슴살 100g 탄두리맛", "[허닭]스팀 닭가슴살 100g 깻잎맛", "[BBQ]BBQ BEST 그릴 통 닭가슴살" };
			String[] heodakSoftChickenBreast = { "[BHC]수비드 홀 닭가슴살 100g 4종 20팩", "[BHC]수비드 홀 닭가슴살 100g 4종 4팩",
					"[BHC]수비드 홀 닭가슴살 100g 4종 12팩", "[BHC]수비드 홀 닭가슴살 100g 4종 10팩" };

			// 허닭-한입큐브(닭가슴살)
			String[] heodakChawCube = { "[허닭]한입 닭가슴살 큐브 새우100g 10팩", "[허닭]한입 닭가슴살 큐브 오징어100g 10팩",
					"[허닭]한입 닭가슴살 어묵볼100g 감자베이컨 1팩", "[허닭]한입 닭가슴살 어묵볼100g 치즈 10팩" };
			String[] kokobilChawCube = { "[꼬꼬빌]심쿵 닭가슴살 오븐구이 저크바베큐 130g x 5팩", "[꼬꼬빌]심쿵 닭가슴살 오븐구이 저크바베큐 130g x 10팩",
					" [꼬꼬빌]심쿵 닭가슴살 오븐구이 치즈범벅 130g x 5팩", "[꼬꼬빌]심쿵 닭가슴살 오븐구이 저크바베큐 130g x 30팩" };

			// 랭킹닭컴
			String[] rangkingdakcomSteak = { "햇살닭 현미 닭가슴살 스테이크 100g", "맛있닭 닭가슴살 스테이크 오리지널 100g",
					"맛있닭 닭가슴살 스테이크 갈릭맛 100g", "맛있닭 닭가슴살 스테이크 고추맛 100g", "맛있닭 닭가슴살 스테이크 호박맛 100g",
					"맛있닭 소스 닭가슴살 스테이크 매콤 토마토 150g", "맛있닭 소스 닭가슴살 스테이크 로스트 갈릭 150g", "맛있닭 소스 닭가슴살 스테이크 자색고구마 까르보나라 150g",
					"맛있닭 소스 닭가슴살 스테이크 흑마늘 150g" };
			// 10개-다이어트,대회 준비 하는사람추천
			String[] rangkingdakcomLowSaltChickenBreast = { "맛있닭 저염 닭가슴살 100g", "맛있닭 프로 닭가슴살 120g",
					"맛있닭 닭가슴살 스테이크 갈릭맛 100g", "맛있닭 저염·프로 닭가슴살 혼합 100~120g", "(강추)잇메이트 저염 스팀 닭가슴살 오리지널 100g",
					"(강추)잇메이트 저염 닭가슴살 오리지널 100g", "햇살닭 저염 훈제 닭가슴살 플러스 100g", "햇살닭 저염 수비드 닭가슴살 150g",
					"햇살닭 저염 훈제 닭가슴살 오리지널 200g" };
			// 6개
			String[] rangkingdakcomNudeChickenBreast = { "랭커 IQF 한입 닭가슴살 100g", "랭커 IQF 한입 닭가슴살 200g",
					"랭커 IQF 한입 닭가슴살 1kg", "하림 동물복지 IFF 냉동 생 닭가슴살 800g", "다향 IQF 닭가슴살 1kg",
					"닭스몰 무항생제 1등급 냉동 생 닭가슴살 400g" };
			// 10개
			String[] rangkingdakcomSmokedChickenBreast = { "맛있닭 훈제 닭가슴살 훈제 100g", "맛있닭 훈제 닭가슴살 칠리 100g",
					"맛있닭 훈제 닭가슴살 카레 100g", "맛있닭 훈제 닭가슴살 혼합 100g", "잇메이트 훈제 닭가슴살 오리지널 100g", "잇메이트 훈제 닭가슴살 마늘 100g",
					"잇메이트 훈제 닭가슴살 할라피뇨 100g", "치품닭 치즈품은 훈제 닭가슴살 갈릭 110g", "치품닭 치즈품은 훈제 닭가슴살 고추 110g",
					"햇살닭 저염 훈제 닭가슴살 오리지널 200g" };

			// =====프로틴=================================================================
			// 프로틴 식품 추천 (프로틴 브랜드 : 마이프로틴, 신타6, 머스팜 컴뱃)
			String myProtein = "마이프로틴";
			String syntha6 = "신타6";
			String musclePharm = "머슬팜";

			// 마이프로틴/9개
			String[] myProtein1 = { "임팩트웨이프로틴", "임팩트웨이아이솔레이트", "모노크레아틴", "클리어웨이아아이솔레이트", "프로틴 식사대용 블렌드(저칼로리 식사대용)",
					"클리어웨이게이너", "임팩트다이어트웨이", "임팩트 프로틴 블렌드", "밀크 프로틴" };

			// 신타6/9개
			String[] syntha61 = { "단백질파우더드링크믹스(초콜릿밀크쉐이크)", "울트라프리미엄프로틴매트릭스(딸기밀크셰이크)", "콜드스톤 크리머리(민트초콜릿칩)",
					"콜드스톤크리머리쿠키돈트유원썸", "비에스엔 프로틴 파우더", "비에스엔 아이솔레이트", "비에스엔 엣지" };

			// 머슬팜
			String[] musclePharm1 = { "울트라 웨이 머슬팜 컴뱃", "프로틴 파우더 머슬팜 컴뱃", "BCAA 아미노산 머슬팜 컴뱃", "CLA 머슬팜 컴뱃",
					"글루타민 머슬팜 컴뱃" };

			// =====샐러드=================================================================
			// 샐러드 식품 추천(샐러드 브랜드 : 샐러디아, 샐러마켓, 헬로 잇츠, 편한 한끼)
			String saladia = "샐러디아";
			String slimCook = "슬림쿡";
			String saladPanda = "샐러드판다";
			String pocketSalad = "포켓샐러드";

			// 샐러디아13개
			String[] saladia1 = { "그린 샐러드 빅볼", "토시살 샐러드 빅볼", "부채살 샐러드 빅볼", "목살 샐러드 빅볼", " 훈제 연어 샐러드 빅볼", "훈제 오리 샐러드 빅볼",
					" 촉촉 닭가슴살 샐러드 빅볼", "리코타치즈 샐러드 빅볼", "치킨 텐더 샐러드 빅볼", "무스 샐러드 빅볼", "아보카도 샐러드 빅볼", "구운 새우 샐러드 빅볼",
					"구운 야채 샐러드 빅볼" };
			// 슬림쿡
			String[] slimCook1 = { "[데일리] 그린 샐러드(드레싱x)", "[SET] 인기 샐러드 8종 맛보기 세트", "[데일리] 닭가슴살 오징어 샐러드 5팩 세트",
					"[데일리+프리미엄] 샐러드 골라담기", "[프리미엄] 샐러드 골라담기", "[프리미엄] 아보카불고기 샐러드", "[프리미엄] 그릴두부 샐러드",
					"[프리미엄] 그릴함박스테이크 샐러드", "[프리미엄] 아보카쉬림프 샐러드", "[데일리] 목살 스테이크 샐러드" };
			// 샐러드판다
			String[] saladPanda1 = { "샐린이 3종 세트", "베스트 4종 세트", "잘 챙겨먹어야해 6종 세트" };
			// 포켓샐러드
			String[] pocketSalad1 = { "그린 샐러드", "닭가슴살 샐러드", "훈제오리 샐러드", "닭가슴살볼 숯불갈비맛샐러드", "채소만 베이직 플러스 믹스 샐러드",
					"파스타 샐러드" };
			String[] pocketSaladRegularDelivery = { "(4주)정기배송 샐러드 (주/5일)", "(4주)정기배송 샐러드 (주/5일)",
					"(2주) 정기배송 샐러드 (주/6일)", "샐러드와 간편식(5일)", "(4주)정기배송 짜여진 식단", "(6주)정기배송 짜여진 식단" };

			// =====다이어트도시락=======================================================
			// 샐러드 식품 추천(도시락 브랜드 : 샐러디아, 슬림쿡, 허닭, 편한 한끼)

			// 샐러디아도시락 4개만하자...
			String[] saladiaDosirak = { "촉촉 닭가슴살 도시락", "훈제 오리 도시락", "목살 스테이크 도시락", "연어 스테이크 도시락" };
			String[] slimCookDosirak = { "[슬림쿡 런치] 플러스+ 정기배송 (10일)", "[슬림쿡 런치] 플러스+ 정기배송(5일)",
					"[슬림쿡 런치] 플러스+ 정기배송 (3일)", "[슬림쿡 런치] 도시락 정기배송 (3일)" };
			String[] heodakDosirak = { "잡곡밥 도시락 6종 24팩", "볶음밥 도시락 250g 6종 12팩", "다이어트 도시락 210g 4종 8팩",
					"일품도시락 10종 11팩" };
			String[] pyeonhanHankkiDosirak = { "한끼도시락 간편 냉동 복음밥 도시락 6팩", "식단도시락34종골라담기", "장인도시락 간편 식단관리 (남편/아이들도시락)",
					"고단백식 1주 닭가슴살 식단 도시락 (6종/6팩)" };

			// 목표기간 설정 스캐너

			// 식품 구현
			if (foundMember.months.equals("1~3개월")) { // 목표 감량 :1개월-6개월
				if (foundMember.loss.equals("5kg 감량")) { // 1kg~5kg감량
					System.out.printf("\n");
					System.out.println("======================================================================================================================================================================");
					System.out.println("|                                                                  회원님에게 추천하는 식품 브랜드                                                                   |");
					System.out.println("|====================================================================================================================================================================|");
					System.out.println("|  1~3개월/5kg 감량kg  |   브랜드   |                                                            제품                                                                |");
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |   %s   |  %s, %s, %s\n",bardak, bardakChickenBreast[0], bardakSmokedChickenBreast[0], bardakSteamChickenBreast[0]);
					System.out.printf ("|       닭가슴살       |    %s    |  %s, %s, %s \n",heodak, heodakSauceChickenBreast[0], heodakSteamChickenBreast[0], heodakSoftChickenBreast[0]);
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",rangkingdakcom, rangkingdakcomSteak[0], rangkingdakcomLowSaltChickenBreast[0], rangkingdakcomNudeChickenBreast[0]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      | %s |  %s, %s, %s \n",myProtein, myProtein1[0], myProtein1[1], myProtein1[2]);
					System.out.printf ("|        프로틴        |    %s   |  %s, %s, %s \n",syntha6, syntha61[0], syntha61[1], syntha61[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",musclePharm, musclePharm1[0], musclePharm1[1], musclePharm1[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladia1[0], saladia1[1], saladia1[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",slimCook, slimCook1[0], slimCook1[1], slimCook1[2]);
					System.out.printf ("|        샐러드        | %s |  %s, %s, %s \n",saladPanda, saladPanda1[0], saladPanda1[1], saladPanda1[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pocketSalad1[0], pocketSalad1[1], pocketSalad1[2]);
					System.out.printf ("|                      |            |  %s, %s, %s \n",pocketSaladRegularDelivery[0], pocketSaladRegularDelivery[1], pocketSaladRegularDelivery[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladiaDosirak[0], saladiaDosirak[1], saladiaDosirak[2]);
					System.out.printf ("|    다이어트 도시락   |   %s   |  %s, %s, %s \n",slimCook, slimCookDosirak[0], slimCookDosirak[1], slimCookDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",saladPanda, heodakDosirak[0], heodakDosirak[1], heodakDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pyeonhanHankkiDosirak[0], pyeonhanHankkiDosirak[1], pyeonhanHankkiDosirak[2]);
					System.out.println("|====================================================================================================================================================================|");
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
					System.out.printf("\n");
					break;
				} else if (foundMember.loss.equals("10kg 감량")) { // 5kg~10kg감량일때
					System.out.printf("\n");
					// 닭찌찌흫
					System.out.println("======================================================================================================================================================================");
					System.out.println("|                                                                  회원님에게 추천하는 식품 브랜드                                                                   |");
					System.out.println("|====================================================================================================================================================================|");
					System.out.println("|  1~3개월/10kg 감량kg |   브랜드   |                                                            제품                                                                |");
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |   %s   |  %s, %s, %s\n",bardak, bardakChickenBreast[0], bardakSmokedChickenBreast[0], bardakSteamChickenBreast[0]);
					System.out.printf ("|       닭가슴살       |    %s    |  %s, %s, %s \n",heodak, heodakSauceChickenBreast[0], heodakSteamChickenBreast[0], heodakSoftChickenBreast[0]);
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",rangkingdakcom, rangkingdakcomSteak[0], rangkingdakcomLowSaltChickenBreast[0], rangkingdakcomNudeChickenBreast[0]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      | %s |  %s, %s, %s \n",myProtein, myProtein1[0], myProtein1[1], myProtein1[2]);
					System.out.printf ("|        프로틴        |    %s   |  %s, %s, %s \n",syntha6, syntha61[0], syntha61[1], syntha61[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",musclePharm, musclePharm1[0], musclePharm1[1], musclePharm1[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladia1[0], saladia1[1], saladia1[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",slimCook, slimCook1[0], slimCook1[1], slimCook1[2]);
					System.out.printf ("|        샐러드        | %s |  %s, %s, %s \n",saladPanda, saladPanda1[0], saladPanda1[1], saladPanda1[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pocketSalad1[0], pocketSalad1[1], pocketSalad1[2]);
					System.out.printf ("|                      |            |  %s, %s, %s \n",pocketSaladRegularDelivery[0], pocketSaladRegularDelivery[1], pocketSaladRegularDelivery[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladiaDosirak[0], saladiaDosirak[1], saladiaDosirak[2]);
					System.out.printf ("|    다이어트 도시락   |   %s   |  %s, %s, %s \n",slimCook, slimCookDosirak[0], slimCookDosirak[1], slimCookDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",saladPanda, heodakDosirak[0], heodakDosirak[1], heodakDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pyeonhanHankkiDosirak[0], pyeonhanHankkiDosirak[1], pyeonhanHankkiDosirak[2]);
					System.out.println("|====================================================================================================================================================================|");
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
					System.out.printf("\n");
					break;

				} else if (foundMember.loss.equals("15kg 감량")) { // 10kg~15kg감량일때
					System.out.printf("\n");
					// 닭찌찌흫
					System.out.println("======================================================================================================================================================================");
					System.out.println("|                                                                  회원님에게 추천하는 식품 브랜드                                                                   |");
					System.out.println("|====================================================================================================================================================================|");
					System.out.println("|  1~3개월/15kg 감량kg |   브랜드   |                                                            제품                                                                |");
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |   %s   |  %s, %s, %s\n",bardak, bardakChickenBreast[0], bardakSmokedChickenBreast[0], bardakSteamChickenBreast[0]);
					System.out.printf ("|       닭가슴살       |    %s    |  %s, %s, %s \n",heodak, heodakSauceChickenBreast[0], heodakSteamChickenBreast[0], heodakSoftChickenBreast[0]);
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",rangkingdakcom, rangkingdakcomSteak[0], rangkingdakcomLowSaltChickenBreast[0], rangkingdakcomNudeChickenBreast[0]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      | %s |  %s, %s, %s \n",myProtein, myProtein1[0], myProtein1[1], myProtein1[2]);
					System.out.printf ("|        프로틴        |    %s   |  %s, %s, %s \n",syntha6, syntha61[0], syntha61[1], syntha61[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",musclePharm, musclePharm1[0], musclePharm1[1], musclePharm1[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladia1[0], saladia1[1], saladia1[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",slimCook, slimCook1[0], slimCook1[1], slimCook1[2]);
					System.out.printf ("|        샐러드        | %s |  %s, %s, %s \n",saladPanda, saladPanda1[0], saladPanda1[1], saladPanda1[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pocketSalad1[0], pocketSalad1[1], pocketSalad1[2]);
					System.out.printf ("|                      |            |  %s, %s, %s \n",pocketSaladRegularDelivery[0], pocketSaladRegularDelivery[1], pocketSaladRegularDelivery[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladiaDosirak[0], saladiaDosirak[1], saladiaDosirak[2]);
					System.out.printf ("|    다이어트 도시락   |   %s   |  %s, %s, %s \n",slimCook, slimCookDosirak[0], slimCookDosirak[1], slimCookDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",saladPanda, heodakDosirak[0], heodakDosirak[1], heodakDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pyeonhanHankkiDosirak[0], pyeonhanHankkiDosirak[1], pyeonhanHankkiDosirak[2]);
					System.out.println("|====================================================================================================================================================================|");
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
					System.out.printf("\n");
					break;
				}
			}
			// 1-3개월 다음 시작
			else if (foundMember.months.equals("3~6개월")) { // 목표 감량 :3-6개월
				if (foundMember.loss.equals("5kg 감량")) {
					System.out.printf("\n");
					// 소세지(닭가슴살)
					System.out.println("======================================================================================================================================================================");
					System.out.println("|                                                                  회원님에게 추천하는 식품 브랜드                                                                   |");
					System.out.println("|====================================================================================================================================================================|");
					System.out.println("|  3~6개월/5kg 감량kg  |   브랜드   |                                                            제품                                                                |");
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |   %s   |  %s, %s, %s\n",bardak, bardakSosejiSet[0], bardakFrankSoseji[0], bardakFrankStick[0]);
					System.out.printf ("|       닭가슴살       |    %s    |  %s, %s, %s \n",heodak, heodakSauceChickenBreast[1], heodakSteamChickenBreast[1], heodakSoftChickenBreast[1]);
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",rangkingdakcom, rangkingdakcomSteak[1], rangkingdakcomLowSaltChickenBreast[1], rangkingdakcomNudeChickenBreast[1]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      | %s |  %s, %s, %s \n",myProtein, myProtein1[0], myProtein1[1], myProtein1[2]);
					System.out.printf ("|        프로틴        |    %s   |  %s, %s, %s \n",syntha6, syntha61[0], syntha61[1], syntha61[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",musclePharm, musclePharm1[0], musclePharm1[1], musclePharm1[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladia1[0], saladia1[1], saladia1[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",slimCook, slimCook1[0], slimCook1[1], slimCook1[2]);
					System.out.printf ("|        샐러드        | %s |  %s, %s, %s \n",saladPanda, saladPanda1[0], saladPanda1[1], saladPanda1[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pocketSalad1[0], pocketSalad1[1], pocketSalad1[2]);
					System.out.printf ("|                      |            |  %s, %s, %s \n",pocketSaladRegularDelivery[0], pocketSaladRegularDelivery[1], pocketSaladRegularDelivery[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladiaDosirak[0], saladiaDosirak[1], saladiaDosirak[2]);
					System.out.printf ("|    다이어트 도시락   |   %s   |  %s, %s, %s \n",slimCook, slimCookDosirak[0], slimCookDosirak[1], slimCookDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",saladPanda, heodakDosirak[0], heodakDosirak[1], heodakDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pyeonhanHankkiDosirak[0], pyeonhanHankkiDosirak[1], pyeonhanHankkiDosirak[2]);
					System.out.println("|====================================================================================================================================================================|");
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
					System.out.printf("\n");
					break;
				} else if (foundMember.loss.equals("10kg 감량")) {
					System.out.printf("\n");
					// 소세지(닭가슴살)
					System.out.println("======================================================================================================================================================================");
					System.out.println("|                                                                  회원님에게 추천하는 식품 브랜드                                                                   |");
					System.out.println("|====================================================================================================================================================================|");
					System.out.println("|  3~6개월/10kg 감량kg |   브랜드   |                                                            제품                                                                |");
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |   %s   |  %s, %s, %s\n",bardak, bardakSosejiSet[0], bardakFrankSoseji[0], bardakFrankStick[0]);
					System.out.printf ("|       닭가슴살       |    %s    |  %s, %s, %s \n",heodak, heodakSauceChickenBreast[1], heodakSteamChickenBreast[1], heodakSoftChickenBreast[1]);
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",rangkingdakcom, rangkingdakcomSteak[1], rangkingdakcomLowSaltChickenBreast[1], rangkingdakcomNudeChickenBreast[1]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      | %s |  %s, %s, %s \n",myProtein, myProtein1[0], myProtein1[1], myProtein1[2]);
					System.out.printf ("|        프로틴        |    %s   |  %s, %s, %s \n",syntha6, syntha61[0], syntha61[1], syntha61[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",musclePharm, musclePharm1[0], musclePharm1[1], musclePharm1[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladia1[0], saladia1[1], saladia1[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",slimCook, slimCook1[0], slimCook1[1], slimCook1[2]);
					System.out.printf ("|        샐러드        | %s |  %s, %s, %s \n",saladPanda, saladPanda1[0], saladPanda1[1], saladPanda1[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pocketSalad1[0], pocketSalad1[1], pocketSalad1[2]);
					System.out.printf ("|                      |            |  %s, %s, %s \n",pocketSaladRegularDelivery[0], pocketSaladRegularDelivery[1], pocketSaladRegularDelivery[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladiaDosirak[0], saladiaDosirak[1], saladiaDosirak[2]);
					System.out.printf ("|    다이어트 도시락   |   %s   |  %s, %s, %s \n",slimCook, slimCookDosirak[0], slimCookDosirak[1], slimCookDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",saladPanda, heodakDosirak[0], heodakDosirak[1], heodakDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pyeonhanHankkiDosirak[0], pyeonhanHankkiDosirak[1], pyeonhanHankkiDosirak[2]);
					System.out.println("|====================================================================================================================================================================|");
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
					System.out.printf("\n");
					
					break;
				} else if (foundMember.loss.equals("15kg 감량")) { // 목표감량 : 10~15kg
					System.out.printf("\n");
					// 소세지(닭가슴살)
					System.out.println("======================================================================================================================================================================");
					System.out.println("|                                                                  회원님에게 추천하는 식품 브랜드                                                                   |");
					System.out.println("|====================================================================================================================================================================|");
					System.out.println("|  3~6개월/15kg 감량kg |   브랜드   |                                                            제품                                                                |");
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |   %s   |  %s, %s, %s\n",bardak, bardakSosejiSet[0], bardakFrankSoseji[0], bardakFrankStick[0]);
					System.out.printf ("|       닭가슴살       |    %s    |  %s, %s, %s \n",heodak, heodakSauceChickenBreast[1], heodakSteamChickenBreast[1], heodakSoftChickenBreast[1]);
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",rangkingdakcom, rangkingdakcomSteak[1], rangkingdakcomLowSaltChickenBreast[1], rangkingdakcomNudeChickenBreast[1]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      | %s |  %s, %s, %s \n",myProtein, myProtein1[0], myProtein1[1], myProtein1[2]);
					System.out.printf ("|        프로틴        |    %s   |  %s, %s, %s \n",syntha6, syntha61[0], syntha61[1], syntha61[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",musclePharm, musclePharm1[0], musclePharm1[1], musclePharm1[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladia1[0], saladia1[1], saladia1[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",slimCook, slimCook1[0], slimCook1[1], slimCook1[2]);
					System.out.printf ("|        샐러드        | %s |  %s, %s, %s \n",saladPanda, saladPanda1[0], saladPanda1[1], saladPanda1[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pocketSalad1[0], pocketSalad1[1], pocketSalad1[2]);
					System.out.printf ("|                      |            |  %s, %s, %s \n",pocketSaladRegularDelivery[0], pocketSaladRegularDelivery[1], pocketSaladRegularDelivery[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladiaDosirak[0], saladiaDosirak[1], saladiaDosirak[2]);
					System.out.printf ("|    다이어트 도시락   |   %s   |  %s, %s, %s \n",slimCook, slimCookDosirak[0], slimCookDosirak[1], slimCookDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",saladPanda, heodakDosirak[0], heodakDosirak[1], heodakDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pyeonhanHankkiDosirak[0], pyeonhanHankkiDosirak[1], pyeonhanHankkiDosirak[2]);
					System.out.println("|====================================================================================================================================================================|");
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
					break;
				}
			}
			// 3-6개월 다음 시작
			else if (foundMember.months.equals("6~12개월")) {
				if (foundMember.loss.equals("5kg 감량")) { // 1kg~5kg감량
					System.out.printf("\n");
					System.out.println("======================================================================================================================================================================");
					System.out.println("|                                                                  회원님에게 추천하는 식품 브랜드                                                                   |");
					System.out.println("|====================================================================================================================================================================|");
					System.out.println("|  6~12개월/5kg 감량kg |   브랜드   |                                                            제품                                                                |");
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |   %s   |  %s, %s, %s\n",bardak, bardakSosejiSet[0], bardakFrankSoseji[0], bardakFrankStick[0]);
					System.out.printf ("|       닭가슴살       |    %s    |  %s, %s, %s \n",heodak, heodakSauceChickenBreast[1], heodakSteamChickenBreast[1], heodakSoftChickenBreast[1]);
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",rangkingdakcom, rangkingdakcomSteak[1], rangkingdakcomLowSaltChickenBreast[1], rangkingdakcomNudeChickenBreast[1]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      | %s |  %s, %s, %s \n",myProtein, myProtein1[0], myProtein1[1], myProtein1[2]);
					System.out.printf ("|        프로틴        |    %s   |  %s, %s, %s \n",syntha6, syntha61[0], syntha61[1], syntha61[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",musclePharm, musclePharm1[0], musclePharm1[1], musclePharm1[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladia1[0], saladia1[1], saladia1[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",slimCook, slimCook1[0], slimCook1[1], slimCook1[2]);
					System.out.printf ("|        샐러드        | %s |  %s, %s, %s \n",saladPanda, saladPanda1[0], saladPanda1[1], saladPanda1[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pocketSalad1[0], pocketSalad1[1], pocketSalad1[2]);
					System.out.printf ("|                      |            |  %s, %s, %s \n",pocketSaladRegularDelivery[0], pocketSaladRegularDelivery[1], pocketSaladRegularDelivery[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladiaDosirak[0], saladiaDosirak[1], saladiaDosirak[2]);
					System.out.printf ("|    다이어트 도시락   |   %s   |  %s, %s, %s \n",slimCook, slimCookDosirak[0], slimCookDosirak[1], slimCookDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",saladPanda, heodakDosirak[0], heodakDosirak[1], heodakDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pyeonhanHankkiDosirak[0], pyeonhanHankkiDosirak[1], pyeonhanHankkiDosirak[2]);
					System.out.println("|====================================================================================================================================================================|");
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
					System.out.printf("\n");
					break;
				} else if (foundMember.loss.equals("10kg 감량")) { // 5kg~10kg감량
					System.out.printf("\n");
					// 한입큐브(닭가슴살)
					System.out.println("======================================================================================================================================================================");
					System.out.println("|                                                                  회원님에게 추천하는 식품 브랜드                                                                   |");
					System.out.println("|====================================================================================================================================================================|");
					System.out.println("| 6~12개월/10kg 감량kg |   브랜드   |                                                            제품                                                                |");
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |   %s   |  %s, %s, %s\n",bardak, bardakSosejiSet[0], bardakFrankSoseji[0], bardakFrankStick[0]);
					System.out.printf ("|       닭가슴살       |    %s    |  %s, %s, %s \n",heodak, heodakSauceChickenBreast[1], heodakSteamChickenBreast[1], heodakSoftChickenBreast[1]);
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",rangkingdakcom, rangkingdakcomSteak[1], rangkingdakcomLowSaltChickenBreast[1], rangkingdakcomNudeChickenBreast[1]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      | %s |  %s, %s, %s \n",myProtein, myProtein1[0], myProtein1[1], myProtein1[2]);
					System.out.printf ("|        프로틴        |    %s   |  %s, %s, %s \n",syntha6, syntha61[0], syntha61[1], syntha61[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",musclePharm, musclePharm1[0], musclePharm1[1], musclePharm1[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladia1[0], saladia1[1], saladia1[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",slimCook, slimCook1[0], slimCook1[1], slimCook1[2]);
					System.out.printf ("|        샐러드        | %s |  %s, %s, %s \n",saladPanda, saladPanda1[0], saladPanda1[1], saladPanda1[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pocketSalad1[0], pocketSalad1[1], pocketSalad1[2]);
					System.out.printf ("|                      |            |  %s, %s, %s \n",pocketSaladRegularDelivery[0], pocketSaladRegularDelivery[1], pocketSaladRegularDelivery[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladiaDosirak[0], saladiaDosirak[1], saladiaDosirak[2]);
					System.out.printf ("|    다이어트 도시락   |   %s   |  %s, %s, %s \n",slimCook, slimCookDosirak[0], slimCookDosirak[1], slimCookDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",saladPanda, heodakDosirak[0], heodakDosirak[1], heodakDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pyeonhanHankkiDosirak[0], pyeonhanHankkiDosirak[1], pyeonhanHankkiDosirak[2]);
					System.out.println("|====================================================================================================================================================================|");
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
					System.out.printf("\n");
					break;
				} else if (foundMember.loss.equals("15kg 감량")) { // 10kg~15kg감량
					System.out.printf("\n");
					// 한입큐브(닭가슴살)
					System.out.println("======================================================================================================================================================================");
					System.out.println("|                                                                  회원님에게 추천하는 식품 브랜드                                                                   |");
					System.out.println("|====================================================================================================================================================================|");
					System.out.println("| 6~12개월/15kg 감량kg |   브랜드   |                                                            제품                                                                |");
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |   %s   |  %s, %s, %s\n",bardak, bardakSosejiSet[0], bardakFrankSoseji[0], bardakFrankStick[0]);
					System.out.printf ("|       닭가슴살       |    %s    |  %s, %s, %s \n",heodak, heodakSauceChickenBreast[1], heodakSteamChickenBreast[1], heodakSoftChickenBreast[1]);
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",rangkingdakcom, rangkingdakcomSteak[1], rangkingdakcomLowSaltChickenBreast[1], rangkingdakcomNudeChickenBreast[1]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      | %s |  %s, %s, %s \n",myProtein, myProtein1[0], myProtein1[1], myProtein1[2]);
					System.out.printf ("|        프로틴        |    %s   |  %s, %s, %s \n",syntha6, syntha61[0], syntha61[1], syntha61[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",musclePharm, musclePharm1[0], musclePharm1[1], musclePharm1[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladia1[0], saladia1[1], saladia1[2]);
					System.out.printf ("|                      |   %s   |  %s, %s, %s \n",slimCook, slimCook1[0], slimCook1[1], slimCook1[2]);
					System.out.printf ("|        샐러드        | %s |  %s, %s, %s \n",saladPanda, saladPanda1[0], saladPanda1[1], saladPanda1[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pocketSalad1[0], pocketSalad1[1], pocketSalad1[2]);
					System.out.printf ("|                      |            |  %s, %s, %s \n",pocketSaladRegularDelivery[0], pocketSaladRegularDelivery[1], pocketSaladRegularDelivery[2]);
					System.out.println("|----------------------|------------|--------------------------------------------------------------------------------------------------------------------------------|");
					System.out.printf ("|                      |  %s  |  %s, %s, %s \n",saladia, saladiaDosirak[0], saladiaDosirak[1], saladiaDosirak[2]);
					System.out.printf ("|    다이어트 도시락   |   %s   |  %s, %s, %s \n",slimCook, slimCookDosirak[0], slimCookDosirak[1], slimCookDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",saladPanda, heodakDosirak[0], heodakDosirak[1], heodakDosirak[2]);
					System.out.printf ("|                      | %s |  %s, %s, %s \n",pocketSalad, pyeonhanHankkiDosirak[0], pyeonhanHankkiDosirak[1], pyeonhanHankkiDosirak[2]);
					System.out.println("|====================================================================================================================================================================|");
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
					System.out.printf("\n");
					break;
				}
			}
		}
	}
}
