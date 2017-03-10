SELECT DISTINCT
    CITY_ID,
    BRAND_CODE,
    COMPANY_ID,
    COUNTRY_ID,
    REGION_ID,
    COMPANY_NAME,
    CITY_NAME,
    COUNTRY_NAME,
    REGION_NAME,
    YEAR,
    SUM(CASE CONCAT(year, LPAD(week, 2, 0))
        WHEN 201647 THEN SALE_QTY
        ELSE 0
    END) SALE_QTY_0,
    SUM(CASE CONCAT(year, LPAD(week, 2, 0))
        WHEN 201648 THEN SALE_QTY
        ELSE 0
    END) SALE_QTY_1,
    SUM(CASE CONCAT(year, LPAD(week, 2, 0))
        WHEN 201649 THEN SALE_QTY
        ELSE 0
    END) SALE_QTY_2,
    SUM(CASE CONCAT(year, LPAD(week, 2, 0))
        WHEN 201650 THEN SALE_QTY
        ELSE 0
    END) SALE_QTY_3,
    SUM(CASE CONCAT(year, LPAD(week, 2, 0))
        WHEN 201651 THEN SALE_QTY
        ELSE 0
    END) SALE_QTY_4,
    SUM(CASE CONCAT(year, LPAD(week, 2, 0))
        WHEN 201652 THEN SALE_QTY
        ELSE 0
    END) SALE_QTY_5,
    SUM(CASE CONCAT(year, LPAD(week, 2, 0))
        WHEN 201701 THEN SALE_QTY
        ELSE 0
    END) SALE_QTY_6,
    SUM(CASE CONCAT(year, LPAD(week, 2, 0))
        WHEN 201702 THEN SALE_QTY
        ELSE 0
    END) SALE_QTY_7
FROM
    (SELECT 
        rw.COMPANY_ID,
            rw.city_id,
            rw.COUNTRY_ID,
            rw.REGION_ID,
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
        CONCAT(year, LPAD(week, 2, 0)) >= 201647
            AND CONCAT(year, LPAD(week, 2, 0)) <= 201702
            AND COMPANY_ID = 1
    GROUP BY rw.year , rw.week , rw.brand_code , rw.COMPANY_ID , rw.city_id , rw.COUNTRY_ID , rw.REGION_ID , rw.COMPANY_NAME , rw.CITY_NAME , rw.COUNTRY_NAME , rw.REGION_NAME) tp
GROUP BY tp.year , tp.brand_code , tp.city_id , tp.COMPANY_ID , tp.COUNTRY_ID , tp.REGION_ID , tp.COMPANY_NAME , tp.CITY_NAME , tp.COUNTRY_NAME , tp.REGION_NAME
ORDER BY year DESC , SALE_QTY_0 DESC