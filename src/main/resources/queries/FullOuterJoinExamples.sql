SELECT * FROM users u
LEFT JOIN phones p on u.phones_id = p.id
UNION ALL
SELECT * FROM users u
RIGHT JOIN phones p on u.phones_id = p.id;

SELECT * FROM jobs j
LEFT JOIN codesalaries c on j.code = c.id_code
UNION ALL
SELECT * FROM jobs j
RIGHT JOIN codesalaries c on j.code = c.id_code;

SELECT * FROM technologies t
LEFT JOIN specs s on t.specs = s.id
UNION ALL
SELECT * FROM technologies t
RIGHT JOIN specs s on t.specs = s.id;

SELECT * FROM jobs j
LEFT JOIN codesalaries c on j.code = c.id_code
WHERE c.salary > 5000
UNION ALL
SELECT * FROM jobs j
RIGHT JOIN codesalaries c on j.code = c.id_code
WHERE j.id_jobs >= 8
ORDER BY 1;

SELECT * FROM technologies t
LEFT JOIN specs s on t.specs = s.id
WHERE t.pc = 0
UNION ALL
SELECT * FROM technologies t
RIGHT JOIN specs s on t.specs = s.id
WHERE t.pc = 0 and ss.operating_system = 10;

