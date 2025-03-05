import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Studenttest {

    static ArrayList<User> list=new ArrayList<>();

    static {//添加一些用户信息
        list.add(new User("zhangsan","1234qwer","110101200001011234","13112345678"));
    }


    public static void main(String[] args) {

        printusersystem(list);

    }

    //添加功能
    //键盘录入每一个学生信息并添加，需要满足以下要求：
    //id唯一
    public static ArrayList<Student> addstudent(ArrayList<Student> list) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要添加学生的id:");
        String id = sc.next();
        if (index_student(list, id) != -1) {
            System.out.println("学生id重复,请输入系统中没有的id");
        } else {
            s.setId(id);
            System.out.println("请输入要添加学生的name:");
            s.setName(sc.next());
            System.out.println("请输入要添加学生的age:");
            s.setAge(sc.nextInt());
            System.out.println("请输入要添加学生的address:");
            s.setAddress(sc.next());
            list.add(s);
            System.out.println("添加成功!");
        }
        return list;
    }


    //删除功能
    //键盘录入要删除的学生id，需要满足以下要求：
    //id存在删除
    //id不存在，需要提示不存在，并回到初始菜单
    public static ArrayList<Student> deletestudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除学生的id号:");
        String id = sc.next();
        if (index_student(list, id) == -1) {
            System.out.println("该id不存在");
        } else {
            list.remove(index_student(list, id));
            System.out.println("id为" + id + "的学生删除成功");


        }
        return list;
    }

    //修改功能
    //键盘录入要修改的学生id，需要满足以下要求
    //id存在，继续录入其他信息
    //id不存在，需要提示不存在，并回到初始菜单
    public static ArrayList<Student> modifystudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        System.out.println("请输入要修改学生的id:");
        String id = sc.next();
        if (index_student(list, id) == -1) {
            System.out.println("该id不存在");
        } else {
            s.setId(id);
            System.out.println("请输入修改后学生的name:");
            s.setName(sc.next());
            System.out.println("请输入修改后学生的age:");
            s.setAge(sc.nextInt());
            System.out.println("请输入修改后学生的address:");
            s.setAddress(sc.next());
            list.set(index_student(list, id), s);
            System.out.println("id为" + id + "的学生修改成功");
        }
        return list;
    }

    //查询功能
    //打印所有的学生信息，需要满足以下要求
    //如果没有学生信息，提示：当前无学生信息，请添加后再查询
    //如果有学生信息，需要按照以下格式输出。（不用过于纠结对齐的问题）
    public static void querystudent(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("当前无学生信息,请添加后查询");
            return;
        }
        // 打印表头，对齐字段宽度
        System.out.println(String.format("%-15s %-15s %-15s %-15s", "id", "姓名", "年龄", "家庭住址"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                // 格式化每个字段的宽度
                System.out.println(String.format("%-15s %-15s %-15s %-15s",
                        list.get(i).getId(),
                        list.get(i).getName(),
                        list.get(i).getAge(),
                        list.get(i).getAddress()));
            }
        }
        return;
    }


    public static boolean contains(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }


    //找出id在集合ArrayList<Student> list中的索引,要是没有则返回-1
    public static int index_student(ArrayList<Student> list, String id) {
        if (list.size()==0) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }


    //找出username在集合ArrayList<User> list中的索引,要是没有则返回-1
    public static int index_user(ArrayList<User> list, String username) {
        if (list.size()==0) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }


    //学生系统
    /*"-------------欢迎来到黑马学生管理系统----------------"
            "1：添加学生"
            "2：删除学生"
            "3：修改学生"
            "4：查询学生"
            "5：退出"
            "请输入您的选择:"*/
    public static void printstudentsystem() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        String input;

        loop:
        while (true) {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    System.out.println(list.get(i).getId() + "," + list.get(i).getName() + "," + list.get(i).getAge() + "," + list.get(i).getAddress());
                }
            }

            System.out.println("-----欢迎来到学生管理系统-----");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出");
            System.out.println("请输入您的选择:");
            input = sc.next();

            switch (input) {
                case "1" -> addstudent(list);
                case "2" -> deletestudent(list);
                case "3" -> modifystudent(list);
                case "4" -> querystudent(list);
                case "5" -> {
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }


    //用户系统
    /*"欢迎来到用户界面"
        请选择操作
      "1：登录"
      "2：注册"
      "3：忘记密码"
      "4：查询用户"
      "5：退出""*/
    public static void printusersystem(ArrayList<User> list) {
        //ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        loop:
        while (true) {
            System.out.println("欢迎来到用户界面");
            System.out.println("请选择操作");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.忘记密码");
            System.out.println("4.查询用户");
            System.out.println("5.退出");
            String input = sc.next();
            switch (input) {
                case "1" -> login(list);//用户登录
                case "2" -> registeruser(list);//用户注册
                case "3" -> passwordforgot(list);//忘记密码
                case "4" -> queryuser(list);//查询所有的用户信息
                case "5" -> {
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    //注册用户
    /*如果注册成功的话添加到ArrayList<User> list中,这里细分成四个方法来写的
    //1，用户名需要满足以下要求：
    //验证要求：
    //用户名唯一
    //用户名长度必须在3~15位之间
    //只能是字母加数字的组合，但是不能是纯数字
    //2，密码键盘输入两次，两次一致才可以进行注册。
    //3，身份证号码需要验证。
    //验证要求：
    //长度为18位
    //不能以0为开头
    //前17位，必须都是数字
    //最为一位可以是数字，也可以是大写X或小写x
    //4，手机号验证。
    //验证要求：
    //长度为11位
    //不能以0为开头
    //必须都是数字*/
    public static ArrayList<User> registeruser(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        User u = new User();
        if (checkusername(list, u)) {
            System.out.println("用户名符合规范");
            if (checkpassword(u)) {
                System.out.println("两次密码输入一致");
                if (checkidnumber(u)) {
                    System.out.println("身份证号码符合规范");
                    if (checkphonenumber(u)) {
                        System.out.println("手机号符合规范");
                        list.add(u);
                        System.out.println("用户注册成功!");
                    }
                }
            }
        } else {
            System.out.print("用户名不满足要求");
        }
        return list;
    }


    //用户登录
    //1，键盘录入用户名
    //2，键盘录入密码
    //3，键盘录入验证码
    //验证要求：
    //用户名如果未注册，直接结束方法，并提示：用户名未注册，请先注册
    //判断验证码是否正确，如不正确，重新输入
    //再判断用户名和密码是否正确，有3次机会
    public static void login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        if(list.size()==0){
            System.out.println("当前无用户信息,请注册后登录");
            return;
        }
        System.out.println("请输入用户名:");
        String username = sc.next();
        int n = index_user(list, username);
        if (n != -1) {
            int count = 0;
            loop1:while (true) {
                System.out.println("验证码为:");
                String s = captcha();
                System.out.println(s);
                System.out.println("请输入验证码:");
                String captcha2 = sc.next();
                if (s.equalsIgnoreCase(captcha2)) {
                    System.out.println("请输入密码:");
                    loop2:while (count < 3) {
                        String password = sc.next();
                        if (list.get(n).getPassword().equals(password)) {
                            System.out.println("登录成功");
                            printstudentsystem();
                            break loop1;
                        } else {
                            System.out.println("第" + (count + 1) + "次输入的密码不正确,请重新输入:");
                            count++;
                        }
                    }
                    if (count == 3) {
                        System.out.println("3次输入密码错误");
                        return;
                    }
                } else {
                    System.out.println("验证码输入不正确,请重新输入");
                }
            }
        } else {
            System.out.println("该用户未注册,请先注册");
        }
    }


    //忘记密码
    //1，键盘录入用户名，判断当前用户名是否存在，如不存在，直接结束方法，并提示：未注册
    //2，键盘录入身份证号码和手机号码
    //3，判断当前用户的身份证号码和手机号码是否一致，
    //如果一致，则提示输入密码，进行修改。
    //如果不一致，则提示：账号信息不匹配，修改失败。
    public static void passwordforgot(ArrayList<User> list){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username=sc.next();
        int n=index_user(list,username);
        if(n!=-1){
            System.out.println("请输入用户的身份证号码:");
            String idnumber=sc.next();
            if(idnumber.equals(list.get(n).getIdnumber())){
                System.out.println("请输入用户的手机号码:");
                String phonenumber=sc.next();
                if(phonenumber.equals(list.get(n).getPhonenumber())){
                    System.out.println("请输入你要进行修改后的密码:");
                    String password=sc.next();
                    list.get(n).setPassword(password);
                    System.out.println("修改成功!");
                    return;
                }else{
                    System.out.println("电话号码不一致,修改失败");
                }
            }else{
                System.out.println("身份证号码不一致,修改失败");
            }
        }else{
            System.out.println("当前的用户名不存在,请注册");
            return;
        }
    }


    //计算字符串中数字的个数
    public static int countnumber(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count++;
            }
        }
        return count;
    }


    //检查用户名是否符合规范,符合规范的用户名添加到User u中
    //用户名需要满足以下要求：
    //用户名唯一
    //用户名长度必须在3~15位之间
    //只能是字母加数字的组合，但是不能是纯数字
    public static boolean checkusername(ArrayList<User> list, User u) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要注册的用户名:");
        String username = sc.next();
        if (index_user(list, username) == -1) {//list中没有输入的用户名
            if (username.length() < 3) {
                System.out.println("用户名长度低于3位");
            }
            if (username.length() > 15) {
                System.out.println("用户名长度超过15位");
            }
            if (countnumber(username) == username.length()) {
                System.out.println("用户名不能是纯数字");
            }
            if (username.length() >= 3 && username.length() <= 15 && countnumber(username) < username.length()) {
                u.setUsername(username);
                return true;
            }
        } else {
            System.out.println("该用户名已存在");
        }
        return false;
    }


    //检查两次输入的密码是否一致,符合规范的密码添加到User u中
    //密码键盘输入两次，两次一致才可以进行注册
    public static boolean checkpassword(User u) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入密码:");
            String s_password1 = sc.next();
            System.out.println("请再次输入密码:");
            String s_password2 = sc.next();
            if (s_password1.equals(s_password2)) {
                u.setPassword(s_password1);
                return true;
            } else {
                System.out.println("两次输入的密码不一致");
                System.out.println("请重新输入密码");
            }
        }
    }


    //检查身份证号是否符合规范,符合规范的身份证号添加到User u中
    //身份证号码需要验证:
    //长度为18位
    //不能以0为开头
    //前17位，必须都是数字
    //最为一位可以是数字，也可以是大写X或小写x
    public static boolean checkidnumber(User u) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入身份证号码:");
            String s = sc.next();
            if (s.length() == 18) {//身份证长度为18位
                if (s.charAt(0) != '0') {//不能以0为开头
                    if (countnumber(s.substring(0, 17)) == 17) {//前17位，必须都是数字
                        if ((s.charAt(17) >= '0' && s.charAt(17) <= '9') || s.charAt(17) == 'x' || s.charAt(17) == 'X') {//最为一位可以是数字，也可以是大写X或小写x
                            u.setIdnumber(s);
                            return true;
                        } else {
                            System.out.println("最后一位既不是数字，也不是大写X或小写x");
                        }
                    } else {
                        System.out.println("身份证前17位不全是数字");
                    }
                } else {
                    System.out.println("身份证不能以零开头");
                }
            } else {
                System.out.println("身份证长度不为18位");
            }
            System.out.println("请重新输入身份证号");
        }
    }


    //检查电话号码是否符合规范,符合规范的电话号码添加到User u中
    //手机号验证:
    //长度为11位
    //不能以0为开头
    //必须都是数字
    public static boolean checkphonenumber(User u) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入手机号:");
            String s = sc.next();
            if (s.length() == 11) {//长度为11位
                if (s.charAt(0) != '0') {//不能以0为开头
                    if (countnumber(s) == 11) {//手机号都是数字
                        u.setPhonenumber(s);
                        return true;
                    } else {
                        System.out.println("手机号必须都是数字");
                    }
                } else {
                    System.out.println("手机号不能以0为开头");
                }
            } else {
                System.out.println("手机号的长度不为11位");
            }
            System.out.println("请重新输入手机号");
        }
    }


    //打印所有的用户信息
    public static void queryuser(ArrayList<User> list) {
        if (list.size() == 0) {
            System.out.println("当前无用户信息,请注册后查询");
            return;
        }
        // 打印表头，对齐字段宽度
        System.out.println(String.format("%-20s %-20s %-25s %-20s", "用户名", "密码", "身份证号", "手机号"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                // 格式化每个字段的宽度
                System.out.println(String.format("%-20s %-20s %-25s %-20s",
                        list.get(i).getUsername(),
                        list.get(i).getPassword(),
                        list.get(i).getIdnumber(),
                        list.get(i).getPhonenumber()));
            }
        }
        return;
    }


    //产生一个随机验证码
    //长度为5
    //由4位大写或者小写字母和1位数字组成，同一个字母可重复
    //数字可以出现在任意位置
    public static String captcha() {
        Random r = new Random();
        char letter[] = new char[62];
        String s = "";
        for (int i = 0; i < 26; i++) {
            letter[i] = (char) ('a' + i);
        }
        for (int i = 0; i < 26; i++) {
            letter[i + 26] = (char) ('A' + i);
        }
        for (int i = 0; i < 10; i++) {
            letter[i + 52] = (char) ('0' + i);
        }

        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(62);
            s = s + letter[index];
        }
        return s;
    }

}
