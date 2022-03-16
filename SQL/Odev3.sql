SELECT country FROM country
WHERE country LIKE 'A%a';

SELECT country FROM country
WHERE country LIKE '_____%n';

SELECT title FROM film
WHERE title ILIKE '%t%t%t%t%';

SELECT * FROM film
<<<<<<< HEAD
WHERE title LIKE 'C%' AND length > 90 AND rental_rate = 2.99;
=======
WHERE title LIKE 'C%' AND length > 90 AND rental_rate = 2.99;
>>>>>>> refs/remotes/origin/main
