package suiteA;

import org.testng.annotations.Test;

public class TestA3 
{
  @Test
  public void testA3() throws InterruptedException 
  {
	  System.out.println("Starting testA3");
	  Thread.sleep(2000);
	  System.out.println("Ending testA3");
   }
}
