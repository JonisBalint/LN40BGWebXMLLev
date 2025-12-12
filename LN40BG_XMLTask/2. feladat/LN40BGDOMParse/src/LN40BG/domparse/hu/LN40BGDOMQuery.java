package LN40BG.domparse.hu;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class LN40BGDOMQuery {

    public static void main(String[] args) {

        try {
            // XML betöltése
            File inputFile = new File("LN40BG_XML.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            /*
             * 1. LEKÉRDEZÉS
             * Összes autó rendszáma + márkája + típusa
             */
            System.out.println("1. Autók listája (rendszám + márka + típus):");
            NodeList autoList = doc.getElementsByTagName("Auto");

            for (int i = 0; i < autoList.getLength(); i++) {
                Node node = autoList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element auto = (Element) node;

                    String rendszam = auto.getElementsByTagName("Rendszam").item(0).getTextContent();
                    String marka = auto.getElementsByTagName("Marka").item(0).getTextContent();
                    String tipus = auto.getElementsByTagName("Tipus").item(0).getTextContent();

                    System.out.println(" - " + rendszam + " | " + marka + " | " + tipus);
                }
            }

            System.out.println("\n====================================\n");

            /*
             * 2. LEKÉRDEZÉS:
             * Balesetek, ahol a kár > 200000
             */
            System.out.println("2. Balesetek 200000 Ft feletti kárral:");
            NodeList balList = doc.getElementsByTagName("Baleset");

            for (int i = 0; i < balList.getLength(); i++) {
                Node node = balList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element b = (Element) node;

                    int kar = Integer.parseInt(b.getElementsByTagName("Kar").item(0).getTextContent());

                    if (kar > 200000) {
                        String id = b.getElementsByTagName("Baleset_ID").item(0).getTextContent();
                        String hely = b.getElementsByTagName("Helyszin").item(0).getTextContent();

                        System.out.println(" - Baleset ID: " + id + " | Helyszín: " + hely + " | Kár: " + kar);
                    }
                }
            }

            System.out.println("\n====================================\n");

            /*
             * 3. LEKÉRDEZÉS:
             * Szervizek listája + melyik balesethez tartoznak
             */
            System.out.println("3. Szervizek és a hozzájuk tartozó balesetek:");
            NodeList szervizLista = doc.getElementsByTagName("Szerviz");

            for (int i = 0; i < szervizLista.getLength(); i++) {
                Node node = szervizLista.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element sz = (Element) node;

                    String nev = sz.getElementsByTagName("Nev").item(0).getTextContent();
                    String balesetFK = sz.getElementsByTagName("Baleset_FK").item(0).getTextContent();

                    System.out.println(" - Szerviz: " + nev + " | Baleset ID: " + balesetFK);
                }
            }

            System.out.println("\n====================================\n");

            /*
             * 4. LEKÉRDEZÉS:
             * BA1 baleset résztvevői + okozó/károsult státusz
             */
            System.out.println("4. Baleset (BA1) résztvevői + okozó/károsult státusz:");
            NodeList reszvList = doc.getElementsByTagName("Reszvetel");

            for (int i = 0; i < reszvList.getLength(); i++) {
                Node node = reszvList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element r = (Element) node;

                    String balFK = r.getElementsByTagName("Baleset_FK").item(0).getTextContent();

                    if (balFK.equals("BA1")) {
                        String rsz = r.getElementsByTagName("Rendszam_FK").item(0).getTextContent();
                        String okozo = r.getElementsByTagName("Okozo").item(0).getTextContent();
                        String karosult = r.getElementsByTagName("Karosult").item(0).getTextContent();

                        System.out.println(" - Autó: " + rsz + " | Okozó: " + okozo + " | Károsult: " + karosult);
                    }
                }
            }

            System.out.println("\n====================================\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
