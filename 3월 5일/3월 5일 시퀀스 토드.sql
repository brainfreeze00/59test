select seq_book_no.nextval from dual

-- 동시 접속자가 많은 경우  안전하게 번호를 채번하기  예약번호 

select seq_book_no.currval from dual

select * from member