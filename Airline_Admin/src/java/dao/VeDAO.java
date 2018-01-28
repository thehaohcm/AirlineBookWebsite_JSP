/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Ve;

/**
 *
 * @author thehaohcm
 */
public interface VeDAO {
    public ArrayList<Ve> getListVe();
    public boolean deleteVe(int mahk);
    public boolean deleteVe(String mahk);
    public String getGiaVe(int mahk);
    public String getMaCB(int mahk);
}
