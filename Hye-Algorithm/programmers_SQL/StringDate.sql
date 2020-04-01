
 [String, Date]

-- Quiz1. 루시와 엘라 찾기

SELECT animal_id, name, sex_upon_intake
FROM animal_ins
WHERE name IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY animal_id;

-- Quiz2. 이름에 el이 들어가는 동물 찾기
SELECT animal_id, name
FROM animal_ins
WHERE upper(name) LIKE upper('%EL%')
    AND animal_type = 'Dog'
ORDER BY name;

-- Quiz3. 중성화 여부 파악하기

SELECT 
    animal_id,
    name,
    CASE
        WHEN sex_upon_intake Like 'Neutered%'
            THEN 'O'
        WHEN sex_upon_intake Like 'Spayed%'
            THEN 'O'
        ELSE
            'X'
    END AS "중성화"
FROM animal_ins
ORDER BY animal_id;

-- Quiz4. 오랜 기간 보호한 동물(2)

SELECT animal_id, name FROM (
    SELECT rownum date_rank, TMP.* FROM (
        SELECT i.animal_id, i.name, i.datetime "보호 시작일", o.datetime "입양일", o.datetime - i.datetime "보호기간"
        FROM animal_ins i, animal_outs o
        WHERE i.animal_id = o.animal_id
            AND o.datetime - i.datetime > 0
        ORDER BY "보호기간" DESC
    ) TMP
)E
WHERE date_rank BETWEEN 1 AND 2;

-- Quiz5. DATETIME에서 DATE로 형 변환

SELECT animal_id, name, to_char(datetime, 'YYYY-MM-DD')
FROM animal_ins
ORDER BY animal_id;