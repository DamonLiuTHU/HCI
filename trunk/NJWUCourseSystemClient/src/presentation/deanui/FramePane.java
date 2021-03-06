package presentation.deanui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import net.miginfocom.swing.MigLayout;
import presentation.frameui.CreateFramePane;
import presentation.frameui.FrameInfoPane;
import presentation.frameui.FrameRemarkPane;
import presentation.statusui.FrameButtonSetter;
import presentation.tools.Setter;
import presentation.tools.ViewReplyMessage;

@SuppressWarnings("serial")
public class FramePane extends JPanel implements ViewReplyMessage,DeanUIImage{
	JPanel headPane;
	FrameInfoPane infoPane;
	
	public FramePane(){	
		this.setLayout(new MigLayout());
		this.setOpaque(false);
		showHeadPane();
	}
	
	public void showHeadPane(){
		removeAll();
		
		headPane=new JPanel(new MigLayout());
		headPane.setOpaque(false);
		
		ImageIcon icon2=new ImageIcon(refreshButton);
		JButton refreshInfo_b=new JButton(icon2);
		refreshInfo_b.setToolTipText("刷新");
		new Setter().setButtonUnOpaque(refreshInfo_b);
		//若不更新添加更新按钮，做出去掉一行的修改时，提交后界面不会立即更新
		refreshInfo_b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				showCreatePanel();
				showHeadPane();
			}			
		});
		infoPane=new FrameInfoPane();
		
		JButton createButton=new JButton("  创建新框架   ");
		
		boolean enable=new FrameButtonSetter().setEnable(createButton);
		if(!enable){
			createButton.setToolTipText(CREATE_TIP);
		}
		createButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
					showCreatePanel();				
			}
		});	
		JPanel p=new JPanel(new MigLayout());
		p.setOpaque(false);
		p.add(refreshInfo_b,"gapleft 20,wrap");
		p.add(new FrameRemarkPane(),"gaptop 15,wrap");
		p.add(createButton,"gaptop 55,gapleft 20");
		
		headPane.add(infoPane,"gaptop 5");
		headPane.add(p,"gapleft 80,gaptop 25");
		
		add(headPane);
		repaint();
	}
	
	public void showCreatePanel(){
		removeAll();
		add(new CreateFramePane(),"gapbottom 50,wrap");
		ImageIcon icon1=new ImageIcon(returnButton);
		JButton return_b=new JButton(icon1);
		return_b.setContentAreaFilled(false);
		return_b.setBorderPainted(false);
		return_b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				showHeadPane();
			}			
		});		
		add(new JSeparator(),"span,grow x");
		add(return_b,"gapleft 10");
		repaint();
	}
}
