package LN40BG.domparse.hu;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class LN40BGDOMModify {

    public static void main(String[] args) {

        try {
            // ===== XML betöltése =====
            File xmlFile = new File("LN40BG_XML.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("--- ADATMÓDOSÍTÁS EREDMÉNYE ---\n");

            /*
             * Tulaj név megváltoztatása
             */
            NodeList tulajList = doc.getElementsByTagName("Tulaj");
            Element tulaj = (Element) tulajList.item(0);
            tulaj.getElementsByTagName("Nev").item(0).setTextContent("Kiss Ádám Jr.");

            System.out.println("Aktuális elem: Tulaj");
            System.out.println("Tulaj_ID: " + tulaj.getElementsByTagName("Tulaj_ID").item(0).getTextContent());
            System.out.println("Új név: " + tulaj.getElementsByTagName("Nev").item(0).getTextContent() + "\n");


            /*
             * Autó gyártási év módosítása
             */
            NodeList autoList = doc.getElementsByTagName("Auto");
            Element auto = (Element) autoList.item(0);
            auto.getElementsByTagName("Gyartasi_ev").item(0).setTextContent("2019");

            System.out.println("Aktuális elem: Auto");
            System.out.println("Rendszám: " + auto.getElementsByTagName("Rendszam").item(0).getTextContent());
            System.out.println("Új gyártási év: " + auto.getElementsByTagName("Gyartasi_ev").item(0).getTextContent() + "\n");

            /*
             * Biztosítás díj módosítása
             */
            NodeList biztList = doc.getElementsByTagName("Biztositas");
            Element bizt = (Element) biztList.item(0);
            bizt.getElementsByTagName("Dij").item(0).setTextContent("27000");

            System.out.println("Aktuális elem: Biztositas");
            System.out.println("Bizt_ID: " + bizt.getElementsByTagName("Bizt_ID").item(0).getTextContent());
            System.out.println("Új díj: " + bizt.getElementsByTagName("Dij").item(0).getTextContent() + "\n");

            /*
             * Baleset kár összegének módosítása
             */
            NodeList balList = doc.getElementsByTagName("Baleset");
            Element baleset = (Element) balList.item(0);
            baleset.getElementsByTagName("Kar").item(0).setTextContent("350000");

            System.out.println("Aktuális elem: Baleset");
            System.out.println("Baleset_ID: " + baleset.getElementsByTagName("Baleset_ID").item(0).getTextContent());
            System.out.println("Új kár összege: " + baleset.getElementsByTagName("Kar").item(0).getTextContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
