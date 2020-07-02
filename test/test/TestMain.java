/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import crawlers.Audio46Crawler;

/**
 *
 * @author Hoang Pham
 */
public class TestMain {

    public static double similarity(String s1, String s2) {
        String longer = s1.trim(), shorter = s2.trim();
        if (s1.length() < s2.length()) { // longer should always have greater length
            longer = s2;
            shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) {
            return -1.0;
            /* both strings are zero length */ }
        /* // If you have Apache Commons Text, you can use it to calculate the edit distance:
    LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
    return (longerLength - levenshteinDistance.apply(longer, shorter)) / (double) longerLength; */
        return (longerLength - editDistance(longer, shorter)) / (double) longerLength;

    }

    // Example implementation of the Levenshtein Edit Distance
    // See http://rosettacode.org/wiki/Levenshtein_distance#Java
    public static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        System.out.println(s1.length());
        System.out.println(s2.length());
        System.out.println(costs.length);
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    costs[j] = j;
                } else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        }
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0) {
                costs[s2.length()] = lastValue;
            }
        }
        return costs[s2.length()];
    }

    public static void printSimilarity(String s, String t) {
        System.out.println(String.format(
                "%.3f is the similarity between \"%s\" and \"%s\"", similarity(s, t), s, t));
    }

    public static void main(String[] args) {
//        printSimilarity("", "");
//        printSimilarity("1234567890", "1");
//        printSimilarity("1234567890", "123");
//        printSimilarity("1234567890", "1234567");
//        printSimilarity("1234567890", "1234567890");
//        printSimilarity("1234567890", "1234567980");
//        printSimilarity("47/2010", "472010");
//        printSimilarity("47/2010", "472011");
//        printSimilarity("47/2010", "AB.CDEF");
//        printSimilarity("47/2010", "4B.CDEFG");
//        printSimilarity("47/2010", "AB.CDEFG");
//        printSimilarity("Meze - Rai Penta IEMs", "rai penta");
//        String s1 = "Meze - Rai Penta IEMs";
//        System.out.println(s1.compareToIgnoreCase("rai penta"));

//        WebPageDownloader downloader = new WebPageDownloader();
//        downloader.writeAudio46CollectionsLinkList2Xml(UrlEnums.AUDIO46.getUrl(),
//                FileNameEnums.DOWNLOADED_COLLECTIONS_LINK_AUDIO46_XML.getFileName());
//        MyXSLTransformer transformer = new MyXSLTransformer();
//        transformer.transform(FileNameEnums.DOWNLOADED_COLLECTIONS_LINK_AUDIO46_XML.getFileName(),
//                FileNameEnums.FINAL_COLLECTIONS_LINK_AUDIO46_XML.getFileName(),
//                "xslt/collectionsLink.xsl");
//        MyXMLValiditor validitor = new MyXMLValiditor();
//        validitor.validateXMLWithSchema(FileNameEnums.FINAL_COLLECTIONS_LINK_AUDIO46_XML.getFileName(), SchemaEnums.AUDIO46_COLLECTION_LINKS_SCHEMA.getFileName());
//        JAXBUnmarshaller unmarshaller = new JAXBUnmarshaller();
//        List<String> links = unmarshaller.getLinks(FileNameEnums.FINAL_COLLECTIONS_LINK_AUDIO46_XML.getFileName());
//        for (String link : links) {
//            System.out.println(link);
//        }
        Audio46Crawler audio46Crawler = new Audio46Crawler();
        audio46Crawler.demo();
        //        JAXBUnmarshaller unmarshaller = new JAXBUnmarshaller();
        //        WebPageDownloader downloader = new WebPageDownloader();
        //        downloader.demo();
//        String s = "1499.00";
//        s= s.replace("4", "6");
//        s= s.replace("1", "2");
//        System.out.println(Float.parseFloat(s));
    }
}
