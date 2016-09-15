/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shedule.web.beans;

import java.sql.Time;

/**
 *
 * @author macbook
 */
public class Schedule {

    private long idSchedule;
    private Time begin;
    private Time end;

    public Schedule() {
    }

    public Schedule(Time begin, Time end) {
        this.begin = begin;
        this.end = end;
    }

    public void setIdSchedule(long idSchedule) {
        this.idSchedule = idSchedule;
    }

    public void setBegin(Time begin) {
        this.begin = begin;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public long getIdSchedule() {
        return idSchedule;
    }

    public Time getBegin() {
        return begin;
    }

    public Time getEnd() {
        return end;
    }
}
