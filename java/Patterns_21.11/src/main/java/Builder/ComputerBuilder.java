package Builder;

/**
 * Created by olymp on 21.11.2016.
 */
public abstract class ComputerBuilder {
    protected Computer computer;
    public abstract void buildnewComputer();
    public  abstract void buildNewMotherBoard();
    public  abstract void buildNewCpu();
    public  abstract void buildNewRam();
    public  abstract void buildNewHdd();
    public  Computer getComputer() {
        return this.computer;
    }

}
