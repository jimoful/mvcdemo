<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/6/1
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        div p{
            background: purple;
        }
        #first{
            height: 300px;
            width: 300px;
            background: gray;
            background-image: url("/image/abd.jpg");
            background-position: center,center;
            /*滚动时候图片是否移动*/
            background-attachment: local;
            margin: 20px 40px;
            padding: 20px;
            float: left;
            display:inline;
            /*border: 35px solid blue;*/
        }
        #second{
            height: 300px;
            width: 300px;
            background: orange;
            margin: 40px auto;
            padding: 20px;
            float: left;
            /*border: 35px solid blue;*/
            -moz-box-shadow: 10px 10px 5px #888888; /* 老的 Firefox */
            -webkit-box-shadow: #888888;
            transform:rotate(9deg);
            text-shadow: #185188;
            background:yellow;
            transition:width 2s, height 2s;
            -moz-transition:width 2s, height 2s, -moz-transform 2s; /* Firefox 4 */
            -webkit-transition:width 2s, height 2s, -webkit-transform 2s; /* Safari and Chrome */
            -o-transition:width 2s, height 2s, -o-transform 2s; /* Opera */
            /*-moz-box-shadow: 10px 10px 5px #888888; *//* 老的 Firefox */
            box-shadow: 10px 10px 5px #888888;
            position:relative;
            animation:mymove 5s infinite;
            -moz-animation:mymove 5s infinite; /* Firefox */
            -webkit-animation:mymove 5s infinite; /* Safari and Chrome */
            -o-animation:mymove 5s infinite; /* Opera */
        }
        /*自定义动画*/
        @keyframes mymove1
        {
            0%   {top:0px; background:red; width:100px;}
            100% {top:200px; background:yellow; width:300px;}
        }
        @keyframes mymove
        {
            from {top:0px;}
            to {top:200px;}
        }
        @-moz-keyframes mymove /* Firefox */
        {
        }
        @-webkit-keyframes mymove /* Safari and Chrome */
        {
        }
        @-o-keyframes mymove /* Opera */
        {
        }
        #second:hover{
            width: 400px;
            height: 400px;
            transform:rotate(0deg);
            -moz-transform:rotate(0deg); /* Firefox 4 */
            -webkit-transform:rotate(0deg); /* Safari and Chrome */
            -o-transform:rotate(0deg); /* Opera */
        }
        #p1{
            /*文本修饰，下划线*/
            text-decoration: underline;
            /*居中方式*/
            text-align: left;
            /*缩进*/
            text-indent: 20px;
            /*字间距*/
            letter-spacing: 1px;
            background: gray;

            /*先提供几种可选字体，在提供字体大类*/
            font-family: Monaco, Menlo, Consolas, "Courier New", monospace;
            /*斜体*/
            font-style: italic;
            font-weight: bold;
            line-height: 25px;
            font-size: 20px;
            /*sans serif*无衬线字体*/
            
        }
        /*其上方不允许浮动*/
        #clear{
            clear: both;
        }
        /*列表*/
        ul li{
            /*类型*/
            list-style-type: circle;
            text-overflow: ellipsis;
        }
        /*表格*/
        table{
            border-collapse: collapse;
            /*border-spacing: 20px;*/
        }
        table td{
            border: 1px solid blue;
            text-align: center;
        }
        a:link{
            color: #ffffff;
            text-decoration: none;
        }
        a:visited{
            color: blueviolet;
            text-decoration: none;
        }
        a:hover{
            color: #000000;
            text-decoration: dotted;
            background-image: url("/image/abd.jpg");
        }
        a:active{
            color: red;
        }
    </style>
</head>
<body>
    <div>
         <div id="first">一个盒子模型</div>
         <div id="second">一个盒子模型</div>
         <div id="clear" style="position: relative">一个盒子模型</div>
        <div>
        <p id="p1">    生物等效性试验是测试仿制药与原研药的效果是否一致。对此，国际通行的原则是，
            企业自主进行生物等效性测试，不需要经过官方机构审批，因为仿制药是按照原研药生产的，
            而原研药是经过市场证明过的优良产品，发生风险的可能性很低。</p>
        <p id="p2">但在中国，生物等效性测试是必须经过食药监局的药审中心审批的，
            据全球第四大制药企业赛诺菲亚太区高级副总裁李宁称，2014年的18500多件待审任务中，
            仿制药的生物等效性测试就占了约三分之一。</p>
            <ol>
                <li>1</li>
                <li>2</li>
                <li>3</li>
                <li>4</li>
            </ol>
            <ul>
                <li>1</li>
                <li>2</li>
                <li>3</li>
                <li>4</li>
            </ul>
            <table>
                <tr>
                    <td colspan="4">number</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                </tr>
                <tr>
                    <td>a</td>
                    <td>b</td>
                    <td>c</td>
                    <td rowspan="2">d</td>
                </tr>
                <tr>
                    <td>one</td>
                    <td>two</td>
                    <td>three</td>
                </tr>

            </table>
<a href="http://www.baidu.com" target="_blank" title="百度一下">百度</a>
<a href="boxmodel.jsp#pp1" target="_self" title="pp1">pp1锚点</a>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
            <a name="pp1"></a>
            <p>pp1</p>

        <br/>
        <br/>
        <br/>
        </div>
    </div>
</body>
</html>
