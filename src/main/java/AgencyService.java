import java.util.Collection;

public interface AgencyService {

    public Collection<Agency> getAgencies(String site_id, String payment_method_id, Criterio criterioOrden) throws ApiException;


}
