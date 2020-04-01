
 [String, Date]

-- Quiz1. ��ÿ� ���� ã��

SELECT animal_id, name, sex_upon_intake
FROM animal_ins
WHERE name IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY animal_id;

-- Quiz2. �̸��� el�� ���� ���� ã��
SELECT animal_id, name
FROM animal_ins
WHERE upper(name) LIKE upper('%EL%')
    AND animal_type = 'Dog'
ORDER BY name;

-- Quiz3. �߼�ȭ ���� �ľ��ϱ�

SELECT 
    animal_id,
    name,
    CASE
        WHEN sex_upon_intake Like 'Neutered%'
            THEN 'O'
        WHEN sex_upon_intake Like 'Spayed%'
            THEN 'O'
        ELSE
            'X'
    END AS "�߼�ȭ"
FROM animal_ins
ORDER BY animal_id;

-- Quiz4. ���� �Ⱓ ��ȣ�� ����(2)

SELECT animal_id, name FROM (
    SELECT rownum date_rank, TMP.* FROM (
        SELECT i.animal_id, i.name, i.datetime "��ȣ ������", o.datetime "�Ծ���", o.datetime - i.datetime "��ȣ�Ⱓ"
        FROM animal_ins i, animal_outs o
        WHERE i.animal_id = o.animal_id
            AND o.datetime - i.datetime > 0
        ORDER BY "��ȣ�Ⱓ" DESC
    ) TMP
)E
WHERE date_rank BETWEEN 1 AND 2;

-- Quiz5. DATETIME���� DATE�� �� ��ȯ

SELECT animal_id, name, to_char(datetime, 'YYYY-MM-DD')
FROM animal_ins
ORDER BY animal_id;