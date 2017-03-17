truncate table kom_manager.T_SYSTEM_ROLE;

INSERT INTO kom_manager.T_SYSTEM_ROLE (ROLE_CODE, ROLE_NAME, IS_INACTIVE, CREATED_BY, CREATE_TIME, UPDATED_BY, UPDATE_TIME)
  VALUES ('system', 'system', '1', 'system', NOW(), 'system', NOW());
  INSERT INTO kom_manager.T_SYSTEM_ROLE (ROLE_CODE, ROLE_NAME, IS_INACTIVE, CREATED_BY, CREATE_TIME, UPDATED_BY, UPDATE_TIME)
  VALUES ('admin', 'admin', '1', 'system', NOW(), 'system', NOW());
  INSERT INTO kom_manager.T_SYSTEM_ROLE (ROLE_CODE, ROLE_NAME, IS_INACTIVE, CREATED_BY, CREATE_TIME, UPDATED_BY, UPDATE_TIME)
  VALUES ('manager', 'manager', '1', 'system', NOW(), 'system', NOW());
  INSERT INTO kom_manager.T_SYSTEM_ROLE (ROLE_CODE, ROLE_NAME, IS_INACTIVE, CREATED_BY, CREATE_TIME, UPDATED_BY, UPDATE_TIME)
  VALUES ('supervisor', 'supervisor', '1', 'system', NOW(), 'system', NOW());
  INSERT INTO kom_manager.T_SYSTEM_ROLE (ROLE_CODE, ROLE_NAME, IS_INACTIVE, CREATED_BY, CREATE_TIME, UPDATED_BY, UPDATE_TIME)
  VALUES ('promoter', 'promoter', '1', 'system', NOW(), 'system', NOW());