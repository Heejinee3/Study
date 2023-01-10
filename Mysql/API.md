-- 한줄 코멘트
/_
여러줄
코멘트
_/

# Database Create

    CREATE DATABASE market_db;

# Database Drop

    DROP DATABASE IF EXISTS market_db;

# Database Use

    USE market_db;

# Table Create

    CREATE TABLE buy -- 구매 테이블
    (  num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
        mem_id  	CHAR(8) NOT NULL, -- 아이디(FK)
        prod_name 	CHAR(6) NOT NULL, --  제품이름
        group_name 	CHAR(4)  , -- 분류
        price     	INT  NOT NULL, -- 가격
        amount    	SMALLINT  NOT NULL, -- 수량
        FOREIGN KEY (mem_id) REFERENCES member(mem_id)
    );

# Table Drop

    DROP TABLE `member`;

# Data Insert

    INSERT INTO member (memberno, id, `name`) VALUES (1, 'hong', '홍길동');

# Data Update

    UPDATE member SET id='lee', `name`='미스터리' WHERE memberno=1;

# Data Delete

    DELETE FROM member WHERE memberno=1;

# Select

    SELECT <column1>, <column2>, ...
      FROM <table>
      WHERE <condition>
      ORDER BY <column1> <ASC | DESC>, <column2> <ASC | DESC> ...
      LIMIT <offset> <number>;

# WHERE Operator

    >, <,  >=, <=, !=, <>
    AND, OR
    BETWEEN <number> AND <number>
    IN(<element1>, <element2>, ...)
    LIKE                            // _(한 문자), %(여러 문자) 사용하기

DISTINCT, COUNT()
set @rownum:=0;
@rownum:=@rownum+1 rownum
