SQLȰ�� ����

SELECT , INSERT , UPDATE , DELETE DML --������ �����ϱ�FRONT END

-��������� , BANK, SCOTT, HR

CREATE USER BANK IDENTIFIED BY 1234  --��������� DDL ��������

���ӱ��� �ο��ϱ� -- DCL

�����ͺ��̽�����


create view v_emp(e_no, e_name)
as select empno, ename
        from emp
       where deptno = 10
       
SELECT e_no, e_name FROM v_emp


SELECT empno FROM emp

������ �� �����Ѵ���  ctrl+e �ϸ� �����ȹ�� �� �� �ִ�.

��Ʈ��

�����ڰ� ��Ƽ���������� �����ȹ�� ���ﶧ hint���� �ۼ��� �޸�
�����Ͽ� ���ϵ��� ��û �Ҽ� �ִ�.
-- best

SELECT /*+index_desc(emp pk_emp)*/ empno
FROM emp

-- ���� �� ����

SELECT empno FROM emp ORDER BY empno desc

empno�� �ε����� �����Ƿ� ���̺��� ���� access���� �ʰ� �����͸� ������ �ִ�.

SELECT ename FROM emp

SELECT ename FROM emp
ORDER BY ename asc

create index i_ename on emp(ename)

create index i_hiredate on emp(hiredate)

�ε����� �����ϴ��� �� �÷��� �˻����ǿ��� ������� ������ 
�����ȹ�� �ε����� Ȱ������ �ʰ� �˻������ ��ȸ�Ѵ�.

SELECT hiredate FROM emp

SELECT hiredate FROM emp
WHERE hiredate>'1986-12-30'

SELECT ename, hiredate FROM emp
WHERE hiredate>'1986-12-30'

�ε����� ������ ���� ����Ŭ�� �����ȹ�� �ٲ�� �ִ�.
�����ȹ�� �ٲ�� �˻��ӵ����� ������ �ִ�.

SELECT hiredate FROM emp -- �ʿ������� �־�߸� �����ϴ� �̹����� ���о�
WHERE hiredate>'9999-99-99'

CREATE VIEW emp_dept
AS
SELECT b.dname, b.deptno, a.ename
    FROM emp a, dept b
   WHERE a.deptno = b.deptno
   
SELECT * FROM emp_dept

������� ����ڰ� ���ϴ� ��������� ����ܰ迡���� ���� �Ǿ���.
����ڰ� ��ó �䱸���� ���Ǽ��� �ۼ��� ������.
���� ���� �������� �� ������ ���� �������� ������.
����ڰ� ���۾��� �ؾ���.
���ι����� �� ����ڿ��� �� �� ������.
�並 ����� 
�� ����ڿ��� 

SELECT * FROM emp_dept

�������� �� ��ȸ ����� Ȯ���� �� �ִ�.

SELECT 
        gm.name_vc, gm.point_nu-gp.point_nu
FROM t_giftpoint gp, t_giftmem gm
WHERE gp.point_nu <= gm.point_nu
  AND gp.name_vc ='��ȭƼ��'
  

SELECT point_nu 
FROM t_giftpoint 
WHERE name_vc='��ȭƼ��'  

--�ӵ� ����
  
SELECT 
        gm.name_vc, gm.point_nu-gp.point_nu
FROM (SELECT point_nu 
        FROM t_giftpoint 
        WHERE name_vc='��ȭƼ��') gp
        , t_giftmem gm
WHERE gp.point_nu <= gm.point_nu

--����ȭ

SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename ='SCOTT')

--������

SELECT ename, sal   
FROM emp
WHERE sal > 4752

SELECT table_name, sum(b_size) table_size
FROM (SELECT table_name, 
        CASE WHEN DATA_TYPE = 'VARCHAR2' THEN DATA_LENGTH
             WHEN DATA_TYPE = 'DATE' THEN 7
        END AS b_size
        FROM all_tab_columns
        WHERE owner = 'SCOTT'AND table_name='DEPT')
        GROUP BY table_name

SELECT table_name, sum(b_size) table_size
FROM (SELECT table_name, 
        CASE WHEN DATA_TYPE = 'VARCHAR2' THEN DATA_LENGTH
             WHEN DATA_TYPE = 'NUMBER' THEN DATA_LENGTH
             WHEN DATA_TYPE = 'DATE' THEN 7 --2020-03-09     
        END AS b_size
        FROM all_tab_columns
        WHERE owner = 'SCOTT'AND table_name='DEPT')
        GROUP BY table_name
        
SELECT table_name, sum(b_size) table_size
FROM (SELECT table_name, 
        CASE WHEN DATA_TYPE = 'VARCHAR2' THEN DATA_LENGTH
             WHEN DATA_TYPE = 'NUMBER' THEN DATA_LENGTH
             WHEN DATA_TYPE = 'DATE' THEN 7 --2020-03-09     
        END AS b_size
        FROM all_tab_columns
        WHERE owner = 'SCOTT'AND table_name='EMP')
        GROUP BY table_name        

SELECT table_name, sum(b_size) table_size
FROM (SELECT table_name, 
        CASE WHEN DATA_TYPE = 'VARCHAR2' THEN DATA_LENGTH
             WHEN DATA_TYPE = 'NUMBER' 
             THEN 2+(DATA_LENGTH+NVL(DATA_PRECISION,0)
             WHEN DATA_TYPE = 'DATE' THEN 7
        END AS b_size
        FROM all_tab_columns
        WHERE owner = 'SCOTT'AND table_name='DEPT')
        GROUP BY table_name
        
SELECT mem_id, mem_name FROM bank.member