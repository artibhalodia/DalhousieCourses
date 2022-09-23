
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class XMLHandlerTest {
    private static XMLHandler xmlHandler;
    private static OrderInput oi;
    private static OrderItemsInput oii;

    public static void setup() throws ParserConfigurationException, SAXException {
        xmlHandler = new XMLHandler("");
        DealerDB.SeedDB();
        OrderItemDB.SeedDB();
        DataHandler dh = new DataHandler();

        oi = new OrderInput();
        DealerInput di = new DealerInput();
        di.setDealerId(DealerDB.getDealerDB().get(0).getDealerId());
        di.setDealerAccessKey(DealerDB.getDealerDB().get(0).getDealerAccessKey());
        oi.setDealer(di);

        oii = new OrderItemsInput();
        oii.setItem(OrderItemDB.getOrderItemDb());
        oi.setOrderItems(oii);

        DeliveryAddressInput dai = new DeliveryAddressInput();
        dai.setName("abc");
        dai.setProvince("Halifax");
        dai.setCity("fas");
        dai.setPostalCode("123-456");
        dai.setStreet("fdf4 4324");
        oi.setDeliveryAddress(dai);

        dh.setOrderInput(oi);
        xmlHandler.setHandler(dh);
    }

    public static void IsDealerAuthorized_Dealer_Null_Test() throws ParserConfigurationException, SAXException {
        setup();
        oi.setDealer(null);
        if(xmlHandler.isDealerAuthorized(oi)){
            System.out.println("FAIL - IsDealerAuthorized Dealer Null Test ");
        }
        else{
            System.out.println("PASS - IsDealerAuthorized Dealer Null Test ");
        }
    }

    public static void IsDealerAuthorized_OrderInput_Null_Test() throws ParserConfigurationException, SAXException {
        setup();

        if(xmlHandler.isDealerAuthorized(null)){
            System.out.println("FAIL - IsDealerAuthorized Dealer OrderInput Test ");
        }
        else{
            System.out.println("PASS - IsDealerAuthorized Dealer OrderInput Test ");
        }
    }

    public static void IsDealerAuthorized_Dealer_Valid_True_Test() throws ParserConfigurationException, SAXException {
        setup();
        if(!xmlHandler.isDealerAuthorized(oi)){
            System.out.println("FAIL - IsDealerAuthorized Dealer Valid True Test ");
        }
        else{
            System.out.println("PASS - IsDealerAuthorized Dealer Valid True Test ");
        }
    }

    public static void IsDealerAuthorized_Dealer_InValid_True_Test() throws ParserConfigurationException, SAXException {
        setup();
        oi.getDealer().setDealerId("abc");
        if(xmlHandler.isDealerAuthorized(oi)){
            System.out.println("FAIL - IsDealerAuthorized Dealer InValid True Test ");
        }
        else{
            System.out.println("PASS - IsDealerAuthorized Dealer InValid True Test ");
        }
    }

    // Delivery Address Check

    public static void validateDeliveryAddress_Null_Test() throws ParserConfigurationException, SAXException {
        setup();
        oi.setDeliveryAddress(null);
        if(xmlHandler.validateDeliveryAddress(oi)){
            System.out.println("FAIL - DeliveryAddress Null Test ");
        }
        else{
            System.out.println("PASS - DeliveryAddress Null Test ");
        }
    }

    public static void validateDeliveryAddress_Invalid_Test() throws ParserConfigurationException, SAXException {
        setup();
        oi.getDeliveryAddress().setStreet(null);
        if(xmlHandler.validateDeliveryAddress(oi)){
            System.out.println("FAIL - DeliveryAddress Invalid  Test");
        }
        else{
            System.out.println("PASS - DeliveryAddress Invalid Test ");
        }
    }

    public static void validateDeliveryAddress_Valid_Test() throws ParserConfigurationException, SAXException {
        setup();
        if(!xmlHandler.validateDeliveryAddress(oi)){
            System.out.println("FAIL - DeliveryAddress Valid Test ");
        }
        else{
            System.out.println("PASS - DeliveryAddress Valid Test ");
        }
    }

    public static void isOrderItemValid_False_Test() throws ParserConfigurationException, SAXException {
        setup();

        if(!xmlHandler.isOrderItemValid(oi)){
            System.out.println("FAIL - isOrderItemValid False Test ");
        }
        else{
            System.out.println("PASS - isOrderItemValid False Test ");
        }
    }

}
