package j2ee.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This way is optional
 * 在这个方案中，所有的处理逻辑在这个handler里面
 * @Author yansong
 * @Date 2018/12/28 17:17
 */
@Component
public class WebSocketCustomizedHandler extends TextWebSocketHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        logger.info("Connected ... " + session.getId());
        sessions.add(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("handleTextMessage start");
        // 将消息进行转化，因为是消息是json数据，可能里面包含了发送给某个人的信息，所以需要用json相关的工具类处理之后再封装成TextMessage，
        // 我这儿并没有做处理，消息的封装格式一般有{from:xxxx,to:xxxxx,msg:xxxxx}，来自哪里，发送给谁，什么消息等等
        String msg = message.getPayload();
        logger.info("msg = " + msg);

        // 我们可以在这里进行一些处理逻辑
        // 给某一个session发送信息
        session.sendMessage(new TextMessage("json{}"));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        if (session.isOpen()) {
            session.close();
        }
        sessions.remove(session);
        logger.info(String.format("Session %s closed because of %s", session.getId(), status.getReason()));
    }
}
