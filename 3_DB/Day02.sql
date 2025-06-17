-- 실행: CTRL + ENTER
SELECT * FROM EMPLOYEE;

-- 테이블명 블럭치고 F4

-- 데이터 기본 사항 처리 로직
-- 데이터 베이스에서 실행하고자 하는 명령 종류
-- [CRUD]
-- CREATE : 데이터 추가 / INSERT
-- READ   : 데이터 조회 / SELECT
-- UPDATE : 데이터 수정 / UPDATE
-- DELETE : 데이터 삭제 / DELETE

-- SELECT : 조회용 SQL 명령어
-- SELECT 조회용컬럼	: 조회하고자 하는 내용
-- FROM 테이블명		: 조회하고자 하는 테이블명
-- WHERE 조건			: 특정 조건
-- ORDER BY 컬럼		: 정렬
-- ;

-- 부서코드가 'D6'인 부서의
-- 직원 정보를 모두 조회하자.
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6';




-- DAY 2
-- 컬럼명에 별칭 달기

-- 1. AS 표현
SELECT EMP_ID AS "사원번호",
	   EMP_NAME AS "사원명"
FROM EMPLOYEE;

-- 2. AS 생략
SELECT EMP_ID "사원번호,",
--	   EMP_NAME '사원명'   별칭을 정할 때, '' 사용 불가. ""사용!
	   EMP_NAME 사원명     -- ""생략 가능!
FROM EMPLOYEE;
-- ""으로 별명 작성
-- 생략도 가능하다.
-- 단, 별칭에 공백이 들어갈 경우 생략 불가!

SELECT EMP_ID "사원 번호",
	   EMP_NAME 사원명
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 부서가 'D2'이거나 'D1'인
-- 사원들의 사원명, 입사일, 연락처를 조회
-- (단, 조회하는 컬럼명에 별칭 부여)
SELECT EMP_NAME "사원명",
	   HIRE_DATE 입사일,
	   PHONE "연락처"
FROM EMPLOYEE
WHERE DEPT_CODE = 'D2'
   OR DEPT_CODE = 'D1';


-- SELECT에 연산이 들어갈 수 있다.
-- 컬럼값이 NULL이라면 어떤 연산 처리가 되어도
-- 결과값은 무조건 NULL
SELECT EMP_NAME 사원명,
	   SALARY 급여,
	   (SALARY * 12) 연봉,   -- 컬럼명이 길다. 별칭을 제공해 주면, 훨씬 편하게 접근 가능.
	   BONUS 보너스,
	   (SALARY + (SALARY*BONUS))*12 연봉총합
FROM EMPLOYEE;

-- NVL() : 현재 조회한 값이 NULL일 경우 별로도 지정한 값으로 변경.
SELECT BONUS, NVL(BONUS, 0)
FROM EMPLOYEE;

SELECT EMP_NAME 사원명,
	   SALARY 급여,
	   (SALARY * 12) 연봉,
	   BONUS 보너스,
	   (SALARY + (SALARY*NVL(BONUS,0)))*12 연봉총합
FROM EMPLOYEE;


-- DISTINCT
-- 해당하는 값이 컬럼에 여러개 존재할 경우 중복 제거하고 한개만 조회. (NULL도 포함)
SELECT DEPT_CODE
FROM EMPLOYEE;

SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;


-- [문제1]
-- DEPARTMENT 테이블을 참고하여
-- 부서가 '해외영업2부'인 부서의 부서 코드를 찾고
-- EMPLOYEE 테이블에서 해당 부서의 사원들 중
-- 급여가 200만원 보다 많이 받는 직원의
-- 사번, 사원명, 급여 조회
-- 1) '해외영업2부' 부서의 부서코드 확인
SELECT * FROM DEPARTMENT
WHERE DEPT_TITLE = '해외영업2부';
-- 부서코드 : D6

-- 내 풀이
--SELECT DEPT_TITLE 부서명, DEPT_ID 부서코드
--FROM DEPARTMENT
--WHERE DEPT_TITLE = '해외영업2부';

-- 2) 해당 부서의 정보를 EMPLOYEE에서 조회
SELECT EMP_ID 사번,
	   EMP_NAME 사원명,
	   SALARY 급여
