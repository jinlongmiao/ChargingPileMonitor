package protocol;

import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by violetMoon on 2017/12/11.
 */
public class ObjectEncoder {

    private static Map<String, String> toFieldMap(Object data) {
        Field[] fields = data.getClass().getFields();
        Map<String, String> dataMap = new HashMap<>(fields.length);
        for (Field field : fields) {
            try {
                dataMap.put(field.getName(), field.get(data).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return dataMap;
    }

    protected void encode(Object obj, DataOutputStream out) throws Exception {
        System.out.println("StringMapEncoder.encode");
        toFieldMap(obj).entrySet().forEach(e ->{
            byte[] keyBytes = e.getKey().getBytes();
            byte[] valueBytes = e.getValue().getBytes();
            try {
                out.writeInt(keyBytes.length);
                out.writeBytes(e.getKey());
                out.writeInt(valueBytes.length);
                out.writeBytes(e.getValue());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        out.writeInt(-1);
    }
//
}
