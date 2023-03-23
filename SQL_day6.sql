--SQL(�������� ����ȭ Query ��� ) ANSIǥ�� 
--PL/SQL (oracle�� ���������α׷�) : Procedure, Function, Trigger, Package 

create table aa(id number);

--Procedure:������ �Ǽ����� �����͸� ������ ���� 
create or replace procedure sp_salary(v_empid in employees.employee_id%type,
                                                                  v_salary out employees.salary%type,
                                                                  v_firstname out employees.first_name%type
)
is
    v_message varchar2(50) := '������ �޿��� ��ȸ�Ѵ�.';
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


-----�޿��� �ش��ϴ� ����.....
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


--Ŀ���̿�(������ select�� �ݵ�û��)

create or replace procedure sp_dept
is
    v_dept_record departments%rowtype;
    v_deptid departments.department_id%type;
    v_deptname departments.department_name%type;
    --Ŀ������
    cursor cur_dept
    is select department_id,department_name  from departments where manager_id is not null;
    
begin
    --Ŀ������
     open cur_dept;
     loop
         --Ŀ�����
         --fetch cur_dept into v_deptid, v_deptname;
         fetch cur_dept into v_dept_record.department_id, v_dept_record.department_name;
         exit when cur_dept%notfound;
         DBMS_OUTPUT.put_line('�μ���ȣ:'||v_deptid);
         DBMS_OUTPUT.put_line('�μ��̸�:'||v_deptname);
     end loop;
     --Ŀ���ݱ� 
     close cur_dept;
     
end;
/
execute sp_dept;
-- �����Ŀ��(declare, open . fetch, close)
-- �Ͻ���Ŀ�� 
create or replace procedure sp_dept2
is

begin
    
     for  v_record    in ( select *  from departments where manager_id is not null   ) loop
         DBMS_OUTPUT.put_line('�μ���ȣ:'||v_record.department_id);
         DBMS_OUTPUT.put_line('�μ��̸�:'||v_record.department_name);
     end loop;
end;
/
execute sp_dept2;

--procedure : SQL����, DATA���� ����. Network�� �̿��ϸ� ��ȿ�����̴�. �׷��� ���������� ����Ǵ� ����.
--Function : ������� , ���氡�ɼ����ִ� �κ��� �Ź� SQL���� ������ �������� function���� ������ 

--����� 
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
                    --Ŀ������
                    cursor cur_dept
                    is select department_id,department_name  from departments where manager_id is not null;
                    
                begin
                    --Ŀ������
                     open cur_dept;
                     loop
                         --Ŀ�����
                         fetch cur_dept into v_deptid, v_deptname;
                         --fetch cur_dept into v_dept_record.department_id, v_dept_record.department_name;
                         exit when cur_dept%notfound;
                         DBMS_OUTPUT.put_line('�μ���ȣ:'||v_deptid);
                         DBMS_OUTPUT.put_line('�μ��̸�:'||v_deptname);
                     end loop;
                     --Ŀ���ݱ� 
                     close cur_dept;
                     
                end; --sp_dept��
                procedure sp_dept2
                        is
                        
                begin
                    
                     for  v_record    in ( select *  from departments where manager_id is not null   ) loop
                         DBMS_OUTPUT.put_line('�μ���ȣ:'||v_record.department_id);
                         DBMS_OUTPUT.put_line('�μ��̸�:'||v_record.department_name);
                     end loop;
                end;  --sp_dept2��  
end;
/

execute PKG_EMP.sp_dept;
execute PKG_EMP.sp_dept2;


---trigger : � table�� ����� �߻��� �ڵ����� ����ǵ����ϴ� prrocedure�̴�. 
delete from job_history;
commit;
select * from job_history;

select * from employees where employee_id = 100;
update employees set department_id = 110 where employee_id = 100;

rollback;

create or replace trigger trigger_dept1
after insert on departments
begin
    DBMS_output.put_line('�μ��� ���ԵǾ����ϴ�....');

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
    DBMS_output.put_line('sales_dept�� insert�˴ϴ�.....');
    insert into sales_dept values(seq_sales.nextval, 1000, :new.department_id);
end;
/

insert into departments( department_id, department_name)
values (9, '���ߺ�!!!!!');

select * from sales_dept;


create or replace trigger trigger_dept3
 after delete on departments
 for each row
begin
    DBMS_output.put_line('sales_dept�� delete�˴ϴ�.....');
    delete from sales_dept where department_id = :old.department_id;
end;
/
DELETE from departments where department_id = 9;


CREATE TABLE ��ǰ(
            ��ǰ�ڵ� CHAR(6) PRIMARY KEY,
            ��ǰ�� VARCHAR2(12) NOT NULL,
            ������ VARCHAR(12),
            �Һ��ڰ��� NUMBER(8),
            ������ NUMBER DEFAULT 0
);

CREATE TABLE �԰�(
        �԰��ȣ NUMBER(6) PRIMARY KEY,
        ��ǰ�ڵ� CHAR(6) REFERENCES ��ǰ(��ǰ�ڵ�),
        �԰����� DATE DEFAULT SYSDATE,
        �԰���� NUMBER(6),
        �԰�ܰ� NUMBER(8),
        �԰�ݾ� NUMBER(8)
);


INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���)
VALUES('A00001','��Ź��', 'LG', 500); 

INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���)
VALUES('A00002','��ǻ��', 'LG', 700);

INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���)
VALUES('A00003','�����', '�Ｚ', 600);

select * from ��ǰ;
select * from �԰�;


-- �԰� Ʈ����
CREATE OR REPLACE TRIGGER TRG_04
AFTER INSERT ON �԰�
FOR EACH ROW
BEGIN
            UPDATE ��ǰ
            SET ������ = ������ + :NEW.�԰����
            WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
END;
/ 

insert into �԰�(�԰��ȣ, ��ǰ�ڵ�,�԰����,�԰�ܰ�) values(1, 'A00003', 10, 200);
insert into �԰�(�԰��ȣ, ��ǰ�ڵ�,�԰����,�԰�ܰ�) values(2, 'A00003', 20, 200);

select * from �԰�;
select * from ��ǰ;


      
select * from departments;    
drop table sales_dept;
delete from departments where department_id<10 ;
commit;
      

      
      
      
      
      
      
        