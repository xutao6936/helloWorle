/*==============================================================*/
/* DBMS name:      ORACLE Version 9i2                           */
/* Created on:     2014-03-28 11:07:20                          */
/*==============================================================*/


alter table ACC_USER
   drop constraint FK_ACC_USER_REFERENCE_ACCT_ROL;

alter table ACCT_ANAES_METHOD
   drop primary key cascade;

drop table ACCT_ANAES_METHOD cascade constraints;

drop index INDEX_PINYIN;

alter table ACCT_DIAGNOSIS
   drop primary key cascade;

drop table ACCT_DIAGNOSIS cascade constraints;

drop index INDEX_TYPE_NAME;

alter table ACCT_DICT
   drop primary key cascade;

drop table ACCT_DICT cascade constraints;

alter table ACCT_OPERATOR
   drop primary key cascade;

drop table ACCT_OPERATOR cascade constraints;

alter table ACCT_OPERATROOM
   drop primary key cascade;

drop table ACCT_OPERATROOM cascade constraints;

alter table ACCT_REG_OPT
   drop primary key cascade;

drop table ACCT_REG_OPT cascade constraints;

drop index INDEX_ANAES_METHOD;

drop index INDEX_ANESTHE_CODE;

alter table ACCT_REG_SHADOW
   drop primary key cascade;

drop table ACCT_REG_SHADOW cascade constraints;

alter table ACCT_ROLE
   drop primary key cascade;

drop table ACCT_ROLE cascade constraints;

drop index INDEX_OPER_PINYIN;

drop table ACCT_SURGICAL_NAME cascade constraints;

alter table ACC_USER
   drop primary key cascade;

drop table ACC_USER cascade constraints;

drop sequence SEQ_ANAES_METHOD;

drop sequence SEQ_DIAGNOSIS;

drop sequence SEQ_DICT;

drop sequence SEQ_OPERATOR;

drop sequence SEQ_OPERATROOM;

drop sequence SEQ_REG_OPT;

drop sequence SEQ_REG_SHADOW;

drop sequence SEQ_ROLE;

drop sequence SEQ_SURGICAL;

drop sequence SEQ_USER;



