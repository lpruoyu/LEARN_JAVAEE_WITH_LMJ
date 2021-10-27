<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setAttribute("ctx", request.getContextPath());%>
<!DOCTYPE html>
<html lang="en" class="crt crt-nav-on crt-nav-type1 crt-main-nav-on crt-sidebar-on crt-layers-2">
<head>
    <meta charset="utf-8">
    <title>lpruoyu-首页</title>
    <link href="${ctx}/static/asset/front/css/icmoon.css" rel="stylesheet"><!-- Styles -->
    <link href="${ctx}/static/asset/front/css/plugins.min.css" rel="stylesheet">
    <link href="${ctx}/static/asset/front/css/style.min.css" rel="stylesheet"><!-- Modernizer -->
    <link href="${ctx}/static/asset/front/css/main.css" rel="stylesheet"><!-- Modernizer -->
</head>
<body class="">
<div class="crt-wrapper">
    <header id="crt-header">
        <nav id="crt-nav-sm" class="crt-nav hidden-lg hidden-md">
            <ul class="clear-list">
                <li>
                    <a href="user.html">
                        <img class="avatar avatar-42" src="../asset/front/img/avatar/avatar-42x42.png" alt="">
                    </a>
                </li>
                <li><a href="education.html"><span
                        class="crt-icon crt-icon-book"></span></a></li>
                <li><a href="experience.html"><span
                        class="crt-icon crt-icon-experience"></span></a></li>
                <li><a href="project.html"><span
                        class="crt-icon crt-icon-wrench"></span></a></li>
                <li><a href="contact.html"><span
                        class="crt-icon crt-icon-contact"></span></a></li>
                <li><a href="../admin/user.html"><span
                        class="crt-icon crt-icon-key"></span></a></li>
            </ul>
        </nav><!-- #crt-nav-sm --></header><!-- #crt-header -->
    <div id="crt-container" class="crt-container">
        <div id="crt-nav-wrap" class="hidden-sm hidden-xs">
            <div id="crt-nav-inner">
                <div class="crt-nav-cont">
                    <div id="crt-nav-scroll">
                        <nav id="crt-nav" class="crt-nav">
                            <ul class="clear-list">
                                <li>
                                    <a href="user.html" data-tooltip="首页">
                                        <img class="avatar avatar-42" src="../asset/front/img/avatar/avatar-42x42.png"
                                             alt="">
                                    </a>
                                </li>
                                <li><a href="education.html" data-tooltip="教育经验"><span
                                        class="crt-icon crt-icon-book"></span></a></li>
                                <li><a href="experience.html" data-tooltip="工作经验"><span
                                        class="crt-icon crt-icon-experience"></span></a></li>
                                <li><a href="project.html" data-tooltip="项目经验"><span
                                        class="crt-icon crt-icon-wrench"></span></a></li>
                                <li><a href="contact.html" data-tooltip="联系我吧"><span
                                        class="crt-icon crt-icon-contact"></span></a></li>
                                <li><a href="../admin/user.html" data-tooltip="后台管理"><span
                                        class="crt-icon crt-icon-key"></span></a></li>
                            </ul>
                        </nav>
                    </div>
                    <div id="crt-nav-tools" class="hidden"><span class="crt-icon crt-icon-dots-three-horizontal"></span>
                        <button id="crt-nav-arrow" class="clear-btn"><span
                                class="crt-icon crt-icon-chevron-thin-down"></span></button>
                    </div>
                </div>
                <div class="crt-nav-btm"></div>
            </div>
        </div><!-- .crt-nav-wrap -->
        <div class="crt-container-sm">
            <div class="crt-paper-layers">
                <div class="crt-paper clear-mrg">
                    <section class="section">
                        <div class="crt-card crt-card-wide bg-primary text-center">
                            <div class="crt-card-avatar">
                                <img class="avatar avatar-195"
                                     src="../asset/front/img/avatar/avatar-195x195.png"
                                     width="195" height="195" alt=""></div>
                            <div class="crt-card-info">
                                <h2 class="text-upper">lpruoyu</h2>
                                <p class="text-muted">lpruoyu | 讲师</p>
                                <ul class="crt-social clear-list">
                                    <li><a><span class="crt-icon crt-icon-wechat"></span></a></li>
                                    <li><a><span class="crt-icon crt-icon-qq"></span></a></li>
                                    <li><a><span class="crt-icon crt-icon-weibo"></span></a></li>
                                    <li><a><span class="crt-icon crt-icon-github"></span></a></li>
                                    <li><a><span class="crt-icon crt-icon-blog"></span></a></li>
                                </ul>
                            </div>
                        </div>
                    </section><!-- .section -->
                    <section class="section brd-btm padd-box">
                        <div class="row">
                            <div class="col-sm-12 clear-mrg text-box"><h2 class="title-lg text-upper">关于我</h2>
                                <p><b>哈罗，我是lpruoyu！</b><br>本人学识渊博、经验丰富，代码风骚、效率恐怖，C/C++
                                    C#、Java、PHP、Android、iOS、Python、JavaScript，无不精通玩转，熟练掌握各种框架，并自写语言，创操作系统，写CPU处理器构架，做指令集成。深山苦练20余年，一天只睡3小时，千里之外定位问题，瞬息之间修复上线。身体强壮、健步如飞，可连续工作100小时不休息，讨论技术方案9小时不喝水，上至研发CPU芯片、带项目、出方案、弄计划，下至盗账号、黑网站、Shell提权挂马、攻击同行、拍片摄影、泡妞把妹纸、开挖掘机、威胁PM，啥都能干。
                                </p>
                            </div>
                        </div>
                    </section><!-- .section -->
                    <section class="section brd-btm padd-box">
                        <div class="row">
                            <div class="col-sm-12 clear-mrg">
                                <h2 class="title-thin text-muted">个人信息</h2>
                                <dl class="dl-horizontal clear-mrg">
                                    <dt class="text-upper">姓名</dt>
                                    <dd>lpruoyu</dd>
                                    <dt class="text-upper">生日</dt>
                                    <dd>1999-09-10</dd>
                                    <dt class="text-upper">住址</dt>
                                    <dd>广州市北京路</dd>
                                    <dt class="text-upper">邮箱</dt>
                                    <dd><a href="mailto:666@qq.com">666@qq.com</a></dd>
                                    <dt class="text-upper">电话</dt>
                                    <dd>136-4500-6868</dd>
                                </dl>
                            </div><!-- .col-sm-6 -->
                        </div><!-- .row -->
                    </section><!-- .section -->
                    <section class="section brd-btm padd-box">
                        <div class="row">
                            <div class="col-sm-12 clear-mrg">
                                <h2 class="title-thin text-muted">专业技能</h2>
                                <div class="progress-line crt-animate">
                                    <strong class="progress-title">Php & MySQL</strong>
                                    <div class="progress-bar" data-text="精通" data-value="1"></div>
                                </div>
                                <div class="progress-line crt-animate">
                                    <strong class="progress-title">Javascript</strong>
                                    <div class="progress-bar" data-text="掌握" data-value="0.75"></div>
                                </div>
                                <div class="progress-line crt-animate">
                                    <strong class="progress-title">UX Design</strong>
                                    <div class="progress-bar" data-text="熟悉" data-value="0.5"></div>
                                </div>
                                <div class="progress-line crt-animate">
                                    <strong class="progress-title">UI Design</strong>
                                    <div class="progress-bar" data-text="了解" data-value="0.25"></div>
                                </div>
                            </div><!-- .col-sm-6 -->
                        </div><!-- .row -->
                    </section><!-- .section -->
                    <section class="section brd-btm padd-box">
                        <div class="row">
                            <div class="col-sm-12 clear-mrg">
                                <h2 class="title-thin text-muted">个人特质</h2>
                                <ul class="styled-list icon-list-col3 clear-mrg">
                                    <li>学识渊博</li>
                                    <li>经验丰富</li>
                                    <li>学识渊博</li>
                                    <li>效率恐怖</li>
                                </ul>
                            </div><!-- .col-sm-6 --></div><!-- .row --></section><!-- .section -->
                    <section class="section brd-btm padd-box">
                        <div class="row">
                            <div class="col-sm-12 clear-mrg">
                                <h2 class="title-thin text-muted">兴趣爱好</h2>
                                <ul class="icon-list icon-list-col3 clearfix">
                                    <li><span class="crt-icon crt-icon-check-circle"></span>足球</li>
                                    <li><span class="crt-icon crt-icon-check-circle"></span>台球</li>
                                    <li><span class="crt-icon crt-icon-check-circle"></span>羽毛球</li>
                                    <li><span class="crt-icon crt-icon-check-circle"></span>电玩</li>
                                </ul>
                            </div>
                        </div>
                    </section><!-- .section -->
                    <section class="section padd-box">
                        <h2 class="title-thin text-muted">获奖成就</h2>
                        <div class="row">
                            <div class="col-sm-6 clear-mrg">
                                <div class="award-box">
                                    <img class="award-img" src="../asset/front/img/awards/award00.jpg" alt="">
                                    <h3 class="award-title">图灵奖</h3>
                                    <div class="award-text text-muted clear-mrg"><p>计算机界的诺贝尔奖</p></div>
                                </div>
                            </div><!-- .col-sm-6 -->
                            <div class="col-sm-6 clear-mrg">
                                <div class="award-box">
                                    <img class="award-img" src="../asset/front/img/awards/award01.jpeg" alt="">
                                    <h3 class="award-title">菲尔兹奖</h3>
                                    <div class="award-text text-muted clear-mrg"><p>数学界的诺贝尔奖</p></div>
                                </div>
                            </div><!-- .col-sm-6 -->
                        </div><!-- .row -->
                    </section><!-- .section -->
                </div>
                <!-- .crt-paper -->
            </div><!-- .crt-paper-layers -->
        </div><!-- .crt-container-sm -->
    </div>
    <!-- .crt-container -->
    <footer id="crt-footer" class="crt-container-lg">
        <div class="crt-container">
            <div class="crt-container-sm clear-mrg text-center"><p>lpruoyu &copy; All Rights Reserved 2020</p></div>
        </div><!-- .crt-container -->
    </footer><!-- #crt-footer -->
    <svg id="crt-bg-shape-1" class="hidden-sm hidden-xs" height="519" width="758">
        <polygon class="pol" points="0,455,693,352,173,0,92,0,0,71"/>
    </svg>
    <svg id="crt-bg-shape-2" class="hidden-sm hidden-xs" height="536" width="633">
        <polygon points="0,0,633,0,633,536"/>
    </svg>
</div><!-- .crt-wrapper --><!-- Scripts -->
<script src="../asset/front/js/modernizr-3.3.1.min.js"></script>
<script src="../asset/plugin/jquery/jquery.min.js"></script>
<script src="../asset/front/js/plugins.min.js"></script>
<script src="../asset/front/js/theme.min.js"></script>
</body>
</html>