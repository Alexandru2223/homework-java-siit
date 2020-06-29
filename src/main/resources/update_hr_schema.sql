drop database hr;
create schema hr;
use hr;

create table if not exists department
(
    id   int(2) auto_increment primary key,
    name varchar(50) not null,
    city varchar(50) null,
    sasa char(109)

);

create table if not exists employee
(
    id            int(4)      not null
        primary key,
    name          varchar(10) null,
    job           varchar(9)  null,
    mgr           int(4)      null,
    hiredate      date        null,
    salary        int(4),
    comm          int(4)      null,
    department_id int(2) references department (id)
);

create table if not exists salgrade
(
    id    int(4) primary key auto_increment,
    losal int null,
    hisal int null
);

INSERT INTO department (id, name, city)
VALUES (10, 'WORK', 'NEW YORK');
INSERT INTO department (id, name, city)
VALUES (20, 'RESEARCH', 'DALLAS');
INSERT INTO department (id, name, city)
VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO department (id, name, city)
VALUES (40, 'OPERATIONS', 'BOSTON');


INSERT INTO salgrade (id, LOSAL, HISAL)
VALUES (1, 700, 1200);
INSERT INTO salgrade (id, LOSAL, HISAL)
VALUES (2, 1201, 1400);
INSERT INTO salgrade (id, LOSAL, HISAL)
VALUES (3, 1401, 2000);
INSERT INTO salgrade (id, LOSAL, HISAL)
VALUES (4, 2001, 3000);
INSERT INTO salgrade (id, LOSAL, HISAL)
VALUES (5, 3001, 9999);

INSERT INTO employee
VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 920, 138, 20),
       (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30),
       (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250, 500, 30),
       (7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 3421, 513, 20),
       (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30),
       (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850, null, 30),
       (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, null, 10),
       (7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', 3450, 518, 20),
       (7839, 'KING', 'PRESIDENT', null, '1981-11-17', 5000, null, 10),
       (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30),
       (7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', 1265, 190, 20),
       (7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, null, 30),
       (7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3450, 518, 20),
       (7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, null, null),
       (7935, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, null, 10);
