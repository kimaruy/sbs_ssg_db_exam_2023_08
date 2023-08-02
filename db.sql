# 데이터베이스 삭제/생성/선택
DROP DATABASE IF EXISTS sbs_proj;
CREATE DATABASE sbs_proj;
USE sbs_proj;

CREATE TABLE article (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	nickname CHAR(100) NOT NULL,
	title CHAR(100) NOT NULL,
	`body` CHAR(100) NOT NULL,
	memberId INT(1) UNSIGNED NOT NULL,
	boardId INT(1) UNSIGNED NOT NULL,
	hit INT(10) UNSIGNED NOT NULL,
	`like` INT(10) UNSIGNED NOT NULL,
	INDEX boardId (`boardId`)
);

SELECT * FROM article;

CREATE TABLE articleReply (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	nickname CHAR(100) NOT NULL,
	`body` CHAR(100) NOT NULL,
	memberId INT(1) UNSIGNED NOT NULL,
	articleId INT(1) UNSIGNED NOT NULL,
	`like` INT(10) UNSIGNED NOT NULL,
	INDEX articleId (`articleId`)
);

SELECT * FROM articleReply;

CREATE TABLE `member` (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	loginId CHAR(100) NOT NULL UNIQUE,
	loginPw CHAR(100) NOT NULL,
	`name` CHAR(100) NOT NULL,
	nickName CHAR(100) NOT NULL,
	e_mail CHAR(100) NOT NULL,
	sex CHAR(100) NOT NULL,
	birth CHAR(100) NOT NULL,
	height DOUBLE(5,2) NOT NULL,
	weight DOUBLE(5,2) NOT NULL,
	bmi DOUBLE(4,2) NOT NULL,
	bmi_level CHAR(100) NOT NULL,
	loss CHAR(100) NOT NULL,
	months CHAR(100) NOT NULL,
	category CHAR(100) NOT NULL,
	category_level CHAR(100) NOT NULL,
	cart CHAR(100) NULL
);

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw = 'admin',
`name` = '관리자',
nickName = '관리자',
e_mail = 'pyyk@gym.com',
sex = '남자',
birth = '881214',
height = '170',
weight = '70',
bmi = '20',
bmi_level = '표준',
loss = '5kg 감량',
months = '6~12개월',
category = '필라테스',
category_level = '필른이';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw = 'user1',
`name` = '김창민',
nickName = '유저1',
e_mail = 'user1@gym.com',
sex = '여자',
birth = '990415',
height = '150',
weight = '55',
bmi = '20',
bmi_level = '표준',
loss = '10kg 감량',
months = '1~3개월',
category = '요가',
category_level = '요른이';

SELECT * FROM `member`;

CREATE TABLE board (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	`code` CHAR(100) NOT NULL UNIQUE, # free/notice
	`name` CHAR(100) NOT NULL # 자유/공지사항
);

INSERT INTO `board`
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'notice',
`name` = '공지';

INSERT INTO `board`
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'free',
`name` = '자유';

INSERT INTO `board`
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'food',
`name` = '식품 후기';

INSERT INTO `board`
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'wear',
`name` = '운동복 후기';

SELECT * FROM board;

CREATE TABLE articleLike (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	articleId INT(10) UNSIGNED NOT NULL,
	memberId INT(10) UNSIGNED NOT NULL,
	FOREIGN KEY (`articleId`) REFERENCES `article`(`id`),
	FOREIGN KEY (`memberId`) REFERENCES `member`(`id`)
);

SELECT * FROM articleLike;

CREATE TABLE articleReplyLike (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	articleReplyId INT(10) UNSIGNED NOT NULL,
	memberId INT(10) UNSIGNED NOT NULL,
	FOREIGN KEY (`articleReplyId`) REFERENCES `articleReply`(`id`),
	FOREIGN KEY (`memberId`) REFERENCES `member`(`id`)
);

SELECT * FROM articleReplyLike;

