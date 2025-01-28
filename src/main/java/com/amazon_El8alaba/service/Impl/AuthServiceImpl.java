package com.amazon_El8alaba.service.Impl;

import com.amazon_El8alaba.dao.UserRepository;
import com.amazon_El8alaba.entity.UserEntity;
import com.amazon_El8alaba.enums.Role;
import com.amazon_El8alaba.model.LoginDTO;
import com.amazon_El8alaba.model.SignUpDTO;
import com.amazon_El8alaba.model.User;
import com.amazon_El8alaba.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public User Login(LoginDTO loginDTO) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();


        Optional<UserEntity> theUser =  userRepository.findByEmail(email);

        User currentUser = mapToUser(theUser);
        if(currentUser==null) {
            return null;
        }
        if(currentUser.getPassword().equals(password)) {
            return currentUser;
        }
        return null;
    }

    @Override
    public boolean register(SignUpDTO registerDTO) {
        UserEntity newUser = mapToEntity(registerDTO);
        UserEntity theUser =  userRepository.save(newUser);
        if (theUser != null) {
            return true;
        }
        return  false;
    }

    @Override
    public boolean forgotPassword(String email) {
        Optional<UserEntity> theUser = userRepository.findByEmail(email);
        if (theUser != null) {
            return true;
        }
        return false;
    }
    private UserEntity mapToEntity(SignUpDTO registerDTO) {
        return modelMapper.map(registerDTO, UserEntity.class);

    }
    private User mapToUser( Optional<UserEntity> userEntity) {
        return modelMapper.map(userEntity, User.class);

    }
}