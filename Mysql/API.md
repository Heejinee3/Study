# Database Show/ Create/ Drop/ Use

#### Show

    SHOW DATABASES;

#### Create

    CREATE DATABASE IF NOT EXISTS <database>;

#### Drop

    DROP DATABASE IF EXISTS <database>;

#### Use

    USE <database>;

# Table Describe/ Create/ Alter/ Drop

#### Describe

    DESC <table>;

#### Create

    CREATE TABLE IF NOT EXISTS <table>
    (   <column> <type> AUTO_INCREMENT,
        <column> <type> NOT NULL,
        <column> <type> PRIMARY KEY,
        <column> <type> UNIQUE,
        <column> <type> CHECK (<condition>),
        <column> <type> DEFAULT <value>,
        PRiMARY KEY(<column>),
        FOREIGN KEY(<column>)
            REFERENCES <table>(<column>)
            ON UPDATE <way>
            ON DELETE <way>
    );

    CREATE TABLE IF NOT EXISTS <table>
        <select statement>;

Foreign Key Update/ Delete Option

AUTO_INCREMENT| 1부터 자동으로 숫자가 지정, 지정한 열이 PRIMARY KEY나 UNIQUE여야 함
NOT NULL | NULL이 입력될 수 없음
UNIQUE | 같은 값이 올 수 없음
PRIMARY KEY | NOT NULL + UNIQUE
FOREIGN KEY | 다른 테이블의 열과 연결, 지정한 열이 PRIMARY KEY나 UNIQUE여야 함
CASCADE | 함께 작동
SET NULL | NULL로 설정
RESTRICT | error 발생

#### Alter

    ALTER TABLE <table> ADD COLUMN <column> <type> <option>;             -- add column

    ALTER TABLE <table> ADD COLUMN <column> <type> <option> <column>;    -- add column behind

    ALTER TABLE <table> MODIFY COLUMN <column> <type> <option>;          -- modify column

    ALTER TABLE <table> CHANGE COLUMN <column> <column> <type> <option>; -- change column name

    ALTER TABLE table_name DROP COLUMN <column>;                         -- drop column

    ALTER TABLE <table> RENAME <table>;                                  -- change table name

    ALTER TABLE <table>
        ADD CONSTRAINT PRIMARY KEY(<column>);                            -- primary key 지정

    ALTER TABLE <table>
        ADD CONSTRAINT FOREIGN KEY(<column>)
            REFERENCES <table> (<column>)
            ON UPDATE <way>
            ON DELETE <way>;                                             -- foreign key 지정

    ALTER TABLE <table>
        ALTER COLUMN <column> SET DEFAULT <value>;                       -- default value 지정

#### Drop

    DROP TABLE IF EXISTS <table>;

# View

#### Create

    CREATE OR REPLACE VIEW <view> AS
        <select statement>;

#### Alter

    ALTER VIEW <view> AS
        <select statement>;

#### Drop

    DROP VIEW <view>;

#### Show

    DESC v_viewtest2;

    SHOW CREATE VIEW <view>;

update할때 not null이 없어야함 아니면 모두 input하거나

# Data Insert/ Update/ Delete

#### Insert

    INSERT INTO <table | view> (<column>, <column>, ...)
        VALUES (<value>, <value>, ...), (<value>, <value>, ...), ...; -- insert values

    INSERT INTO <table> (<column>, <column>, ...)
        <select statement>;                                           -- insert table

#### Update

    UPDATE <table | view>
        SET <column> = <value>, <column> = <value>, ...
        WHERE <condition>;

#### Delete

    DELETE FROM <table | view>
        WHERE <condition>;                                            -- delete data

    TRUNCATE TABLE <table>;                                           -- delete all

# Select

    SELECT <column> <name>, <column> <name>, ...
        FROM <table>
        WHERE <condition>
        GROUP BY <column>
        HAVING <condition>
        ORDER BY <column> <ASC | DESC>, <column2> <ASC | DESC> ...
        LIMIT <offset> <number>;

# JOIN

#### Inner Join/ Self Join

    SELECT <table>.<column> <name>, <table>.<column> <name>, ...
        FROM <table> <name>
            INNER JOIN  <table> <name>
            ON <table>.<column> = <table>.<column>;              -- inner join / self join

#### Left Outer Join

    SELECT <table>.<column> <name>, <table>.<column> <name>, ...
        FROM <table> <name>
            LEFT OUTER JOIN  <table> <name>
            ON <table>.<column> = <table>.<column>;              -- left outer join

