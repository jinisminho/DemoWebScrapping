/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Hoang Pham
 */
public enum DatabaseEnums {
    SQLSERVER_DRIVER_STRING("com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    USER("SA"),
    PASSWORD("4123"),
    URL("jdbc:sqlserver://localhost:1433; databasename=HeadphonesDB;");

    private String content;

    DatabaseEnums(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
