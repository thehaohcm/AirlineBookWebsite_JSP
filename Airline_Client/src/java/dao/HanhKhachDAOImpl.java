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
import model.HanhKhach;


public class HanhKhachDAOImpl implements HanhKhachDAO {

    @Override
    public ArrayList<HanhKhach> getListHanhKhach() {
        Connection connect=DBConnect.getConnection();
        String sql="SELECT * FROM qlvemaybay.hanhkhach;";
        ArrayList<HanhKhach> arr=new ArrayList();
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            while(rs.next()){
                HanhKhach hk=new HanhKhach(rs.getInt("MaHK"),rs.getString("HoTen"),rs.getString("CMND"),rs.getString("SoDT"),rs.getString("DChi"),rs.getFloat("HanhLy"),rs.getString("Email"));
                arr.add(hk);
            }
            connect.close();
            return arr;
        }
        catch(SQLException ex){
            
        }
        return arr;
    }

    
    @Override
    public HanhKhach getHanhKhachbymahk(int mahk) {
        Connection connect=DBConnect.getConnection();
        HanhKhach hk=new HanhKhach();
        //hk=null;
        String sql="SELECT * FROM qlvemaybay.hanhkhach where MaHK='"+mahk+"';";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            if(rs.next())
            {
                hk.setMaHK(rs.getInt("MaHK"));
                hk.setHoTen(rs.getString("HoTen"));
                hk.setCMND(rs.getString("CMND"));
                hk.setSoDT(rs.getString("SoDT"));
                hk.setDChi(rs.getString("DChi"));
                hk.setHanhLy(rs.getFloat("HanhLy"));
                hk.setEmail(rs.getString("Email"));
                
                connect.close();
            }
        }
        catch(SQLException ex){
            //hk=null;
        }
        
        return hk;
    }
    
    @Override
    public ArrayList<HanhKhach> getListHanhKhachbyEmail(String email) {
        Connection connect=DBConnect.getConnection();
        ArrayList<HanhKhach> arr=new ArrayList();
//        String sql="SELECT * FROM qlvemaybay.hanhkhach where Email='"+email+"';";
        String sql="SELECT * FROM qlvemaybay.hanhkhach where Email='"+email+"';";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            while(rs.next()){
                HanhKhach hk = new HanhKhach();
                //hk=null;
                hk.setMaHK(rs.getInt("MaHK"));
                hk.setHoTen(rs.getString("HoTen"));
                hk.setCMND(rs.getString("CMND"));
                hk.setSoDT(rs.getString("SoDT"));
                hk.setDChi(rs.getString("DChi"));
                hk.setHanhLy(rs.getFloat("HanhLy"));
                hk.setEmail(rs.getString("Email"));
                
                //if(hk!=null)
                    arr.add(hk);
            }
            
            connect.close();
        }
        catch(SQLException ex){
            
        }
        return arr;
    }
    
    public ArrayList<HanhKhach> getListHanhKhach(String hoten)
    {
        Connection connect=DBConnect.getConnection();
        String sql="SELECT * FROM qlvemaybay.HanhKhach WHERE HoTen='"+hoten+"';";
        ArrayList<HanhKhach> arr=new ArrayList();
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            while(rs.next()){
                HanhKhach hk=new HanhKhach();
                hk.setMaHK(rs.getInt("MaHK"));
                hk.setHoTen(rs.getString("HoTen"));
                hk.setCMND(rs.getString("CMND"));
                hk.setSoDT(rs.getString("SoDT"));
                hk.setDChi(rs.getString("DChi"));
                hk.setHanhLy(rs.getFloat("HanhLy"));
                hk.setEmail(rs.getString("Email"));
                
                arr.add(hk);
            }
            connect.close();
        }
        catch(SQLException ex){
            
        }
        return arr;
    }
    
   @Override
   public ArrayList<HanhKhach> getListHanhKhachbyMaCB(String MaCB){
       Connection connect=DBConnect.getConnection();
        String sql="SELECT * FROM qlvemaybay.HanhKhach,qlvemaybay.Ve WHERE MaCB='"+MaCB+"' AND HanhKhach.MaHK=Ve.MaHK;";
        ArrayList<HanhKhach> arr=new ArrayList();
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            while(rs.next()){
                HanhKhach hk=new HanhKhach();
                hk.setMaHK(rs.getInt("MaHK"));
                hk.setHoTen(rs.getString("HoTen"));
                hk.setCMND(rs.getString("CMND"));
                hk.setSoDT(rs.getString("SDT"));
                hk.setDChi(rs.getString("DChi"));
                hk.setHanhLy(rs.getFloat("HanhLy"));
                hk.setEmail(rs.getString("Email"));
                
                arr.add(hk);
            }
            connect.close();
        }
        catch(SQLException ex){
            
        }
        return arr;
   }
   public boolean DeleteHK(String mahk){
       Connection connect=DBConnect.getConnection();
        String sql="DELETE FROM `qlvemaybay`.`hanhkhach` WHERE `MaMK`='"+mahk+"';";
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
   
   public boolean AddHK(String macb,String hoten,String cmnd,String sdt,String dchi,float hanhly,String email){
        
        int mahk=0;
        mahk=getMaHK(hoten,cmnd,sdt,dchi,email);
        if(mahk!=0) //Trùng Hành Khách trong danh sách
           return false;
       
        Connection connect=DBConnect.getConnection();
        String sql="INSERT INTO `qlvemaybay`.`hanhkhach` (`HoTen`, `CMND`, `SoDT`, `DChi`, `HanhLy`, `Email`) VALUES ('"+hoten+"', '"+cmnd+"', '"+sdt+"', '"+dchi+"', '"+hanhly+"', '"+email+"');";
        
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            boolean rs=pr.execute();
            
            sql="UPDATE `qlvemaybay`.`chuyenbay` SET SLHKHT=SLHKHT+1 WHERE MaCB='"+macb+"';";
            pr=connect.prepareStatement(sql);
            rs=pr.execute();
            
            mahk=getMaHK(hoten,cmnd,sdt,dchi,email);
            if(mahk==0)
            {
                connect.close();
                return false;
            }
            
            int giahl=0;
            if(hanhly<15.0)
                giahl=0;
            else if(hanhly<20.0)
                giahl=143000;
            else if(hanhly<25.0)
                giahl=165000;
            else if(hanhly<30.0)
                giahl=220000;
            else if(hanhly<35.0)
                giahl=270000;
            else if(hanhly<40.0)
                giahl=320000;
            
            ChuyenBayDAOImpl cb=new ChuyenBayDAOImpl();
            int giave=0;
            giave=cb.getEleChuyenBay(macb).getGiaVe()+giahl;
            sql="INSERT INTO `qlvemaybay`.`ve` (`MaCB`, `MaHK`,`GiaVe`) VALUES ('"+macb+"', '"+mahk+"','"+giave+"');";
            pr=connect.prepareStatement(sql);
            rs=pr.execute();
            
            connect.close();
            return true;
        }
        catch(SQLException ex){
            
        }
        return false;
   }
   
   public int getMaHK(String hoten,String cmnd,String sdt,String dchi,String email){
       Connection connect=DBConnect.getConnection();
       String sql="SELECT `MaHK` FROM `qlvemaybay`.`hanhkhach` WHERE `HoTen`='"+hoten+"' and `CMND`='"+cmnd+"' and `SoDT`='"+sdt+"' and `DChi`='"+dchi+"' and `Email`='"+email+"';";
       int mahk=0;
       try{
           PreparedStatement pr=connect.prepareStatement(sql);
           ResultSet rs=pr.executeQuery();
           if(rs.next())
               mahk=rs.getInt("MaHK");
            connect.close();
       }catch(SQLException ex){
           
       }
       return mahk;
   }
   
   public int getMaHK(HanhKhach hk){
       Connection connect=DBConnect.getConnection();
       String sql="SELECT `MaHK` FROM `qlvemaybay`.`hanhkhach` WHERE `HoTen`='"+hk.getHoTen()+"' and `CMND`='"+hk.getCMND()+"' and `SoDT`='"+hk.getSoDT()+"' and `DChi`='"+hk.getDChi()+"' and `Email`='"+hk.getEmail()+"';";
       int mahk=0;
       try{
           PreparedStatement pr=connect.prepareStatement(sql);
           ResultSet rs=pr.executeQuery();
           if(rs.next())
               mahk=rs.getInt("MaHK");
            connect.close();
       }catch(SQLException ex){
           
       }
       return mahk;
   }
}
