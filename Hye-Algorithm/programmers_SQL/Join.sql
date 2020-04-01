
 [JOIN]

-- Quiz1. ������ ��� ã��

SELECT o.animal_id, o.name
FROM animal_ins i, animal_outs o
WHERE i.animal_id(+) = o.animal_id
	AND i.animal_id IS NULL
ORDER BY animal_id;

-- Quiz2. �־��µ��� �������ϴ�

SELECT i.animal_id, i.name
FROM animal_ins i, animal_outs o
WHERE i.animal_id = o.animal_id
    AND i.datetime > o.datetime
ORDER BY i.datetime;

-- Quiz3. ���� �Ⱓ ��ȣ�� ����(1)

SELECT name, "datetime" FROM (
    SELECT rownum date_rank, TMP.* FROM (
        SELECT i.animal_id, i.name, i.datetime "datetime", o.datetime "�Ծ���"
        FROM animal_ins i, animal_outs o
        WHERE i.ANIMAL_ID = o.ANIMAL_ID(+)
            AND o.datetime IS NULL
        ORDER BY i.datetime
    ) TMP
)E
WHERE date_rank BETWEEN 1 AND 3;


-- Quiz4. ��ȣ�ҿ��� �߼�ȭ�� ����

SELECT i.animal_id, i.animal_type, i.name
FROM animal_ins i, animal_outs o
WHERE i.animal_id = o.animal_id
    AND instr(sex_upon_intake, 'Intact') != 0
    AND instr(sex_upon_outcome, 'Intact') = 0
ORDER BY i.animal_id;