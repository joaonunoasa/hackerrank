package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Business service.
 * In spring, business services are typically singletons.
 * When the application starts up, spring creates an instance of this service and keeps it in memory
 */
@Service
class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    List<Course> getAllCourses(String topicId) {
        return courseRepository.findByTopicId(topicId);
    }

    Optional<Course> getCourse(String id) {
        return courseRepository.findById(id);
    }

    void addCourse(Course course) {
        courseRepository.save(course);
    }

    void setCourse(Course course) {
        courseRepository.save(course);
    }

    void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
