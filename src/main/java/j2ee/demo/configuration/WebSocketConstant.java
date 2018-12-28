package j2ee.demo.configuration;

/**
 * @Author yansong
 * @Date 2018/12/28 05:55
 *
 * Usage: frontedend
 *      // 1. 连接SockJS的endpoint是“endpointWisely”，与后台代码中注册的 CONNECT_PATH 要一样。
 *      var socket = new SockJS('/endpointWisely');
 *      // 2. 创建STOMP协议的webSocket客户端。
 *      stompClient = Stomp.over(socket);
 *      // 3. 连接webSocket的服务端。
 *      stompClient.connect({}, function(frame) {
 *          setConnected(true);
 *          console.log('开始进行连接Connected: ' + frame);
 *          // 4. 通过stompClient.subscribe() 订阅服务器的目标是'/topic/getResponse'发送过来的地址，与@SendTo中的地址对应。
 *          stompClient.subscribe('/topic/getResponse', function(respnose){
 *              // 收到结果时的回调
 *              showResponse(JSON.parse(respnose.body).responseMessage);
 *          });
 *          // 4. 通过stompClient.subscribe() 订阅服务器的目标是'/user/' + userId + '/msg'接收一对一的推送消息,
 *          // 其中userId由服务端传递过来,用于表示唯一的用户,通过此值将消息精确推送给一个用户
 *          // userId是发起websocket请求的用户的id
 *          stompClient.subscribe('/user/' + userId + '/msg', function(respnose){
 *              console.log(respnose);
 *              // 收到结果时的回调
 *              showResponse1(JSON.parse(respnose.body).responseMessage);
 *          });
 *      });
 *      // 5. 发送信息
 *      // 通过stompClient.send()向地址为"/welcome"的服务器地址发起请求，与@MessageMapping里的地址对应。
 *      // 因为我们配置了registry.setApplicationDestinationPrefixes(Constant.WEBSOCKETPATHPERFIX);
 *      // 所以需要增加前缀/ws-push/
 *      stompClient.send("/ws-push/welcome", {}, JSON.stringify({ 'name': name }));
 */
public final class WebSocketConstant {
    // webSocket相关配置
    // 连接SockJS的endpoint
    public static final String CONNECT_PATH = "/endpointWisely";
    public static final String CONNECT_PATH_WITHOUT_STOMP = "/withoutStomp";
    // 客户端发起信息推送请求时的base path
    public static final String DESTINATION_PERFIX = "/ws-push";
    // 前端发送给服务端请求地址
    public static final String DESTINATION_CLIENT_PUSH_PATH = "/welcome";
    // 服务器端发起广播时的base path
    public static final String BROADCAST_BASE_PATH = "/topic";
    // 服务端生产地址实例,客户端订阅此地址以接收服务端生产的消息
    public static final String BRODCAT_PRODUCER_PATH_1 = "/topic/getResponse";
    // 点对点消息推送地址前缀
    public static final String P2P_PUSH_PERFIX = "/user";
    // 点对点消息推送地址后缀,最后的地址为/user/用户识别码/msg
    public static final String P2P_PUSH_POSTFIX = "/msg";
}
