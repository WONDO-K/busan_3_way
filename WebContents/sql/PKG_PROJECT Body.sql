create or replace PACKAGE BODY PKG_PROJECT AS

  PROCEDURE PROC_STORE_ADD(IN_STORE_ID IN VARCHAR2,IN_STORE_NAME IN VARCHAR2,IN_STORE_GUGUN IN VARCHAR2,IN_STORE_EX IN VARCHAR2,IN_STORE_ADDR IN VARCHAR2,
    IN_STORE_ADDR2 IN VARCHAR2,IN_STORE_TEL IN VARCHAR2,IN_STORE_SITE IN VARCHAR2,IN_STORE_TIME IN VARCHAR2,IN_STORE_MENU IN VARCHAR2,
    IN_STORE_IMG IN VARCHAR2,IN_STORE_THUMB IN VARCHAR2,IN_STORE_CONT IN VARCHAR2) AS
  BEGIN
   INSERT INTO TSTORE(STORE_ID,STORE_NAME,STORE_GUGUN,STORE_EX,STORE_ADDR,STORE_ADDR2,STORE_TEL,STORE_SITE,STORE_TIME,STORE_MENU,STORE_IMG,STORE_THUMB,STORE_CONT)
   VALUES(IN_STORE_ID,IN_STORE_NAME,IN_STORE_GUGUN,IN_STORE_EX,IN_STORE_ADDR,IN_STORE_ADDR2,IN_STORE_TEL,IN_STORE_SITE,IN_STORE_TIME,IN_STORE_MENU,
   IN_STORE_IMG,IN_STORE_THUMB,IN_STORE_CONT);
  END PROC_STORE_ADD;
  
--------------------------------------------------------------------------------------------------------------------------------------------------------------
  PROCEDURE PROC_STORE_MERGE(IN_STORE_ID IN VARCHAR2,IN_STORE_NAME IN VARCHAR2,IN_STORE_GUGUN IN VARCHAR2,IN_STORE_EX IN VARCHAR2,IN_STORE_ADDR IN VARCHAR2,
    IN_STORE_ADDR2 IN VARCHAR2,IN_STORE_TEL IN VARCHAR2,IN_STORE_SITE IN VARCHAR2,IN_STORE_TIME IN VARCHAR2,IN_STORE_MENU IN VARCHAR2,
    IN_STORE_IMG IN VARCHAR2,IN_STORE_THUMB IN VARCHAR2,IN_STORE_CONT IN VARCHAR2) AS
  BEGIN
    MERGE INTO TSTORE
        USING DUAL                --비교할 테이블(동일 테이블로 비교시에는 DUAL사용)
    ON(STORE_ID=IN_STORE_ID)  -- 비교 조건(조건에 사용한 컬럼은 UPDATE 사용 불가능)
    WHEN MATCHED THEN     -- 조건에 맞을시
        UPDATE SET STORE_NAME=IN_STORE_NAME,STORE_GUGUN=IN_STORE_GUGUN,STORE_EX=IN_STORE_GUGUN,
                    STORE_ADDR=STORE_ADDR,STORE_ADDR2=IN_STORE_ADDR2,STORE_TEL=IN_STORE_TEL,
                    STORE_SITE=IN_STORE_SITE,STORE_TIME=IN_STORE_TIME,STORE_MENU=IN_STORE_MENU,
                    STORE_IMG=IN_STORE_IMG,STORE_THUMB=IN_STORE_THUMB,STORE_CONT=IN_STORE_CONT
                    WHERE STORE_ID=IN_STORE_ID
                    DELETE WHERE STORE_ID=IN_STORE_ID
    WHEN NOT MATCHED THEN -- 조건에 맞지 않을 시
     INSERT(STORE_ID,STORE_NAME,STORE_GUGUN,STORE_EX,STORE_ADDR,STORE_ADDR2,STORE_TEL,STORE_SITE,STORE_TIME,STORE_MENU,STORE_IMG,STORE_THUMB,STORE_CONT)
     VALUES(IN_STORE_ID,IN_STORE_NAME,IN_STORE_GUGUN,IN_STORE_EX,IN_STORE_ADDR,IN_STORE_ADDR2,IN_STORE_TEL,IN_STORE_SITE,IN_STORE_TIME,IN_STORE_MENU,
            IN_STORE_IMG,IN_STORE_THUMB,IN_STORE_CONT);

  END PROC_STORE_MERGE;
  
