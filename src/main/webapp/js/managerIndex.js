$(function () {
    navHeight()
})

function navHeight() {
    var height = $('body').css('height');
    var top = $('.top-nav').css('height');
    // console.log(height)
    height = height.substring(0,height.length-1);
    // console.log(height)
    top = top.substring(0,top.length-1);
    // console.log(top)
    height = parseFloat(height);
    top = parseFloat(top);
    $('.main-nav').css('height',(height-top)+'px')
}

$('.layui-nav-item').click(function(){
    $(this).siblings('li').attr('class','layui-nav-item');
})