package j2ee.demo.service;

import j2ee.demo.model.Favourites;
import j2ee.demo.model.User;

import java.util.List;

public interface UsersService {
    int addUser(User user);

    List<Integer> getFavourite(Integer userId, Integer favId);

    int unfollow(Integer userId, Integer followedUserId);

    int follow(Integer userId, Integer followedUserId);

    List<Integer> getFollow(Integer userId);

    User getUser(Integer userId);

    int modifyUser(Integer userId, User user);
}
