<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Message</title>
    <script>
        function get() {
            // 创建XMLHttpRequest对象
            const xhr = new XMLHttpRequest()
            // 配置请求方法和URL（第三个参数如果是true代表异步，false代表同步，默认是true）
            xhr.open('GET', 'http://localhost:8080/ajax/hello?message=hello_ajax_get')
            // 配置服务器返回数据的格式
            xhr.responseType = 'json'
            // 发送请求
            xhr.send()
            // 监听响应
            xhr.onload = function () {
                if (xhr.status !== 200) return
                console.log(xhr.response)
            }
        }

        function post() {
            const xhr = new XMLHttpRequest()
            xhr.open('POST', 'http://localhost:8080/ajax/hello')
            xhr.responseType = 'json'
            // 设置请求头（以表单形式提交）
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8')
            // 发送请求（如果是POST请求，需要传递请求体）
            xhr.send('message=hello_ajax_post')
            xhr.onload = function () {
                if (xhr.status !== 200) return
                console.log(xhr.response)
            }
        }

        function postFile() {
            const xhr = new XMLHttpRequest()
            xhr.open('POST', 'http://localhost:8080/ajax/hello')
            xhr.responseType = 'json'
            // 发送请求（表单-文件上传的形式）
            const body = new FormData()
            body.append('message', 'hello_ajax_post-file')
            xhr.send(body)
            xhr.onload = function () {
                if (xhr.status !== 200) return
                console.log(xhr.response)
            }
        }

    </script>
</head>
<body>
<button type="button" onclick="get()">get</button>
<br>
<button type="button" onclick="post()">post</button>
<br>
<button type="button" onclick="postFile()">post-file</button>
</body>
</html>