FROM EMPLOYEE
WHERE SALARY >= 2000000
  AND DEPT_CODE = 'D6';

SELECT EMP_ID 사번,
	   EMP_NAME 사원명,
	   SALARY 급여
FROM EMPLOYEE
WHERE SALARY >= 2000000
  AND DEPT_CODE = (SELECT DEPT_ID FROM DEPARTMENT
				   WHERE DEPT_TITLE = '해외영업2부');


-- 연산자
-- 연결 연산자 '||'
-- 여러 컬럼의 결과나 리터럴(값)을 하나의 컬럼으로 묶을 때 사용하는 연산자
SELECT EMP_ID,
	   '을 가진 사원의 이름은 ',
	   EMP_NAME,
	   '입니다.'
FROM EMPLOYEE;

SELECT EMP_ID ||
	   '을 가진 사원의 이름은 ' ||
	   EMP_NAME ||
	   '입니다.'
FROM EMPLOYEE;


-- 비교 연산자
-- <, >, <=, >= : 크기를 비교하는 부등호
-- = : 같다
-- !=, ^=, <> : 같지 않다.
SELECT * FROM EMPLOYEE
--WHERE DEPT_CODE = 'D9';
--WHERE DEPT_CODE != 'D9';
--WHERE DEPT_CODE ^= 'D9';
WHERE DEPT_CODE <> 'D9';


-- EMPLOYEE 테이블에서
-- 급여가 350만원 이상, 550만원 이하인
-- 직원의 사번, 사원명, 부서코드, 직급코드, 급여를 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3500000
  AND SALARY <= 5500000;

-- 방금 작성한 코드를
-- BETWEEN A AND B
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 5500000;

-- 350미만, 550만원 초과인 직원 정보 조회할 경우
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY NOT BETWEEN 3500000 AND 5500000;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < 3500000
  AND SALARY > 5500000;


-- 	LIKE
-- 입력한 숫자, 문자 포함된 정보를 조회할 때
-- '_' : 임의의 한 문자
-- '%' : 몇자리 문자건 관계없이

-- EMPLOYEE 에서
-- 사원의 이름 가운데 '중'이 들어가는 사원 정보 조회
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_중_';

-- EMPLOYEE에서
-- 주민등록번호 기준 여성인 사원 정보만 조회
SELECT *
FROM EMPLOYEE
WHERE EMP_NO LIKE '______-2%';
-- 내 풀이 WHERE EMP_NO LIKE '%-2%';


-- 사원의 이메일 아이디가
-- 5글자 초과(6글자 이상)하는 사원의
-- 사원명, 사번, 이메일 정보 조회
SELECT EMP_NAME, EMP_ID, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '______%@%';

-- 사원 중 이메일 4째 자리가 '_'인 사원의 정보 조회하기
-- ESCAPE 문자를 선언
-- 특수 문자가 아닌 일반문자로 선언하여 사용할 수 있다.
SELECT EMP_NAME, EMP_ID, EMAIL
FROM EMPLOYEE
--WHERE EMAIL LIKE '____%@%';     -- 앞에 4글자 이상인 걸 탐색하는 것이 되버림.
WHERE EMAIL LIKE '___#_%@%' ESCAPE '#';   -- # 뒤에오는 문자는 무조건 일반 문자다! #이 아닌 다른 기호를 사용해도 상관없음.

-- EMPLOYEE 테이블에서 성이 '이'인 사원 정보 조회
SELECT * FROM EMPLOYEE
WHERE EMP_NAME LIKE '이%';


-- IN 연산자
-- IN (값1, 값2, 값3, ...)
-- 괄호 안에 있는 값들 중에 하나라도 일치하는 경우 해당 값 조회

-- 부서 코드가 D1인거나 D6인 직원 정보 조회
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE = 'D1'
   OR DEPT_CODE = 'D6';

SELECT * FROM EMPLOYEE
WHERE DEPT_CODE IN('D1', 'D6');

-- D1도 D6도 아닌 부서의 직원 조회
-- WHERE DEPT_CODE != 'D1' AND DEPT_CODE != 'D6';

SELECT * FROM EMPLOYEE
WHERE DEPT_CODE NOT IN('D1', 'D6');


-- 함수(FUNCTION)

