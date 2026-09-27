class Solution {
    public double[] convertTemperature(double celsius) {
        double [] a=new double[2];
        double kelvin = celsius + 273.15;
        double Fahrenheit = celsius * 1.80 + 32.00;
        a[0] = kelvin;
        a[1] = Fahrenheit;
        return a;
    }
}