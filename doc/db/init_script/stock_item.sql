
truncate table kom_manager.T_STOCK_ITEM;

INSERT INTO kom_manager.T_STOCK_ITEM(ID,STOCK_ID,COMPANY_ID,BILLNO,LINE_ID,BRAND_CODE,MODEL_CODE,QTY,PRICE,AMOUNT,ISHISTORY)
 SELECT ID,STOCK_ID,COMPANY_ID,BILLNO,LINE_ID,BRAND_CODE,MODEL_MAT_CODE,FQTY,FPRICE,FAMOUNT,ISHISTORY FROM kom.T_SHOPSTOCK_DETAIL;


