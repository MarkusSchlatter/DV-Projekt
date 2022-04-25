package ToDo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.Font;



import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;



public class Hauptfenster {
	private JFrame frmTodoListe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hauptfenster window = new Hauptfenster();
					window.frmTodoListe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hauptfenster() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTodoListe = new JFrame();
		frmTodoListe.setTitle("ToDo Liste");
		frmTodoListe.setBounds(100, 100, 784, 613);
		frmTodoListe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTodoListe.getContentPane().setLayout(null);
		
		
		
		//JLabel
		
		JLabel lblToDoList = new JLabel("To Do Liste");
		lblToDoList.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblToDoList.setBounds(300, 10, 186, 65);
		frmTodoListe.getContentPane().add(lblToDoList);
		
		
		JButton btnNeuerEintrag = new JButton("Neuer Eintrag");
		btnNeuerEintrag.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNeuerEintrag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				NeuerEintrag.main(null);
			}
		});
		btnNeuerEintrag.setBounds(36, 511, 151, 31);
		frmTodoListe.getContentPane().add(btnNeuerEintrag);
		
		
		
		
		//Fenster mit To Do Liste
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 97, 697, 386);
		frmTodoListe.getContentPane().add(scrollPane);
		
		JLabel Eintraege = new JLabel("Einträge");
		Eintraege.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setColumnHeaderView(Eintraege);
		
		
		
		
		final int MAX = 10;
        String[] listElems = new String[MAX];			//	Beispielliste zum testen
        for (int i = 1; i < MAX; i++) {
            listElems[i] = "0"+i+".02.2022  Test Eintrag" ;
        }
		JList list = new JList(listElems);
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(list);
		
	            
		
		JButton btnErledigt = new JButton("erledigt");
		btnErledigt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				   String selectedElem = "";
	                int selectedIndices[] = list.getSelectedIndices();
	                for (int j = 0; j < selectedIndices.length; j++) {
	                    String elem =
	                            (String) list.getModel().getElementAt(selectedIndices[j]);
	                    selectedElem += "\n" + elem;
	                    
	                }
	                JOptionPane.showMessageDialog(null,"Du hast " + selectedElem+ " ausgewählt!");

			}
		});
		btnErledigt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnErledigt.setBounds(598, 511, 130, 31);
		frmTodoListe.getContentPane().add(btnErledigt);
	
	
	
		
	
	}
}
