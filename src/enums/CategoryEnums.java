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
public enum CategoryEnums {
    NEUTRAL(1),
    ANALYTICAL(2),
    BRIGHT(3),
    WARM(4),
    DARK(5),
    FUN(6),
    VERYBAD(7),
    MID(8);

    private int categoryId;

    CategoryEnums(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
