-- 사용자 테이블
CREATE TABLE USER_TB(
	USER_NO NUMBER PRIMARY KEY,
	KAKAO_USER_ID NUMBER NOT NULL,
	USER_EMAIL VARCHAR2(1000) NOT NULL,
	USER_NAME VARCHAR2(500),
	USER_ADDR VARCHAR2(1000),
	USER_PHONE VARCHAR2(1000),
	USER_BIRTH DATE,
	USER_MBTI VARCHAR2(100),
	USER_IS_WITHDRAWN CHAR(1) CHECK (USER_IS_WITHDRAWN IN ('Y', 'N')),
	USER_JOIN_DATE DATE,
	USER_PURCHASE_CNT NUMBER
);
CREATE SEQUENCE USER_SQ
	INCREMENT BY 1
	START WITH 1
	CACHE 20;
ALTER TABLE USER_TB ADD CONSTRAINT UK_USER_EMAIL UNIQUE (USER_EMAIL);
ALTER TABLE USER_TB MODIFY USER_IS_WITHDRAWN CHAR(1) NOT NULL;
ALTER TABLE USER_TB MODIFY USER_JOIN_DATE DATE NOT NULL;
SELECT * FROM USER_TB;

SELECT * FROM PRODUCT_CATEGORY_TB;
SELECT * FROM PRODUCT_TB;
SELECT * FROM PRODUCT_TB WHERE CATEGORY_NO = 26;
SELECT * FROM SELLER_TB;
SELECT * FROM PRODUCT_IMG_TB;
SELECT * FROM PRODUCT_OPTION_TB;
SELECT * FROM OPTION_TB;

INSERT INTO SELLER_TB VALUES (
	SELLER_SQ.NEXTVAL,
	'SEL1',
	'PW1',
	'홍길동',
	'010-1234-1234',
	'gildong123@naver.com',
	'123123123',
	'길동 만물상',
	'서울 강남구 도곡로 112 서한빌딩 3층 테크브루',
	'N',
	'Y',
	SYSDATE
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'JBL FLIP6 휴대용 캠핑 피크닉 무선 블루투스 스피커',
	149000,
	20,
	'/product_img/26-1-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'오아 아이브릭 미니 블루투스 스피커 무선 휴대용 캠핑 야외 감성 탁상용',
	24800,
	15,
	'/product_img/26-2-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'아이리버 블루투스스피커 사운드드럼 시즌2 BTS-D1',
	32800,
	12,
	'/product_img/26-3-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'블루투스스피커 마제스티7 25년형',
	249100,
	7,
	'/product_img/26-4-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'NEW 뮤젠 와일드 미니 2.0 아웃도어 블루투스 스피커',
	119000,
	35,
	'/product_img/26-5-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'크리에이티브 PEBBLE V3 스피커',
	64900,
	25,
	'/product_img/26-6-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'HURIZ MUSE 미니턴테이블 블루투스 스피커',
	44900,
	20,
	'/product_img/26-7-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'일리안 휴대용 블루투스 스피커',
	36000,
	27,
	'/product_img/26-9-detail.jpg'
);

UPDATE PRODUCT_TB SET PRODUCT_NM = '일리안 휴대용 블루투스 스피커', PRODUCT_PRICE=36000, DETAIL_IMG_URL='/product_img/26-9-detail.jpg' WHERE PRODUCT_NO = 72;

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'PRESONUS Eris E3.5',
	194000,
	20,
	'/product_img/26-10-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'에이투 붐5 방수 블루투스 스피커',
	60510,
	15,
	'/product_img/26-11-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'액센 BS80 TWS 불멍 무드램프 스피커',
	109000,
	16,
	'/product_img/26-12-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'슬기로운야외생활 감성 우드 블루투스 스피커',
	12900,
	17,
	'/product_img/26-13-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'Britz BA-C1 SoundRoom 휴대용 멀티 블루투스 스피커',
	79000,
	19,
	'/product_img/26-14-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'앱코 SP400 2채널 북쉘프 USB 컴퓨터 스피커',
	26500,
	7,
	'/product_img/26-15-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'브리츠 스피커 Z2100 2채널',
	33000,
	12,
	'/product_img/26-16-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'세비즈 레트로 우드 5.0 블루투스 휴대용 캠핑용 스피커',
	42000,
	11,
	'/product_img/26-17-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'브리츠 BZ-SP200X 데스크탑 게이밍 PC스피커',
	39900,
	15,
	'/product_img/26-18-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'피스넷 뮤직라이더 시즌2',
	69900,
	36,
	'/product_img/26-19-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	26,
	1,
	'디붐 디투 프로 블루투스 스피커',
	129000,
	50,
	'/product_img/26-20-detail.jpg'
);