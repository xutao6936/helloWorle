/*==============================================================*/
/* DBMS name:      ORACLE Version 9i2                           */
/* Created on:     2014-03-28 11:08:49                          */
/*==============================================================*/


  
    
    
create sequence SEQ_ANAES_METHOD
increment by 1
start with 50;

create sequence SEQ_DIAGNOSIS
increment by 1
start with 50;

create sequence SEQ_DICT
increment by 1
start with 50;

create sequence SEQ_OPERATOR
increment by 1
start with 50;

create sequence SEQ_OPERATROOM
increment by 1
start with 50;

create sequence SEQ_REG_OPT
increment by 1
start with 50;

create sequence SEQ_REG_SHADOW
increment by 1
start with 50;

create sequence SEQ_ROLE
increment by 1
start with 50;

create sequence SEQ_SURGICAL
increment by 1
start with 50;

create sequence SEQ_USER
increment by 1
start with 50;

/*==============================================================*/
/* Table: ACCT_ANAES_METHOD                                     */
/*==============================================================*/
create table ACCT_ANAES_METHOD  (
   CODE                 NUMBER(20)                      not null,
   NAME                 VARCHAR2(50),
   ENABLE               CHAR(2)
);

alter table ACCT_ANAES_METHOD
   add constraint PK_ACCT_ANAES_METHOD primary key (CODE);

/*==============================================================*/
/* Table: ACCT_DIAGNOSIS                                        */
/*==============================================================*/
create table ACCT_DIAGNOSIS  (
   CODE                 NUMBER(20)                      not null,
   NAME                 VARCHAR2(40),
   ENABLE               CHAR(2),
   SOURCE_CODE          VARCHAR2(20),
   SOURCE_NAME          VARCHAR2(40),
   PINYIN               VARCHAR2(40)
);

comment on column ACCT_DIAGNOSIS.CODE is
'代码';

comment on column ACCT_DIAGNOSIS.NAME is
'名称';

comment on column ACCT_DIAGNOSIS.ENABLE is
'是否有效';

comment on column ACCT_DIAGNOSIS.SOURCE_CODE is
'来源代码';

comment on column ACCT_DIAGNOSIS.SOURCE_NAME is
'来源名称';

comment on column ACCT_DIAGNOSIS.PINYIN is
'拼音码';

alter table ACCT_DIAGNOSIS
   add constraint PK_ACCT_DIAGNOSIS primary key (CODE);

/*==============================================================*/
/* Index: INDEX_PINYIN                                          */
/*==============================================================*/
create index INDEX_PINYIN on ACCT_DIAGNOSIS (
   PINYIN ASC
);

/*==============================================================*/
/* Table: ACCT_DICT                                             */
/*==============================================================*/
create table ACCT_DICT  (
   CODE                 NUMBER(20)                      not null,
   TYPE_CODE            VARCHAR2(50),
   NAME                 VARCHAR2(50),
   VALUE                VARCHAR2(50),
   ENABLE               VARCHAR(2),
   TYPE_NAME            VARCHAR2(50)
);

comment on column ACCT_DICT.CODE is
'CODE';

comment on column ACCT_DICT.TYPE_CODE is
'大类code';

comment on column ACCT_DICT.NAME is
'名称';

comment on column ACCT_DICT.VALUE is
'值';

comment on column ACCT_DICT.ENABLE is
'是否有效';

comment on column ACCT_DICT.TYPE_NAME is
'大类名称';

alter table ACCT_DICT
   add constraint PK_ACCT_DICT primary key (CODE);

/*==============================================================*/
/* Index: INDEX_TYPE_NAME                                       */
/*==============================================================*/
create index INDEX_TYPE_NAME on ACCT_DICT (
   TYPE_NAME ASC,
   CODE ASC
);

/*==============================================================*/
/* Table: ACCT_OPERATOR                                         */
/*==============================================================*/
create table ACCT_OPERATOR  (
   CODE                 NUMBER(30)                      not null,
   NAME                 VARCHAR2(40),
   ENABLE               CHAR(2),
   SOURCE_CODE          VARCHAR2(30),
   COMPETENCE           VARCHAR2(30)
);

