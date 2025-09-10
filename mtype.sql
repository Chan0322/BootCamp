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
ALTER TABLE USER_TB ADD CONSTRAINT UK_KAKAO_USER_ID UNIQUE (KAKAO_USER_ID);
ALTER TABLE USER_TB MODIFY USER_IS_WITHDRAWN CHAR(1) NOT NULL;
ALTER TABLE USER_TB MODIFY USER_JOIN_DATE DATE NOT NULL;
SELECT * FROM USER_TB;

SELECT * FROM PRODUCT_CATEGORY_TB;
SELECT * FROM PRODUCT_TB;
SELECT * FROM PRODUCT_TB WHERE CATEGORY_NO = 28;
SELECT * FROM SELLER_TB;
SELECT * FROM PRODUCT_IMG_TB;
SELECT * FROM PRODUCT_OPTION_TB;
SELECT * FROM OPTION_TB;

-- 판매자 테스트용 
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
--

---------------------------------------- 디지털 - 음향기기 - 스피커 -------------
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
---------------------------------------------------------------------------

------------------------------------디지털 - 음향기기 - 마이크 ----------------------
INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'마타스튜디오 C1',
	20000,
	28,
	'/product_img/27-1-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'TSG 스탠드 콘덴서 마이크 GM200U',
	52900,
	11,
	'/product_img/27-2-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'피핀 Fifine AM8 다이나믹 마이크',
	64600,
	15,
	'/product_img/27-3-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'미라클엠 M70 블루투스 마이크',
	44500,
	7,
	'/product_img/27-4-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'COSY 휴대용 블랑 블루투스마이크',
	29000,
	32,
	'/product_img/27-5-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'로이체 노래방 마이크 BTS-30KM',
	21900,
	13,
	'/product_img/27-6-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'미라클엠 블루투스마이크 M100',
	72000,
	56,
	'/product_img/27-7-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'마타스튜디오 와이어리스1',
	55000,
	34,
	'/product_img/27-8-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'펜톤 BM5 무선 블루투스 노래방 마이크',
	49790,
	43,
	'/product_img/27-9-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'오아 뮤즈S 블루투스 노래방 무선 마이크',
	37800,
	20,
	'/product_img/27-10-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'블루투스 마이크 TJ미디어 (TMB-10)',
	79000,
	9,
	'/product_img/27-11-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'블루투스마이크 참이슬 숟가락 마이크',
	39900,
	14,
	'/product_img/27-12-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'잔망루피 블루투스 무선 노래방 휴대용 캐릭터 마이크',
	39900,
	16,
	'/product_img/27-13-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'플레이고 P154 휴대용 LED 블루투스 휴대용 에코 마이크',
	17800,
	35,
	'/product_img/27-14-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'욜로 2세대 블루투스 마이크 YS-BM320',
	27000,
	9,
	'/product_img/27-15-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'휴대용 차량용 마이크 자동차 노래방 블루투스 마이크',
	33150,
	25,
	'/product_img/27-16-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'욜로 PRO 블루투스 듀엣 노래방 마이크 YS-BM400',
	46200,
	16,
	'/product_img/27-17-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'ASSA 매직씽 AP-500 무선 블루투스 마이크',
	75000,
	13,
	'/product_img/27-18-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'만방코리아 블루투스마이크 V7',
	20000,
	43,
	'/product_img/27-19-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	27,
	1,
	'BT21 미니니 블루투스 노래방 마이크 CM KY',
	15900,
	24,
	'/product_img/27-20-detail.jpg'
);
--------------------------------------------------------

