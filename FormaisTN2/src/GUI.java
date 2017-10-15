import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	static private JTextArea input;
	static private JTextArea output;

	public GUI() {
		JFrame guiFrame = new JFrame();
		
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("FormaisTN2");
		guiFrame.setSize(640, 360);
		guiFrame.setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
		input = new JTextArea();
		JButton analize = new JButton("Analizar");
		JButton clear = new JButton("Limpar");
		output = new JTextArea();

		analize.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				Program.Start(input.getText());
			}
		});
		
		clear.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				input.setText("");
				output.setText("");
			}
		});
		
		mainPanel.add(input);
		buttonPanel.add(analize);
		buttonPanel.add(clear);
		mainPanel.add(buttonPanel);
		mainPanel.add(output);
		
		guiFrame.add(mainPanel, BorderLayout.CENTER);

		guiFrame.setVisible(true);
	}
	
	public static void concatText(String text) {
		output.setText(output.getText().concat(text));
	}
}