comment on column ACCT_OPERATOR.CODE is
'CODE';

comment on column ACCT_OPERATOR.NAME is
'姓名';

comment on column ACCT_OPERATOR.ENABLE is
'是否有效';

comment on column ACCT_OPERATOR.SOURCE_CODE is
'HIS_CODE';

comment on column ACCT_OPERATOR.COMPETENCE is
'权限码';

alter table ACCT_OPERATOR
   add constraint PK_ACCT_OPERATOR primary key (CODE);

/*==============================================================*/
/* Table: ACCT_OPERATROOM                                       */
/*==============================================================*/
create table ACCT_OPERATROOM  (
   CODE                 NUMBER(20)                      not null,
   NAME                 VARCHAR2(40),
   ENABLE               CHAR(2)
);

alter table ACCT_OPERATROOM
   add constraint PK_ACCT_OPERATROOM primary key (CODE);

/*==============================================================*/
/* Table: ACCT_REG_OPT                                          */
/*==============================================================*/
create table ACCT_REG_OPT  (
   ID                   VARCHAR2(40)                    not null,
   NAME                 VARCHAR2(40),
   SEX                  VARCHAR2(10),
   HID                  VARCHAR2(40),
   AGE                  FLOAT,
   AGE_MONTH            FLOAT,
   SURGICAL_CODE        VARCHAR2(40),
   SURGICAL_NAME        VARCHAR2(40),
   DIALIGS_CODE         VARCHAR2(40),
   DIALIGS_NAME         VARCHAR2(40),
   ANAES_METHOD_CODE    VARCHAR2(40),
   ANAES_METHOD_NAME    VARCHAR2(60),
   OPERROOM             VARCHAR2(40),
   OPER_DATE            DATE,
   CREATE_DATE          TIMESTAMP,
   OPER_TABLE           NUMBER(8),
   CREATE_ID            NUMBER(20),
   SURGICAL_ASSISTANT_CODE VARCHAR2(40),
   SURGICAL_ASSISTANT_NAME VARCHAR2(40),
   INSTRUMENT_NURSE_CODE VARCHAR2(40),
   INSTRUMENT_NURSE_NAME VARCHAR2(40),
   ANESTHE_CODE         VARCHAR2(40),
   ANESTHE_NAME         VARCHAR2(40),
   ANESTHE_ASSISTANT_CODE VARCHAR2(40),
   ANESTHE_ASSISTANT_NAME VARCHAR2(40),
   STATE                VARCHAR2(20),
   SHADOW_ID            VARCHAR2(40)
);

comment on column ACCT_REG_OPT.ID is
'ID';

comment on column ACCT_REG_OPT.NAME is
'姓名';

comment on column ACCT_REG_OPT.SEX is
'性别';

comment on column ACCT_REG_OPT.HID is
'住院号';

comment on column ACCT_REG_OPT.AGE is
'年龄年';

comment on column ACCT_REG_OPT.AGE_MONTH is
'年龄月';

comment on column ACCT_REG_OPT.SURGICAL_CODE is
'手术代码';

comment on column ACCT_REG_OPT.SURGICAL_NAME is
'手术名称';

comment on column ACCT_REG_OPT.DIALIGS_CODE is
'诊断代码';

comment on column ACCT_REG_OPT.DIALIGS_NAME is
'诊断名称';

comment on column ACCT_REG_OPT.ANAES_METHOD_CODE is
'麻醉方法代码';

comment on column ACCT_REG_OPT.ANAES_METHOD_NAME is
'麻醉方法名称';

comment on column ACCT_REG_OPT.OPERROOM is
'手术室';

comment on column ACCT_REG_OPT.OPER_DATE is
'手术日期';

comment on column ACCT_REG_OPT.CREATE_DATE is
'创建时间';

comment on column ACCT_REG_OPT.OPER_TABLE is
'台次';

comment on column ACCT_REG_OPT.CREATE_ID is
'创建人id';

comment on column ACCT_REG_OPT.SURGICAL_ASSISTANT_CODE is
'手术助手代码';

comment on column ACCT_REG_OPT.SURGICAL_ASSISTANT_NAME is
'手术助手名称';

