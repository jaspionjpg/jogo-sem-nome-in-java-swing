package Classes;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Utils.Music;

public class Garen extends Campeao {
	private static final long serialVersionUID = 1L;
	
	public Garen(int x, int y, int altTela,int larTela, int[][] chaoBinario, Monstro[] monstros, JFrame chao) {
		this.chao = chao;
		this.altTela = altTela;
		this.larTela = larTela;
		this.chaoBinario = chaoBinario;
		this.xPersonagemBinario = x;
		this.yPersonagemBinario = y;
		this.monstros = monstros;
		
		setBounds(x, y, 80, 130);
		ImageIcon icon = new ImageIcon(getClass().getResource("../Imagens/MovimentacoesZero/andar/1.png"));
		setIcon(new ImageIcon(icon.getImage().getScaledInstance(80, 130, Image.SCALE_DEFAULT)));
		
		comecaStatus();
	}
	public void falaDeAbertura(){
		new Thread(new Music(getClass().getResource("../Musicas/Garen.mp3").getFile())).start();
	}
	private void comecaStatus() {
		
		this.vida = 616.28;
		this.vidaAtual = this.vida;
		this.regeneracaoVida = 7.84;
		this.mana = 0d;
		this.manaAtual = this.mana;
		this.regeneracaoMana = 0d;

		this.dano = 57.88;
		this.danoMagico = 0d;
		this.armadura = 27.536; 
		this.resistenciaMagica = 32.1;
		this.velocidadeAtaque = 0.625;
		
		this.critico = 0;
	}
	
	public void newLevel(){
		this.vida += 84.25;
		this.regeneracaoVida += +0.5;

		this.dano += 4.5;
		this.armadura += 3; 
		this.resistenciaMagica += 1.25;
		this.velocidadeAtaque += 0.0029;
		
		this.critico += 0;
	}
	
