import java.util.ArrayList;
import java.util.Objects;

public class proFunction {

    public ArrayList<entityOperation> setList(ArrayList<colEntity> col)   //根据输入的元素集合初始化运算表
    {
        ArrayList<entityOperation> list = new ArrayList<>();
        for (int i = 0; i < col.size(); i++) {
            for (int j = 0; j < col.size(); j++) {
                entityOperation cat = new entityOperation();
                cat.setPr(col.get(i).getData());
                list.add(cat);
            }
        }
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setRe(col.get(j).getData());
            j++;
            if (j == col.size())
                j = 0;
        }
        return list;
    }

    public boolean JudgeClosed(ArrayList<entityOperation> list)  //判断集合在运算上的封闭性
    {
        boolean flag = true;
        for (int i = 0; i < list.size(); i++) {
            int j;
            for (j = 0; j < list.size(); j++) {
                if (Objects.equals(list.get(i).getData(), list.get(j).getPr()))
                    break;
            }
            if (j == list.size()) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean JudgeAssociative(ArrayList<entityOperation> list)  //判断是否满足结合律
    {
        boolean flag = true;
        return flag;
    }
}