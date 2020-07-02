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
public enum ProductTypeEnums {
    HEADPHONES(1),
    IEMS_INEARS(2);

    private int typeId;

    ProductTypeEnums(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }
}
