


insert into ACCT_ROLE values(1,'admin');
insert into ACCT_ROLE values(2,'user');
insert into ACCT_ROLE values(3,'manager');



insert into ACCT_AUTHIRITY values(1,'admin','1');
insert into ACCT_AUTHIRITY values(2,'login','2');
insert into ACCT_AUTHIRITY values(3,'webservice','3');
insert into ACCT_AUTHIRITY values(4,'timer','4');


insert into ROLE_AUTH_MIDDLE  values(1,1,1);
insert into ROLE_AUTH_MIDDLE  values(2,2,2);
insert into ROLE_AUTH_MIDDLE  values(3,2,3);

---- 外键关联的放到最后
insert into ACC_USER(ID,LOG_NAME,NAME,PWD,ROLE_ID) values(1,'admin','admin','admin',1);

commit;