-- LENGTH(), LENGTHB()
-- 문자열의 길이를 계산하는 함수
-- LENGTHB() : 몇 바이트인지.  한글은 오라클에서 3바이트이다.
SELECT LENGTH('Hello'), LENGTHB('Hello'),
	   LENGTH('이창진'), LENGTHB('이창진')
FROM DUAL;

-- DUAL : 임시 테이블, 가상 테이블, 테스트용
--		  리터럴을 활용한 계산 식 등을 테스트 하고자 할 때 사용 되는 임시 테이블

-- 오라클에서 한글은 3BYTE
-- LENGTHB를 통해 해당 문자열의 바이트 크기를 확인

 -- 각 로우별 이메일의 길이
SELECT EMP_NAME, EMAIL, LENGTH(EMAIL)
FROM EMPLOYEE;

-- INSTR : 주어진 값에서 원하는 문자가 몇 번째 인지 찾아 반환
-- 한 글자가 아니여도 됨. 없는 글자를 찾는 경우에는 0
SELECT INSTR('ABCDE', 'A'),
	   INSTR('ABCDE', 'C'),
	   INSTR('ABCDE', 'BC'),
	   INSTR('ABCDE', 'Z')
FROM DUAL;

SELECT EMAIL,
	   INSTR(EMAIL, '_')
FROM EMPLOYEE;

-- SUBSTR : 주어진 문자열에서 특정 부분만 꺼내오는 함수
-- 문자열의 몇 번째 부터 몇 개 가져올지.  / 몇 번째부터 끝까지.
-- SUBSTR(컬럼명|값, 시작위치, 갯수)
SELECT 'Hello Oracle',
	   SUBSTR('Hello Oracle', 1, 5),
	   SUBSTR('Hello Oracle', 3, 5),
	   SUBSTR('Hello Oracle', 7)
FROM DUAL;


-- [문제2]
-- EMPLOYEE 테이블에서
-- 사원들의 이름, 이메일 조회하는데
-- 이메일은 아이디 부분만 조회하기
-- 조회 결과 예시
-- 이창진  lee_cj
SELECT INSTR(EMAIL, '@')
FROM EMPLOYEE;

-- 함수 안에 함수 실행
SELECT EMP_NAME,
	   SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1)
FROM EMPLOYEE;


-- LPAD/RPAD
-- 빈칸을 지정한 문자로 채우는 함수
-- 20칸 공간을 확보하고 그 안에 이메일을 넣는다. 그리고 남는 왼쪽 공간을 지정한 문자로 채운다. 칸이 부족해 남는 공간이 없으면 채워지지 않음.
SELECT LPAD(EMAIL, 20, '#'),
	   RPAD(EMAIL, 20, '*')
FROM EMPLOYEE;

-- LTRIM/RTRIM
-- 현재 부여된 컬럼 값이나, 특정 값으로부터 특정 문자를 찾아 지워준다.
SELECT '     HELLO',
	   LTRIM('     HELLO     '),
	   RTRIM('     HELLO     ')
FROM DUAL;

-- 왼쪽에서부터 해당하는 값을 찾아 제거. 찾다가, 찾는 문자가 아닌 다른 문자가 나오면 종료
SELECT LTRIM('012345', '0'),
	   LTRIM('111123', '1'),
	   LTRIM('012345', '5'),    -- 찾는 문자가 아닌 문자를 먼저 찾기에 바로 종료
	   RTRIM('012345', '5')
FROM DUAL;

-- TRIM
-- 주어진 문자열에서 양 끝을 기준으로 특정 문자를 지워주는 함수.     양 끝을 기준으로 다른 문자를 만나면 끝나버림.
SELECT TRIM('     HELL O     ')
FROM DUAL;

-- TRIM에서 특정 문자를 지우기 위해 작성하는 방식은 다르다. 앞에 지울 문자를 먼저 넣고, ',' 대신에 FROM 사용.  문자는 한글자만 가능. 두글자X
SELECT TRIM('0' FROM '00001230000')
FROM DUAL;

-- LTRIM 처럼 왼쪽만
SELECT TRIM(LEADING '0' FROM '00001230000')
FROM DUAL;
-- RTRIM 처럼 오른쪽만
SELECT TRIM(TRAILING '0' FROM '00001230000')
FROM DUAL;
-- TRIM처럼 양쪽 다.
SELECT TRIM(BOTH '0' FROM '00001230000')
FROM DUAL;


