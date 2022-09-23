
public class SecurityTest {

    private static Security security;

    public static void setup(){
        security = new Security();
        DealerDB.SeedDB();
    }

    public static void IsDealerAuthorized_DealerId_Null_Test(){
        setup();
        if(security.IsDealerAuthorized(null,"0mkms")==true){
            System.out.println("FAIL - IsDealerAuthorized DealerId Null Test");
        }
        else{
            System.out.println("PASS - IsDealerAuthorized DealerId Null Test");
        }
    }

    public static void IsDealerAuthorized_DealerAccessKey_Null_Test(){
        setup();
        if(security.IsDealerAuthorized("4",null)==true){
            System.out.println("FAIL - IsDealerAuthorized DealerAccessKey Null Test");
        }
        else{
            System.out.println("PASS - IsDealerAuthorized DealerAccessKey Null Test");
        }
    }

    public static void IsDealerAuthorized_True_Test(){
        setup();
        if(security.IsDealerAuthorized("XXX-1234-ABCD-1234","kkklas8882kk23nllfjj88290")==false){
            System.out.println("FAIL - IsDealerAuthorized True Test");
        }
        else{
            System.out.println("PASS - IsDealerAuthorized True Test");
        }
    }

    public static void IsDealerAuthorized_DealerID_Invalid_Test(){
        setup();
        if(security.IsDealerAuthorized("XXX-1","kkklas8882kk23nllfjj88290")==true){
            System.out.println("FAIL - IsDealerAuthorized DealerID Invalid Test");
        }
        else{
            System.out.println("PASS - IsDealerAuthorized DealerID Invalid Test");
        }
    }

    public static void IsDealerAuthorized_DealerAccessKey_Invalid_Test(){
        setup();
        if(security.IsDealerAuthorized("XXX-1234-ABCD-1234","2kk23nllfjj88290")==true){
            System.out.println("FAIL - IsDealerAuthorized DealerAccessKey Invalid Test");
        }
        else{
            System.out.println("PASS - IsDealerAuthorized DealerAccessKey Invalid Test");
        }
    }
}