CREATE TABLE sportsrecommend (
   id INT(100) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
   sex CHAR(100) NOT NULL,
   category CHAR(100) NOT NULL,
   brand CHAR(100) NOT NULL,
   part CHAR(100) NOT NULL,
    price INT(100) NOT NULL,
   `name` VARCHAR(1000) NOT NULL
);

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '하의',
price = 27000,
`name` = '베스트셀러 에어쿨링';


INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '하의',
price = 35000,
`name` = '에어쿨링 핏 텐션';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '하의',
price = 19000,
`name` = '조거핏';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '티셔츠',
price = 27000,
`name` = '에어페치페이스'; 

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '티셔츠',
price = 35000,
`name` = '에어로실버크롭티';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '티셔츠',
price = 22000,
`name` = '시스루투웨이셔링커버업';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '아우터',
price = 27000,
`name` ='릴레어컴포트핏크롭집업';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '아우터',
price = 35000,
`name` ='릴레어컴포트핏집업';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '아우터',
price = 19000,
`name` ='클리어페더미들윈드자켓';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '이너웨어',
price = 27000,
`name` = '비프리올데이';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '이너웨어',
price = 19000,
`name` = '에어리프리소프트';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '안다르',
part = '이너웨어',
price = 19000,
`name` = '프론트지퍼홀백';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '하의',
price = 27000,
`name` = "블랙라벨 시그니처 360N";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '하의',
price = 35000,
`name` = "업텐션";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '하의',
price = 19000,
`name` = "블랙라벨 시그니처 360N 부츠컷팬츠";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '티셔츠',
price = 27000,
`name` = "프레쉬페더 트위스트 크롭 숏슬리브";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '티셔츠',
price = 35000,
`name` = "에어센트 숏슬리브";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '티셔츠',
price = 19000,
`name` = "언밸러스 트임 숏슬리브";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '아우터',
price = 27000,
`name` = "슬림핏크롭집업자켓";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '아우터',
price = 47000,
`name` = "젤라인텐션슬림핏집업자켓";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '아우터',
price = 19000,
`name` = "XXMX 크롭 바람막이 블랙";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '이너웨어',
price = 28900,
`name` = "블랙라벨시그니처서포트탑";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '이너웨어',
price = 35000,
`name` = "하이디베이직";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '젝시믹스',
part = '이너웨어',
price = 19000,
`name` = "베이직플레인";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '하의',
price = 27000,
`name` = "제로뉴베이직";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '하의',
price = 35000,
`name` = "플렉스 에어";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '하의',
price = 19000,
`name` = "익스트림 프로";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '티셔츠',
price = 27000,
`name` = "라운드크롭 숏슬리브";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '티셔츠',
price = 35000,
`name` = "플레어언발슬리브리스";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '티셔츠',
price = 17000,
`name` = "벤츄리쿨링티셔츠";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '아우터',
price = 27000,
`name` = "아쿠아쿨링크롭자켓";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '아우터',
price = 35000,
`name` = "올데이라이트후드집업";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '아우터',
price = 19000,
`name` = "후드집업우드로즈핑크";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '이너웨어',
price = 27000,
`name` = "아우아쿨링소피아";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '이너웨어',
price = 35000,
`name` = "아쿠아쿨링다이아";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '헬스', 
brand = '스컬피그',
part = '이너웨어',
price = 19000,
`name` = "익스트림맥스업";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '안다르',
part = '하의',
price = 27000,
`name` = '베스트셀러 에어쿨링';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '안다르',
part = '하의',
price = 35000,
`name` = '에어쿨링 핏 텐션';

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '안다르',
part = '티셔츠',
price = 39000,
`name` = "모달 투웨이 슬릿 커버업";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '안다르',
part = '티셔츠',
price = 27000,
`name` = "모달 서스테이너블 크로스백 슬리브리스";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '안다르',
part = '티셔츠',
price = 35000,
`name` = "모달 서스테이너블 드레이프 숏슬리브";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '안다르',
part = '아우터',
price = 19000,
`name` = "클리어페더윈드자켓";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '안다르',
part = '아우터',
price = 27000,
`name` = "시스루멀티커버업";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '안다르',
part = '아우터',
price = 45000,
`name` = "에어쿨링타이업가디건";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '안다르',
part = '이너웨어',
price = 19000,
`name` = "비프리올데이";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '안다르',
part = '이너웨어',
price = 27000,
`name` = "에어리프리소프트";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '안다르',
part = '이너웨어',
price = 35000,
`name` = "프론트지퍼홀백";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '하의',
price = 19000,
`name` = "에어라이트 3D 9부 Lgg";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '하의',
price = 27000,
`name` = "힙업 부스터 프럽 Lgg";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '하의',
price = 15500,
`name` = "Penna Soft Leggings(Navy)";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '티셔츠',
price = 19000,
`name` = "레이어 올인원 크롭탑";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '티셔츠',
price = 27000,
`name` = "빅홀 올인원 크롭탑";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '티셔츠',
price = 35000,
`name` = "오픈백 스트랩 슬리브";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '아우터',
price = 19000,
`name` = "타이다이 랩 가디건";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '아우터',
price = 27000,
`name` = "루즈 플러피 맨투맨 ";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '아우터',
price = 35000,
`name` = "디어 슬릿 골지 슬리브";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '이너웨어',
price = 19000,
`name` = "블랙라벨시그니처서포트탑";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '이너웨어',
price = 25000,
`name` = "하이디베이직";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '콘치웨어',
part = '이너웨어',
price = 35000,
`name` = "베이직플레인";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '하의',
price = 19000,
`name` = "스티치스모킹";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '하의',
price = 27000,
`name` = "우븐스트레치";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '하의',
price = 34000,
`name` = "핀턱조거";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '티셔츠',
price = 19000,
`name` = "키홀 홀터넥 캐미솔 - 딥 라벤더";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '티셔츠',
price = 27000,
`name` = "레이온 숏슬리브 커버업 - 인디 핑크";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '티셔츠',
price = 35000,
`name` = "스모킹 숏슬리브 커버업 - 스카이 샌드";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '아우터',
price = 19000,
`name` = "타이다이 셔츠";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '아우터',
price = 27000,
`name` = "워싱 랩 가디건";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '아우터',
price = 35000,
`name` = "요루 한텐";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '이너웨어',
price = 19000,
`name` = "아우아쿨링소피아";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '이너웨어',
price = 21000,
`name` = "아쿠아쿨링다이아";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '요가', 
brand = '요가웨어',
part = '이너웨어',
price = 35000,
`name` = "익스트림맥스업";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '시크릿스',
part = '하의',
price = 19000,
`name` = "V컷 Lgg 요가 필라테스 애플힙 스포츠";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '시크릿스',
part = '티셔츠',
price = 19900,
`name` = "글램버튼필라테스복반팔";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '시크릿스',
part = '티셔츠',
price = 35000,
`name` = "에어로실버크롭티";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '시크릿스',
part = '티셔츠',
price = 19000,
`name` = "개미허리필라테스복";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '시크릿스',
part = '이너웨어',
price = 27000,
`name` = "스킨 크롭탑 튜브탑 필라테스 요가";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '시크릿스',
part = '이너웨어',
price = 35000,
`name` = "코르셋 브라탑 필라테스 요가";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '젝시믹스',
part = '하의',
price = 19000,
`name` = "블랙라벨 시그니처 330N 8부";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '젝시믹스',
part = '하의',
price = 26000,
`name` = "블랙라벨 시그니처 300N 수퍼라이트";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '젝시믹스',
part = '하의',
price = 35000,
`name` = "블랙라벨 시그니처 투웨이워터";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '젝시믹스',
part = '이너웨어',
price = 19000,
`name` = "소프트 액티브 브라 블랙";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '젝시믹스',
part = '이너웨어',
price = 27000,
`name` = "소프트 액티브 브라 멜란그레이";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '젝시믹스',
part = '이너웨어',
price = 42000,
`name` = "골지 밴딩 브라렛 라벤더가든";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '뮬라웨어',
part = '하의',
price = 19000,
`name` = "뉴 노블 하이라이즈";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '뮬라웨어',
part = '하의',
price = 27000,
`name` = "제로 프레스";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '뮬라웨어',
part = '하의',
price = 35000,
`name` = "에너지업";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '뮬라웨어',
part = '티셔츠',
price = 19000,
`name` = "슬래쉬 포인트 롱 슬리브(패드 타입)";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '뮬라웨어',
part = '티셔츠',
price = 23000,
`name` = "백 오버랩 롱 슬리브(패드 타입)";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '뮬라웨어',
part = '티셔츠',
price = 35000,
`name` = "백컷 숏 슬리브(패드 타입)";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '뮬라웨어',
part = '이너웨어',
price = 19000,
`name` = "믹스 업 숏 브라탑";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '뮬라웨어',
part = '이너웨어',
price = 27000,
`name` = "프론트 집업 숏 브라탑";

