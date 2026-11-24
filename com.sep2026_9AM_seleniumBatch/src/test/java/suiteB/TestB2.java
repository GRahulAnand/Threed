package suiteB;

import org.testng.annotations.Test;

public class TestB2 {
  @Test
  public void testB2() throws InterruptedException 
  {
	  System.out.println("Starting testB2");
	  Thread.sleep(2000);
	  System.out.println("Ending testB2");  
  }
}
