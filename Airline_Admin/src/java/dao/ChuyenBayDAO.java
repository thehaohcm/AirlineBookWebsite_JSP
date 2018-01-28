/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.ChuyenBay;

/**
 *
 * @author thehaohcm
 */
public interface ChuyenBayDAO {
    
    public ArrayList<ChuyenBay> getListChuyenBay();
    public ArrayList<ChuyenBay> getListChuyenBaybyNgayDi(String NgayDi);
    public ArrayList<ChuyenBay> getListChuyenBay(String NoiDi,String NoiDen,String Ngay);
    public ChuyenBay getEleChuyenBay(String macb);
    public boolean updateCB(String macbcu,String hang,String macb,String ngaydi,String giodi,String ngayden,String gioden,int diadiemdi,int diadiemden,int giave,int slhktd);
    public boolean addCB(String macb,String hang,String ngaydi,String giodi,String ngayden,String gioden,int diadiem_di,int diadiem_den,int giave,int slhktd);
    public boolean deleteCB(String macb);
    public ChuyenBay getChuyenBay(int mahk);
}
