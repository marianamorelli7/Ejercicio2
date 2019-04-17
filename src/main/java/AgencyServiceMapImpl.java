import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jdk.nashorn.internal.runtime.ListAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class AgencyServiceMapImpl implements AgencyService {

    private List<Agency> agencyMap;

    public AgencyServiceMapImpl() {
        this.agencyMap = new ArrayList<Agency>();
    }

    @Override
    public Collection<Agency> getAgencies(String site_id, String payment_methods, Criterio criterioOrden) throws ApiException{

        String url = "https://api.mercadolibre.com/sites/"+site_id+"/payment_methods/"+payment_methods+"/agencies";
        try {
            String data = readUrl(url);
            JsonObject jsonObject = new Gson().fromJson(data, JsonElement.class).getAsJsonObject();
            Agency.criterioOrden = criterioOrden;
            Agency[] agencies = new Gson().fromJson(jsonObject.get("results"), Agency[].class);
            for(Agency agency : agencies){
                agencyMap.add(agency);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        order(agencyMap);
        return agencyMap;
    }

    private static <T extends Comparable<T>> Collection<T> order(List<T> agencies){
         Collections.sort(agencies);
        return agencies;
    }
    private String readUrl(String urlString) throws IOException {

        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Accept","application/json");
            connection.setRequestProperty("User-Agent","Mozilla/5.0");
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            int read = 0;
            StringBuffer buffer = new StringBuffer();
            char[] chars = new char[1024];
            while((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            return buffer.toString();
        }
        finally {
            if(reader != null){
                reader.close();
            }
        }
    }
}
