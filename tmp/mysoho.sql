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
-- --------------------member_all--------------------
DROP TABLE IF EXISTS member_all;
CREATE TABLE member_all(
   member_all_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT -- 회원/비회원/탈퇴회원 key
   
);

INSERT INTO member_all
	VALUES (NULL); 
SELECT * FROM member_all;

-- --------------------member-------------------- 
DROP TABLE IF EXISTS member;
CREATE TABLE member(
   id VARCHAR(20) PRIMARY KEY,          -- 아이디
   member_all_no INT UNSIGNED NOT NULL, -- member_all table과 연결
   pw VARCHAR(30) NOT NULL,             -- 비밀번호
   `name` VARCHAR(20) NOT NULL,         -- 이름
   email VARCHAR(255) NOT NULL,         -- 이메일
   contact VARCHAR(13) NOT NULL,        -- 전화번호
   `point` INT UNSIGNED NOT NULL,       -- 적립금
   signup_date DATETIME NOT NULL,       -- 가입 날짜
   withdrawal_date DATETIME,            -- 탈퇴 날짜
   withdrawal TINYINT NOT NULL,         -- 탈퇴 여부(0: 회원, 1: 탈퇴 회원)  
   address VARCHAR(255),                -- 주소
   FOREIGN KEY(member_all_no)
   	REFERENCES member_all(member_all_no)
      ON UPDATE CASCADE						 -- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE						 -- ------------------ 임시, 삭제하기 ------------------ 
);

INSERT INTO member 
	VALUES ('id',1,'pw','name','email@gmail.com','010-0000-0000',0,NOW(),NULL,0,"서울특별시 마포구 신촌로 94 그랜드플라자 7층"); 
SELECT * FROM member;

-- --------------------item--------------------
DROP TABLE IF EXISTS item;
CREATE TABLE item(
   item_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- 상품 key
   `name` VARCHAR(20) NOT NULL,                     -- 이름
   class TINYINT UNSIGNED NOT NULL,                 -- 0:TOP, 1:BOTTOM, 2: ONE-PIECE, 3: ACC
   tag_price INT UNSIGNED NOT NULL,                 -- 할인 전 가격
   discount_price INT UNSIGNED NOT NULL,            -- 할인 후 가격
   `option` TEXT,                                   -- 옵션
   `count` INT UNSIGNED NOT NULL                    -- 수량
);
INSERT INTO item 
	VALUES (NULL,'린넨 ops 베이지',1,49000,44100,"{'사이즈':['S','M','L'], '색상':['빨강','파랑']}",3); 
SELECT * FROM item;

