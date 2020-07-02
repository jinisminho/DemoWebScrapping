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
public enum XsltFileEnums {
    SIGNATURE_LINKS_XSLT("xslt\\signatureLinksTransformer.xsl"),
    SIGNATURE_XSLT("xslt\\signaturesTransformer.xsl"),
    FAILED("Update to database failed");

    private String name;

    XsltFileEnums(String name) {
        this.name = name;
    }

    public String getFileName() {
        return name;
    }
}
