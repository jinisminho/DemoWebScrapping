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
public enum DbMessageEnum
{
    SUCCESS("Update to database successfully"),
    PENDING("Database is not used"),
    FAILED("Update to database failed");

    private String message;

    DbMessageEnum(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
