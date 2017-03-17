truncate table kom_manager.T_USER_ROLE;

INSERT INTO kom_manager.T_USER_ROLE ( USER_ID, ROLE_ID, IS_INACTIVE)
  SELECT ID, DUTY_ID, IS_INACTIVE FROM kom_manager.T_USER;

SELECT ROLE_ID, count(*) FROM kom_manager.T_USER_ROLE group by ROLE_ID;

#ROLE_ID
UPDATE kom_manager.T_USER_ROLE userRole, T_USER user  SET ROLE_ID = 2 WHERE ROLE_ID = 10001100 and user.ID = userRole.USER_ID AND user.COMPANY_ID=2;
UPDATE kom_manager.T_USER_ROLE userRole, T_USER user  SET ROLE_ID = 3 WHERE ROLE_ID = 10001005 and user.ID = userRole.USER_ID AND user.COMPANY_ID=2;
UPDATE kom_manager.T_USER_ROLE userRole, T_USER user  SET ROLE_ID = 4 WHERE ROLE_ID = 10001002 and user.ID = userRole.USER_ID AND user.COMPANY_ID=2;
UPDATE kom_manager.T_USER_ROLE userRole, T_USER user  SET ROLE_ID = 4 WHERE ROLE_ID = 10001004 and user.ID = userRole.USER_ID AND user.COMPANY_ID=2;
UPDATE kom_manager.T_USER_ROLE userRole, T_USER user  SET ROLE_ID = 4 WHERE ROLE_ID = 10001007 and user.ID = userRole.USER_ID AND user.COMPANY_ID=2;
UPDATE kom_manager.T_USER_ROLE userRole, T_USER user  SET ROLE_ID = 5 WHERE ROLE_ID = 10001001 and user.ID = userRole.USER_ID AND user.COMPANY_ID=2;
UPDATE kom_manager.T_USER_ROLE userRole, T_USER user  SET ROLE_ID = 5 WHERE ROLE_ID = 10001003 and user.ID = userRole.USER_ID AND user.COMPANY_ID=2;

#ROLE_NAME
UPDATE kom_manager.T_USER_ROLE userRole, kom_manager.T_SYSTEM_ROLE role SET userRole.ROLE_NAME = role.ROLE_NAME WHERE userRole.ROLE_ID = role.ROLE_ID;
