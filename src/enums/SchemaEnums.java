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
public enum SchemaEnums {
    SIGNATURE_LINKS_SCHEMA("schemas\\signatureLinksXmlSchema.xsd"),
    SIGNATURE_SCHEMA("schemas\\signatureXmlSchema.xsd");

    private String name;

    SchemaEnums(String name) {
        this.name = name;
    }

    public String getFileName() {
        return name;
    }
}
