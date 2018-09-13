var stompClient = null;
var userName = null;
$('body').keyup(function (e) {
    var event = e || window.event;
    var code = event.keyCode || event.which || event.charCode;
    if (code == 13) {
        sendMsg();
    }
});

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('user').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('msgWindows').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('sendBtn').style.visibility = connected ? 'visible' : 'hidden';
    $('#response').html();
}

function connect() {
    var user = $('#user').val();
    if (user == null || user.trim().length==0) {
        showModel('提示', '请输入姓名!');
    } else {
        userName = user;
        var socket = new SockJS('/endpointWisely');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log('连接:' + frame);
            stompClient.subscribe('/topic/getResponse', function (response) {
                showResponse(JSON.parse(response.body));
            });
        });
    }
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect()
    }
    setConnected(false);
    console.log('连接断开');
    //菜单跳转
    $('.nav li').removeClass('active');
    $('.chat').addClass('active');
    $('.chatAll').addClass('active');
}

//消息发送
function sendMsg() {
    var msg = $('#msg').val();
    if (msg == null || msg == "") {
        showModel('提示', '消息不能为空！')
    }
    $('#msg').val('');
    var data = {
        'userName': userName,
        'msg': msg
    };
    stompClient.send('/sendAll', {}, JSON.stringify(data));
}

//消息接收
function showResponse(data) {
    var html = '<div class="msgInfo">';
    if (data.sendUser != userName) {
        call();//消息提醒
        html += '<span style="color: #3657f9;font-weight: 500;font-family: cursive; font-size: 16px;">'
    } else {
        html += '<span style="color: #478a14;font-weight: 500;font-family: cursive; font-size: 16px;">'
    }
    html += data.sendUser;
    html += '&nbsp;' + data.time;
    html += '</span>';
    html += '</br><div style="color: #2b2a2a;font-size: 16px;margin: 5px 0 5px 29px;">' + data.responseMessage + '</div>';
    html += '</div>';
    $('#response').prepend(html);
    //长度限制
    var $index = $('.msgInfo').length;
    if ($index >= 15) {
        $('.msgInfo:last').remove();
    }
}

function call() {
    var audioElementHovertree = document.createElement('audio');
    audioElementHovertree.setAttribute('src', 'http://w.qq.com/audio/classic.mp3');
    audioElementHovertree.setAttribute('autoplay', 'autoplay'); //打开自动播放
}