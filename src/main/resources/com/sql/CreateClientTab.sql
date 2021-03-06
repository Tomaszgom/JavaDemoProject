--------------------------------------------------------
--  DDL for Table CLIENT
--------------------------------------------------------

  CREATE TABLE "HR"."CLIENT" 
   (	"CLIENT_ID" NUMBER(*,0), 
	"FIRST_NAME" VARCHAR2(35 BYTE), 
	"LAST_NAME" VARCHAR2(35 BYTE), 
	"CITY" VARCHAR2(35 BYTE), 
	"POINTS" NUMBER, 
	"LAST_LOGIN_DATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HR.CLIENT
SET DEFINE OFF;
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (8,'Fidel','Castro','Hawana',null,to_date('01-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (9,'Jan','Doe','Warszawa',5,to_date('31-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (10,'Chris','Fast','Warszawa',40,to_date('01-MAY-18','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (11,'Elvis','Presley','Memphis',10,to_date('10-OCT-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (12,null,'White','New York',101,to_date('31-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (13,'Daniel','Craig','Moscow',22,to_date('20-MAR-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (14,'Tom','Hardy','Dublin',40,to_date('26-SEP-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (15,'Fidel','Castro','Hawana',null,to_date('01-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (16,'Jan','Doe','Warszawa',5,to_date('31-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (17,'Chris','Fast','Warszawa',40,to_date('01-MAY-18','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (18,'Elvis','Presley','Memphis',10,to_date('10-OCT-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (19,'John','White','New York',101,to_date('31-DEC-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (20,'Daniel','Craig','Moscow',22,to_date('20-MAR-17','DD-MON-RR'));
Insert into HR.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,CITY,POINTS,LAST_LOGIN_DATE) values (21,'Tom','Hardy','Dublin',40,to_date('26-SEP-17','DD-MON-RR'));
--------------------------------------------------------
--  DDL for Index CLIENTID
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."CLIENTID" ON "HR"."CLIENT" ("CLIENT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table CLIENT
--------------------------------------------------------

  ALTER TABLE "HR"."CLIENT" ADD CONSTRAINT "CLIENTID" PRIMARY KEY ("CLIENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
