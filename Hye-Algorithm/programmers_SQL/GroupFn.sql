 
 [SUM, MAX, MIN]

-- Quiz1. 최댓값 구하기

SELECT max(datetime)
FROM animal_ins;

-- Quiz2. 최솟값 구하기

SELECT min(datetime)
FROM animal_ins;

-- Quiz3. 동물 수 구하기

SELECT count(*) count
FROM animal_ins;

-- Quiz4. 중복 제거하기

SELECT count(name) FROM(
    SELECT DISTINCT name
    FROM animal_ins
);