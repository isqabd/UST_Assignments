Question-1

use temp;

						-- 1 //emp whose fname starts with vowel and lname ends with consonant --
SELECT first_name, last_name
FROM employees
WHERE 
LEFT(first_name, 1) IN ('A', 'E', 'I', 'O', 'U')
AND 
RIGHT(last_name, 1) NOT IN ('A', 'E', 'I', 'O', 'U');

Question-2

use temp;
										-- SELECTING DEPARTMENTS TOTAL,AVG MAX SALARY  --
SELECT employees.employee_id,
employees.first_name,
employees.last_name,
departments.department_name,
salaries.salary,

(SELECT SUM(salaries.salary) FROM employees AS e 
JOIN salaries ON e.employee_id = salaries.employee_id 
WHERE e.department_id = employees.department_id) AS total_salary_expenditure,

(SELECT AVG(salaries.salary) FROM employees AS e 
JOIN salaries ON e.employee_id = salaries.employee_id 
WHERE e.department_id = employees.department_id) AS avg_pay,

(SELECT MAX(salaries.salary) FROM employees AS e 
JOIN salaries ON e.employee_id = salaries.employee_id 
WHERE e.department_id = employees.department_id) AS max_pay

FROM employees
JOIN departments ON employees.department_id = departments.department_id
JOIN salaries ON employees.employee_id = salaries.employee_id;

Question-3

use temp;

SELECT employees.employee_id,
employees.first_name AS employee_first_name,
employees.last_name AS employee_last_name,
departments.department_name,
managers.first_name AS manager_first_name,

salaries.salary
FROM employees
JOIN departments ON employees.department_id   =   departments.department_id
LEFT JOIN employees AS managers ON employees.manager_id   =   managers.employee_id
JOIN salaries  ON  employees.employee_id   =   salaries.employee_id;

