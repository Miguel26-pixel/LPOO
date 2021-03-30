import java.util.ArrayList;
import java.util.List;

public class BoxOffice {
    public BoxOffice() {}
    public static List<Ticket> buy(Concert concert, int number) throws InvalidTicket {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Ticket t = new Ticket(concert.UpNumber_ticket(), concert);
            tickets.add(t);
        }
        return tickets;
    }
}

