truncate table kom_manager.T_SHOP;
INSERT INTO kom_manager.T_SHOP 
( SHOP_ID, SHOP_CODE, SHOP_NAME, COMPANY_ID,PARENT_ID,COUNTRY,CITY,ADDRESS,GRADE_ID,BIZ_ID,BRANDS_FIRST,BRANDS_TWO,BRANDS_THREE,PURCHAS_CHANNEL,IS_KOM,RELATIONSHIP,BIZ_CATEGORY,INCORPORATOR,INCORPORATOR_TEL,FWIDTH, SHOP_AREA, SHOW_NUM, STAFF_NUM, SALES_NUM, IS_INACTIVE, REMARK,CREATE_DATE, UPDATE_DATE )
  SELECT  DEALER_ID, DEALER_CODE, DEALER_NAME, COMPANY_ID,PARENT_ID,COUNTRY,CITY,ADDRESS,GRADE_ID,SHOPCLASS,BRAND_CODE1,BRAND_CODE2,BRAND_CODE3,SUPPLY_CHANNEL,IS_KOM,RELATIONSHIP,BUSINESS_CATEGROY,INCORPORATOR,INCORPORATOR_TEL,FWIDTH, FLOOR(FAREA), SHOWNUM, STAFFNUM, SALESNUM, IS_INACTIVE, REMARK,CREATED_TIME, UPDATED_TIME FROM kom.T_BB_SHOP;

#COMPANY_ID
UPDATE kom_manager.T_SHOP SET COMPANY_ID = 5 WHERE COMPANY_ID = 2000;
UPDATE kom_manager.T_SHOP SET COMPANY_ID = 6 WHERE COMPANY_ID = 3000;
UPDATE kom_manager.T_SHOP SET COMPANY_ID = 2 WHERE COMPANY_ID = 1000 OR COMPANY_ID = 0 OR COMPANY_ID IS NULL;
UPDATE kom_manager.T_SHOP SET CREATE_BY = 'system';
UPDATE kom_manager.T_SHOP SET UPDATE_BY = 'system';
UPDATE kom_manager.T_SHOP SET CREATE_DATE =  NOW() WHERE CREATE_DATE IS NULL;
UPDATE kom_manager.T_SHOP SET UPDATE_DATE = NOW() WHERE UPDATE_DATE IS NULL;

#set parent id
UPDATE kom_manager.T_SHOP r1 , kom_manager.T_SHOP r2 SET r1.PARENT_ID = r2.ID WHERE r1.PARENT_ID = r2.SHOP_ID;
#REGION_ID
UPDATE T_SHOP s,T_REGION r SET s.REGION_ID = r.ID WHERE s.CITY = r.REGION_CODE;
#CITY
UPDATE T_SHOP s,T_REGION r SET s.CITY = r.ID WHERE s.CITY = r.REGION_CODE;
#COUNTRY
UPDATE T_SHOP s,T_REGION r SET s.COUNTRY = r.ID WHERE s.COUNTRY = r.REGION_CODE;
#GRADE_ID
#1001	A
#1002	A+
#1003	A++
#1004	B
#1005	C
#1006	D
#1007	E
#1008	F
#1	A++
#2	A+
#3	A
#4	B
#5	C
#6	D
#7	E
#8	F
UPDATE kom_manager.T_SHOP SET GRADE_ID = 1 WHERE GRADE_ID = 1001;
UPDATE kom_manager.T_SHOP SET GRADE_ID = 2 WHERE GRADE_ID = 1002;
UPDATE kom_manager.T_SHOP SET GRADE_ID = 3 WHERE GRADE_ID = 1003;
UPDATE kom_manager.T_SHOP SET GRADE_ID = 4 WHERE GRADE_ID = 1004;
UPDATE kom_manager.T_SHOP SET GRADE_ID = 5 WHERE GRADE_ID = 1005;
UPDATE kom_manager.T_SHOP SET GRADE_ID = 6 WHERE GRADE_ID = 1006;
UPDATE kom_manager.T_SHOP SET GRADE_ID = 7 WHERE GRADE_ID = 1007;
UPDATE kom_manager.T_SHOP SET GRADE_ID = 8 WHERE GRADE_ID = 1008;

#BIZ_ID
#24010045	��׼��	��20M2	Standard Exclusive	Tecno exclusive shop
#24010040	�����	��30M2	Image Exclusive	Tecno exclusive shop
#24010035	�콢���50M	��50M2	Flagship Shop	Tecno exclusive shop
#24010005	������	the retailer owns two shops or above	Chain Shop	Branding shop
#24010030	�����̳���	the shop in the mall or supermarket	Shopping Mall	Branding shop
#24010015	����С��	the shop locates outside phone market	Independent Shop	Branding shop
#24010020	����ͨ�������г���	the shop locates in phone market	Mobile Market Shop	Branding shop
#24010025	��Ӫ�̵�	the shop of operator	Operator Shop	Branding shop
#24010010	����������	the shop sells the electronic appliance and phones	Electronic Appliance Shop	Branding shop
#24010050	�콢��		Tecno Flagship	

#1	Standard Exclusive	��׼��
#2	Image Exclusive	�����
#3	Flagship Shop	�콢��
#4	Chain shop	������
#5	Shopping mall	�����̳���
#6	Independent shop	����С��
#7	Mobile market shop	����ͨ�������г���
#8	Operator shop	��Ӫ�̵�
#9	Electronic appliance shop	����������
UPDATE kom_manager.T_SHOP SET BIZ_ID = 1 WHERE BIZ_ID = 24010045;
UPDATE kom_manager.T_SHOP SET BIZ_ID = 2 WHERE BIZ_ID = 24010040;
UPDATE kom_manager.T_SHOP SET BIZ_ID = 3 WHERE BIZ_ID = 24010035;
UPDATE kom_manager.T_SHOP SET BIZ_ID = 4 WHERE BIZ_ID = 24010005;
UPDATE kom_manager.T_SHOP SET BIZ_ID = 5 WHERE BIZ_ID = 24010030;
UPDATE kom_manager.T_SHOP SET BIZ_ID = 6 WHERE BIZ_ID = 24010015;
UPDATE kom_manager.T_SHOP SET BIZ_ID = 7 WHERE BIZ_ID = 24010020;
UPDATE kom_manager.T_SHOP SET BIZ_ID = 8 WHERE BIZ_ID = 24010025;
UPDATE kom_manager.T_SHOP SET BIZ_ID = 9 WHERE BIZ_ID = 24010010;
#RELATIONSHIP
#24070005	2407	1	Close	���������ǵĹ�ϵ
#24070010	2407	2	GOOD	���������ǵĹ�ϵ
#24070015	2407	3	Intimate	���������ǵĹ�ϵ
#24070020	2407	4	Normal	���������ǵĹ�ϵ
#24070025	2407	5	Poor	���������ǵĹ�ϵ
#24070030	2407	6	Bad	���������ǵĹ�ϵ
#24070035	2407	7		���������ǵĹ�ϵ
#1	2	1	1	Close	����
#2	2	1	2	Good	��
UPDATE kom_manager.T_SHOP SET RELATIONSHIP = 1 WHERE RELATIONSHIP = 24070005;
UPDATE kom_manager.T_SHOP SET RELATIONSHIP = 2 WHERE RELATIONSHIP = 24070010;