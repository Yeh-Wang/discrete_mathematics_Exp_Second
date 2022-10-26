public class entityOperation {  //创建实体存储序偶集(relation)
    private String pr;
    private String data;
    private String re;
    public entityOperation() {pr="";data="";re="";}

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

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }

    public String toString()
    {
        return pr + " * " + re + " = " + data;
    }
}
