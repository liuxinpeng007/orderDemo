package com.mall.user.mapper;

import com.mall.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserById(int id);

    List<User> getUsersByIds(List<Integer> ids);
}
