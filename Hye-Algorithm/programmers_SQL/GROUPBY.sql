
 [GROUP BY]

-- Quiz1. ����̿� ���� �� ���� ������

SELECT animal_type, count(animal_type) count
FROM animal_ins
GROUP BY animal_type
ORDER BY animal_type;

-- Quiz2. ���� ���� �� ã��

SELECT name, count(name) count
FROM animal_ins
GROUP BY name
HAVING count(name) > 1
ORDER BY name;

-- Quiz3. �Ծ� �ð� ���ϱ�(1)

SELECT to_char(datetime, 'HH24') hour, count(*) count
FROM ANIMAL_OUTS
GROUP BY to_char(datetime, 'HH24')
HAVING to_char(datetime, 'HH24') BETWEEN 9 AND 19
ORDER BY hour;


-- Quiz4. �Ծ� �ð� ���ϱ�(2)

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