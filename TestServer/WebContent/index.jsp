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
        이름 : <input type="text" name="name" size="10"><br>
        주소 : <input type="text" name="password" size="30"><br>
        취미 :
            <input type="checkbox" name="hobby" value="game">게임
            <input type="checkbox" name="hobby" value="travel">여행
            <input type="checkbox" name="hobby" value="reading">독서
            <br>
        <input type="submit" value="전송">
    </form>


</body>
</html>