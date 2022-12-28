package com.example.springbootproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;

    //relation with course
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.DETACH, CascadeType.MERGE})
    @JoinTable(name = "groups_courses",
            joinColumns = @JoinColumn(name ="group_id" ),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;


    // relation with students
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    List<Student> students;

}
