package com.example.springbootproject.service.impl;

import com.example.springbootproject.dto.request.GroupRequest;
import com.example.springbootproject.dto.response.GroupResponse;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.model.entity.Group;
import com.example.springbootproject.mapper.GroupMapper;
import com.example.springbootproject.repository.GroupRepository;
import com.example.springbootproject.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public GroupResponse save(GroupRequest groupRequest) {
        return groupMapper.mapToResponse(
                groupRepository.save(
                        groupMapper.mapToEntity(groupRequest)
                )
        );
    }

    @Override
    public GroupResponse findById(Long id) {
        return groupMapper.mapToResponse(getObject(id));
    }

    @Override
    public List<GroupResponse> findAll() {
        return groupMapper.mapToResponse(
                groupRepository.findAll()
        );
    }

    @Override
    public GroupResponse update(Long id, GroupRequest groupRequest) {
      Group group = getObject(id);
      group.setGroupName(groupRequest.getGroupName());
      group.setDateOfStart(groupRequest.getDateOfStart());
      group.setDateOfFinish(groupRequest.getDateOfFinish());
      groupRepository.save(group);
        return groupMapper.mapToResponse(group);
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);

    }

    private Group getObject(Long id){
        return groupRepository.findById(id).orElseThrow(()->
                new NotFoundException(
                        String.format("Course with %d id not found!", id)));
    }
}