INSERT INTO sportsrecommend
SET sex = '여자',
category = '필라테스', 
brand = '뮬라웨어',
part = '이너웨어',
price = 35000,
`name` = "노블 액티브 숏 브라탑";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '젝시믹스',
part = '하의',
price = 19000,
`name` = "하디 스트레치 카고 쇼츠";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '젝시믹스',
part = '하의',
price = 29000,
`name` = "멀티플 액션 6인치 쇼츠";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '젝시믹스',
part = '하의',
price = 35000,
`name` = "컴포터블 카고 조거팬츠";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '젝시믹스',
part = '티셔츠',
price = 19000,
`name` = "머슬핏 숏슬리브";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '젝시믹스',
part = '티셔츠',
price = 27000,
`name` = "머슬핏 듀얼 슬리브리스";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '젝시믹스',
part = '티셔츠',
price = 35000,
`name` = "트리플 엑스 숏슬리브";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '젝시믹스',
part = '아우터',
price = 19000,
`name` = "윈드테크 스윙자켓";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '젝시믹스',
part = '아우터',
price = 27000,
`name` = "플렉스 집업 후디";


INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '젝시믹스',
part = '아우터',
price = 38000,
`name` = "스트링 후드 아노락";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '스파이더',
part = '하의',
price = 19000,
`name` = "유니섹스 저지 숏츠";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '스파이더',
part = '하의',
price = 27000,
`name` = "맨즈 트레이닝 베이직 셋업 팬츠";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '스파이더',
part = '하의',
price = 35000,
`name` = "유니섹스 트레이닝 라이트 셋업 팬츠";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '스파이더',
part = '티셔츠',
price = 19000,
`name` = "유니섹스 에센셜 미들 로고 반팔 티셔츠";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '스파이더',
part = '티셔츠',
price = 27000,
`name` = "유니섹스 트레이닝 슬림핏 반팔 티셔츠";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '스파이더',
part = '티셔츠',
price = 35000,
`name` = "유니섹스 액티브 긴팔 티셔츠";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '스파이더',
part = '아우터',
price = 19500,
`name` = "맨즈 러닝 라이트 핑거루프 후드 집업 자켓";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '스파이더',
part = '아우터',
price = 27000,
`name` = "맨즈 액티브 스탠드넥 쿨링 트리코트 셋업 집업";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '스파이더',
part = '아우터',
price = 35000,
`name` = "유니섹스 트레이닝 하프집 아노락 자켓";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '언더아머',
part = '하의',
price = 19000,
`name` = "남성 UA 론치 런 5인치 쇼츠";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '언더아머',
part = '하의',
price = 27000,
`name` = "남성 APAC 우븐 쇼츠 2.0";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '언더아머',
part = '하의',
price = 35000,
`name` = "남성 UA 론치 런 투인원 쇼츠";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '언더아머',
part = '티셔츠',
price = 19000,
`name` = "남성 UA 스포츠스타일 로고 탱크";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '언더아머',
part = '티셔츠',
price = 29000,
`name` = "남성 UA RUSH™ 우븐 ½ 집 아노락 재킷";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '언더아머',
part = '티셔츠',
price = 35000,
`name` = "남성 UA 베이스라인 코튼 탱크";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '언더아머',
part = '아우터',
price = 19000,
`name` = "남성 UA Storm 포프런트 레인 재킷";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '언더아머',
part = '아우터',
price = 27000,
`name` = "남성 UA 스트레치 우븐 윈드브레이커 ";

