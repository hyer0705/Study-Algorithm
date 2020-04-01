
 [JOIN]

-- Quiz1. 없어진 기록 찾기

SELECT o.animal_id, o.name
FROM animal_ins i, animal_outs o
WHERE i.animal_id(+) = o.animal_id
	AND i.animal_id IS NULL
ORDER BY animal_id;

-- Quiz2. 있었는데요 없었습니다

SELECT i.animal_id, i.name
FROM animal_ins i, animal_outs o
WHERE i.animal_id = o.animal_id
    AND i.datetime > o.datetime
ORDER BY i.datetime;

-- Quiz3. 오랜 기간 보호한 동물(1)

SELECT name, "datetime" FROM (
    SELECT rownum date_rank, TMP.* FROM (
        SELECT i.animal_id, i.name, i.datetime "datetime", o.datetime "입양일"
        FROM animal_ins i, animal_outs o
        WHERE i.ANIMAL_ID = o.ANIMAL_ID(+)
            AND o.datetime IS NULL
        ORDER BY i.datetime
    ) TMP
)E
WHERE date_rank BETWEEN 1 AND 3;


-- Quiz4. 보호소에서 중성화한 동물

SELECT i.animal_id, i.animal_type, i.name
FROM animal_ins i, animal_outs o
WHERE i.animal_id = o.animal_id
    AND instr(sex_upon_intake, 'Intact') != 0
    AND instr(sex_upon_outcome, 'Intact') = 0
ORDER BY i.animal_id;