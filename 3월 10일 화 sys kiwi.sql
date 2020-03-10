CREATE USER KIWI IDENTIFIED BY tiger;


SELECT username, account_status
    FROM dba_user;
    
alter user kiwi account lock;

alter user kiwi account unlock;

grant create session to kiwi with admin option;

grant create table to kiwi with admin option;

grant connect, resource, create view to kiwi;

grant connect, resource, create view to scott;

drop user kiwi;

grant select on bank.member to scott;

grant select, update, delete on bank.member to scott;