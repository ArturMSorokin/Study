package Builder;

/**
 * Created by olymp on 21.11.2016.
 */
public class Computer {
    private final String cpu;
    private final String motherBoard;
    private final String ram;
    private final String hdd;
    private final String os;

    public Computer(Builder builder) {
        this.motherBoard = builder.motherBoard;
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.hdd = builder.hdd;
        if (builder.os!=null)
            this.os = builder.os;
        else
            this.os = "os";
    }
//
//    public Computer() {
//
//    }
    public static class Builder {
        private  String cpu;
        private  String motherBoard;
        private  String ram;
        private  String hdd;
        private  String os;
        Builder() { }

        public Builder withMotherBoard(String motherBoard) {
            this.motherBoard = motherBoard;
            return this;
        }
        public Builder withCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        public Builder withRam(String ram) {
            this.ram = ram;
            return this;
        }
        public Builder withHdd(String hdd) {
            this.hdd = hdd;
            return this;
        }

        public Builder withOs(String os) {
            this.os = os;
            return this;
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


    public String getMotherBoard() {
        return motherBoard;
    }


    public String getRam() {
        return ram;
    }


    public String getHdd() {
        return hdd;
    }

}
