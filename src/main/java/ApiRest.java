import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.port;

public class ApiRest {

    public static void main(String[] args) {

        port(8080);

        final AgencyService agencyService = new AgencyServiceMapImpl();
        get("/agency", (request, response) -> {
            response.type("application/json");
            String site_id = request.queryParams("site_id");
            String payment_methods = request.queryParams("payment_methods");
            String criterioIngreso = request.queryParams("criterioOrden");
            Criterio criterio = Criterio.AGENCY_CODE;

            switch (criterioIngreso){
                case "address_line":
                    criterio = Criterio.ADDRESS;
                    break;
                case "distance":
                    criterio = Criterio.DISTANCE;
                    break;
                case "agency_code":
                    criterio = Criterio.AGENCY_CODE;
                    break;
            }
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(agencyService.getAgencies(site_id,payment_methods,criterio)
                )));
        });

    }

}