-- LOWER / UPPER / INITCAP
-- 주어진 문자열을 소문자, 대문자, 앞글자만 대문자로 변경해주는 함수.

SELECT LOWER('NICE TO MEET YOU'),
	   UPPER('nice to meet you'),
	   INITCAP('nice to meet you')    -- 공백을 기준으로 단어마다 첫 글자를 대문자로 바꿔줌.
FROM DUAL;


-- CONCAT : 여러 문자열을 하나의 문자열로 합치는 함수.
SELECT CONCAT('오라클', '재밌어요:)')
FROM DUAL;

SELECT CONCAT(EMP_NAME, '님')
FROM EMPLOYEE;

-- 연결연산자를 이용해도 동일한 결과를 얻을 수 있다.
SELECT EMP_NAME||'님'
FROM EMPLOYEE;


-- REPLACE : 주어진 문자열에서 특정 문자를 변경
SELECT REPLACE('HELLO ORACLE', 'HELLO', 'BYE') -- 주어진 문자열에서 HELLO를 찾아 BYE로 변경.
FROM DUAL;

-- [문제3]
-- EMPLOYEE 테이블에서
-- 사원의 주민번호를 확인
-- 생년, 생월, 생일 각각 조회
-- 예시
-- 이름  |  생년  |  생월  |  생일
-- 이창진 |  00년 |  00월  | 00일
SELECT EMP_NO FROM EMPLOYEE;
-- 내 풀이
SELECT EMP_NAME 이름,
	   CONCAT(SUBSTR(EMP_NO, 1, 2), '년') 생년,
	   CONCAT(SUBSTR(EMP_NO, 3, 2), '월') 생월,
	   CONCAT(SUBSTR(EMP_NO, 5, 2), '일') 생일
FROM EMPLOYEE;
-- 강사님 풀이
SELECT EMP_NAME 이름,
	   SUBSTR(EMP_NO, 1, 2)||'년' "생년",
	   CONCAT(SUBSTR(EMP_NO, 3, 2), '월') "생월",
	   CONCAT(SUBSTR(EMP_NO, 5, 2), '일') "생일"
FROM EMPLOYEE;

-- SUBSTR 이용하면 날짜 데이터도 쪼갤 수 있다.
-- '25/06/02' -> 25 / 06 / 02
SELECT EMP_NAME,
	   HIRE_DATE,
	   SUBSTR(HIRE_DATE, 1, 2),
	   SUBSTR(HIRE_DATE, 4, 2)
FROM EMPLOYEE;


-- [문제4]
-- EMPLOYEE 테이블에서 현재 근무하는
-- 여성사원의 사번, 사원명, 직급코드를 조회
-- ENT_YN : 퇴사여부
-- WHERE 절에서도 함수 사용 가능
SELECT ENT_YN FROM EMPLOYEE;

-- 단일행 함수(Single Row Function) --    각각의 Row 하나마다 결과 값이 나옴.
SELECT EMP_ID 사번,
	   EMP_NAME 사원명,
	   JOB_CODE 직급코드,
	   ENT_YN 퇴사여부
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '2'
  AND ENT_YN = 'N';


-- 그룹 함수(Group Function) --   다수의 Row를 모아서 결과 도출
-- 다중행 함수
-- SUM(), AVG(), MAX(), MIN(), COUNT()
-- SUM(숫자가 기록된 컬럼) : 해당 컬럼들의 합계
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- AVG('') : 해당 컬럼들의 평균을 계산
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- MAX() : 해당 컬럼들의 값 중 최대값
SELECT MAX(SALARY)
FROM EMPLOYEE;

-- MIN() : 해당 컬럼들의 값 중 최소값
SELECT MIN(SALARY)
FROM EMPLOYEE;


-- EMPLOYEE 테이블에서
-- '해외영업1부'에 근무하는 모든 사원의
-- 평균 급여, 가장 높은 급여, 가장 낮은 급여, 급여합계
-- 조회하기