--------------------------------------------------------------------------------------------------------------------------------------------------------------

  PROCEDURE PROC_FESTIVAL_MERGE(IN_FESTIVAL_ID IN VARCHAR2,IN_FESTIVAL_NAME IN VARCHAR2,IN_FESTIVAL_GUGUN IN VARCHAR2,IN_FESTIVAL_PLACE IN VARCHAR2,
                                IN_FESTIVAL_TITLE IN VARCHAR2,IN_FESTIVAL_SUBTITLE IN VARCHAR2,IN_FESTIVAL_MAIN_PLACE IN VARCHAR2,IN_FESTIVAL_ADDR1 IN VARCHAR2,
                                IN_FESTIVAL_ADDR2 IN VARCHAR2,IN_FESTIVAL_TEL IN VARCHAR2,IN_FESTIVAL_SITE IN VARCHAR2,IN_FESTIVAL_TRFC_INFO IN VARCHAR2,
                                IN_FESTIVAL_USAGEDAY IN VARCHAR2,IN_FESTIVAL_TIME IN VARCHAR2,IN_FESTIVAL_USAGE_AMOUNT IN VARCHAR2,IN_FESTIVAL_IMG IN VARCHAR2,
                                IN_FESTIVAL_THUMB IN VARCHAR2,IN_FESTIVAL_CONT IN VARCHAR2,IN_FESITVAL_CONVENIENT IN VARCHAR2) AS
  BEGIN
   MERGE INTO TFESTIVAL
        USING DUAL                       --비교할 테이블(동일 테이블로 비교시에는 DUAL사용)
    ON(FESTIVAL_ID=IN_FESTIVAL_ID)       -- 비교 조건(조건에 사용한 컬럼은 UPDATE 사용 불가능)
    WHEN MATCHED THEN                    -- 조건에 맞을시
    UPDATE SET  FESTIVAL_NAME=IN_FESTIVAL_NAME , FESTIVAL_GUGUN=IN_FESTIVAL_GUGUN, FESTIVAL_PLACE=IN_FESTIVAL_PLACE,
                FESTIVAL_TITLE=IN_FESTIVAL_TITLE, FESTIVAL_SUBTITLE=IN_FESTIVAL_SUBTITLE, FESTIVAL_MAIN_PLACE=IN_FESTIVAL_MAIN_PLACE,
                FESTIVAL_ADDR1=IN_FESTIVAL_ADDR1, FESTIVAL_ADDR2=IN_FESTIVAL_ADDR2, FESTIVAL_TEL=IN_FESTIVAL_TEL, FESTIVAL_SITE=IN_FESTIVAL_SITE, 
                FESTIVAL_TRFC_INFO=IN_FESTIVAL_TRFC_INFO, FESTIVAL_USAGEDAY=IN_FESTIVAL_USAGEDAY, FESTIVAL_TIME=IN_FESTIVAL_TIME, 
                FESTIVAL_USAGE_AMOUNT=IN_FESTIVAL_USAGE_AMOUNT, FESTIVAL_IMG=IN_FESTIVAL_IMG, FESTIVAL_THUMB=IN_FESTIVAL_THUMB, 
                FESTIVAL_CONT=IN_FESTIVAL_CONT, FESITVAL_CONVENIENT=IN_FESITVAL_CONVENIENT
                WHERE FESTIVAL_ID = IN_FESTIVAL_ID    
                DELETE WHERE FESTIVAL_ID = IN_FESTIVAL_ID 
    WHEN NOT MATCHED THEN -- 조건에 맞지 않을 시 
    INSERT (FESTIVAL_ID ,FESTIVAL_NAME, FESTIVAL_GUGUN, FESTIVAL_PLACE,
            FESTIVAL_TITLE ,FESTIVAL_SUBTITLE, FESTIVAL_MAIN_PLACE, FESTIVAL_ADDR1,
            FESTIVAL_ADDR2, FESTIVAL_TEL, FESTIVAL_SITE, FESTIVAL_TRFC_INFO,
            FESTIVAL_USAGEDAY, FESTIVAL_TIME, FESTIVAL_USAGE_AMOUNT, FESTIVAL_IMG,
            FESTIVAL_THUMB, FESTIVAL_CONT, FESITVAL_CONVENIENT)
    VALUES (IN_FESTIVAL_ID, IN_FESTIVAL_NAME, IN_FESTIVAL_GUGUN, IN_FESTIVAL_PLACE,
            IN_FESTIVAL_TITLE ,IN_FESTIVAL_SUBTITLE, IN_FESTIVAL_MAIN_PLACE, IN_FESTIVAL_ADDR1,
            IN_FESTIVAL_ADDR2, IN_FESTIVAL_TEL, IN_FESTIVAL_SITE, IN_FESTIVAL_TRFC_INFO,
            IN_FESTIVAL_USAGEDAY, IN_FESTIVAL_TIME, IN_FESTIVAL_USAGE_AMOUNT, IN_FESTIVAL_IMG,
            IN_FESTIVAL_THUMB, IN_FESTIVAL_CONT, IN_FESITVAL_CONVENIENT);
  END PROC_FESTIVAL_MERGE;
  
