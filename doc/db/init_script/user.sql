truncate table kom_manager.T_USER;
#system/admin user
INSERT INTO `kom_manager`.`T_USER` (`USER_ID`, `USER_CODE`, `USER_NAME`, `EMP_ID`, `COMPANY_ID`, `DUTY_ID`, `PASSWORD`, `USER_CATEGORY`, `FORBIDDEN_TIME`, `PWD_UPDATED`, `LOGIN_TIMES`, `LAST_LOGIN`, `IS_ONLINE`, `IS_INACTIVE`, `REMARK`, `CREATED_BY`, `CREATED_TIME`, `UPDATED_BY`, `UPDATED_TIME`, `VERSION`) VALUES ('0', 'system', 'system', '0', '0', '0', '3E2D3E1D3D300F', '10070005', '2017-02-06 17:53:23', '2017-01-08 08:00:00', '0', '2017-02-06 17:53:23', '0', '1', NULL, 'syetem', '2016-11-23 15:59:23', 'syetem', '2017-02-06 17:53:23', '0');
INSERT INTO `kom_manager`.`T_USER` (`USER_ID`, `USER_CODE`, `USER_NAME`, `EMP_ID`, `COMPANY_ID`, `DUTY_ID`, `PASSWORD`, `USER_CATEGORY`, `FORBIDDEN_TIME`, `PWD_UPDATED`, `LOGIN_TIMES`, `LAST_LOGIN`, `IS_ONLINE`, `IS_INACTIVE`, `REMARK`, `CREATED_BY`, `CREATED_TIME`, `UPDATED_BY`, `UPDATED_TIME`, `VERSION`) VALUES ('0', 'admin', 'admin', '0', '0', '0', '3E2D3E1D3D300F', '10070005', '2017-02-06 17:53:23', '2017-01-08 08:00:00', '0', '2017-02-06 17:53:23', '0', '1', NULL, 'syetem', '2016-11-23 15:59:23', 'syetem', '2017-02-06 17:53:23', '0');
UPDATE kom_manager.T_USER SET IS_INACTIVE = 1 WHERE USER_CODE ='system';
UPDATE kom_manager.T_USER SET IS_INACTIVE = 1 WHERE USER_CODE ='admin';

INSERT INTO kom_manager.T_USER (USER_ID, USER_CODE, USER_NAME, EMP_ID, COMPANY_ID, DUTY_ID, PASSWORD,USER_CATEGORY,FORBIDDEN_TIME, PWD_UPDATED,LOGIN_TIMES,LAST_LOGIN,IS_ONLINE,IS_INACTIVE,REMARK,CREATED_TIME,UPDATED_TIME )
  SELECT USER_ID, USER_CODE, USER_NAME, EMP_ID, COMPANY_ID, DUTY_ID, PASSWORD,USER_CATEGORY,FORBIDDEN_TIME, PWD_UPDATED_DATE,LOGIN_TIMES,LAST_LOGIN_TIME,IS_ONLINE,IS_INACTIVE,REMARK,CREATED_TIME,UPDATED_TIME FROM kom.DT_PV_USERS;

INSERT INTO  T_USER
( `USER_CODE`, `USER_NAME`, `EMP_ID`, `COMPANY_ID`, `DUTY_ID`, `PASSWORD`, `USER_CATEGORY`,
 `FORBIDDEN_TIME`, `PWD_UPDATED`, `LOGIN_TIMES`, `LAST_LOGIN`, `IS_ONLINE`, `IS_INACTIVE`, `REMARK`, `CREATED_BY`, 
`CREATED_TIME`, `UPDATED_BY`, `UPDATED_TIME`, `VERSION`) VALUES 
( 'Imanager', NULL, NULL, '4', '51', '3E2D3E1D3D300F', NULL, '2017-03-20 11:30:50', '2017-03-20 11:30:50',
 NULL, '2017-03-20 11:30:50', '0', '1', NULL, 'admin', '2017-03-20 11:44:22', NULL, '2017-03-20 11:30:50', '0');

INSERT INTO  T_USER
(`USER_CODE`, `USER_NAME`, `EMP_ID`, `COMPANY_ID`, `DUTY_ID`, `PASSWORD`, `USER_CATEGORY`, 
`FORBIDDEN_TIME`, `PWD_UPDATED`, `LOGIN_TIMES`, `LAST_LOGIN`, `IS_ONLINE`, `IS_INACTIVE`, `REMARK`, `CREATED_BY`,
 `CREATED_TIME`, `UPDATED_BY`, `UPDATED_TIME`, `VERSION`) VALUES 
('Infmanager', NULL, NULL, '3', '41', '3E2D3E1D3D300F', NULL, '2017-03-20 11:31:09', '2017-03-20 11:31:09',
 NULL, '2017-03-20 11:31:09', '0', '1', NULL, 'admin', '2017-03-20 11:45:22', NULL, '2017-03-20 11:31:09', '0');

UPDATE kom_manager.T_USER SET COMPANY_ID = 5 WHERE COMPANY_ID = 2000;
UPDATE kom_manager.T_USER SET COMPANY_ID = 6 WHERE COMPANY_ID = 3000;
UPDATE kom_manager.T_USER SET COMPANY_ID = 2 WHERE COMPANY_ID = 1000 OR COMPANY_ID = 0 OR COMPANY_ID IS NULL;
UPDATE kom_manager.T_USER SET CREATED_BY = 'system';
UPDATE kom_manager.T_USER SET UPDATED_BY = 'system';
UPDATE kom_manager.T_USER SET IS_INACTIVE = 2 WHERE IS_INACTIVE = 1;
UPDATE kom_manager.T_USER SET IS_INACTIVE = 1 WHERE IS_INACTIVE = 0;