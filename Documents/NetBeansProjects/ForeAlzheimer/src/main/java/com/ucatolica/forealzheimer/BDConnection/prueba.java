/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucatolica.forealzheimer.BDConnection;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.io.IOException;
import org.bson.Document;

/**
 *
 * @author Daniela
 */
public class prueba {

    public static void main(String[] args) throws IOException {
        MongoConnection con = new MongoConnection();
        MongoDatabase database = con.Connection();
        MongoCollection<Document> collection = database.getCollection("RF_RESULT");
        
        Document cursor = collection.find(eq("_id", "123123")).first();
        if (cursor!=null){
        System.out.println(cursor);
        System.out.println(cursor.get("_id"));
        System.out.println(cursor.get("RESULT"));
        }else{
            System.out.println("No se encontraron resultados con ID:"+ "123123");
        }
        
    }
}
