import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Base64;

import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;


public class CryptographyApp{

    private final JButton encryptButton, decryptButton, copyEncryptionButton, copyDecryptionButton;
    private final JComboBox<String> algorithmChoiceBox;
    private final JTextArea messageTextArea, encryptionKeyTextArea, encryptedMessageTextArea, cypherTextArea, decryptionKeyTextArea, decryptedMessageTextArea;
    private final JFrame frame;


    public CryptographyApp(){
        frame = new JFrame();
        frame.setTitle(" OTP | 3DES | AES - Encryption And Decryption");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        Container frontPage = frame.getContentPane();
        frontPage.setBackground(Color.darkGray);

        EmptyBorder encryptPanelPaddingBorder = new EmptyBorder(20, 15, 20, 10);
        EmptyBorder decryptPanelPaddingBorder = new EmptyBorder(20, 10, 20, 15);
        Font headerFont = new Font("Arial", Font.BOLD, 22);
        Font textAreaFont = new Font("", Font.PLAIN, 18);
        Dimension messageDimension = new Dimension(200, 100);
        Dimension buttonDimension = new Dimension(150, 50);
        Color panelColor = new Color(30,30,30);
        Color buttonColor = new Color(20,20, 20);
        Color buttonForegroundColor = new Color(140, 140, 140);
        Color textAreaColor = new Color(100,100,100);
        Color messageTextColor = new Color(40, 240,40);
        Color cypherTextColor = new Color(253, 174, 3);
        Color keyTextColor = new Color(40, 140, 240);


        //Encryption Panel
        JPanel encryptionPanel = new JPanel();
        encryptionPanel.setBorder(encryptPanelPaddingBorder);
        messageTextArea = new JTextArea();
        messageTextArea.setPreferredSize(messageDimension);
        messageTextArea.setBackground(textAreaColor);
        messageTextArea.setForeground(messageTextColor);
        messageTextArea.setFont(textAreaFont);
        JLabel encryptLabel = new JLabel();
        encryptLabel.setText("Message To Encrypt");
        encryptLabel.setFont(headerFont);
        encryptLabel.setForeground(Color.GREEN);
        encryptLabel.setHorizontalTextPosition(JLabel.CENTER);
        JPanel encryptionKeyPanel = new JPanel();
        encryptionKeyPanel.setBackground(panelColor);
        JButton encryptionKeyButton = new JButton("Encryption Key");
        encryptionKeyButton.setBackground(Color.GRAY);
        encryptionKeyTextArea = new JTextArea();
        encryptionKeyTextArea.setPreferredSize(new Dimension(300, 30));
        encryptionKeyTextArea.setBackground(textAreaColor);
        encryptionKeyTextArea.setForeground(keyTextColor);
        encryptionKeyTextArea.setFont(textAreaFont);
        JPanel encryptionButtonsPanel = new JPanel();
        encryptButton = new JButton("Encrypt");
        copyEncryptionButton = new JButton(" Copy Encryption ");
        encryptButton.setPreferredSize(buttonDimension);
        copyEncryptionButton.setPreferredSize(buttonDimension);
        encryptButton.setBackground(buttonColor);
        encryptButton.setForeground(buttonForegroundColor);
        copyEncryptionButton.setBackground(buttonColor);
        copyEncryptionButton.setForeground(buttonForegroundColor);
        encryptedMessageTextArea = new JTextArea();
        encryptedMessageTextArea.setPreferredSize(messageDimension);
        encryptedMessageTextArea.setBackground(textAreaColor);
        encryptedMessageTextArea.setForeground(cypherTextColor);
        encryptedMessageTextArea.setFont(textAreaFont);
        encryptionPanel.setLayout(new BoxLayout(encryptionPanel, BoxLayout.Y_AXIS));
        encryptionButtonsPanel.add(encryptButton);
        encryptionButtonsPanel.add(copyEncryptionButton);
        encryptionButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        encryptionButtonsPanel.setBackground(panelColor);
        encryptionKeyPanel.add(encryptionKeyButton);
        encryptionKeyPanel.add(encryptionKeyTextArea);
        encryptionPanel.add(encryptLabel);
        encryptionPanel.add(messageTextArea);
        encryptionPanel.add(encryptionKeyPanel);
        encryptionPanel.add(encryptionButtonsPanel);
        encryptionPanel.add(encryptedMessageTextArea);
        encryptionPanel.setBackground(panelColor);
        frontPage.add(encryptionPanel, BorderLayout.WEST);


        //Decryption Panel
        JPanel decryptionPanel = new JPanel();
        decryptionPanel.setBorder(decryptPanelPaddingBorder);
        cypherTextArea = new JTextArea();
        cypherTextArea.setPreferredSize(messageDimension);
        cypherTextArea.setBackground(textAreaColor);
        cypherTextArea.setForeground(cypherTextColor);
        cypherTextArea.setFont(textAreaFont);
        JLabel decryptLabel = new JLabel();
        decryptLabel.setText("Message To Decrypt");
        decryptLabel.setFont(headerFont);
        decryptLabel.setForeground(Color.GREEN);
        decryptLabel.setHorizontalTextPosition(JLabel.CENTER);
        JPanel decryptionKeyPanel = new JPanel();
        decryptionKeyPanel.setBackground(panelColor);
        JButton decryptionKeyButton = new JButton("Decryption Key ");
        decryptionKeyButton.setBackground(Color.GRAY);
        decryptionKeyTextArea = new JTextArea();
        decryptionKeyTextArea.setPreferredSize(new Dimension(300, 30));
        decryptionKeyTextArea.setBackground(textAreaColor);
        decryptionKeyTextArea.setForeground(keyTextColor);
        decryptionKeyTextArea.setFont(textAreaFont);
        JPanel decryptButtonsPanel = new JPanel();
        decryptButton = new JButton("Decrypt");
        copyDecryptionButton = new JButton(" Copy Decryption ");
        decryptButton.setPreferredSize(buttonDimension);
        copyDecryptionButton.setPreferredSize(buttonDimension);
        decryptButton.setBackground(buttonColor);
        decryptButton.setForeground(buttonForegroundColor);
        copyDecryptionButton.setBackground(buttonColor);
        copyDecryptionButton.setForeground(buttonForegroundColor);
        decryptButton.setBackground(buttonColor);
        copyDecryptionButton.setBackground(buttonColor);
        decryptedMessageTextArea = new JTextArea();
        decryptedMessageTextArea.setPreferredSize(messageDimension);
        decryptedMessageTextArea.setBackground(textAreaColor);
        decryptedMessageTextArea.setForeground(messageTextColor);
        decryptedMessageTextArea.setFont(textAreaFont);
        decryptionPanel.setLayout(new BoxLayout(decryptionPanel, BoxLayout.Y_AXIS));
        decryptButtonsPanel.add(decryptButton);
        decryptButtonsPanel.add(copyDecryptionButton);
        decryptButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        decryptButtonsPanel.setBackground(panelColor);
        decryptionKeyPanel.add(decryptionKeyButton);
        decryptionKeyPanel.add(decryptionKeyTextArea);
        decryptionPanel.add(decryptLabel);
        decryptionPanel.add(cypherTextArea);
        decryptionPanel.add(decryptionKeyPanel);
        decryptionPanel.add(decryptButtonsPanel);
        decryptionPanel.add(decryptedMessageTextArea);
        decryptionPanel.setBackground(panelColor);
        frontPage.add(decryptionPanel, BorderLayout.EAST);
        

        //Cryptography Algorithm Choice Combo-Box
        JPanel algorithmChoicePanel = new JPanel();
        algorithmChoicePanel.setBackground(Color.darkGray);
        JLabel algorithmChoiceLabel = new JLabel();
        algorithmChoiceLabel.setText("Choose Algorithm");
        algorithmChoiceLabel.setForeground(Color.black);
        algorithmChoiceLabel.setFont(headerFont);
        algorithmChoicePanel.add(algorithmChoiceLabel);
        String[] options = {"One-Time Pad (OTP)", "3DES", "AES"};
        algorithmChoiceBox = new JComboBox<>(options);
        algorithmChoiceBox.setBackground(Color.GRAY);
        algorithmChoiceBox.setMaximumRowCount(3);
        algorithmChoiceBox.setPreferredSize(new Dimension(250, 50));
        algorithmChoiceBox.setFont(new Font("Arial", Font.PLAIN, 18));
        algorithmChoicePanel.add(algorithmChoiceBox);
        frontPage.add(algorithmChoicePanel, BorderLayout.SOUTH);
        
        encryptButton.addActionListener(new IL());
        decryptButton.addActionListener(new IL());
        copyEncryptionButton.addActionListener(new IL());
        copyDecryptionButton.addActionListener(new IL());

        frame.pack();
        frame.setVisible(true);

    }
    

