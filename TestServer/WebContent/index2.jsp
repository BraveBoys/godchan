<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    String str = request.getParameter("param");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>


이름 : <%= request.getParameter("name") %><br>
    주소 : <%= request.getParameter("address") %><br>
    취미 : 
    <%
        // 체크박스는 배열로 처리해야 한다.
        String[] values = request.getParameterValues("hobby");
        if(values != null){
            for(int i=0; i<values.length; i++){        
    %>
        <%=values[i] %>
        
    <%
            }
        }
    %><br>
    파라미터 주소 : <%=str %>
    
</body>
</html>