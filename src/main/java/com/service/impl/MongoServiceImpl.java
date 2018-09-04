package com.service.impl;

import com.entity.MongoDoc;
import com.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
@Service
public class MongoServiceImpl implements MongoService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public MongoDoc get(String key) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(key);
        query.addCriteria(criteria);
        MongoDoc result = mongoTemplate.findOne(query, MongoDoc.class);
        return result;
    }
}
