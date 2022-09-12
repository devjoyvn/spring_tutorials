package com.deft.service;

import com.deft.dto.RoleDTO;
import com.deft.entity.Role;
import com.deft.mapper.RoleMapper;
import com.deft.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Throwable.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDTO create(RoleDTO dto) {
        Role role = new Role();
        role.setName(dto.getName());
        return RoleMapper.getInstance().toDTO(roleRepository.save(role));
    }
}
