create table bankaccount(
    ba_no number(10) constraints bank_no_pk  primary key
    ,daccnumber varchar2(20)
    ,waccnumber varchar2(20)
    ,withdraw number(10) default 0
    ,deposit number(10) default 0
    ,dealdate varchar2(20)
    ,withdrawmsg varchar2(30)
    ,depositmsg varchar2(30)
    ,mem_id varchar2(10)
    ,constraints mem_id_fk foreign key(mem_id) references member(mem_id)
)