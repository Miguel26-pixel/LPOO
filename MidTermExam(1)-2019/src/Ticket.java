public class Ticket {
    private Concert concert;
    private int number;
    public Ticket(int number, Concert c) throws InvalidTicket{
        this.concert = c;
        if(number<0)
            throw new InvalidTicket();
        this.number = number;
    }
    public int getNumber(){
        return this.number;
    }
    public Concert getConcert(){
        return this.concert;
    }
}
