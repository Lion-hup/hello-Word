import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Login extends JFrame implements ActionListener {

    Container cp = null;

    String name = null;

    String psw = null;

    JFrame f = null;

    JButton j1, j2;

    JTextField t1;

    JPasswordField t2;

    JLabel jLabe1, jLabe2;

    Color c;

    JPanel jp1, jp2;

    Login(){
        f=new JFrame("学生管理系统");

        j1 = new JButton("确定");
        j2 = new JButton("取消");

        cp = f.getContentPane();

        jLabe1 = new JLabel("输入用户名");

        jLabe2 = new JLabel("用户密码");

        jp1 = new JPanel();

        jp2 = new JPanel();

        t1 = new JTextField(18);

        t2 = new JPasswordField(18);

        jp1.add(jLabe1);

        jp1.add(t1);

        jp1.add(jLabe2);

        jp1.add(t2);

        JLabel jl = new JLabel("<html><font color=#000000 size='6'><i> 欢迎进入学生管理系统</i></font>", SwingConstants.CENTER);

        cp.add(jl, "North");

        jp2.add(j1);

        jp2.add(j2);

        cp.add(jp1, "Center");

        cp.add("South", jp2);

        jp1.setBackground(Color.lightGray);

        Toolkit kit = Toolkit.getDefaultToolkit();

        Dimension screen = kit.getScreenSize();

        int x = screen.width;

        int y = screen.height;

        f.setSize(300, 300);

        int xcenter = (x - 300)/2;

        int ycenter = (y - 300)/2;

        f.setLocation(xcenter, ycenter);

        f.setVisible(true);

        j1.addActionListener(this);

        j2.addActionListener(this);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public void confirm() throws IOException {
        File file = new File("/wangbin/gitHup/hello-Word/Login.txt");

        try {
            if (!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(new FileReader(file));

        String temp = br.readLine();

        String line;

        while ((line = br.readLine()) != null){
            temp +="," + line;
        }

        if (temp == null){
            System.out.println();
        }else {
            String[] str = temp.split(",");

            name = str[0];

            psw = str[1];

            if (t1.getText().trim().equals(name) && t2.getText().trim().equals(psw)){
//                Text text = new Text();
//                new Test();
                f.hide();

                br.close();
            }else {
                JOptionPane.showMessageDialog(null, "该用户不存在", "提示！", JOptionPane.YES_NO_OPTION);

            }
            t1.setText("");
            t2.setText("");

        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("确定")){
            try {
                confirm();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (cmd.equals("取消")){
            f.dispose();
        }
    }


    public static void main(String[] args) {
        Login login = new Login();
    }
}
