/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import autogenerated.entities.audio46.links.products.Links;
import enums.UrlEnums;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoang Pham
 */
public class WebPageDownloader {

    private InputStream inputStream = null;
    private BufferedReader bufferedReader = null;
    private Writer writer = null;
    private List<String> tmpList = null;

    private void closeStream() {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (writer != null) {
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Failed to close stream: " + e.getMessage());
        }
    }

    public InputStream downloadHttpAsInputStream(String url) {
        try {
            URL urlObj = new URL(url);
            URLConnection urlConnection = urlObj.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            HttpURLConnection httpConnection = (HttpURLConnection) urlObj.openConnection();
            httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            int responseCode = httpConnection.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("!!! Download http failed. Page response: " + responseCode + ". For link: " + url);
            }

            return urlConnection.getInputStream();
        } catch (Exception e) {
            System.out.println("!!! ERROR. Message: " + e.getMessage());
        }
        return null;
    }

    public void writeProduc2tXmlFileFromInputStream(String url, String fileName) {
        try {
            inputStream = downloadHttpAsInputStream(url);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            writer.write("<product>\n");
            String tmpLine;
            while ((tmpLine = bufferedReader.readLine()) != null) {
                if (tmpLine.contains("class=\"product-featured-img js-zoom-enabled\">")) {
                    writer.write(tmpLine);
                    writer.write("</img>" + "\n");
                }
                if (tmpLine.contains("<h1 itemprop=\"name\" class=\"product-single__title product_title-h1-full\">")) {
                    writer.write(tmpLine + "\n");
                }
                if (tmpLine.contains("<span id=\"ProductPrice")) {
                    writer.write(tmpLine + "\n");
                }
                if (tmpLine.contains("<span class=\"variant-sku")) {
                    writer.write(tmpLine + "\n");
                }
            }
            writer.write("</product>");

            System.out.println("Write to File successfully!");
        } catch (Exception ex) {
            System.out.println("Failed to write InputStream as file: " + ex.getMessage());
        } finally {
            closeStream();
        }
    }

    public boolean writeSignature2XmlFileFromInputStream(ArrayList<String> urls, String fileName) {
        boolean isWritten2File = false;
        try {
            File file = new File(fileName);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write("<signature>\n");
            writer.close();

            for (String url : urls) {
                combineIEMsAndHeadphonesSignatures(url, fileName);
            }

            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("</signature>");
            writer.close();

            System.out.println("Write to File successfully!");
            isWritten2File = true;
        } catch (Exception ex) {
            System.out.println("Failed to write InputStream as file: " + ex.getMessage());
        } finally {
            closeStream();
        }
        return isWritten2File;
    }

    private void combineIEMsAndHeadphonesSignatures(String url, String fileName) {
        try {
            inputStream = downloadHttpAsInputStream(url);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
//            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            File file = new File(fileName);
            writer = new BufferedWriter(new FileWriter(file, true));
            if (url.contains("headphones")) {
                writer.write("<headphones>");
            } else if (url.contains("iem")) {
                writer.write("<iems>");
            }
            String tmpLine;
            while ((tmpLine = bufferedReader.readLine()) != null) {
                if (tmpLine.contains("<td class=\"column-1\">")
                        || tmpLine.contains("<tr ")
                        || tmpLine.contains("</tr")) {
                    if (tmpLine.contains("<br>")) {
                        writer.write(tmpLine.replace("<br>", " ") + "\n");
                    } else if (tmpLine.contains("<a />")) {
                        writer.write(tmpLine.replace("<a />", "</a>") + "\n");
                    } else {
                        writer.write(tmpLine + "\n");
                    }
                }
            }
            if (url.contains("headphones")) {
                writer.write("</headphones>");
            } else if (url.contains("iem")) {
                writer.write("</iems>");
            }

            System.out.println("Write to File successfully!");
        } catch (Exception ex) {
            System.out.println("Failed to combine IEM & Headphones signature to a file: "
                    + ex.getMessage());
        } finally {
            closeStream();
        }
    }

    public void writeProductsLinkList2XmlFileFromInputStream(String url, String fileName) {
        try {
            inputStream = downloadHttpAsInputStream(url);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            writer.write("<links>\n");
            String tmpLine;
            while ((tmpLine = bufferedReader.readLine()) != null) {
                if (tmpLine.contains("<a href=\"/collections/")
                        && tmpLine.contains("headphones")
                        && tmpLine.contains("</a>")
                        && !tmpLine.contains("li>")) {
                    if (tmpLine.contains("& ")) {
                        writer.write(tmpLine.replace("&", "&amp;") + "\n");
                    } else {
                        writer.write(tmpLine + "\n");
                    }
                }
            }
            writer.write("</links>");

            System.out.println("Write to File successfully!");
        } catch (Exception ex) {
            System.out.println("Failed to write InputStream as file: " + ex.getMessage());
        } finally {
            closeStream();
        }
    }

    public boolean writeSignaturesLinkList2XmlFileFromInputStream(String url, String destFileName) {
        boolean isWritten2File = false;
        try {
            inputStream = downloadHttpAsInputStream(url);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFileName), "UTF-8"));
            writer.write("<links>\n");
            String tmpLine;
            tmpList = new ArrayList<>();

            while ((tmpLine = bufferedReader.readLine()) != null) {
                if (tmpLine.contains("<a href=\"https://crinacle.com/rankings/")
                        && tmpLine.contains("class=\"elementor-sub-item\"")
                        && (tmpLine.contains("menu-item-8374") || (tmpLine.contains("menu-item-7300")))) {
                    if (!tmpList.contains(tmpLine)) {
                        writer.write(tmpLine + "\n");
                        tmpList.add(tmpLine);
                    }
                }
            }
            writer.write("</links>");

            System.out.println("Write to File successfully!");
            isWritten2File = true;
        } catch (Exception ex) {
            System.out.println("(method: writeSignaturesLinkList2XmlFileFromInputStream) Failed to write InputStream as file: " + ex.getMessage());
        } finally {
            closeStream();
        }
        return isWritten2File;
    }

    public boolean writeAudio46CollectionsLinkList2Xml(String url, String destFileName) {
        boolean isWritten = false;
        try {
            inputStream = downloadHttpAsInputStream(url);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFileName), "UTF-8"));
            writer.write("<links>\n");
            String tmpLine;
            tmpList = new ArrayList<>();
            while ((tmpLine = bufferedReader.readLine()) != null) {
                if (tmpLine.contains("class=\"collection-grid-item__link\">")
                        && tmpLine.contains("audiophile")) {
                    if (!tmpList.contains(tmpLine)) {
                        writer.write(tmpLine + "</a>\n");
                        tmpList.add(tmpLine);
                    }
                }
            }
            writer.write("</links>");
            System.out.println("Write to File " + destFileName + " successfully!");
