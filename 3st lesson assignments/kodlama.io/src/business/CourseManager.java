package business;

import core.logging.Logger;
import dataAccess.CourseDao;
import entities.Course;

public class CourseManager {
    private CourseDao courseDao;
    private Logger[] loggers;

    public CourseManager(CourseDao courseDao, Logger[] loggers) {
        this.courseDao = courseDao;
        this.loggers = loggers;
    }

    public void add(Course course) throws Exception {
        Course[] courses = {new Course(1, "Java", "Backend programing", 10), new Course(2, "Javascript", "Frontend programing", 25)};
        for (Course c : courses) {
            if (course.getName() == c.getName()) {
                throw new Exception("Kurs ismi tekrar edemez.");
            } else if (course.getPrice() < 0) {
                throw new Exception("Bir kursun fiyatı 0 dan küçük olamaz.");
            }
        }
        courseDao.add(course);
        for (Logger logger : loggers) {
            logger.log(course.getName());
        }
    }
}
