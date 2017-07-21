package redbee.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mongodb.util.JSON;
import org.bson.Document;
import redbee.challenge.models.User;

import java.io.IOException;

/**
 * Created by ftesei on 11/07/17.
 */
public class Utils {

/*
    public static String userToJsonString(User u){
        Gson gson = new Gson();
       return gson.toJson(u);

    }
    public static Document jsonStringToDocument(String  jsonString){

        return  Document.parse(jsonString);
    }

    public static Document userToDocument(User  u){

        return jsonStringToDocument(userToJsonString(u));
    }
    public static String documentToJsonString(Document d){
        return JSON.serialize(d);

    }
    public  static Object jsonToObj( String json ,Class clasS) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json,clasS);
    }
    public static Object documentToObj(Document doc, Class clasS) throws IOException {

        return jsonToObj(documentToJsonString(doc),clasS);
    }
    */
}
