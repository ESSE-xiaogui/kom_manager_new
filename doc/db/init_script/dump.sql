export MYSQL_HOME=/c/Program/mysql-5.7.12-winx64/bin
cd $MYSQL_HOME

#dump db schema
#./mysqldump -ukom -pKom#12345  kom_manager -d --single-transaction | sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > kom_manager.sql

#dump table schema and data
./mysqldump -ukom -pKom#12345 kom_manager T_ATTRIBUTE| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_ATTRIBUTE.sql
./mysqldump -ukom -pKom#12345 kom_manager T_BRAND| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_BRAND.sql
./mysqldump -ukom -pKom#12345 kom_manager T_COMPANY| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_COMPANY.sql
./mysqldump -ukom -pKom#12345 kom_manager T_CONFIGURATION| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_CONFIGURATION.sql
./mysqldump -ukom -pKom#12345 kom_manager T_CURRENCY| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_CURRENCY.sql
./mysqldump -ukom -pKom#12345 kom_manager T_DUTY| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_DUTY.sql
./mysqldump -ukom -pKom#12345 kom_manager T_EMPLOYEE| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_EMPLOYEE.sql
./mysqldump -ukom -pKom#12345 kom_manager T_MATERIEL| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_MATERIEL.sql
./mysqldump -ukom -pKom#12345 kom_manager T_MODEL| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_MODEL.sql
./mysqldump -ukom -pKom#12345 kom_manager T_ORGANIZATION| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_ORGANIZATION.sql
./mysqldump -ukom -pKom#12345 kom_manager T_REGION| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_REGION.sql
./mysqldump -ukom -pKom#12345 kom_manager T_REGION_TYPE| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_REGION_TYPE.sql
./mysqldump -ukom -pKom#12345 kom_manager T_ROLE_MENU| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_ROLE_MENU.sql
./mysqldump -ukom -pKom#12345 kom_manager T_ROLE_RESOURCE| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_ROLE_RESOURCE.sql
./mysqldump -ukom -pKom#12345 kom_manager T_SALE| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_SALE.sql
./mysqldump -ukom -pKom#12345 kom_manager T_SALE_ITEM| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_SALE_ITEM.sql
./mysqldump -ukom -pKom#12345 kom_manager T_SERIES| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_SERIES.sql
./mysqldump -ukom -pKom#12345 kom_manager T_SHOP| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_SHOP.sql
./mysqldump -ukom -pKom#12345 kom_manager T_SHOP_BIZ| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_SHOP_BIZ.sql
./mysqldump -ukom -pKom#12345 kom_manager T_SHOP_EXTENSION| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_SHOP_EXTENSION.sql
./mysqldump -ukom -pKom#12345 kom_manager T_SHOP_GRADE| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_SHOP_GRADE.sql
./mysqldump -ukom -pKom#12345 kom_manager T_STOCK| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_STOCK.sql
./mysqldump -ukom -pKom#12345 kom_manager T_STOCK_ITEM| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_STOCK_ITEM.sql
./mysqldump -ukom -pKom#12345 kom_manager T_SYSTEM_MENU| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_SYSTEM_MENU.sql
./mysqldump -ukom -pKom#12345 kom_manager T_SYSTEM_RESOURCE| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_SYSTEM_RESOURCE.sql
./mysqldump -ukom -pKom#12345 kom_manager T_SYSTEM_ROLE| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_SYSTEM_ROLE.sql
./mysqldump -ukom -pKom#12345 kom_manager T_USER| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_USER.sql
./mysqldump -ukom -pKom#12345 kom_manager T_USER_SHOP| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_USER_SHOP.sql
./mysqldump -ukom -pKom#12345 kom_manager T_USER_ROLE| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_USER_ROLE.sql
./mysqldump -ukom -pKom#12345 kom_manager T_VERSION| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_VERSION.sql
./mysqldump -ukom -pKom#12345 kom_manager T_VISIT_SCORE_SETTING| sed 's/ AUTO_INCREMENT=[0-9]*\b//g' > T_VISIT_SCORE_SETTING.sql
