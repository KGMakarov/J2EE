/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shedule.web.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import shedule.web.beans.Employee;
import shedule.web.db.DBConnection;

/**
 *
 * @author macbook
 */
public class EmployesList {

    private ArrayList<Employee> employeesList = new ArrayList<Employee>();

    private ArrayList<Employee> getEmployees() {
        try (
                Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("select * from EmployeesTimetable.Employee order by FIO;");) {
            while (rs.next()) {
                Employee currentEmpl = new Employee();
                currentEmpl.setIdEmployee(rs.getLong("idEmployee"));
                currentEmpl.setFio(rs.getString("FIO"));
                currentEmpl.setAge(rs.getInt("Age"));
                currentEmpl.setSchedule_Id(rs.getLong("Schedule_Id"));
                employeesList.add(currentEmpl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployesList.class.getName()).log(Level.SEVERE, null, ex);

        }
        return employeesList;
    }

    public ArrayList<Employee> getEmployeesList() {
        if (!employeesList.isEmpty()) {
            return employeesList;
        } else {
            return getEmployees();
        }
    }

    static public String makePagingLinks(int currentPageNumber,
            int totalItems, int itemsPerPage, String pageLocation) {

        StringBuilder ret = new StringBuilder();
        ret.append("");

        if (totalItems <= itemsPerPage) {
            return ret.toString();
        }
        int totalPages = (totalItems / itemsPerPage);
        if (totalItems % itemsPerPage != 0) {
            totalPages++;
        }

        if (totalItems <= currentPageNumber * itemsPerPage) {
            currentPageNumber = totalPages;
        }
        int start = currentPageNumber - 3;
        if (start <= 0) {
            start = 1;
        }
        int end = currentPageNumber + 3;
        if (end >= totalPages) {
            end = totalPages;
        }
        if (start > 1) {
            ret.append("<a href='").append(pageLocation).append("?currentPage=1").append("\'>1</a> ");
        }
        if (start > 2) {
            ret.append("..., ");
        }
        for (int i = start; i <= end; i++) {
            if (i == currentPageNumber) {
                ret.append("<span style=\"font-weight: bold;color: black;\">").append(i).append("</span>");
            } else {
                ret.append("<a href='").append(pageLocation).append("?currentPage=").append(i).append("'>").append(i).append("</a>");
            }
            if (i < totalPages) {
                ret.append(", ");
            }
        }
        if (end + 1 < totalPages) {
            ret.append("..., ");
        }
        if (end < totalPages) {
            if (totalPages == currentPageNumber) {
                ret.append("<strong>").append(totalPages).append("</strong>");
            } else {
                ret.append("<a href='").append(pageLocation).append("?currentPage=").append(totalPages).append("'>").append(totalPages).append("</a>");
            }
        }
        ret.append("  ");
        return ret.toString();
    }

}
