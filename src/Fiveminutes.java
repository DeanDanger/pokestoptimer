//import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
//import Image_Loader;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.Timer;

class Fiveminutes extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//static ImageIcon img = new ImageIcon("icon.jpg");
public static int onepsecs = -1;
public static int tenpsecs = 0;
public static int onepmins = 0;
public static int tenpmins = 0;
private static JButton start = new JButton();
private static JButton reset = new JButton();
private static JButton pause = new JButton();
//private static JButton cancel = new JButton();
private static JButton resume = new JButton();
private static int cnt;
static JFrame f;
static JLabel l;

	public static void main(String args[]) {
		GridLayout flayout = new GridLayout(0,1);
		f=new JFrame();
		l= new JLabel("press start",SwingConstants.CENTER);
		f.setSize(200,100);
		//f.setLayout(flayout);
		start.setSize(200,100);
		start.setHorizontalTextPosition(SwingConstants.CENTER);
		start.setVerticalTextPosition(SwingConstants.NORTH);
 //cancel.setSize(20, 30);
 //l.setText("loading...");
		start.setText("Start");
		reset.setText("Reset");
		pause.setText("pause");
		resume.setText("resume");
		//cancel.setText("cancel");
		f.add(l);
		l.setVisible(false);
		f.add(start);
		f.add(reset);
		//f.add(pause);
		//f.add(resume);
		resume.setVisible(false);
		//cancel.setVisible(false);
		reset.setVisible(false);
		f.setIconImage(Image_Loader.Load_Image("/images/icon1.png"));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent argo0){
				f.setLayout(flayout);
				l.setVisible(true);
				start.setVisible(false);
				reset.setVisible(true);
				pause.setVisible(true);
				l.setText("Loading...");
				
				ActionListener actListner = new ActionListener() {
					
					@Override

					public void actionPerformed(ActionEvent event) {
						cnt += 1;
						if(cnt!=301)
						{
							if(cnt==300)
							{
							JOptionPane.showMessageDialog(f,"SPINDAAAAAAAAAAA WIN","IT'S TIME!", JOptionPane.WARNING_MESSAGE);	
							}
							
							if (onepsecs==9){
								onepsecs=-1;
								tenpsecs++;
						}
							if(tenpsecs==6){
								tenpsecs=0;
								onepmins++;
						}
							if(onepmins==9){
								onepmins=-1;
								tenpmins++;
						}
							onepsecs++;
							l.setText(tenpmins+onepmins+":"+tenpsecs+onepsecs);
			//f.pack();
						}
						
						else
						{
							cnt=0;
							onepsecs = 0;
							tenpsecs = 0;
							onepmins = 0;
							tenpmins = 0;
							l.setText(tenpmins+onepmins+":"+tenpsecs+onepsecs);
						}
					}
					
		 
		 
				};
				Timer timer = new Timer(1000, actListner);
				timer.start();
				reset.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent argo1){
						pause.setVisible(true);
						resume.setVisible(false);
						cnt=0;
						onepsecs = 0;
						tenpsecs = 0;
						onepmins = 0;
						tenpmins = 0;
						timer.stop();
						l.setText(tenpmins+onepmins+":"+tenpsecs+onepsecs);
						timer.start();
					}
			});
				pause.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent argo1){
						timer.stop();
						pause.setVisible(false);
						resume.setVisible(true);
						
					}
			});
				resume.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent argo1){
						timer.stop();
						resume.setVisible(false);
						timer.start();
						pause.setVisible(true);
						
						
					}
			});
			}
		});




			

	}
 }