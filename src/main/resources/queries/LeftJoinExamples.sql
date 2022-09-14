select * 
From jobs j 
LEFT JOIN codesalaries c on j.code = c.id_code;

select name,salary
FROM jobs j
LEFT join codesalaries c on j.code = c.id_code
ORDER BY c.salary;

select name,salary
FROM jobs j
LEFT JOIN codesalaries c on j.code = c.id_code
WHERE c.salary > 5000
ORDER BY c.salary;

SELECT * 
FROM users u 
LEFT JOIN phones p on u.phones_id = p.id;

SELECT u.full_name,u.age,p.phone_number
FROM users u
LEFT JOIN phones p on u.phones_id = p.id
WHERE p.phone_number is not null and age >= 40;


