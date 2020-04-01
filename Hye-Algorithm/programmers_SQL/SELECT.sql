
 [SELECT]

-- Quiz1. ��� ���ڵ� ��ȸ�ϱ�
 SELECT * 
 FROM ANIMAL_INS
 ORDER BY ANIMAL_ID;


--Quiz2. ���� �����ϱ�

SELECT NAME, DATETIME
FROM animal_ins
ORDER BY animal_id DESC;


-- Quiz3. ���� ���� ã��

SELECT animal_id, name
FROM animal_ins
WHERE intake_condition = 'Sick'
ORDER BY animal_id;

-- Quiz4. � ���� ã��

SELECT animal_id, name
FROM animal_ins
WHERE intake_condition != 'Aged'
ORDER BY animal_id;


-- Quiz5. ������ ���̵�� �̸�

SELECT animal_id, name
FROM animal_ins
ORDER BY animal_id;

-- Quiz6. ���� �������� �����ϱ�

SELECT animal_id, name, datetime
FROM animal_ins
ORDER BY name, datetime desc;

-- Quiz7. ���� n�� ���ڵ�

SELECT name
FROM animal_ins
WHERE datetime = (
    SELECT min(datetime)
    FROM animal_ins);