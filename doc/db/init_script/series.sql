truncate table kom_manager.T_SERIES;
INSERT INTO kom_manager.T_SERIES (BRAND_CODE, SERIES_CODE, SERIES_NAME, COMPANY_ID, IS_INACTIVE,CREATED_TIME,UPDATED_TIME )
  SELECT BRAND_CODE, SERIES_CODE, SERIES_NAME, COMPANY_ID, IS_INACTIVE,CREATED_TIME,UPDATED_TIME FROM kom.T_BB_SERIES;
UPDATE kom_manager.T_SERIES SET COMPANY_ID = 2 WHERE BRAND_CODE='TECNO';
UPDATE kom_manager.T_SERIES SET COMPANY_ID = 3 WHERE BRAND_CODE='INFINIX';
UPDATE kom_manager.T_SERIES SET COMPANY_ID = 4 WHERE BRAND_CODE='ITEL';
UPDATE kom_manager.T_SERIES SET CREATED_BY = 'system';
UPDATE kom_manager.T_SERIES SET UPDATED_BY = 'system';
UPDATE kom_manager.T_SERIES SET CREATED_TIME =  NOW() WHERE CREATED_TIME IS NULL;
UPDATE kom_manager.T_SERIES SET UPDATED_TIME = NOW() WHERE UPDATED_TIME IS NULL;
UPDATE kom_manager.T_SERIES SET IS_INACTIVE = 2 WHERE IS_INACTIVE = 1;
UPDATE kom_manager.T_SERIES SET IS_INACTIVE = 1 WHERE IS_INACTIVE = 0;