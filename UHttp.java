import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URL;
import urbi.UObject; 


public class UHttp extends UObject // must extends UObject 
{ 
	/// Register the class within urbi 
	static { UStart(UHttp.class); } 

	/// the class must have a single constructor taking a string 
	public UHttp (String s) 
	{ 
		super (s); 

		/// Bind the function to Urbi 
		UBindFunction ("init"); 
	} 


	/// The init function is the constructor in Urbi. 
	public int init () 
	{ 
		/// Bind the function add to Urbi 
		UBindFunction ("get"); 

		// success
		return 0; 
	} 

	/// Our method. 
	public String get(String url) 
	{
		/*
		   UHttp.java:37: unreported exception java.net.MalformedURLException; must be caught or declared to be thrown
		   URL u = new URL(url);
		   ^
		   UHttp.java:38: unreported exception java.io.IOException; must be caught or declared to be thrown
		   BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
		   ^
		   UHttp.java:43: unreported exception java.io.IOException; must be caught or declared to be thrown
		   while ((inputLine = in.readLine()) != null)
		   ^
		   UHttp.java:46: unreported exception java.io.IOException; must be caught or declared to be thrown
		   in.close(); 
		   ^
		 */
		try 
		{
			URL u = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));

			String inputLine;
			StringBuilder sb = new StringBuilder();

			while ((inputLine = in.readLine()) != null)
				sb.append(inputLine);

			in.close(); 
			inputLine = sb.toString();
			sb = null;
			return inputLine; 
		} catch (Exception e) {
			for( StackTraceElement ste : e.getStackTrace() ) {
				System.out.println( ste + "\n" );
			}

			return "Exception caught : " + e ;
		}
	} 
}
