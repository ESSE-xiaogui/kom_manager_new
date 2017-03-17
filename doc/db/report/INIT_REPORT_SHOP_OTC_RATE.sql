insert into T_REPORT_SHOP_OTC_RATE (
	COMPANY_ID,
    BRAND_CODE,
    MODEL_CODE,
    USER_CODE,
    VISIT_DATE,
    COUNTRY_ID,
    CITY_ID,
    REGION_ID,
    AREA_ID,
    COMPANY_NAME,
    AREA_NAME,
    COUNTRY_NAME,
    CITY_NAME,
    REGION_NAME,
    EMP_NAME, 
    VISIT_SHOP,
    CREATED_BY,
    CREATE_TIME,
    UPDATED_BY,
    UPDATE_TIME
)
select tm.COMPANY_ID,
            tm.BRAND_CODE,
            tm.MODEL_CODE,
            tm.USER_CODE,
            tm.VISIT_DATE,
            tm.COUNTRY_ID,
            tm.CITY_ID,
            tm.REGION_ID,
            tm.AREA_ID,
            tm.COMPANY_NAME,
            tm.AREA_NAME,
            tm.COUNTRY_NAME,
            tm.CITY_NAME,
            tm.REGION_NAME,
            tm.EMP_NAME, COUNT(1) VISIT_SHOP,
            'system', sysdate(), 'system', sysdate()
            from (
SELECT 
    visit.*,    
    tb.BRAND_CODE,
    tmd.MODEL_CODE,
    s.COUNTRY COUNTRY_ID,
    s.CITY CITY_ID,
    s.REGION_ID,
    ar.AREA_ID,
    ar.AREA_NAME,
    tc.COMPANY_NAME,
    r1.REGION_NAME COUNTRY_NAME,
    r2.REGION_NAME CITY_NAME,
    r2.REGION_NAME REGION_NAME,
    e.EMP_NAME
FROM
    (SELECT 
        v.COMPANY_ID,
            vm.BRAND_ID,
            vm.MODEL_ID,
            vm.SHOP_ID,
            v.VISTOR USER_CODE,
            DATE_FORMAT(v.VISIT_DATE, '%Y%m') VISIT_DATE
    FROM
        T_VISIT_MODEL vm, T_VISIT v
    WHERE
       -- v.COMPANY_ID = 1 AND 
        vm.VISIT_ID = v.id
    GROUP BY v.COMPANY_ID , vm.BRAND_ID , vm.MODEL_ID , vm.SHOP_ID , v.VISTOR , DATE_FORMAT(v.VISIT_DATE, '%Y%m')) visit
        LEFT JOIN
    T_SHOP s ON visit.COMPANY_ID = s.COMPANY_ID
        AND visit.SHOP_ID = s.id
        LEFT JOIN
    T_USER u ON visit.COMPANY_ID = u.COMPANY_ID
        AND visit.USER_CODE = u.USER_CODE
        LEFT JOIN
	T_COMPANY tc on visit.COMPANY_ID = tc.ID
        LEFT JOIN
    T_EMPLOYEE e ON e.COMPANY_ID = e.COMPANY_ID
        AND e.U_ID = u.ID
        LEFT JOIN
    T_REGION r1 ON r1.ID = s.COUNTRY
        LEFT JOIN
    T_REGION r2 ON r2.ID = s.CITY
        LEFT JOIN
    T_REGION r3 ON r3.ID = s.REGION_ID
        LEFT JOIN
    T_AREA_SHOP ars ON visit.SHOP_ID = ars.SHOP_ID
        LEFT JOIN
    T_AREA ar ON ar.COMPANY_ID = visit.COMPANY_ID
        AND ar.AREA_ID = ars.AREA_ID
		left join
	T_BRAND tb on tb.ID = visit.BRAND_ID
		left join
	T_MODEL tmd on tmd.ID = visit.MODEL_ID
        ) tm        
        group by tm.COMPANY_ID,
            tm.BRAND_CODE,
            tm.MODEL_CODE,
            tm.USER_CODE,
            tm.VISIT_DATE,
            tm.COUNTRY_ID,
            tm.CITY_ID,
            tm.REGION_ID,
            tm.AREA_ID,
            tm.COMPANY_NAME,
            tm.AREA_NAME,
            tm.COUNTRY_NAME,
            tm.CITY_NAME,
            tm.REGION_NAME,
            tm.EMP_NAME;
            
UPDATE T_REPORT_SHOP_OTC_RATE t set t.total_shop = (select count(1) from T_SHOP s where s.city = t.city_id and s.company_id = t.company_id);
update T_REPORT_SHOP_OTC_RATE t set t.otc_rate = (t.visit_shop / t.total_shop)

            