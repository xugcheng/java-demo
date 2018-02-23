var ws = new WebSocket("ws://localhost:9999/ws");
ws.onopen = function (event) {
    console.log("建立连接...");
    ws.send("hello");
    ws.send("测试");
    ws.close(100,'毫无理由');
}
ws.onmessage = function (p1) {
    console.log("收到消息:" + p1.data);
}
ws.onclose = function (p1) {
    console.log("关闭连接," + p1.code + "," + p1.reason + ',' + p1.wasClean);
}
ws.onerror = function (event) {
    console.log("出校异常," + event.data);
}

var sock = new SockJS('http://localhost:9999/sockjs');
sock.onopen = function () {
    console.log('open');
    sock.send('test');
};
sock.onmessage = function (e) {
    console.log('message:', e.data);
    sock.close();
};
sock.onclose = function () {
    console.log('close');
};