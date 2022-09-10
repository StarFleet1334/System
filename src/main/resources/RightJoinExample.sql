SELECT * 
FROM users u 
RIGHT JOIN phones p on u.phones_id = p.id;

SELECT * 
FROM jobs j 
RIGHT JOIN codesalaries c on j.code = c.id_code;

SELECT *
FROM technologies t 
RIGHT JOIN specs s on t.specs = s.id;

 SELECT *
FROM technologies t 
RIGHT JOIN specs s on t.specs = s.id
WHERE system_manufacturer = 'APPLE';

SELECT *
FROM jobs j 
RIGHT JOIN codesalaries c on j.code = c.id_code
WHERE c.salary > 5000;