INSERT INTO sportsrecommend
SET sex = '남자',
category = '헬스', 
brand = '언더아머',
part = '아우터',
price = 35000,
`name` = "남성 프로젝트 락 브라마 재킷";

SELECT * FROM sportsrecommend;

CREATE TABLE foodRecommend (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(100) NOT NULL,
    part VARCHAR(100) NOT NULL,
    price INT(100) NOT NULL,
    product VARCHAR(100) NOT NULL
);

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 21000,
product = '소스품은 닭가슴살 화이트어니언';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 19000,
product = '소스품은 닭가슴살 청양마요';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 24000,
product = '소스품은 닭가슴살 리얼커리';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 35000,
product = '소스품은 닭가슴살 사천짜장맛';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 19000,
product = '소스품은 닭가슴살 찜닭맛';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 27000,
product = '스팀 조각 닭가슴살 매콤칠리';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 35000,
product = '스팀 닭가슴살 오리지널';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 19000,
product = '스팀 닭가슴살 블랙페퍼';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 27000,
product = '스팀 닭가슴살 허브바베';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 35000,
product = '훈제 닭가슴살 할라피뇨';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 19000,
product = '훈훈제 닭가슴살 오리지널';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 27000,
product = '훈제 닭가슴살 저염';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 35000,
product = '훈제 닭가슴살 페퍼';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '닭가슴살',
price = 19000,
product = '훈제 닭가슴살 6종 골라담기';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 27000,
product = '훈닭가슴살 후랑크 소시지 5종 세트';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 35000,
product = '닭가슴살 후랑크 꼬치 5종 세트';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 19000,
product = '닭가슴살 방울소시지 3종 세트';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 27000,
product = '닭가슴살 후랑크 소시지 오리지널';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 35000,
product = '닭가슴살 후랑크 소시지 치즈';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 19000,
product = '닭가슴살 후랑크 소시지 알싸청양';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 27000,
product = '닭가슴살 후랑크 소시지 불닭';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 35000,
product = '닭가슴살 후랑크 소시지 매콤갈비';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 19000,
product = '닭가슴살 후랑크 꼬치 오리지널';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 27000,
product = '닭가슴살 후랑크 꼬치 치즈';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 35000,
product = '닭가슴살 후랑크 꼬치 알싸청양';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 19000,
product = '닭가슴살 후랑크 꼬치 커리';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 27000,
product = '닭가슴살 후랑크 꼬치 페퍼';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 35000,
product = '닭가슴살 방울소시지 오리지널';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 19000,
product = '닭가슴살 방울소시지 알싸청양';

