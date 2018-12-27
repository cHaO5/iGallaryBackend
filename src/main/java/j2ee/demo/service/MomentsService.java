package j2ee.demo.service;

import j2ee.demo.model.Moment;

import java.util.List;

public interface MomentsService {
    int deleteMomentById(Integer momentId);

    int forward(Integer momentId, Integer userId);

    int deleteMomentLikes(Integer momentId, Integer userId);

    int addMomentLikes(Integer momentId, Integer userId);

    int addMoment(Moment moment);

    int modifyMoment(Moment moment);

    List<Moment> getMoment(Integer userId);
}
