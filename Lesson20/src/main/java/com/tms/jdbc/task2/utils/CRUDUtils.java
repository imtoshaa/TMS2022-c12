package com.tms.jdbc.task2.utils;

import com.tms.jdbc.task2.model.Student;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CRUDUtils {

    /*
     * Посмотрите в пакете resources файл initStudents.sql
     * */

    private static String GET_ALL_STUDENTS_QUERY = "SELECT * FROM students_db.students JOIN students_db.city ON students.id=city.idCity";
    private static String INSERT_STUDENT_QUERY = "INSERT INTO students_db.students(name, surname, course) VALUES(?, ?, ?);";
    private static String INSERT_STUDENT_CITY_QUERY = "INSERT INTO students_db.city(nativeCity, currentCity) VALUES(?, ?);";
    private static String UPDATE_STUDENT_QUERY = "UPDATE students_db.students SET course = ? WHERE id = ?;";
    private static String UPDATE_STUDENT_CITY_QUERY = "UPDATE students_db.city SET currentCity = ? WHERE idCity = ?;";
    private static String DELETE_STUDENT_QUERY = "DELETE FROM students_db.students WHERE id = ?";
    private static String DELETE_STUDENT_CITY_QUERY = "DELETE FROM students_db.city WHERE idCity = ?";

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("name");
                String lastName = rs.getString("surname");
                String nativeCity = rs.getString("nativeCity");
                String currentCity = rs.getString("currentCity");
                int course = rs.getInt("course");
                students.add(new Student(id, firstName, lastName, course, nativeCity, currentCity));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return students;
    }

    public static List<Student> saveStudent(Student student) {
        List<Student> updatedStudents = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement studentStatement = connection.prepareStatement(INSERT_STUDENT_QUERY);
            PreparedStatement studentCityStatement = connection.prepareStatement(
                    INSERT_STUDENT_CITY_QUERY);

            studentStatement.setString(1, student.getName());
            studentStatement.setString(2, student.getSurname());
            studentStatement.setInt(3, student.getCourse());

            studentCityStatement.setString(1, student.getNativeCity());
            studentCityStatement.setString(2, student.getCurrentCity());

            studentStatement.executeUpdate();
            studentCityStatement.executeUpdate();

            updatedStudents = getAllStudents();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return updatedStudents;
    }

    public static List<Student> updateStudent(int studentId, int course, String currentCity) {
        List<Student> updatedStudents = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement studentStatement = connection.prepareStatement(UPDATE_STUDENT_QUERY);
            PreparedStatement studentCityStatement = connection.prepareStatement(UPDATE_STUDENT_CITY_QUERY);

            studentStatement.setInt(1, course);
            studentStatement.setInt(2, studentId);

            studentCityStatement.setString(1, currentCity);
            studentCityStatement.setInt(2, studentId);

            studentStatement.executeUpdate();
            studentCityStatement.executeUpdate();

            updatedStudents = getAllStudents();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return updatedStudents;
    }

    public static List<Student> deleteStudent(int studentId) {
        List<Student> updatedStudents = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
//            PreparedStatement studentCityStatement = connection.prepareStatement(DELETE_STUDENT_CITY_QUERY);
            PreparedStatement studentStatement = connection.prepareStatement(DELETE_STUDENT_QUERY);

//            studentCityStatement.setInt(1, studentId);
            studentStatement.setInt(1, studentId);


//            studentCityStatement.execute();
            studentStatement.execute();

            updatedStudents = getAllStudents();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return updatedStudents;
    }
}
