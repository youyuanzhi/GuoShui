<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>角色管理</title>
    <script type="text/javascript">
    
    
  	//全选、全反选
	function doSelectAll(){
		// jquery 1.6 前
		//$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
		//prop jquery 1.6+建议使用
		$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
	}
  	//新增
  	function doAdd(){
  		document.forms[0].action = "${basePath}nsfw/role/addUI";
  		document.forms[0].submit();
  	}
  	//编辑
  	function doEdit(id){
  		document.forms[0].action = "${basePath}nsfw/role/editUI?id="+id;
  		document.forms[0].submit();
  	}
  	//删除
  	function doDelete(id){
  		document.forms[0].action = "${basePath}nsfw/role_delete.action?role.roleId=" + id;
  		document.forms[0].submit();
  	}
  	//批量删除
  	function doDeleteAll(){
  		document.forms[0].action = "${basePath}nsfw/role_deleteSelected.action";
  		document.forms[0].submit();
  	}
  	var list_url = "${basePath}nsfw/role_listUI.action";
	//搜索
  	function doSearch(){
  		//重置页号
  		$("#pageNo").val(1);
  		document.forms[0].action = list_url;
  		document.forms[0].submit();
  	}
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>角色管理 </strong></div> </div>
                <div class="search_art">
                    <li>
                        角色名称：<textfield name="RName" cssClass="s_text" id="roleName"  cssStyle="width:160px;"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td width="120" align="center">角色名称</td>
                            <td align="center">权限</td>
                            <td width="80" align="center">状态</td>
                            <td width="120" align="center">操作</td>
                        </tr>
                       		<c:forEach items="${page.list }" var="role" >
                            <tr <c:if test="#st.odd">bgcolor="f8f8f8"</c:if> >
                                <td align="center"><input type="checkbox" name="selectedRow" value="${role.role_id }"/></td>
                                <td align="center">${role.name }</td>
                                <td align="center">
                                	<c:forEach items="${role.privileges }" var="privilege">
                                		${privilege.code } &nbsp;
                                	</c:forEach>	
                                </td>
                                <td align="center">${role.state == 1 ? "有效":"无效" }</td>
                                <td align="center">
                                    <a href="javascript:doEdit('${role.role_id }')">编辑</a>
                                    <a href="javascript:doDelete('${role.role_id }')">删除</a>
                                </td>
                            </tr>
                           </c:forEach>
                    </table>
                </div>
            </div>
			<%-- <jsp:include pageNum="/common/pageNavigator.jsp"/> --%>
			总共:${page.total }&nbsp;条记录,
                    总页数：${page.pages } &nbsp;,当前第${page.pageNum }页,
       <a href="${basePath}nsfw/role/listUI?pageNum=1">首页</a>
       <c:if test="${page.pageNum > 1}">
       <a href="${basePath}nsfw/role/listUI?page=${page.pageNum - 1}">上一页</a>
       </c:if>
       <c:if test="${page.pageNum < page.pages }">
       <a href="${basePath}nsfw/role/listUI?page=${page.pageNum + 1}">下一页</a>
       </c:if>
        <a href="${basePath}nsfw/role/listUI?page=${page.pages}">尾页</a>
        </div>
    </div>
</form>

</body>
</html>