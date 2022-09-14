UPDATE users
SET age = 25
WHERE full_name = 'peter parker';	

UPDATE users 
SET full_name = 'Unknown'
WHERE phones_id = 1;

UPDATE codesalaries 
SET salary = 5555.5
WHERE id_code = 1;

UPDATE jobs
SET description = 'works on developing system,debugging.'
WHERE name = 'developer';

UPDATE users
SET full_name = 'Unknown', age = 99
WHERE phones_id = null;

UPDATE specs
SET operating_system = '10'
WHERE model = 'GT212L0';

UPDATE codesalaries 
SET salary = 62123.2;

UPDATE technologies 
SET name = 'ASUS'
WHERE name = 'DELL INSPIRION 16';

UPDATE users
SET full_name = 'Undead'
WHERE age > 200;

UPDATE jobs
SET name = 'construction worker'
WHERE code = 1;