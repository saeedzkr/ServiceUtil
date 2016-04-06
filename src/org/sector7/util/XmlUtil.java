package org.sector7.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.io.StringReader;

/**
 * Created by s.zakipour on 04/04/2016.
 */
public class XmlUtil {


    public XmlUtil() {


    }


    public void createXmlFromPOJO() {
        try {

            JAXBContext context = JAXBContext.newInstance(Config.class);

            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Config cfg = new Config();
            cfg.setHour("*");
            cfg.setMinute("0,15");
            cfg.setSeccond("0");
            cfg.setEnabled(1);

            marshaller.marshal(cfg, new FileOutputStream("k.xml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Config createPojoFromXmlString() {
        Config cfg = null;
        try {
            String xml = "<config>\n" +
                    "    <enabled>1</enabled>\n" +
                    "    <hour>*</hour>\n" +
                    "    <minute>0,15</minute>\n" +
                    "    <seccond>0</seccond>\n" +
                    "</config>";


            JAXBContext context = JAXBContext.newInstance(Config.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StreamSource src = new StreamSource(new StringReader(xml));
            JAXBElement el = unmarshaller.unmarshal(src, Config.class);

            cfg = (Config) el.getValue();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cfg;


    }


}
