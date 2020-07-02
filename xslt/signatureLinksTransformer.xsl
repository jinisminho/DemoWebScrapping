<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : signatureLinksTransformer.xsl
    Created on : June 29, 2020, 10:18 PM
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
        <links xmlns="http://xml.netbeans.org/schema/links">
            <xsl:for-each select="links/li">
                <link>
                    <xsl:value-of select="a/@href" />
                </link>
            </xsl:for-each>
        </links>
    </xsl:template>

</xsl:stylesheet>
