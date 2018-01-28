/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author thehaohcm
 */
public class ChuyenBay {
    private String MaCB;
    private String Hang;
    private String NgayDi;
    private String GioDi;
    private String NgayDen;
    private String GioDen;
    private int DiaDiem_Di;
    private int DiaDiem_Den;
    private int GiaVe;
    private int SLHKHT;
    private int SLHKTD;

    public ChuyenBay(String MaCB, String Hang, String NgayDi, String GioDi, String NgayDen, String GioDen, int DiaDiem_Di, int DiaDiem_Den, int GiaVe,int SLHKHT,int SLHKTD) {
        this.MaCB = MaCB;
        this.Hang = Hang;
        this.NgayDi = NgayDi;
        this.GioDi = GioDi;
        this.NgayDen = NgayDen;
        this.GioDen = GioDen;
        this.DiaDiem_Di = DiaDiem_Di;
        this.DiaDiem_Den = DiaDiem_Den;
        this.GiaVe = GiaVe;
        this.SLHKHT=SLHKHT;
        this.SLHKTD=SLHKTD;
    }

    public ChuyenBay() {
    }

    /**
     * @return the MaCB
     */
    public String getMaCB() {
        return MaCB;
    }

    /**
     * @param MaCB the MaCB to set
     */
    public void setMaCB(String MaCB) {
        this.MaCB = MaCB;
    }

    /**
     * @return the Hang
     */
    public String getHang() {
        return Hang;
    }

    /**
     * @param Hang the Hang to set
     */
    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    /**
     * @return the NgayDi
     */
    public String getNgayDi() {
        return NgayDi;
    }

    /**
     * @param NgayDi the NgayDi to set
     */
    public void setNgayDi(String NgayDi) {
        this.NgayDi = NgayDi;
    }

    /**
     * @return the GioDi
     */
    public String getGioDi() {
        return GioDi;
    }

    /**
     * @param GioDi the GioDi to set
     */
    public void setGioDi(String GioDi) {
        this.GioDi = GioDi;
    }

    /**
     * @return the NgayDen
     */
    public String getNgayDen() {
        return NgayDen;
    }

    /**
     * @param NgayDen the NgayDen to set
     */
    public void setNgayDen(String NgayDen) {
        this.NgayDen = NgayDen;
    }

    /**
     * @return the GioDen
     */
    public String getGioDen() {
        return GioDen;
    }

    /**
     * @param GioDen the GioDen to set
     */
    public void setGioDen(String GioDen) {
        this.GioDen = GioDen;
    }

    /**
     * @return the DiaDiem_Di
     */
    public int getDiaDiem_Di() {
        return DiaDiem_Di;
    }

    /**
     * @param DiaDiem_Di the DiaDiem_Di to set
     */
    public void setDiaDiem_Di(int DiaDiem_Di) {
        this.DiaDiem_Di = DiaDiem_Di;
    }

    /**
     * @return the DiaDiem_Den
     */
    public int getDiaDiem_Den() {
        return DiaDiem_Den;
    }

    /**
     * @param DiaDiem_Den the DiaDiem_Den to set
     */
    public void setDiaDiem_Den(int DiaDiem_Den) {
        this.DiaDiem_Den = DiaDiem_Den;
    }

    /**
     * @return the GiaVe
     */
    public int getGiaVe() {
        return GiaVe;
    }

    /**
     * @param GiaVe the GiaVe to set
     */
    public void setGiaVe(int GiaVe) {
        this.GiaVe = GiaVe;
    }
    
    public int getSLHKHT(){
        return SLHKHT;
    }
    
    public void setSLHKHT(int SLHKHT){
        this.SLHKHT=SLHKHT;
    }
    
    public int getSLHKTD(){
        return SLHKTD;
    }
    
    public void setSLHKTD(int SLHKTD){
        this.SLHKTD=SLHKTD;
    }
}
