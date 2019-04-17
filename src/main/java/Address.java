public class Address implements Comparable<Address>{

    private String addres_line;
    private String city;
    private String country;
    private String location;
    private String other_info;
    private String State;
    private String zip_code;

    public Address() {
    }

    public Address(String addres_line, String city, String country, String location, String other_info, String state, String zip_code) {
        this.addres_line = addres_line;
        this.city = city;
        this.country = country;
        this.location = location;
        this.other_info = other_info;
        State = state;
        this.zip_code = zip_code;
    }

    public String getAddres_line() {
        return addres_line;
    }

    public void setAddres_line(String addres_line) {
        this.addres_line = addres_line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOther_info() {
        return other_info;
    }

    public void setOther_info(String other_info) {
        this.other_info = other_info;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addres_line='" + addres_line + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", location='" + location + '\'' +
                ", other_info='" + other_info + '\'' +
                ", State='" + State + '\'' +
                ", zip_code='" + zip_code + '\'' +
                '}';
    }

    @Override
    public int compareTo(Address o) {
        return addres_line.compareToIgnoreCase(o.getAddres_line());
    }
}
