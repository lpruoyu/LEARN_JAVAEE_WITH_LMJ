<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mvc05</title>
</head>
<body>
<div><input id="path" type="text"></div>
<div>
    <button id="btn">获取数据</button>
</div>
<div>
    <p id="showInfo"></p>
</div>
<script src="jquery.min.js"></script>
<script>
    const $showInfo = $('#showInfo')
    $('#btn').click(function () {
        const url = '${pageContext.request.contextPath}/' + $('#path').val()
        $.get(url, function (data) {
            if (data instanceof Object) {
                $showInfo.text(JSON.stringify(data))
            } else {
                $showInfo.text(data)
            }
        })
        // $.getJSON(url, function (json) {
        //     console.log(json)
        // })
    })
</script>
</body>
</html>
