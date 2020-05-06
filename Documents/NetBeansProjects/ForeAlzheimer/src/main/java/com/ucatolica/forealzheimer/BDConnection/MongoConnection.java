/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucatolica.forealzheimer.BDConnection;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;

/**
 *
 * @author Daniela
 */
public class MongoConnection {
    
    MongoClient con;
    
    public MongoConnection() {
        this.con = null;
    }
    
    public MongoDatabase Connection() throws IOException {

        String uri = "mongodb+srv://admin:admin@mongodb-onkfa.mongodb.net/test";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("forealzheimer");

        return database;
    }
    
}
