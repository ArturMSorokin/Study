import java.io.Serializable;

/**
 * Created by olymp on 08.11.2016.
 */
public class Main {
    public static void main(String[] arg) {
        Human human = new Human(22,"Vasya");
        Serializer serializer = new Serializer();
        String stringObject = null;
        try {
            stringObject = serializer.serialize(human);
            System.out.println(stringObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
