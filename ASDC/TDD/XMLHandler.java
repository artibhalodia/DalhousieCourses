
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class XMLHandler {

    private  SAXParser saxParser;
    private String filename;
    private DataHandler handler;

    public XMLHandler(String filename) throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        this.saxParser = factory.newSAXParser();
        this.filename=filename;
        handler = new DataHandler();
    }

    public void setHandler(DataHandler handler) {
        this.handler = handler;
    }

    public void generateFile(){
        try {
            FileWriter writer = new FileWriter(Instant.now().toEpochMilli()+".txt");
            writer.write(generateResponse());
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String generateResponse(){
        InvalidOutput io = new InvalidOutput();

        if(!validateXML()){

            io.setResult(String.valueOf(IPartManager.PartResponse.FAILURE));
            io.setErrormessage("Invalid File");
            return io.toString();
        }
        if(!isDealerAuthorized(handler.getOrderInput())){

            io.setResult(String.valueOf(IPartManager.PartResponse.FAILURE));
            io.setErrormessage("Not Authorized");
            return io.toString();
        }
        if(!validateDeliveryAddress(handler.getOrderInput())){

            io.setResult(String.valueOf(IPartManager.PartResponse.FAILURE));
            io.setError("Invalid Order");
            io.setErrormessage("Invalid delivery address");
            return io.toString();
        }
        if(!isOrderItemValid(handler.getOrderInput())){

            io.setResult(String.valueOf(IPartManager.PartResponse.FAILURE));
            io.setError("Invalid Order");
            io.setErrormessage("Invalid order item list");
            return io.toString();
        }
        if(!isItemValid(handler.getOrderInput())){

            io.setResult(String.valueOf(IPartManager.PartResponse.FAILURE));
            io.setError("Invalid Order");
            io.setErrormessage("Invalid order item entry");
            return io.toString();
        }
        OrderOutput orderOutput = getOrderOutput(handler.getOrderInput());
        return orderOutput.toString();
    }

    public  boolean isDealerAuthorized(OrderInput input){
        ISecurity security = new Security();
        if(input ==null){
            return false;
        }

        if(input.getDealer()==null){
            return false;
        }
        if(input.getDealer().getDealerId()==null || Objects.equals(input.getDealer().getDealerId(), "")){
            return false;
        }
        if(input.getDealer().getDealerAccessKey()==null || Objects.equals(input.getDealer().getDealerAccessKey(), "")){
            return false;
        }

        return security.IsDealerAuthorized(input.getDealer().getDealerId(),input.getDealer().getDealerAccessKey());
    }

    public boolean validateDeliveryAddress(OrderInput input){
        if(input.getDeliveryAddress()==null){
            return false;
        }
        if(Objects.equals(input.getDeliveryAddress().getName(), "") ||
                input.getDeliveryAddress().getName()==null){
            return false;
        }
        if(Objects.equals(input.getDeliveryAddress().getCity(), "") ||
                input.getDeliveryAddress().getCity()==null){
            return false;
        }
        if(Objects.equals(input.getDeliveryAddress().getPostalCode(), "") ||
                input.getDeliveryAddress().getPostalCode()==null){
            return false;
        }
        if(Objects.equals(input.getDeliveryAddress().getProvince(), "")||
                input.getDeliveryAddress().getProvince()==null){
            return false;
        }
        if(Objects.equals(input.getDeliveryAddress().getStreet(), "")||
                input.getDeliveryAddress().getStreet()==null){
            return false;
        }
        return true;
    }

    public boolean isOrderItemValid(OrderInput input){
        if(input.getOrderItems().getItem().isEmpty()){
            return false;
        }
        return true;
    }

    public boolean isItemValid(OrderInput input){
        for (ItemInput op:
             input.getOrderItems().getItem()) {
            IStock stock = new Stock();
            if(!stock.IsPartNumberValid(op.getPartnumber())){
               return false;
            }
        }
        return true;
    }

    public  boolean validateXML(){
        try {
            saxParser.parse(filename, handler);
            return true;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public OrderOutput getOrderOutput(OrderInput orderInput){
        OrderOutput orderOutput = new OrderOutput();
        orderOutput.setOrderItems(getOrderItemsOutput(orderInput.getOrderItems()));
        return orderOutput;
    }

    private OrderItemsOutput getOrderItemsOutput(OrderItemsInput orderItems) {
        OrderItemsOutput orderItemsOutput = new OrderItemsOutput();
        orderItemsOutput.setItem(getItemOutput(orderItems.getItem()));
        return orderItemsOutput;
    }

    private List<ItemOutput> getItemOutput(List<ItemInput> item) {
        List<ItemOutput> itemOutput = new ArrayList<>();
        IStock stock = new Stock();

        for (ItemInput itemInput: item) {
            ItemOutput op = new ItemOutput();
            op.setPartnumber(itemInput.getPartnumber());
            op.setQuantity(itemInput.getQuantity());

            if(!stock.IsManufacturing(itemInput.getPartnumber())){
                op.setResult(IPartManager.PartResponse.valueOf("FAILURE"));
                op.setErrormessage(String.valueOf(IPartManager.PartResponse.NO_LONGER_MANUFACTURED));
            }
            else if(!stock.IsStockAvailable(itemInput.getPartnumber(), itemInput.getQuantity())){
                op.setResult(IPartManager.PartResponse.valueOf("FAILURE"));
                op.setErrormessage(String.valueOf(IPartManager.PartResponse.OUT_OF_STOCK));
            }
            else{
                op.setResult(IPartManager.PartResponse.valueOf("SUCCESS"));
                op.setErrormessage(String.valueOf(IPartManager.PartResponse.SUCCESS));
            }
            itemOutput.add(op);
        }
        return itemOutput;
    }

}
