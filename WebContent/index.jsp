<%-- 
    Document   : index
    Created on : Jun 10, 2020, 8:05:33 PM
    Author     : Bassey Oddy
--%>
<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%response.sendRedirect("customer/list"); %>