insert into T_REPORT_SALE_DAILY (
    COMPANY_ID,
    SHOP_ID,
    GRADE_ID,
    COUNTRY_ID,
    CITY_ID,
    REGION_ID,
    AREA_ID,
    AREA_NAME,
    USER_CODE,
    SHOP_CODE,
    BRAND_CODE,
    MODEL_CODE,
    SALE_DATE,
    WEEK,    
    COMPANY_NAME,
    SHOP_NAME,
    GRADE_NAME,
    COUNTRY_NAME,
    CITY_NAME,
    REGION_NAME,
    EMP_NAME,
    SALE_QTY,
    STOCK_QTY,
    CREATED_BY,
    CREATE_TIME,
    UPDATED_BY,
    UPDATE_TIME
)
SELECT 
    sale.COMPANY_ID,
    sale.SHOP_ID,
    ts.GRADE_ID,
    ts.COUNTRY COUNTRY_ID,
    ts.CITY CITY_ID,
    ts.REGION_ID,
    ar.AREA_ID,
    ar.AREA_NAME,
    sale.USER_CODE,
    ts.SHOP_CODE,
    sale.brand_code BRAND_CODE,
    sale.model_code MODEL_CODE,
    sale.SALE_DATE,
    sale.week WEEK,
    tc.COMPANY_NAME,
    ts.shop_name SHOP_NAME,
    sg.GRADE_NAME,
    r1.REGION_NAME COUNTRY_NAME,
    r2.REGION_NAME CITY_NAME,
    r2.REGION_NAME REGION_NAME,
    te.EMP_NAME,
    sale.sale_qty SALE_QTY,
    stock.stock_qty STOCK_QTY,
    'system', sysdate(), 'system', sysdate()
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
	T_COMPANY tc on sale.COMPANY_ID = tc.ID
		left join
	T_USER tu on sale.COMPANY_ID = tu.COMPANY_ID and sale.USER_CODE = tu.USER_CODE
		Left join
	T_EMPLOYEE te on sale.COMPANY_ID = te.COMPANY_ID 
		and te.U_ID = tu.ID
		Left join
    T_SHOP ts ON sale.shop_id = ts.id
        LEFT JOIN
    T_REGION r1 ON r1.ID = ts.COUNTRY
        LEFT JOIN
    T_REGION r2 ON r2.ID = ts.CITY
		LEFT JOIN
    T_REGION r3 ON r3.ID = ts.REGION_ID
		LEFT join
	T_SHOP_GRADE sg on sg.id = ts.GRADE_ID 
		left join
    T_AREA_SHOP ars ON sale.SHOP_ID = ars.SHOP_ID
        LEFT JOIN
    T_AREA ar ON ar.COMPANY_ID = sale.COMPANY_ID
        AND ar.AREA_ID = ars.AREA_ID
