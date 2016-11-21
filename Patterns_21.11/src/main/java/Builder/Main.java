package Builder;

/**
 * Created by olymp on 21.11.2016.
 */
public class Main {
    public static void main(String[] arg) {
//        ComputerManager computerManager = new ComputerManager(new IntelComputer());
//        System.out.println(computerManager.buildComputer());
        Computer.Builder builder = new Computer.Builder().
        withMotherBoard("motherBoard").
        withCpu("cpu").
        withRam("ram").
        withHdd("hdd").
                withOs("os");
        System.out.println(new Computer(builder));
    }
}
