/**
 * @author :Yeh-Wang
 * @date : 2022/10/27
 */

import java.util.ArrayList;
import java.util.Scanner;

public class proInterface {
    public ArrayList<colEntity> col = new ArrayList<>();
    public ArrayList<entityOperation> list = new ArrayList<>();
    public proFunction fun = new proFunction();
    public Scanner scanner = new Scanner(System.in);

    public void showPanel() {
        int count = 0;
        while (count < 99) {
            String gather;
//输入集合元素并进行处理--------------------------------------------------------------------------------
            System.out.println("请输入集合元素:(使用”<>“或者”{}“包裹,元素间以半角逗号分隔)");
            gather = scanner.nextLine();
            int k = 1;
            for (int i = 1; i < gather.length(); i = i + 1) {
                colEntity data1 = new colEntity();
                if (gather.charAt(i) == ',' || gather.charAt(i) == '>' || gather.charAt(i) == '}') {
                    data1.setData(gather.substring(k, i));
                    k = i + 1;
                    col.add(data1);
                }
            }
            scanner.reset();
//输入*运算表并进行处理---------------------------------------------------------------------------------
            list = fun.setList(col);
            System.out.println("请输入集合元素:(使用”<>“或者”{}“包裹,元素间以半角逗号分隔)");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                gather = scanner.nextLine();
                list.get(i).setData(gather);
                scanner.reset();
            }

            if(fun.JudgeClosed(list))
            {
                System.out.println("满足封闭性");
                if(fun.JudgeAssociative(list,col)){
                    System.out.println("满足结合律");
                    if(fun.JudgeIE(list,col)){
                        System.out.println("存在幺元");
                    } else {
                        System.out.println("不存在幺元");
                    }
                }else {
                    System.out.println("不满足结合律");
                }
            } else {
                System.out.println("不满足封闭性");
            }

            list.clear();
            col.clear();
            count++;
        }
    }
}
