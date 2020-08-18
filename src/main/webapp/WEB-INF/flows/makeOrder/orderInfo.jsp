<%--
  Created by IntelliJ IDEA.
  User: luxa4
  Date: 30.07.2020
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Full information</title>
</head>
<body>
Full information about your order!

Адрес доставки:
${order.address.region}
${order.address.city}
${order.address.homeNumber}
${order.address.flat}


<a href="${flowExecutionUrl}&_eventId=cancel" class="btn btn-primary">Cancel</a>
<a href="${flowExecutionUrl}&_eventId=back" class="btn btn-primary">Back</a>
<a href="${flowExecutionUrl}&_eventId=makeOrder" class="btn btn-primary">Next</a>

</body>
</html>
