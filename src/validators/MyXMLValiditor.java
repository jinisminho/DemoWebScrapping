/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Hoang Pham
 */
public class MyXMLValiditor {

    public boolean validateXMLWithSchema(String xmlFile, String xsdFile) {
        boolean isValid = false;
        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File(xsdFile));
            Validator validator = schema.newValidator();
            InputSource inputFile = new InputSource(
                    new BufferedReader(new FileReader(xmlFile)));
            validator.validate(new SAXSource(inputFile));
            System.out.println(">> " + xmlFile + " is valid");
            isValid = true;
        } catch (IOException | SAXException ex) {
            System.out.println("!! " + xmlFile + " is not valid: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return isValid;
    }
}
