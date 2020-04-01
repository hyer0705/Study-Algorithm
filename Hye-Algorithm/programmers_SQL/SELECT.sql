
 [SELECT]

-- Quiz1. 모든 레코드 조회하기
 SELECT * 
 FROM ANIMAL_INS
 ORDER BY ANIMAL_ID;


--Quiz2. 역순 정렬하기

SELECT NAME, DATETIME
FROM animal_ins
ORDER BY animal_id DESC;


-- Quiz3. 아픈 동물 찾기

SELECT animal_id, name
FROM animal_ins
WHERE intake_condition = 'Sick'
ORDER BY animal_id;

-- Quiz4. 어린 동물 찾기

SELECT animal_id, name
FROM animal_ins
WHERE intake_condition != 'Aged'
ORDER BY animal_id;


-- Quiz5. 동물의 아이디와 이름

SELECT animal_id, name
FROM animal_ins
ORDER BY animal_id;

-- Quiz6. 여러 기준으로 정렬하기

SELECT animal_id, name, datetime
FROM animal_ins
ORDER BY name, datetime desc;

-- Quiz7. 상위 n개 레코드

SELECT name
FROM animal_ins
WHERE datetime = (
    SELECT min(datetime)
    FROM animal_ins);