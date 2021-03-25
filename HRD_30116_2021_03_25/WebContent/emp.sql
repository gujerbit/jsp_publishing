drop table employee_tbl;

create table employee_tbl(
	empno		number(5) primary key,
	empname		varchar2(20),
	joindate	date,
	rank		char(1),
	dept		char(1)
);

insert into employee_tbl values(10001, '고영만', '2017-03-01', 'A', 'A');
insert into employee_tbl values(10002, '만준원', '2017-03-01', 'A', 'B');
insert into employee_tbl values(10003, '원성휘', '2017-03-01', 'B', 'A');
insert into employee_tbl values(10004, '휘현진', '2015-05-01', 'B', 'B');
insert into employee_tbl values(10005, '진유민', '2015-05-01', 'C', 'C');

drop table salary_tbl;

create table salary_tbl(
	empno		number(5),
	payday		date,
	pay			number(10),
	constraint temp primary key(empno, payday)
);

insert into salary_tbl values(10001, '2019-03-01', 1540000);
insert into salary_tbl values(10001, '2019-04-01', 1570000);
insert into salary_tbl values(10002, '2019-03-01', 1740000);
insert into salary_tbl values(10002, '2019-04-01', 1770000);
insert into salary_tbl values(10003, '2019-03-01', 2400000);
insert into salary_tbl values(10003, '2019-04-01', 2450000);
insert into salary_tbl values(10004, '2019-03-01', 3400000);
insert into salary_tbl values(10004, '2019-04-01', 3450000);
insert into salary_tbl values(10005, '2019-03-01', 4500000);
insert into salary_tbl values(10005, '2019-04-01', 4550000);

delete employee_tbl where empno = 10006; 

select e.empno, e.empname, sum(s.pay) from employee_tbl e, salary_tbl s where e.empno = s.empno group by(e.empno, e.empname) order by sum(s.pay) desc;