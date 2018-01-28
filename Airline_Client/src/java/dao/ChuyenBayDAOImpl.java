/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChuyenBay;

/**
 *
 * @author thehaohcm
 */
public class ChuyenBayDAOImpl implements ChuyenBayDAO {

    @Override
    public ArrayList<ChuyenBay> getListChuyenBay() {
        Connection connection=DBConnect.getConnection();
        String sql="SELECT * FROM qlvemaybay.chuyenbay;";
        ArrayList<ChuyenBay> arr=new ArrayList<>();
        //arr=null;
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ChuyenBay cb;
            while(rs.next()){
                cb=new ChuyenBay();
                cb.setMaCB(rs.getString("MaCB"));
                cb.setHang(rs.getString("Hang"));
                cb.setNgayDi(rs.getString("NgayDi"));
                cb.setGioDi(rs.getString("GioDi"));
                cb.setNgayDen(rs.getString("NgayDen"));
                cb.setGioDen(rs.getString("GioDen"));
                cb.setDiaDiem_Di(rs.getInt("DiaDiem_Di"));
                cb.setDiaDiem_Den(rs.getInt("DiaDiem_Den"));
                cb.setGiaVe(rs.getInt("GiaVe"));
                cb.setSLHKHT(rs.getInt("SLHKHT"));
                cb.setSLHKTD(rs.getInt("SLHKTD"));
                //if(cb!=null)
                    arr.add(cb);
            }
            connection.close();
        } catch (SQLException ex) {
            
        }
        return arr;
    }
    
    public ArrayList<ChuyenBay> getListChuyenBay(String NoiDi,String NoiDen,String Ngay){
        
        
        Connection connect=DBConnect.getConnection();
        
        String sql="SELECT * FROM qlvemaybay.chuyenbay WHERE `DiaDiem_Di`='"+NoiDi+"' AND `DiaDiem_Den`='"+NoiDen+"' AND `NgayDi`='"+Ngay+"';";
        
        ArrayList<ChuyenBay> arr=new ArrayList();
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            while(rs.next()){
                ChuyenBay cb=new ChuyenBay();
                cb.setMaCB(rs.getString("MaCB"));
                cb.setHang(rs.getString("Hang"));
                cb.setNgayDi(rs.getString("NgayDi"));
                cb.setGioDi(rs.getString("GioDi"));
                cb.setNgayDen(rs.getString("NgayDen"));
                cb.setGioDen(rs.getString("GioDen"));
                cb.setDiaDiem_Di(rs.getInt("DiaDiem_Di"));
                cb.setDiaDiem_Den(rs.getInt("DiaDiem_Den"));
                cb.setGiaVe(rs.getInt("GiaVe"));
                cb.setSLHKHT(rs.getInt("SLHKHT"));
                cb.setSLHKTD(rs.getInt("SLHKTD"));
                arr.add(cb);
            }
        }
        catch(SQLException ex){
            
        }
        return arr;
    }
    
    @Override
    public ArrayList<ChuyenBay> getListChuyenBaybyNgayDi(String NgayDi){
        Connection connection=DBConnect.getConnection();
        String sql="SELECT * FROM qlvemaybay.chuyenbay WHERE `NgayDi`='"+NgayDi+"';";
        ArrayList<ChuyenBay> arr=new ArrayList<>();
        //arr=null;
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChuyenBay cb=new ChuyenBay();
                cb.setMaCB(rs.getString("MaCB"));
                cb.setHang(rs.getString("Hang"));
                cb.setNgayDi(rs.getString("NgayDi"));
                cb.setGioDi(rs.getString("GioDi"));
                cb.setNgayDen(rs.getString("NgayDen"));
                cb.setGioDen(rs.getString("GioDen"));
                cb.setDiaDiem_Di(rs.getInt("DiaDiem_Di"));
                cb.setDiaDiem_Den(rs.getInt("DiaDiem_Den"));
                cb.setGiaVe(rs.getInt("GiaVe"));
                cb.setSLHKHT(rs.getInt("SLHKHT"));
                cb.setSLHKTD(rs.getInt("SLHKTD"));
                //if(cb!=null)
                    arr.add(cb);
            }
            connection.close();
        } catch (SQLException ex) {
            
        }
        return arr;
    }
    
    public ChuyenBay getEleChuyenBay(String macb){
        Connection connect=DBConnect.getConnection();
        String sql="SELECT * FROM qlvemaybay.chuyenbay WHERE `MaCB`='"+macb+"';";
        ChuyenBay cb=new ChuyenBay();
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            while(rs.next()){
                cb.setMaCB(rs.getString("MaCB"));
                cb.setHang(rs.getString("Hang"));
                cb.setNgayDi(rs.getString("NgayDi"));
                cb.setGioDi(rs.getString("GioDi"));
                cb.setNgayDen(rs.getString("NgayDen"));
                cb.setGioDen(rs.getString("GioDen"));
                cb.setDiaDiem_Di(rs.getInt("DiaDiem_Di"));
                cb.setDiaDiem_Den(rs.getInt("DiaDiem_Den"));
                cb.setGiaVe(rs.getInt("GiaVe"));
                cb.setSLHKHT(rs.getInt("SLHKHT"));
                cb.setSLHKTD(rs.getInt("SLHKTD"));
            }
        }
        catch(SQLException ex){
            
        }
        return cb;
    }
    
    public boolean updateCB(String macbcu,String macb,String ngaydi,String giodi,String ngayden,String gioden,int diadiemdi,int diadiemden,int giave,int slhktd){
        Connection connect=DBConnect.getConnection();
        //Chưa làm xong
        String sql="UPDATE `qlvemaybay`.`chuyenbay` SET `MaCB`='"+macb+"', `NgayDi`='"+ngaydi+"', `GioDi`='"+giodi+"', `NgayDen`='"+ngayden+"', `GioDen`='"+gioden+"', `DiaDiem_Di`='"+diadiemdi+"', `DiaDiem_Den`='"+diadiemden+"', `GiaVe`='"+giave+"', `SLHKTD`='"+slhktd+"' WHERE `MaCB`='"+macbcu+"';";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            boolean rs=pr.execute();
            connect.close();
            return true;
        }catch(SQLException ex){
            
        }
        return false;
    }
    public boolean addCB(String macb,String hang,String ngaydi,String giodi,String ngayden,String gioden,int diadiem_di,int diadiem_den,int giave,int slhktd){
        Connection connect=DBConnect.getConnection();
        String sql="INSERT INTO `qlvemaybay`.`chuyenbay` (`MaCB`, `Hang`, `NgayDi`, `GioDi`, `NgayDen`, `GioDen`, `DiaDiem_Di`, `DiaDiem_Den`, `GiaVe`, `SLHKHT`, `SLHKTD`) VALUES ('"+macb+"', '"+hang+"', '"+ngaydi+"', '"+giodi+"', '"+ngayden+"', '"+gioden+"', '"+diadiem_di+"', '"+diadiem_den+"', '"+giave+"', '0', '"+slhktd+"');";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            boolean rs=pr.execute();
            connect.close();
            return true;
        }
        catch(SQLException ex){
            
        }
        return false;
    }
    public boolean deleteCB(String macb){
        Connection connect=DBConnect.getConnection();
        String sql="DELETE FROM `qlvemaybay`.`chuyenbay` WHERE `MaCB`='"+macb+"';";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            boolean rs=pr.execute();
            connect.close();
            return true;
        }
        catch(SQLException ex){
            
        }
        return false;
    }
}