	@Override
	public void run() {
		int andar = 1;
		int pulo = 0;
		while(true){	
			
			try {
				new Thread();
				Thread.sleep(40);
				
				if(andando == 1){
					if(chaoBinario[xPersonagemBinario+85][yPersonagemBinario] != 1){
						if(getLocation().getX()+5 > 10){
							setLocation(
							(int) getLocation().getX()-5, 
							(int) getLocation().getY());
							xPersonagemBinario -= 5;
						}
						andar++;
						ImageIcon icon = new ImageIcon(getClass().getResource("../Imagens/MovimentacoesZero/voltar/"+andar+".png"));
						setIcon(new ImageIcon(icon.getImage().getScaledInstance(80, 130, Image.SCALE_DEFAULT)));
						if(andar == 13){
							andar = 0;
						}
					}
				}
				if(andando == 2 && pulo < 2){
					pular();
					pulo++;
				}
				if(andando == 3){
					if(chaoBinario[xPersonagemBinario-5][yPersonagemBinario] != 1){
						if(getLocation().getX()+5 < larTela * 0.65){
						setLocation(
							(int) getLocation().getX()+5, 
							(int) getLocation().getY());
							xPersonagemBinario += 5;
						}
						andar++;
						ImageIcon icon = new ImageIcon(getClass().getResource("../Imagens/MovimentacoesZero/andar/"+andar+".png"));
						setIcon(new ImageIcon(icon.getImage().getScaledInstance(80, 130, Image.SCALE_DEFAULT)));
						if(andar == 13){
							andar = 0;
						}
					}
				}
				
				if(chaoBinario[xPersonagemBinario][yPersonagemBinario+135] != 1){
					if(yPersonagemBinario + 5 < altTela)
						setLocation(
							(int) getLocation().getX(), 
							(int) getLocation().getY()+5);
						yPersonagemBinario += 5;
				} else {
					pulo = 0;
				}
				
				if(andando == 9){
					atacar();
				}
				
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null, "Erro: Thead não pode prosseguir");
			}
		}
	}
	
	public void usarQ() throws InterruptedException{
	}
	
	public void usarW() throws InterruptedException{
	}
	
	public void usarE() throws InterruptedException{
	}
	
	public void usarR() throws InterruptedException{
	}
	
	public void checaSeExisteMonstroETiraDano(){
		for(int i = 0 ; i < monstros.length ; i ++){
			if((monstros[i].getLocation().getX() <= getLocation().getX()+140 && monstros[i].getLocation().getX()+45 >= getLocation().getX()-60)
					&& (monstros[i].getLocation().getY() <= getLocation().getY()+130 && monstros[i].getLocation().getY()+ 75 >= getLocation().getY()-130)){
				monstros[i].sofrerDano(dano);
				if(monstros[i].getVivo() == 0){
				exp += monstros[i].getExpMonstro();
					if(exp >= 100){
						newLevel();
						level++;
					}
				}
			}
		}
	}
	
	public void atacar() throws InterruptedException{
			int i = 0;
			checaSeExisteMonstroETiraDano();
			while(i < 13){
				i++;
				new Thread();
				Thread.sleep(60);
				if(i > 3 && i < 12){
					setSize(140,130);
					ImageIcon icon = new ImageIcon(getClass().getResource("../Imagens/MovimentacoesZero/atacar/"+i+".png"));
					setIcon(new ImageIcon(icon.getImage().getScaledInstance(140, 130, Image.SCALE_DEFAULT)));
				} else {
					ImageIcon icon = new ImageIcon(getClass().getResource("../Imagens/MovimentacoesZero/atacar/"+i+".png"));
					setIcon(new ImageIcon(icon.getImage().getScaledInstance(80, 130, Image.SCALE_DEFAULT)));
				}
			}
			ImageIcon icone = new ImageIcon(getClass().getResource("../Imagens/MovimentacoesZero/pular/7.png"));
			setIcon(new ImageIcon(icone.getImage().getScaledInstance(80, 130, Image.SCALE_DEFAULT)));
	}
	
	public void pular() throws InterruptedException{
		int i = 0;
		int trocar = 1;
		while(i < 25 && yPersonagemBinario > 10){
			new Thread();
			Thread.sleep(15);
			if(i % 5 == 0){
				trocar++;
			}
			i++;
			ImageIcon icon = new ImageIcon(getClass().getResource("../Imagens/MovimentacoesZero/pular/"+trocar+".png"));
			setIcon(new ImageIcon(icon.getImage().getScaledInstance(80, 130, Image.SCALE_DEFAULT)));
			setLocation(
				(int) getLocation().getX(), 
				(int) getLocation().getY()-5);
			yPersonagemBinario -= 5;
		}
		ImageIcon icone = new ImageIcon(getClass().getResource("../Imagens/MovimentacoesZero/pular/7.png"));
		setIcon(new ImageIcon(icone.getImage().getScaledInstance(80, 130, Image.SCALE_DEFAULT)));
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		// Teclas de Locomoção
			// 1 == ESQUERDA
			// 2 == CIMA
			// 3 == DIREITA
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
		// Teclas de Habilidades
			// 5 == Q
			// 6 == W
			// 7 == E
			// 8 == R
			// 9 == A
			case 81:
				andando = 5;
				break;
			case 87:
				andando = 6;
				break;
			case 69:
				andando = 7;
				break;
			case 82:
				andando = 8;
				break;
			case 65:
				andando = 9;
				break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		ImageIcon icon;
		switch (e.getKeyCode()) {
			case 37:
				andando = 0;
				icon = new ImageIcon(getClass().getResource("../Imagens/MovimentacoesZero/andar/"+1+".png"));
				setIcon(new ImageIcon(icon.getImage().getScaledInstance(80, 130, Image.SCALE_DEFAULT)));
				break;
			case 38:
				andando = 0;
				break;
			case 39:
				andando = 0;
				icon = new ImageIcon(getClass().getResource("../Imagens/MovimentacoesZero/andar/"+1+".png"));
				setIcon(new ImageIcon(icon.getImage().getScaledInstance(80, 130, Image.SCALE_DEFAULT)));
				break;
			case 65:
				andando = 0;
				break;
		}
	}
}
