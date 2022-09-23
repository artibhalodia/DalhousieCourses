
public interface IPartManager
{
    public enum PartResponse
    {
        SUCCESS,
        OUT_OF_STOCK,
        NO_LONGER_MANUFACTURED,
        FAILURE
    }
    // Submit part for manufacture and delivery.
    public PartResponse SubmitPartForManufactureAndDelivery(
            int partNumber,
            int quantity,
            DeliveryAddressInput deliveryAddress);
}
