import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class DataHandler extends DefaultHandler {

    private StringBuilder currentValue = new StringBuilder();

    public void setOrderInput(OrderInput orderInput) {
        this.orderInput = orderInput;
    }

    public OrderInput getOrderInput() {
        return orderInput;
    }

    private OrderInput orderInput;
    private ItemInput item;
    private List<ItemInput> itemList;

    @Override
    public void startDocument() {
       orderInput = new OrderInput();
    }

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes) {

        // reset the tag value
        currentValue.setLength(0);

        // start of loop
        if (qName.equalsIgnoreCase("orderitems")) {
            itemList = new ArrayList<>();
        }

        if (qName.equalsIgnoreCase("item")) {
            item = new ItemInput();
        }
    }

    public void endElement(String uri,
                           String localName,
                           String qName) {

        if (qName.equalsIgnoreCase("dealerid")) {
            orderInput.getDealer().setDealerId(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("dealeraccesskey")) {
            orderInput.getDealer().setDealerAccessKey(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("name")) {
            orderInput.getDeliveryAddress().setName(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("street")) {
            orderInput.getDeliveryAddress().setStreet(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("city")) {
            orderInput.getDeliveryAddress().setCity(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("province")) {
            orderInput.getDeliveryAddress().setProvince(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("postalcode")) {
            orderInput.getDeliveryAddress().setPostalCode(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("partnumber")) {
            item.setPartnumber(Integer.parseInt(currentValue.toString()));
        }

        if (qName.equalsIgnoreCase("quantity")) {
            item.setQuantity(Integer.parseInt(currentValue.toString()));
        }

        if (qName.equalsIgnoreCase("item")) {
            itemList.add(item);
        }

        if (qName.equalsIgnoreCase("orderitems")) {
            orderInput.getOrderItems().setItem(itemList);
        }
    }

    public void characters(char ch[], int start, int length) {
        currentValue.append(ch, start, length);

    }

}
