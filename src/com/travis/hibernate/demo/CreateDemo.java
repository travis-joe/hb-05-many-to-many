package com.travis.hibernate.demo;

import com.travis.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession(); factory) {
            Instructor instructor = new Instructor("travis", "joe", "weelgod@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com", "luv2code");
            Course course = new Course("sex position");
            Course course2 = new Course("play sluts");
            Review review1 = new Review("great!");
            Review review2 = new Review("nice!");
            Review review3 = new Review("bad!");
            Review review4 = new Review("sucks!");
            Student wee = new Student("qiu", "zengyuan", "weelgod@gmail.com");
            Student yfb = new Student("ye", "fangbin", "weelgod@gmail.com");
            Student xpp = new Student("qiu", "pearl", "weelgod@gmail.com");
            course.addStudent(wee);
            course.addStudent(yfb);
            course2.addStudent(xpp);
            instructor.setInstructorDetail(instructorDetail);
            course.addReview(review1);
            course.addReview(review2);
            course.addReview(review3);
            course2.addReview(review4);
            instructor.add(course);
            instructor.add(course2);
            session.beginTransaction();
            session.save(course);
            session.save(course2);
            session.save(instructor);
            session.save(review1);
            session.save(review2);
            session.save(review3);
            session.save(wee);
            session.save(yfb);
            session.save(xpp);
            session.getTransaction().commit();
        }
    }
}
