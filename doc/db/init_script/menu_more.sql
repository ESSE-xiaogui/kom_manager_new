
INSERT INTO kom_manager.TEMP_SYSTEM_MENU (MENU_CODE,MENU_NAME,MENU_ORDER,PARENT_MENU_ID,MENU_ICON,PAGE_URL,USABLE,VERSION) SELECT MENU_CODE,MENU_NAME,MENU_ORDER,PARENT_MENU_ID,MENU_ICON,PAGE_URL,USABLE, MENU_ID FROM T_SYSTEM_MENU;
UPDATE kom_manager.TEMP_SYSTEM_MENU r1 , kom_manager.TEMP_SYSTEM_MENU r2 SET r1.PARENT_MENU_ID = r2.MENU_ID WHERE r1.PARENT_MENU_ID = r2.VERSION
UPDATE kom_manager.TEMP_SYSTEM_MENU SET VERSION ='0';
DROP TABLE kom_manager.T_SYSTEM_MENU;
RENAME TABLE kom_manager.TEMP_SYSTEM_MENU TO kom_manager.T_SYSTEM_MENU;