package org.sector7.util;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.JSONPObject;

import java.io.IOException;
import java.util.List;


/**
 * Created by s.zakipour on 04/04/2016.
 */
public class JsonUtil {
    public Object createPOJOFromJSON(String json, Object obj) {
        JSONPObject object = new JSONPObject(json, obj);

        return object.getValue();
    }

    public List createPOJOListFromJSON(String json , Object obj) {


        ObjectMapper mapper = new ObjectMapper();


        List list = null;
        try {
            list = (List) mapper.readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
