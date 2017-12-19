package com.xugc.demo;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.*;

public class aviator {

    public static void main(String[] args) {

        //执行表达式
        System.out.println(AviatorEvaluator.exec("1+2+3"));
        System.out.println(AviatorEvaluator.exec("'hello ' + yourName", "xgc"));
        System.out.println(AviatorEvaluator.execute("string.length('hello')"));
        System.out.println(AviatorEvaluator.execute("string.contains(\"test\",string.substring('hello',1,2))"));

        //自定义函数
        AviatorEvaluator.addFunction(new AddFunction());
        System.out.println(AviatorEvaluator.execute("add(1,2)"));
        System.out.println(AviatorEvaluator.execute("add(add(1,2),100)"));

        String expression = "a-(b-c)>100";
        //编译表达式
        Expression compiledExp = AviatorEvaluator.compile(expression, true);
        Map<String, Object> env = new HashMap<>();
        env.put("a", 100.3);
        env.put("b", 45);
        env.put("c", -199.100);
        //执行表达式
        Boolean result = (Boolean) compiledExp.execute(env);
        System.out.println(result);

        //访问数组和集合
        final List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        final int[] array = new int[3];
        array[0] = 0;
        array[1] = 1;
        array[2] = 3;
        final Map<String, Date> map = new HashMap<>();
        map.put("date", new Date());
        env = new HashMap<>();
        env.put("list", list);
        env.put("array", array);
        env.put("mmap", map);

        System.out.println(AviatorEvaluator.execute("list[0]+' '+list[1]", env));
        System.out.println(AviatorEvaluator.execute("array[0]+array[1]+array[2]", env));
        System.out.println(AviatorEvaluator.execute("mmap.date", env));

        //三元操作符
        System.out.println(AviatorEvaluator.exec("a>0? 'yes' : 'no'", 1));
        System.out.println(AviatorEvaluator.exec("a>0? 'yes' : 'no'", 0));

        //正则表达式
        env = new HashMap<>();
        env.put("email", "killme2008@gmail.com");
        String username = (String) AviatorEvaluator.execute("email=~/([\\w0-8]+)@\\w+[\\.\\w+]+/ ? $1 : 'unknow' ", env);
        System.out.println(username);

        env.put("email", "killme2008+@gmail.com");
        username = (String) AviatorEvaluator.execute("email=~/([\\w0-8]+)@\\w+[\\.\\w+]+/ ? $1 : 'unknow' ", env);
        System.out.println(username);

        //变量
        Pos pos = new Pos(11, 22);
        env = new HashMap<>();
        env.put("pos", pos);
        System.out.println(AviatorEvaluator.execute("'pos.x = '+pos.x", env));

        //内置函数
        System.out.println(AviatorEvaluator.execute("sysdate()"));
        System.out.println(AviatorEvaluator.execute("rand()"));
        System.out.println(AviatorEvaluator.execute("now()"));
        System.out.println(AviatorEvaluator.exec("long(x)", 1.1));
        System.out.println(AviatorEvaluator.exec("double(x)", 1));
        System.out.println(AviatorEvaluator.exec("date_to_string(date,'yyyy-MM-dd HH:mm:ss')", new Date()));
        System.out.println(AviatorEvaluator.exec("string_to_date(datestr,'yyyy-MM-dd HH:mm:ss')", "2017-12-19 14:13:23"));
        System.out.println(AviatorEvaluator.exec("math.sqrt(x)", 2));
        System.out.println(AviatorEvaluator.exec("math.log(x)", 10));

    }
}

/**
 * 自定义add函数
 */
class AddFunction extends AbstractFunction {
    public String getName() {
        return "add";
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        Number left = FunctionUtils.getNumberValue(arg1, env);
        Number right = FunctionUtils.getNumberValue(arg2, env);
        return new AviatorDouble(left.doubleValue() + right.doubleValue());
    }
}
