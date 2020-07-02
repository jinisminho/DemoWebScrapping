/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawlers;

import enums.FileNameEnums;
import enums.SchemaEnums;
import enums.UrlEnums;
import enums.XsltFileEnums;
import html.WebPageDownloader;
import java.util.ArrayList;
import parsers.MyXMLParser;
import transformers.MyXSLTransformer;
import validators.MyXMLValiditor;

/**
 *
 * @author Hoang Pham
 */
public class SignatureCrawler {

    private static WebPageDownloader webPageDownloader;
    private static MyXMLParser xmlParser;
    private static MyXSLTransformer transformer;
    private static MyXMLValiditor validitor;
//    Links
    private final String linksUrl = UrlEnums.CRINACLE_RANKINGS.getUrl();
    private final String downloadedLinksFile = FileNameEnums.DOWNLOADED_SIGNATURES_LINKS_XML.getFileName();
    private final String linkXslt = XsltFileEnums.SIGNATURE_LINKS_XSLT.getFileName();
    private final String finalLinksXml = FileNameEnums.FINAL_SIGNATURES_LINK_XML.getFileName();
    private final String linkSchema = SchemaEnums.SIGNATURE_LINKS_SCHEMA.getFileName();
    private ArrayList<String> links = new ArrayList<>();
//    Signatures
    private final String signatureXslt = XsltFileEnums.SIGNATURE_XSLT.getFileName();
    private final String finalSignatureXml = FileNameEnums.FINAL_SIGNATURES_XML.getFileName();
    private final String downloadedSignatureFile = FileNameEnums.DOWNLOADED_SIGNATURES_XML.getFileName();
    private final String signaturesSchema = SchemaEnums.SIGNATURE_SCHEMA.getFileName();

    public boolean crawl() {
        boolean crawled = false;
        if (crawlLinks()) {
            if (crawlSignatures()) {
                crawled = true;
            }
        }
        return crawled;
    }

    private boolean crawlLinks() {
        System.out.println(">> Init crawl desired links");
        webPageDownloader = new WebPageDownloader();
//        Download URL contents and write contents to an xml file
        boolean isWritten2File = webPageDownloader.writeSignaturesLinkList2XmlFileFromInputStream(linksUrl, downloadedLinksFile);
        if (isWritten2File) {
//            Check if written xml is well-formed
            xmlParser = new MyXMLParser();
            boolean isWellformed = xmlParser.checkWellFormedXml(downloadedLinksFile);
            if (isWellformed) {
//                Transform into usable xml
                transformer = new MyXSLTransformer();
                boolean isTransformed = transformer.transform(downloadedLinksFile, finalLinksXml, linkXslt);
                if (isTransformed) {
//                    Validate xml
                    validitor = new MyXMLValiditor();
                    return validitor.validateXMLWithSchema(finalLinksXml, linkSchema);
                }
            }
        }
        return false;
    }

    private boolean crawlSignatures() {
        System.out.println(">> Init crawl desired signatures");
        getLinks();
//        Download URL contents and write contents to an xml file
        webPageDownloader = new WebPageDownloader();
        boolean isWritten2File = webPageDownloader.writeSignature2XmlFileFromInputStream(links, downloadedSignatureFile);
        if (isWritten2File) {
//            Check if written xml is well-formed
            xmlParser = new MyXMLParser();
            boolean isWellformed = xmlParser.checkWellFormedXml(downloadedSignatureFile);
            if (isWellformed) {
//                Transform into usable xml
                transformer = new MyXSLTransformer();
                boolean isTransformed = transformer.transform(downloadedSignatureFile, finalSignatureXml, signatureXslt);
                if (isTransformed) {
                    validitor = new MyXMLValiditor();
                    return validitor.validateXMLWithSchema(finalSignatureXml, signaturesSchema);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void getLinks() {
        xmlParser = new MyXMLParser();
        links = (ArrayList<String>) xmlParser.getSignatureLinks(finalLinksXml);
    }

    public void demo() {
//        getLinks();
//        webPageDownloader = new WebPageDownloader();
//        webPageDownloader.writeSignature2XmlFileFromInputStream(links, "parserDemo.xml");
//        transformer = new MyXSLTransformer();
//        transformer.transform("demo.xml", "transDemo.xml", signatureXslt);
//        validitor = new MyXMLValiditor();
//        validitor.validateXMLWithSchema("transDemo.xml", signaturesSchema);
    }
}
