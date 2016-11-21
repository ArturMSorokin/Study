package Builder;

/**
 * Created by olymp on 21.11.2016.
 */
public class IntelComputer extends ComputerBuilder{
//    protected Computer computer;
    @Override
    public void buildnewComputer() {
        this.computer = new Computer();
    }

    @Override
    public void buildNewMotherBoard() {
        this.computer.setMotherBoard("Intel");
    }

    @Override
    public void buildNewCpu() {
        this.computer.setCpu("Intel");
    }

    @Override
    public void buildNewRam() {
        this.computer.setRam("Intel");
    }

    @Override
    public void buildNewHdd() {
        this.computer.setHdd("Intel");
    }
}
