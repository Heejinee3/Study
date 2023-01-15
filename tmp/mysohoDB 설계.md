database: mysoho

# member_all

    account_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT -- 회원/비회원/탈퇴회원 key

# member

    id VARCHAR(20) PRIMARY KEY                                                       -- 아이디
    account_no INT UNSIGNED FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL -- account table과 연결
    pw VARCHAR(30) NOT NULL                                                          -- 비밀번호
    name VARCHAR(20) NOT NULL                                                        -- 이름
    email VARCHAR(255) NOT NULL                                                      -- 이메일
    contact VARCHAR(13) NOT NULL                                                     -- 전화번호
    point INT UNSIGNED NOT NULL                                                      -- 적립금
    signup_date DATETIME NOT NULL                                                    -- 가입 날짜
    address VARCHAR(255)                                                             -- 주소

# item

    item_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT -- 상품 key
    name VARCHAR(20) NOT NULL                       -- 이름
    class TINYINT UNSIGNED NOT NULL                 -- 0:TOP, 1:BOTTOM, 2: ONE-PIECE, 3: ACC
    tag_price INT UNSIGNED NOT NULL                 -- 할인 전 가격
    discount_price INT UNSIGNED NOT NULL            -- 할인 후 가격
    option TEXT                                     -- 옵션
    count INT UNSIGNED NOT NULL                     -- 수량

# item_detail

    item_detail_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                        -- item detail 글 file key
    item_no INT UNSIGNED FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL -- item table과 연결
    file_path VARCHAR(255) NOT NULL                                               -- 파일 경로

# item_image

    item_image_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                         -- 상품 이미지 key
    item_no INT UNSIGNED FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL -- item table과 연결
    file_path VARCHAR(255) NOT NULL                                               -- 이미지 파일 경로

# cart

    cart_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                                   -- 장바구니 key
    account_no INT UNSIGNED FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL  -- account table과 연결

# cart_item

    cart_item_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                          -- 장바구니 안 각 상품의 key
    item_no INT UNSIGNED FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL -- item table과 연결
    cart_no INT UNSIGNED FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL -- cart table과 연결
    option TEXT                                                                   -- 옵션
    count INT UNSIGNED NOT NULL                                                   -- 수량

# order

    order_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                                   -- 주문 key
    account_no INT UNSIGNED FOREIGN KEY ON UPDATE SET NULL ON DELETE SET NULL NOT NULL -- account table과 연결
    status TINYINT UNSIGNED                                                            -- 0: 미입금/주문완료 1: 배송대기 2: 배송중 3: 배송/처리완료 4: 취소/반품/교환
    orderer_name VARCHAR(20) NOT NULL                                                  -- 주문자 이름
    orderer_contact VARCHAR(13) NOT NULL                                               -- 주문자 전화번호
    receiver_name VARCHAR(20)NOT NULL                                                  -- 수령자 이름
    receiver_contact VARCHAR(13)NOT NULL                                               -- 수령자 전화번호
    receiver_address VARCHAR(255) NOT NULL                                             -- 수령자 주소
    message VARCHAR(50)                                                                -- 메세지
    default_shipping_fee INT UNSIGNED NOT NULL DEFAULT 3000                            -- 기본 배송비
    region_shipping_fee INT UNSIGNED NOT NULL                                          -- 지역 배송비
    item_discount INT UNSIGNED DEFAULT 0                                               -- 상품 할인
    coupon_no INT UNSIGNED FOREIGN KEY ON UPDATE SET NULL ON DELETE SET NULL NOT NULL  -- 쿠폰
    discount_code INT UNSIGNED NOT NULL DEFAULT 0                                      -- 해야지!!!!!!!!!!!!프로모션 할인코드
    point INT UNSIGNED NOT NULL DEFAULT 0                                              -- 적립금
    final_payment INT UNSIGNED NOT NULL                                                -- 최종 결제금액
    refund INT UNSIGNED NOT NULL DEFAULT 0                                             -- 환불 금액
    repayment INT UNSIGNED NOT NULL DEFAULT 0                                          -- 재결제 금액

