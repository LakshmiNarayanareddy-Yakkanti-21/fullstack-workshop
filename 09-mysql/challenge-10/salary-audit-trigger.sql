DELIMITER $$

CREATE TRIGGER trg_salary_audit
AFTER UPDATE ON employees
FOR EACH ROW
BEGIN
    -- Check if salary actually changed
    IF OLD.salary <> NEW.salary THEN
        INSERT INTO salary_audit (
            employee_id,
            old_salary,
            new_salary,
            change_percent
        )
        VALUES (
            OLD.id,
            OLD.salary,
            NEW.salary,
            ROUND(((NEW.salary - OLD.salary) / OLD.salary) * 100, 2)
        );
    END IF;
END$$

DELIMITER ;
