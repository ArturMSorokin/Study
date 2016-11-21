package Builder;

/**
 * Created by olymp on 21.11.2016.
 */
public class Computer {
    private String cpu;
    private String motherBoard;
    private String ram;
    private String hdd;
    private String gpu;

    public Computer(String cpu, String motherBoard, String ram, String hdd) {
        this.cpu = cpu;
        this.motherBoard = motherBoard;
        this.ram = ram;
        this.hdd = hdd;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(String motherBoard) {
        this.motherBoard = motherBoard;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }
}
