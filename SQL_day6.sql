--SQL(비절차적 구조화 Query 언어 ) ANSI표준 
--PL/SQL (oracle의 절차적프로그램) : Procedure, Function, Trigger, Package 

create table aa(id number);

--Procedure:복잡한 건수많은 데이터를 서버에 실행 
create or replace procedure sp_salary(v_empid in employees.employee_id%type,
                                                                  v_salary out employees.salary%type,
                                                                  v_firstname out employees.first_name%type
)
is
    v_message varchar2(50) := '직원의 급여를 조회한다.';
begin
    select salary, first_name
    into v_salary, v_firstname
    from employees
    where employee_id = v_empid;
    dbms_output.put_line(v_message || ':'|| v_salary);
end;
/
set serveroutput on;
variable sal number ;
execute sp_salary(101, :sal);

print sal

------------------Function
select lower('ORACLE') from dual;

select first_name, substr(first_name,1,3) 
from employees
where department_id = 60;


-----급여에 해당하는 세금.....
create or replace Function f_tax(v_salary in employees.salary%type)
return employees.salary%type
is
    v_tax employees.salary%type;
begin
    v_tax := v_salary*0.5;
    return v_tax;
end;
/

select f_tax(1000) from dual;select first_name, salary, f_tax(salary)
from employees;


--커서이용(여러건 select시 반드시사용)

create or replace procedure sp_dept
is
    v_dept_record departments%rowtype;
    v_deptid departments.department_id%type;
    v_deptname departments.department_name%type;
    --커서선언
    cursor cur_dept
    is select department_id,department_name  from departments where manager_id is not null;
    
begin
    --커서열기
     open cur_dept;
     loop
         --커서사용
         --fetch cur_dept into v_deptid, v_deptname;
         fetch cur_dept into v_dept_record.department_id, v_dept_record.department_name;
         exit when cur_dept%notfound;
         DBMS_OUTPUT.put_line('부서번호:'||v_deptid);
         DBMS_OUTPUT.put_line('부서이름:'||v_deptname);
     end loop;
     --커서닫기 
     close cur_dept;
     
end;
/
execute sp_dept;
-- 명시적커서(declare, open . fetch, close)
-- 암시적커서 
create or replace procedure sp_dept2
is

begin
    
     for  v_record    in ( select *  from departments where manager_id is not null   ) loop
         DBMS_OUTPUT.put_line('부서번호:'||v_record.department_id);
         DBMS_OUTPUT.put_line('부서이름:'||v_record.department_name);
     end loop;
end;
/
execute sp_dept2;

--procedure : SQL복잡, DATA양이 많다. Network를 이용하면 비효율적이다. 그래서 서버에서만 실행되는 좋다.
--Function : 재사용목적 , 변경가능성이있는 부분은 매번 SQL문에 계산식을 쓰지말고 function으로 만들자 

--선언부 
create or replace package pkg_emp
is
    procedure sp_dept;
    procedure sp_dept2;
end;
/

create or replace package body pkg_emp
is
    procedure sp_dept
                is
                    v_dept_record departments%rowtype;
                    v_deptid departments.department_id%type;
                    v_deptname departments.department_name%type;
                    --커서선언
                    cursor cur_dept
                    is select department_id,department_name  from departments where manager_id is not null;
                    
                begin
                    --커서열기
                     open cur_dept;
                     loop
                         --커서사용
                         fetch cur_dept into v_deptid, v_deptname;
                         --fetch cur_dept into v_dept_record.department_id, v_dept_record.department_name;
                         exit when cur_dept%notfound;
                         DBMS_OUTPUT.put_line('부서번호:'||v_deptid);
                         DBMS_OUTPUT.put_line('부서이름:'||v_deptname);
                     end loop;
                     --커서닫기 
                     close cur_dept;
                     
                end; --sp_dept끝
                procedure sp_dept2
                        is
                        
                begin
                    
                     for  v_record    in ( select *  from departments where manager_id is not null   ) loop
                         DBMS_OUTPUT.put_line('부서번호:'||v_record.department_id);
                         DBMS_OUTPUT.put_line('부서이름:'||v_record.department_name);
                     end loop;
                end;  --sp_dept2끝  
end;
/

execute PKG_EMP.sp_dept;
execute PKG_EMP.sp_dept2;


---trigger : 어떤 table에 사건이 발생시 자동으로 실행되도록하는 prrocedure이다. 
delete from job_history;
commit;
select * from job_history;

select * from employees where employee_id = 100;
update employees set department_id = 110 where employee_id = 100;

rollback;

create or replace trigger trigger_dept1
after insert on departments
begin
    DBMS_output.put_line('부서가 삽입되었습니다....');

end;
/
desc departments;

insert into departments( department_id, department_name)
values (1, 'aa');


insert into departments( department_id, department_name)
values (3, 'cc');


create sequence seq_sales;

rollback;

drop table sales_dept;
drop table sales_dept2;

create table sales_dept(
   salno number primary key,
   price number,
   department_id number REFERENCES departments(department_id)
);

create or replace trigger trigger_dept2
 after insert on departments
 for each row
begin
    DBMS_output.put_line('sales_dept에 insert됩니다.....');
    insert into sales_dept values(seq_sales.nextval, 1000, :new.department_id);
end;
/

insert into departments( department_id, department_name)
values (9, '개발부!!!!!');

select * from sales_dept;


create or replace trigger trigger_dept3
 after delete on departments
 for each row
begin
    DBMS_output.put_line('sales_dept에 delete됩니다.....');
    delete from sales_dept where department_id = :old.department_id;
end;
/
DELETE from departments where department_id = 9;


CREATE TABLE 상품(
            상품코드 CHAR(6) PRIMARY KEY,
            상품명 VARCHAR2(12) NOT NULL,
            제조사 VARCHAR(12),
            소비자가격 NUMBER(8),
            재고수량 NUMBER DEFAULT 0
);

CREATE TABLE 입고(
        입고번호 NUMBER(6) PRIMARY KEY,
        상품코드 CHAR(6) REFERENCES 상품(상품코드),
        입고일자 DATE DEFAULT SYSDATE,
        입고수량 NUMBER(6),
        입고단가 NUMBER(8),
        입고금액 NUMBER(8)
);


INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00001','세탁기', 'LG', 500); 

INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00002','컴퓨터', 'LG', 700);

INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00003','냉장고', '삼성', 600);

select * from 상품;
select * from 입고;


-- 입고 트리거
CREATE OR REPLACE TRIGGER TRG_04
AFTER INSERT ON 입고
FOR EACH ROW
BEGIN
            UPDATE 상품
            SET 재고수량 = 재고수량 + :NEW.입고수량
            WHERE 상품코드 = :NEW.상품코드;
END;
/ 

insert into 입고(입고번호, 상품코드,입고수량,입고단가) values(1, 'A00003', 10, 200);
insert into 입고(입고번호, 상품코드,입고수량,입고단가) values(2, 'A00003', 20, 200);

select * from 입고;
select * from 상품;


      
select * from departments;    
drop table sales_dept;
delete from departments where department_id<10 ;
commit;
      

      
      
      
      
      
      
        