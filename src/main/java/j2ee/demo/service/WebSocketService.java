package j2ee.demo.service;

import j2ee.demo.configuration.WebSocketConstant;
import j2ee.demo.model.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yansong
 * @Date 2018/12/28 05:56
 */
@Service
public class WebSocketService {
    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 广播
     * 发给所有在线用户
     *
     * @param msg
     */
    public void sendMsg(WiselyResponse msg) {
        template.convertAndSend(WebSocketConstant.BRODCAT_PRODUCER_PATH_1, msg);
    }

    /**
     * 发送给指定用户
     * @param users
     * @param msg
     */
    public void send2Users(List<String> users, WiselyResponse msg) {
        users.forEach(userName -> {
            System.out.println("sendTo: " + userName);
            template.convertAndSendToUser(userName, WebSocketConstant.P2P_PUSH_POSTFIX, msg);
        });
    }
}
