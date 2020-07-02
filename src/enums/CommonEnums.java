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
public enum CommonEnums {
    EMPTY_STRING("");

    private String content;

    CommonEnums(String content) {
        this.content = content;        
    }

    public String getContent() {
        return content;
    }
}
