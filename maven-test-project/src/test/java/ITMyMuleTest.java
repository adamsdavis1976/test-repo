
import junit.framework.Assert;

import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class ITMyMuleTest extends FunctionalTestCase
{
    @Override
    protected String getConfigResources()
    {
      return "maven-test-project.xml";
    }
 
    @Test
    public void testValidJob() throws Exception
    {
      MuleClient client = new MuleClient(muleContext);
      MuleMessage result = client.send("http://localhost:8085/test", "", null);
      
     
      //final String value = muleContext.getRegistry().get("http.port");
      //System.out.println("env port\n " +muleContext.getRegistry().toString());
      Assert.assertEquals(result.getPayloadAsString().startsWith("Hello World"), true);
 
      //comment
     
    }
    
}
 