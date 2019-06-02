package Telas;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Utils.Music;

public class MenuIniciar extends JFrame implements Runnable, MouseListener, ActionListener{
	private static final long serialVersionUID = 1L;

	int altTela;
	int larTela;
	JLabel fundo;
	
	JButton novoJogo;
	JButton carregarJogo;
	
	JButton escolherZero;
	JButton escolherGoku;
	
	public MenuIniciar() {
		inicializaComponentes();
	}

	JPanel escolherCampeao = new JPanel();
	private void inicializaComponentes() {
		setTitle("Jogo do Lol");

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setLayout(null);
		
		Toolkit kit = Toolkit.getDefaultToolkit();  
		Dimension tamTela = kit.getScreenSize();  

		larTela = tamTela.width;  
		altTela = tamTela.height;
		
		setPainelEscolherCampeoes();
		
		novoJogo = new JButton();
		novoJogo.setBounds((larTela-400)/2, 200, 400, 90);
		novoJogo.setFont(new Font("Arial", 70,70));
		novoJogo.setText("Novo Jogo");
		novoJogo.setContentAreaFilled(false);
		novoJogo.addActionListener(this);
		novoJogo.addMouseListener(this);
		add(novoJogo);

		carregarJogo = new JButton();
		carregarJogo.setBounds((larTela-400)/2, 300, 400, 90);
		carregarJogo.setFont(new Font("Arial", 70,70));
		carregarJogo.setText("Carregar Jogo");
		carregarJogo.setContentAreaFilled(false);
		carregarJogo.addActionListener(this);
		carregarJogo.addMouseListener(this);
		add(carregarJogo);

		ImageIcon icon = new ImageIcon(getClass().getResource("../Imagens/papeldeparede.png"));
		fundo = new JLabel();
		fundo.setBounds(0, 0, larTela, altTela);
		fundo.setIcon(new ImageIcon(icon.getImage().getScaledInstance(larTela, altTela, Image.SCALE_DEFAULT)));
		add(fundo);
		
		setVisible(true);
	}

	public void setPainelEscolherCampeoes() {
		escolherCampeao.setBounds((larTela-500)/2,(altTela-500)/2,500,500);
		escolherCampeao.setLayout(null);
		
		JLabel fundo = new JLabel();
		fundo.setSize(500,500);
		ImageIcon icon = new ImageIcon(getClass().getResource("../Imagens/fundoescolhercampeao.jpg"));
		fundo.setIcon(new ImageIcon(icon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));

		icon = new ImageIcon(getClass().getResource("../Imagens/MovimentacoesZero/rosto.png"));
		escolherZero = new JButton();
		escolherZero.setBounds(10,10,50,50);
		escolherZero.setIcon(new ImageIcon(icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		escolherZero.addActionListener(this);
		
		icon = new ImageIcon(getClass().getResource("../Imagens/Goku/rosto.png"));
		escolherGoku = new JButton();
		escolherGoku.setBounds(70,10,50,50);
		escolherGoku.setIcon(new ImageIcon(icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		escolherGoku.addActionListener(this);
		
		escolherCampeao.add(escolherZero);
		escolherCampeao.add(escolherGoku);
		escolherCampeao.add(fundo);

		escolherCampeao.setVisible(false);
		add(escolherCampeao);
	}

	@Override
	public void run() {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == novoJogo){
			new Thread(new Music(getClass().getResource("../Musicas/yourturn.mp3").getFile())).start();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == escolherZero){
			Fase1 fase1 = new Fase1(1);
			new Thread(fase1).start();
			setVisible(false);
		} else if (e.getSource() == novoJogo){
			escolherCampeao.setVisible(true);
		} else if( e.getSource() == escolherGoku){
			Fase1 fase1 = new Fase1(2);
			new Thread(fase1).start();
			setVisible(false);
		}
	}
	
}
