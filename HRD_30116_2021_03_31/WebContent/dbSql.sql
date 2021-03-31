DROP TABLE course_tbl;

CREATE TABLE course_tbl(
	id			VARCHAR2(5) PRIMARY KEY,
	name		VARCHAR2(40),
	credit		NUMBER(6),
	lecturer	VARCHAR2(10),
	week		NUMBER(2),
	start_hour	NUMBER(4),
	end_end		NUMBER(4)
);

INSERT INTO course_tbl VALUES(10001, '프로그래밍', 2, '1', 1, 0900, 1100);
INSERT INTO course_tbl VALUES(10002, '객체지향 프로그래밍', 2, '2', 2, 0900, 1200);
INSERT INTO course_tbl VALUES(10003, '자료구조', 3, '4', 3, 0900, 1200);
INSERT INTO course_tbl VALUES(10004, '알고리즘', 3, '4', 4, 0900, 1200);
INSERT INTO course_tbl VALUES(20001, '시스템 프로그래밍', 2, '5', 1, 1300, 1600);
INSERT INTO course_tbl VALUES(20002, '운영체제', 3, '5', 2, 0900, 1800);
INSERT INTO course_tbl VALUES(20003, '오토마타와 컴파일러', 3, '5', 3, 1330, 1630);
INSERT INTO course_tbl VALUES(30001, '소프트웨어 공학', 2, '3', 4, 1330, 1530);
INSERT INTO course_tbl VALUES(30002, '시스템 분석 및 설계', 3, '3', 5, 0900, 1200);
INSERT INTO course_tbl VALUES(40001, '데이터베이스', 3, '2', 5, 1300, 1600);

select * from course_tbl;
delete course_tbl where lecturer = 6;

DROP TABLE lecturer_tbl;

CREATE TABLE lecturer_tbl(
	idx			VARCHAR2(10) PRIMARY KEY,
	name		VARCHAR2(10),
	major		VARCHAR2(30),
	field		VARCHAR2(30)
);

INSERT INTO lecturer_tbl VALUES(1, '김교수', '소프트웨어공학', '알고리즘');
INSERT INTO lecturer_tbl VALUES(2, '이교수', '소프트웨어공학', '인공지능');
INSERT INTO lecturer_tbl VALUES(3, '박교수', '소프트웨어공학', '소프트웨어공학');
INSERT INTO lecturer_tbl VALUES(4, '우교수', '소프트웨어공학', '알고리즘');
INSERT INTO lecturer_tbl VALUES(5, '최교수', '응용컴퓨터공학', '임베디드 시스템');
INSERT INTO lecturer_tbl VALUES(6, '강교수', '응용컴퓨터공학', '멀티미디어');
INSERT INTO lecturer_tbl VALUES(7, '황교수', '모바일시스템공학', '네트워크');

SELECT * FROM lecturer_tbl ORDER BY idx;

SELECT c.id, c.name, c.credit, l.name, c.week, c.start_hour, c.end_end FROM course_tbl c, lecturer_tbl l WHERE c.lecturer = l.idx;