#### Right Outer Join

    SELECT <table>.<column> <name>, <table>.<column> <name>, ...
        FROM <table> <name>
            RIGHT OUTER JOIN  <table> <name>
            ON <table>.<column> = <table>.<column>;              -- right outer join

#### Full Outer Join

    SELECT <table>.<column> <name>, <table>.<column> <name>, ...
        FROM <table> <name>
            LEFT OUTER JOIN  <table> <name>
            ON <table>.<column> = <table>.<column>
    UNION
    SELECT <table>.<column> <name>, <table>.<column> <name>, ...
        FROM <table> <name>
            RIGHT OUTER JOIN  <table> <name>
            ON <table>.<column> = <table>.<column>;              -- full outer join

#### Cross Join

    SELECT <table>.<column> <name>, <table>.<column> <name>, ...
        FROM <table> <name>
            CROSS JOIN JOIN  <table> <name>                      -- cross join

# Procedure

#### Create

    DROP PROCEDURE IF EXISTS <procedure>;
    DELIMITER $$
    CREATE PROCEDURE <procedure>()
    BEGIN
        <statement>;
    END $$
    DELIMITER ;

#### Call

    CALL <procedure>();

#### Declaration/ Initializaion

    DECLARE <variable> <type>;      -- declaration

    SET <variable> = <value>;       -- set variable

    SELECT <column> INTO <variable>
        FROM <table>
        WHERE <condition>;          -- set variable using table

#### If Statement

    IF <condition> THEN
    	<statement>;
    ELSEIF <condition> THEN
        <statement>;
    ELSE
    	<statement>;
    END IF;

#### Case Statement

    CASE
    	WHEN <condition> THEN
    		SET <variable> = <value>;
    	WHEN <condition> THEN
    		SET <variable> = <value>;
    	WHEN <condition> THEN
    		SET <variable> = <value>;
    	WHEN <condition> THEN
    		SET <variable> = <value>;
    	ELSE
    		SET <variable> = <value>;
    END CASE;

#### While Loop

    <loop>:
    WHILE <condition> DO
        <statement>;     -- ITERATE <loop> : continue, loop 제외 가능
                         -- LEAVE <loop>   : break, loop 제외 가능
    END WHILE;

# Prepare

#### Allocate

    PREPARE <prepare> FROM <sql>;                           -- variable을 넣는 곳에는 ?을 넣음

#### Execute

    EXECUTE <prepare> USING @<variable> , @<variable>, ...;

#### Deallocate

    DEALLOCATE PREPARE <prepare>;

# Operator

    >, <,  >=, <=, !=, <>         : 관계 연산자
    AND, OR                       : 논리 연산자
    BETWEEN <number> AND <number> : 값 사이에 있는지 확인
    IN(<element>, <element>, ...) : 포함되어있는지 확인
    LIKE                          : 정규식 확인, _(한 문자), %(여러 문자) 사용 가능
    IS NULL, IS NOT NULL          : NULL인지 아닌지 확인

# Aggregate Function

    SUM()           : 합계
    AVG()           : 평균
    MIN()           : 최소값
    MAX()           : 최대값
    COUNT()         : 행의 개수
    COUNT(DISTINCT) : 행의 개수 (중복은 1개만 인정)

# Type

#### Kind

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

#### Reference

    -- 정수에 UNSIGNED | SIGNED 사용 가능
    -- CAST(<value> AS <type>)   : 형 변환
    -- CONVERT (<value>, <type>) : 형 변환

# Reference

#### AUTO_INCREMENT

    CREATE TABLE <table>(
        <column> <type> AUTO_INCREMENT
    );                                            -- auto increment 설정

    ALTER TABLE <table> AUTO_INCREMENT = <value>; -- 시작값 설정

    SET @@auto_increment_increment = <value>;     -- 증가값 설정

#### DISTINCT

    SELECT DISTINCT <column> FROM <table>;

#### Using Variable

    SET @<variable> := <value>;
    SET @<variable> = <value>;

    PREPARE <prepare> FROM <sql>;
    EXECUTE <prepare> USING @<variable>;
    DEALLOCATE PREPARE mySQL;

#### Function

    LAST_INSERT_ID()          //
    CURRENT_DATE()                        -- 현재
    CURRENT_TIMESTAMP()                        -- 현재
    DATEDIFF(<date>, <date>)              -- date 차이 반환
    TIMESTAMPDIFF(<unit>, <date>, <date>) -- date 차이 반환
                                          /* <unit>
                                             SECOND
                                             MINUTE
                                             HOUR
                                             DAY
                                             WEEK
                                             MONTH
                                             QUARTER
                                             YEAR    */
    CONCAT(,)
    length

## UNION

    UNION DISTINCT
    UNION ALL
