<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : signaturesTransformer.xsl
    Created on : June 29, 2020, 9:12 PM
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
        <signatures xmlns="http://xml.netbeans.org/schema/signatures">
            <iems>
                <xsl:for-each select="signature/iems/tr[not(self::tr[contains(@class, 'row-1 odd')])]">
                    <signature>
                        <id>
                            <xsl:value-of select="position()" />
                        </id>
                        <name>
                            <xsl:value-of select="td[contains(@class, 'column-5')]" />
                        </name>
                        <price>
                            <xsl:value-of select="td[contains(@class, 'column-15')]" />
                        </price>
                        <xsl:variable name="linkedModel" select="td[contains(@class, 'column-3')]/a"/>
                        <xsl:variable name="unlinkedModel" select="td[contains(@class, 'column-3')]" />
                        <xsl:choose>
                            <xsl:when test="$linkedModel != ''">
                                <model>
                                    <xsl:value-of select="td[contains(@class, 'column-3')]/a" />
                                </model>
                            </xsl:when>
                            <xsl:otherwise>
                                <model>
                                    <xsl:value-of select="td[contains(@class, 'column-3')]" />
                                </model>
                            </xsl:otherwise>
                        </xsl:choose>
                        <!--                        <model>
                            <xsl:value-of select="td[contains(@class, 'column-3')]/a" />
                        </model>-->
                        <description>
                            <xsl:value-of select="td[contains(@class, 'column-6')]" />
                        </description>
                    </signature>
                </xsl:for-each>
            </iems>
            <headphones>
                <xsl:for-each select="signature/headphones/tr[not(self::tr[contains(@class, 'row-1 odd')])]">
                    <signature>
                        <id>
                            <xsl:value-of select="position()" />
                        </id>
                        <name>
                            <xsl:value-of select="td[contains(@class, 'column-5')]" />
                        </name>
                        <price>
                            <xsl:value-of select="td[contains(@class, 'column-15')]" />
                        </price>
                        <xsl:variable name="linkedModel" select="td[contains(@class, 'column-3')]/a"/>
                        <xsl:variable name="unlinkedModel" select="td[contains(@class, 'column-3')]" />
                        <xsl:choose>
                            <xsl:when test="$linkedModel != ''">
                                <model>
                                    <xsl:value-of select="td[contains(@class, 'column-3')]/a" />
                                </model>
                            </xsl:when>
                            <xsl:otherwise>
                                <model>
                                    <xsl:value-of select="td[contains(@class, 'column-3')]" />
                                </model>
                            </xsl:otherwise>
                        </xsl:choose>
                        <description>
                            <xsl:value-of select="td[contains(@class, 'column-6')]" />
                        </description>
                    </signature>
                </xsl:for-each>
            </headphones>
        </signatures>
    </xsl:template>

</xsl:stylesheet>
