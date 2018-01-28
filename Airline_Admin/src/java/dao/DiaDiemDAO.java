/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.DiaDiem;

/**
 *
 * @author thehaohcm
 */
public interface DiaDiemDAO {
    public ArrayList<DiaDiem> getListDiaDiem();
    public DiaDiem getElebyMaDD(int MaDD);
    public String getTenSB(int TenDD);
    public String getTenDD(int TenSB);
    public boolean AddDiaDiem(int MaDD,String TenDD,String TenSB);
    public boolean deleteDD(int MaDD);
    public boolean updateDD(int MaDD,String TenDD,String TenSB);
}