------------------------------------디지털 - 음향기기 - 이어폰/헤드셋 ----------------------
INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'브리츠 오픈형 골전도 블루투스 이어폰',
	56900,
	35,
	'/product_img/28-1-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'JBL T770NC 노이즈캔슬링 블루투스 헤드셋',
	129000,
	23,
	'/product_img/28-2-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'아이리버 무선 이어폰 IBO-OPENAIR3',
	44900,
	32,
	'/product_img/28-3-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'MONDO 몬도 프리스타일 온이어 헤드폰',
	99000,
	5,
	'/product_img/28-4-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'핏 ANC H1 블루투스 무선 헤드셋',
	69990,
	24,
	'/product_img/28-5-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'브리츠 미니멀 디자인 초경량 오픈형 블루투스 이어폰',
	34900,
	16,
	'/product_img/28-6-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'마샬 메이저5 MAJOR5 블루투스 헤드폰',
	160000,
	23,
	'/product_img/28-7-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'소니 WH-CH720N',
	139000,
	13,
	'/product_img/28-8-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'소니 WF-C710N 노이즈캔슬링 블루투스 이어폰',
	149000,
	25,
	'/product_img/28-9-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'QCY T1C 헤드폰 무선 블루투스 이어폰',
	28500,
	32,
	'/product_img/28-10-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'오리 헤드셋 덕헤드셋',
	47400,
	5,
	'/product_img/28-11-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'필립스 TAH 1108 블루투스 헤드셋',
	39900,
	26,
	'/product_img/28-12-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'삼성전자 JBL T770NC 오버이어 블루투스헤드셋',
	128000,
	50,
	'/product_img/28-13-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'베이어다이나믹 AVENTHO 300 노이즈캔슬링',
	699000,
	12,
	'/product_img/28-14-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'뱅앤올룹슨 베오플레이 H95 (Beoplay H95) 95주년',
	1449000,
	5,
	'/product_img/28-15-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'차이팟 블루투스 무선 이어폰',
	26900,
	55,
	'/product_img/28-16-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'초코송이 블루투스 이어폰 머쉬룸',
	136700,
	20,
	'/product_img/28-17-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'애플 에어팟 프로2 2세대',
	335040,
	33,
	'/product_img/28-18-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'삼성전자 갤럭시 버즈3 프로 SM-R630N',
	319000,
	35,
	'/product_img/28-19-detail.jpg'
);

INSERT INTO PRODUCT_TB VALUES (
	PRODUCT_SQ.NEXTVAL,
	28,
	1,
	'LG 톤플러스 HBS-510 무선 블루투스 이어폰',
	395010,
	30,
	'/product_img/28-20-detail.jpg'
);
--------------------------------------------------------

SELECT * FROM PRODUCT_IMG_TB ORDER BY IMG_NO DESC;
SELECT * FROM PRODUCT_TB;
SELECT * FROM PRODUCT_TB WHERE CATEGORY_NO = 26;
---------------------------- 디지털 - 음향기기 - 스피커  상품 이미지 ------
INSERT INTO PRODUCT_IMG_TB VALUES(
	PRODUCT_IMG_SQ.NEXTVAL,
	74,
	'/product_img/26-11-1.png',
	'Y'
);
INSERT INTO PRODUCT_IMG_TB VALUES(
	PRODUCT_IMG_SQ.NEXTVAL,
	74,
	'/product_img/26-11-2.png',
	'N'
);INSERT INTO PRODUCT_IMG_TB VALUES(
	PRODUCT_IMG_SQ.NEXTVAL,
	74,
	'/product_img/26-11-3.png',
	'N'
);
--------------------------------------------------------------------

SELECT * FROM PRODUCT_IMG_TB ORDER BY IMG_NO DESC;
SELECT * FROM PRODUCT_TB;
SELECT * FROM PRODUCT_TB WHERE CATEGORY_NO = 27;
---------------------------- 디지털 - 음향기기 - 마이크  상품 이미지 ------
INSERT INTO PRODUCT_IMG_TB VALUES(
	PRODUCT_IMG_SQ.NEXTVAL,
	136,
	'/product_img/27-20-1.png',
	'Y'
);
INSERT INTO PRODUCT_IMG_TB VALUES(
	PRODUCT_IMG_SQ.NEXTVAL,
	136,
	'/product_img/27-20-2.png',
	'N'
);INSERT INTO PRODUCT_IMG_TB VALUES(
	PRODUCT_IMG_SQ.NEXTVAL,
	136,
	'/product_img/27-20-3.png',
	'N'
);
--------------------------------------------------------------------

SELECT * FROM PRODUCT_IMG_TB ORDER BY IMG_NO DESC;
SELECT * FROM PRODUCT_IMG_TB WHERE PRODUCT_NO > 116 AND PRODUCT_NO < 137;
SELECT * FROM PRODUCT_TB;
SELECT * FROM PRODUCT_TB WHERE CATEGORY_NO = 26 ORDER BY PRODUCT_NO ASC;

SELECT * FROM PRODUCT_IMG_TB WHERE PRODUCT_NO IN (SELECT PRODUCT_NO FROM PRODUCT_TB WHERE CATEGORY_NO =26);
---------------------------- 디지털 - 음향기기 - 이어폰/헤드셋  상품 이미지 ------
INSERT INTO PRODUCT_IMG_TB VALUES(
	PRODUCT_IMG_SQ.NEXTVAL,
	156,
	'/product_img/28-20-1.png',
	'Y'
);
INSERT INTO PRODUCT_IMG_TB VALUES(
	PRODUCT_IMG_SQ.NEXTVAL,
	156,
	'/product_img/28-20-2.png',
	'N'
);INSERT INTO PRODUCT_IMG_TB VALUES(
	PRODUCT_IMG_SQ.NEXTVAL,
	156,
	'/product_img/28-20-3.png',
	'N'
);
--------------------------------------------------------------------