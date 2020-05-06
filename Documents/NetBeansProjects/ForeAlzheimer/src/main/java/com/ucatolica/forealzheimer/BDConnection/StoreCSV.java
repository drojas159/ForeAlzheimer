/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucatolica.forealzheimer.BDConnection;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.servlet.http.Part;
import org.bson.Document;

/**
 *
 * @author Daniela
 */
public class StoreCSV {

    public StoreCSV() {
    }

    public ArrayList<ArrayList<String>> readCSV(Part archivo) throws IOException {

        InputStream is = archivo.getInputStream();
        Scanner sc = new Scanner(is);
        ArrayList<ArrayList<String>> datos = new ArrayList<>();

        String linea;

        while (sc.hasNext()) {

            linea = sc.nextLine();
            linea = linea.replaceAll(" ", "");
            String[] datosDeLinea = linea.split(",");
            ArrayList<String> datosTemporal = new ArrayList<>();
            datosTemporal.addAll(Arrays.asList(datosDeLinea));
            datos.add(datosTemporal);
        }

        datos.remove(0);
        return datos;
    }

    public void StoreCsv(String doc, List<Part> archivos, String action) throws IOException {
        MongoConnection con = new MongoConnection();
        MongoDatabase database = con.Connection();
        int i = 0;
        for (Part archivo : archivos) {
            i++;
            switch (action) {
                case "EEG": {

                    MongoCollection<Document> collection = database.getCollection("EEG_" + doc + "_" + i);
                    ArrayList<ArrayList<String>> datos = readCSV(archivo);

                    System.out.println(datos);

                    List<Document> documents = new ArrayList<>();

                    for (ArrayList<String> dato : datos) {

                        documents.add(new Document("COUNTER", parseFloat(dato.get(0)))
                                .append("INTERPOLATED", parseFloat(dato.get(1)))
                                .append("AF3", parseFloat(dato.get(2))).append("F7", parseFloat(dato.get(3)))
                                .append("F3", parseFloat(dato.get(4))).append("FC5", parseFloat(dato.get(5)))
                                .append("T7", parseFloat(dato.get(6))).append("P7", parseFloat(dato.get(7)))
                                .append("O1", parseFloat(dato.get(8))).append("O2", parseFloat(dato.get(9)))
                                .append("P8", parseFloat(dato.get(10))).append("T8", parseFloat(dato.get(11)))
                                .append("FC6", parseFloat(dato.get(12))).append("F4", parseFloat(dato.get(13)))
                                .append("F8", parseFloat(dato.get(14))).append("AF4", parseFloat(dato.get(15)))
                                .append("RAW_CQ", parseFloat(dato.get(16))).append("GYROX", parseFloat(dato.get(17)))
                                .append("GYROY", parseFloat(dato.get(18))).append("MARKER", parseFloat(dato.get(19)))
                                .append("SYNC", parseFloat(dato.get(20))).append("TIME_STAMP_s", parseFloat(dato.get(21)))
                                .append("TIME_STAMP_ms", parseFloat(dato.get(22))).append("CQ_AF3", parseFloat(dato.get(23)))
                                .append("CQ_F7", parseFloat(dato.get(24))).append("CQ_F3", parseFloat(dato.get(25)))
                                .append("CQ_FC5", parseFloat(dato.get(26))).append("CQ_T7", parseFloat(dato.get(27)))
                                .append("CQ_P7", parseFloat(dato.get(28))).append("CQ_O1", parseFloat(dato.get(29)))
                                .append("CQ_O2", parseFloat(dato.get(30))).append("CQ_P8", parseFloat(dato.get(31)))
                                .append("CQ_T8", parseFloat(dato.get(32))).append("CQ_FC6", parseFloat(dato.get(33)))
                                .append("CQ_F4", parseFloat(dato.get(34))).append("CQ_F8", parseFloat(dato.get(35)))
                                .append("CQ_AF4", parseFloat(dato.get(36))).append("CQ_CMS", parseFloat(dato.get(37)))
                                .append("CQ_DRL", parseFloat(dato.get(38)))
                        );
                    }
                    collection.insertMany(documents);
                    break;
                }

                case "ETCSV": {

                    MongoCollection<Document> collection = database.getCollection("ETCSV_" + doc + "_" + i);
                    ArrayList<ArrayList<String>> datos = readCSV(archivo);
                    List<Document> documents = new ArrayList<>();

                    for (ArrayList<String> dato : datos) {
                        documents.add(new Document ("Avi TimeStamp", dato.get(0))
                                .append("Frame", parseInt(dato.get(1)))
                                .append("Spot x", parseFloat(dato.get(2)))
                                .append("Spot y", parseFloat(dato.get(3)))
                                .append("Pupil x", parseFloat(dato.get(4)))
                                .append("Pupil y", parseFloat(dato.get(5)))
                                .append("Pupil r", parseFloat(dato.get(6)))
                                .append("Scene x", parseFloat(dato.get(7)))
                                .append("Scene y", parseFloat(dato.get(8)))
                                .append("XDAT", parseFloat(dato.get(9)))
                        );
                    }

                    collection.insertMany(documents);

                    break;
                   
                }
            }
        }
    }
}
