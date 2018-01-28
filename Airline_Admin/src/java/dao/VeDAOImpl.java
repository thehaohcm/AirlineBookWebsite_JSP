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
import model.Ve;


public class VeDAOImpl implements VeDAO {

    @Override
    public ArrayList<Ve> getListVe() {
        Connection connect=DBConnect.getConnection();
        ArrayList<Ve> arr=new ArrayList();
        //arr=null;
        String sql="SELECT * FROM qlvemaybay.ve;";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            while(rs.next()){
                Ve v = new Ve();
                //v=null;
                v.setMaCB(rs.getString("MaCB"));
                v.setMaHK(rs.getString("MaHK"));
                v.setGiaVe(rs.getInt("GiaVe"));
                
                //if(v!=null)
                    arr.add(v);
            }
            connect.close();
        }
        catch(SQLException ex)
        {
            
        }
        return arr;
    }
    
    public boolean deleteVe(String mahk){
        Connection connect=DBConnect.getConnection();
        String macb="";
        int _mahk=Integer.parseInt(mahk);
        macb= getMaCB(_mahk);
        String sql="UPDATE `qlvemaybay`.`chuyenbay` SET SLHKHT=SLHKHT-1 WHERE `MaCB`='"+macb+"';";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            boolean rs=pr.execute();
            
            
            sql="DELETE FROM `qlvemaybay`.`ve` WHERE `MaHK`='"+mahk+"';";
            pr=connect.prepareStatement(sql);
            rs=pr.execute();
            connect.close();
            return true;
            
        }catch(SQLException ex){
            
        }
        return false;
    }
    
    public boolean deleteVe(int mahk){
        Connection connect=DBConnect.getConnection();
        String macb="";
        macb= getMaCB(mahk);
        String sql="UPDATE `qlvemaybay`.`chuyenbay` SET SLHKHT=SLHKHT-1 WHERE `MaCB`='"+macb+"';";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            boolean rs=pr.execute();
            
            
            sql="DELETE FROM `qlvemaybay`.`ve` WHERE `MaHK`='"+mahk+"';";
            pr=connect.prepareStatement(sql);
            rs=pr.execute();
            connect.close();
            return true;
            
        }catch(SQLException ex){
            
        }
        return false;
    }
    
    public String getGiaVe(int mahk){
        Connection connect=DBConnect.getConnection();
        String giave="";
        String sql="SELECT * FROM `qlvemaybay`.`ve` WHERE `MaHK`='"+mahk+"';";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            if(rs.next()){
                giave=rs.getString("GiaVe");
            }
        }catch(SQLException ex){
            
        }
        return giave;
    }
    public String getMaCB(int mahk){
        Connection connect=DBConnect.getConnection();
        String macb="";
        String sql="SELECT * FROM `qlvemaybay`.`ve` WHERE `MaHK`='"+mahk+"';";
        try{
            PreparedStatement pr = connect.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                macb=rs.getString(1);
            }
            connect.close();
        }catch(SQLException ex){
            
        }
        return macb;
    }
    
}
