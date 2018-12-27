package j2ee.demo.service.impl;

import j2ee.demo.mapper.FavouriteMapper;
import j2ee.demo.mapper.UserMapper;
import j2ee.demo.model.Favourites;
import j2ee.demo.model.User;
import j2ee.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FavouriteMapper favouriteMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Favourites getFavourite(Integer userId, Integer favId) {

    }

    @Override
    public int unfollow(Integer userId, Integer followedUserId) {

    }

    @Override
    public int follow(Integer userId, Integer followedUserId) {

    }

    @Override
    public List<Integer> getFollow(Integer userId) {

    }

    @Override
    public User getUser(Integer userId) {
        return userMapper.getOne(userId);
    }

    @Override
    public int modifyUser(Integer userId, User user) {
        return userMapper.update(user);
    }
}
