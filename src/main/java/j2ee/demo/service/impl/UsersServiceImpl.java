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

import java.util.List;

public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FavouriteMapper favouriteMapper;

    @Autowired
    private UserFollowMapper userFollowMapper;

    @Autowired
    private FavouritesMomentMapper favouritesMomentMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<Integer> getFavourite(Integer userId, Integer favId) {
        // TODO Add favourite function
        return favouritesMomentMapper.getMomentsInFavourites(favId);
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
    public User getUser(Integer userId) {
        return userMapper.getOne(userId);
    }

    @Override
    public int modifyUser(Integer userId, User user) {
        return userMapper.update(user);
    }
}
