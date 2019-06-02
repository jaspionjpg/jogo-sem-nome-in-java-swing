package Classes;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MinionMago extends Monstro  {
	private static final long serialVersionUID = 1L;
	int andando = 0;
	
	public MinionMago(Campeao campeao, int altTela, int larTela, JFrame chao) {
		this.altTela = altTela;
		this.larTela = larTela;
		this.chao = chao;
		this.campeao = campeao;
		
		setBounds(900, altTela-140, 40, 70);
		ImageIcon icon = new ImageIcon(getClass().getResource("../Imagens/MinionMago/1.png"));
		setIcon(new ImageIcon(icon.getImage().getScaledInstance(40, 70, Image.SCALE_DEFAULT)));
		comecaStatus();
	}
	
	public void sofrerDano(Double dano){
		vidaAtual -= dano;
		if(vidaAtual < 1){
			vivo = 0;
			setVisible(false);
		}
	}
	
	private void comecaStatus() {
		this.expMonstro = 14;
		this.vida = 200d;
		this.vidaAtual = this.vida;
		this.regeneracaoVida = 7.84;
		this.mana = 0d;
		this.manaAtual = this.mana;
		this.regeneracaoMana = 0d;

		this.dano = 0d;
		this.danoMagico = 130d;
		this.armadura = 27.536; 
		this.resistenciaMagica = 32.1;
		this.velocidadeAtaque = 0.625;
		
		this.critico = 0;
	}
	
	public void soltarMagia(){
		Magiazinha magiazinhapoder = new Magiazinha(campeao,(int) getLocation().getX(),(int) getLocation().getY()+20, getDanoMagico());
		chao.add(magiazinhapoder,1);
		new Thread(magiazinhapoder).start();
	}
	
	@Override
	public void run() {
		int magiazinha = 0;
		while(true){
			try {
				new Thread();
				Thread.sleep(40);
				magiazinha++;
				if(magiazinha > 70){
					magiazinha = 0;
					if(getVivo() == 1){
						soltarMagia();
					}
				}
		
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null, "Erro: Thead não pode prosseguir");
			}
		}
	}

	
}
