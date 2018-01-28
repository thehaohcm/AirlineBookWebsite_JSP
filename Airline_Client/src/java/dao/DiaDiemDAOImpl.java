/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.DiaDiem;
import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

/**
 *
 * @author thehaohcm
 */
public class DiaDiemDAOImpl implements DiaDiemDAO {

    @Override
    public ArrayList<DiaDiem> getListDiaDiem() {
        Connection connect=DBConnect.getConnection();
        String sql="SELECT * FROM qlvemaybay.diadiem;";
        ArrayList<DiaDiem> arr = new ArrayList<>();
        //arr=null;
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){                
                DiaDiem dd=new DiaDiem();
                //dd=null;
                dd.setMaDD(rs.getInt("MaDD"));
                dd.setTenDD(rs.getString("TenDD"));
                dd.setTenSB(rs.getString("TenSB"));
                
                //if(dd!=null)
                    arr.add(dd);
            }
            connect.close();
        }
        catch(SQLException ex)
        {
            
        }
        
        return arr;
    }

    @Override
    public DiaDiem getElebyMaDD(int MaDD) {
        Connection connect=DBConnect.getConnection();
        DiaDiem dd=new DiaDiem();
        //dd=null;
        String sql="SELECT * FROM qlvemaybay.diadiem where MaDD='"+MaDD+"';";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            if(rs.next()){
                dd.setMaDD(rs.getInt("MaDD"));
                dd.setTenDD(rs.getString("TenDD"));
                dd.setTenSB(rs.getString("TenSB"));
            }
            connect.close();
        }
        catch(SQLException ex)
        {
            //dd=null;
        }
        return dd;
    }
    
    @Override
    public String getTenSB(int MaDD){
        Connection connect=DBConnect.getConnection();
        String tenSB = null;
        //dd=null;
        String sql="SELECT * FROM qlvemaybay.diadiem where MaDD="+MaDD+";";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            if(rs.next()){
                tenSB=rs.getString("TenSB");
            }
            connect.close();
        }
        catch(SQLException ex)
        {
            //dd=null;
        }
        return tenSB;
    }
    
    @Override
    public String getTenDD(int MaDD){
        Connection connect=DBConnect.getConnection();
        String tenDD = null;
        //dd=null;
        String sql="SELECT * FROM qlvemaybay.diadiem where MaDD="+MaDD+";";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            if(rs.next()){
                tenDD=rs.getString("TenDD");
            }
            connect.close();
        }
        catch(SQLException ex)
        {
            //dd=null;
        }
        return tenDD;
    }
    
    public boolean AddDiaDiem(int MaDD,String TenDD,String TenSB){
        if(TenDD.isEmpty()==false && TenSB.isEmpty()==false){
            
            try{
                Connection connect=DBConnect.getConnection();

                String sql="INSERT INTO qlvemaybay.diadiem values('"+MaDD+"','"+TenDD+"','"+TenSB+"');";
                PreparedStatement pr=connect.prepareStatement(sql);
                boolean rs=pr.execute();

                connect.close();
                return true;
            }
            catch(SQLException ex)
            {

            }
        }
        return false;
    }
    public boolean deleteDD(int MaDD){
        Connection connect=DBConnect.getConnection();
        String sql="DELETE FROM `qlvemaybay`.`diadiem` WHERE `MaDD`='"+MaDD+"';";
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
    public boolean updateDD(int MaDD,String TenDD,String TenSB){
        Connection connect=DBConnect.getConnection();
        String sql="UPDATE `qlvemaybay`.`diadiem` SET TenDD='"+TenDD+"', TenSB='"+TenSB+"' WHERE MaDD='"+MaDD+"';";
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
