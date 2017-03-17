
truncate table kom_manager.T_SALE_ITEM;

INSERT INTO kom_manager.T_SALE_ITEM(ID,SALE_ID,BILLNO,LINE_ID,COMPANY_ID,BRAND_CODE,MODEL_CODE,IMEI_NO,IMEI_LIST,SALE_QTY,SALE_PRICE,SALE_AMOUNT)
 SELECT ID,SALE_ID,BILLNO,LINE_ID,COMPANY_ID,BRAND_CODE,MODEL_MAT_CODE,IMEI_NO,IMEI_LIST,SALE_QTY,SALE_PRICE,SALE_AMOUNT FROM kom.T_SHOP_SALEITEM;

# SHOP_ID
#UPDATE kom_manager.T_SALE_ITEM item , kom_manager.T_SALE sale SET item.SHOP_ID = sale.SHOP_ID WHERE sale.ID = item.SALE_ID;

DROP PROCEDURE update_saleitem_shopid;

DELIMITER //
CREATE PROCEDURE update_saleitem_shopid()
BEGIN
DECLARE finished INTEGER DEFAULT 0;
DECLARE id BIGINT(20) DEFAULT 0;
DECLARE shop_id CHAR(12) DEFAULT "";
DECLARE sale_cur CURSOR FOR SELECT sales.ID, sales.SHOP_ID FROM T_SALE sales ORDER BY sales.ID;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;

OPEN sale_cur;

update_sale: LOOP
FETCH sale_cur INTO id, shop_id;
IF finished THEN
LEAVE update_sale;
END IF;
UPDATE T_SALE_ITEM SET SHOP_ID = shop_id WHERE SALE_ID = id;
IF (MOD(id, 5000) = 0) THEN
SELECT  "................";
END IF;
END LOOP update_sale;

CLOSE sale_cur;
SELECT  "last id " + id;

END
//
DELIMITER ;

select now();
call update_saleitem_shopid;
select now();
