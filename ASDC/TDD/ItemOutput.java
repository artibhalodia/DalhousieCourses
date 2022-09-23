
public class ItemOutput {
    private int partnumber;
    private int quantity;
    private IPartManager.PartResponse result;
    private String errormessage;

    public int getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(int partnumber) {
        this.partnumber = partnumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public IPartManager.PartResponse getResult() {
        return result;
    }

    public void setResult(IPartManager.PartResponse result) {
        this.result = result;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
