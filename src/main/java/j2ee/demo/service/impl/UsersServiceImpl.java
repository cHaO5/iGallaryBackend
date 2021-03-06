package j2ee.demo.service.impl;

import j2ee.demo.mapper.FavouriteMapper;
import j2ee.demo.mapper.FavouritesMomentMapper;
import j2ee.demo.mapper.UserFollowMapper;
import j2ee.demo.mapper.UserMapper;
import j2ee.demo.model.Favourites;
import j2ee.demo.model.User;
import j2ee.demo.model.UserFollow;
import j2ee.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.OnError;
import java.util.List;

@Service(value = "usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserFollowMapper userFollowMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int unfollow(Integer userId, Integer followedUserId) {
        return userFollowMapper.delete(userId, followedUserId);
    }

    @Override
    public int follow(Integer userId, Integer followedUserId) {
        UserFollow userFollow = new UserFollow();
        userFollow.setUserId(userId);
        userFollow.setFollowTo(followedUserId);
        return userFollowMapper.insert(userFollow);
    }

    @Override
    public List<Integer> getFollow(Integer userId) {
        return userFollowMapper.followTo(userId);
    }

    @Override
    public UserFollow findByUserIdAndFollowTo(Integer userId, Integer followTo) {
        return userFollowMapper.findByUserIdAndFollowTo(userId, followTo);
    }

    @Override
    public User getUser(Integer userId) {
        return userMapper.getOne(userId);
    }

    @Override
    public int modifyUser(Integer userId, User user) {
        return userMapper.update(user);
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public int forgetPassword(User user) {
        return userMapper.modifyByEmail(user);
    }
}
