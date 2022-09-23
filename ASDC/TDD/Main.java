
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;


public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        testRun();

        OrderItemDB.SeedDB();
        DealerDB.SeedDB();

        XMLHandler xmlHandler = new XMLHandler(args[0]);
        //xmlHandler.generateFile();
        System.out.println(xmlHandler.generateResponse());
    }

    public static void testRun() throws ParserConfigurationException, SAXException {

        SecurityTest.IsDealerAuthorized_True_Test();

        SecurityTest.IsDealerAuthorized_DealerAccessKey_Invalid_Test();
        SecurityTest.IsDealerAuthorized_DealerAccessKey_Null_Test();

        SecurityTest.IsDealerAuthorized_DealerID_Invalid_Test();
        SecurityTest.IsDealerAuthorized_DealerId_Null_Test();

        XMLHandlerTest.validateDeliveryAddress_Invalid_Test();
        XMLHandlerTest.validateDeliveryAddress_Null_Test();
        XMLHandlerTest.validateDeliveryAddress_Valid_Test();

        XMLHandlerTest.IsDealerAuthorized_Dealer_InValid_True_Test();
        XMLHandlerTest.IsDealerAuthorized_Dealer_Null_Test();
        XMLHandlerTest.IsDealerAuthorized_Dealer_Valid_True_Test();

        XMLHandlerTest.IsDealerAuthorized_OrderInput_Null_Test();
        XMLHandlerTest.isOrderItemValid_False_Test();

        StockTest.IsStockAvailable_Not_NegativeQuantity_test();
        StockTest.IsStockAvailable_Not_test();
        StockTest.IsStockAvailable_Yes_test();
        StockTest.IsStockAvailable_Partnumber_Zero_test();

        StockTest.IsPartNumberValid_True_Test();
        StockTest.IsPartNumberValid_False_Test();
        StockTest.IsPartNumberValid_Negative_Test();

        StockTest.IsManufacturing_False_Test();
        StockTest.IsManufacturing_True_Test();

    }
}
