SELECT deptno, dname, loc
FROM dept

���� : ª�� �ð����� ���� �ű��
SELECT * FROM t_worktime

commit

SELECT time_nu
    FROM t_worktime
    
SELECT time_nu                 -- ��� �׷쿡 �����Ŵ� ?
    FROM t_worktime a, t_worktime b
    
SELECT a.time_nu     --īŸ 9����
    FROM t_worktime a, t_worktime b

SELECT a.time_nu    
    FROM t_worktime a, t_worktime b
WHERE b.time_nu <= a.time_nu

SELECT a.time_nu, b.time_nu    
    FROM t_worktime a, t_worktime b
WHERE b.time_nu <= a.time_nu

SELECT a.time_nu, count(b.time_nu)    --���ϰ� �׷����� �����Ҽ� ���� ���ϴ��� �׷�׷� 
    FROM t_worktime a, t_worktime b
WHERE b.time_nu <= a.time_nu

SELECT max(a.time_nu), count(b.time_nu)    
    FROM t_worktime a, t_worktime b
WHERE b.time_nu <= a.time_nu

SELECT a.time_nu, count(b.time_nu)    
    FROM t_worktime a, t_worktime b
WHERE b.time_nu <= a.time_nu
GROUP BY a.time_nu

SELECT a.time_nu, count(b.time_nu)     
    FROM t_worktime a, t_worktime b
WHERE b.time_nu(+) < a.time_nu
GROUP BY a.time_nu

SELECT a.time_nu, count(b.time_nu)+1     
    FROM t_worktime a, t_worktime b
WHERE b.time_nu(+) < a.time_nu
GROUP BY a.time_nu


DELETE FROM t_worktime
WHERE rownum < 3

1������ 20������ ��ȣ ���̱�

SELECT emp_name FROM temp

SELECT rownum rno, emp_name FROM temp

�ζ��κ�

SELECT  rno ,ceil(rno/4) cno
FROM (SELECT rownum rno, emp_name FROM temp)

SELECT  ceil(rno/4) cno
FROM (SELECT rownum rno, emp_name FROM temp)
GROUP BY  ceil(rno/4)

SELECT rno, ceil(rno/5) cno, mod(rno,5) mno
FROM (SELECT rownum rno, emp_name FROM temp)

SELECT rno, ceil(rno/5) cno, mod(rno,5) mno
        ,decode(mod(rno,5),1,emp_name) name1
FROM (SELECT rownum rno, emp_name FROM temp)

SELECT rno, ceil(rno/5) cno, mod(rno,5) mno
        ,decode(mod(rno,5),1,emp_name) name1
        ,decode(mod(rno,5),2,emp_name) name2
FROM (SELECT rownum rno, emp_name FROM temp)

SELECT rno, ceil(rno/5) cno, mod(rno,5) mno
        ,decode(mod(rno,5),1,emp_name) name1
        ,decode(mod(rno,5),2,emp_name) name2
        ,decode(mod(rno,5),3,emp_name) name3
FROM (SELECT rownum rno, emp_name FROM temp)

SELECT rno, ceil(rno/5) cno, mod(rno,5) mno
        ,decode(mod(rno,5),1,emp_name) name1
        ,decode(mod(rno,5),2,emp_name) name2
        ,decode(mod(rno,5),3,emp_name) name3
        ,decode(mod(rno,5),4,emp_name) name4
FROM (SELECT rownum rno, emp_name FROM temp)

SELECT rno, ceil(rno/5) cno, mod(rno,5) mno
        ,decode(mod(rno,5),1,emp_name) name1
        ,decode(mod(rno,5),2,emp_name) name2
        ,decode(mod(rno,5),3,emp_name) name3
        ,decode(mod(rno,5),4,emp_name) name4
        ,decode(mod(rno,5),0,emp_name) name5 -- �������� 0
FROM (SELECT rownum rno, emp_name FROM temp)

SELECT  ceil(rno/5) cno
        ,decode(mod(rno,5),1,emp_name) name1
        ,decode(mod(rno,5),2,emp_name) name2
        ,decode(mod(rno,5),3,emp_name) name3
        ,decode(mod(rno,5),4,emp_name) name4
        ,decode(mod(rno,5),0,emp_name) name5 
FROM (SELECT rownum rno, emp_name FROM temp)
GROUP BY ceil(rno/5)

SELECT  ceil(rno/5) cno
        ,max(decode(mod(rno,5),1,emp_name)) name1
        ,max(decode(mod(rno,5),2,emp_name)) name2
        ,max(decode(mod(rno,5),3,emp_name)) name3
        ,max(decode(mod(rno,5),4,emp_name)) name4
        ,max(decode(mod(rno,5),0,emp_name)) name5 
FROM (SELECT rownum rno, emp_name FROM temp)
GROUP BY ceil(rno/5)
ORDER BY ceil(rno/5) asc

SELECT  
        decode(job,'CLERK', sal)
       ,decode(job,'SALESMAN',sal,null)
     FROM emp
     
SELECT  
        decode(job,'CLERK', sal)
       ,decode(job,'SALESMAN',sal,null)
     FROM emp
GROUP BY decode(job,'CLERK', sal)
       ,decode(job,'SALESMAN',sal,null) --GROUP BY�ص� �ϳ����� 
       
SELECT  
        sum(decode(job,'CLERK', sal))
       ,sum(decode(job,'SALESMAN',sal,null))
     FROM emp

null     
HOBBY�� NULL �Ǵ� ����� ��츦 ����Ͻÿ�

SELECT * FROM temp

SELECT emp_name, hobby 
FROM temp
WHERE hobby IN('���','����')

SELECT emp_name, hobby 
FROM temp
WHERE hobby IN('���',null)

SELECT emp_name, hobby 
FROM temp
WHERE hobby IN(null,'���')