INSERT INTO foodRecommend
SET brand = '바르닭',
part = '소세지',
price = 27000,
product = '닭가슴살 방울소시지 치즈';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 35000,
product = '[허닭]소스 슬라이스 닭가슴살 120g 화이트머쉬룸 10팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 19000,
product = '[허닭]스팀 소스 닭안심 120g 바베큐';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 27000,
product = '[허닭]스팀 소스 닭안심 120g 핫바베큐';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 35000,
product = '[오빠닭]소스 슬라이스 닭가슴살 레드크림커리 120g';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 19000,
product = '[바디닭]소프트 저염 닭가슴살';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 27000,
product = '[허닭]스팀 닭가슴살 100g 마늘맛';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 25000,
product = '[허닭]스팀 닭가슴살 100g 고추맛';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 19000,
product = '[허닭]스팀 닭가슴살 100g 탄두리맛';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 27000,
product = '[허닭]스팀 닭가슴살 100g 깻잎맛';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 35000,
product = '[BBQ]BBQ BEST 그릴 통 닭가슴살';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 19000,
product = '[BHC]수비드 홀 닭가슴살 100g 4종 20팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 27000,
product = '[BHC]수비드 홀 닭가슴살 100g 4종 4팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 35000,
product = '[BHC]수비드 홀 닭가슴살 100g 4종 12팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '닭가슴살',
price = 19000,
product = '[BHC]수비드 홀 닭가슴살 100g 4종 10팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '한입큐브',
price = 27000,
product = '[허닭]한입 닭가슴살 큐브 새우100g 10팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '한입큐브',
price = 35000,
product = '[허닭]한입 닭가슴살 큐브 오징어100g 10팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '한입큐브',
price = 19000,
product = '[허닭]한입 닭가슴살 어묵볼100g 감자베이컨 1팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '한입큐브',
price = 27000,
product = '[허닭]한입 닭가슴살 어묵볼100g 치즈 10팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '한입큐브',
price = 35000,
product = '[꼬꼬빌]심쿵 닭가슴살 오븐구이 저크바베큐 130g x 5팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '한입큐브',
price = 19000,
product = '[꼬꼬빌]심쿵 닭가슴살 오븐구이 저크바베큐 130g x 10팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '한입큐브',
price = 27000,
product = '[꼬꼬빌]심쿵 닭가슴살 오븐구이 치즈범벅 130g x 5팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '한입큐브',
price = 32000,
product = '[꼬꼬빌]심쿵 닭가슴살 오븐구이 저크바베큐 130g x 30팩';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '햇살닭 현미 닭가슴살 스테이크 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 27000,
product = '맛있닭 닭가슴살 스테이크 오리지널 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 35000,
product = '맛있닭 닭가슴살 스테이크 갈릭맛 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '맛있닭 닭가슴살 스테이크 고추맛 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 27000,
product = '맛있닭 닭가슴살 스테이크 호박맛 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '맛있닭 소스 닭가슴살 스테이크 매콤 토마토 150g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 35000,
product = '맛있닭 소스 닭가슴살 스테이크 로스트 갈릭 150g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 27000,
product = '맛있닭 소스 닭가슴살 스테이크 자색고구마 까르보나라 150g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 16000,
product = '맛있닭 소스 닭가슴살 스테이크 흑마늘 150g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '맛있닭 저염 닭가슴살 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 27000,
product = '맛있닭 프로 닭가슴살 120g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 35000,
product = '맛있닭 닭가슴살 스테이크 갈릭맛 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '맛있닭 저염·프로 닭가슴살 혼합 100~120g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 27000,
product = '(강추)잇메이트 저염 스팀 닭가슴살 오리지널 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 15000,
product = '(강추)잇메이트 저염 닭가슴살 오리지널 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '햇살닭 저염 훈제 닭가슴살 플러스 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '햇살닭 저염 수비드 닭가슴살 150g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 27000,
product = '햇살닭 저염 훈제 닭가슴살 오리지널 200g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 35000,
product = '랭커 IQF 한입 닭가슴살 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '랭커 IQF 한입 닭가슴살 200g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 29900,
product = '랭커 IQF 한입 닭가슴살 1kg';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 41000,
product = '하림 동물복지 IFF 냉동 생 닭가슴살 800g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '다향 IQF 닭가슴살 1kg';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 27000,
product = '닭스몰 무항생제 1등급 냉동 생 닭가슴살 400g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 35000,
product = '맛있닭 훈제 닭가슴살 훈제 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '맛있닭 훈제 닭가슴살 칠리 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 27000,
product = '맛있닭 훈제 닭가슴살 카레 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 35000,
product = '맛있닭 훈제 닭가슴살 혼합 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '잇메이트 훈제 닭가슴살 오리지널 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 27000,
product = '잇메이트 훈제 닭가슴살 마늘 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 35000,
product = '잇메이트 훈제 닭가슴살 할라피뇨 100g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 19000,
product = '치품닭 치즈품은 훈제 닭가슴살 갈릭 110g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 27000,
product = '치품닭 치즈품은 훈제 닭가슴살 고추 110g';

