
public interface IStock {

    // Returns whether the dealer is authorized to order parts on behalf of their customers.
    public boolean IsStockAvailable(int partnumber, int quantity);
    public boolean IsPartNumberValid(int partnumber);

    boolean IsManufacturing(int partNumber);
}
