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
public class DiaDiem {
    private int MaDD;
    private String TenDD;
    private String TenSB;

    public DiaDiem() {
    }

    public DiaDiem(int MaDD,String TenDD,String TenSB) {
        this.MaDD=MaDD;
        this.TenDD=TenDD;
        this.TenSB=TenSB;
    }
    
    public int getMaDD(){
        return MaDD;
    }
    
    public void setMaDD(int MaDD){
        this.MaDD=MaDD;
    }

    public String getTenDD(){
        return TenDD;
    }
    
    public void setTenDD(String TenDD){
        this.TenDD=TenDD;
    }
    
    public String getTenSB(){
        return TenSB;
    }
    
    public void setTenSB(String TenSB){
        this.TenSB=TenSB;
    }
    
}
