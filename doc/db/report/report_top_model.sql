-- desc
-- 根据时间区间查询前10的机型销售数量
SELECT 
    COMPANY_ID,
    CITY_ID,
    COUNTRY_ID,
    REGION_ID,
    COMPANY_NAME,
    CITY_NAME,
    COUNTRY_NAME,
    REGION_NAME,
    BRAND_CODE,
    MODEL_CODE,
    SUM(SALE_QTY) SALE_QTY
FROM
    T_REPORT_SALE_DAILY
WHERE
    SALE_DATE >= STR_TO_DATE('2016-03-02', '%Y-%m-%d %H:%i:%s')
        AND SALE_DATE <= STR_TO_DATE('2016-12-02', '%Y-%m-%d %H:%i:%s')
        AND COMPANY_ID = 1        
GROUP BY BRAND_CODE , MODEL_CODE , CITY_ID , CITY_NAME , COMPANY_ID , COMPANY_NAME , COUNTRY_ID , COUNTRY_NAME , REGION_ID , REGION_NAME
ORDER BY SALE_QTY DESC
limit 0, 10