-- '해외영업1부'의 부서코드 확인
SELECT * FROM DEPARTMENT;
-- D5
-- 내 풀이
SELECT AVG(SALARY) "평균 급여",
	   MAX(SALARY) "가장 높은 급여",
	   MIN(SALARY) "가장 낮은 급여",
	   SUM(SALARY) "급여 합계"
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_ID FROM DEPARTMENT WHERE DEPT_ID = 'D5');
-- 강사님 풀이
SELECT AVG(SALARY), MAX(SALARY), MIN(SALARY), SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- SELECT 되었을 때, ROW 결과 값의 갯수가 다르기 때문에 오류
-- 단일행 함수와 그룹 함수는 함께 사용 불가.
--SELECT MAX(SALARY), EMP_NAME
--FROM EMPLOYEE;
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEE);
-- WHERE SALARY = (8000000);


-- COUNT(컬럼명) : 행의 개수
SELECT COUNT(EMP_ID) FROM EMPLOYEE;
SELECT COUNT(DEPT_CODE) FROM EMPLOYEE; -- NULL을 포함을 하는 경우 COUNT에서 제외
SELECT COUNT(*) FROM EMPLOYEE;  -- 주로 단순 ROW의 갯수를 세고 싶을 때 많이 사용.
SELECT COUNT(*),
	   COUNT(DEPT_CODE),
	   COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;

SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;


-- 날짜 함수

-- 현재 날짜, 시간 확인
SELECT SYSDATE, SYSTIMESTAMP, CURRENT_DATE, CURRENT_TIMESTAMP
FROM DUAL;

-- MONTHS_BETWEEN : 두 날짜 사이의 개월 수
SELECT HIRE_DATE "입사일",
	   MONTHS_BETWEEN(SYSDATE, HIRE_DATE) "입사 후 개월 수"
FROM EMPLOYEE;

-- ADD_MONTHS(날짜, 개월 수) : 날짜를 기준으로 개월 수를 더한다.  결과 값은 DATE 타입
SELECT ADD_MONTHS(SYSDATE, 3)
FROM DUAL;

-- EXTRACT(YEAR|MONTH|DAY FROM 날짜데이터) : 지정한 날부터 날짜 값을 추출하는 함수  숫자 타입으로 결과
SELECT EXTRACT(YEAR FROM SYSDATE),
	   EXTRACT(MONTH FROM SYSDATE)
FROM DUAL;

SELECT EXTRACT(MONTH FROM HIRE_DATE)
FROM EMPLOYEE;

--
SELECT HIRE_DATE,
	   TO_CHAR(HIRE_DATE, 'YYYY-MM-DD'),
	   TO_CHAR(HIRE_DATE, 'YYYY/MM/DD'),
	   TO_CHAR(HIRE_DATE, 'YY-MM-DD')
FROM EMPLOYEE;

-- TO_CHAR() : 날짜나 숫자 값을 문자 형태로 변환
-- 0 : 남은 자리는 0으로 표시.
-- 9 : 남은 자리는 표시하지 않는다.
SELECT SALARY,
	   TO_CHAR(SALARY, '000,000,000'),
	   TO_CHAR(SALARY, '999,999,999'),
	   TO_CHAR(SALARY, '999999999'),
	   TO_CHAR(SALARY, 'L000,000,000'),
	   TO_CHAR(SALARY, 'L999,999,999') -- L : 통화 기호 시스템의 지역 기준에 따라 원이 붙는다.  $ 붙이면 달러
FROM EMPLOYEE;

-- 20250603 숫자값 => 날짜값
-- '2025-06-03' => 
-- TO_DATE()
SELECT 20250603,
	   TO_DATE(20250603, 'YYYY/MM/DD'),   -- 숫자를 날짜로 출력한다. 포멧 형식은 따지지 않음. 기본 형식으로 출력.
	   '20250603',
	   -- 문자값을 토대로 날짜 값으로 바꿈.
	   TO_DATE('20250603', 'YYYYMMDD')
FROM DUAL;


-- JAVA의 3항 연산자
-- DECODE
-- 현재 근무하는 직원들의 성별을 남,여로 출력 해보자
-- DECODE(컬럼|데이터, 비교값1, 결과1, 비교값2, 결과2, ..., 기본값)
SELECT EMP_NAME 사원명,
	   EMP_NO,
	   -- 특정 값을 기준으로 그 값과 일치하는 결과값, 일치하지 않을 때의 결과값
	   DECODE(SUBSTR(EMP_NO, 8, 1), '2', '여', '남') 성별
