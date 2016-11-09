/**
 * Created by olymp on 08.11.2016.
 */
public class Human {
    int age;
    String name;

    public Human() {
        name = new String();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public String getName() {
        return name;
    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
