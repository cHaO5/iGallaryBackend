package j2ee.demo.controller;

import j2ee.demo.configuration.WebSocketConstant;
import j2ee.demo.model.WiselyMessage;
import j2ee.demo.model.WiselyResponse;
import j2ee.demo.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


@RestController
public class WebSocketController {

    @Autowired
    WebSocketService webSocketService;

    // @MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
    @MessageMapping(WebSocketConstant.DESTINATION_CLIENT_PUSH_PATH)
    // 如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。 必须和@MessageMapping搭配使用
    @SendTo(WebSocketConstant.BRODCAT_PRODUCER_PATH_1)
    public WiselyResponse say(WiselyMessage message) throws Exception {
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }

    @RequestMapping(value = "/targetUserId", method = RequestMethod.POST)
    public WiselyResponse communicate(WiselyMessage message, @RequestParam String userId) {
        List<String> users = new LinkedList<>();
        // 此处写死只是为了方便测试,此值需要对应页面中订阅个人消息的userId
        // userId 由自己定义
        users.add(message.getName());
        String result = "from: " + message.getName() + "; theMsg: " + "这段话需要通过定义传入的实体类来获得";
        webSocketService.send2Users(users, new WiselyResponse(result));
        // 验证是否发送成功
        return new WiselyResponse("OK");
    }
}