
 [IS NULL]

-- Quiz1. �̸��� ���� ������ ���̵�

SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL
ORDER BY ANIMAL_ID;

-- Quiz2. �̸��� �ִ� ������ ���̵�

SELECT animal_id
FROM animal_ins
WHERE name IS NOT NULL
ORDER BY animal_id;

-- Quiz3. Null ó���ϱ�

SELECT ANIMAL_TYPE, NVL(TO_CHAR(NAME), 'No name') name, SEX_UPON_INTAKE
FROM animal_ins
ORDER BY animal_id;