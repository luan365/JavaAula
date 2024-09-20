package Angulo;

public class Angulo {
    private double angulo;

    public Angulo (short angulo){
        this.angulo = angulo % 360;
    }

    public void setAngulo(double angulo) throws Exception{
        this.angulo = angulo;
    }

    public double getAngulo(){
        return this.angulo;
    }

    public double getValorEmGraus(){
        return angulo;
    }

    public double getValorEmGrados(){
        return angulo * 1.111111111111;
    }

    public double getValorEmRadianos(){
        return angulo * Math.PI / 180;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setValorEmGraus (double angulo){
        this.angulo = angulo;
    }
    
    public void setValorEmGrados (double grados){
        this.angulo = grados * 1.111111111111;
    }

    public void setValorEmRadianos (double radianos){
        this.angulo = radianos * 180 / Math.PI;
    }

    @Override
    public int hashCode() {
        return (int)this.angulo;
    }

    @Override
    public boolean equals(Object angulo) {
        if(angulo == this) return true;
        return false;
    }   

    @Override
    public String toString(){
        String strAngulo = Double.toString(getAngulo());
        return strAngulo + "°";
    }

}
