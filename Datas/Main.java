
public class Main
{
    public static void main (String[] args)
    {

        try
        {
            Data data = new Data ((byte)31,(byte)8,(short)2024);

            data.avanceUmDia();            
            
            System.out.println (data.getDia()+"/"+
                                data.getMes()+"/"+
                                data.getAno());

        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }

    }
}
