SELECT 
    SHOP_ID,
    SHOP_CODE,
    GRADE_ID,
    CITY_ID,
    BRAND_CODE,
    COMPANY_ID,
    COUNTRY_ID,
    REGION_ID,
    SHOP_NAME,
    GRADE_NAME,
    COMPANY_NAME,
    CITY_NAME,
    COUNTRY_NAME,
    REGION_NAME,
    YEAR,
    WEEK,
    SALE_QTY
FROM
    (SELECT 
        rw.COMPANY_ID,
            rw.SHOP_ID,
            rw.GRADE_ID,
            rw.SHOP_CODE,
            rw.city_id,
            rw.COUNTRY_ID,
            rw.REGION_ID,
            rw.SHOP_NAME,
            rw.GRADE_NAME,
            rw.COMPANY_NAME,
            rw.CITY_NAME,
            rw.COUNTRY_NAME,
            rw.REGION_NAME,
            rw.brand_code,
            rw.year,
            rw.week,
            SUM(rw.SALE_QTY) SALE_QTY
    FROM
        T_REPORT_SALE_WEEK rw
    WHERE
        YEAR = 2017 AND COMPANY_ID = 1
    GROUP BY rw.year , rw.week , rw.brand_code , rw.COMPANY_ID , rw.shop_id , rw.GRADE_ID, rw.GRADE_NAME, rw.city_id , rw.COUNTRY_ID , rw.REGION_ID , rw.SHOP_CODE , rw.shop_name , rw.COMPANY_NAME , rw.CITY_NAME , rw.COUNTRY_NAME , rw.REGION_NAME) tp
GROUP BY tp.year , tp.week , tp.brand_code , tp.shop_id , tp.city_id , tp.COMPANY_ID , tp.COUNTRY_ID , tp.REGION_ID , tp.SHOP_CODE , tp.GRADE_ID, tp.GRADE_NAME, tp.shop_name , tp.COMPANY_NAME , tp.CITY_NAME , tp.COUNTRY_NAME , tp.REGION_NAME
ORDER BY year DESC , week DESC , SALE_QTY DESC