    private class IL implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //Encrypt button event
            if(e.getSource() == encryptButton){
                String selectedOption = (String) algorithmChoiceBox.getSelectedItem();
                if (selectedOption.equals("One-Time Pad (OTP)")){
                    String encInput = messageTextArea.getText();
                    String encKey = encryptionKeyTextArea.getText();
                    byte[] answer = OneTimePad.otpEncrypt(encInput.getBytes(), encKey.getBytes());
                    String encOutput = new String(answer);
                    encryptedMessageTextArea.setText(encOutput);
                }
                else if (selectedOption.equals("3DES")){
                    String encInput = messageTextArea.getText();
                    String encKey = encryptionKeyTextArea.getText();
                    String encOutput;
                    byte[] answer;
                    try {
                        answer = TripleDES.desEncrypt(encInput, encKey);
                        encOutput = Base64.getEncoder().encodeToString(answer);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        encOutput = "Please check your inputs (24-byte key)";
                        e1.printStackTrace();
                    } 
                    encryptedMessageTextArea.setText(encOutput);

                }
                else if (selectedOption.equals("AES")){
                    String encInput = messageTextArea.getText();
                    String encKey = encryptionKeyTextArea.getText();
                    byte[] answer;
                    String encOutput;
                    try {
                        answer = AES.aesEncrypt(encInput.getBytes(), encKey.getBytes());
                        encOutput = Base64.getEncoder().encodeToString(answer);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        encOutput = "Please check your inputs (16-byte key)";
                    }
                    encryptedMessageTextArea.setText(encOutput);
                    
                }
                else{
                    System.out.println("OTP selected");
                }

            }

