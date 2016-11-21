package Builder;

/**
 * Created by olymp on 21.11.2016.
 */
public class Computer {
    private String cpu;
    private String motherBoard;
    private String ram;
    private String hdd;
    public Computer(Builder builder) {
        this.motherBoard = builder.motherBoard;
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.hdd = builder.hdd;
    }

    public Computer() {

    }

    public static class Builder {
        private String cpu;
        private String motherBoard;
        private String ram;
        private String hdd;
        Builder() { }

        public void withMotherBoard(String motherBoard) {
            this.motherBoard = motherBoard;
        }
        public void withCpu(String cpu) {
            this.cpu = cpu;
        }
        public void withRam(String ram) {
            this.ram = ram;
        }
        public void withHdd(String hdd) {
            this.hdd = hdd;
        }

    }

    @Override
    public String toString() {
        return new StringBuilder(motherBoard).append("|").
                append(cpu).append("|").
                append(ram).append("|").
                append(hdd).append("|").
                append(ram).append("|").toString();
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
