/**
 * @author :Yeh-Wang
 * @date : 2022/10/27
 */

import java.util.ArrayList;
import java.util.Objects;

public class proFunction {

    /**
     * 根据已知的集合元素初始化相对应的运算表
     *
     * @param col a known collection
     */
    public ArrayList<entityOperation> setList(ArrayList<colEntity> col)
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

    /**
     * 判断集合在运算上的封闭性
     *
     * @param list a table of operations for known sets
     */
    public boolean JudgeClosed(ArrayList<entityOperation> list)
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


    /**
     *
     * @declare 判断所给运算表是否满足结合律
     *
     * @param list a table of operations for known sets
     */
    public boolean JudgeAssociative(ArrayList<entityOperation> list)  //判断是否满足结合律
    {
        boolean flag = true;
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j< list.size();j++)
            {
            }
        }
        return flag;
    }
}