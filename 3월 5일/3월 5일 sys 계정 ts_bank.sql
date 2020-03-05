CREATE tablespace ts_bank
datafile 'C:\app\kosmo_03\oradata\orcl11\kosmoBANK.dbf' size 100M;

ALTER  database datafile
'C:\app\kosmo_03\oradata\orcl11\kosmoBANK.dbf' resize 80M;

CREATE user bank identified by tiger
default tablespace ts_bank
temporary tablespace temp;

GRANT create session to bank with admin option;


GRANT create table to bank with admin option;

GRANT create view to bank with admin option;

ALTER USER bank quota unlimited on ts_bank;  

GRANT create sequence to bank with admin option;