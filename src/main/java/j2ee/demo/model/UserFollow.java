package j2ee.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserFollow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int userId;

    private int followTo;

    public UserFollow() {

    }

    public UserFollow(int userId, int followTo) {
        this.userId = userId;
        this.followTo = followTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFollowTo() {
        return followTo;
    }

    public void setFollowTo(int followTo) {
        this.followTo = followTo;
    }
}
