/**
 * @author :Yeh-Wang
 * @date : 2022/10/27
 */

import java.util.ArrayList;
import java.util.Objects;

public class proFunction {

    /**
     * @param col a known collection of elements
     * @declare 根据已知的集合元素初始化相对应的运算表
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
     * @param list a table of operations for known sets
     * @declare 判断集合在运算*上的封闭性
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
     * @declare 判断<A, *>代数系统是否满足结合律
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
     * @param list a table of operations for known sets
     * @param col  a collection of elements
     * @declare 判断<A, *>代数系统中是否有幺元
     */
    public String JudgeIE(ArrayList<entityOperation> list, ArrayList<colEntity> col) {
        boolean flag = false;
        String IE = " ";
        for (int i = 0; i < col.size(); i++) {
            int j;
            for (j = 0; j < col.size(); j++) {
                String newData_1 = get_data_By_Pr_Re(list, col.get(i).getData(), col.get(j).getData());
                String newData_2 = get_data_By_Pr_Re(list, col.get(j).getData(), col.get(i).getData());
                if (!Objects.equals(newData_1, newData_2)) {
                    break;
                }
            }
            if (j == col.size()) {
                flag = true;
                IE = col.get(i).getData();
                break;
            }
        }
        return IE;
    }

    /**
     * @param list a table of operations for known sets
     * @param col  a collection of elements
     * @declare 判断<A, *>代数系统中集合A中每个元素是否都有逆元
     */
    public boolean JudgeInverse(ArrayList<entityOperation> list, ArrayList<colEntity> col) {
        boolean flag = false;
        String IE = JudgeIE(list, col);
        for (int i = 0; i < col.size(); i++) {
            int j;
            for (j = 0; j < col.size(); j++) {
                String newData_1 = get_data_By_Pr_Re(list, col.get(i).getData(), col.get(j).getData());
                String newData_2 = get_data_By_Pr_Re(list, col.get(j).getData(), col.get(i).getData());
                if ((Objects.equals(newData_1, IE)) || (Objects.equals(newData_2, IE))) {
                    break;
                }
            }
            if (j != col.size()) {
                flag = true;
                break;
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

    /**
     * @declare 输出运算表
     * @param list a table of operations for known sets
     * @param col a collection of elements
     */
    public void print(ArrayList<entityOperation> list,ArrayList<colEntity> col)
    {
        int k=0;
        for(int i=0;i< col.size();i++)
        {
            for(int j=0;j< col.size();j++)
            {
                System.out.print(list.get(k)+"   ");
                k++;
            }
            System.out.println();
        }
    }
}