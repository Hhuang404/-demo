<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <title>Freemarker入门小DEMO </title>
</head>
<body>

<#--加载其他页面-->
<#include "head.ftl">

<#--我只是一个注释，我不会有任何输出  -->
${name},你好。${message}</br>

<#assign linkman="黄先生"></br>
联系人：${linkman}</br>

<#assign info={"mobile":"13301231212",'address':'北京市昌平区王府街'} ></br>
电话：${info.mobile}  地址：${info.address}</br>

<#--if语句-->
<#if flag=true>
    flag 为true
</#if>
<#if flag=false>
    flag 为false
</#if>
</br>
----商品价格表----<br>
<#list goodsList as goods>
    ${goods_index+1} 商品名称： ${goods.name} 价格：${goods.price}<br>
</#list>
</br>
共#{goodsList?size}条记录

<#--JSON字符串转换成JSON对象-->
<#assign test="{'name':'pite','sex':'boy'}"/>
<#assign data=test?eval/>
姓名：${data.name} 性别：${data.sex}
</br>
当前日期：${today?date} <br>
当前时间：${today?time} <br>
当前日期+时间：${today?datetime} <br>
日期格式化：  ${today?string("yyyy年MM月")}
</br>
数字会分隔符：${point}
</br>
转换为字符串：${point?c}
</br>
<#if any??>
    any变量存在
<#else>
    any变量不存在
</#if>
</br>
${any!"如果不对any赋值，会显示此内容"}
</br>
加${1+2}
乘${1*2}
除${1/2}
求膜${1%2}
</body>
</html>
