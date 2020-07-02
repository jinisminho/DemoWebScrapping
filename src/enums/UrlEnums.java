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
public enum UrlEnums {
    CRINACLE_RANKINGS("https://crinacle.com/rankings"),
    AUDIO46("https://audio46.com"),
    FAILED("Update to database failed");

    private String url;

    UrlEnums(String url) {
        this.url = url;        
    }

    public String getUrl() {
        return url;
    }
}
