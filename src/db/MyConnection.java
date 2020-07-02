/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import enums.DatabaseEnums;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hoang Pham
 */
public class MyConnection implements Serializable {

    public static Connection getMyConnection() throws Exception {
        Class.forName(DatabaseEnums.SQLSERVER_DRIVER_STRING.getContent());
        return DriverManager.getConnection(DatabaseEnums.URL.getContent(),
                DatabaseEnums.USER.getContent(),
                DatabaseEnums.PASSWORD.getContent());
    }
}