comment on column ACCT_REG_OPT.INSTRUMENT_NURSE_CODE is
'器械护士代码';

comment on column ACCT_REG_OPT.INSTRUMENT_NURSE_NAME is
'器械护士名称';

comment on column ACCT_REG_OPT.ANESTHE_CODE is
'麻醉医生代码';

comment on column ACCT_REG_OPT.ANESTHE_NAME is
'麻醉医生名称';

comment on column ACCT_REG_OPT.ANESTHE_ASSISTANT_CODE is
'麻醉助手代码';

comment on column ACCT_REG_OPT.ANESTHE_ASSISTANT_NAME is
'麻醉助手名称';

comment on column ACCT_REG_OPT.STATE is
'流程状态';

alter table ACCT_REG_OPT
   add constraint PK_ACCT_REG_OPT primary key (ID);

/*==============================================================*/
/* Table: ACCT_REG_SHADOW                                       */
/*==============================================================*/
create table ACCT_REG_SHADOW  (
   ID                   VARCHAR2(40)                    not null,
   NAME                 VARCHAR2(40),
   SEX                  VARCHAR2(10),
   HID                  VARCHAR2(40),
   AGE                  FLOAT,
   AGE_MONTH            FLOAT,
   SURGICAL_CODE        VARCHAR2(40),
   SURGICAL_NAME        VARCHAR2(40),
   DIALIGS_CODE         VARCHAR2(40),
   DIALIGS_NAME         VARCHAR2(40),
   ANAES_METHOD_CODE    VARCHAR2(40),
   ANAES_METHOD_NAME    VARCHAR2(60),
   OPERROOM             VARCHAR2(40),
   OPER_DATE            DATE,
   CREATE_DATE          TIMESTAMP,
   OPER_TABLE           NUMBER(8),
   CREATE_ID            NUMBER(20),
   SURGICAL_ASSISTANT_CODE VARCHAR2(40),
   SURGICAL_ASSISTANT_NAME VARCHAR2(40),
   INSTRUMENT_NURSE_CODE VARCHAR2(40),
   INSTRUMENT_NURSE_NAME VARCHAR2(40),
   ANESTHE_CODE         VARCHAR2(40),
   ANESTHE_NAME         VARCHAR2(40),
   ANESTHE_ASSISTANT_CODE VARCHAR2(40),
   ANESTHE_ASSISTANT_NAME VARCHAR2(40),
   STATE                CHAR(1)
);

comment on column ACCT_REG_SHADOW.ID is
'ID';

comment on column ACCT_REG_SHADOW.NAME is
'姓名';

comment on column ACCT_REG_SHADOW.SEX is
'性别';

comment on column ACCT_REG_SHADOW.HID is
'住院号';

comment on column ACCT_REG_SHADOW.AGE is
'年龄年';

comment on column ACCT_REG_SHADOW.AGE_MONTH is
'年龄月';

comment on column ACCT_REG_SHADOW.SURGICAL_CODE is
'手术代码';

comment on column ACCT_REG_SHADOW.SURGICAL_NAME is
'手术名称';

comment on column ACCT_REG_SHADOW.DIALIGS_CODE is
'诊断代码';

comment on column ACCT_REG_SHADOW.DIALIGS_NAME is
'诊断名称';

comment on column ACCT_REG_SHADOW.ANAES_METHOD_CODE is
'麻醉方法代码';

comment on column ACCT_REG_SHADOW.ANAES_METHOD_NAME is
'麻醉方法名称';

comment on column ACCT_REG_SHADOW.OPERROOM is
'手术室';

comment on column ACCT_REG_SHADOW.OPER_DATE is
'手术日期';

comment on column ACCT_REG_SHADOW.CREATE_DATE is
'创建时间';

comment on column ACCT_REG_SHADOW.OPER_TABLE is
'台次';

comment on column ACCT_REG_SHADOW.CREATE_ID is
'创建人id';

comment on column ACCT_REG_SHADOW.SURGICAL_ASSISTANT_CODE is
'手术助手代码';

comment on column ACCT_REG_SHADOW.SURGICAL_ASSISTANT_NAME is
'手术助手名称';

