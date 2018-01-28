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


public class TaiKhoanDAOImpl implements TaiKhoanDAO {

    @Override
    public String getPassword(String username) {
        String password = null;
        Connection connect=DBConnect.getConnection();
        String sql="SELECT qlvemaybay.taikhoan.password from qlvemaybay.taikhoan where `username`='"+username+"';";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            if(rs.next()){
                password=rs.getString("password");
            }
            connect.close();
            return password;
        }
        catch(SQLException ex){
            
        }
        return password;
    }

    @Override
    public boolean CheckAccount(String username, String password) {
        String pass = null,user=null;
        Connection connect=DBConnect.getConnection();
        String sql="SELECT * from qlvemaybay.taikhoan where `username`='"+username+"';";
        try{
            PreparedStatement pr=connect.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            if(rs.next()){
                user=rs.getString("username");
                pass=rs.getString("password");
                
            }
            connect.close();
            if(username.equals(user)&&password.equals(pass))
                return true;
            else
                return false;
        }
        catch(SQLException ex){
            
        }
        return false;
    }
    
}
