package com.deft.service;

import com.deft.dto.UserCreationDTO;
import com.deft.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO create(UserCreationDTO dto);

    List<UserDTO> findAll();
}
