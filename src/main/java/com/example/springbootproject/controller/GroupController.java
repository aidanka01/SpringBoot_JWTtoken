package com.example.springbootproject.controller;

import com.example.springbootproject.dto.request.GroupRequest;
import com.example.springbootproject.dto.response.GroupResponse;
import com.example.springbootproject.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/api/group")

public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public GroupResponse save(@RequestBody GroupRequest groupRequest){
        return groupService.save(groupRequest);
    }

    @GetMapping({"id"})
    public GroupResponse findById(@PathVariable Long id){
        return groupService.findById(id);
    }

    @PutMapping
    public GroupService update(@PathVariable Long id, @RequestBody GroupRequest groupRequest){
        return (GroupService) groupService.update(id, groupRequest);
    }

    @DeleteMapping({"id"})
    public String delete(@PathVariable Long id){
        groupService.delete(id);
        return String.format("Group with %d id is successfully deleted", id);
    }
}
