package Horario;

public class Horario
{
    // atributos hora, minuto e segundo
    // construtor com parâmetros H, M e S
    // getter e setters para todos atributos
    // toString e equals

    private byte segundos, minutos;
    private short horas;

    public Horario (byte segundos, byte minutos, short horas) throws Exception
    {
        if(!Horario.isValida(segundos, minutos, horas))
            throw new Exception ("Horário inválido");

        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
    }

    private static boolean isValida(byte segundos, byte minutos, short horas){
        if(segundos > 60)
            return false;
        if(minutos > 60)
            return false;
        if(segundos < 0 || minutos < 0 || horas < 0)
            return false;

        return true;
    }

    public byte getSegundos() {
        return this.segundos;
    }
    public byte getMinutos() {
        return this.minutos;
    }
    public short getHoras() {
        return this.horas;
    }

    public void setSegundos(byte segundos) throws Exception{
        if(isValida(segundos, this.minutos, this.horas))
            throw new Exception("Segundos inválido");

        segundos = this.segundos;
    }

    public void setMinutos(byte minutos) throws Exception{
        if(isValida(segundos, this.minutos, horas))
            throw new Exception("Minutos inválidos");

        minutos = this.minutos;
    }

    public void setHoras(short horas) throws Exception{
        if(isValida(segundos, minutos, this.horas))
            throw new Exception("Horas inválidas");

        horas = this.horas;
    }

    public void adiante (int qtdSegundos) throws Exception
    {
        if(qtdSegundos <= 0)
            throw new Exception("Valor inválido. Escolha um número maior que zero.");

            this.segundos += qtdSegundos;
        while(this.segundos >= 60) {
            this.segundos -= 60;
            if(this.minutos < 60)
                this.minutos++;

            if(this.minutos == 60){
                this.minutos = 0;
                this.horas++;
            }
        }
        //dar exceção se qtdSegundos<=0
        
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + segundos;
        result = prime * result + minutos;
        result = prime * result + horas;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Horario other = (Horario) obj;
        if (segundos != other.segundos)
            return false;
        if (minutos != other.minutos)
            return false;
        if (horas != other.horas)
            return false;
        return true;
    }

    public void atrase (int qtdSegundos) throws Exception
    {
        if(qtdSegundos <= 0)
            throw new Exception("Valor inválido. Escolha um número maior que zero.");

            this.segundos -= qtdSegundos;

            while(this.segundos < 0) {
                this.segundos += 60;
                if(this.minutos >= 0)
                this.minutos--;
    
                if(this.minutos < 0){
                    this.minutos = 60;
                    this.horas--;
                }
            }    
        
        //dar exceção se qtdSegundos<=0
        
    }
    public int diferenca (Horario h) throws Exception
    {

        int segundos1, segundosH;

        Horario temp = new Horario((byte)0, (byte)0, (short)0);

        if(h == null)
            throw new Exception("Valor inválido. Escolha um número maior que zero.");
        
        segundos1 = this.segundos + (this.minutos * 60) + (this.horas * 3600);
        segundosH = h.segundos + (h.minutos * 60) + (h.horas * 3600);

        segundos1 -= segundosH;

        while(segundos1 >= 60) {
            temp.minutos++;

            if(temp.minutos == 60){
                temp.minutos = 0;
                temp.horas++;
            }
        }
        return temp.segundos + (temp.minutos * 60) + (temp.horas * 3600);
    }

    public Horario getHorarioFuturo (int qtdSegundos) throws Exception
    {
        if(qtdSegundos <= 0)
            throw new Exception("Valor inválido. Escolha um número maior que zero.");

        Horario ret = new Horario(this.segundos,this.minutos,this.horas);

        ret.segundos += qtdSegundos;
        while(ret.segundos >= 60) {
            if(ret.minutos < 60)
                ret.minutos++;

            if(ret.minutos == 60){
                ret.minutos = 0;
                ret.horas++;
            }
        }
        // modificar o ret para avancar qtdSegundos
        return ret;
        //dar exceção se qtdSegundos<=0
    }
    public Horario getHorarioPassado (int qtdSegundos) throws Exception
    {
        if(qtdSegundos <= 0)
            throw new Exception("Valor inválido. Escolha um número maior que zero.");

        Horario ret = new Horario(this.segundos,this.minutos,this.horas);

        ret.segundos -= qtdSegundos;
        while(ret.segundos < 0) {
            if(ret.minutos > 0)
                ret.minutos--;

            if(ret.minutos == 0){
                ret.minutos = 60;
                ret.horas--;
            }
        }
        return ret;
    }

    @Override
    public String toString(){
        Byte getSegundos = getSegundos(), getMinutos = getMinutos();
        short getHoras = getHoras();
        
        String strSegundos = getSegundos <= 9? "0" + getSegundos : Byte.toString(getSegundos);
        String strMinutos = getMinutos <= 9? "0" + getMinutos : Byte.toString(getMinutos);
        String strHoras = getHoras <= 9? "0" + getHoras : Short.toString(getHoras);

        return strHoras + ":" + strMinutos + ":" + strSegundos;
    }

}
