/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import entities.ProductEntity;
import enums.CommonEnums;
import enums.ProductTypeEnums;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author Hoang Pham
 */
public class MyXMLParser {

    /**
     * OLD PARSERS (NOT USING)
     *
     * private static XMLEvent getXMLEvent(XMLStreamReader reader) throws
     * XMLStreamException { return allocator.allocate(reader); }
     *
     * public boolean parseProductDetailsXml(String srcFile, String desFile) {
     * boolean isXMLWellForm = true;
     *
     * try { XMLInputFactory inputFactory = XMLInputFactory.newFactory();
     * inputFactory.setEventAllocator(new XMLEventAllocatorImpl()); allocator =
     * inputFactory.getEventAllocator(); XMLStreamReader xmlr =
     * inputFactory.createXMLStreamReader(srcFile, new
     * FileInputStream(srcFile));
     *
     * Writer writer = new BufferedWriter(new OutputStreamWriter(new
     * FileOutputStream(desFile), "UTF-8"));
     * writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); int cursor
     * = xmlr.getEventType();
     *
     * while (xmlr.hasNext()) { cursor = xmlr.next();
     *
     * if (cursor == XMLStreamConstants.START_ELEMENT) { StartElement event =
     * getXMLEvent(xmlr).asStartElement();
     * writer.write(event.toString().trim()); if
     * (xmlr.getLocalName().equals("product")) { writer.write("\n"); }
     *
     * } else if (cursor == XMLStreamConstants.END_ELEMENT) { EndElement event =
     * getXMLEvent(xmlr).asEndElement(); writer.write(event.toString().trim() +
     * "\n"); String tagName = xmlr.getLocalName(); if (tagName.equals("")) { }
     * } else if (cursor == XMLStreamConstants.CHARACTERS) { Characters event =
     * getXMLEvent(xmlr).asCharacters(); writer.write(event.toString().trim());
     *
     * } else if (cursor == XMLStreamConstants.END_DOCUMENT) { break; } }
     * writer.close(); System.out.println("XML is well-formed!"); } catch
     * (Exception ex) { System.out.println("XML is not well-formed: " +
     * ex.getMessage()); } return isXMLWellForm; }
     */
    public boolean checkWellFormedXml(String srcFile) {
        boolean isWellformed = true;

        try {
            XMLInputFactory xmlif = XMLInputFactory.newInstance();
            File f = new File(srcFile);
            InputStream inputStream = new FileInputStream(f);
            XMLStreamReader xmlStreamReader = xmlif.createXMLStreamReader(inputStream);
            int cursor;

            while (xmlStreamReader.hasNext()) {
                cursor = xmlStreamReader.next();
                if (cursor == XMLStreamConstants.END_DOCUMENT) {
                    break;
                }
            }

            xmlStreamReader.close();
            System.out.println("XML is well-formed!");
        } catch (Exception ex) {
            isWellformed = false;
            System.out.println("XML is not well-formed: " + ex.getMessage());
        }
        return isWellformed;
    }

    public List<String> getSignatureLinks(String xmlFile) {
        List<String> links = new ArrayList<>();
        try {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader reader = factory.createXMLStreamReader(xmlFile, new FileInputStream(xmlFile));
            int cursor;
            while (reader.hasNext()) {
                cursor = reader.next();
                if (cursor == XMLStreamConstants.START_ELEMENT) {
                    String tagName = reader.getLocalName();
                    if (tagName.equals("link")) {
                        String link = reader.getElementText();
                        links.add(link);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to get links list: " + e.getMessage());
        }
        return links;
    }

    public String getTextContent(XMLStreamReader currentCursor, String tagName) {
        try {
            if (currentCursor != null) {
                while (currentCursor.hasNext()) {
                    int cursor = currentCursor.next();
                    if (cursor == XMLStreamReader.START_ELEMENT) {
                        String currentTag = currentCursor.getLocalName();
                        if (currentTag.equals(tagName)) {
                            currentCursor.next();
                            String result = currentCursor.getText();
                            currentCursor.nextTag();
                            return result;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to get text content: " + e.getMessage());
        }
        return CommonEnums.EMPTY_STRING.getContent();
    }

    public List<ProductEntity> mapSignatureXml2Objects(String xmlFile) {
        ProductEntity entity = new ProductEntity();
        ArrayList<ProductEntity> list = new ArrayList<>();
        int type = 999;
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlFile));
            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "iems":
                            type = ProductTypeEnums.IEMS_INEARS.getTypeId();
                            break;
                        case "headphones":
                            type = ProductTypeEnums.HEADPHONES.getTypeId();
                            break;
                        case "signature":
                            entity = new ProductEntity();
                            entity.setTypeId(type);
                            break;
                        case "name":
                            nextEvent = reader.nextEvent();
                            entity.setSignature(nextEvent.asCharacters().getData());
                            break;
                        case "model":
                            nextEvent = reader.nextEvent();
                            entity.setName(nextEvent.asCharacters().getData());
                            break;
                        case "description":
                            nextEvent = reader.nextEvent();
                            entity.setDescription(nextEvent.asCharacters().getData());
                            break;
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("signature")) {
                        list.add(entity);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void parserDemo(String xmlFile) {
        ProductEntity entity = new ProductEntity();
        ArrayList<ProductEntity> list = new ArrayList<>();
        int type = 999;
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlFile));
            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "iems":
                            type = ProductTypeEnums.IEMS_INEARS.getTypeId();
                            break;
                        case "headphones":
                            type = ProductTypeEnums.HEADPHONES.getTypeId();
                            break;
                        case "signature":
                            entity = new ProductEntity();
                            entity.setTypeId(type);
                            break;
                        case "name":
                            nextEvent = reader.nextEvent();
                            entity.setSignature(nextEvent.asCharacters().getData());
                            break;
                        case "model":
                            nextEvent = reader.nextEvent();
                            entity.setName(nextEvent.asCharacters().getData());
                            break;
                        case "description":
                            nextEvent = reader.nextEvent();
                            entity.setDescription(nextEvent.asCharacters().getData());
                            break;
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("signature")) {
                        list.add(entity);
                    }
                }
            }
            System.out.println("list size: " + list.size());
            System.out.println(list.toString());
        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
        }
    }
}
