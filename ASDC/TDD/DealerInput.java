
public class DealerInput {
    private String dealerId;
    private String dealerAccessKey;

    public DealerInput(){
        dealerId = null;
    }
    public String getDealerId()
    {
        return dealerId;
    }

    public void setDealerId(String dealerId)
    {
        this.dealerId = dealerId;
    }

    public String getDealerAccessKey()
    {
        return dealerAccessKey;
    }

    public void setDealerAccessKey(String dealerAccessKey)
    {
        this.dealerAccessKey = dealerAccessKey;
    }



}
