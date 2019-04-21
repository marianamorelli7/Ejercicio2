import com.google.gson.Gson;

import static spark.Spark.*;


public class ApiRest {

    public static void main(String[] args) {

        port(8080);

        final AgencyService agencyService = new AgencyServiceMapImpl();

        get("/agency", (request, response) -> {
            response.type("application/json");
            String site_id = request.queryParams("site_id");
            String payment_methods = request.queryParams("payment_methods");
            String criterioIn = request.queryParams("criterioOrden");
            MyLog.logInfo(request.url() + "?" + request.raw().getQueryString());

            Criterio criterioOrden = Criterio.AGENCY_CODE;

            switch (criterioIn) {
                case "address_line":
                    criterioOrden = Criterio.ADDRESS_LINE;
                    break;
                case "distance":
                    criterioOrden = Criterio.DISTANCE;
                    break;
                case "agency_code":
                default: criterioOrden = Criterio.AGENCY_CODE;
            }
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(agencyService.getAgencies(site_id,payment_methods,criterioOrden)
                )));
        });

    }

}
