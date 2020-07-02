<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : productsLinks.xsl
    Created on : July 2, 2020, 7:43 PM
    Author     : Hoang Pham
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <links xmlns="http://xml.netbeans.org/schema/audio46ProductsLinks">
            <earphones>
                <xsl:for-each select="links/earphones/a">
                    <link>
                        <xsl:value-of select="@href" />
                    </link>
                </xsl:for-each>
            </earphones>
            <headphones>
                <xsl:for-each select="links/headphones/a">
                    <link>
                        <xsl:value-of select="@href" />
                    </link>
                </xsl:for-each>
            </headphones>
        </links>
    </xsl:template>

</xsl:stylesheet>
