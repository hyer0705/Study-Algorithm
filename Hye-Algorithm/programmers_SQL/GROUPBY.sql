
 [GROUP BY]

-- Quiz1. 고양이와 개는 몇 마리 있을까

SELECT animal_type, count(animal_type) count
FROM animal_ins
GROUP BY animal_type
ORDER BY animal_type;

-- Quiz2. 동명 동물 수 찾기

SELECT name, count(name) count
FROM animal_ins
GROUP BY name
HAVING count(name) > 1
ORDER BY name;

-- Quiz3. 입양 시각 구하기(1)

SELECT to_char(datetime, 'HH24') hour, count(*) count
FROM ANIMAL_OUTS
GROUP BY to_char(datetime, 'HH24')
HAVING to_char(datetime, 'HH24') BETWEEN 9 AND 19
ORDER BY hour;


-- Quiz4. 입양 시각 구하기(2)

SELECT TIME.HOUR, NVL(COUNT, 0)
FROM
    (SELECT LEVEL-1 HOUR
    FROM dual
     CONNECT BY LEVEL <= 24
    ) TIME,
    (SELECT to_char(datetime, 'hh24') HOUR, count(*) "COUNT"
     FROM animal_outs
     GROUP BY to_char(datetime, 'hh24')
    ) ATIME
WHERE TIME.HOUR = ATIME.HOUR(+)
ORDER BY TIME.HOUR;