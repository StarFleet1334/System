SELECT * 
FROM jobs j 
INNER JOIN codesalaries c on j.id_jobs = c.id_code;

SELECT 'total sum',sum(c.salary)
FROM jobs j 
INNER JOIN codesalaries c on j.id_jobs = c.id_code;

SELECT *
FROM users u 
INNER JOIN phones p on u.phones_id = p.id;

SELECT 	* 
FROM technologies t 
INNER JOIN specs s on t.specs = s.id;

SELECT t.name,s.operating_system,s.model,s.memory,s.system_manufacturer 
FROM technologies t
INNER JOIN specs s on t.specs = s.id
WHERE s.operating_system = 11 and memory >= 16;
