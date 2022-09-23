
public class PartManager {
    public IPartManager.PartResponse SubmitPartForManufactureAndDelivery(
            int partNumber,
            int quantity,
            DeliveryAddressInput deliveryAddress){
        return deliveryAddress.SubmitPartForManufactureAndDelivery(partNumber,quantity,this);
    }
}
