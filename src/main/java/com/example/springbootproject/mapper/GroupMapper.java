package com.example.springbootproject.mapper;

import com.example.springbootproject.dto.request.GroupRequest;
import com.example.springbootproject.dto.response.GroupResponse;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.model.entity.Course;
import com.example.springbootproject.model.entity.Group;
import com.example.springbootproject.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@RequestMapping
public class GroupMapper {
    private final CourseRepository courseRepository;

    public Group mapToEntity(GroupRequest groupRequest) {
        Group group = new Group();
        Course course = courseRepository.findById(Long.valueOf(groupRequest.getCourseId())).get();
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        group.setCourses(courses);
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());

        return group;
    }

    public GroupResponse mapToResponse(Group group) {
        GroupResponse groupResponse = new GroupResponse();
        if (group.getId() == null) {
            throw new NotFoundException(
                    String.format("Group with %d id not found!", group.getId())
            );
        }
        groupResponse.setId(group.getId());
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setDateOfFinish(group.getDateOfFinish());
        for (Course course : group.getCourses()) {
            groupResponse.setCourseId(course.getId());
        }
        return groupResponse;
    }

    public List<GroupResponse> mapToResponse(List<Group> groups) {
        List<GroupResponse> groupResponses = new ArrayList<>();
        for (Group group : groups) {
            groupResponses.add(mapToResponse(group));
        }
        return groupResponses;
    }
}

