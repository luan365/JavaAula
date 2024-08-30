package Horario;

public class Main
{
    public static void main (String[] args)
    {

        try
        {
            Horario horario = new Horario ((byte)60,(byte)8,(short)5);
            Horario h1 = new Horario ((byte)31,(byte)8,(short)5);
            
            System.out.println(horario.getSegundos() + ":" + 
                               horario.getMinutos() + ":" + 
                               horario.getHoras());

            horario.adiante(5);
            System.out.println(horario.getSegundos() + ":" + 
                               horario.getMinutos() + ":" + 
                               horario.getHoras());

            horario.atrase(5);
            System.out.println(horario.getSegundos() + ":" + 
                               horario.getMinutos() + ":" + 
                               horario.getHoras());


            System.out.println(horario.diferenca(h1) + " segundos.");

        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }

    }
}
