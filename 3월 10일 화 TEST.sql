SQL활용 과목

SELECT , INSERT , UPDATE , DELETE DML --데이터 조작하기FRONT END

-계정만들기 , BANK, SCOTT, HR

CREATE USER BANK IDENTIFIED BY 1234  --계정만들기 DDL 구조정의

접속권한 부여하기 -- DCL

데이터베이스구현


create view v_emp(e_no, e_name)
as select empno, ename
        from emp
       where deptno = 10
       
SELECT e_no, e_name FROM v_emp


SELECT empno FROM emp

갈무리 후 실행한다음  ctrl+e 하면 실행계획을 볼 수 있다.

힌트문

개발자가 옵티마이저에게 실행계획을 세울때 hint문에 작성된 메모를
참고하여 일하도록 요청 할수 있다.
-- best

SELECT /*+index_desc(emp pk_emp)*/ empno
FROM emp

-- 위가 더 좋음

SELECT empno FROM emp ORDER BY empno desc

empno는 인덱스가 있으므로 테이블을 직접 access하지 않고 데이터를 꺼낼수 있다.

SELECT ename FROM emp

SELECT ename FROM emp
ORDER BY ename asc

create index i_ename on emp(ename)

create index i_hiredate on emp(hiredate)

인덱스가 존재하더라도 그 컬럼을 검색조건에서 사용하지 않으면 
실행계획은 인덱스를 활용하지 않고 검색결과를 조회한다.

SELECT hiredate FROM emp

SELECT hiredate FROM emp
WHERE hiredate>'1986-12-30'

SELECT ename, hiredate FROM emp
WHERE hiredate>'1986-12-30'

인덱스의 전략에 따라서 오라클의 실행계획이 바뀔수 있다.
실행계획이 바뀌면 검색속도에도 영향이 있다.

SELECT hiredate FROM emp -- 필요조건이 있어야만 가능하니 이문장은 실패야
WHERE hiredate>'9999-99-99'

CREATE VIEW emp_dept
AS
SELECT b.dname, b.deptno, a.ename
    FROM emp a, dept b
   WHERE a.deptno = b.deptno
   
SELECT * FROM emp_dept

은행업무 담당자가 원하는 기능이지만 설계단계에서는 누락 되었다.
담당자가 미처 요구사항 정의서에 작성을 누락함.
은행 전산 페이지에 그 업무에 대한 페이지가 없었다.
담당자가 수작업을 해야함.
조인문장을 그 담당자에게 줄 수 없었다.
뷰를 만들고 
그 담당자에게 

SELECT * FROM emp_dept

실행했을 때 조회 결과를 확인할 수 있다.

SELECT 
        gm.name_vc, gm.point_nu-gp.point_nu
FROM t_giftpoint gp, t_giftmem gm
WHERE gp.point_nu <= gm.point_nu
  AND gp.name_vc ='영화티켓'
  

SELECT point_nu 
FROM t_giftpoint 
WHERE name_vc='영화티켓'  

--속도 개선
  
SELECT 
        gm.name_vc, gm.point_nu-gp.point_nu
FROM (SELECT point_nu 
        FROM t_giftpoint 
        WHERE name_vc='영화티켓') gp
        , t_giftmem gm
WHERE gp.point_nu <= gm.point_nu

--변수화

SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename ='SCOTT')

--직접적

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