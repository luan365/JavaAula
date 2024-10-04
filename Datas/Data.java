/* Nunca printar nada, a não ser que seja na Main ou uma classe exclusiva para isso **/

public class Data implements Comparable <Data>, Cloneable{

    private byte dia, mes; // 0 to 255
    private short ano; // -32,768 to 32,767
    
    public /*void*/ Data (byte dia, byte mes, short ano) throws Exception
    {
        if (!Data.isValida(dia,mes,ano)) throw new Exception ("Data invalida");
        
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }
    //Construtor de cópia, é auxiliar para o clone
    public /*void*/ Data (Data modelo) throws Exception
    {
        if (modelo == null) throw new Exception ("Modelo invalido");
        
        this.dia=modelo.dia;
        this.mes=modelo.mes;
        this.ano=modelo.ano;
    }
    
    private static boolean isBissexto (short ano){
        // Calendário Juliano
        if(ano < 1582)
            if(ano % 4 == 0) return true;
            else return false;

        // Calendário Gregoriano
        if(ano % 400 == 0)return true;
        if(ano % 4 == 0 && ano % 100 != 0) return true;
        return false;
    }
    
    private static boolean isValida(byte dia, byte mes, short ano){
        if(ano < -45 || ano == 0) return false;

        if(ano == 1582 && mes == 10 && dia >= 5 && dia <=14) return false; // esses dias não existiram

        if(dia > 31 || dia < 1 || mes > 12 || mes < 1) return false;

        if(dia == 32 && (mes == 4 || mes == 6 || mes == 8 || mes == 10 || mes == 12)) return false;

        if(mes == 2 && dia > 28) return false;

        if(dia == 29 && mes == 2 && !Data.isBissexto(ano)) return false;

        return true;
    }

    public byte getDia ()
    {
        return this.dia;
    }

    public byte getMes ()
    {
        return this.mes;
    }

    public short getAno ()
    {
        return this.ano;
    }

    public void setDia(byte dia) throws Exception{
        if(!Data.isValida(dia,this.mes,this.ano))
            throw new Exception("Invalid dia"); // O metodo morre

        this.dia = dia;
    }
    public void setMes(byte mes) throws Exception{
        if(!Data.isValida(this.dia,mes,this.ano))
            throw new Exception("Invalid mes");

        this.mes = mes;
    }
    public void setAno(short ano) throws Exception{
        if(!Data.isValida(this.dia,this.mes,ano))
            throw new Exception("Invalid ano");

        this.ano = ano;
    }

    public void avanceUmDia () // altera o this
    {
        if (Data.isValida((byte)(this.dia+1),this.mes,this.ano))
            this.dia++;
        else if (Data.isValida((byte)1,(byte)(this.mes+1),this.ano))
        {
            this.dia=(byte)1;
            this.mes++;
        }
        else if (Data.isValida((byte)1,(byte)1,(short)(this.ano+1)))
        {
            this.dia=(byte)1;
            this.mes=(byte)1;
            this.ano++;
        }
        else if (this.ano==1582 && this.mes==10 && this.dia==4)
            this.dia=(byte)15;
        else // if (this.ano==-1 && this.mes==12 && this.dia==31)
        {
            this.dia=(byte)1;
            this.mes=(byte)1;
            this.ano=(short)1;
        }
    }
    public void avanceVariosDias (int qtd) // altera o this
    {      // faça
    }

    public void retrocedaUmDia () // altera o this
    {     
        if(this.ano==1 && this.mes==1 && this.dia==1)
            {
                this.dia=(byte)31;
                this.mes=(byte)12;
                this.ano=(short)-1;
            }

        else if (Data.isValida((byte)(this.dia-1),this.mes,this.ano))
            this.dia--;

        else if (Data.isValida((byte)31,(byte)(this.mes-1),this.ano))
        {
            this.dia=(byte)31;
            this.mes--;
        }

        else if (Data.isValida((byte)30,(byte)(this.mes-1),this.ano))
        {
            this.dia=(byte)30;
            this.mes--;
        }
        
        else if (Data.isValida((byte)29,(byte)(this.mes-1),this.ano))
        {
            this.dia=(byte)29;
            this.mes--;
        } 
        
        else if (Data.isValida((byte)28,(byte)(this.mes-1),this.ano))
        {
            this.dia=(byte)28;
            this.mes--;
        } 

        else if (Data.isValida((byte)31,(byte)12,(short)(this.ano-1)))
        {
            this.dia=(byte)31;
            this.mes=(byte)12;
            this.ano--;
        }
        else if (this.ano==1582 && this.mes==10 && this.dia==15)
            this.dia=(byte)4;
        
    }

    
    public void retrocedaVariosDias (int qtd) // altera o this
    {      // faça

    }
    
    public Data getDiaSeguinte () throws Exception // não altera o this
    {
        try {
            return new Data (this.dia++,this.mes,this.ano);
        } catch (Exception erro1) { try {
            return new Data ((byte)1,this.mes++,this.ano);
        } catch (Exception erro2) { try {
            return new Data ((byte)1,(byte)1,this.ano++);
        } catch (Exception erro3) { if (this.ano==-1) {
            return new Data ((byte)1,(byte)1,(short)1);
        } else // if (this.ano==1582 && this.mes==10 && this.dia==4) {
            return new Data ((byte)15,this.mes,this.ano);
        }}}
    }

    @Override
    public int compareTo(Data d) {
        if(this.ano > d.ano) return 1;
        if(this.ano < d.ano) return -1;
        
        if(this.mes > d.mes) return 1;
        if(this.mes < d.mes) return -1;

        if(this.dia > d.dia) return 1;
        if(this.dia < d.dia) return -1;

        return 0;
    }

    /*public Data getVariosDiasAdiante (int qtd) // não altera o this
    {      // faça
    }

    public Data getDiaAnterior () // não altera o this
    {      // faça
    }

    public Data getVariosDiasAtras (int qtd) // não altera o this
    {      // faça
    }*/

    @Override
    public String toString() {
        Byte getDia = getDia(), getMes = getMes();
        Short getAno = getAno();

        String strDia = getDia <= 9? "0" + dia : Byte.toString(getDia); 
        String strMes = getMes <= 9? "0" + mes : Byte.toString(getMes); 
        String strAno = getAno <= 9? "0" + ano : Short.toString(getAno); 

        return strDia + "/" + strMes + "/" + strAno;
    }
    @Override
    public Object clone() {
        Data ret = null;
        try{
            ret = new Data(this);
        }
        catch(Exception erro) {}
        return ret;
    }
}