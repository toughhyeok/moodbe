/*!
* Start Bootstrap - Shop Item v5.0.6 (https://startbootstrap.com/template/shop-item)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-item/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project
$("#reply-register-submit-button").click(function(event){
    var content = $("#reply-register-content").val();
    var musicId = $("#reply-register-music-id").val();
    var replyElement = '<div id="reply-alert" class="alert alert-warning alert-dismissible fade show" role="alert">댓글 입력란이 비어있습니다.</div>'
    if(content === ''){
        $('#reply-alert-target').html(replyElement);
        setTimeout(function () {
            $('#reply-alert').alert('close');
        }, 5000);
        return;
    }
    $.post('/api/v1/reply', {content: content, musicId: musicId})
        .done(function(res) {
            location.reload();
        })
        .fail(function(xhr, status, error) {
            console.log(xhr, status, error);
            alert('댓글 등록에 실패했습니다.');
        });
});
$('#reply-register-cancel-button').click(function() {
    $('#reply-register-content').val('');
});