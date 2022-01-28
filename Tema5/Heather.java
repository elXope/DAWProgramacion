package Tema5;

public class Heather {

    private double temperature;
    private double increment;
    private double min;
    private double max;

    public Heather(double min, double max) {
        this.temperature = 15.0;
        this.increment = 5.0;
        this.min = min;
        this.max = max;
    }

    public void setIncrement(double increment) {
        if (1.0 <= increment && increment <= 5) this.increment = increment;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void warmer() {
        if (this.temperature + this.increment <= this.max) this.temperature += this.increment;
    }

    public void cooler() {
        if (this.temperature - this.increment >= this.min) this.temperature -= this.increment;
    }
}
