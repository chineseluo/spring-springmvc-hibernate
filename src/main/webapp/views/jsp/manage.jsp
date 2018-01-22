<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width ,initial-scale=1">
    <link href="/views/css/bootstrap.css" rel="stylesheet">
    <script src="/views/js/jquery-3.2.1.js" type="application/javascript"></script>
    <script src="/views/js/bootstrap.js" type="application/javascript"></script>
    <script src="/views/js/page.js" type="application/javascript"></script>
    <title>用户管理系统</title>
    <style>
        @media (min-width: 768px) {
            #search1 {
                width: 250px;
                margin-top: 51px;
                position: absolute;
                z-index: 1;
            }

            #search2 {
                margin: 10px 0;
            }

            .page_main {
                margin-left: 250px;
                margin-top: -20px;
            }
        }

            #tab2 {
                width: 250px;
                margin-left: 300px;
                position: absolute;
                z-index: 1;
            }

            .headPortrait {
                width: 300px;
                height: 300px;
            }
        .page{
            list-style: none;
        }
        .page>li{
            float: left;
            padding: 5px 10px;
            cursor: pointer;
        }
        .page .pageItem{
            border: solid thin #DDDDDD;
            margin: 5px;
        }
        .page .pageItemActive{
            border: solid thin #0099FF;
            margin: 5px;
            background-color: #0099FF;
            color:white;
        }
        .page .pageItem:hover{
            border: solid thin #0099FF;
            background-color: #0099FF;
            color:white;
        }
        .page .pageItemDisable{
            border: solid thin #DDDDDD;
            margin: 5px;
            background-color: #DDDDDD;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top">
    <div class="navbar-header">
        <a href="#" class="navbar-brand"><span class="glyphicon glyphicon-user"></span>用户管理系統</a>
    </div>
    <ul class="nav navbar-nav navbar-right" style="margin-right:25px">
        <li>
            <a href="#"><span class="badge " style="background:skyblue">首页</span></a>
        </li>
        <li>
            <a href="#"><span class="badge" style="background:skyblue">帮助</span></a>
        </li>
        <li>
            <a href="#"><span class="glyphicon glyphicon-off"></span>&nbsp;注销</a>
        </li>
    </ul>
    <!--侧边功能栏-->
    <div class="navbar-default navbar-collapse" style="margin-top:51px" id="search1">
        <ul class="nav">
            <li>
                <!--搜索-->
                <div class="input-group" id="search2">
                    <input type="text" class="form-control"/>
                    <span class="input-group-btn">
           					 <button type="button" class="btn btn-danger">
                			<span class="glyphicon glyphicon-search"></span>
							</button>
							<button type="button" class="btn btn-danger"> <span><strong>查询</strong></span></button>
							</span>
                </div>
            </li>
            <li>
                <a href="#demo1" data-toggle="collapse" class="btn-danger">个人信息</a>
                <ul class="nav collapse" id="demo1">
                    <li>
                        <a href="#pan1" data-toggle="tab">个人资料</a>
                    </li>
                    <li>
                        <a href="#pan2" data-toggle="tab">修改密码</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#demo2" data-toggle="collapse" class="btn-danger">用户信息</a>
                <ul class="nav collapse" id="demo2">
                    <li>
                        <a href="#pan3" data-toggle="tab" id="userinfo" >用户查询</a>
                    </li>
                    <li>
                        <a href="#pan4" data-toggle="tab">用户新增</a>
                    </li>
                    <li>
                        <a href="#pan5" data-toggle="tab">其他</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#demo3" data-toggle="collapse" class="btn-danger">职业管理</a>
                <ul class="nav collapse" id="demo3">
                    <li>
                        <a href="#pan6" data-toggle="tab" id="workinfo">职业信息</a>
                    </li>
                    <li>
                        <a href="#pan7" data-toggle="tab">职业新增</a>
                    </li>
                    <li>
                        <a href="#pan8" data-toggle="tab">其他</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#demo4" data-toggle="collapse" class="btn-danger">爱好管理</a>
                <ul class="nav collapse" id="demo4">
                    <li>
                        <a href="#pan9" data-toggle="tab" id="hobbyinfo">爱好信息</a>
                    </li>
                    <li>
                        <a href="#pan10" data-toggle="tab">爱好新增</a>
                    </li>
                    <li>
                        <a href="#pan11" data-toggle="tab">其他</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#demo5" data-toggle="collapse" class="btn-danger">系统公告</a>
        </ul>
    </div>
</nav>
<div class="page_main">
    <ol class="breadcrumb">
        <li>
            <a href="#">管理首页</a>
        </li>
        <li>
            <a href="#">栏目</a>
        </li>
        <li>
            <a href="#">增加栏目</a>
        </li>
    </ol>
</div>
<div class="tab-content" id="tab2">
    <div class="tab-pane " id="pan1">
        <span><strong><h3>个人信息</h3></strong></span>
        <span><strong><h4>姓名：某某某</h4></strong></span>
        <span><strong><h4>教师编号：0817</h4></strong></span>
        <span><strong><h4>职称：教授</h4></strong></span>
        <h1>Users:${users}</h1>
    </div>
    <div class="tab-pane" id="pan2">
        <span><strong><h3>修改密码</h3></strong></span>
        <div class="form-group">
            <label for="password" class="control-label">新密码</label>
            <input type="text" v-model="list.grade" id="password" class="form-control ">
        </div>
        <div class="form-group">
            <label for="passwordagain" class="control-label">确认密码</label>
            <input type="text" v-model="list.grade" id="passwordagain" class="form-control ">
        </div>
        <button type="button" class="btn btn-danger">提交</button>
        <button type="button" class="btn btn-danger">重置</button>
    </div>
    <div class="tab-pane" id="pan3">
        <div id="app">
            <table id="userTable" class="table table-bordered table-hover table-condensed" style="width:800px">
                <tr>
                    <th><input type="checkbox"/>用户名称</th>
                    <th>职业</th>
                    <th>邮箱</th>
                    <th>性别</th>
                    <th>生日</th>
                    <th>爱好</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
            </table>
            <ul class="page" id="page"></ul>
        </div>
        <form id="modifyuserpassword" action="http://localhost:8080/user/modifypassword" method="post" style="display:none">
            <div class="form-group" style="width:400px;margin-top: 20px;display:none;">
                <label for="userid" class="control-label">用户ID</label>
                <input name="id" type="text" id="userid" class="form-control" placeholder="用户ID" >
            </div>
            <div class="form-group" style="width:400px;margin-top: 20px;display:none;">
                <label for="newusername" class="control-label">用户名称</label>
                <input name="username" type="text" id="newusername" class="form-control"  readonly="readonly">
            </div>
            <div class="form-group" style="width:400px;margin-top: 20px;">
                <label for="newpassword" class="control-label">新密码</label>
                <input name="password" type="text" id="newpassword" class="form-control" placeholder="新密码" autofocus="autofocus" required="required">
            </div>
            <hr/>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <button type="submit" class="btn btn-info">保存</button>
                </div>
                <div class="btn-group" role="group">
                    <button type="reset" class="btn btn-success">重置</button>
                </div>
            </div>
        </form>
    </div>
    <div class="tab-pane" id="pan4">
        <form method="post" action="http://localhost:8080/user/saveuser">
            <div class="form-group headPortrait" style="width:400px;margin-top: 20px;">
                <img id="img" src="" width="200" height="200"/>
                <input type="file" name="file" id="file"/>
                <input type="button" value="上传" onclick="upload()"/>
            </div>
            <div class="form-group" style="width:400px;margin-top: 20px;">
                <label for="username" class="control-label">用户名称</label>
                <input type="text" name="username" id="username" class="form-control" placeholder="请输入您的用户名！" autofocus="autofocus"
                       required="required">
            </div>
            <div class="form-group" style="width:400px">
                <label for="userpassword" class="control-label">登陆密码</label>
                <input type="text" name="password" id="userpassword" class="form-control" placeholder="请输入您的密码！" required="required">
            </div>
            <div class="form-group" style="width:400px">
                <label for="userpwdagain" class="control-label">重复密码</label>
                <input type="text"  id="userpwdagain" class="form-control" placeholder="请输入您的确认密码！" required="required">
            </div>
            <div class="form-group" style="width:400px">
                <label for="email" class="control-label">电子邮箱</label>
                <input type="email" name="email" id="email" class="form-control" placeholder="请输入您的邮箱！" required="required">
            </div>
            <div class="form-group" style="width:400px">
                <label for="birthday" class="control-label">出生日期</label>
                <input type="text" name="birthday" id="birthday" class="form-control" placeholder="请选择您的出生日期！">
            </div>
            <div class="form-group">
                <label class="radio-inline">
                    <input type="radio" value="true" name="sex" >男性
                </label>
                <label class="radio-inline">
                    <input type="radio" value="false" name="sex" >女性
                </label>
            </div>
            <div class="form-group" style="width:400px">
                <label for="work">职业</label>
                <select id="work" class="form-control" name="work">
                    <option value="学生">学生</option>
                    <option value="老师">老师</option>
                    <option value="校长">校长</option>
                </select>
            </div>
            <div class="form-group" style="width:400px">
                </select>
                <label for="hobby">爱好</label>
                <select id="hobby" multiple class="form-control" name="hobby">
                    <option value="书法">书法</option>
                    <option value="乐器">乐器</option>
                    <option value="运动">运动</option>
                    <option value="编程">编程</option>
                </select>
            </div>
            <hr/>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <button type="submit" class="btn btn-info">保存</button>
                </div>
                <div class="btn-group" role="group">
                    <button type="reset" class="btn btn-success">重置</button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default">返回</button>
                </div>
            </div>
        </form>
    </div>
    <div class="tab-pane" id="pan5">无</div>
    <div class="tab-pane" id="pan6">
        职业信息
        <table id="workTable" class="table table-bordered table-hover table-condensed" style="width:800px">
            <tr>
                <th>序号</th>
                <th>职业名称</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
        </table>
        <form id="editworkform" action="http://localhost:8080/work/editwork" method="post" style="display:none">
            <div class="form-group" style="width:400px;margin-top: 20px;display:none;">
                <label for="editworkID" class="control-label">职业ID</label>
                <input name="id" type="text" id="editworkID" class="form-control" placeholder="职业ID" >
            </div>
            <div class="form-group" style="width:400px;margin-top: 20px;">
                <label for="editwork" class="control-label">职业名称</label>
                <input name="workname" type="text" id="editwork" class="form-control" placeholder="职业名称" autofocus="autofocus" required="required">
            </div>
            <hr/>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <button type="submit" class="btn btn-info">保存</button>
                </div>
                <div class="btn-group" role="group">
                    <button type="reset" class="btn btn-success">重置</button>
                </div>
            </div>
        </form>
    </div>
    <div class="tab-pane" id="pan7">
        职业新增
    <form action="http://localhost:8080/work/savework" method="post">
        <div class="form-group" style="width:400px;margin-top: 20px;">
            <label for="inputwork" class="control-label">职业名称</label>
            <input name="workname" type="text" id="inputwork" class="form-control" placeholder="职业名称" autofocus="autofocus"
                   required="required">
        </div>
        <hr/>
        <div class="btn-group btn-group-justified" role="group" aria-label="...">
            <div class="btn-group" role="group">
                <button type="submit" class="btn btn-info">保存</button>
            </div>
            <div class="btn-group" role="group">
                <button type="reset" class="btn btn-success">重置</button>
            </div>
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-default">返回</button>
            </div>
        </div>
    </form>
    </div>
    <div class="tab-pane" id="pan8">其他</div>
    <div class="tab-pane" id="pan9">
        爱好信息
        <table id="hobbyTable" class="table table-bordered table-hover table-condensed" style="width:800px">
            <tr>
                <th>序号</th>
                <th>爱好名称</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
        </table>
        <form id="edithobbyform" action="http://localhost:8080/hobby/edithobby" method="post" style="display:none">
            <div class="form-group" style="width:400px;margin-top: 20px;display:none;">
                <label for="edithobbyID" class="control-label">爱好ID</label>
                <input name="id" type="text" id="edithobbyID" class="form-control" placeholder="爱好ID" >
            </div>
            <div class="form-group" style="width:400px;margin-top: 20px;">
                <label for="edithobby" class="control-label">爱好名称</label>
                <input name="hobbyname" type="text" id="edithobby" class="form-control" placeholder="爱好名称" autofocus="autofocus" required="required">
            </div>
            <hr/>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <button type="submit" class="btn btn-info">保存</button>
                </div>
                <div class="btn-group" role="group">
                    <button type="reset" class="btn btn-success">重置</button>
                </div>
            </div>
        </form>
    </div>
    <div class="tab-pane" id="pan10">
        爱好新增
        <form action="http://localhost:8080/hobby/savehobby" method="post">
            <div class="form-group" style="width:400px;margin-top: 20px;">
                <label for="inputhobby" class="control-label">爱好名称</label>
                <input name="hobbyname" type="text" id="inputhobby" class="form-control" placeholder="爱好名称" autofocus="autofocus" required="required">
            </div>
            <hr/>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <button type="submit" class="btn btn-info">保存</button>
                </div>
                <div class="btn-group" role="group">
                    <button type="reset" class="btn btn-success">重置</button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default">返回</button>
                </div>
            </div>
        </form>
    </div>
    <div class="tab-pane" id="pan11">其他</div>
</div>
<script>
    function  upload() {
        //js file 对象
        var file=$("#file")[0].files[0];

        //js form
        var form=new FormData();
        form.append("file",file);

        //jquery ajax
        var opt={
            url:"http://localhost:8080/user/do_upload",
            type:"post",
            contentType:false,
            processData:false,
            data:form,
            success:function(data){
                var json=eval("("+data+")");
                $("#img").attr("src","/upload/"+json.url);
            }
        };
        $.ajax(opt);
    }

  // var pageCountFromUser=0;
    //图片加载
    $(function(){
        var p = new ImgPreview();
        p.preview({previewid:"imgupload1"});
    });
    $("#userinfo").click(function(){
        $("#userTable").find(".content").remove();
        var opt= {
            url: "http://localhost:8080/user/findAllUser",
            type: "post",
            success: function (data) {
                var dataObj = eval(data);
                $.each(dataObj, function (index, item) {
                    pageCountFromUser = index + 1;
                  //  alert(pageCountFromUser);
                    var userid = item.userid;
                    var workdemo = item.workbyuser.replace(/\[(.*)\]/, "$1");
                    var hobbydemo = item.userHobby.replace(/\[(.*)\]/, "$1");
                    var htmldemo = "<tr class='content'><td><input type='checkbox'/>" + item.username + "</td><td>" + workdemo + "</td><td>" + item.email + "</td><td>" + item.sex + "</td><td>" + item.birthday + "</td><td>" + hobbydemo + "</td><td>" + item.createDate + "</td><td><a href='javascript:void(0)'>【编辑】</a><a href='javascript:void(0)' onclick='finduser(" + userid + ")'>【修改密码】</a><a href='javascript:void(0)' onclick='removeuser(" + userid + ")'>【删除】</a></td></tr>";
                    $("#userTable").append(htmldemo);

                })
            }
        }
                $.ajax(opt);

    });
    //异步删除user
    function removeuser(userid) {
        $("#userTable").find(".content").remove();
        var removedata = {
            url: "http://localhost:8080/user/removeuser",
            type: "post",
            data: {"userid": userid},
            dataType: "json",
            success: function (data) {
                var dataOb = eval(data);
                $.each(dataOb, function (index, item) {
                    var userid = item.userid;
                    var workdemo=item.workbyuser.replace(/\[(.*)\]/,"$1");
                    var hobbydemo=item.userHobby.replace(/\[(.*)\]/,"$1");
                    var htmldemo="<tr class='content'><td><input type='checkbox'/>"+item.username+"</td><td>"+workdemo+"</td><td>"+item.email+"</td><td>"+item.sex+"</td><td>"+item.birthday+"</td><td>"+hobbydemo+"</td><td>"+item.createDate+"</td><td><a href='javascript:void(0)'>【编辑】</a><a href='javascript:void(0)' onclick='finduser("+userid+")'>【修改密码】</a><a href='javascript:void(0)' onclick='removeuser(" + userid + ")'>【删除】</a></td></tr>";
                    $("#userTable").append(htmldemo);
                })
            }
        }
        $.ajax(removedata);
    }
    //异步查询user
    function finduser(userid){
        alert("userid:"+userid)
        var editdata={
            url: "http://localhost:8080/user/finduser",
            type:"post",
            data:{"userid":userid},
            dataType: "json",
            success: function(data)  {
                var dataOb=eval(data);
                alert("dataOB"+dataOb)
                alert(dataOb.userid)
                $.each(dataOb,function (index,item) {
                    $("#modifyuserpassword").css({
                        display:"block"
                    })
                    $("#userid").val(dataOb.userid)
                    $("#username").val(dataOb.username)
                    $("#newpassword").val(dataOb.password)
                })
            }
        }
        $.ajax(editdata);
    }
    $("#workinfo").click(function(){
        $("#workTable").find(".content").remove();
            var opt={
                url: "http://localhost:8080/work/findAllWork",
                type:"post",
                success: function(data)  {
                    var dataObj=eval(data);
                  // alert(dataObj);
                    $.each(dataObj,function (index,item) {
                        var workid=item.workid;
                        var htmldemo="<tr class='content'><td>"+item.workid+"</td><td>"+item.workname+"</td><td>"+item.createname+"</td><td><a href='javascript:void(0)' onclick='findwork("+workid+")'>【编辑】</a><a href='javascript:void(0)' onclick='removework("+workid+")'>【删除】</a></td></tr>";
                        $("#workTable").append(htmldemo);
                    })
                },
                error: function() {
                    alert("请求失败")
                }
            };
            $.ajax(opt);
    });
    //异步删除work
    function removework(workid){
        $("#workTable").find(".content").remove();
        var removedata={
            url: "http://localhost:8080/work/removework",
            type:"post",
            data:{"workid":workid},
            dataType: "json",
            success: function(data)  {
                var dataOb=eval(data);
                $.each(dataOb,function (index,item) {
                    var workid=item.workid;
                    var htmldemo="<tr class='content'><td>"+item.workid+"</td><td>"+item.workname+"</td><td>"+item.createname+"</td><td><a href='javascript:void(0)' onclick='findwork("+workid+")'>【编辑】</a><a href='javascript:void(0)' onclick='removework("+workid+")'>【删除】</a></td></tr>";
                    $("#workTable").append(htmldemo);
                })
            }
        }
        $.ajax(removedata);
    }
    //查询workid对应的work
    function findwork(workid){
     alert("workid:"+workid)
        var editdata={
            url: "http://localhost:8080/work/findwork",
            type:"post",
            data:{"workid":workid},
            dataType: "json",
            success: function(data)  {
                var dataOb=eval(data);
                alert("dataOB"+dataOb)
                alert(dataOb.workid)
                $.each(dataOb,function (index,item) {
                    $("#editworkform").css({
                        display:"block"
                    })
                    $("#editworkID").val(dataOb.workid)
                    $("#editwork").val(dataOb.workname)
                })
            }
        }
        $.ajax(editdata);
    }
    //查询所有爱好
    $("#hobbyinfo").click(function(){
        $("#hobbyTable").find(".content").remove();
        var opt={
            url: "http://localhost:8080/hobby/findAllHobby",
            type:"post",
            success: function(data)  {
                var dataObj=eval(data);
                //alert(dataObj);
                $.each(dataObj,function (index,item) {
                  var hobbyid=item.hobbyid;
                    var htmldemo="<tr class='content'><td>"+item.hobbyid+"</td><td>"+item.hobbyname+"</td><td>"+item.createname+"</td><td><a href='javascript:void(0)' onclick='findhobby("+hobbyid+")'>【编辑】</a><a href='javascript:void(0)' id='removehobby' onclick='removehobby("+hobbyid+")' >【删除】</a></td></tr>";
                    $("#hobbyTable").append(htmldemo);
                })
            },
            error: function() {
                alert("请求失败")
            }
        };
        $.ajax(opt);
    });
    //异步修改hobby
    function findhobby(hobbyid){
        //$("#hobbyTable").find(".content").remove();
        var editdata={
            url: "http://localhost:8080/hobby/findhobby",
            type:"post",
            data:{"hobbyid":hobbyid},
            dataType: "json",
            success: function(data)  {
                var dataOb=eval(data);
              alert(dataOb.hobbyid)
                $.each(dataOb,function (index,item) {
                    $("#edithobbyform").css({
                        display:"block"
                    })
                    $("#edithobbyID").val(dataOb.hobbyid)
                $("#edithobby").val(dataOb.hobbyname)
                })
            }
        }
        $.ajax(editdata);
    }
    //异步删除hobby
function removehobby(hobbyid) {
    $("#hobbyTable").find(".content").remove();
    var removedata = {
        url: "http://localhost:8080/hobby/removehobby",
        type: "post",
        data: {"hobbyid": hobbyid},
        dataType: "json",
        success: function (data) {
            var dataOb = eval(data);
            $.each(dataOb, function (index, item) {
                var hobbyid = item.hobbyid;
                var htmldemo = "<tr class='content'><td>" + item.hobbyid + "</td><td>" + item.hobbyname + "</td><td>" + item.createname + "</td><td><a href='javascript:void(0)' onclick='findhobby(" + hobbyid + ")'>【编辑】</a><a href='javascript:void(0)' id='removehobby'  onclick='removehobby(" + hobbyid + ")'>【删除】</a></td></tr>";
                $("#hobbyTable").append(htmldemo);
            })
        }
    }
    $.ajax(removedata);
}
    $("form :input").blur(function () {
        var $parent = $(this).parent();
        //验证用户名
        if ($(this).is("#newusername")) {
            var nameVal = $(this).val().trim().length;
            var errorMsg = "用户名长度应该在6到20个字符之间"
            if (nameVal < 6 || nameVal > 20) {
                $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
            } else {
                $parent.find(".onError").remove()
            }
        }
        //验证密码
        if ($(this).is("#userpassword")) {
            var passwordVal = $(this).val().trim().length;
            var errorMsg = "密码长度应该在6到20个字符之间"
            if (passwordVal < 6 || passwordVal > 20) {
                $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
            } else {
                $parent.find(".onError").remove()
            }
        }
        //验证确认密码
        if ($(this).is("#userpwdagain")) {
            var userpassword = $("#userpassword").val()

            var userpwdagain = $(this).val()

            var userpwdagainVal = $(this).val().trim().length;
            var errorMsg = "确认密码长度应该在6到20个字符之间"
            if (userpwdagainVal < 6 || userpwdagainVal > 20) {
                $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
            } else {
                $parent.find(".onError").remove()
            }
            if (userpassword != userpwdagain) {
                alert(userpassword)
                alert(userpwdagain)
                alert("密码和重复密码必须相同")
            }
        }
    })

</script>
</body>

</html>