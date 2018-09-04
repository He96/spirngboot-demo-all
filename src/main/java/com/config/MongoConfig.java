package com.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.config.ConfigUtil.*;

/**
 * mongodb基础配置，springBoot集成可以不使用
 * 调用方法
 *  MongoDatabase mongoDatabase = MongoConfig.mongoDatabase
 *  MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
 *  collection.find().first();
 */

public class MongoConfig {

    public static MongoDatabase mongoDatabase;

     static {
        if (!MONGODB_ISONLY) {
            List<ServerAddress> addresses = new ArrayList<>();
            for (String str : MONGODB_URLS.split("T")) {
                addresses.add(new ServerAddress(str.split(":")[0].trim(), Integer.parseInt(str.split(":")[1].trim())));
            }
            MongoClient mongoClient = new MongoClient(addresses);
            mongoDatabase = mongoClient.getDatabase(MONGODB_DATABASE);
        } else {
            ServerAddress address = new ServerAddress(MONGODB_HOST, MONGODB_PORT);
            MongoCredential credential = MongoCredential.createCredential(MONGODB_USERNAME, MONGODB_DATABASE, MONGODB_PASSWORD.toCharArray());
            MongoClient mongoClient = new MongoClient(address);
            mongoDatabase = mongoClient.getDatabase(MONGODB_DATABASE);
        }
    }
}
