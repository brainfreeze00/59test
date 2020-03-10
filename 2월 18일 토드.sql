SELECT * FROM dept

SELECT deptno, dname, loc FROM dept WHERE deptno = 61;

INSERT INTO dept(deptno,dname,loc) values(61,'개발부','서울')

commit

rollback

UPDATE dept SET dname = '형상관리부', loc = '경기' 
WHERE deptno = 61

SELECT * FROM dept

DELETE FROM dept WHERE deptno = 50

DELETE FROM dept WHERE deptno = 61

commit

SELECT * FROM dept 

INSERT INTO dept(deptno,dname,loc) values(50,'서울','부산')

--select의 반환값은 VO 1 row  OR VO[] n row    executeQuery():RS
--insert into dept values(?,?,?)  파라미터 3개
--update dept set dname = ? , loc = ? , deptno = ? 있는것을 변경 다만 수정할때 파라미터가 3개필요
--delete from dept where deptno = ? 있는것을 삭제하는 것 파라미터 1개
--executeUpdate()  : 반환 타입 int , NUMBER
--반환값이 0 이면 실행 안됨 1이면 실행됨

