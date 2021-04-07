DROP TABLE personnel;

CREATE TABLE personnel(
	id			CHAR(2) PRIMARY KEY,
	name		VARCHAR2(30) NOT NULL,
	dept		VARCHAR2(20) NOT NULL,
	position	CHAR(1),
	duty		VARCHAR2(20),
	phone		VARCHAR2(14)
);

INSERT INTO personnel VALUES('95', '박민우', '인사부', '1', '상무', '010-1234-5678');
INSERT INTO personnel VALUES('96', '홍길동', '경리부', '2', '과장', '010-3333-4444');