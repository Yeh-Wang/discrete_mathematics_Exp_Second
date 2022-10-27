/**
 * @author :Yeh-Wang
 * @date : 2022/10/27
 */

public class entityOperation {  //创建实体存储序偶集(relation)
    private String pr;
    private String data;
    private String su;
    public entityOperation() {pr="";data="";
        su ="";}

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSu() {
        return su;
    }

    public void setSu(String su) {
        this.su = su;
    }

    public String toString()
    {
        return pr + " * " + su + " = " + data;
    }
}
