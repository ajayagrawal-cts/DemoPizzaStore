<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>O2 Pizza Store</title>
</head>
<body>
<h2>Welcome to Pizza Store</h2>
<form:form method="post" action="saveOrder.html">
 
    <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" size="50"/></td>
    </tr>
    <tr>
        <td><form:label path="address">Address</form:label></td>
        <td><form:input path="address" length="150"/></td>
    </tr>
    <tr>
        <td><form:label path="noOfPizzas">No. of Pizzas</form:label></td>
        <td><form:input path="noOfPizzas"/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Place Order"/>
        </td>
    </tr>
</table> 
     
</form:form>
</body>
</html>