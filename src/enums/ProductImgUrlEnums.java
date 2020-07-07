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
public enum ProductImgUrlEnums {
    EARPHONES_URL("https://previews.123rf.com/images/sn333g/sn333g1806/sn333g180600113/103239683-in-ear-wired-headphones-icon-vector-outline-sign.jpg"),
    HEADPHONES_URL("https://previews.123rf.com/images/sn333g/sn333g1807/sn333g180700118/104903420-over-ear-headphones-vector-outline-icon-or-symbol.jpg");

    private String url;

    ProductImgUrlEnums(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
