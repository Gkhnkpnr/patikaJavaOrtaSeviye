UPDATE employee
SET	name = 'Ahmet Yildirim',
	birthday = '1990-10-10',
	email = 'ahmet@gmail.com'
WHERE id = 1;

UPDATE employee
SET	name = 'Serhat Yilmaz',
	birthday = '1990-1-11',
	email = 'serhat@hotmail.com'
WHERE name = 'Gay Pinar';

UPDATE employee
SET	name = 'Esra Demir',
	birthday = '1990-12-21',
	email = 'esra@gmail.com'
WHERE email = 'agoggey2@photobucket.com';

UPDATE employee
SET	name = 'Ali Yildiz',
	birthday = '1991-11-11',
	email = 'ali@gmail.com'
WHERE id = 4;

UPDATE employee
SET	name = 'Muaz Yol',
	birthday = '1994-5-5',
	email = 'muaz@gmail.com'
WHERE id = 5;

DELETE FROM employee
WHERE id = 1;

DELETE FROM employee
WHERE name = 'Angelo Ridgley';

DELETE FROM employee
WHERE email = 'avyvyan9@salon.com';

DELETE FROM employee
WHERE birthday = '2009-10-11';

DELETE FROM employee
WHERE id = 10;
