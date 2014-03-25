/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2013/12/16 11:55:22                          */
/*==============================================================*/


alter table ACC_USER
   drop constraint FK_ACC_USER_REFERENCE_ACCT_ROL;

alter table ROLE_AUTH_MIDDLE
   drop constraint FK_ROLE_AUT_REFERENCE_ACCT_ROL;

alter table ROLE_AUTH_MIDDLE
   drop constraint FK_ROLE_AUT_REFERENCE_ACCT_AUT;

alter table ACCT_AUTHIRITY
   drop primary key cascade;

drop table ACCT_AUTHIRITY cascade constraints;

alter table ACCT_ROLE
   drop primary key cascade;

drop table ACCT_ROLE cascade constraints;

alter table ACC_USER
   drop primary key cascade;

drop table ACC_USER cascade constraints;

alter table ROLE_AUTH_MIDDLE
   drop primary key cascade;

drop table ROLE_AUTH_MIDDLE cascade constraints;

drop sequence SEQ_AUTH;

drop sequence SEQ_AUTH_ROLE;

drop sequence SEQ_ROLE;

drop sequence SEQ_USER;

create sequence SEQ_AUTH
increment by 1
start with 50;

create sequence SEQ_AUTH_ROLE
increment by 1
start with 50;

create sequence SEQ_ROLE
increment by 1
start with 50;

create sequence SEQ_USER
increment by 1
start with 50;

/*==============================================================*/
/* Table: ACCT_AUTHIRITY                                        */
/*==============================================================*/
create table ACCT_AUTHIRITY 
(
   ID                   NUMBER(19)           not null,
   AUTH_NAME            VARCHAR2(30)         not null,
   AUTH_CODE            VARCHAR2(30)         not null
);

comment on table ACCT_AUTHIRITY is
'权限表';

comment on column ACCT_AUTHIRITY.ID is
'ID';

comment on column ACCT_AUTHIRITY.AUTH_NAME is
'权限名称';

comment on column ACCT_AUTHIRITY.AUTH_CODE is
'权限代码';

alter table ACCT_AUTHIRITY
   add constraint PK_ACCT_AUTHIRITY primary key (ID);

/*==============================================================*/
/* Table: ACCT_ROLE                                             */
/*==============================================================*/
create table ACCT_ROLE 
(
   ID                   NUMBER(19)           not null,
   ROLE_NAME            varchar2(20)         not null
);

comment on table ACCT_ROLE is
'角色表';

comment on column ACCT_ROLE.ID is
'ID';

comment on column ACCT_ROLE.ROLE_NAME is
'角色名';

alter table ACCT_ROLE
   add constraint PK_ACCT_ROLE primary key (ID);

/*==============================================================*/
/* Table: ACC_USER                                              */
/*==============================================================*/
create table ACC_USER 
(
   ID                   NUMBER(19)           not null,
   LOG_NAME             varchar2(20)         not null,
   PWD                  varchar2(30),
   NAME                 varchar2(20),
   SALT                 VARCHAR2(40),
   CARETE_DATE          TIMESTAMP,
   ROLE_ID              NUMBER(19)
);

comment on table ACC_USER is
'用户';

comment on column ACC_USER.ID is
'ID';

comment on column ACC_USER.LOG_NAME is
'用户名';

comment on column ACC_USER.PWD is
'密码';

comment on column ACC_USER.NAME is
'姓名';

comment on column ACC_USER.SALT is
'SALT';

comment on column ACC_USER.CARETE_DATE is
'注册日期';

comment on column ACC_USER.ROLE_ID is
'角色ID';

alter table ACC_USER
   add constraint PK_ACC_USER primary key (ID);

/*==============================================================*/
/* Table: ROLE_AUTH_MIDDLE                                      */
/*==============================================================*/
create table ROLE_AUTH_MIDDLE 
(
   ID                   NUMBER(19)           not null,
   ROLE_ID              NUMBER(19),
   AUTH_ID              NUMBER(19)
);

comment on table ROLE_AUTH_MIDDLE is
'角色权限中间表';

comment on column ROLE_AUTH_MIDDLE.ID is
'ID';

comment on column ROLE_AUTH_MIDDLE.ROLE_ID is
'角色id';

comment on column ROLE_AUTH_MIDDLE.AUTH_ID is
'权限id';

alter table ROLE_AUTH_MIDDLE
   add constraint PK_ROLE_AUTH_MIDDLE primary key (ID);

alter table ACC_USER
   add constraint FK_ACC_USER_REFERENCE_ACCT_ROL foreign key (ROLE_ID)
      references ACCT_ROLE (ID);

alter table ROLE_AUTH_MIDDLE
   add constraint FK_ROLE_AUT_REFERENCE_ACCT_ROL foreign key (ROLE_ID)
      references ACCT_ROLE (ID);

alter table ROLE_AUTH_MIDDLE
   add constraint FK_ROLE_AUT_REFERENCE_ACCT_AUT foreign key (AUTH_ID)
      references ACCT_AUTHIRITY (ID);

