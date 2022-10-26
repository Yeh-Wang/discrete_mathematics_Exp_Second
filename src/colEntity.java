public class colEntity {  //存储集合元素
    private String data;

    public colEntity() {
        data = "";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toString() {
        return String.valueOf(data);
    }
}
