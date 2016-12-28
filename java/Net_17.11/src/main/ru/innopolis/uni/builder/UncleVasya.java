package ru.innopolis.uni.builder;

/**
 * Created by olymp on 17.11.2016.
 */
public class UncleVasya implements Eater , Builder {
    public void build() {
        realBuilder.build();
    }
    public void eat() {
        realEater.eat();
    }
    private Builder realBuilder;
    private Eater realEater;
    public UncleVasya(Builder realBuilder, Eater readEater) {
        this.realBuilder = realBuilder;
        this.realEater = readEater;
    }
}
