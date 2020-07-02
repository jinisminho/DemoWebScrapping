<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : productDetails.xsl
    Created on : June 29, 2020, 3:31 PM
    Author     : Hoang Pham
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <product xmlns="http://xml.netbeans.org/schema/product">
            <name><xsl:value-of select="product/h1"/></name>
            <sku><xsl:value-of select="product/p/span[contains(@class,'variant-sku')]"/></sku>
            <price><xsl:value-of select="product/span[contains(@id,'ProductPrice-product-template')]"/></price>
            <image><xsl:value-of select="product/img/@src"/></image>
        </product>
    </xsl:template>
</xsl:stylesheet>
