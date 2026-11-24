package suiteB;

import org.testng.annotations.Test;

public class TestB1  
{
  @Test
  public void testB1() throws InterruptedException 
  {
	  System.out.println("Starting testB1");
	  Thread.sleep(2000);
	  System.out.println("Ending testB1");  
  }
}
