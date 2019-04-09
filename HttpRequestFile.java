import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class HttpRequestFile extends HttpRequest
{
  private String fileName;
  private File f;
  private ArrayList<String> urlList;

  public HttpRequestFile(String fileName)
  {
    this.fileName = fileName;
    urlList = new ArrayList<String>();
  }
  public void readAndParse()
  {
    readURL(fileName);
    for(String s : urlContent)
    {
      httpRequestIndex(s);
      processURLS();
    }
  }

  public void httpRequestIndex(String line)
  {
    String[] splitList = line.split("\"");

    if (splitList.length > 9)
    {
      if (splitList[9].equals("ContactURL"))
      {
        urlList.add(splitList[11]);
        System.out.println("URL: "+splitList[11]);
      }
}
  }
  public boolean processURLS()
  {
    boolean value = true;

    for(String s : urlList)
    {
      HttpRequest request = new HttpRequest(s);
      if(request.readURL())
      {
        System.out.println(request);
      }else
      {
        value = false;
      }
    }
    return value;
  }
  private String findDataAssociatedWithKey(String data, String key) {
    int firstIndex = data.indexOf(key);
    if (firstIndex < 0) {
        return null;
    }

    String s = data.substring(firstIndex + key.length());
    int closingQuoteIndex = s.indexOf("\"");

    if (closingQuoteIndex > -1) {
        s = s.substring(0,closingQuoteIndex);
    }

    return s;
}

  @Override
  public String toString()
  {
    String value = "URLs in: \""+fileName+"\"\n";
    for (String s : urlList)
    {
      value = value + s + "\n";
    }
    return value;
  }
}
