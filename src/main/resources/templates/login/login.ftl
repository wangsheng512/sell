<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>胜哥干货后台系统</title>
    <link type="text/css" rel="stylesheet" href="css/normalize.css" />
    <link type="text/css" rel="stylesheet" href="css/demo.css" />
    <!--必要样式-->
    <link type="text/css" rel="stylesheet" href="css/component.css" />
    <!--[if IE]>
    <script src="js/html5.js"></script>
    <![endif]-->
</head>

<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎登录</h3>
                <form action="/sell/doLogin" role="form" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
                    </div>
                    <div class="mb2"><button class="act-but submit" href="javascript:;" style="color: #FFFFFF" type="submit">登录</button></div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/TweenLite.min.js"></script>
<script type="text/javascript" src="js/EasePack.min.js"></script>
<script type="text/javascript" src="js/rAF.js"></script>
<script type="text/javascript" src="js/demo-1.js"></script>
</body>
</html>