import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Properties;
public class UserVerificationUI implements UserVerifier, ActionListener {
    Random random;
    private int code;
    private JFrame verificationFrame;
    private JPanel verificationPanel;
    private JLabel verificationLabel;
    private JTextField verificationCodeText;
    private JButton verifyButton;
    public UserVerificationUI(int code){
        this.code = code;
    }
    public void verify(String email){
        //Creating the UI to input the verification code
        verificationFrame = new JFrame();
        verificationFrame.setSize(400, 200);
        verificationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        verificationPanel = new JPanel();
        verificationFrame.add(verificationPanel);

        verificationPanel.setLayout(null);
        verificationLabel = new JLabel("Verification Code");
        verificationLabel.setBounds(10,25, 200, 25);
        verificationCodeText = new JTextField();
        verificationCodeText.setBounds(125, 20, 165, 25);

        verificationPanel.add(verificationLabel);
        verificationPanel.add(verificationCodeText);

        verifyButton = new JButton("verify");
        verifyButton.setBounds(125, 50, 100, 25);
        verificationPanel.add(verifyButton);
        verifyButton.addActionListener(this);
        verificationFrame.setVisible(true);
    }

    public static void sendVerificationCode(String email){
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
            System.out.println("verified");
        }else{
            System.out.println("verification unsuccessful");
        }
    }
}
