package com.darren.optimize.interview.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 * 格式化代码 ctrl + alt + L
 */
public class JavaBaseTest {
    @Test
    public void addition_isCorrect() {
        // 字符串常量池 (堆区) 有A,B对象
        String a = "A";
        a = "B";
    }

    class A {
        private final void getName() {
        }
    }

    public class B extends A {
        public void getName() {
            System.out.println("OK");
        }
    }

    @Test
    public void genTest() {
        // ArrayList是泛型, 没有指定就是object, String,Integer都可以加入,但是取出的时候忘记了,麻烦了...
        List list = new ArrayList();
        list.add("qqyumidi");
        list.add("corn");
        list.add(100);
        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i);
            System.out.println("name:" + name);
        }
    }


    @Test
    public void boxTest() {
        Box<String> boxStr = new Box<>("adb");
        Box<Integer> boxInteger = new Box<>(111);
        Class<? extends Box> aClass = boxStr.getClass();
        Class<? extends Box> bClass = boxInteger.getClass();
        System.out.println("aClass == bClass:" + (aClass == bClass));
    }

    @Test
    public void boxTest2() {
        Box<Number> name = new Box<Number>(99);
        Box<Integer> age = new Box<Integer>(712);
        getData(name);
//        getData(age); //error
        getData2(name);
        getData2(age);
    }

    @Test
    public void boxTest3() {
        // Box<Number>不能视为 Box<Integer>的父类
        Box<Integer> a = new Box<Integer>(712);
//        Box<Number> b = a; //error
        Box<Float> f = new Box<Float>(3.14f); // 1
//        b.set(f); // 2 //error
    }

    /**
     * 第一: 泛型只作用于编译期, java 经过javac之后class是不存在 泛型 T (泛型擦除)
     * 看字节码就知道了
     * 第二: Box<Number> Box<Integer> 这两个对象获取的getClass 都是Box 相等的, 不存在父子关系
     * 第三: 类型通配符: Box<?>在逻辑上是 Box<Integer>、Box<Number>...等所有 Box<具体 类型实参>的父类
     *     注意只是逻辑上
     * 第四: Box<? extends Number> data 上限
     *  Box<? super Number> data 下线
     */
    @Test
    public void boxTest4() {
        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);
        getData2(name);
        getData2(age);
        getData2(number);

       // getUpperNumberData(name); // error
        getUpperNumberData(age);
        getUpperNumberData(number);


    }

    public void getData(Box<Number> data) {
        System.out.println("data :" + data.get());
    }

    // 类型通配符: Box<?>在逻辑上是 Box<Integer>、Box<Number>...等所有 Box<具体 类型实参>的父类。
    public void getData2(Box<?> data) {
        System.out.println("data :" + data.get());
    }

    // 类型通配符上限
    public static void getUpperNumberData(Box<? extends Number> data) {
        System.out.println("data :" + data.get());
    }

}