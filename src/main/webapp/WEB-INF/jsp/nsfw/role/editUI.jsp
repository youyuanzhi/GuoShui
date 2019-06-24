<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>角色管理</title>
    <script type="text/javascript" src="${basePath }js/jquery/jquery-1.10.2.min.js"></script>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath }nsfw/role/editRole" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>角色管理</strong>&nbsp;-&nbsp;编辑角色</div></div>
    <div class="tableH2">编辑角色</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">角色名称：</td>
            <td><input type="text" name="name" value="${roleEdit.name}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">角色权限：</td>
            <td>
            	<label><input type="checkbox" id="gzzy" name="privilege" value="gzzy" > 工作主页 &nbsp;</label>
            	<label><input type="checkbox" id="xzgl" name="privilege" value="xzgl" > 行政管理 &nbsp;</label>
            	<label><input type="checkbox" id="hqfw" name="privilege" value="hqfw" > 后勤服务 &nbsp;</label>
            	<label><input type="checkbox" id="zxxx" name="privilege" value="zxxx" > 在线学习 &nbsp;</label>
            	<label><input type="checkbox" id="nsfw" name="privilege" value="nsfw" > 纳税服务 &nbsp;</label>
            	<label><input type="checkbox" id="wdkj" name="privilege" value="wdkj" > 我的空间 &nbsp;</label>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">状态：</td>
            <td>
            	<c:if test="${roleEdit.state == '1' }">
            		<label>
	            		<input type="radio" name="state" value="1" checked="checked"> 有效  &nbsp; 
	            	</label>
	            	<label>
	            		<input type="radio" name="state" value="0"> 无效  &nbsp; 
	            	</label>
            	</c:if>
            	<c:if test="${roleEdit.state == '0' }">
            		<label>
	            		<input type="radio" name="state" value="1" > 有效  &nbsp; 
	            	</label>
	            	<label>
	            		<input type="radio" name="state" value="0" checked="checked"> 无效  &nbsp; 
	            	</label>
            	</c:if>
            </td>
        </tr>
    </table>
    <input type="hidden" name="role_id" value="${roleEdit.role_id}"/>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
   
</form>
</body>
<script type="text/javascript">
	$(function (){
		var privilegesName = ${roleEdit.privilegesName };
		for(var i = 0 ; i < privilegesName.length ; i ++ ){
			if(privilegesName[i].value == "gzzy" ){
				$("#gzzy").prop('checked',true);
			}
			if(privilegesName[i].value == "xzgl" ){
				$("#xzgl").prop('checked',true);
			}
			if(privilegesName[i].value == "hqfw" ){
				$("#hqfw").prop('checked',true);
			}
			if(privilegesName[i].value == "zxxx" ){
				$("#zxxx").prop('checked',true);
			}
			if(privilegesName[i].value == "nsfw" ){
				$("#nsfw").prop('checked',true);
			}
			if(privilegesName[i].value == "wdkj" ){
				$("#wdkj").prop('checked',true);
			}
		}
		
	})
	
</script>
</html>