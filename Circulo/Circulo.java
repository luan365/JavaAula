package Circulo;

public class Circulo {
    int comprimento, raio, area;
    int[] centro = new int[2];

    public Circulo(int[] centro, int raio) throws Exception{
        if(raio < 0){
            throw new Exception("Valor inválido");
        }
        this.raio = raio;
        this.centro = centro;
    }

    public double getComprimento(){
        return this.raio * 2 * Math.PI;
    }
    public double getArea(){
        return Math.PI * Math.pow(this.raio, 2);
    }

    public void setCentro(int x, int y)throws Exception{
        if(x < 0 || y < 0){
            throw new Exception("Valor inválido");
        }
        this.centro[0] = x;
        this.centro[1] = y;
    }

}
