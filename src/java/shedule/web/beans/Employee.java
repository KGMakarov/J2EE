/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shedule.web.beans;

/**
 *
 * @author macbook
 */
public class Employee {

    private long idEmployee;
    private String fio;
    private int age;
    private long schedule_Id;

    public Employee() {
    }

    public Employee(String fio, int age) {
        this.fio = fio;
        this.age = age;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchedule_Id(long schedule_Id) {
        this.schedule_Id = schedule_Id;
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public String getFio() {
        return fio;
    }

    public int getAge() {
        return age;
    }

    public long getSchedule_Id() {
        return schedule_Id;
    }
}
