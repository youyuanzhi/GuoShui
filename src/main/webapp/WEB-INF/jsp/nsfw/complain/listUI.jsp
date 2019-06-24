<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>投诉受理管理</title>
    <script type="text/javascript" src="${basePath }js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
  	var list_url = "${basePath}nsfw/complain/listUI.action";
  	//搜索
  	function doSearch(){
  		//重置页号
  		$("#page").val(1);
  		document.forms[0].action = "${basePath}nsfw/complain/search.action";
  		document.forms[0].submit();
  	}
  	//受理
  	function doDeal(compId){
  		document.forms[0].action = "${basePath}nsfw/complain/dealUI.action?CId=" + compId;
  		document.forms[0].submit();
  	}
  	//投诉统计
  	function doAnnualStatistic(){
  		document.forms[0].action = "${basePath}nsfw/complain/annualStatisticChartUI";
  		document.forms[0].submit();
  	}
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>投诉受理管理</strong></div> </div>
                <div class="search_art">
                    <li>
                       	投诉标题：<textfield name="CTitle" cssClass="s_text"  cssStyle="width:160px;"/>
                    </li>
                    <li>
                       	投诉时间：<textfield id="CStarttime" name="CStarttime" cssClass="s_text"  cssStyle="width:160px;"
                       	 readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm:ss'});"/>
                              - 
                             <textfield id="CEndtime" name="CEndtime" cssClass="s_text"  cssStyle="width:160px;"
                              readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm:ss'});"/>
                    </li>
                    <li>
                       	状态：<property value="complainStatusMap[CStatus]"/>
                       	<%-- <select name="CStatus" list="" headerKey="" headerValue="全部"/> --%>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                    	<input type="button" value="统计" class="s_button" onclick="doAnnualStatistic()"/>&nbsp;
                    </li>

                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td align="center">投诉标题</td>
                            <td width="120" align="center">被投诉部门</td>
                            <td width="120" align="center">被投诉人</td>
                            <td width="140" align="center">投诉时间</td>
                            <td width="100" align="center">受理状态</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                      
                            <tr <if test="#st.odd"> bgcolor="f8f8f8" </if> >
                                <td align="center"></td>
                                <td align="center"></td>
                                <td align="center"></td>
                                <td align="center"></td>
                                <td align="center"></td>
                                <td align="center">
                                	
                                </td>
                            </tr>
                            
                        
                    </table>
                </div>
            </div>

        <%-- <jsp:include page="/common/pageNavigator.jsp"/> --%>
         总共:${tiao }&nbsp;条,
       总页数：${countPage } &nbsp;,当前第页,
       <a href="${basePath}nsfw/complain/listUI.action?page=1">首页</a>
       <if test="%{page==1 }">上一页</if>
       <if test="%{page>1 }">
       <a href="${basePath}nsfw/complain/listUI">上一页</a>
       </if>
       <if test="%{page==countPage}">下一页</if>
       <if test="%{page<countPage }">
       <a href="${basePath}nsfw/complain/listUI.action">下一页</a>
       </if>    
        <a href="${basePath}nsfw/complain/listUI.action">尾页</a>
        </div>
    </div>
</form>

</body>
</html>