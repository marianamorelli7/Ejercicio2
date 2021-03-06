public class Agency implements Comparable<Agency> {

    private String agency_code;
    private String correspondent_id;
    private String description;
    private boolean disabled;
    private Double distance;
    private String id;
    private String payment_method_id;
    private String phone;
    private String site_id;
    private boolean terminal;
    private Address address;
    public static Criterio criterioOrden;
    public Agency() {
    }

    public Agency(String agency_code, String correspondent_id, String description, boolean disabled, Double distance, String id, String payment_method_id, String phone, String site_id, boolean terminal, Address address, Criterio criterioOrden) {
        this.agency_code = agency_code;
        this.correspondent_id = correspondent_id;
        this.description = description;
        this.disabled = disabled;
        this.distance = distance;
        this.id = id;
        this.payment_method_id = payment_method_id;
        this.phone = phone;
        this.site_id = site_id;
        this.terminal = terminal;
        this.address = address;
        this.criterioOrden = criterioOrden;
    }

    public String getAgency_code() {
        return agency_code;
    }

    public void setAgency_code(String agency_code) {
        this.agency_code = agency_code;
    }

    public String getCorrespondent_id() {
        return correspondent_id;
    }

    public void setCorrespondent_id(String correspondent_id) {
        this.correspondent_id = correspondent_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public boolean getTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int compareTo(Agency o) {
        int respuesta = 0;

        switch (this.criterioOrden)
        {
            case ADDRESS_LINE:
                respuesta = this.address.compareTo(o.address);
                break;
            case DISTANCE:
                respuesta = distance.compareTo(o.distance);
                break;
            case AGENCY_CODE:
                respuesta = agency_code.compareTo(o.agency_code);
                break;
        }
        return respuesta;
    }
}
