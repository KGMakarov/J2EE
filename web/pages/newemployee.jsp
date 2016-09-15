<%@page import="shedule.web.logic.AddEmployee"%>
<%@page import="java.sql.Time"%>
<%@page import="shedule.web.beans.Schedule"%>
<%@page import="shedule.web.beans.HomeAdress"%>
<%@page import="shedule.web.beans.Employee"%>
<%@page import="shedule.web.logic.FullData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file = "../WEB-INF/jspf/right_buttom.jspf"%>
<link href="../css_styles/style_employeedata.css" rel="stylesheet" type="text/css">

<jsp:useBean id="employeeFullData" class="shedule.web.logic.FullData" scope="page"/>
<%request.setCharacterEncoding("UTF-8");%>

<div>
    <div class = "head">
        <b>Данные сотрудника</b>
    </div>



    <div>
        <%
            String fio = "";
            int age = 0;
            String homeAdress = "";
            String district = "";
            String okrug = "";
            Time begin = new Time(0L);
            Time end = new Time(0L);

            try {
                fio = String.valueOf(request.getParameter("FIO"));
                age = Integer.valueOf(request.getParameter("Age"));
                homeAdress = String.valueOf(request.getParameter("Adress"));
                district = String.valueOf(request.getParameter("District"));
                okrug = String.valueOf(request.getParameter("Okrug"));
                begin = Time.valueOf(request.getParameter("Begin"));
                end = Time.valueOf(request.getParameter("end"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            Employee em = new Employee(fio, age);
            HomeAdress ha = new HomeAdress(homeAdress, district, okrug);
            Schedule sc = new Schedule(begin, end);

            AddEmployee.addShedule(sc);
            AddEmployee.addEmployee(em, sc.getIdSchedule());
            AddEmployee.addHomeAdress(ha, em.getIdEmployee());

            long idEmployee = em.getIdEmployee();

            Employee returned_em = employeeFullData.getEmployeeData(idEmployee);
            HomeAdress returned_ha = employeeFullData.getHomeAdressData(idEmployee);
            Schedule returned_sc = employeeFullData.getScheduleData(idEmployee);
        %>
        <strong>Ф.И.О: </strong> <span><%=returned_em.getFio()%></span>
        <br/><strong>Возраст: </strong> <span><%=returned_em.getAge()%> лет</span>
        <br/><strong>Адрес: </strong> <span><%=returned_ha.getAdress()%></span>  <span><strong>Район:</strong> <%=returned_ha.getDistrict()%> </span> <span><strong>Округ:</strong> <%=returned_ha.getOkrug()%></span> 
        <br/><strong>График работы: </strong> <span><%=returned_sc.getBegin()%> - <%=returned_sc.getEnd()%></span>
    </div>

</div>
<div class="sidebar2">
    <form action="main.jsp">
        <button class="add_button" type="submit" name="currentPage" value="1" >Назад к списку</button>
    </form> 
</div>