comment on column ACCT_REG_SHADOW.INSTRUMENT_NURSE_CODE is
'器械护士代码';

comment on column ACCT_REG_SHADOW.INSTRUMENT_NURSE_NAME is
'器械护士名称';

comment on column ACCT_REG_SHADOW.ANESTHE_CODE is
'麻醉医生代码';

comment on column ACCT_REG_SHADOW.ANESTHE_NAME is
'麻醉医生名称';

comment on column ACCT_REG_SHADOW.ANESTHE_ASSISTANT_CODE is
'麻醉助手代码';

comment on column ACCT_REG_SHADOW.ANESTHE_ASSISTANT_NAME is
'麻醉助手名称';

comment on column ACCT_REG_SHADOW.STATE is
'补录状态';

alter table ACCT_REG_SHADOW
   add constraint PK_ACCT_REG_SHADOW primary key (ID);

/*==============================================================*/
/* Index: INDEX_ANESTHE_CODE                                    */
/*==============================================================*/
create index INDEX_ANESTHE_CODE on ACCT_REG_SHADOW (
   ANESTHE_CODE ASC
);

/*==============================================================*/
/* Index: INDEX_ANAES_METHOD                                    */
/*==============================================================*/
create index INDEX_ANAES_METHOD on ACCT_REG_SHADOW (
   ANAES_METHOD_CODE ASC
);

/*==============================================================*/
/* Table: ACCT_ROLE                                             */
/*==============================================================*/
create table ACCT_ROLE  (
   ID                   NUMBER(19)                      not null,
   ROLE_NAME            varchar2(20)                    not null,
   AUTHITIY             VARCHAR2(60),
   ENABLE               CHAR(2)
);

comment on column ACCT_ROLE.ID is
'ID';

comment on column ACCT_ROLE.ROLE_NAME is
'角色名';

comment on column ACCT_ROLE.AUTHITIY is
'权限';
comment on column ACCT_ROLE.ENABLE is
'是否有效';

alter table ACCT_ROLE
   add constraint PK_ACCT_ROLE primary key (ID);

/*==============================================================*/
/* Table: ACCT_SURGICAL_NAME                                    */
/*==============================================================*/
create table ACCT_SURGICAL_NAME  (
   CODE                 NUMBER(20)                      not null,
   NAME                 VARCHAR2(40),
   ENABLE               CHAR(2),
   SOURCE_CODE          VARCHAR2(20),
   SOURCE_NAME          VARCHAR2(40),
   PINYIN               VARCHAR2(40)
);

comment on column ACCT_SURGICAL_NAME.CODE is
'代码';

comment on column ACCT_SURGICAL_NAME.NAME is
'名称';

comment on column ACCT_SURGICAL_NAME.ENABLE is
'是否有效';

comment on column ACCT_SURGICAL_NAME.SOURCE_CODE is
'来源代码';

comment on column ACCT_SURGICAL_NAME.SOURCE_NAME is
'来源名称';

comment on column ACCT_SURGICAL_NAME.PINYIN is
'拼音码';

/*==============================================================*/
/* Index: INDEX_OPER_PINYIN                                     */
/*==============================================================*/
create index INDEX_OPER_PINYIN on ACCT_SURGICAL_NAME (
   PINYIN ASC
);

/*==============================================================*/
/* Table: ACC_USER                                              */
/*==============================================================*/
create table ACC_USER  (
   ID                   NUMBER(20)                      not null,
   LOG_NAME             VARCHAR2(60)                    not null,
   PWD                  VARCHAR2(200),
   NAME                 VARCHAR2(60),
   SALT                 VARCHAR2(200),
   CARETE_DATE          TIMESTAMP,
   ROLE_ID              NUMBER(20),
   ENABLE               CHAR(2),
   EMAIL                VARCHAR2(100)
);

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
comment on column ACC_USER.ENABLE is
'是否有效';

comment on column ACC_USER.EMAIL is
'邮箱';

alter table ACC_USER
   add constraint PK_ACC_USER primary key (ID);

alter table ACC_USER
   add constraint FK_ACC_USER_REFERENCE_ACCT_ROL foreign key (ROLE_ID)
      references ACCT_ROLE (ID);

