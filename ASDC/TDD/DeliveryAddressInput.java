
public class DeliveryAddressInput {
    public String name;
    public String street;
    public String city;
    public String province;
    public String postalCode;

    public DeliveryAddressInput(){
        name=null;
        street=null;
        city=null;
        province=null;
        postalCode=null;
    }

    public String getName(){
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getStreet(){
        return street;
    }
    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getProvince(){
        return province;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getPostalCode(){
        return postalCode;
    }
    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public IPartManager.PartResponse SubmitPartForManufactureAndDelivery(int partNumber, int quantity, PartManager partManager) {
        return partManager.SubmitPartForManufactureAndDelivery(partNumber,quantity,this);
    }
}
