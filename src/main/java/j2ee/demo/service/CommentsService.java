package j2ee.demo.service;

import j2ee.demo.model.MomentComment;

public interface CommentsService {
    int deleteComment(Integer commentId);

    MomentComment getComment(Integer commentId);

    int modifyComment(Integer commentId, MomentComment momentComment);

    int addComment(MomentComment momentComment);
}
