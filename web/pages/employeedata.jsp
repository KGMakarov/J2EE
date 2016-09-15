<%@page import="shedule.web.beans.Schedule"%>
<%@page import="shedule.web.beans.HomeAdress"%>
<%@page import="shedule.web.beans.Employee"%>
<%@page import="shedule.web.logic.FullData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file = "../WEB-INF/jspf/right_buttom.jspf"%>
<link href="../css_styles/style_employeedata.css" rel="stylesheet" type="text/css">

<jsp:useBean id="employeeFullData" class="shedule.web.logic.FullData" scope="page"/>


<div>
    <div class = "head">
        <b>Данные сотрудника</b>
    </div>



    <div>
        <%
            long idEmployee = 0L;
            try {
                idEmployee = Long.valueOf(request.getParameter("idEmployee"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            Employee ed = employeeFullData.getEmployeeData(idEmployee);
            HomeAdress ha = employeeFullData.getHomeAdressData(idEmployee);
            Schedule sc = employeeFullData.getScheduleData(idEmployee);
        %>
        <strong>Ф.И.О: </strong> <span><%=ed.getFio()%></span>
        <br/><strong>Возраст: </strong> <span><%=ed.getAge()%> лет</span>
        <br/><strong>Адрес: </strong> <span><%=ha.getAdress()%></span>  <span><strong>Район:</strong> <%=ha.getDistrict()%> </span> <span><strong>Округ:</strong> <%=ha.getOkrug()%></span> 
        <br/><strong>График работы: </strong> <span><%=sc.getBegin()%> - <%=sc.getEnd()%></span>
    </div>

</div>
<div class="sidebar2">
    <form action="main.jsp">
        <button class="add_button" type="submit" name="currentPage" value="1" >Назад к списку</button>
    </form> 
</div>
