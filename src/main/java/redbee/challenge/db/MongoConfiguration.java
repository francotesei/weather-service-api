package redbee.challenge.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import redbee.challenge.Properties;

import java.util.Arrays;

import static java.lang.Integer.parseInt;


/**
 * Created by ftesei on 11/07/17.
 */
@Configuration
public class MongoConfiguration {

    public @Bean MongoDbFactory mongoDbFactory() throws Exception {
        Properties props = Properties.getInstance();
        ServerAddress serverAddress = new ServerAddress(props.getProperty("mongoHost"), parseInt(props.getProperty("mongoPort")));
        MongoCredential credential = MongoCredential.createCredential(props.getProperty("mongoUser"), props.getProperty("mongoDB"), props.getProperty("mongoPass").toCharArray());
        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));

        return new SimpleMongoDbFactory(mongoClient, props.getProperty("mongoDB"));
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}