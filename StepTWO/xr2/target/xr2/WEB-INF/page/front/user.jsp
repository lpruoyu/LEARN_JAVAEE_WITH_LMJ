<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="crt crt-nav-on crt-nav-type1 crt-main-nav-on crt-sidebar-on crt-layers-2">
<head>
    <title>M了个J-首页</title>
    <%@ include file="common/head.jsp" %>
</head>
<body>
<div class="crt-wrapper">
    <%@ include file="common/header.jsp" %>

    <div id="crt-container" class="crt-container">
        <%@ include file="common/nav.jsp" %>

        <div class="crt-container-sm">
            <div class="crt-paper-layers">
                <div class="crt-paper clear-mrg">
                    <section class="section">
                        <div class="crt-card crt-card-wide bg-primary text-center">
                            <div class="crt-card-avatar">
                                <img class="avatar avatar-195"
                                     src="${frontAsset}/img/avatar/avatar-195x195.png"
                                     width="195" height="195" alt="头像">
                            </div>
                            <div class="crt-card-info">
                                <h2 class="text-upper">${user.name}</h2>
                                <p class="text-muted">${user.job}</p>
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
                                <p><b>哈罗，我是${user.name}！</b><br>${user.intro}</p>
                            </div>
                        </div>
                    </section><!-- .section -->
                    <section class="section brd-btm padd-box">
                        <div class="row">
                            <div class="col-sm-12 clear-mrg">
                                <h2 class="title-thin text-muted">个人信息</h2>
                                <dl class="dl-horizontal clear-mrg">
                                    <dt class="text-upper">姓名</dt>
                                    <dd>${user.name}</dd>
                                    <dt class="text-upper">生日</dt>
                                    <dd>${user.birthdayString}</dd>
                                    <dt class="text-upper">住址</dt>
                                    <dd>${user.address}</dd>
                                    <dt class="text-upper">邮箱</dt>
                                    <dd><a href="mailto:666@qq.com">${user.email}</a></dd>
                                    <dt class="text-upper">电话</dt>
                                    <dd>${user.phone}</dd>
                                </dl>
                            </div><!-- .col-sm-6 -->
                        </div><!-- .row -->
                    </section><!-- .section -->
                    <c:if test="${not empty skills}">
                        <section class="section brd-btm padd-box">
                            <div class="row">
                                <div class="col-sm-12 clear-mrg">
                                    <h2 class="title-thin text-muted">专业技能</h2>
                                    <c:forEach items="${skills}" var="skill">
                                        <div class="progress-line crt-animate">
                                            <strong class="progress-title">${skill.name}</strong>
                                            <div class="progress-bar" data-text="${skill.levelString}"
                                                 data-value="${(skill.level + 1) * 0.25}"></div>
                                        </div>
                                    </c:forEach>
                                </div><!-- .col-sm-6 -->
                            </div><!-- .row -->
                        </section><!-- .section -->
                    </c:if>
                    <c:if test="${not empty user.traitList}">
                        <section class="section brd-btm padd-box">
                            <div class="row">
                                <div class="col-sm-12 clear-mrg">
                                    <h2 class="title-thin text-muted">个人特质</h2>
                                    <ul class="styled-list icon-list-col3 clear-mrg">
                                        <c:forEach items="${user.traitList}" var="trait">
                                            <li>${trait}</li>
                                        </c:forEach>
                                    </ul>
                                </div><!-- .col-sm-6 -->
                            </div><!-- .row -->
                        </section><!-- .section -->
                    </c:if>
                    <c:if test="${not empty user.interestsList}">
                        <section class="section brd-btm padd-box">
                            <div class="row">
                                <div class="col-sm-12 clear-mrg"><h2 class="title-thin text-muted">兴趣爱好</h2>
                                    <ul class="icon-list icon-list-col3 clearfix">
                                        <c:forEach items="${user.interestsList}" var="interests">
                                            <li><span class="crt-icon crt-icon-check-circle"></span>${interests}</li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </section><!-- .section -->
                    </c:if>
                    <c:if test="${not empty awards}">
                        <section class="section padd-box">
                            <h2 class="title-thin text-muted">获奖成就</h2>
                            <div class="row">
                                <c:forEach items="${awards}" var="award">
                                    <div class="col-sm-6 clear-mrg">
                                        <div class="award-box">
                                            <img class="award-img" src="${award.image}" alt="图片">
                                            <h3 class="award-title">${award.name}</h3>
                                            <div class="award-text text-muted clear-mrg"><p>${award.intro}</p></div>
                                        </div>
                                    </div><!-- .col-sm-6 -->
                                </c:forEach>
                            </div><!-- .row -->
                        </section><!-- .section -->
                    </c:if>
                </div>
                <!-- .crt-paper -->
            </div><!-- .crt-paper-layers -->
        </div><!-- .crt-container-sm -->
    </div>
    <!-- .crt-container -->
    <footer id="crt-footer" class="crt-container-lg">
        <div class="crt-container">
            <div class="crt-container-sm clear-mrg text-center"><p>${website.footer}</p></div>
        </div><!-- .crt-container -->
    </footer><!-- #crt-footer -->
    <svg id="crt-bg-shape-1" class="hidden-sm hidden-xs" height="519" width="758">
        <polygon class="pol" points="0,455,693,352,173,0,92,0,0,71"/>
    </svg>
    <svg id="crt-bg-shape-2" class="hidden-sm hidden-xs" height="536" width="633">
        <polygon points="0,0,633,0,633,536"/>
    </svg>
</div><!-- .crt-wrapper --><!-- Scripts -->

<%@ include file="common/foot.jsp" %>
</body>
</html>