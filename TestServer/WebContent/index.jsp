<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="/TestServer/BraveBoys/" method="get">
        �̸� : <input type="text" name="name" size="10"><br>
        �ּ� : <input type="text" name="password" size="30"><br>
        ��� :
            <input type="checkbox" name="hobby" value="game">����
            <input type="checkbox" name="hobby" value="travel">����
            <input type="checkbox" name="hobby" value="reading">����
            <br>
        <input type="submit" value="����">
    </form>


</body>
</html>