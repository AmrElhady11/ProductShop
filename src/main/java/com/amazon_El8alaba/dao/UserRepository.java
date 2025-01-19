package com.amazon_El8alaba.dao;

import com.amazon_El8alaba.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