-- --------------------item_detail--------------------
DROP TABLE IF EXISTS item_detail;
CREATE TABLE item_detail(
   item_detail_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- item detail 글 file key
   item_no INT UNSIGNED NOT NULL,                			  -- item table과 연결
   file_path VARCHAR(255) NOT NULL,                        -- 파일 경로
   FOREIGN KEY(item_no)
   	REFERENCES item(item_no)
      ON UPDATE CASCADE   											  -- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE												  -- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO item_detail 
	VALUES (NULL,1,"상세 설명1.png"); 
SELECT * FROM item_detail;

-- --------------------item_image--------------------
DROP TABLE IF EXISTS item_image;
CREATE TABLE item_image(
   item_image_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- 상품 이미지 key
   item_no INT UNSIGNED NOT NULL,                         -- item table과 연결
   file_path VARCHAR(255) NOT NULL,                       -- 이미지 파일 경로
   FOREIGN KEY(item_no)
   	REFERENCES item(item_no)
      ON UPDATE CASCADE												 -- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE                                   -- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO item_image 
	VALUES (NULL,1,"img1.png"); 
SELECT * FROM item_image;

-- --------------------cart--------------------
DROP TABLE IF EXISTS cart;
CREATE TABLE cart(
   cart_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- 장바구니 안 각 상품의 key
   item_no INT UNSIGNED NOT NULL, 					    -- item table과 연결
   member_all_no INT UNSIGNED NOT NULL, 			    -- member_all table과 연결
   `option` TEXT,                                   -- 옵션
   `count` INT UNSIGNED NOT NULL,                   -- 수량
   FOREIGN KEY(item_no)
   	REFERENCES item(item_no)
      ON UPDATE CASCADE		                         -- ------------------ 임시, 삭제하기 ------------------ 			
      ON DELETE CASCADE, 									 -- ------------------ 임시, 삭제하기 ------------------ 
   FOREIGN KEY(member_all_no)
   	REFERENCES member_all(member_all_no)
      ON UPDATE CASCADE 									 -- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE									    -- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO cart 
	VALUES (NULL,1,1,"S,빨강",3); 
SELECT * FROM cart;

-- --------------------coupon--------------------

DROP TABLE IF EXISTS coupon;
CREATE TABLE coupon(
   coupon_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- 쿠폰 key
   member_all_no INT UNSIGNED NOT NULL, 					-- member_all table 연결
   start_date DATETIME NOT NULL,                      -- 시작 날짜
   end_date DATETIME NOT NULL,                        -- 종료 날짜
   `use` TINYINT NOT NULL,                            -- 사용 여부 (0: 사용x, 1: 사용)
   rate TINYINT NOT NULL,                             -- 할인율(%)
   FOREIGN KEY(member_all_no)
   	REFERENCES member_all(member_all_no)
      ON UPDATE CASCADE											-- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE 										-- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO coupon 
	VALUES (NULL,1,'2022-02-02','2023-03-03',0,9); 
SELECT * FROM coupon;

-- --------------------promotion--------------------

DROP TABLE IF EXISTS promotion;
CREATE TABLE promotion(
   promotion_code VARCHAR(20) PRIMARY KEY, -- 프로모션 할인코드 key
   start_date DATETIME NOT NULL,           -- 시작 날짜
   end_date DATETIME NOT NULL,             -- 종료 날짜
   rate TINYINT NOT NULL                   -- 할인율(%)
);
INSERT INTO promotion 
	VALUES ("3GEL455",'2022-02-02','2023-03-03',9); 
SELECT * FROM promotion;

-- --------------------order--------------------

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`(
   order_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, 		   -- 주문 key
   member_all_no INT UNSIGNED NOT NULL,              		   -- member_all table과 연결
   orderer_name VARCHAR(20) NOT NULL,              		   -- 주문자 이름
   orderer_contact VARCHAR(13) NOT NULL,         			   -- 주문자 전화번호
   receiver_name VARCHAR(20)NOT NULL,              	  	   -- 수령자 이름
   receiver_contact VARCHAR(13)NOT NULL,             		   -- 수령자 전화번호
   receiver_address VARCHAR(255) NOT NULL,           		   -- 수령자 주소
   message VARCHAR(50),                                     -- 메세지
   default_shipping_fee INT UNSIGNED NOT NULL DEFAULT 3000, -- 기본 배송비
   region_shipping_fee INT UNSIGNED NOT NULL,               -- 지역 배송비
   item_discount INT UNSIGNED NOT NULL DEFAULT 0,           -- 상품 할인
   coupon_no INT UNSIGNED,  								         -- 쿠폰
   promotion_code VARCHAR(20),                              -- 프로모션 할인코드
   `point` INT UNSIGNED NOT NULL DEFAULT 0,                 -- 적립금
   final_payment INT UNSIGNED NOT NULL,                     -- 최종 결제금액
   refund INT UNSIGNED NOT NULL DEFAULT 0,                  -- 환불 금액
   repayment INT UNSIGNED NOT NULL DEFAULT 0,               -- 재결제 금액
   FOREIGN KEY(member_all_no)
   	REFERENCES member_all(member_all_no)
      ON UPDATE CASCADE  												-- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE, 												-- ------------------ 임시, 삭제하기 ------------------ 
   FOREIGN KEY(coupon_no)
   	REFERENCES coupon(coupon_no)
      ON UPDATE SET NULL 												-- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE SET NULL, 												-- ------------------ 임시, 삭제하기 ------------------ 
   FOREIGN KEY(promotion_code)
   	REFERENCES promotion(promotion_code)
      ON UPDATE SET NULL 												-- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE SET NULL 												-- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO `order` 
	VALUES (NULL,1,"홍길동","010-0000-0000","홍길동","010-0000-0000","서울특별시 마포구 신촌로 94 그랜드플라자 7층","배송 전 연락 바랍니다.",DEFAULT,0,DEFAULT,NULL,NULL,DEFAULT, 30000,DEFAULT,DEFAULT); 
SELECT * FROM `order`;

-- --------------------order_payment--------------------

DROP TABLE IF EXISTS order_payment;
CREATE TABLE order_payment(
   order_payment_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- 결제 key
   order_no INT UNSIGNED NOT NULL,                           -- order table과 연결
   `type` TINYINT NOT NULL,                                  -- 결제 유형(0:삼성페이, 1: 휴대폰결제, 2:무통장입금, 3: 환불) 
   `date` DATETIME NOT NULL,                                 -- 결제 날짜
   bank VARCHAR(20) NOT NULL,                                -- 은행
   account_number VARCHAR(20) NOT NULL,                      -- 계좌번호
   `name` VARCHAR(20) NOT NULL,                              -- 입금자명
   amount INT NOT NULL,                                      -- 금액
   FOREIGN KEY(order_no)
   	REFERENCES `order`(order_no)
      ON UPDATE CASCADE												    -- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE 												 -- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO order_payment 
	VALUES (NULL,1,2,"2022-02-02","기업은행","01068593030119","홍길동","30000"); 
SELECT * FROM order_payment;

-- --------------------order_status--------------------

DROP TABLE IF EXISTS order_status;
CREATE TABLE order_status(
	order_status_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- 결제 상태 key
	order_no INT UNSIGNED NOT NULL,                          -- order table과 연결
	order_status TINYINT UNSIGNED NOT NULL,                  -- 0: 미입금/주문완료, 1: 배송대기, 2: 배송중, 3: 배송/처리완료, 4: 취소, 5:반품, 6:교환
	FOREIGN KEY(order_no)
   	REFERENCES `order`(order_no)
      ON UPDATE CASCADE												   -- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE 												-- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO order_status 
	VALUES (NULL,1,0); 
SELECT * FROM order_status;

-- --------------------order_item--------------------

DROP TABLE IF EXISTS order_item;
CREATE TABLE order_item(
   order_item_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- 주문 상품 key
   order_no INT UNSIGNED NOT NULL,  							 -- order table과 연결
   item_no INT UNSIGNED NOT NULL, 								 -- item table과 연결
   `option` TEXT,                                         -- 옵션
   `count` INT UNSIGNED NOT NULL,                         -- 수량  
   FOREIGN KEY(order_no)
   	REFERENCES `order`(order_no)
      ON UPDATE CASCADE												 -- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE, 										    -- ------------------ 임시, 삭제하기 ------------------ 
	FOREIGN KEY(item_no)
   	REFERENCES item(item_no)
      ON UPDATE CASCADE								    			 -- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE 											 -- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO order_item 
	VALUES (NULL,1,1,"S,빨강",3); 
SELECT * FROM order_item;
  
-- --------------------review--------------------

DROP TABLE IF EXISTS review;
CREATE TABLE review(
   review_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- 리뷰 key
   id VARCHAR(20) NOT NULL, 					            -- member table과 연결
   order_item_no INT UNSIGNED NOT NULL,      			-- order_item table과 연결
   rating TINYINT UNSIGNED NOT NULL,                  -- 평점 (1~5)
	price TINYINT UNSIGNED NOT NULL,                   -- 가격 (1~5)
   design TINYINT UNSIGNED NOT NULL,                  -- 디자인 (1~5)
   material TINYINT UNSIGNED NOT NULL,                -- 소재 (1~5)
   weight TINYINT UNSIGNED NOT NULL,                  -- 무게 (1~5)
   color TINYINT UNSIGNED NOT NULL,                   -- 색 (1~5)
   content TEXT(1000) NOT NULL,                       -- 내용
   `date` DATETIME NOT NULL,                          -- 날짜
	FOREIGN KEY(id)
   	REFERENCES `member`(id)
      ON UPDATE CASCADE								    		-- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE, 										-- ------------------ 임시, 삭제하기 ------------------ 
	FOREIGN KEY(order_item_no)
   	REFERENCES order_item(order_item_no)
      ON UPDATE CASCADE								    		-- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE 										-- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO review 
	VALUES (NULL,"id",1,5,5,5,5,5,5,"good","2022-02-02"); 
SELECT * FROM review;

-- --------------------review_image--------------------

DROP TABLE IF EXISTS review_image;
CREATE TABLE review_image(
   review_image_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- 리뷰 이미지 key
   review_no INT UNSIGNED NOT NULL, 							   -- review table과 연결
   image_path VARCHAR(255) NOT NULL,                        -- 이미지 파일 경로
	FOREIGN KEY(review_no)
   	REFERENCES review(review_no)
      ON UPDATE CASCADE								    		      -- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE 										      -- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO review_image 
	VALUES (NULL,1,"img1.png"); 
SELECT * FROM review_image;

-- --------------------qna--------------------

DROP TABLE IF EXISTS qna;
CREATE TABLE qna(
   qna_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- QnA key
   class TINYINT UNSIGNED NOT NULL,                -- 0: 상품문의 1: 배송문의 2: 교환문의 3: 반품문의 4: 환불문의 5: 기타문의
   pw VARCHAR(30),                                 -- 글 비밀번호
   title VARCHAR(20) NOT NULL,                     -- 제목
   content TEXT(1000) NOT NULL,                    -- 내용
	id VARCHAR(20) NOT NULL, 					         -- member table과 연결
   secret TINYINT UNSIGNED NOT NULL,               -- 비밀글
   `date` DATETIME NOT NULL,                       -- 날짜
   answer TEXT,                                    -- 답변
	FOREIGN KEY(id)
   	REFERENCES `member`(id)
      ON UPDATE CASCADE								      -- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE 									-- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO qna 
	VALUES (NULL,0,NULL,"제목입니다.","내용입니다.","id",1,"2022-02-02","답변입니다."); 
SELECT * FROM qna;

-- --------------------notice--------------------

DROP TABLE IF EXISTS notice;
CREATE TABLE notice(
   notice_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- 공지글 key
   title VARCHAR(20) NOT NULL,                        -- 제목
   `date` DATETIME NOT NULL                           -- 날짜
);
INSERT INTO notice 
	VALUES (NULL,"제목입니다.","2022-02-02"); 
SELECT * FROM notice;

-- --------------------notice_content--------------------

DROP TABLE IF EXISTS notice_content;
CREATE TABLE notice_content(
   notice_content_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- 공지글 내용 file key
   notice_no INT UNSIGNED NOT NULL, 								  -- notice table과 연결
   file_path VARCHAR(255) NOT NULL,                           -- 파일 경로
   FOREIGN KEY(notice_no)
   	REFERENCES notice(notice_no)
      ON UPDATE CASCADE								      			  -- ------------------ 임시, 삭제하기 ------------------ 
      ON DELETE CASCADE 											     -- ------------------ 임시, 삭제하기 ------------------ 
);
INSERT INTO notice_content 
	VALUES (NULL,1,"img1.png"); 
SELECT * FROM notice_content;

