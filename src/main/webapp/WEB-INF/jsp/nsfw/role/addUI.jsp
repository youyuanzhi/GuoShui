<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <script type="text/javascript" src="${basePath }/js/jquery/jquery-1.10.2.min.js "></script>
    <title>角色管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath }nsfw/role/addRole" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>角色管理</strong>&nbsp;-&nbsp;新增角色</div></div>
    <div class="tableH2">新增角色</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">角色名称：</td>
            <td>
           		 <input type="text" name="name" id="roleName" onblur="roleName1()"/>
           		 <span id="roleNameMsg"></span>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">角色权限：</td>
            <td>
            	
            	<label><input type="checkbox" name="privilege" value="gzzy" checked="checked" disabled="disabled">工作主页 &nbsp;</label>
            	<label><input type="checkbox" name="privilege" value="xzgl">行政管理 &nbsp;</label>
            	<label><input type="checkbox" name="privilege" value="hqfw">后勤服务 &nbsp;</label>
            	<label><input type="checkbox" name="privilege" value="zxxx">在线学习 &nbsp;</label>
            	<label><input type="checkbox" name="privilege" value="nsfw">纳税服务 &nbsp;</label>
            	<label><input type="checkbox" name="privilege" value="wdkj" checked="checked" disabled="disabled">我的空间 &nbsp;</label>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">状态：</td>
            <td>
            <label>  <input type="radio" name="state" value="1" checked="checked">有效 &nbsp; </label>
            <label>  <input type="radio" name="state" value="0">无效 &nbsp; </label>
            </td>
           
            
        </tr>
    </table>
    
    <div class="tc mt20">
        <input type="submit" class="btnB2"  value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div>
    </div>
    </div>
    
   
</form>
</body>
<script type="text/javascript">
	
	function roleName1(){
    var roleName= $("#roleName").val();
	$.ajax({
		type:"get",
		url:"${basePath}nsfw/role/getRoleNames",
		data:{roleName:roleName},
		success:function(data){
			$("#roleNameMsg").text(data.msg)
		}
	  })
	}

</script>

</html>