INSERT INTO foodRecommend
SET brand = '랭킹닭컴',
part = '닭가슴살',
price = 35000,
product = '햇살닭 저염 훈제 닭가슴살 오리지널 200g';

INSERT INTO foodRecommend
SET brand = '마이프로틴',
part = '프로틴',
price = 19000,
product = '임팩트웨이프로틴';

INSERT INTO foodRecommend
SET brand = '마이프로틴',
part = '프로틴',
price = 27000,
product = '임팩트웨이아이솔레이트';

INSERT INTO foodRecommend
SET brand = '마이프로틴',
part = '프로틴',
price = 35000,
product = '모노크레아틴';

INSERT INTO foodRecommend
SET brand = '마이프로틴',
part = '프로틴',
price = 17900,
product = '클리어웨이아아이솔레이트';

INSERT INTO foodRecommend
SET brand = '마이프로틴',
part = '프로틴',
price = 27000,
product = '프로틴 식사대용 블렌드(저칼로리 식사대용)';

INSERT INTO foodRecommend
SET brand = '마이프로틴',
part = '프로틴',
price = 35000,
product = '클리어웨이게이너';

INSERT INTO foodRecommend
SET brand = '마이프로틴',
part = '프로틴',
price = 19000,
product = '임팩트다이어트웨이';

