import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class UserVerificationUI implements UserVerifier, ActionListener {
    Random random;
    private final int code;
    private JTextField verificationCodeText;

    public UserVerificationUI(int code){
        this.code = code;
    }
    public void verify(String email){
        //Creating the UI to input the verification code
        JFrame verificationFrame = new JFrame();
        verificationFrame.setSize(400, 200);
        verificationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel verificationPanel = new JPanel();
        verificationFrame.add(verificationPanel);

        verificationPanel.setLayout(null);
        JLabel verificationLabel = new JLabel("Verification Code");
        verificationLabel.setBounds(10,25, 200, 25);
        verificationCodeText = new JTextField();
        verificationCodeText.setBounds(125, 20, 165, 25);

        verificationPanel.add(verificationLabel);
        verificationPanel.add(verificationCodeText);

        JButton verifyButton = new JButton("verify");
        verifyButton.setBounds(125, 50, 100, 25);
        verificationPanel.add(verifyButton);
        verifyButton.addActionListener(this);
        verificationFrame.setVisible(true);
    }

    public void sendVerificationCode(String email){
        //When this is implemented, a verification code(this.code) will be sent to email with email address "email",
        //The code will be a random number that is generated, when the user presses the register
        // button(see UserRegistrationUI).
    }
    public static void main(String[] args){
        UserVerificationUI ver = new UserVerificationUI(389);
        ver.verify("abc");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int verCode = Integer.parseInt(verificationCodeText.getText());
        if(code == verCode){
            //Going to change below to a label, and will link to LoginUI
            System.out.println("verified");
        }else{
            //Going to change below to a label
            System.out.println("verification unsuccessful");
        }
    }
}
