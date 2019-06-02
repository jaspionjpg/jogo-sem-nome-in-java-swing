package Telas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Classes.Campeao;
import Classes.Garen;
import Classes.Goku;
import Classes.Magiazinha;
import Classes.MinionMago;
import Classes.Monstro;
import Utils.Music;

public class Fase1 extends JFrame implements Runnable, KeyListener{
	private static final long serialVersionUID = 1L;
	int andando = 0;
	int larTela;
	int tamanhoTela;
	int altTela;
	Magiazinha magiazinha;
	Campeao campeao;
	Monstro[] monstros = new Monstro[1];
	List<JProgressBar> vidaMostros = new ArrayList<JProgressBar>();
	
	int[][] binariaParaFisica;
	JLabel derrota = new JLabel();
	JPanel chao;
	
	JProgressBar vida;
	JProgressBar mana;
	JProgressBar exp;
	
	public Fase1(int campeao) {
		inicializaComponentes(campeao);
	}

	private void inicializaComponentes(int campeao) {
		setTitle("Jogo do Lol");
		new Thread(new Music(getClass().getResource("../Musicas/Castlevania.mp3").getFile())).start();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setTamanhoTela(); 
		setLayout(null);
		
		addKeyListener(this);
		
		setCampeao(campeao);
		setVidaEMana();
		setChao();
		//setFundo();
		setVisible(true);
		
		new Thread(this.campeao).start();
		this.campeao.falaDeAbertura();
	}

