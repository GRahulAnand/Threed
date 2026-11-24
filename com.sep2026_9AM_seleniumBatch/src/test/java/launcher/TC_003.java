package launcher;

import java.io.IOException;

public class TC_003 extends BaseTest{

	public static void main(String[] args) throws IOException 
	{
		init();
		launch("chromebrowser");
		navigateUrl("amazonurl");
		

	}

}