//            for (String string : tmpList) {
//                System.out.println(string);
//            }
            isWritten = true;
        } catch (Exception ex) {
            System.out.println("writeAudio46CollectionsLinkList2Xml Failed to write xml file: " + ex.getMessage());
        } finally {
            closeStream();
        }
        return isWritten;
    }

    public boolean writeAudio46ProductLinks2Xml(List<String> urls, String destFileName) {
        boolean isWritten2File = false;
        try {
            File file = new File(destFileName);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write("<links>\n");
            writer.close();

            for (String url : urls) {
                url = UrlEnums.AUDIO46.getUrl() + url;
                combineItemLinksFromAudio46(url, destFileName);
            }

            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("</links>");
            writer.close();

            System.out.println("Write to File successfully!");
            isWritten2File = true;
        } catch (Exception ex) {
            System.out.println("Failed to write InputStream as file: " + ex.getMessage());
        } finally {
            closeStream();
        }
        return isWritten2File;
    }

    private void combineItemLinksFromAudio46(String url, String destFileName) {
        int page = 1;
        url += "?page=";
        String tmpUrl = url;
        List<String> duplicateUrlChecker = new ArrayList<>();
        int i = 0;

        try {
            File file = new File(destFileName);
            writer = new BufferedWriter(new FileWriter(file, true));
            if (url.contains("earphone")) {
                writer.write("<earphones>");
            } else if (url.contains("headphone")) {
                writer.write("<headphones>");
            }
            while ((i++) < 4) {
                int count = 0;
                url += (page++);
                inputStream = downloadHttpAsInputStream(url);
                System.out.println(url);
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String tmpLine = "";
                while ((tmpLine = bufferedReader.readLine()) != null) {
                    if (tmpLine.contains("<a class=\"grid-view-item__link\" href=")) {
                        if (!duplicateUrlChecker.contains(tmpLine)) {
                            System.out.println(count++);
                            tmpLine += "</a>";
                            duplicateUrlChecker.add(tmpLine);
                            writer.write(tmpLine);
                        }
                    }
                }
                url = tmpUrl;
            }
            if (url.contains("earphone")) {
                writer.write("</earphones>");
            } else if (url.contains("headphone")) {
                writer.write("</headphones>");
            }

        } catch (Exception ex) {
            System.out.println("!!! Error at [" + url + "]. Error: "
                    + ex.getMessage());
        } finally {
            closeStream();
        }

    }

    public boolean writeAudio46Products2Xml(Links urls, String destFileName) {
        boolean isWritten2File = false;
        try {
            File file = new File(destFileName);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write("<products>\n");
            writer.close();

            combineItemsFromAudio46(urls.getEarphones().getLink(), destFileName, "earphones");
            combineItemsFromAudio46(urls.getHeadphones().getLink(), destFileName, "headphones");

            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("</products>");
            writer.close();

            System.out.println("Written to File successfully!");
            isWritten2File = true;
        } catch (Exception ex) {
            System.out.println("Failed to write InputStream as file: " + ex.getMessage());
        } finally {
            closeStream();
        }
        return isWritten2File;
    }

    private void combineItemsFromAudio46(List<String> urls, String destFileName, String type) {
        int count = 1;
        try {
            File file = new File(destFileName);
            writer = new BufferedWriter(new FileWriter(file, true));
            if (type.equals("earphones")) {
                writer.write("<earphones>");
            } else if (type.equals("headphones")) {
                writer.write("<headphones>");
            }
            for (String url : urls) {
                url = UrlEnums.AUDIO46.getUrl() + url;
                try {
                    inputStream = downloadHttpAsInputStream(url);
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

                    writer.write("<product>");
                    String tmpLine;
                    while ((tmpLine = bufferedReader.readLine()) != null) {
                        if (tmpLine.contains("<h1 itemprop=\"name\"")) {
//                            Name
                            writer.write(tmpLine.replace("&", "&amp;"));
                        }
                        if (tmpLine.contains("<div id=\"FeaturedImageZoom")) {
//                            Image
                            writer.write(tmpLine + "</div>");
                        }
                        if (tmpLine.contains("<span id=\"ProductPrice")) {
//                            Price
                            tmpLine = tmpLine.replace("$", "");
                            tmpLine = tmpLine.replace(",", "");
                            writer.write(tmpLine);
                        }
                    }
                    writer.write("</product>");
                    System.out.println("- item: " + (count++));
                } catch (Exception ex) {
                    System.out.println("!!! Error at [" + url + "]. Error: "
                            + ex.getMessage());
                } finally {
                    bufferedReader.close();
                    inputStream.close();
                }
            }
            if (type.equals("earphones")) {
                writer.write("</earphones>");
            } else if (type.equals("headphones")) {
                writer.write("</headphones>");
            }
            System.out.println(">> Combined 1/2");
        } catch (Exception ex) {
            System.out.println("!!! Error combining items from audio46.com: " + ex.getMessage());
        } finally {
            closeStream();
        }

    }

    public void demo() {
        ArrayList<String> list = new ArrayList<>();
        list.add("/products/final-audio-e1000-earphones");
        combineItemsFromAudio46(list, "abc2.xml", "earphones");
    }
}