	private void setDerrota() {
		try {
			int i = 1;
			while(i < 269){
				new Thread();
				Thread.sleep(15);
				ImageIcon icon = new ImageIcon(getClass().getResource("../Imagens/Derrota/"+i+".jpg"));
				derrota.setIcon(new ImageIcon(icon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
				i++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void setVidaEMana() {
		vida = new JProgressBar();
		vida.setMinimum(0);  
		vida.setMaximum(campeao.getVida().intValue());  
		vida.setValue(campeao.getVida().intValue());
		vida.setString(campeao.getVidaAtual().intValue()+" / "+campeao.getVida().intValue());
		vida.setStringPainted(true);
		vida.setBounds((larTela-300)/2,10,300,30);		
		add(vida);
		
		mana = new JProgressBar();
		mana.setMinimum(0);  
		mana.setMaximum(campeao.getMana().intValue());  
		mana.setValue(campeao.getMana().intValue());
		mana.setString(campeao.getManaAtual().intValue()+" / "+campeao.getMana().intValue());
		mana.setStringPainted(true);
		mana.setBounds((larTela-300)/2,50,300,30);		
		add(mana);
		
		exp = new JProgressBar(JProgressBar.VERTICAL);
		exp.setMinimum(0);  
		exp.setMaximum(100);  
		exp.setValue(campeao.getExp());
		exp.setBounds(10,10,30,100);		
		add(exp);
	}

	@Override
	public void run() {
		while(true){
			try {
				new Thread();
				Thread.sleep(40);
				atualizaVidaCampeao();
				atualizaVidaMonstros();
				
				if(andando == 3){
					if(campeao.getLocation().getX() > larTela * 0.55)
					chao.setLocation(
						(int) chao.getLocation().getX()-5, 
						(int) chao.getLocation().getY());
				}
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null, "Erro: Thead não pode prosseguir");
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		// Teclas de Locomoção
			// 1 == DIREITA
			// 2 == CIMA
			// 3 == ESQUERDA
			// 4 == BAIXO
			case 37:
				andando = 1;
				break;
			case 38:
				andando = 2;
				break;
			case 39:
				andando = 3;
				break;
			case 40:
				andando = 4;
				break;
			case 114:
				System.exit(1);
				break;	
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case 37:
				andando = 0;
				break;
			case 38:
				andando = 0;
				break;
			case 39:
				andando = 0;
				break;
			case 40:
				andando = 0;
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	public void setTamanhoTela() {
		Toolkit kit = Toolkit.getDefaultToolkit();  
		Dimension tamTela = kit.getScreenSize();  
		larTela = tamTela.width;
		tamanhoTela = 8000;  
		altTela = tamTela.height;
		
		binariaParaFisica = new int[tamanhoTela][altTela];
		preencheBinaria(0, altTela-70, tamanhoTela, 70,1);
	}
	
	private void setChao() {
		ImageIcon iconChao1 = new ImageIcon(getClass().getResource("../Imagens/Fase1/chao.png"));
		ImageIcon iconFundo = new ImageIcon(getClass().getResource("../Imagens/Fase1/fundo.jpg"));
		chao = new JPanel();
		chao.setSize(tamanhoTela,altTela);
		chao.setLayout(null);
		
		setInimigos();
		criaVidaMonstros();
		
		JLabel chao1 = new JLabel();
		chao1.setBounds(0, altTela-80, tamanhoTela, 80);
		chao1.setIcon(new ImageIcon(iconChao1.getImage().getScaledInstance(tamanhoTela, 80, Image.SCALE_DEFAULT)));
		
		JLabel fundo = new JLabel();
		fundo.setBounds(0, 0, tamanhoTela, altTela);
		fundo.setIcon(new ImageIcon(iconFundo.getImage().getScaledInstance(tamanhoTela, altTela, Image.SCALE_DEFAULT)));
		add(fundo);
		
		chao.add(chao1);
		chao.add(fundo);
		
		add(chao);
	}
	
	private void preencheBinaria(int x, int y, int lar, int alt, int tipoBinaria){
		for(int i = x; i < x + lar; i++){
			for(int j = y; j < y + alt; j++){
				binariaParaFisica[i][j] = tipoBinaria;
			}
		}
	}
	
	private void setCampeao(int c) {
		if(c == 1){
			campeao = new Garen(300, altTela-200,altTela,larTela,binariaParaFisica, monstros, this);
			addKeyListener(campeao);
			add(campeao);
		} else
		if(c == 2){
			campeao = new Goku(300, altTela-200,altTela,larTela,binariaParaFisica, monstros, this);
			addKeyListener(campeao);
			add(campeao);
		}
	}

	private void setInimigos() {
		derrota.setBounds((larTela - 500) / 2, (altTela - 500) / 2, 500,500);
		add(derrota);

		monstros[0] = new MinionMago(campeao, altTela,larTela, this);
		new Thread(monstros[0]).start();
		add(monstros[0]);
	}
	
	public void atualizaVidaCampeao(){
		vida.setValue(campeao.getVidaAtual().intValue());
		vida.setString(campeao.getVidaAtual().intValue()+" / "+campeao.getVida().intValue());
		exp.setValue(campeao.getExp());
		if(campeao.getVidaAtual().intValue() < 1){
			setDerrota();
			setVisible(false);
		}
	}
	
	public void atualizaVidaMonstros(){
		if(monstros[0].getVivo() == 1){
			vidaMostros.get(0).setValue(monstros[0].getVidaAtual().intValue());
			vidaMostros.get(0).setString(monstros[0].getVidaAtual().intValue()+" / "+monstros[0].getVida().intValue());
		} else { 
			vidaMostros.get(0).setVisible(false);
		}
	}

	private void criaVidaMonstros() {
		vidaMostros.add(new JProgressBar());
		vidaMostros.get(0).setMinimum(0);  
		vidaMostros.get(0).setMaximum(monstros[0].getVida().intValue());  
		vidaMostros.get(0).setValue(monstros[0].getVida().intValue());
		vidaMostros.get(0).setString(monstros[0].getVidaAtual().intValue()+" / "+monstros[0].getVida().intValue());
		vidaMostros.get(0).setStringPainted(true);
		vidaMostros.get(0).setBounds((int)(monstros[0].getLocation().getX()-30),(int)(monstros[0].getLocation().getY()-30),100,30);		
		chao.add(vidaMostros.get(0));
	}
}
