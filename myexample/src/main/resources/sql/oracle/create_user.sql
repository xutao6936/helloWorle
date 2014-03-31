
drop tablespace TRACKAO_TAB including contents cascade constraints;
drip user MYEXAMPLE cascade;
--- 创建命名空间

create  tablespace TRACKAO_TAB
datafile 'D:\oracle\oradata\orcl\trackao.dbf'
size 10M
reuse
 autoextend on
    next 5
    maxsize UNLIMITED;

-----创建用户
-- Create the user 
create user MYEXAMPLE   
  IDENTIFIED BY MYEXAMPLE
  default tablespace TRACKAO_TAB
  temporary tablespace TEMP
  profile DEFAULT;
-- Grant/Revoke role privileges 
grant connect to MYEXAMPLE with admin option;
grant dba to MYEXAMPLE with admin option;
-- Grant/Revoke system privileges 
grant unlimited tablespace to MYEXAMPLE with admin option;
  