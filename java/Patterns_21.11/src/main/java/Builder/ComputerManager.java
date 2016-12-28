package Builder;

/**
 * Created by olymp on 21.11.2016.
 */
public class ComputerManager {
    private ComputerBuilder computerBuilder;

    public ComputerManager(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }
    public Computer buildComputer() {
        this.computerBuilder.buildnewComputer();
        this.computerBuilder.buildNewMotherBoard();//важеи порядок!
        this.computerBuilder.buildNewCpu();
        this.computerBuilder.buildNewRam();
        this.computerBuilder.buildNewHdd();
        return this.computerBuilder.getComputer();
    }

}
