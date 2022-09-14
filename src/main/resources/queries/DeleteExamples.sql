DELETE FROM users
WHERE id = 1;

DELETE FROM users 
WHERE age = 25;

DELETE FROM users
Where age >= 19 and phones_id = null;


DELETE FROM jobs 
WHERE name = 'developer' and code is not null;

DELETE FROM jobs
WHERE id_jobs = 1;
DELETE FROM technologies;

DELETE FROM phones
WHERE full_name = 'son of poseidion';

DELETE FROM phones 
WHERE phone_number = '555092289' and full_name = 'zeus';

DELETE FROM users
WHERE full_name = 'jack' and phones_id = null;

DELETE FROM users 
WHERE age = 20 and phones_id = null;

DELETE FROM phones
WHERE phone_number = null;

