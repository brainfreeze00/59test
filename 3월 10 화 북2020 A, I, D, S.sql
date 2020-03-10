INSERT FROM book2020(b_no, b_name, b_author, b_publish, b_info)
VALUES(?,?,?,?,?)

SELECT b_no, b_name, b_author, b_publish, b_info
    FROM book2020
    
    
SELECT seq_book_no.nextval FROM dual

INSERT into book2020(b_no, b_name, b_author
                    , b_publish, b_info)
               VALUES(seq_book_no.nextval,'1'
               ,'1','1','1')

delete from book2020 where b_name = '444444'