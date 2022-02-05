import java.net.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
  
public class JSONReadExample 
{
    public static void main(String[] args) throws Exception 
    {
       
       URL url = new URL(“The required URL”);
       HttpURLConnection conn = (HttpURLConnection)url.openConnection();
       conn.setRequestMethod(“GET”);
       conn.connect();
       int responsecode = conn.getResponseCode();
       if(responsecode != 200)
	throw new RuntimeException(“HttpResponseCode: “ +responsecode);
       else{
	Scanner sc = new Scanner(url.openStream());
	while(sc.hasNext())
	{
		inline+=sc.nextLine();
	}
	System.out.println(“\nJSON data in string format”);
	System.out.println(inline);
	sc.close();
       }
       int total = 0; 
        JSONParser parse = new JSONParser();
        
        // JSON Input

        JSONObject jo = (JSONObject)parse.parse(inline);
        JSONArray ja = (JSONArray) jo.get("order_items");
          
        Iterator itr2 = ja.iterator();
          
        while (itr2.hasNext()) 
        {
            String name = ja.get("name");
            int qty = jo.get("quantity");
            int price = jo.get("price");
            
            total += (qty * price);
        }
          
        int distance = jo.get("distance");
       
        JSONObject offer = (JSONObject) obj.get("offer");

        String offer_type = offer.get("offer_type");
        int value = offer.get("offer_val");

        if(offer_type == "FLAT"){
	if((distance/1000) > 0 && (distance/1000) <= 10)
		total += 5000;

	if((distance/1000) > 10 && (distance/1000) <= 20)
		total += 10000;

	if((distance/1000) > 20 && (distance/1000) <= 50)
		total += 50000;
	
	if((distance/1000) > 50)
		total += 100000;
                  total -= value;
        }
       if(offer_type == "DELIVERY"){
	continue;
       }
      
      // JSON Response
       JSONObject out = new JSONObject();
       jo.put("order_total", total);
       obj.toString();
        

    }
}