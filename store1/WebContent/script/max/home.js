//总加载
window.onload = function() {
    showNowPage();
    typeSelect();
    checkbox_listener();
    biggerImg();
    submitBuy()
    modifyPassword();
    registered();
    emptyCart();
    toggleTitle();
    /*min*/
    showNowPage_min();
}

//添加、移除className
function addClass(elem, value) {
    if (!elem.className) { //没有类名直接赋值
        elem.className = value;
    } else if (elem.className.indexOf(value) > -1) { //有就直接返回
        return;
    } else { //原来有类名
        elem.oldClass = elem.className;
        var newClass = elem.oldClass; //
        newClass += " ";
        newClass += value;
        elem.className = newClass //老类名 " " 新类名
    }
}

function removeClass(elem, value) {
    if (elem.className == value || elem.className == undefined) { //  本来就没有类名或者只有这一个类名
        elem.className = null;
    } else if (elem.className.indexOf(value) == -1) {
        return;

    } else {
        elem.className = elem.oldClass;
    }
}


//当前页面header标签固定
function showNowPage() {
    var links = $("#top nav ul li a");
    for (var i = 0; i < links.length; i++) {
        if (document.URL.indexOf(links[i].getAttribute('href')) > 0) { ///////      字符串包含连体写法    ///////!!!!!
            links[i].setAttribute("class", "this");
        } else if (document.URL.endsWith("WebContent/")) { //////    字符串包含     ////////!!!!!
            links[0].setAttribute("class", "this");
        }
    }
}

function showNowPage_min() {
    var links_father = $("#min-top nav ul li");
    for (var i = 0; i < links_father.length; i++) {
        var links = links_father[i].firstElementChild;
        if (document.URL.indexOf(links.getAttribute('href')) > 0) {
            links_father[i].setAttribute("class", "this");
        } else if (document.URL.endsWith("WebContent/")) {
            links_father[0].setAttribute("class", "this");
        }
    }
}
//type页面按分类显示
function typeSelect() {
    if (document.URL.indexOf('type') < 0) { return; } //    字符串的是否包含      ////////////!!!!!
    var box = document.getElementById("types");
    var links = box.getElementsByTagName('a');
    // alert(links[1].getAttribute("href"));
    for (var i = 0; i < links.length; i++) {
        links[i].forword = (links[i].getAttribute('href').split('#')[1]); //    将页内跳转的href属性去掉"#"   将跳转ID添加为元素的一个属性  ///!!!!!
        links[i].onclick = function() { showSection(this); return false; }; //     匿名函数不会被调用！直接添加括号会被调用！   ///////!!!!!

    }
    showSection(links[0]) //初始化选择第一个
}

function showSection(ID) {
    addClass(ID, "selected")
    $siblings = $(ID.parentNode).siblings(); ////////////////!!!!!
    for (var i = 0; i < $siblings.length; i++) {
        // var links = $siblings[i].firstChild;
        removeClass($siblings[i].firstChild, "selected");
    }

    var box = document.getElementById("goods"); //
    var sections = box.getElementsByTagName('section');
    for (var i = 0; i < sections.length; i++) {
        addClass(sections[i], "hide");
        if (sections[i].getAttribute("id") == ID.forword) {
            removeClass(sections[i], "hide");
        }
    }
}

//cart页面计算总价
function checkbox_listener() {
    if (document.URL.indexOf('cart') < 0) { return; }
    var goods_box = $('#goods_list').find("tr"); ////////////////!!!!!         转换成了DOM属性（List）
    for (var i = 0; i < goods_box.length - 1; i++) { //                   最后一栏是总价：length-1
        //goods_box[i].find("input:first");
        var is_checked = goods_box[i].getElementsByTagName("input")[2];
        var checked_number = goods_box[i].getElementsByTagName("input")[1];
        is_checked.setAttribute("onchange", "sumPrice()"); ////////////////!!!!!
        checked_number.setAttribute("onchange", "sumPrice()");
        // is_checked2.setAttribute("style", "background-color:white;");
    }
}

function sumPrice() {
    var sum = 0.00;
    var sum_box = $("#sum_box")[0].firstChild;
    var goods_box = $('#goods_list').find("tr"); //!!!!!////////////////!!!!!
    for (var i = 0; i < goods_box.length - 1; i++) { //        最后一栏是总价：length-1
        //goods_box[i].find("input:first");
        //价格td
        var price = goods_box[i].getElementsByClassName("one_price")[0].firstChild;
        var is_checked = goods_box[i].getElementsByTagName("input");
        if (is_checked[2].checked == true) { ////////!!!!!////////////////!!!!!////////////////!!!!!
            var price_box = (Number)(price.nodeValue) * (Number)(is_checked[1].value); ////////////////!!!!!
            sum += price_box;
        }
    }
    sum_box.nodeValue = parseFloat(sum).toFixed(parseInt(sum).toString.length + 1); ////////////////!!!!!
}

