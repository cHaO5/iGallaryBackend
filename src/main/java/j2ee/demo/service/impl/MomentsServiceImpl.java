package j2ee.demo.service.impl;

import j2ee.demo.mapper.ForwardMapper;
import j2ee.demo.mapper.MomentMapper;
import j2ee.demo.model.Forward;
import j2ee.demo.model.Moment;
import j2ee.demo.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MomentsServiceImpl implements MomentsService {
    @Autowired
    private MomentMapper momentMapper;

    @Autowired
    private ForwardMapper forwardMapper;

    @Override
    public int deleteMomentById(Integer momentId) {
        return momentMapper.delete(momentId);
    }

    @Override
    public int forward(Integer momentId, Integer userId) {
        Forward forward = new Forward();
        forward.setCreator(userId);
        forward.setMomentId(momentId);
        return forwardMapper.insert(forward);
    }

    @Override
    public int deleteMomentLikes(Integer momentId, Integer userId) {
        Moment moment = momentMapper.getOne(momentId);
        moment.setLikeNum(moment.getLikeNum() - 1);
        return momentMapper.update(moment);
    }

    @Override
    public int addMomentLikes(Integer momentId, Integer userId) {
        Moment moment = momentMapper.getOne(momentId);
        moment.setLikeNum(moment.getLikeNum() + 1);
        return momentMapper.update(moment);
    }

    @Override
    public int addMoment(Moment moment) {
        return momentMapper.insert(moment);
    }

    @Override
    public int modifyMoment(Moment moment) {
        return momentMapper.update(moment);
    }

    @Override
    public List<Moment> getMoment(Integer userId) {
        return momentMapper.getALL();
    }
}
