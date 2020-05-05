<%--
  Created by IntelliJ IDEA.
  User: Magic Systems
  Date: 5/4/2020
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% for (int i = 0; i <= 10; i++) {%>
Factorial of <%= i%> is
<%= computeFactorial(i)%> <br />
<% }%>
<%! private long computeFactorial(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * computeFactorial(n - 1);
    }
}

%>


</body>
</html>
