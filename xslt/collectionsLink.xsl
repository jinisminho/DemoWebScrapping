<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : collectionsLink.xsl
    Created on : July 2, 2020, 11:09 AM
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
        <links xmlns="http://xml.netbeans.org/schema/audio46links">
            <xsl:for-each select="links/a">
                <link>
                    <xsl:value-of select="@href" />
                </link>
            </xsl:for-each>
        </links>
    </xsl:template>
</xsl:stylesheet>
