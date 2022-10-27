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
    public ArrayList<entityOperation> setList(ArrayList<colEntity> col) {
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
            list.get(i).setSu(col.get(j).getData());
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
    public boolean JudgeClosed(ArrayList<entityOperation> list) {
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
     * @param list a table of operations for known sets
     * @param col  a collection of elements
     * @declare 判断所给运算表是否满足结合律
     */
    public boolean JudgeAssociative(ArrayList<entityOperation> list, ArrayList<colEntity> col) {
        boolean flag = true;
        for (int i = 0; i < col.size(); i++) {
            for (int j = 0; j < col.size(); j++) {
                for (int k = 0; k < col.size(); k++) {
                    String newData_1 = get_data_By_Pr_Re(list, col.get(i).getData(), col.get(j).getData());
                    String newData_2 = get_data_By_Pr_Re(list, col.get(j).getData(), col.get(k).getData());
                    if (!Objects.equals(get_data_By_Pr_Re(list, newData_1, col.get(k).getData()), get_data_By_Pr_Re(list, col.get(i).getData(), newData_2))) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    /**
     *
     * @declare 判断所给运算表是否有幺元
     *
     * @param list a table of operations for known sets
     * @param col  a collection of elements
     */
    public boolean JudgeIE(ArrayList<entityOperation> list, ArrayList<colEntity> col) {
        boolean flag = true;
        for (int i = 0; i < col.size(); i++) {
            for (int j = 0; j < col.size(); j++) {
                String newData_1 = get_data_By_Pr_Re(list, col.get(i).getData(), col.get(j).getData());
                String newData_2 = get_data_By_Pr_Re(list, col.get(j).getData(), col.get(i).getData());
                if(!Objects.equals(newData_1, newData_2))
                {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * 根据前驱后继元素在运算表中寻找相对应的结果
     *
     * @param list a table of operations for known sets
     * @param pr   precursor element
     * @param su   successor element
     */
    public String get_data_By_Pr_Re(ArrayList<entityOperation> list, String pr, String su) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getPr(), pr) && Objects.equals(list.get(i).getSu(), su))
                break;
        }
        return list.get(i).getData();
    }
}