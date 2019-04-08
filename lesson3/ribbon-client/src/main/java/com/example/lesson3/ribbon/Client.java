package com.example.lesson3.ribbon;


import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-04-03
 * Time: 10:39
 */
public class Client {
    public static void main(String[] args) throws Exception{
        System.out.println("hhhhhhh");
        ConfigurationManager.loadPropertiesFromResources("application.properties");//1
        System.out.println(ConfigurationManager.getConfigInstance().getProperty("sample-client.ribbon.listOfServers"));
        RestClient client = (RestClient) ClientFactory.getNamedClient("sample-client");//2
        HttpRequest request = HttpRequest.newBuilder().uri("/provider").build();//3
        for (int i = 0; i < 10; i++)  {
            HttpResponse response = client.executeWithLoadBalancer(request); // 4
            System.out.println("Status code for " + response.getRequestedURI() + "  :" + response.getStatus()+" entity: "+response.getEntity(String.class));
        }
    }
}
