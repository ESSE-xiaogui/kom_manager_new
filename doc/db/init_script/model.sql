truncate table kom_manager.T_MODEL;
INSERT INTO kom_manager.T_MODEL (BRAND_CODE, SERIES_CODE, MODEL_CODE, MODEL_NAME, COMPANY_ID,SALE_TIME, PRICE_SCALE,ELEMENT_TYPE,ELEMENT_CODE, IS_INACTIVE,CREATED_TIME,UPDATED_TIME )
  SELECT BRAND_CODE, SERIES_CODE, MODEL_MAT_CODE, MODEL_MAT_NAME, COMPANY_ID,SALE_TIME, PRICE_SCALE,ELEMENT_TYPE,ELEMENT_CODE, IS_INACTIVE,CREATED_TIME,UPDATED_TIME FROM kom.T_BB_BOM_ELEMENTS;
UPDATE kom_manager.T_MODEL SET COMPANY_ID = 2 WHERE BRAND_CODE='TECNO';
UPDATE kom_manager.T_MODEL SET COMPANY_ID = 3 WHERE BRAND_CODE='INFINIX';
UPDATE kom_manager.T_MODEL SET COMPANY_ID = 4 WHERE BRAND_CODE='ITEL';
UPDATE kom_manager.T_MODEL SET CREATED_BY = 'system';
UPDATE kom_manager.T_MODEL SET UPDATED_BY = 'system';
UPDATE kom_manager.T_MODEL SET CREATED_TIME =  NOW() WHERE CREATED_TIME IS NULL;
UPDATE kom_manager.T_MODEL SET UPDATED_TIME = NOW() WHERE UPDATED_TIME IS NULL;
UPDATE kom_manager.T_MODEL SET IS_INACTIVE = 2 WHERE IS_INACTIVE = 1;
UPDATE kom_manager.T_MODEL SET IS_INACTIVE = 1 WHERE IS_INACTIVE = 0;
#update brnad id
UPDATE kom_manager.T_MODEL model, kom_manager.T_BRAND brand SET model.BRAND_ID = brand.ID WHERE model.BRAND_CODE = brand.BRAND_CODE;

#########remove duplicated model
#select repeat model
(select modelA.ID ,modelA.MODEL_CODE from T_MODEL modelA where modelA.MODEL_CODE
in (select  modelB.MODEL_CODE from T_MODEL modelB group by  modelB.MODEL_CODE HAVING count(*)>1) ORDER BY  modelA.ID);

#select min model id
(select min(modelA.ID), modelA.MODEL_CODE from T_MODEL modelA where modelA.MODEL_CODE
in (select  modelB.MODEL_CODE from T_MODEL modelB group by  modelB.MODEL_CODE HAVING count(*)>1) group by  modelA.MODEL_CODE ORDER BY  modelA.ID);

DROP TABLE T_TEMP_MODEL;

CREATE TEMPORARY TABLE IF NOT EXISTS T_TEMP_MODEL AS 
select  model.ID from T_MODEL model where model.ID 
IN
(select modelA.ID from T_MODEL modelA where modelA.MODEL_CODE
in (select  modelB.MODEL_CODE from T_MODEL modelB group by  modelB.MODEL_CODE HAVING count(*)>1))

AND model.ID  NOT IN
(select min(modelC.ID) from T_MODEL modelC where modelC.MODEL_CODE
in (select  modelD.MODEL_CODE from T_MODEL modelD group by  modelD.MODEL_CODE HAVING count(*)>1)group by  modelC.MODEL_CODE);

DELETE FROM T_MODEL WHERE ID IN (SELECT * FROM T_TEMP_MODEL);
DROP TABLE T_TEMP_MODEL;