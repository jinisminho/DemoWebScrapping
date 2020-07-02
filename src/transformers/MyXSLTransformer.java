/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformers;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Hoang Pham
 */
public class MyXSLTransformer {

    public boolean transform(String srcFilePath, String desFilePath, String xslFilePath) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File(xslFilePath));
            Transformer transformer = factory.newTransformer(xslt);
            Source text = new StreamSource(new File(srcFilePath));
            transformer.transform(text, new StreamResult(new File(desFilePath)));
            System.out.println("Transformed");
            return true;
        } catch (TransformerConfigurationException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } catch (TransformerException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return false;
    }
}
