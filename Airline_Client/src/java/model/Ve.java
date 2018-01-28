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
public class Ve {
    private String MaCB;
    private int MaHK;
    private int GiaVe;

    public Ve() {
    }

    public Ve(String MaCB, int MaHK,int GiaVe) {
        this.MaCB=MaCB;
        this.MaHK=MaHK;
        this.GiaVe=GiaVe;
    }

    public int getMaHK(){
        return MaHK;
    }
    
    public void setMaHK(int MaHK){
        this.MaHK=MaHK;
    }
    
    public String getMaCB(){
        return MaCB;
    }
    
    public void setMaCB(String MaCB){
        this.MaCB=MaCB;
    }
    
    public int getGiaVe(){
        return GiaVe;
    }
    
    public void setGiaVe(int GiaVe){
        this.GiaVe=GiaVe;
    }
}
