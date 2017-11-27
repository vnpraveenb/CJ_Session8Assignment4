
/**
 * Program to reserve tickets in an online bus reservation system using synchronization
 */
package busreservation;

//
/**
 * This class implements the booking of the tickets and printing whether they are booked or not 
 * @author Praveen
 *
 */
class Ticket
{
	int availableSeats=15;
	
	/**
	 * This method is used to book the tickets  for passengers. It checks if the seatsWanted are 
	 * available and books them if they are available and prints the same. Else, it prints 
	 * that the seats are unavailable
	 * @param passengerName Name of the passenger who wants to book tickets
	 * @param seatsWanted Number of seats available for booking
	 * @return This method returns nothing
	 */
	synchronized void bookTicket(String passengerName,int seatsWanted)
	{
		if((availableSeats>=seatsWanted)&&(seatsWanted>0))
		{
			System.out.println(passengerName + " :" + seatsWanted + " Seats booked");
			availableSeats=seatsWanted;
		}
		else
			System.out.println(passengerName + " :" + seatsWanted + " Seats not available");
	}
}

/**
 * This class extends the Thread class to implement a thread to book tickets
 * @author Praveen
 *
 */
class BookTicketsThread extends Thread
{
	Ticket tkt;
	String name;  // Name of the passenger who wants the tickets booked
	int seats;    // No. of seats wanted by the passenger
	
	/**
	 * Constructor
	 * @param ticket
	 * @param passengerName
	 * @param seatsWanted
	 */
	BookTicketsThread(Ticket ticket, String passengerName, int seatsWanted)
	{
		tkt=ticket;
		name=passengerName;
		seats=seatsWanted;
		start();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run()
	{
		tkt.bookTicket(name, seats); // Calling bookTicket method to book tickets
	}
}

/**
 * This class is used to book the tickets for the bus online
 * @author Praveen
 *
 */
public class OnlineBusReservation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Ticket tkt=new Ticket(); //Creates object of Ticket Class
		
		System.out.println("Total Seats Available: " + tkt.availableSeats);
		
		//Creates object of BookTicketsThread parameterized constructor and passing the values
		
		BookTicketsThread t1=new BookTicketsThread(tkt, "Praveen", 6);
		
		BookTicketsThread t2=new BookTicketsThread(tkt, "Ramesh", 10);
		
		BookTicketsThread t3=new BookTicketsThread(tkt, "Rakesh", 4);
	}

}