INSERT INTO foodRecommend
SET brand = '마이프로틴',
part = '프로틴',
price = 27500,
product = '임팩트 프로틴 블렌드';

INSERT INTO foodRecommend
SET brand = '신타6',
part = '프로틴',
price = 35000,
product = '단백질파우더드링크믹스(초콜릿밀크쉐이크)';

INSERT INTO foodRecommend
SET brand = '신타6',
part = '프로틴',
price = 19000,
product = '울트라프리미엄프로틴매트릭스(딸기밀크셰이크)';

INSERT INTO foodRecommend
SET brand = '신타6',
part = '프로틴',
price = 27000,
product = '콜드스톤 크리머리(민트초콜릿칩)';

INSERT INTO foodRecommend
SET brand = '신타6',
part = '프로틴',
price = 35000,
product = '콜드스톤크리머리쿠키돈트유원썸';

INSERT INTO foodRecommend
SET brand = '신타6',
part = '프로틴',
product = '비에스엔 프로틴 파우더"';

INSERT INTO foodRecommend
SET brand = '신타6',
part = '프로틴',
price = 18000,
product = '비에스엔 아이솔레이트';

INSERT INTO foodRecommend
SET brand = '신타6',
part = '프로틴',
price = 28000,
product = '비에스엔 엣지';

INSERT INTO foodRecommend
SET brand = '머슬팜',
part = '프로틴',
price = 35000,
product = '울트라 웨이 머슬팜 컴뱃';

INSERT INTO foodRecommend
SET brand = '머슬팜',
part = '프로틴',
price = 19000,
product = '프로틴 파우더 머슬팜 컴뱃';

INSERT INTO foodRecommend
SET brand = '머슬팜',
part = '프로틴',
price = 29900,
product = 'BCAA 아미노산 머슬팜 컴뱃';

INSERT INTO foodRecommend
SET brand = '머슬팜',
part = '프로틴',
price = 35000,
product = 'CLA 머슬팜 컴뱃';

INSERT INTO foodRecommend
SET brand = '머슬팜',
part = '프로틴',
price = 19000,
product = '글루타민 머슬팜 컴뱃';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 27000,
product = '그린 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 35000,
product = '토시살 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 19000,
product = '부채살 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 27000,
product = '목살 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 35000,
product = '훈제 연어 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 19000,
product = '촉촉 닭가슴살 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 25000,
product = '리코타치즈 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 35000,
product = '치킨 텐더 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 19500,
product = '무스 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 27000,
product = '아보카도 샐러드 빅볼';


INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 30000,
product = '아보카도 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 19000,
product = '구운 새우 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '샐러드',
price = 27000,
product = '구운 야채 샐러드 빅볼';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '샐러드',
price = 17000,
product = '[데일리] 그린 샐러드(드레싱x)';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '샐러드',
price = 19000,
product = '[SET] 인기 샐러드 8종 맛보기 세트';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '샐러드',
price = 27000,
product = '[데일리] 닭가슴살 오징어 샐러드 5팩 세트';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '샐러드',
price = 35000,
product = '[데일리+프리미엄] 샐러드 골라담기';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '샐러드',
price = 19000,
product = '[프리미엄] 샐러드 골라담기';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '샐러드',
price = 33000,
product = '[프리미엄] 아보카불고기 샐러드';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '샐러드',
price = 35000,
product = '[프리미엄] 그릴두부 샐러드';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '샐러드',
price = 19000,
product = '[프리미엄] 그릴함박스테이크 샐러드';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '샐러드',
price = 27000,
product = '[프리미엄] 아보카쉬림프 샐러드';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '샐러드',
price = 35000,
product = '[데일리] 목살 스테이크 샐러드';

