/* Nunca printar nada, a não ser que seja na Main ou uma classe exclusiva para isso **/

public class Date{

    private byte day, month; // 0 to 255
    private short year; // -32,768 to 32,767

    private static boolean isBissexto (short year){
        // Calendário Juliano
        if(year < 1582)
            if(year % 4 == 0) return true;
            else return false;

        // Calendário Gregoriano
        if(year % 400 == 0)return true;
        if(year % 4 == 0 && year % 100 != 0) return true;
        return false;
    }

    private static boolean isValid(byte day, byte month, short year){
        if(year < -45 || year == 0) return false;

        if(year == 1582 && month == 10 && day >= 5 && day <=14) return false; // esses dias não existiram

        if(day > 31 || day < 1 || month > 12 || month < 1) return false;

        if(day == 31 && month == 4 || month == 6 || month == 8 || month == 10 || month == 12) return false;

        if(month == 2 && day > 28) return false;

        if(day == 29 && month == 2 && !Date.isBissexto(year)) return false;

        return true;
    }

    public void setDay(byte day) throws Exception{
        if(!Date.isValid(day,this.month,this.year))
            throw new Exception("Invalid day"); // O metodo morre

        this.day = day;
    }
    public void setMonth(byte month) throws Exception{
        if(!Date.isValid(this.day,month,this.year))
            throw new Exception("Invalid month");

        this.month = month;
    }
    public void setYear(short year) throws Exception{
        if(!Date.isValid(this.day,this.month,year))
            throw new Exception("Invalid year");

        this.year = year;
    }

}