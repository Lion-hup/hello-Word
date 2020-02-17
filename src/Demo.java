import java.util.Scanner;

class Demo{

    public static void main(String[]args){

        //tinaj    22222222222

        Demo demo = new Demo();

        demo.print("wangbin", 30);

        System.out.println("请输入你的名字：");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();

        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();

        demo.print(name, age);

    }


    public void print( String name, int age){

        System.out.println("你的名字是：" + name + ", 年龄是：" + age);

    }

}
