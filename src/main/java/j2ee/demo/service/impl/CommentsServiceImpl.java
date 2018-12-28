package j2ee.demo.service.impl;

import j2ee.demo.mapper.MomentCommentMapper;
import j2ee.demo.model.MomentComment;
import j2ee.demo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "commentsService")
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    MomentCommentMapper momentCommentMapper;

    @Override
    public int deleteComment(Integer commentId) {
        return momentCommentMapper.delete(commentId);
    }

    @Override
    public MomentComment getComment(Integer commentId) {
        return momentCommentMapper.getOne(commentId);
    }

    @Override
    public int modifyComment(Integer commentId, MomentComment momentComment) {
        return momentCommentMapper.update(momentComment);
    }

    @Override
    public int addComment(MomentComment momentComment) {
        return momentCommentMapper.insert(momentComment);
    }
}
