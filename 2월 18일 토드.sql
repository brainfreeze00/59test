SELECT * FROM dept

SELECT deptno, dname, loc FROM dept WHERE deptno = 61;

INSERT INTO dept(deptno,dname,loc) values(61,'���ߺ�','����')

commit

rollback

UPDATE dept SET dname = '���������', loc = '���' 
WHERE deptno = 61

SELECT * FROM dept

DELETE FROM dept WHERE deptno = 50

DELETE FROM dept WHERE deptno = 61

commit

SELECT * FROM dept 

INSERT INTO dept(deptno,dname,loc) values(50,'����','�λ�')

--select�� ��ȯ���� VO 1 row  OR VO[] n row    executeQuery():RS
--insert into dept values(?,?,?)  �Ķ���� 3��
--update dept set dname = ? , loc = ? , deptno = ? �ִ°��� ���� �ٸ� �����Ҷ� �Ķ���Ͱ� 3���ʿ�
--delete from dept where deptno = ? �ִ°��� �����ϴ� �� �Ķ���� 1��
--executeUpdate()  : ��ȯ Ÿ�� int , NUMBER
--��ȯ���� 0 �̸� ���� �ȵ� 1�̸� �����

