USE challenge_db;

SELECT department,
COUNT(*) AS employee_count,
ROUND (AVG(salary),2) AS avg_sal,
MAX(salary) AS max_sal
FROM employees
GROUP  BY department
HAVING COUNT(*)>2;
