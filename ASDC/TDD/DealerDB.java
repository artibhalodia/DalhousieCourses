
import java.util.ArrayList;
import java.util.List;

public class DealerDB {

    private static List<DealerInput> dealerDB;

    public static void SeedDB(){
        dealerDB = new ArrayList<>();
        for(int i=0;i<9;i++){
            DealerInput input = new DealerInput();
            input.setDealerId(String.valueOf(i));
            input.setDealerAccessKey("kkklas8882kk23nllfjj88290"+i);
            dealerDB.add(input);
        }
        DealerInput input = new DealerInput();
        input.setDealerId("XXX-1234-ABCD-1234");
        input.setDealerAccessKey("kkklas8882kk23nllfjj88290");
        dealerDB.add(input);

    }

    public static List<DealerInput> getDealerDB() {
        return dealerDB;
    }

    public static void setDealerDB(List<DealerInput> dealerDB) {
        DealerDB.dealerDB = dealerDB;
    }

}
