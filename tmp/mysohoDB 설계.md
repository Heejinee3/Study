database: mysoho

# member(coupon)

member_id VARCHAR(20) PRIMARY KEY
member_pw VARCHAR(30) NOT NULL
member_name VARCHAR(20) NOT NULL
member_email VARCHAR(255) NOT NULL
member_contact VARCHAR(13) NOT NULL
member_coupon
member_point INT NOT NULL
member_signup_date DATETIME NOT NULL
member_address VARCHAR(255)

# item

item_no INT PRIMARY KEY AUTO_INCREMENT
item_name VARCHAR(20) NOT NULL
item_class VARCHAR(9) NOT NULL
item_tagprice INT NOT NULL
item_discountprice INT NOT NULL
item_image1 VARCHAR(255) NOT NULL
item_image2 VARCHAR(255)
item_image3 VARCHAR(255)
item_image4 VARCHAR(255)
item_image5 VARCHAR(255)
item_details BLOB

# cart

cart_no:
member_id와 비회원 id 병합
제품id
개수

# order

order_no: INT PRIMARY KEY AUTO_INCREMENT
member_id: VARCHAR(20) FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL
order_status: 미입금/주문완료 배송대기 배송중 배송/처리완료 취소/반품/교환
주문한사람 이름
주문한사람 번호
수령자 이름
수령자 번호
수령자 주소
기타: 배송전연락바랍니다./부재시 휴대폰/부재시 경비실/집앞/택배함/기타입력(text)
적립금사용
결제방법

# coupon

# 상품 후기

member_id

# 상품 문의

member_id

# 비회원

# QNA

qna_no : INT PRIMARY KEY, AUTO_INCREMENT
qna_class : TINYINT(5) // 상품문의, 배송문의, 교환문의, 반품문의,환불문의,기타문의
qna_pw : VARCHAR(30) NOT NULL
qna_title : VARCHAR(20) NOT NULL
qna_content: TEXT(1000) NOT NULL
member_id : VARCHAR(20) FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL
qna_secret : TINYINT(1) NOT NULL
qna_date : DATETIME NOT NULL

# notice

상품 정보 고시?
