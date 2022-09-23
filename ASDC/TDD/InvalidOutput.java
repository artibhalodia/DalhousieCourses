
public class InvalidOutput {
    private String result;
    private String error;
    private String errormessage;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<order>\n");
        sb.append("<result>"+result+"</result>\n");
        if(errormessage.length()>0){
            sb.append("<errormessage>"+errormessage+"</errormessage>\n");

        }
        sb.append("</order>");

        return sb.toString();
    }
}



