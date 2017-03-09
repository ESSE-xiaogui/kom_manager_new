insert into T_REPORT_SALE_WEEK (
	COMPANY_ID,
	SHOP_ID,
    GRADE_ID,
    COUNTRY_ID,
    CITY_ID,
    REGION_ID,
	USER_CODE,
    SHOP_CODE,
	BRAND_CODE,
	MODEL_CODE,
	YEAR,
	WEEK,
    COMPANY_NAME,
	SHOP_NAME,
	GRADE_NAME,
    COUNTRY_NAME,
    CITY_NAME,
    REGION_NAME,
    EMP_NAME,
	SALE_QTY,
	STOCK_QTY
)
SELECT 
    sale.COMPANY_ID,
    sale.SHOP_ID,
    ts.GRADE_ID,
    ts.COUNTRY COUNTRY_ID,
    ts.CITY CITY_ID,
    ts.REGION_ID,
    sale.USER_CODE,
    ts.SHOP_CODE,
    sale.BRAND_CODE,
    sale.MODEL_CODE,
    sale.year YEAR,
    sale.week WEEK,
    tc.COMPANY_NAME,
    ts.shop_name SHOP_NAME,
    sg.GRADE_NAME,
    r1.REGION_NAME COUNTRY_NAME,
    r2.REGION_NAME CITY_NAME,
    r2.REGION_NAME REGION_NAME,
    te.EMP_NAME,
    sale.SALE_QTY,
    stock.stock_qty STOCK_QTY
FROM
    (SELECT 
        s.COMPANY_ID,
            s.SHOP_ID,
            s.USER_CODE,
            i.BRAND_CODE,
            i.MODEL_CODE,
            YEAR(s.sale_date) year,
            WEEK(s.SALE_DATE) week,
            SUM(i.SALE_QTY) SALE_QTY
    FROM
        T_SALE s, T_SALE_ITEM i
    WHERE
        s.billno = i.billno
    GROUP BY s.user_code , s.COMPANY_ID , s.shop_id , i.brand_code , i.model_code , YEAR(s.sale_date) , WEEK(s.sale_date)) sale
        LEFT JOIN
    (SELECT 
        s.shop_id,
            s.user_code,
            i.brand_code,
            i.model_code,
            YEAR(s.stock_date) year,
            WEEK(s.stock_date) week,
            SUM(i.qty) stock_qty
    FROM
        T_STOCK s, T_STOCK_ITEM i
    WHERE
        s.billno = i.billno
    GROUP BY s.user_code , s.shop_id , i.brand_code , i.model_code , YEAR(s.stock_date) , WEEK(s.stock_date)) stock ON sale.year = stock.year
        AND sale.week = stock.week
        AND sale.user_code = stock.user_code
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
