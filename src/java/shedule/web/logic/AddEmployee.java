/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shedule.web.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import shedule.web.beans.Employee;
import shedule.web.beans.HomeAdress;
import shedule.web.beans.Schedule;
import shedule.web.db.DBConnection;

/**
 *
 * @author macbook
 */
public class AddEmployee {

    public static void addShedule(Schedule schedule) {
        StringBuilder sqlQueryShedule = new StringBuilder();
        sqlQueryShedule.append("INSERT INTO `EmployeesTimetable`.`Schedule` (`Begin`, `end`) VALUES ('")
                .append(schedule.getBegin()).append("', '").append(schedule.getEnd()).append("');");
        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sqlQueryShedule.toString(), Statement.RETURN_GENERATED_KEYS);) {

            int affectedRows = stm.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating shedule failed, no rows affected.");
            }

            try (ResultSet rs = stm.getGeneratedKeys()) {
                if (rs.next()) {
                    schedule.setIdSchedule(rs.getLong(1));
                } else {
                    throw new SQLException("Creating shedule failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployesList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addEmployee(Employee employee, long schedule_Id) {
        StringBuilder sqlQueryEmployee = new StringBuilder();
        sqlQueryEmployee.append("INSERT INTO `EmployeesTimetable`.`Employee` (`FIO`, `Age`, `Schedule_Id`) VALUES ('")
                .append(employee.getFio()).append("', '").append(employee.getAge()).append("', '").append(schedule_Id).append("');");
        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sqlQueryEmployee.toString(), Statement.RETURN_GENERATED_KEYS);) {

            int affectedRows = stm.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating shedule failed, no rows affected.");
            }

            try (ResultSet rs = stm.getGeneratedKeys()) {
                if (rs.next()) {
                    employee.setIdEmployee(rs.getLong(1));
                } else {
                    throw new SQLException("Creating shedule failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployesList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addHomeAdress(HomeAdress homeAdress, long employe_id) {
        StringBuilder sqlQueryHomeAdress = new StringBuilder();
        sqlQueryHomeAdress.append("INSERT INTO `EmployeesTimetable`.`HomeAdress` (`Adress`, `District`, `Okrug`, `Employe_id`) VALUES ('")
                .append(homeAdress.getAdress()).append("', '").append(homeAdress.getDistrict()).append("', '").append(homeAdress.getOkrug()).append("', '").append(employe_id).append("');");
        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sqlQueryHomeAdress.toString(), Statement.RETURN_GENERATED_KEYS);) {

            int affectedRows = stm.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating shedule failed, no rows affected.");
            }

            try (ResultSet rs = stm.getGeneratedKeys()) {
                if (rs.next()) {
                    homeAdress.setIdHomeAdress(rs.getLong(1));
                } else {
                    throw new SQLException("Creating shedule failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployesList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
