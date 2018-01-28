/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author thehaohcm
 */
public class HanhKhach {
    private int MaHK;
    private String HoTen;
    private String CMND;
    private String SoDT;
    private String DChi;
    private float HanhLy;
    private String Email;

    public HanhKhach(int MaHK, String HoTen, String CMND, String SoDT, String DChi, float HanhLy, String Email) {
        this.MaHK = MaHK;
        this.HoTen = HoTen;
        this.CMND = CMND;
        this.SoDT = SoDT;
        this.DChi = DChi;
        this.HanhLy = HanhLy;
        this.Email = Email;
    }
    
    public HanhKhach(String HoTen,String CMND,String SoDT,String DChi,float HanhLy, String Email){
        this.HoTen = HoTen;
        this.CMND = CMND;
        this.SoDT = SoDT;
        this.DChi = DChi;
        this.HanhLy = HanhLy;
        this.Email = Email;
    }
    
    public HanhKhach(String HoTen,String CMND,String SoDT,String DChi, String Email){
        this.HoTen = HoTen;
        this.CMND = CMND;
        this.SoDT = SoDT;
        this.DChi = DChi;
        this.Email = Email;
    }

    public HanhKhach() {
    }

    /**
     * @return the MaHK
     */
    public int getMaHK() {
        return MaHK;
    }

    /**
     * @param MaHK the MaHK to set
     */
    public void setMaHK(int MaHK) {
        this.MaHK = MaHK;
    }

    /**
     * @return the HoTen
     */
    public String getHoTen() {
        return HoTen;
    }

    /**
     * @param HoTen the HoTen to set
     */
    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    /**
     * @return the CMND
     */
    public String getCMND() {
        return CMND;
    }

    /**
     * @param CMND the CMND to set
     */
    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    /**
     * @return the SoDT
     */
    public String getSoDT() {
        return SoDT;
    }

    /**
     * @param SoDT the SoDT to set
     */
    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    /**
     * @return the DChi
     */
    public String getDChi() {
        return DChi;
    }

    /**
     * @param DChi the DChi to set
     */
    public void setDChi(String DChi) {
        this.DChi = DChi;
    }

    /**
     * @return the HanhLy
     */
    public float getHanhLy() {
        return HanhLy;
    }

    /**
     * @param HanhLy the HanhLy to set
     */
    public void setHanhLy(float HanhLy) {
        this.HanhLy = HanhLy;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    
}
