 
 [SUM, MAX, MIN]

-- Quiz1. �ִ� ���ϱ�

SELECT max(datetime)
FROM animal_ins;

-- Quiz2. �ּڰ� ���ϱ�

SELECT min(datetime)
FROM animal_ins;

-- Quiz3. ���� �� ���ϱ�

SELECT count(*) count
FROM animal_ins;

-- Quiz4. �ߺ� �����ϱ�

SELECT count(name) FROM(
    SELECT DISTINCT name
    FROM animal_ins
);