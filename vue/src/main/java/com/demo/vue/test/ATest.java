package com.demo.vue.test;



import org.antlr.runtime.ANTLRInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: lxw
 * @date: 2022-12-30  15:24
 */
public class ATest {
    public static void main(String[] args) throws IOException {

    /*    ANTLRInputStream in = new ANTLRInputStream("d");
        JsonLexer lexer = new JsonLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JsonParser exprParser = new JsonParser(tokens);
        ExprContext exprContext = exprParser.expr();
        System.out.println(exprContext.getText());
        List<Bracket_bodyContext> list = exprContext.bracket_body();
*/
        // String a = "(((1&&0)||1)||0)&&1&&(1||0)";
        //String a ="0&&1||0&&1||0&&1";
        String a ="1&&0&&1&&1||0||1&&1||0&&0";
        String s = a.replace("&&", "+").replace("||", "-");
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length() ; i++){
            String ss = String.valueOf(s.charAt(i));
            list.add(ss);
        }
        if (a.contains("(")||a.contains(")")) {
            //包含括号
            int ji=0;
            for (int i = 0; i < list.size(); i++) {
                if("(".equals(list.get(i))){

                }
                if (list.get(i).matches("^[0-9]*$")) {

                }
            }

        }else{
            List<Integer> list1 = list.stream().filter(e1 -> e1.matches("^[0-9]*$")).map(e2->Integer.valueOf(e2)).collect(Collectors.toList());
            List<String> list2 = list.stream().filter(e1 -> !e1.matches("^[0-9]*$")).collect(Collectors.toList());
            int result = 0;
            for (int i = 0; i < list2.size(); i++) {
                if(i==0){
                    result =list1.get(i)+list1.get(i+1);
                }else{
                    result = result+list1.get(i+1);
                }

                if ("+".equals(list2.get(i))) {
                    if (result ==2 ) {
                        result =1;
                    }else {
                        result=0;
                    }
                }else {
                    if (result>0) {
                        result=1;
                    }else{
                        result=0;
                    }
                }


            }

            System.out.println(result);




        }
            }
}
