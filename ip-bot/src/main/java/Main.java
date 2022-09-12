import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.*;
import com.cloudmersive.client.IpAddressApi;

public class Main {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");
        Apikey.setApiKey("c7351bd0-d575-4429-b95c-f667e0034bb8");

        IpAddressApi apiInstance = new IpAddressApi();
        String value = "55.55.55.55";
        try {
            BotCheckResponse result = apiInstance.iPAddressIsBot(value);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IpAddressApi#iPAddressPost");
            e.printStackTrace();
        }
    }
}
