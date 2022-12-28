package com.example.springbootproject.mapper;

import com.example.springbootproject.dto.request.StudentRequest;
import com.example.springbootproject.dto.response.StudentResponse;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.model.entity.Group;
import com.example.springbootproject.model.entity.Student;
import com.example.springbootproject.model.enums.StudyFormat;
import com.example.springbootproject.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@RequestMapping
public class StudentMapper {
    private final GroupRepository groupRepository;

    public Student mapToEntity(StudentRequest studentRequest) {
        Student student = new Student();
        Group group = groupRepository.findById(studentRequest.getGroupId()).get();
        student.setGroup(group);
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(StudyFormat.valueOf(studentRequest.getStudyFormat()));

        return student;
    }

    public StudentResponse mapToResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        if (student.getId() == null) {
            throw new NotFoundException(
                    String.format("Student with %d id not found", student.getId())
            );
        }
        studentResponse.setId(student.getId());
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setStudyFormat(student.getStudyFormat());
      //  studentResponse.setStudyFormat(student.getStudyFormat());
        studentResponse.setGroupId(student.getGroup().getId());

        return studentResponse;
    }

    public List<StudentResponse> mapToResponse(List<Student> students) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student : students) {
            studentResponses.add(mapToResponse(student));
        }
        return studentResponses;
    }
}
