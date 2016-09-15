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
public class FullData {

    private Employee employee = new Employee();
    private HomeAdress homeAdress = new HomeAdress();
    private Schedule schedule = new Schedule();

    public Employee getEmployeeData(long idEmployee) {
        StringBuilder sqlQueryEmployee = new StringBuilder();
        sqlQueryEmployee.append("SELECT * FROM EmployeesTimetable.Employee where idEmployee =").append(idEmployee).append(";");
        try (
                Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sqlQueryEmployee.toString());) {
            rs.next();
            this.employee.setIdEmployee(idEmployee);
            this.employee.setFio(rs.getString("FIO"));
            this.employee.setAge(rs.getInt("Age"));
            this.employee.setSchedule_Id(rs.getLong("Schedule_Id"));
        } catch (SQLException ex) {
            Logger.getLogger(EmployesList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.employee;
    }

    public HomeAdress getHomeAdressData(long idEmployee) {
        StringBuilder sqlQueryHomeAdress = new StringBuilder();
        sqlQueryHomeAdress.append("SELECT * FROM EmployeesTimetable.HomeAdress where Employe_id =").append(idEmployee).append(";");
        try (
                Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sqlQueryHomeAdress.toString());) {
            rs.next();
            homeAdress.setIdHomeAdress(rs.getLong("idHomeAdress"));
            homeAdress.setAdress(rs.getString("Adress"));
            homeAdress.setDistrict(rs.getString("District"));
            homeAdress.setOkrug(rs.getString("Okrug"));
            homeAdress.setEmploye_id(idEmployee);
        } catch (SQLException ex) {
            Logger.getLogger(EmployesList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return homeAdress;
    }

    public Schedule getScheduleData(long idEmployee) {

        StringBuilder sqlQueryShedule = new StringBuilder();
        sqlQueryShedule.append("SELECT * FROM EmployeesTimetable.Schedule where idSchedule = ").append(this.getEmployeeData(idEmployee).getSchedule_Id()).append(";");
        try (
                Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sqlQueryShedule.toString());) {
            rs.next();
            schedule.setIdSchedule(rs.getLong("idSchedule"));
            schedule.setBegin(rs.getTime("Begin"));
            schedule.setEnd(rs.getTime("end"));
        } catch (SQLException ex) {
            Logger.getLogger(EmployesList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return schedule;
    }
}
