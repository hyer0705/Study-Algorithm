
 [IS NULL]

-- Quiz1. 이름이 없는 동물의 아이디

SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL
ORDER BY ANIMAL_ID;

-- Quiz2. 이름이 있는 동물의 아이디

SELECT animal_id
FROM animal_ins
WHERE name IS NOT NULL
ORDER BY animal_id;

-- Quiz3. Null 처리하기

SELECT ANIMAL_TYPE, NVL(TO_CHAR(NAME), 'No name') name, SEX_UPON_INTAKE
FROM animal_ins
ORDER BY animal_id;