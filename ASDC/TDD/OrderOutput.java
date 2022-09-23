
public class OrderOutput {

    private OrderItemsOutput orderItems;

    public OrderOutput() {
        this.orderItems = new OrderItemsOutput();
    }

    public OrderItemsOutput getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItemsOutput orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<order>\n");
        sb.append("<orderitems>\n");
        for (ItemOutput op : orderItems.getItem() ) {
            sb.append("<item>\n");
            sb.append("<partnumber>"+op.getPartnumber()+"</partnumber>\n");
            sb.append("<quantity>"+op.getQuantity()+"</quantity>\n");
            sb.append("<result>"+op.getResult().toString()+"</result>\n");
            sb.append("<errormessage>"+op.getErrormessage()+"</errormessage>\n");
            sb.append("</item>\n");
        }
        sb.append("</orderitems>\n");
        sb.append("</order>");
        return sb.toString();
    }
}