//cart页面图片放大效果
function biggerImg() {
    if (document.URL.indexOf('cart') < 0) { return; }
    var img_boxes = $("#goods_list>tr"); //最后一个不是
    for (var i = 0; i < img_boxes.length - 1; i++) {
        var img_box = img_boxes[i].getElementsByTagName("img");
        img_box[0].onclick = function() { clickImg(this) }
    }
}

function clickImg(ID) {
    if (!ID.getAttribute("src") || ID.getAttribute("src") == "") { return; }
    $(ID).toggleClass('checked') //                                              点击切换！！！
    $("body").toggleClass("disable")
}

//cart页面点击购买无选中效果
function submitBuy() {
    if (document.URL.indexOf('cart') < 0) { return; }
    var buy_button = document.getElementById("buy");
    buy_button.onclick = hasGoods;


}

function hasGoods() {
    var money = Number(document.getElementById("sum_box").firstChild.nodeValue);
    if (money <= 0) {
        alert("请上帝先选需要的宝贝！お願いします！");
        return false;
    } else {
        var goods_box = $('#goods_list').find("tr"); ////////////////!!!!!         转换成了DOM属性（List）
        for (var i = 0; i < goods_box.length - 1; i++) { //最后一栏是总价：length-1
            var is_checked = goods_box[i].getElementsByTagName("input")[3];
            if (is_checked.checked == true) {
                var box = is_checked.parentNode.parentNode;
                box.remove();
            }
        }
        //购物车清空判定
        var $box = $("#goods_list tr");
        if ($box.length <= 1) {
            var container = $("#container")[0];
            container.innerHTML = "<h2 id='clean'>您的购物车清空啦！！<span>土豪</span>，交个朋友呗！</h2>";
        } else {} /////////////////     页面不提交，需要用Ajax改！
    }
    return false;
}

//cart页面空购物车判定
function emptyCart() {
    if (document.URL.indexOf('cart') < 0) { return; }
    var $box = $("#goods_list tr");
    if ($box.length <= 1) {
        var container = $("#container")[0];
        container.innerHTML = "<h2 align='center' style='line-height:5rem'>您还没有选择宝贝哦！</h2>";
    } else {

    }
}
//修改页面密码判定
function modifyPassword() {
    if (document.URL.indexOf("mpassword") < 0) { return; }
    var $box = $("#modify input");
    var $submit = $box[3];
    $submit.onclick = function() {

        if (!$box[1].value || !$box[2].value) {
            alert("上大人请输入密码......")
            return false;
        } else if ($box[1].value != $box[2].value) {
            alert("上帝大人，两次输入的密码不同哦！");
            return false;
        } else {
            return true;
        }
    }
}

//注册页面判定
function registered() {
    if (document.URL.indexOf("registered") < 0) { return; }
    var $box = $("#registered input");
    var $submit = $("#registered input:last")[0];
    $submit.onclick = function() {
        if (!$box[5].value || !$box[6].value) {
            alert("电话和地址是给上帝寄宝贝的重要信息哦，请填写一下呗！");
            return false;
        } else if ($box[1].value != $box[2].value) {
            alert("两次密码不一样哦，萌新同志！");
            return false;
        } else {
            return true;
        }
    }
}

//管理员页面切换控制
function toggleTitle() {
    if (document.URL.indexOf("manager") < 0) { return; }
    var $sessions = $("#container section");
    var $lis = $("#title a");
    for (var z = 1; z < $sessions.length; z++) {
        addClass($sessions[z], "hide");
    }
    addClass($("#title a")[0], "select");
    $lis.hover(
        function() {
            var forward = $(this).attr("href").split("#")[1];
            for (var i = 0; i < $sessions.length; i++) {
                if ($sessions[i].getAttribute("id") != forward) {
                    addClass($sessions[i], "hide");
                    removeClass(this, "select");
                } else if ($sessions[i].getAttribute("id") == forward) {
                    removeClass($sessions[i], "hide");
                }
            }
            addClass(this, "select");
            var $lis_is = $("#title a");
            for (var i = 0; i < $lis_is.length; i++) {
                if ($lis_is[i] != this) {
                    removeClass($lis_is[i], "select");
                }
            }
        }
    );

}