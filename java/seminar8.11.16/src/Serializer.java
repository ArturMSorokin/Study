import java.lang.reflect.Field;

/**
 * Created by olymp on 08.11.2016.
 */
public class Serializer {
    public String serialize(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<"+clazz.getName()+">\n");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String fieldS="    <"+field.getName()+" type=\""+field.getType()+"\" value=\""+field.get(object)+"\">\n";
            stringBuilder.append(fieldS);
        }
        stringBuilder.append("</"+clazz.getName()+">");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
DOM!!!
    private String getEntryFor(String name) {

        if (toString().isEmpty()) {

        } else {

        }
        return;
    }

    public Object deserialize(String xml) {
        Object result = null;
        Class clazz = Class.forName()
        return new Object();
    }
}