FROM EMPLOYEE
--ORDER BY EMP_NAME; -- 이름 기준으로 오름차순 정렬
--ORDER BY EMP_NO;
--ORDER BY EMP_NAME ASC; -- 오름차순(ASC는 생략 가능)
--ORDER BY EMP_NAME DESC; -- 내림차순
--ORDER BY 2; -- 숫자 : SELECT 문에 작성된 순서.
--ORDER BY 3 DESC;
--ORDER BY 성별; -- 별칭
ORDER BY 사원명 DESC;


-- [문제5]
-- EMPLOYEE 테이블에서
-- 모든 직원의 사번, 사원명, 부서코드, 직급코드(JOB_CODE), 근무여부, 관리자 여부(MANAGER_ID)를 조회.
-- 만약 근무여부가 'Y' => 퇴사자
--				'N' => 근무자
-- 관리자사번(MANAGER_ID) 없으면(NULL인 경우) => 관리자
--						있으면 => 사원		
-- 라고 조회
-- DECODE 활용

SELECT * FROM EMPLOYEE;
SELECT EMP_ID 사번,
	   EMP_NAME 사원명,
	   DEPT_CODE 부서코드,
	   JOB_CODE 직급코드,
	   DECODE(ENT_YN, 'N', '근무자', '퇴사자') 근무여부,
	   DECODE(MANAGER_ID, NULL, '관리자', '사원') 관리자여부,
	   MANAGER_ID
FROM EMPLOYEE;

-- MANAGER_ID가 NULL 이라면 NVL을 통해 0으로 값을 변경하여 확인
SELECT DECODE(NVL(MANAGER_ID,0), 0, '관리자', '사원') 관리자여부
FROM EMPLOYEE;

-- NVL2(컬럼명|데이터, NULL이 아닐 경우 값, NULL일 경우 값)
SELECT EMP_ID 사번,
	   EMP_NAME 사원명,
	   BONUS 보너스,
--	   TO_CHAR(BONUS)
	   NVL(TO_CHAR(BONUS), 'X') "NVL 함수",
	   NVL2(BONUS, TO_CHAR(BONUS, '0.99'), 'X') "NVL2 함수"
FROM EMPLOYEE;


-- CASE 문
-- 자바의 SWITCH 문, IF 문과 흡사.

-- 사용법
-- CASE
--	WHEN 조건1 THEN 결과1
--	WHEN 조건2 THEN 결과2
--	ELSE 결과3
-- END

SELECT EMP_ID 사번,
	   EMP_NAME 사원명,
	   CASE
	   	WHEN ENT_YN = 'Y' THEN '퇴사자'
	   	ELSE '근무자'
	   END "근무 여부",
	   CASE
		-- NULL은 = 연산자로 불가. 대신 IS 사용
	   	WHEN MANAGER_ID IS NULL THEN '관리자'
	   	ELSE '사원'
	   END "관리자 여부"
FROM EMPLOYEE;

SELECT EMP_ID 사번,
	   EMP_NAME 사원명,
	   CASE
	   	WHEN ENT_YN = 'Y' THEN '퇴사자'
	   	ELSE '근무자'
	   END "근무 여부",
	   CASE
		-- NULL이 아닌 경우 IS NOT
	   	WHEN MANAGER_ID IS NOT NULL THEN '사원'
	   	ELSE '관리자'
	   END "관리자 여부"
FROM EMPLOYEE;


-- 연산자 우선순위
--0. ()
--1.산술
--2.연결
--3.비교
--4.IS NULL, IS NOT NULL, LIKE, IN, NOT IN
--5.BETWEEN A AND B
--6.NOT
--7.AND
--8.OR

-- 헷갈리면 괄호로 묶어서

-- DAY02 연습문제
--1.  직급이 'J2'이면서 200만원 이상 받는 직원 이거나,
--  직급이 'J7' 인 사원의 사번, 사원명, 직급코드, 급여
--  정보 조회하기
SELECT EMP_ID 사번,
	   EMP_NAME 사원명,
	   JOB_CODE 직급코드,
	   SALARY 급여
