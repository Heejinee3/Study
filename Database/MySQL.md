<br />

본 글은 한빛미디어의 <혼자 공부하는 SQL>을 요약 정리했습니다.

[출처: 우재남, 「혼자 공부하는 SQL」, 한빛미디어](https://www.hanbit.co.kr/store/books/look.php?p_code=B6846155853)

<br />

## Database

#### Show

```sql
SHOW DATABASES;
```

#### Create

```sql
CREATE DATABASE IF NOT EXISTS <database>;
```

#### Drop

```sql
DROP DATABASE IF EXISTS <database>;
```

#### Use

```sql
USE <database>;
```

<br />

## Table

#### Create

```sql
CREATE <OR REPLACE TABLE | TABLE IF NOT EXISTS> <table>
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

CREATE <OR REPLACE TABLE | TABLE IF NOT EXISTS> <table>
    <select statement>;                                 -- select 문을 이용한 table 만들기
```

<table>
  <thead>
    <tr>
      <th>Option</th>
      <th>Explanation</th>
      <th>Way</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>AUTO_INCREMENT</td>
      <td>1부터 자동으로 숫자가 지정, 지정한 열이 PRIMARY KEY나 UNIQUE여야 함</td>
      <td></td>
    </tr>
    <tr>
      <td>NOT NULL</td>
      <td>NULL이 입력될 수 없음</td>
      <td></td>
    </tr>
    <tr>
      <td>UNIQUE</td>
      <td>같은 값이 올 수 없음</td>
      <td></td>
    </tr>
    <tr>
      <td>PRIMARY KEY</td>
      <td>NOT NULL + UNIQUE</td>
      <td></td>
    </tr>
    <tr>
      <td rowspan="4">FOREIGN KEY</td>
      <td>다른 테이블의 열과 연결, 지정한 열이 PRIMARY KEY나 UNIQUE여야 함</td>
      <td></td>
    </tr>
    <tr>
      <td>CASCADE</td>
      <td>함께 작동</td>
    </tr>
    <tr>
      <td>SET NULL</td>
      <td>NULL로 설정</td>
    </tr>
    <tr>
      <td>RESTRICT</td>
      <td>error 발생</td>
    </tr>
  </tbody>
</table>

#### Alter

```sql
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
    ADD CONSTRAINT UNIQUE(<column>);                                 -- unique 지정

ALTER TABLE <table> DROP  PRIMARY KEY;                               -- primary key 삭제

ALTER TABLE <table> DROP  FOREIGN KEY;                               -- foreign key 삭제

ALTER TABLE <table> DROP  UNIQUE;                                    -- unique 삭제
```

#### Drop

```sql
DROP TABLE IF EXISTS <table>;
```

<br />

## View

#### Create

```sql
CREATE <OR REPLACE VIEW | VIEW IF NOT EXISTS> <view> AS
    <select statement>
    <WITH CHECK OPTION>;
```

#### Alter

```sql
ALTER VIEW <view> AS
    <select statement>
    <WITH CHECK OPTION>;
```

#### Drop

```sql
DROP VIEW IF EXISTS <view>;
```

<br />

## Data

#### Insert

```sql
INSERT INTO <table | view> (<column>, <column>, ...)
    VALUES (<value>, <value>, ...), (<value>, <value>, ...), ...; -- insert values

INSERT INTO <table | view> (<column>, <column>, ...)
    <select statement>;                                           -- insert table
```

#### Update

```sql
UPDATE <table | view>
    SET <column> = <value>, <column> = <value>, ...
    WHERE <condition>;
```

#### Delete

```sql
DELETE FROM <table | view>
    WHERE <condition>;                                            -- delete data

TRUNCATE TABLE <table | view>;                                    -- delete all
```

#### Show

```sql
DESC <table | view>;                                              -- 정보를 보여줌

SHOW CREATE <TABLE | VIEW> <table | view>;                        -- 소스코드를 보여줌

CHECK TABLE <table | view>;                                       -- 상태를 확인
```

<br />

## Select

```sql
SELECT <column> <name>, <column> <name>, ...
    FROM <table>
    WHERE <condition>
    GROUP BY <column>
    HAVING <condition>
    ORDER BY <column> <ASC | DESC>, <column2> <ASC | DESC> ...
    LIMIT <offset> <number>;
```

<br />

## Join

#### Inner Join/Self Join

```sql
SELECT <table>.<column> <name>, <table>.<column> <name>, ...
    FROM <table> <name>
        INNER JOIN  <table> <name>
        ON <table>.<column> = <table>.<column>;              -- inner join / self join
```

#### Left Outer Join

```sql
SELECT <table>.<column> <name>, <table>.<column> <name>, ...
    FROM <table> <name>
        LEFT OUTER JOIN  <table> <name>
        ON <table>.<column> = <table>.<column>;              -- left outer join
```

#### Right Outer Join

```sql
SELECT <table>.<column> <name>, <table>.<column> <name>, ...
    FROM <table> <name>
        RIGHT OUTER JOIN  <table> <name>
        ON <table>.<column> = <table>.<column>;              -- right outer join
```

#### Full Outer Join

```sql
SELECT <table>.<column> <name>, <table>.<column> <name>, ...
    FROM <table> <name>
        LEFT OUTER JOIN  <table> <name>
        ON <table>.<column> = <table>.<column>
UNION
SELECT <table>.<column> <name>, <table>.<column> <name>, ...
    FROM <table> <name>
        RIGHT OUTER JOIN  <table> <name>
        ON <table>.<column> = <table>.<column>;              -- full outer join
```

#### Cross Join

```sql
SELECT <table>.<column> <name>, <table>.<column> <name>, ...
    FROM <table> <name>
        CROSS JOIN JOIN  <table> <name>                      -- cross join
```

<br />

## Procedure

#### Create

```sql
DELIMITER $$
CREATE PROCEDURE <procedure>(IN <variable> <type>, OUT <variable> <type>)
BEGIN
    <statement>;
END $$
DELIMITER ;
```

#### Call

```sql
CALL <procedure>(<value>, @<variable>);
```

#### Drop

```sql
DROP PROCEDURE IF EXISTS <procedure>;
```

<br />

## Function

#### Create

```sql
DELIMITER $$
CREATE Function <function>(<variable> <type>) RETURNS <type>
BEGIN
    <statement>;
    RETURN <value>;
END $$
DELIMITER ;
```

#### Call

```sql
SELECT <function>(<value>);
```

#### Drop

```sql
DROP Function IF EXISTS <function>;
```

<br />

## Trigger

#### Create

```sql
DELIMITER $$
CREATE Trigger <trigger>
    AFTER <DELETE | UPDATE | INSERT>
    ON <table>
    FOR EACH ROW
BEGIN
    <statement>;                     -- OLD table, NEW table 사용 가능
END $$
DELIMITER ;
```

#### Drop

```sql
DROP Trigger IF EXISTS <trigger>;
```

<br />

## If/Case/While

#### Declaration/Initializaion

```sql
DECLARE <variable> <type>;      -- declaration

SET <variable> = <value>;       -- set variable

SELECT <column> INTO <variable>
    FROM <table>
    WHERE <condition>;          -- set variable using table
```

#### If Statement

```sql
IF <condition> THEN
    <statement>;
ELSEIF <condition> THEN
    <statement>;
ELSE
    <statement>;
END IF;
```

#### Case Statement

```sql
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
```

#### While Loop

```sql
<loop>:
WHILE <condition> DO
    <statement>;     -- ITERATE <loop> : continue, loop 제외 가능
                     -- LEAVE <loop>   : break, loop 제외 가능
END WHILE;
```

<br />

## Cursor

```sql
DECLARE <row variable> <type>;
DECLARE <end variable> BOOLEAN DEFAULT FALSE;
DECLARE <count variable> INT DEFAULT 0;          -- 변수 설정

DECLARE <cursor> CURSOR FOR
    <select statement>;                          -- cursor 지정

DECLARE CONTINUE HANDLER
    FOR NOT FOUND SET <end variable> = TRUE;     -- loop end 조건

OPEN <cursor>;                                   -- cursor open

<loop>: LOOP                                     -- loop 시작

    FETCH <cursor> INTO <row variable>;          -- table에서 값 받아오기

    IF <end variable> THEN                       -- table 끝까지 오면 loop 빠져나가기
        LEAVE <loop>;
    END IF;

    SET <count variable> = <count variable> + 1; -- table의 row count 세기

END LOOP <loop>;
```

<br />

## Prepare

#### Allocate

```sql
PREPARE <prepare> FROM <sql>;                           -- variable을 넣는 곳에는 ?을 넣음
```

#### Execute

```sql
EXECUTE <prepare> USING @<variable> , @<variable>, ...;
```

#### Deallocate

```sql
DEALLOCATE PREPARE <prepare>;
```

<br />

## Index

#### Show

```sql
SHOW INDEX FROM <table>;               -- 존재하는 index 보기

SHOW TABLE STATUS LIKE <table string>; -- index 상태 보기
```

#### Create

```sql
CREATE <UNIQUE> INDEX <index>
    ON <table>(<column>) <ASC | DESC>; -- index create

ANALYZE TABLE <table>;                 -- index apply
```

#### Drop

```sql
DROP INDEX <index> ON <table>;
```

<br />

## Operator

```sql
>, <,  >=, <=, !=, <>         : 관계 연산자
AND, OR                       : 논리 연산자
BETWEEN <number> AND <number> : 값 사이에 있는지 확인
IN(<element>, <element>, ...) : 포함되어있는지 확인
LIKE                          : 정규식 확인, _(한 문자), %(여러 문자) 사용 가능
IS NULL, IS NOT NULL          : NULL인지 아닌지 확인
```

<br />

## Aggregate Function

```sql
SUM()           : 합계
AVG()           : 평균
MIN()           : 최소값
MAX()           : 최대값
COUNT()         : 행의 개수
COUNT(DISTINCT) : 행의 개수 (중복은 1개만 인정)
```

<br />

## Type

#### Kind

```sql
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
```

#### Additional Details

```sql
-- 정수에 UNSIGNED | SIGNED 사용 가능
-- CAST(<value> AS <type>)   : 형 변환
-- CONVERT (<value>, <type>) : 형 변환
```

<br />

## Reference

#### AUTO_INCREMENT

```sql
CREATE TABLE <table>(
    <column> <type> AUTO_INCREMENT
);                                            -- auto increment 설정

ALTER TABLE <table> AUTO_INCREMENT = <value>; -- 시작값 설정

SET @@auto_increment_increment = <value>;     -- 증가값 설정
```

#### DISTINCT

```sql
SELECT DISTINCT <column> FROM <table>;
```

#### Using Variable

```sql
SET @<variable> := <value>;
SET @<variable> = <value>;
```

#### UNION

```sql
<select statement>
UNION <DISTINCT | ALL>
<select statement>
```

<br />
