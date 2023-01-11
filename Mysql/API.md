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

    USE <database>;

# Table Create/ Drop

    CREATE TABLE buy -- 구매 테이블
    (  num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
        mem_id  	CHAR(8) NOT NULL, -- 아이디(FK)
        prod_name 	CHAR(6) NOT NULL, --  제품이름
        group_name 	CHAR(4)  , -- 분류
        price     	INT  NOT NULL, -- 가격
        amount    	SMALLINT  NOT NULL, -- 수량
        FOREIGN KEY (mem_id) REFERENCES member(mem_id)
    );

    DROP TABLE `member`;

# Data Insert/ Update/ Delete

    INSERT INTO <database>.<table> (<column>, <column>, ...)
        VALUES (<value>, <value>, ...), (<value>, <value>, ...), ...; -- insert values

    INSERT INTO <database>.<table> (<column>, <column>, ...)
        SELECT <column> <column> ... FROM <database>.<table>;         -- insert table

    UPDATE <database>.<table>
        SET <column> = <value>, <column> = <value>, ...
        WHERE <condition>;                                            -- update

    DELETE FROM <database>.<table>
        WHERE <condition>;                                            -- delete data

    TRUNCATE TABLE <database>.<table>;                                -- delete all

# Select

    SELECT <column> <name>, <column> <name>, ...
        FROM <database>.<table>
        WHERE <condition>
        GROUP BY <column>
        HAVING <condition>
        ORDER BY <column> <ASC | DESC>, <column2> <ASC | DESC> ...
        LIMIT <offset> <number>;

# JOIN

    SELECT <table>.<column> <name>, <table>.<column> <name>, ...
        FROM <table> <name>
        INNER JOIN  <table> <name>
        ON <table>.<column> = <table>.<column>;                  -- inner join

-- 데카르트 곱(CROSS JOIN)
SELECT m.mem_id, m.mem_name, b.mem_id
FROM member m, buy b
ORDER BY m.mem_id;

# Operator

    >, <,  >=, <=, !=, <>         : 관계 연산자
    AND, OR                       : 논리 연산자
    BETWEEN <number> AND <number> : 값 사이에 있는지 확인
    IN(<element>, <element>, ...) : 포함되어있는지 확인
    LIKE                          : 정규식 확인, _(한 문자), %(여러 문자) 사용 가능

# Aggregate Function

    SUM()           : 합계
    AVG()           : 평균
    MIN()           : 최소값
    MAX()           : 최대값
    COUNT()         : 행의 개수
    COUNT(DISTINCT) : 행의 개수 (중복은 1개만 인정)

# Type

    TINYINT          : 정수                           (1B)
    SMALLINT         : 정수                           (2B)
    INT              : 정수                           (4B)
    BIGINT           : 정수                           (8B)
    FLOAT            : 소수                           (4B)
    DOUBLE           : 소수                           (8B)
    DATE             : 날짜 YYYY-MM-DD                (3B)
    TIME             : 시간 HH:MM:SS                  (3B)
    DATETIME         : 날짜, 시간 YYYY-MM-DD HH:MM:SS (8B)
    CHAR(length)     : 고정 길이 문자형               (1~255B)
    VARCHAR(length)  : 가변 길이 문자형               (1~16383B)
    TEXT(length)     : 긴 문자형                      (0~65535B)
    LONGTEXT(length) : 긴 문자형                      (0~4294967295B)
    BLOB             : 이미지, 동영상                 (0~65535B)
    LONGBLOB         : 이미지, 동영상                 (0~4294967295B)

    -- 정수에 UNSIGNED | SIGNED 사용 가능
    -- CAST(<value> AS <type>)   : 형 변환
    -- CONVERT (<value>, <type>) : 형 변환

# ECT

    -- AUTO_INCREMENT

    CREATE TABLE <table>(
        <column> <type> AUTO_INCREMENT
    );                                            -- auto increment 설정

    ALTER TABLE <table> AUTO_INCREMENT = <value>; -- 시작값 설정

    SET @@auto_increment_increment = <value>;     -- 증가값 설정

    -- DISTINCT

    SELECT DISTINCT <column> FROM <database>.<table>;

    -- DESCRIBE

    DESC <database>.<table>;

    SET @<variable> := <value>;

    PREPARE <prepare> FROM <sql>;
    EXECUTE <prepare> USING @<variable>;

SELECT LAST_INSERT_ID();
ALTER TABLE toys2 AUTO_INCREMENT=100;
SELECT CURRENT_DATE(), DATEDIFF('2021-12-31', '2000-1-1');
CONCAT(,);