            //Decrypt button event
            else if(e.getSource() == decryptButton){
                String selectedOption = (String) algorithmChoiceBox.getSelectedItem();
                if (selectedOption.equals("One-Time Pad (OTP)")){
                    String decInput = cypherTextArea.getText();
                    String decKey = decryptionKeyTextArea.getText();
                    byte[] answer = OneTimePad.otpDecrypt(decInput.getBytes(), decKey.getBytes());
                    String decOutput = new String(answer);
                    decryptedMessageTextArea.setText(decOutput);
                }
                else if (selectedOption.equals("3DES")){
                    String decInput = cypherTextArea.getText();
                    String decKey = decryptionKeyTextArea.getText();
                    String decOutput;
                    try {
                        decOutput = TripleDES.desDecrypt(Base64.getDecoder().decode(decInput), decKey);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        decOutput = "Please check your inputs (24-byte key)";
                        e1.printStackTrace();
                    } 
                    decryptedMessageTextArea.setText(decOutput);

                }
                else if (selectedOption.equals("AES")){
                    String decInput = cypherTextArea.getText();
                    String decKey = decryptionKeyTextArea.getText();
                    String decOutput;
                    byte[] answer;
                    try {
                        answer = AES.aesDecrypt(Base64.getDecoder().decode(decInput), decKey.getBytes());
                        decOutput = new String(answer);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        decOutput = "Please check your inputs (16-byte key)";
                    }
                    decryptedMessageTextArea.setText(decOutput);
                    
                }
            }
            else if(e.getSource() == copyEncryptionButton){
                String text = encryptedMessageTextArea.getText();
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable transferable = new StringSelection(text);
                clipboard.setContents(transferable, null);
                JOptionPane.showMessageDialog(frame, "Text copied to clipboard!");
            } 

            else if (e.getSource() == copyDecryptionButton) {
                String text = decryptedMessageTextArea.getText();
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable transferable = new StringSelection(text);
                clipboard.setContents(transferable, null);
                JOptionPane.showMessageDialog(frame, "Text copied to clipboard!");
            } 

        }
    }

    //CRYPTOGRAPHY ALGORITHM IMPLEMENTATION ARE INCLUDED IN IMPORTED MODULES

}

