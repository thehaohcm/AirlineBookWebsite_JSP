/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author thehaohcm
 */
public interface TaiKhoanDAO {
    public String getPassword(String username);
    public boolean CheckAccount(String username,String password);
}
