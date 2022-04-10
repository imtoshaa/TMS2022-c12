DROP SCHEMA IF EXISTS students_db;
CREATE SCHEMA IF NOT EXISTS students_db;

DROP TABLE IF EXISTS students_db.city;
CREATE TABLE IF NOT EXISTS students_db.city
(
    idCity      INT PRIMARY KEY AUTO_INCREMENT,
    nativeCity  VARCHAR(45) NOT NULL,
    currentCity VARCHAR(45) NOT NULL
);

DROP TABLE IF EXISTS students_db.students;
CREATE TABLE IF NOT EXISTS students_db.students
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    city_id INT,
    name    VARCHAR(45)  NOT NULL,
    surname VARCHAR(100) NOT NULL,
    course  INT          NOT NULL,
    FOREIGN KEY (city_id) REFERENCES city (idCity) ON DELETE CASCADE
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

