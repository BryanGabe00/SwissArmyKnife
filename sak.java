/**
  * @author Bryan Gabe
  * @version 1.0
  * This program uses HttpRequest.java developed by Eric Pogue
**/
public class sak
{
  public static void main(String[] args)
  {
    long startTime = System.nanoTime();

    if(args.length < 1)
    {
      System.out.println("Please use -Help for help");
      Help.printHelp();
    }
    else if(args[0].equalsIgnoreCase("-Help"))
    {
      System.out.println("Executing -Help");
      Help.printHelp();
    }
    else if(args[0].equalsIgnoreCase("-HttpRequest"))
    {
      System.out.println("Executing -HttpRequest");

      if(args.length < 2)
      System.out.println("Please enter a valid URL for the second parameter");
      else
      {
        String url = args[1];
        HttpRequest request = new HttpRequest();

        if(request.readURL(url))
        System.out.println(request);
      }
    }
    else if(args[0].equalsIgnoreCase("-HttpRequestIndex"))
    {
      System.out.println("Executing -HttpRequestIndex");
      if(args.length < 2)
      System.out.println("Please enter a valid URL for the second parameter");
      else
      {
        String url = args[1];
        HttpRequestFile request = new HttpRequestFile(url);

        request.readAndParse();
      }
    }
    long endTime = System.nanoTime();
    System.out.println("Time in nano seconds the program has been running: " + (long)(endTime - startTime));
  }
}
