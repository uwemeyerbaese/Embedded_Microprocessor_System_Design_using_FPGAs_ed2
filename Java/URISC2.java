// A ISS for the URSIC microprocessor
import java.awt.*;
import java.awt.event.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class urisc2 extends Frame {
    Button stepButton, resetButton;
    Label clkLabel, pcLabel, iwLabel;
    Label r0Label, r1Label, r2Label, r3Label, r4Label, r15Label;
    int [] prog = new int[4096];
    int [] reg = {5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public urisc2 ()
    {   int k = 0, i=1, N=0;
        String fileName = "io.hex";
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while ((myReader.hasNextLine()) && (i>0)) {
                String data = myReader.nextLine();
                i = Integer.parseInt(data, 16);
                System.out.println(k + ") "+data + " = " + i);
                prog[k++] = i;
            }
            N=k;
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found!");
            e.printStackTrace();
        }
        setLayout(new GridLayout(0,2)); // 3 columns; infinity rows
        setTitle("ISS by UMB");
        add(new Label ("Name")); add(new Label ("Value"));
        // row 1: CLK and Value
        add(new Label ("CLK"));
        clkLabel = new Label("0");  add(clkLabel);
        // row 2: PC and value
        add(new Label ("PC"));
        pcLabel = new Label("0"); add(pcLabel);
        // row 3: IW and value
        add(new Label ("IW"));
        String result = String.format("%X", prog[0] );
        iwLabel = new Label(result); add(iwLabel);
        // row 4: R[0] and value
        add(new Label ("R[0]"));
        String r0 = String.format("%d", reg[0] );
        r0Label = new Label(r0); add(r0Label);
        // row 5: R[1] and value
        add(new Label ("R[1]"));
        String r1 = String.format("%d", reg[1] );
        r1Label = new Label(r1); add(r1Label);
        // row 6: R[2] and value
        add(new Label ("R[2]"));
        String r2 = String.format("%d", reg[2] );
        r2Label = new Label(r2); add(r2Label);
        //add(new Label ("Value"));
        // row 7: R[3] and value
        add(new Label ("R[3]"));
        String r3 = String.format("%d", reg[3] );
        r3Label = new Label(r3); add(r3Label);
        // row 8: R[4] and value
        add(new Label ("R[4]"));
        String r4 = String.format("%d", reg[4] );
        r4Label = new Label(r2); add(r4Label);
        // row 9: R[15] and value
        add(new Label ("R[15]"));
        String r15 = String.format("%d", reg[15] );
        r15Label = new Label(r15); add(r15Label);
        // Last row: Buttons for STEP and RESET
        stepButton = new Button ("STEP");
        stepButton.setBackground(new Color(0,128,0)); //
        stepButton.setForeground(Color.WHITE);
        add (stepButton);
        stepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int clk = Integer.parseInt(clkLabel.getText());
                int pc_now = Integer.parseInt(pcLabel.getText());
                int pc_new;
                int dst = (prog[pc_now] &0xF000) >>12;
                int src = (prog[pc_now] & 0x0F00) >> 8;
                int mode = (prog[pc_now] & 0x0080) >> 7;
                int addr = (prog[pc_now] & 0x007F);
                int result = reg[dst] - reg[src];
                if (dst > 0)
                    reg[dst] = result;
                if (result >= 0) {
                    pc_new = pc_now + 1;
                } else if (mode == 1) {
                    pc_new = addr;
                } else {
                    pc_new = pc_now + addr;
                }
                // iw = prog[pc_new];
                //dst, src, mode, addr = decode(iw)
                result = reg[dst] - reg[src];
                String str = String.format("%d", ++clk); clkLabel.setText(str);
                str = String.format("%d", pc_new); pcLabel.setText(str);
                str = String.format("%X", prog[pc_new]); iwLabel.setText(str);
                str = String.format("%d", reg[0]); r0Label.setText(str);
                str = String.format("%d", reg[1]); r1Label.setText(str);
                str = String.format("%d", reg[2]); r2Label.setText(str);
                str = String.format("%d", reg[3]); r3Label.setText(str);
                str = String.format("%d", reg[4]); r4Label.setText(str);
                str = String.format("%d", reg[15]); r15Label.setText(str);
            }
        });
        resetButton = new Button ("RESET");
        resetButton.setBackground(Color.RED);
        resetButton.setForeground(Color.WHITE);
        add (resetButton);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = Integer.parseInt (clkLabel.getText());
                String result = String.format("%d", 0);
                clkLabel.setText(result);
                pcLabel.setText(result);
                result = String.format("%X", prog[0]);
                iwLabel.setText(result);
                for (int k=1; k<=15; k++) reg[k] = -1;
                reg[0]= 5;
                String str = "5"; r0Label.setText(str);
                str = "-1"; r1Label.setText(str); r2Label.setText(str);
                r3Label.setText(str); r4Label.setText(str);
                r15Label.setText(str);
            }
        });
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize (250, 300);
        setVisible (true);
    }
    public static void main (String args[])
    {
        new urisc2();
    }
}
