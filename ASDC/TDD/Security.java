
import java.util.List;
import java.util.Objects;

public class Security implements ISecurity{

    public boolean IsDealerAuthorized(String dealerid, String dealeraccesskey){

        List<DealerInput> dealerDB = DealerDB.getDealerDB();
        for (DealerInput ip:
             dealerDB) {
            if(Objects.equals(ip.getDealerId(), dealerid) && Objects.equals(ip.getDealerAccessKey(), dealeraccesskey)){
                return true;
            }
        }
        return false;
    }


}
