<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath %>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="js/layui/css/layui.css">
<script src="js/layui/layui.js"></script>
<script src="js/echarts.min.js"></script>
</head>
<body>
<ul class="layui-nav">
	<li class="layui-nav-item layui-this"><a href="HomeData/show.do">实时数据</a></li>
	<li class="layui-nav-item"><a href="http://192.168.43.207:8082">家居实景</a></li>
	<li class="layui-nav-item">
		<a href="javascript:;"><img src="images/mine.jpg" class="layui-nav-img">我</a>
		<dl class="layui-nav-child">
			<dd><a href="javascript:;">修改信息</a></dd>
			<dd><a href="javascript:;">安全管理</a></dd>
			<dd><a href="javascript:;">退出</a></dd>
		</dl>
	</li>
</ul>
<script>
	layui.use('element',function(){
		var element=layui.element;
	});
</script>
<!-- 为Eaharts准备一个合适大小 的容器 dom-->
<div id="main" style="width:1280px;height:530px;"></div>
	<script type="text/javascript">
		//基于准备好的 dom ，初始化echarts实例
		var myChart=echarts.init(document.getElementById('main'));
		var arraytem=new Array;
		var indextem=0;
		var arrayhum=new Array;
		var indexhum=0;
		var arraysmoke=new Array;
		var indexsmoke=0;
		<c:forEach var="homeData" items="${homeDatas}">
			arraytem[indextem++]=${homeData.tem};
			arrayhum[indexhum++]=${homeData.hum};
			arraysmoke[indexsmoke++]=${homeData.smoke};
		</c:forEach>
		//指定图表的配置项和数据
		var option={
				title:{
					text:'我的家居环境'
				},
				tooltip:{
					show:true
				},
				legend:{
					data:['温度','湿度','可燃气体浓度']
				},
				calculable:true,
				xAxis:[
					{
						axisLabel:{
							rotate:30,
							interval:0
						},
						axisLine:{
							lineStyle:{
								color:'#000000'
							}
						},
						type:'category',
						boundaryGap:false,
						data:[
							<c:forEach var="homeData" items="${homeDatas}">
								["${homeData.date}"],
							</c:forEach>
						]
						
					}
				],
				yAxis:[
					{
						type:'value',
						axisLine:{
							lineStyle:{
								color:'#000000'
							}
						}
					}
				],
				series:[
					{
						name:'温度',
						type:'line',
						symbol:'none',
						smooth:0.2,
						color:['#CC0000'],
						data:arraytem
					},
					{
						name:'湿度',
						type:'line',
						symbol:'none',
						smooth:0.2,
						color:['#66AEDE'],
						data:arrayhum
					},
					{
						name:'可燃气体浓度',
						type:'line',
						symbol:'none',
						smooth:0.2,
						color:['FFA500'],
						data:arraysmoke
					}
				]
		};
		myChart.setOption(option);
	</script>

</body>
</html>