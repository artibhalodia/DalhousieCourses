
public class StockTest {
    private static Stock st;
    public static void setup(){
        st = new Stock();
        DealerDB.SeedDB();
        OrderItemDB.SeedDB();
    }
    public static void IsStockAvailable_Partnumber_Zero_test() {
        setup();
        if(st.IsStockAvailable(0,10)){
            System.out.println("FAIL - StockAvailable Part number Zero test");
        }
        else{
            System.out.println("PASS - StockAvailable Part number Zero test");
        }
    }

    public static void IsStockAvailable_Not_test() {
        setup();
        if(st.IsStockAvailable(1,500)){
            System.out.println("FAIL - StockAvailable Not test");
        }
        else{
            System.out.println("PASS - StockAvailable Not test");
        }
    }

    public static void IsStockAvailable_Not_NegativeQuantity_test() {
        setup();
        if(st.IsStockAvailable(1,-500)){
            System.out.println("FAIL - StockAvailable Not NegativeQuantity test");
        }
        else{
            System.out.println("PASS - StockAvailable Not NegativeQuantity test");
        }
    }

    public static void IsStockAvailable_Yes_test() {
        setup();
        if(!st.IsStockAvailable(1,10)){
            System.out.println("FAIL - StockAvailable Yes test");
        }
        else{
            System.out.println("PASS - StockAvailable Yes test");
        }
    }

    public static void IsPartNumberValid_True_Test(){
        setup();
        if(!st.IsPartNumberValid(4)){
            System.out.println("FAIL - PartNumberValid Yes test");
        }
        else{
            System.out.println("PASS - PartNumberValid Yes test");
        }
    }

    public static void IsPartNumberValid_False_Test(){
        setup();
        if(st.IsPartNumberValid(300)){
            System.out.println("FAIL - PartNumberValid False test");
        }
        else{
            System.out.println("PASS - PartNumberValid False test");
        }
    }

    public static void IsPartNumberValid_Negative_Test(){
        setup();
        if(st.IsPartNumberValid(-4)){
            System.out.println("FAIL - PartNumberValid Negative Partnumber test");
        }
        else{
            System.out.println("PASS - PartNumberValid Negative Partnumber test");
        }
    }

    public static void IsManufacturing_True_Test(){
        setup();
        if(!st.IsManufacturing(3)){
            System.out.println("FAIL - IsManufacturing True test");
        }
        else{
            System.out.println("PASS - IsManufacturing True test");
        }
    }

    public static void IsManufacturing_False_Test(){
        setup();
        if(st.IsManufacturing(-10)){
            System.out.println("FAIL - IsManufacturing False test");
        }
        else{
            System.out.println("PASS - IsManufacturing False test");
        }
    }


}
