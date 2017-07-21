package redbee.challenge.db;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import redbee.challenge.services.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ftesei on 10/07/17.
 */
public class MongoConnector implements DBConnector {
    private MongoOperations mongoOperation;
    private Class mongoConfClass;
    private String mongoConfXml;
    ApplicationContext ctx;


    public MongoConnector(Class clasS) {
         ctx = new AnnotationConfigApplicationContext(clasS);
    }
    public MongoConnector(String xml) {
         ctx = new AnnotationConfigApplicationContext(xml);
    }

    public MongoConnector(){
        this(MongoConfiguration.class);
    }



    @Override
    public void connect() {
        mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
    }

    @Override
    public void disconnect() {
        mongoOperation = null;
    }


    public MongoOperations getMongoOperation() {
        if(mongoOperation == null)
            connect();
        return mongoOperation;
    }

    public void setMongoOperation(MongoOperations mongoOperation) {
        this.mongoOperation = mongoOperation;
    }

    public Class getMongoConfClass() {
        return mongoConfClass;
    }

    public void setMongoConfClass(Class mongoConfClass) {
        this.mongoConfClass = mongoConfClass;
    }

    public String getMongoConfXml() {
        return mongoConfXml;
    }

    public void setMongoConfXml(String mongoConfXml) {
        this.mongoConfXml = mongoConfXml;
    }

}