# order_payment

    order_payment_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                       -- 결제 key
    order_no INT UNSIGNED FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL -- order table과 연결
    type VARCHAR(20) NOT NULL                                                      -- 결제 유형
    date DATETIME NOT NULL                                                         -- 결제 날짜
    bank VARCHAR(20) NOT NULL                                                      -- 입금은행
    name VARCHAR(20) NOT NULL                                                      -- 입금자
    amount INT NOT NULL                                                            -- 입금금액

# order_item

    order_item_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                           -- 주문 상품 key
    order_no INT UNSIGNED FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL  -- order table과 연결
    item_no INT UNSIGNED FOREIGN KEY ON UPDATE SET NULL ON DELETE SET NULL NOT NULL -- item table과 연결
    option TEXT                                                                     -- 옵션
    count INT UNSIGNED NOT NULL                                                     -- 수량

# coupon

    coupon_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                                -- 쿠폰 key
    account_no INT UNSIGNED FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL -- account table 연결
    start_date DATETIME NOT NULL                                                     -- 시작 날짜
    end_date DATETIME NOT NULL                                                       -- 종료 날짜
    use TINYINT NOT NULL                                                             -- 사용 여부
    rate TINYINT NOT NULL                                                            -- 할인율

# review

    review_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                                 -- 리뷰 key
    account_no VARCHAR(20) FOREIGN KEY ON UPDATE SET NULL ON DELETE SET NULL NOT NULL -- account table과 연결
    order_item_no INT FOREIGN KEY ON UPDATE SET NULL ON DELETE SET NULL NOT NULL      -- order_item table과 연결
    rating TINYINT UNSIGNED NOT NULL                                                  -- 평점 (1~5)
    price TINYINT UNSIGNED NOT NULL                                                   -- 가격 (1~5)
    design TINYINT UNSIGNED NOT NULL                                                  -- 디자인 (1~5)
    material TINYINT UNSIGNED NOT NULL                                                -- 소재 (1~5)
    weight TINYINT UNSIGNED NOT NULL                                                  -- 무게 (1~5)
    color TINYINT UNSIGNED NOT NULL                                                   -- 색 (1~5)
    content TEXT(1000) NOT NULL                                                       -- 내용
    date DATETIME NOT NULL                                                            -- 날짜

# review_image

    review_image_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                         -- 리뷰 이미지 key
    review_no INT UNSIGNED FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL -- review table과 연결
    image_path VARCHAR(255) NOT NULL                                                -- 이미지 파일 경로

# qna

    qna_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                                     -- QnA key
    class TINYINT UNSIGNED NOT NULL                                                    -- 0: 상품문의 1: 배송문의 2: 교환문의 3: 반품문의 4: 환불문의 5: 기타문의
    pw VARCHAR(30)                                                                     -- 글 비밀번호
    title VARCHAR(20) NOT NULL                                                         -- 제목
    content TEXT(1000) NOT NULL                                                        -- 내용
    account_no INT UNSIGNED FOREIGN KEY ON UPDATE SET NULL ON DELETE SET NULL NOT NULL -- account table과 연결
    secret TINYINT UNSIGNED NOT NULL                                                   -- 비밀글
    date DATETIME NOT NULL                                                             -- 날짜
    answer TEXT                                                                        -- 답변

# notice

    notice_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                                  -- 공지글 key
    title VARCHAR(20) NOT NULL                                                         -- 제목
    date DATETIME NOT NULL                                                             -- 날짜

# notice_content

    notice_content_no INT UNSIGNED PRIMARY KEY AUTO_INCREMENT                       -- 공지글 내용 file key
    notice_no INT UNSIGNED FOREIGN KEY ON UPDATE CASCADE ON DELETE CASCADE NOT NULL -- notice table과 연결
    file_path NOT NULL                                                              -- 파일 경로
