
import java.util.List;
import java.util.Objects;

public class Stock implements IStock{


    @Override
    public boolean IsStockAvailable(int partNumber, int quantity) {
        if(quantity<=0){
            return false;
        }
        if(partNumber<=0){
            return false;
        }
        List<ItemInput> orderItemDb = OrderItemDB.getOrderItemDb();
        for ( ItemInput ip:
                orderItemDb) {
            if(Objects.equals(ip.getPartnumber(), partNumber) && ip.getQuantity() > quantity){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean IsPartNumberValid(int partNumber) {
        List<ItemInput> orderItemDb = OrderItemDB.getOrderItemDb();
        for ( ItemInput ip:
                orderItemDb) {
            if(Objects.equals(ip.getPartnumber(), partNumber)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean IsManufacturing(int partNumber) {
        List<ItemInput> orderItemDb = OrderItemDB.getOrderItemDb();
        for ( ItemInput ip:
                orderItemDb) {
            if(Objects.equals(ip.getPartnumber(), partNumber) && ip.getQuantity()>=0){
                return true;
            }
        }
        return false;
    }

}
