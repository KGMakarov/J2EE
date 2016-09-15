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
public class HomeAdress {

    private long idHomeAdress;
    private String adress;
    private String district;
    private String okrug;
    private long employe_id;

    public HomeAdress() {
    }

    public HomeAdress(String adress, String district, String okrug) {
        this.adress = adress;
        this.district = district;
        this.okrug = okrug;
    }

    public void setIdHomeAdress(long idHomeAdress) {
        this.idHomeAdress = idHomeAdress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setOkrug(String okrug) {
        this.okrug = okrug;
    }

    public void setEmploye_id(long employe_id) {
        this.employe_id = employe_id;
    }

    public long getIdHomeAdress() {
        return idHomeAdress;
    }

    public String getAdress() {
        return adress;
    }

    public String getDistrict() {
        return district;
    }

    public String getOkrug() {
        return okrug;
    }

    public long getEmploye_id() {
        return employe_id;
    }

}
