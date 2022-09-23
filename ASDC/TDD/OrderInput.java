
public class OrderInput {

    DealerInput dealer;
    OrderItemsInput orderItems;
    DeliveryAddressInput deliveryAddress;

    public OrderInput() {
        this.dealer = new DealerInput();
        this.orderItems = new OrderItemsInput();
        this.deliveryAddress = new DeliveryAddressInput();
    }

    public DealerInput getDealer() {
        return dealer;
    }

    public void setDealer(DealerInput dealer) {
        this.dealer = dealer;
    }

    public OrderItemsInput getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItemsInput orderItems) {
        this.orderItems = orderItems;
    }

    public DeliveryAddressInput getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressInput deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
