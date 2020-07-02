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
public enum FileNameEnums {
//    SIGNATURES
    DOWNLOADED_SIGNATURES_LINKS_XML("xml_data\\signatures_data\\downloaded_signatures_links.xml"),
    FINAL_SIGNATURES_LINK_XML("xml_data\\signatures_data\\final_signatures_link.xml"),
    DOWNLOADED_SIGNATURES_XML("xml_data\\signatures_data\\downloaded_signatures.xml"),
    FINAL_SIGNATURES_XML("xml_data\\signatures_data\\final_signatures.xml"),
//    PRODUCTS
    DOWNLOADED_COLLECTIONS_LINK_AUDIO46_XML("xml_data\\products_data\\downloaded_collections_audio46.xml"),
    FINAL_COLLECTIONS_LINK_AUDIO46_XML("xml_data\\products_data\\final_collections_audio46.xml"),
    DOWNLOADED_PRODUCTS_LINKS_AUDIO46_XML("xml_data\\products_data\\downloaded_products_links_audio46.xml"),
    FINAL_PRODUCTS_LINKS_AUDIO46_XML("xml_data\\products_data\\final_products_links_audio46.xml"),
    DOWNLOADED_PRODUCTS_AUDIO46_XML("xml_data\\products_data\\downloaded_products_audio46.xml"),
    FINAL_PRODUCTS_AUDIO46_XML("xml_data\\products_data\\final_products_audio46.xml");

    private String name;

    FileNameEnums(String name) {
        this.name = name;
    }

    public String getFileName() {
        return name;
    }
}