INSERT INTO foodRecommend
SET brand = '샐러드판다',
part = '샐러드',
price = 19000,
product = '샐린이 3종 세트';

INSERT INTO foodRecommend
SET brand = '샐러드판다',
part = '샐러드',
price = 22000,
product = '베스트 4종 세트';

INSERT INTO foodRecommend
SET brand = '샐러드판다',
part = '샐러드',
price = 35000,
product = '잘 챙겨먹어야해 6종 세트';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 19000,
product = '그린 샐러드';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 21900,
product = '닭가슴살 샐러드';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 35000,
product = '훈제오리 샐러드';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 19000,
product = '닭가슴살볼 숯불갈비맛샐러드';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 27000,
product = '채소만 베이직 플러스 믹스 샐러드';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 31000,
product = '파스타 샐러드';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 19000,
product = '(4주)정기배송 샐러드 (주/5일)';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 27000,
product = '(4주)정기배송 샐러드 (주/5일)';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 35000,
product = '(2주) 정기배송 샐러드 (주/6일)';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 19000,
product = '샐러드와 간편식(5일)';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 29000,
product = '(4주)정기배송 짜여진 식단';

INSERT INTO foodRecommend
SET brand = '포켓샐러드',
part = '샐러드',
price = 35000,
product = '(6주)정기배송 짜여진 식단';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '다이어트 도시락',
price = 19000,
product = '촉촉 닭가슴살 도시락';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '다이어트 도시락',
price = 27000,
product = '훈제 오리 도시락';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '다이어트 도시락',
price = 35000,
product = '목살 스테이크 도시락';

INSERT INTO foodRecommend
SET brand = '샐러디아',
part = '다이어트 도시락',
price = 19000,
product = '연어 스테이크 도시락';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '다이어트 도시락',
price = 27000,
product = '[슬림쿡 런치] 플러스+ 정기배송 (10일)';

INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '다이어트 도시락',
price = 35000,
product = '[슬림쿡 런치] 플러스+ 정기배송(5일)';


INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '다이어트 도시락',
price = 19000,
product = '[슬림쿡 런치] 플러스+ 정기배송 (3일)';


INSERT INTO foodRecommend
SET brand = '슬림쿡',
part = '다이어트 도시락',
price = 27000,
product = '[슬림쿡 런치] 도시락 정기배송 (3일)';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '다이어트 도시락',
price = 35000,
product = '잡곡밥 도시락 6종 24팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '다이어트 도시락',
price = 19000,
product = '볶음밥 도시락 250g 6종 12팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '다이어트 도시락',
price = 27000,
product = '다이어트 도시락 210g 4종 8팩';

INSERT INTO foodRecommend
SET brand = '허닭',
part = '다이어트 도시락',
price = 35000,
product = '일품도시락 10종 11팩';

INSERT INTO foodRecommend
SET brand = '편한 한끼',
part = '다이어트 도시락',
price = 19000,
product = '한끼도시락 간편 냉동 복음밥 도시락 6팩';

INSERT INTO foodRecommend
SET brand = '편한 한끼',
part = '다이어트 도시락',
price = 27000,
product = '식단도시락34종골라담기';

INSERT INTO foodRecommend
SET brand = '편한 한끼',
part = '다이어트 도시락',
price = 35000,
product = '장인도시락 간편 식단관리 (남편/아이들도시락)';

INSERT INTO foodRecommend
SET brand = '편한 한끼',
part = '다이어트 도시락',
price = 19000,
product = '일고단백식 1주 닭가슴살 식단 도시락 (6종/6팩)';

SELECT * FROM foodRecommend;