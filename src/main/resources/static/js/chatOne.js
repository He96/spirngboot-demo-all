var stompClient = null;
var userName = null;
$('body').keyup(function (e) {
    var event = e || window.event;
    var code = event.keyCode || event.which || event.charCode;
    if (code == 13) {
        sendMsg();
    }
});
//菜单跳转
$('.nav li').removeClass('active');
$('.chat').addClass('active');
$('.chatOne').addClass('active');

var socket = new SockJS('/endpointChat');
var userId = $('#myId').val();
console.log('userId:'+userId);
stompClient = Stomp.over(socket);
stompClient.connect({name:userId}, function (frame) {
    //使用user/订阅地址指定发送给指定用户
    stompClient.subscribe('/user/queue/notifications',function (response) {
        showMsg(response.body)
    });
});


//消息发送
function sendMsg() {
    var msg = $('#msg').val();
    var chooseUser = $('#chooseUser').val();
    var chooseUserName = $('#chooseUser').find("option:selected").text();
    var userId = $('#myId').val();
    var userName = $('#myUserName').val();
    if (msg == null || msg == "") {
        showModel('提示', '消息不能为空！');
        return false;
    }
    if (chooseUser == null || chooseUser == "") {
        showModel('提示', '请至少选择一位好友！');
        return false;
    }
    $('#msg').val('');
    var data = {
        'userId':userId,
        'userName':userName,
        'sendToId': chooseUser,
        'sendToName':chooseUserName,
        'msg': msg
    };
    stompClient.send('/chat', {}, JSON.stringify(data));
    showMsg(JSON.stringify(data));
}

//消息接收
function showMsg(message) {
    var userId = $('#myId').val();
    var data = JSON.parse(message);
    var html = '<div class="msgInfo">';
    if (data.userId != userId) {
        call();//消息提醒
        html += '<span style="color: #3657f9;font-weight: 500;font-family: cursive; font-size: 16px;">'
    } else {
        html += '<span style="color: #478a14;font-weight: 500;font-family: cursive; font-size: 16px;">'
    }
    html += data.userName;
    html += '&nbsp;' + new moment().format('HH:mm:ss');
    html += '</span>';
    html += '</br><div style="color: #2b2a2a;font-size: 16px;margin: 5px 0 5px 29px;">' + data.msg + '</div>';
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