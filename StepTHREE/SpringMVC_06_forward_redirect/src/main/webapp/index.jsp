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
    <p id="show_data"></p>
</div>
<script src="jquery.min.js"></script>
<script>
    const $showData = $('#show_data')
    $('#btn').click(function () {
        const url = '${pageContext.request.contextPath}/' + $('#path').val()
        $.get(url, function (data) {
            if (data instanceof Object) {
                $showData.text(JSON.stringify(data))
            }else {
                $showData.text(data)
            }
        })
    })
</script>
</body>
</html>
