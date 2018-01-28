/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.HanhKhach;

/**
 *
 * @author thehaohcm
 */
public interface HanhKhachDAO {
    public ArrayList<HanhKhach> getListHanhKhach();
    public HanhKhach getHanhKhachbymahk(int mahk);
    public ArrayList<HanhKhach> getListHanhKhachbyEmail(String email);
    public ArrayList<HanhKhach> getListHanhKhachbyMaCB(String MaCB);
    public boolean DeleteHK(String mahk);
    public boolean AddHK(String macb,String hoten,String cmnd,String sdt,String dchi,String email);
    public int getMaHK(String hoten,String cmnd,String sdt,String dchi,String email);
    public boolean updateHanhKhach(int mahk,String tenhk,String cmnd,String sdt,String dchi,float hanhly,String email);
}
