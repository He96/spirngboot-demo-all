
var tipModal = '<div class="modal fade" id="myModal">' +
    '<div class="modal-dialog">' +
    '     <div class="modal-content">' +
    '         <!-- 模态框头部 -->' +
    '         <div class="modal-header">' +
    '             <h4 class="modal-title" id="modal_title"></h4>' +
    '             <button type="button" class="close" data-dismiss="modal"></button>' +
    '         </div>' +
    '         <!-- 模态框主体 -->' +
    '         <div class="modal-body" id="modal_body">' +
    '         </div>' +
    '         <!-- 模态框底部 -->' +
    '         <div class="modal-footer">' +
    '             <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">关闭</button>' +
    '         </div>' +
    '     </div>' +
    ' </div>' +
    '</div>';

function showModel(title,content) {
    $('#modal_title').html(title);
    $("#modal_body").html(content);
    $('#myModal').modal('show');
}

$(function () {
    $('body').append(tipModal);
    $.ajaxSetup({
        timeout: 30000,
        dataType: "json",
        contentType: 'application/json;charset=utf-8',
        //请求成功后触发
        success: function (data) {
            console.log('ajaxSetup-success');
        },
        //请求失败遇到异常触发
        error: function (xhr, status, e) {
            if (xhr.status == 401) {
                window.location.href = "login.html";
            }else{
                showModel('提示','服务器异常请稍后再试！')
            }
        },
        //完成请求后触发。即在success或error触发后触发
        complete: function (xhr, status) {
        },
        //发送请求前触发
        beforeSend: function (xhr) {
        }
    });
});