FROM EMPLOYEE
WHERE (JOB_CODE = 'J2' AND SALARY >= 2000000) OR JOB_CODE = 'J7';
	   



--2.  직급이 'J7' 이거나 'J2'이면서 급여를 200만원 이상
--  받는 직원의 사번, 사원명, 직급코드, 급여, 연봉을
--  조회하시오.
SELECT EMP_ID 사번, EMP_NAME 사원명, JOB_CODE 직급코드, SALARY 급여, SALARY*12 연봉
FROM EMPLOYEE
WHERE (JOB_CODE='J7' OR JOB_CODE='J2') AND SALARY>=2000000;


-- 3. EMPLOYEE 테이블에서
-- 모든 사원의 사번, 사원명, 이메일, 주민번호를
-- 조회하여 사원 목록표를 만들고자 한다.
-- 이 때, 이메일은 '@' 전 까지, 
-- 주민번호는 7번째 자리 이후 '*' 처리를 하여
-- 조회 하시오.
SELECT EMP_ID 사번, EMP_NAME 사원명, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) 이메일, RPAD(SUBSTR(EMP_NO,1,7),14,'*') 주민번호
FROM EMPLOYEE


--4. 직원명과 주민번호를 조회함
--  단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
--  예 : 홍길동 771120-1******
SELECT EMP_NAME 직원명, CONCAT(SUBSTR(EMP_NO, 1,8),'******') 주민번호
FROM EMPLOYEE;

SELECT EMP_NAME 직원명, SUBSTR(EMP_NO, 1,8)||'******' 주민번호
FROM EMPLOYEE;

--5. 직원명, 직급코드, 연봉(원) 조회
--  단, 연봉은 ￦57,000,000 으로 표시되게 함
--     연봉은 보너스포인트가 적용된 1년치 급여임
SELECT EMP_NAME 직원명, JOB_CODE 직급코드,
	   TO_CHAR((SALARY + (SALARY*NVL(BONUS,0)))*12, 'L999,999,999') "연봉(원)"
FROM EMPLOYEE;


--6. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의 
--   정보 조회함.
--   사번 사원명 부서코드 입사일
SELECT EMP_ID 사번, EMP_NAME 사원명, DEPT_CODE 부서코드, HIRE_DATE 입사일
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5', 'D9')
  AND SUBSTR(HIRE_DATE,1,2) = 04;

SELECT SUBSTR(HIRE_DATE, 4, 2)
FROM EMPLOYEE;

--7. 직원명, 부서코드, 생년월일, 나이(만) 조회
--   단, 생년월일은 주민번호에서 추출해서, 
--   ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
--   나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
--  (이상한 날짜 값이 들어간 사원들은 WHERE 조건절을 이용하여 제외)
SELECT EMP_NAME 직원명, DEPT_CODE 부서코드,
	   SUBSTR(EMP_NO,1,2)||'년' ||
	   SUBSTR(EMP_NO,3,2)||'월' ||
	   SUBSTR(EMP_NO,5,2)||'일'	생년월일,
	   EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,6), 'RRMMDD')) 나이
FROM EMPLOYEE
WHERE EMP_ID NOT IN(200, 201, 214);

SELECT EMP_NO, EMP_ID
FROM EMPLOYEE;

--8. 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.
--  아래의 년도에 입사한 인원수를 조회하시오.
--  => to_char, decode, sum 사용
--
--	-------------------------------------------------------------
--	전체직원수   2001년   2002년   2003년   2004년
--	-------------------------------------------------------------
SELECT COUNT(*) 전체직원수,
	   COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2001',1)) "2001년",
	   COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2002',1)) "2002년",
	   COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2003',1)) "2003년",
	   COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2004',1)) "2004년"
FROM EMPLOYEE;

--9.  부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오.
--   단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회함
--  => case 사용
--   부서코드 기준 오름차순 정렬함.
SELECT EMP_NAME 사원명, DEPT_CODE 부서코드,
	   CASE
	   	WHEN DEPT_CODE = 'D5' THEN '총무부'
	   	WHEN DEPT_CODE = 'D6' THEN '기획부'
	   	WHEN DEPT_CODE = 'D9' THEN '영업부'
	   END 부서명
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5', 'D6', 'D9')
ORDER BY 2;