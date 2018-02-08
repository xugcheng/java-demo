var ws = new WebSocket("ws://localhost:9999/ws/message");
ws.onopen = function (event) {
    console.log("建立连接..." + JSON.stringify(event));
    ws.send("hello");
    ws.send("测试");
}
ws.onmessage = function (p1) {
    console.log("收到消息:" + JSON.stringify(p1));
}
ws.onclose = function (p1) {
    console.log("关闭连接," + JSON.stringify(p1));
}
ws.onerror = function (event) {
    console.log("出校异常," + JSON.stringify(event));
}
