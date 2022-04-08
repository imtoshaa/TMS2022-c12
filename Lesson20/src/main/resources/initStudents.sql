--------------------------------------------------------
--  DDL for schema students_db
--------------------------------------------------------
DROP SCHEMA IF EXISTS students_db;
CREATE SCHEMA IF NOT EXISTS students_db;

--------------------------------------------------------
--  DDL for Table students_db
--------------------------------------------------------
DROP TABLE IF EXISTS students_db.students;
CREATE TABLE IF NOT EXISTS students_db.students
(
    id      INT          NOT NULL AUTO_INCREMENT,
    name    VARCHAR(45)  NOT NULL,
    surname VARCHAR(100) NOT NULL,
    course  INT          NOT NULL,
    PRIMARY KEY (id)
);

--------------------------------------------------------
--  DML for Table students_db
--------------------------------------------------------

DROP TABLE IF EXISTS students_db.city;
CREATE TABLE IF NOT EXISTS students_db.city
(
    idCity
                INT         NOT NULL AUTO_INCREMENT,
    nativeCity  VARCHAR(45) NOT NULL,
    currentCity VARCHAR(45) NOT NULL,
    FOREIGN KEY (idCity) REFERENCES students (id)
);

INSERT INTO students_db.students(name, surname, course)
VALUES ('Alex', 'Surkov', 1);
INSERT INTO students_db.city(nativeCity, currentCity)
    VALUE ('Минск', 'Пинск');

INSERT INTO students_db.students(name, surname, course)
VALUES ('Anna', 'Borodich', 2);
INSERT INTO students_db.city(nativeCity, currentCity)
    VALUE ('Воложин', 'Осиповичи');

INSERT INTO students_db.students(name, surname, course)
VALUES ('Sergey', 'Kryvnitskiy', 3);
INSERT INTO students_db.city(nativeCity, currentCity)
    VALUE ('Смиловичи', 'Пинск');

INSERT INTO students_db.students(name, surname, course)
VALUES ('Alina', 'Kedich', 4);
INSERT INTO students_db.city(nativeCity, currentCity)
    VALUE ('Минск', 'Минск');

INSERT INTO students_db.students(name, surname, course)
VALUES ('Petr', 'Medvedzev', 5);
INSERT INTO students_db.city(nativeCity, currentCity)
    VALUE ('Москва', 'Питер');

