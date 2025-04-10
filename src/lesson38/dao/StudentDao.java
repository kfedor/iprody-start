package lesson38.dao;

import lesson38.HibernateSession;
import lesson38.entity.Student;
import lombok.Getter;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    @Getter
    private static final StudentDao INSTANCE = new StudentDao();

    private StudentDao() {
    }

    public void saveStudent(String name, String email) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.persist(
                    Student.builder()
                            .name(name)
                            .email(email)
                            .build());

            session.getTransaction().commit();
        }
    }

    public void deleteStudent(Student student) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(student);
            session.getTransaction().commit();
        }
    }

    public void updateStudentsEmail(Student student, String newEmail) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.get(Student.class, student.getId());
            student.setEmail(newEmail);
            session.getTransaction().commit();
        }
    }

    public List<Student> findAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            session.beginTransaction();
            allStudents = session.createQuery("from Student", Student.class).list();
            session.getTransaction().commit();
        }
        return allStudents;
    }

    public Student findStudentById(Long id) {
        Student student = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            session.beginTransaction();
            student = session.get(Student.class, id);
            session.getTransaction().commit();
        }
        return student;
    }
}
