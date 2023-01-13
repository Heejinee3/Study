-- mysoho.sql
-- 모바일 쇼핑몰 DB 스키마(테이블) 설계
 
-- 1. member: 회원가입, 로그인, 비번찾기, 아이디 찾기, 적립금, 쿠폰
--  	no INT(10): PK
--		member_id: 아이디
--		member_pw: 비번
--		joindate: 회원가입일
--		회원가입 화면 참조
--		point:
--		coupon:
-- 2. item: 상품 목록- 베스트, 최신상품
-- 3. cart: 장바구니 - - 비회원, 회원
--    cart_no
--		member_id
--    item_no (상품테이블의 PK)
-- 4. order: 주문목록 (결제정보, 묶음주문 최대 5개)
--    주문 상태 코드
--    주문완료 -> 결제 대기 -> 결제 완료 -> 배송대기 -> 배송중 -> 배송완료
-- 주문취소 (배송중일때는 안됨)
-- 5. qna: 묻고 답하기
-- 6. notice: 공지사항
-- 7. review: 상품후기

CREATE DATABASE IF NOT EXISTS mysoho;
USE mysoho;
mysoho
-- --------------------account--------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
   account_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT -- 회원/비회원/탈퇴회원 key
);

INSERT INTO account 
	VALUES (NULL); 
SELECT * FROM account;

-- --------------------member-------------------- 
DROP TABLE IF EXISTS member;
CREATE TABLE member(
   id VARCHAR(20) PRIMARY KEY,       -- 아이디
   account_no INT UNSIGNED NOT NULL, -- account table과 연결
   pw VARCHAR(30) NOT NULL,          -- 비밀번호
   `name` VARCHAR(20) NOT NULL,      -- 이름
   email VARCHAR(255) NOT NULL,      -- 이메일
   contact VARCHAR(13) NOT NULL,     -- 전화번호
   `point` INT UNSIGNED NOT NULL,    -- 적립금
   signup_date DATETIME NOT NULL,    -- 가입 날짜
   address VARCHAR(255),             -- 주소
   FOREIGN KEY(account_no)
   	REFERENCES `account`(account_no)
      ON UPDATE CASCADE
      ON DELETE CASCADE
);

INSERT INTO member 
	VALUES ('id',1,'pw','name','email@gmail.com','010-0000-0000',1000,NOW(),"서울특별시 마포구 신촌로 94 그랜드플라자 7층"); 
SELECT * FROM member;

-- --------------------withdrawal_member--------------------
DROP TABLE IF EXISTS withdrawal_member;
CREATE TABLE withdrawal_member(
    id VARCHAR(20) PRIMARY KEY,        -- 아이디
    account_no INT UNSIGNED NOT NULL,  -- account table과 연결
    name VARCHAR(20) NOT NULL,         -- 이름
    email VARCHAR(255) NOT NULL,       -- 이메일
    contact VARCHAR(13) NOT NULL,      -- 전화번호
    point INT UNSIGNED NOT NULL,       -- 적립금
    signup_date DATETIME NOT NULL,     -- 가입 날짜
    withdrawal_date DATETIME NOT NULL, -- 탈퇴 날짜
    address VARCHAR(255),              -- 주소
   FOREIGN KEY(account_no)
   	REFERENCES `account`(account_no)
      ON UPDATE CASCADE
      ON DELETE CASCADE
);

INSERT INTO withdrawal_member 
	VALUES ('id',1,'pw','name','email@gmail.com','010-0000-0000',1000,NOW(),"서울특별시 마포구 신촌로 94 그랜드플라자 7층"); 
SELECT * FROM withdrawal_member;

-- --------------------ITEM--------------------
DROP TABLE IF EXISTS item;
CREATE TABLE item(
	item_no INT PRIMARY KEY AUTO_INCREMENT,
	item_name VARCHAR(20) NOT NULL,
	item_class VARCHAR(9) NOT NULL,
	item_tagprice INT NOT NULL,
	item_discountprice INT NOT NULL,
	item_image TEXT NOT NULL,
	item_option TEXT,
	item_details TEXT
);
INSERT INTO item 
	VALUES (NULL,'린넨 ops 베이지','bottom',49000,44100,'image1.png,image2.png',"{'사이즈':['S','M','L'], '색상':['빨강','파랑']}",'상품정보1.txt,상품정보2.png'); 
SELECT * FROM item;

-- --------------------QNA--------------------
DROP TABLE IF EXISTS qna;
CREATE TABLE qna(
	qna_no INT PRIMARY KEY AUTO_INCREMENT,
	qna_class TINYINT NOT NULL, -- 상품문의,배송문의,교환문의,반품문의,환불문의,기타문의
	qna_pw VARCHAR(30) NOT NULL,
	qna_title VARCHAR(20) NOT NULL,
	qna_content TEXT(1000) NOT NULL,
	member_id VARCHAR(20) NOT NULL,
	qna_secret TINYINT NOT NULL,
	qna_date DATETIME NOT NULL,
	FOREIGN KEY(member_id)
		REFERENCES member(member_id)
		ON UPDATE CASCADE 
		ON DELETE CASCADE
);

INSERT INTO qna 
	VALUES (NULL,0,'password','title','content','id',2, NOW()); 
SELECT * FROM qna;
