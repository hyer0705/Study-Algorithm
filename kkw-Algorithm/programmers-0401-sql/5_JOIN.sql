-- 없어진 기록 찾기
SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS
WHERE ANIMAL_ID NOT IN
    (SELECT ANIMAL_ID
     FROM ANIMAL_INS);

-- 있었는데요 없었습니다
SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I
WHERE I.DATETIME >
    (SELECT DATETIME
     FROM ANIMAL_OUTS
     WHERE ANIMAL_ID = I.ANIMAL_ID)
ORDER BY I.DATETIME;

-- 오랜 기간 보호한 동물(1)
SELECT NAME, DATETIME
FROM ANIMAL_INS
WHERE ANIMAL_ID NOT IN
    (SELECT ANIMAL_ID
     FROM ANIMAL_OUTS)
ORDER BY DATETIME
LIMIT 3;

-- 보호소에서 중성화한 동물
SELECT O.ANIMAL_ID, O.ANIMAL_TYPE, O.NAME
FROM ANIMAL_OUTS O
WHERE O.SEX_UPON_OUTCOME !=
    (SELECT SEX_UPON_OUTCOME
     FROM ANIMAL_INS
     WHERE ANIMAL_ID = O.ANIMAL_ID)
ORDER BY O.ANIMAL_ID;