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


�̸� : <%= request.getParameter("name") %><br>
    �ּ� : <%= request.getParameter("address") %><br>
    ��� : 
    <%
        // üũ�ڽ��� �迭�� ó���ؾ� �Ѵ�.
        String[] values = request.getParameterValues("hobby");
        if(values != null){
            for(int i=0; i<values.length; i++){        
    %>
        <%=values[i] %>
        
    <%
            }
        }
    %><br>
    �Ķ���� �ּ� : <%=str %>
    
</body>
</html>