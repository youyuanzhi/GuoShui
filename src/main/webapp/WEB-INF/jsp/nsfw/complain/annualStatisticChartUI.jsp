<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	//获取当前年份
	Calendar cal = Calendar.getInstance();
	int curYear = cal.get(Calendar.YEAR);//当前年份
	request.setAttribute("curYear", curYear);
	
	List yearList = new ArrayList();
	for(int i = curYear; i > curYear-5 ; i--){
		yearList.add(i);
	}
	request.setAttribute("yearList", yearList);
	
%>

<!DOCTYPE HTML>
<html>
  <head>
    <%@include file="/common/header.jsp"%>
    <title>年度投诉统计图</title>
  </head>
  <script type="text/javascript" src="${basePath }js/fusioncharts/fusioncharts.js"></script>
  <script type="text/javascript" src="${basePath }js/fusioncharts/themes/fusioncharts.theme.fusion.js"></script>
  <script type="text/javascript">
  
  //加载完dom元素后，执行
  $(document).ready(doAnnualStatistic());
  
  //根据年份统计投诉数
  function doAnnualStatistic(){
	  //1、获取年份
	  var year = $("#year option:selected").val();
	  if(year == "" || year == undefined){
		  year = "${curYear}";//默认当前年份
	  }
	  //2、根据年份统计
	  $.ajax({
		  url:"${basePath }nsfw/complain/complainGetAnnualStatisticData",
		  data:{"year":year},
		  type: "post",
		  dataType:"json",
		  success: function(data){
			  if(data != null && data != "" && data != undefined){
				  var revenueChart = new FusionCharts({
				        "type": "column2d",
				        "renderAt": "chartContainer",
				        "width": "600",
				        "height": "400",
				        "dataFormat": "json",
				        "dataSource":  {
			          	"chart": {
				            "caption": year + " 年度投诉数统计图",
				            "xAxisName": "月  份",
				            "yAxisName": "投  诉  数",
				            "theme": "fusion"
				         },
				         "data": [{
					        	 	"label":data.object[0].label,
					        	 	"value":data.object[0].value
				        	 	},{
					        	 	"label":data.object[1].label,
					        	 	"value":data.object[1].value
				        	 	},{
					        	 	"label":data.object[2].label,
					        	 	"value":data.object[2].value
				        	 	},
				        	 	{
					        	 	"label":data.object[3].label,
					        	 	"value":data.object[3].value
				        	 	},{
					        	 	"label":data.object[4].label,
					        	 	"value":data.object[4].value
				        	 	},{
					        	 	"label":data.object[5].label,
					        	 	"value":data.object[5].value
				        	 	},{
					        	 	"label":data.object[6].label,
					        	 	"value":data.object[6].value
				        	 	},{
					        	 	"label":data.object[7].label,
					        	 	"value":data.object[7].value
				        	 	},{
					        	 	"label":data.object[8].label,
					        	 	"value":data.object[8].value
				        	 	},{
					        	 	"label":data.object[9].label,
					        	 	"value":data.object[9].value
				        	 	},{
					        	 	"label":data.object[10].label,
					        	 	"value":data.object[10].value
				        	 	},{
					        	 	"label":data.object[11].label,
					        	 	"value":data.object[11].value
				        	 	}]
				      }

				  });
				revenueChart.render();
			  } else {
				  alert("统计投诉数失败！");
			  }
		  },
		  error: function(){alert("统计投诉数失败！");}
	  });
	  
  }
 
  </script>
  <body>
  	<br>
    <div style="text-align:center;width:100%;">
    	<select id="year" onchange="doAnnualStatistic()">
    		<c:forEach items="${yearList }" var="year">
    			<option value="${year }"  >${year }</option>
    		</c:forEach>
    	</select>
    </div>
    <br>
    <div id="chartContainer" style="text-align:center;width:100%;"></div>
    
    <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
  </body>
</html>
