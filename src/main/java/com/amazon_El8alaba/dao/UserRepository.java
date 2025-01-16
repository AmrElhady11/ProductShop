package com.amazon_El8alaba.dao;

import com.amazon_El8alaba.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
