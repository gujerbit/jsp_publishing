drop table mem_tbl_book;

create table mem_tbl_book(
	custno		number(6) primary key,
	custname	varchar2(20),
	joindate	date,
	grade		char(1),
	address		varchar2(60)
);

insert into mem_tbl_book values(10001, '박정희', '2019-02-15', 'A', '경기 분당구 서현동');
insert into mem_tbl_book values(10002, '최선한', '2019-03-15', 'B', '경기 군포시 산본동');
insert into mem_tbl_book values(10003, '김순애', '2019-04-17', 'A', '경기 군포시 산본동');
insert into mem_tbl_book values(10004, '최정현', '2019-12-19', 'B', '경기 분당구 정자동');
insert into mem_tbl_book values(10005, '김영림', '2020-02-15', 'A', '경기 분당구 정자동');
insert into mem_tbl_book values(10006, '박세영', '2020-02-15', 'C', '경기 용인시 용인동');

drop table rent_tbl_book;

create table rent_tbl_book(
	custno		number(6),
	bookno		number(4),
	rentdate	date,
	returndate	date,
	constraint temp primary key(custno, bookno)
);

insert into rent_tbl_book values(10001, 1234, '2019-02-15', '2019-02-15');
insert into rent_tbl_book values(10001, 1122, '2019-02-15', '2019-02-16');
insert into rent_tbl_book values(10002, 1234, '2019-03-15', '2019-02-15');
insert into rent_tbl_book values(10003, 1234, '2019-04-17', '2019-02-15');
insert into rent_tbl_book values(10004, 1122, '2019-12-19', '2019-02-15');
insert into rent_tbl_book values(10005, 1122, '2020-02-15', '2020-02-15');
insert into rent_tbl_book values(10005, 1113, '2019-02-15', '2019-02-15');
insert into rent_tbl_book values(10005, 1114, '2019-02-15', '2019-02-15');
insert into rent_tbl_book values(10006, 1113, '2020-02-15', '2020-02-15');