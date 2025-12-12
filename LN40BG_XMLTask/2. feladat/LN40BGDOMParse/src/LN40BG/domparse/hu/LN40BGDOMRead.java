package LN40BG.domparse.hu;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class LN40BGDOMRead {

    public static void main(String[] args) {

        try {
            // ==== XML betöltése ====
            File xmlFile = new File("LN40BG_XML.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();


            // ==========================
            //        TULAJOK
            // ==========================
            NodeList tulajList = doc.getElementsByTagName("Tulaj");
            System.out.println("\n--- TULAJOK ---");

            for (int i = 0; i < tulajList.getLength(); i++) {
                Node node = tulajList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    System.out.println("Tulaj_ID: " + elem.getElementsByTagName("Tulaj_ID").item(0).getTextContent());
                    System.out.println("Név: " + elem.getElementsByTagName("Nev").item(0).getTextContent());

                    NodeList telszamok = elem.getElementsByTagName("Telszam");
                    System.out.print("Telszám(ok): ");

                    // Telszámok
                    for (int t = 0; t < telszamok.getLength(); t++) {
                        System.out.print(telszamok.item(t).getTextContent());
                        if (t < telszamok.getLength() - 1) System.out.print(", ");
                    }


                    // Cím
                    Element cim = (Element) elem.getElementsByTagName("Cim").item(0);
                    System.out.println("\n" + "Cím: " +
                            cim.getElementsByTagName("Varos").item(0).getTextContent() + ", " +
                            cim.getElementsByTagName("Utca").item(0).getTextContent() + " " +
                            cim.getElementsByTagName("Hazszam").item(0).getTextContent() + "\n"
                    );
                }
            }

            // ==========================
            //        AUTÓK
            // ==========================
            NodeList autoList = doc.getElementsByTagName("Auto");
            System.out.println("--- AUTÓK ---");

            for (int i = 0; i < autoList.getLength(); i++) {
                Node node = autoList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    System.out.println("Rendszám: " + elem.getElementsByTagName("Rendszam").item(0).getTextContent());
                    System.out.println("Tulaj_FK: " + elem.getElementsByTagName("Tulaj_FK").item(0).getTextContent());
                    System.out.println("Márka: " + elem.getElementsByTagName("Marka").item(0).getTextContent());
                    System.out.println("Típus: " + elem.getElementsByTagName("Tipus").item(0).getTextContent());
                    System.out.println("Gyártási év: " + elem.getElementsByTagName("Gyartasi_ev").item(0).getTextContent() + "\n") ;
                }
            }

            // ==========================
            //      BIZTOSÍTÁSOK
            // ==========================
            NodeList biztList = doc.getElementsByTagName("Biztositas");
            System.out.println("--- BIZTOSÍTÁSOK ---");

            for (int i = 0; i < biztList.getLength(); i++) {
                Node node = biztList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    System.out.println("Bizt_ID: " + elem.getElementsByTagName("Bizt_ID").item(0).getTextContent());
                    System.out.println("Biztosító: " + elem.getElementsByTagName("Biztosito").item(0).getTextContent());
                    System.out.println("Típus: " + elem.getElementsByTagName("Tipus").item(0).getTextContent());
                    System.out.println("Díj: " + elem.getElementsByTagName("Dij").item(0).getTextContent());
                    System.out.println("Rsz_FK: " + elem.getElementsByTagName("Rsz_FK").item(0).getTextContent() + "\n");
                }
            }

            // ==========================
            //        BALESETEK
            // ==========================
            NodeList balList = doc.getElementsByTagName("Baleset");
            System.out.println("--- BALESETEK ---");

            for (int i = 0; i < balList.getLength(); i++) {
                Node node = balList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    System.out.println("Baleset_ID: " + elem.getElementsByTagName("Baleset_ID").item(0).getTextContent());
                    System.out.println("Rsz_BFK: " + elem.getElementsByTagName("Rsz_BFK").item(0).getTextContent());
                    System.out.println("Dátum: " + elem.getElementsByTagName("Datum").item(0).getTextContent());
                    System.out.println("Helyszín: " + elem.getElementsByTagName("Helyszin").item(0).getTextContent());
                    System.out.println("Leírás: " + elem.getElementsByTagName("Leiras").item(0).getTextContent());
                    System.out.println("Kár: " + elem.getElementsByTagName("Kar").item(0).getTextContent() + "\n");
                }
            }

            // ==========================
            //        SZERVIZEK
            // ==========================
            NodeList szervizList = doc.getElementsByTagName("Szerviz");
            System.out.println("--- SZERVIZEK ---");

            for (int i = 0; i < szervizList.getLength(); i++) {
                Node node = szervizList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    System.out.println("Szerviz_ID: " + elem.getElementsByTagName("Szerviz_ID").item(0).getTextContent());
                    System.out.println("Baleset_FK: " + elem.getElementsByTagName("Baleset_FK").item(0).getTextContent());
                    System.out.println("Telefonszám: " + elem.getElementsByTagName("Telszam").item(0).getTextContent());
                    System.out.println("Cím: " + elem.getElementsByTagName("Cim").item(0).getTextContent());
                    System.out.println("Név: " + elem.getElementsByTagName("Nev").item(0).getTextContent() + "\n");
                }
            }

            // ==========================
            //        RÉSZVÉTEL
            // ==========================
            NodeList reszList = doc.getElementsByTagName("Reszvetel");
            System.out.println("--- RÉSZVÉTEL ---");

            for (int i = 0; i < reszList.getLength(); i++) {
                Node node = reszList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    System.out.println("Baleset_FK: " + elem.getElementsByTagName("Baleset_FK").item(0).getTextContent());
                    System.out.println("Rendszam_FK: " + elem.getElementsByTagName("Rendszam_FK").item(0).getTextContent());
                    System.out.println("Okozó: " + elem.getElementsByTagName("Okozo").item(0).getTextContent());
                    System.out.println("Károsult: " + elem.getElementsByTagName("Karosult").item(0).getTextContent() + "\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
