/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import autogenerated.entities.audio46.links.Links;
import autogenerated.entities.signatures.Signature;
import autogenerated.entities.signatures.Signatures;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Hoang Pham
 */
public class JAXBUnmarshaller {

    public static void main(String[] args) {
//        This main method is to test JAXB
        /**
         * DEMO CODE try { // TODO code application logic here JAXBContext jc =
         * JAXBContext.newInstance(Signatures.class); Unmarshaller um =
         * jc.createUnmarshaller(); File f = new File("demo.xml"); Signatures
         * signatures = (Signatures) um.unmarshal(f); List<Signature> headphones
         * = signatures.getHeadphones().getSignature(); for (Signature iem :
         * headphones) { System.out.println(iem.getModel()); } } catch
         * (JAXBException ex) { System.out.println("Failed to unmarshall from
         * demo.xml: " + ex.getMessage()); }
         */
    }

    public List<Signature> getHeadphones(String xmlFile) {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(Signatures.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
            File file = new File(xmlFile);
            Signatures signatures = (Signatures) unmarshaller.unmarshal(file);
            return signatures.getHeadphones().getSignature();
        } catch (Exception e) {
            System.out.println("Failed to unmarshall from " + xmlFile
                    + ", error: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public List<Signature> getIems(String xmlFile) {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(Signatures.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
            File file = new File(xmlFile);
            Signatures signatures = (Signatures) unmarshaller.unmarshal(file);
            return signatures.getIems().getSignature();
        } catch (Exception e) {
            System.out.println("Failed to unmarshall from " + xmlFile
                    + ", error: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public List<String> getAudio46CollectionLinks(String xmlFile) {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(Links.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
            File file = new File(xmlFile);
            Links links = (Links) unmarshaller.unmarshal(file);
            return links.getLink();
        } catch (Exception e) {
            System.out.println("Failed to unmarshall from " + xmlFile
                    + ", error: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public autogenerated.entities.audio46.links.products.Links getAudio46ProductLinks(String xmlFile) {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(autogenerated.entities.audio46.links.products.Links.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
            File file = new File(xmlFile);
            autogenerated.entities.audio46.links.products.Links links = (autogenerated.entities.audio46.links.products.Links) unmarshaller.unmarshal(file);
            return links;
        } catch (Exception e) {
            System.out.println("Failed to unmarshall from " + xmlFile
                    + ", error: " + e.getMessage());
        }
        return new autogenerated.entities.audio46.links.products.Links();
    }
}
