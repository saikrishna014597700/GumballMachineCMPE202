
import java.util.*;

public class GumballMachine
{

    private int num_gumballs;
    private boolean has_enough_money;
    
    private enum machine_type {QUARTERCENTMACHINE, TWOQUARTERCENTMACHINE, ANYCOIN50CENTSMACHINE};
    
    private machine_type current_machine_type;
    
    private int amount;
    
    private Map<machine_type,Integer> remaining_amount;

    public GumballMachine( int size , machine_type current_machine_type)
    {
        // initialise instance variables
        this.num_gumballs = size;
        this.has_enough_money = false;
        this.current_machine_type = current_machine_type;
       
    }

    public void insertCoin(int coin)
    {
    	
    	amount = amount + coin;
    	System.out.println("you entered "+amount + " cents until now");
    	if(current_machine_type == machine_type.QUARTERCENTMACHINE) {
    	
        if ( coin == 25 && amount == 25) {
            this.has_enough_money = true ;
            System.out.println("You have enough money !! please turn crank");
        }
        
        else 
            this.has_enough_money = false ;
    	}
    	
    	if(current_machine_type == machine_type.TWOQUARTERCENTMACHINE) {
    		
    		if ( coin == 25 )
    		{
    			if(amount ==50) {
    				this.has_enough_money = true ;
    				System.out.println("You have enough money !! please turn crank");
    			}
    		}
    		else 
                this.has_enough_money = false ;
    		
    	}
    	
    	if(current_machine_type == machine_type.ANYCOIN50CENTSMACHINE) {
    		
    		if ( coin == 25 || coin ==10 || coin ==5)
    		{
    			
    			if(amount ==50) {
    				this.has_enough_money = true ;
    				System.out.println("You have enough money !! please turn crank");
    			}
    		}
    		else 
                this.has_enough_money = false ;
    		
    	}
    }
    
    public void turnCrank()
    {
    	if ( this.has_enough_money )
    	{
    		if ( this.num_gumballs > 0 )
    		{
    			this.num_gumballs-- ;
    			this.has_enough_money = false ;
    			System.out.println( "Thanks for your Money.  Gumball Ejected!" ) ;
    		}
    		else
    		{
    			System.out.println( "No More Gumballs!  Sorry, can't return your Money." ) ;
    		}
    		
    	}
    	else 
    	{
    		System.out.println( "Please insert enough money" ) ;
    	}  
    	amount = 0;
    }
    
    
    public static void main(String args[]) {
    	GumballMachine gm = new GumballMachine(10, machine_type.QUARTERCENTMACHINE) ;
    	
    	System.out.println("***Test case for First machine with enough balls and enough money***");
    	gm.insertCoin(25);
    	gm.turnCrank();
    	
    	System.out.println("***Test case for First machine without enough balls***");
    	gm.setNum_gumballs(0);
    	gm.insertCoin(25);
    	gm.turnCrank();
    	
    	System.out.println("***Test case for First machine without enough money***");
    	gm.setNum_gumballs(10);
    	gm.insertCoin(10);
    	gm.turnCrank();

    	
    	System.out.println("***Test case for Second machine with enough balls and enough money***");
    	gm.setCurrent_machine_type(machine_type.TWOQUARTERCENTMACHINE);
    	gm.insertCoin(25);
    	gm.insertCoin(25);
    	gm.turnCrank();
    	
    	
    	System.out.println("***Test case for second machine without enough balls***");
    	gm.setNum_gumballs(0);
    	gm.insertCoin(25);
    	gm.insertCoin(25);
    	gm.turnCrank();
    	
    	System.out.println("***Test case for second machine without enough money***");
    	gm.setNum_gumballs(10);
    	gm.insertCoin(10);
    	gm.insertCoin(25);
    	gm.turnCrank();
    	
    	System.out.println("***Test case for Third machine with enough money and enough gumballs***");
    	gm.setCurrent_machine_type(machine_type.ANYCOIN50CENTSMACHINE);
    	gm.setNum_gumballs(10);
    	gm.insertCoin(10);
    	gm.insertCoin(25);
    	gm.insertCoin(10);
    	gm.insertCoin(5);
    	gm.turnCrank();
    	
    	System.out.println("***Test case for Third machine without enough gumballs***");
    	
    	gm.setNum_gumballs(0);
    	gm.insertCoin(10);
    	gm.insertCoin(25);
    	gm.insertCoin(10);
    	gm.insertCoin(5);
    	gm.turnCrank();
    	
    	
    }

	public machine_type getCurrent_machine_type() {
		return current_machine_type;
	}

	public void setCurrent_machine_type(machine_type current_machine_type) {
		this.current_machine_type = current_machine_type;
	}

	public int getNum_gumballs() {
		return num_gumballs;
	}

	public void setNum_gumballs(int num_gumballs) {
		this.num_gumballs = num_gumballs;
	}
}