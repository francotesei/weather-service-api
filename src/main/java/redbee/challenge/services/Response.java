package redbee.challenge.services;

import java.util.ArrayList;

/**
 * Created by ftesei on 14/07/17.
 */

public class Response {

     public enum ResponseStatus{
        OK,ERROR,WARNINIG
    }


    private Object result;
    private ResponseStatus status;

    public Response(Object obj,ResponseStatus status){
        setResult(obj);
        setStatus(status);
    }
    public Response(){}

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
