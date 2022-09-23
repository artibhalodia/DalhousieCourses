
import java.util.ArrayList;
import java.util.List;

public class OrderItemDB {

    private static List<ItemInput> orderItemDb;

    public static void SeedDB(){
        orderItemDb = new ArrayList<>();
        for(int i=0;i<9;i++){
            ItemInput input = new ItemInput();
            input.setPartnumber(i);
            input.setQuantity(20);
            orderItemDb.add(input);
        }
    }

    public static List<ItemInput> getOrderItemDb() {
        return orderItemDb;
    }

    public static void setOrderItemDb(List<ItemInput> orderItemDb) {
        OrderItemDB.orderItemDb = orderItemDb;
    }

}