--------------------------------------------------------------------------------------------------------------------------------------------------------------

  PROCEDURE PROC_ATTRACTION_MERGE(IN_ATTRACTION_ID IN VARCHAR2, IN_ATTRACTION_NAME IN VARCHAR2, IN_ATTRACTION_GUGUN IN VARCHAR2, IN_ATTRACTION_PLACE IN VARCHAR2,
                                    IN_ATTRACTION_TITLE IN VARCHAR2, IN_ATTRACTION_SUBTITLE IN VARCHAR2, IN_ATTRACTION_ADDR1 IN VARCHAR2, IN_ATTRACTION_TEL IN VARCHAR2,
                                    IN_ATTRACTION_SITE IN VARCHAR2, IN_ATTRACTION_TRFC_INFO IN VARCHAR2, IN_ATTRACTION_USAGEDAY IN VARCHAR2, IN_ATTRACTION_HLDY_INFO IN VARCHAR2,
                                    IN_ATTRACTION_TIME IN VARCHAR2, IN_ATTRACTION_USAGE_AMOUNT IN VARCHAR2, IN_ATTRACTION_CONVENIENT IN VARCHAR2, IN_ATTRACTION_IMG IN VARCHAR2,
                                    IN_ATTRACTION_THUMB IN VARCHAR2, IN_ATTRACTION_CONT1 IN VARCHAR2,IN_ATTRACTION_CONT2 IN VARCHAR2,IN_ATTRACTION_CONT3 IN VARCHAR2,IN_ATTRACTION_CONT4 IN VARCHAR2) AS
  BEGIN
    MERGE INTO TATTRACTION 
        USING DUAL                       --비교할 테이블(동일 테이블로 비교시에는 DUAL사용)
    ON (ATTRACTION_ID=IN_ATTRACTION_ID)    -- 비교 조건(조건에 사용한 컬럼은 UPDATE 사용 불가능)
    WHEN MATCHED THEN                    -- 조건에 맞을시
    UPDATE SET ATTRACTION_NAME=IN_ATTRACTION_NAME, ATTRACTION_GUGUN=IN_ATTRACTION_GUGUN, ATTRACTION_PLACE=IN_ATTRACTION_PLACE, ATTRACTION_TITLE=IN_ATTRACTION_TITLE,
               ATTRACTION_SUBTITLE=IN_ATTRACTION_SUBTITLE, ATTRACTION_ADDR1=IN_ATTRACTION_ADDR1, ATTRACTION_TEL=IN_ATTRACTION_TEL, ATTRACTION_SITE=IN_ATTRACTION_SITE,
               ATTRACTION_TRFC_INFO=IN_ATTRACTION_TRFC_INFO, ATTRACTION_USAGEDAY=IN_ATTRACTION_USAGEDAY, ATTRACTION_HLDY_INFO=IN_ATTRACTION_HLDY_INFO, 
               ATTRACTION_TIME=IN_ATTRACTION_TIME, ATTRACTION_USAGE_AMOUNT=IN_ATTRACTION_USAGE_AMOUNT, ATTRACTION_CONVENIENT=IN_ATTRACTION_CONVENIENT,
               ATTRACTION_IMG=IN_ATTRACTION_IMG, ATTRACTION_THUMB=IN_ATTRACTION_THUMB, ATTRACTION_CONT1=IN_ATTRACTION_CONT1, ATTRACTION_CONT2=IN_ATTRACTION_CONT2 ,ATTRACTION_CONT3=IN_ATTRACTION_CONT3, ATTRACTION_CONT4=IN_ATTRACTION_CONT4
               WHERE ATTRACTION_ID=IN_ATTRACTION_ID
    WHEN NOT MATCHED THEN -- 조건에 맞지 않을 시
    INSERT (ATTRACTION_ID, ATTRACTION_NAME, ATTRACTION_GUGUN, ATTRACTION_PLACE, ATTRACTION_TITLE, ATTRACTION_SUBTITLE, ATTRACTION_ADDR1,
            ATTRACTION_TEL, ATTRACTION_SITE, ATTRACTION_TRFC_INFO, ATTRACTION_USAGEDAY, ATTRACTION_HLDY_INFO, ATTRACTION_TIME,
            ATTRACTION_USAGE_AMOUNT, ATTRACTION_CONVENIENT, ATTRACTION_IMG, ATTRACTION_THUMB, ATTRACTION_CONT1, ATTRACTION_CONT2, ATTRACTION_CONT3, ATTRACTION_CONT4)
    VALUES (IN_ATTRACTION_ID, IN_ATTRACTION_NAME, IN_ATTRACTION_GUGUN, IN_ATTRACTION_PLACE,
            IN_ATTRACTION_TITLE, IN_ATTRACTION_SUBTITLE, IN_ATTRACTION_ADDR1, IN_ATTRACTION_TEL,
            IN_ATTRACTION_SITE, IN_ATTRACTION_TRFC_INFO, IN_ATTRACTION_USAGEDAY, IN_ATTRACTION_HLDY_INFO,
            IN_ATTRACTION_TIME, IN_ATTRACTION_USAGE_AMOUNT, IN_ATTRACTION_CONVENIENT, IN_ATTRACTION_IMG,
            IN_ATTRACTION_THUMB, IN_ATTRACTION_CONT1,IN_ATTRACTION_CONT2, IN_ATTRACTION_CONT3, IN_ATTRACTION_CONT4);      
  END PROC_ATTRACTION_MERGE; 

END PKG_PROJECT;