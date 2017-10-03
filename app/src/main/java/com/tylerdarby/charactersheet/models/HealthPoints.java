package com.tylerdarby.charactersheet.models;

/**
 * Created by tdarby on 10/2/17.
 */

public class HealthPoints {
    private int current;
    private int max;
    private int temp;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
