-- 统计个人每天各个机型销售库存数量
SELECT 
    sale.COMPANY_ID,
    sale.SHOP_ID,    
    sale.USER_CODE,
    sale.brand_code BRAND_CODE,
    sale.model_code MODEL_CODE,
    sale.SALE_DATE,  
    sale.week WEEK,    
    ts.shop_name SHOP_NAME,
    r1.REGION_NAME COUNTRY_NAME,
    r2.REGION_NAME CITY_NAME,
    sale.sale_qty SALE_QTY,
    stock.stock_qty STOCK_QTY
FROM
    (SELECT 
        s.COMPANY_ID,
            s.SHOP_ID,
            s.USER_CODE,
            s.SALE_DATE,
            WEEK(s.SALE_DATE) week,
            t.brand_code,
            t.model_code,
            SUM(t.SALE_QTY) sale_qty
    FROM
        T_SALE_ITEM t, T_SALE s
    WHERE
        t.BILLNO = s.BILLNO
            AND s.user_code IS NOT NULL
    GROUP BY s.USER_CODE , s.sale_date , t.brand_code , t.model_code , s.COMPANY_ID , s.SHOP_ID
    ORDER BY s.sale_date DESC) sale
        LEFT JOIN
    (SELECT 
        s.user_code,
            s.stock_date,
            s.shop_id,
            i.brand_code,
            i.model_code,
            SUM(i.qty) stock_qty
    FROM
        T_STOCK s, T_STOCK_ITEM i
    WHERE
        s.billno = i.billno
    GROUP BY s.user_code , s.stock_date , s.shop_id , i.brand_code , i.model_code) stock ON sale.user_code = stock.user_code
        AND sale.sale_date = stock.STOCK_DATE
        AND sale.brand_code = stock.brand_code
        AND sale.model_code = stock.model_code
        LEFT JOIN
    T_SHOP ts ON sale.shop_id = ts.id
        LEFT JOIN
    T_REGION r1 ON r1.ID = ts.COUNTRY
        LEFT JOIN
    T_REGION r2 ON r2.ID = ts.CITY;