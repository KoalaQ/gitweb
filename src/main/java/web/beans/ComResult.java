package web.beans;

import java.io.Serializable;

public class ComResult implements Serializable {
    public final static String STATUSOK="1";
    public final static String STATUSFAIL="0";

    public final static String RETCODEOK="1";
    public final static String RETCODEERROR="0";

    //交互代码：0-失败，1-成功
    private String retcode;
    //功能处理结果：0-失败，1-成功
    private String retstatus;
    //处理消息
    private String retdata;
    private String retdatasize;

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetstatus() {
        return retstatus;
    }

    public void setRetstatus(String retstatus) {
        this.retstatus = retstatus;
    }

    public String getRetdata() {
        return retdata;
    }

    public void setRetdata(String retdata) {
        this.retdata = retdata;
    }

    public String getRetdatasize() {
        return retdatasize;
    }

    public void setRetdatasize(String retdatasize) {
        this.retdatasize = retdatasize;
    }
}
