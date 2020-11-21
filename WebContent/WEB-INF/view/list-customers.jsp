<%-- 
    Document   : list-customers
    Created on : Jun 3, 2020, 6:55:14 AM
    Author     : Bassey Oddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css"
            rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/css/style.css">
        
        <title>Registered Customers</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>CRM- customer relationship manager</h2>
            </div>
        </div>
        
        <!-- Adding the button for adding new customer details -->
        <input type="button" value="Add Customer"
            onclick="window.location.href='showFormForAdd'; return false;"
            class="add-button"
        />
        
        <!-- Adding a table to display customer data-->
        <div id="container">
            <div id="content">
                
                <!-- add our html table -->
                <table id="customer_table">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    
                    <!-- A foreach loop to population the rows with the required data -->
                    <c:forEach var="tempCustomer" items="${customers}">
                        
                        <!-- construct an update link with customer id -->
                        <c:url var="updateLink" value="/customer/showFormForUpdate">
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>
                        
                        <c:url var="deleteLink" value="/customer/deleteCustomer">
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>
                         
                        <tr>
                            <td>${tempCustomer.firstName}</td>
                            <td>${tempCustomer.lastName}</td>
                            <td>${tempCustomer.email} </td>
                            
                            <!-- pass the link into a href -->
                            <td>
                                <a href="${updateLink}">Update</a>
                                |
                                <a href="${deleteLink}"
                                   onclick="if(!(confirm('Are you sure you want to delete this customer'))) return false">Delete</a>
                            </td> 
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>