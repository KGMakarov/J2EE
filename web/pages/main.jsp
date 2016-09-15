<%@page import="java.util.ArrayList"%>
<%@page import="shedule.web.beans.Employee"%>
<%@page import="shedule.web.logic.EmployesList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file = "../WEB-INF/jspf/right_buttom.jspf"%>

<jsp:useBean id="employesList" class="shedule.web.logic.EmployesList" scope="page"/>

<div class = "employesList">
    <ul class ="List">
        <%
            int currentPage = 0;
            try {
                currentPage = Integer.valueOf(request.getParameter("currentPage"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            ArrayList<Employee> el = employesList.getEmployeesList();
            final int ITEMS_PER_PAGE = 10;
            int start = (currentPage - 1) * ITEMS_PER_PAGE;
            int end = start + ITEMS_PER_PAGE;
            if (end > el.size()) {
                end = el.size();
            }

            for (int i = start; i < end; ++i) {
        %>
        <li><a class="listLinks" href ="employeedata.jsp?idEmployee=<%=el.get(i).getIdEmployee()%>"><%=el.get(i).getFio()%></a></li>
        <br/>
        <%}%>
    </ul>
</div>

<div class = "pages">
    <p> <%=EmployesList.makePagingLinks(currentPage, employesList.getEmployeesList().size(), ITEMS_PER_PAGE, "main.jsp")%></p>
</div>

