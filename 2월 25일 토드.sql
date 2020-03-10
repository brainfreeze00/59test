SELECT deptno, dname, loc
FROM dept

문제 : 짧은 시간으로 순위 매기기
SELECT * FROM t_worktime

commit

SELECT time_nu
    FROM t_worktime
    
SELECT time_nu                 -- 어디 그룹에 넣을거니 ?
    FROM t_worktime a, t_worktime b
    
SELECT a.time_nu     --카타 9가지
    FROM t_worktime a, t_worktime b

SELECT a.time_nu    
    FROM t_worktime a, t_worktime b
WHERE b.time_nu <= a.time_nu

SELECT a.time_nu, b.time_nu    
    FROM t_worktime a, t_worktime b
WHERE b.time_nu <= a.time_nu

SELECT a.time_nu, count(b.time_nu)    --단일과 그룹형은 공존할순 없다 단일단일 그룹그룹 
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

1번부터 20번까지 번호 붙이기

SELECT emp_name FROM temp

SELECT rownum rno, emp_name FROM temp

인라인뷰

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
        ,decode(mod(rno,5),0,emp_name) name5 -- 마지막은 0
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
       ,decode(job,'SALESMAN',sal,null) --GROUP BY해도 하나마나 
       
SELECT  
        sum(decode(job,'CLERK', sal))
       ,sum(decode(job,'SALESMAN',sal,null))
     FROM emp

null     
HOBBY가 NULL 또는 등산인 경우를 출력하시오

SELECT * FROM temp

SELECT emp_name, hobby 
FROM temp
WHERE hobby IN('등산','낚시')

SELECT emp_name, hobby 
FROM temp
WHERE hobby IN('등산',null)

SELECT emp_name, hobby 
FROM temp
WHERE hobby IN(null,'등산')