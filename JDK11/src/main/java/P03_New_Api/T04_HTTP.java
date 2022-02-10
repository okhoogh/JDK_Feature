package P03_New_Api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * @author: okhoogh
 * @date: 2022/1/4 14:49
 * @description: JEP 321：标准HTTP客户端
 * 从 Java 9 开始引入了一个处理 HTTP 请求的的 HTTP Client API，不过当时一直处于孵化阶段。
 * 而在 Java 11 中已经为正式可用状态，作为一个标准API提供在java.net.http供大家使用，该 API 支持同步和异步请求。
 * 动机
 * JDK8中的HttpURLConnectionAPI及其实现存在许多问题：
 * 1.URLConnection API是设计时考虑了多种协议，而这些都协议是现在已经不存在（ftp，gopher，等）。
 * 2.API早于HTTP / 1.1并且过于抽象。
 * 3.难于使用
 * 4.仅能在阻塞模式下工作
 * 5.难于维护
 * <p>
 * 新版API优势
 * 1.API必须是易于使用的，包括简单的阻塞模式
 * 2.必须支持通知机制如HTTP消息头收到、错误码、HTTP消息体收到
 * 3.简洁的API能够支持80-90%的需求
 * 4.必须支持标准和通用身份验证机制
 * 5.必须能够轻松使用WebSocket
 * 6.必须支持HTTP 2
 * 7.必须执行与现有网络API一致的安全检查
 * 8.必须对lambda表达式等新语言功能很友好
 * 9.应该对嵌入式系统友好，避免永久运行的后台线程
 * 10.必须支持HTTPS / TLS
 * 11.满足HTTP 1.1和HTTP 2的性能要求
 */
public class T04_HTTP {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 同步
        // 1.创建HttpClient对象。
        var client1 = HttpClient.newHttpClient();
        // 2.创建请求对象：request,封装请求地址和请求方式get.
        var request1 = HttpRequest.newBuilder().uri(URI.create("http://api.k780.com/?app=life.time&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json"))
                .GET().build();
        // 3.使用HttpClient对象发起request请求，获得请求响应对象response
        HttpResponse<String> response = client1.send(request1, HttpResponse.BodyHandlers.ofString());
        // 4.响应的状态码信息
        System.out.println(response.statusCode());
        // 5.响应的数据信息输出
        System.out.println(response.body());

        System.out.println("----------------------");

        // 异步
        // 1.创建HttpClient对象
        var client2 = HttpClient.newHttpClient();
        // 2.创建请求对象：request,封装请求地址和请求方式get.
        var request2 = HttpRequest.newBuilder().uri(URI.create("http://api.k780.com/?app=life.time&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json"))
                .GET().build();
        // 3.使用HttpClient对象发起request异步请求，获得请求响应对象future
        CompletableFuture<HttpResponse<String>> future =
                client2.sendAsync(request2, HttpResponse.BodyHandlers.ofString());
        // 4.监听future对象的响应结果，并通过join方法进行异步阻塞式等待。
        future.whenComplete((resp, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
            } else {
                System.out.println(resp.statusCode());
                System.out.println(resp.body());
            }
        }).join();
        // 先执行获取消息体的生产者函数，然后再执行消费消息体的打印函数
        future.thenApply(HttpResponse::body).thenAccept(System.out::println);
    }
}
