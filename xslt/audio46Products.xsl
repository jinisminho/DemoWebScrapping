<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : audio46Products.xsl
    Created on : July 2, 2020, 9:45 PM
    Author     : Hoang Pham
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml"/>
    
    <xsl:template match="/">
        <products xmlns="http://xml.netbeans.org/schema/audio46/products">
            <earphones>
                <xsl:for-each select="products/earphones/product">
                    <product>
                        <name>
                            <xsl:value-of select="h1"/>
                        </name>
                        <price>
                            <xsl:value-of select="span"/>
                        </price>
                        <image>
                            <xsl:value-of select="div/@data-zoom"/>
                        </image>
                    </product>
                </xsl:for-each>
            </earphones>
            <headphones>
                <xsl:for-each select="products/headphones/product">
                    <product>
                        <name>
                            <xsl:value-of select="h1"/>
                        </name>
                        <price>
                            <xsl:value-of select="span"/>
                        </price>
                        <image>
                            <xsl:value-of select="div/@data-zoom"/>
                        </image>
                    </product>
                </xsl:for-each>
            </headphones>
        </products>
    </xsl:template>

</xsl:stylesheet>
