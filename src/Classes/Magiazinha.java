package Classes;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Magiazinha  extends JLabel implements Runnable{
private static final long serialVersionUID = 1L;
	Campeao campeao;
	Double dano;

	public Magiazinha(Campeao campeao,int x,int y, Double dano) {
		this.campeao  = campeao;
		this.dano = dano;
		setOpaque(true);
		setBackground(Color.RED);
		setBounds(x, y, 10, 10);
	}
	
	@Override
	public void run() {
		while(true){
			try {
				new Thread();
				Thread.sleep(40);
				
				if((campeao.getLocation().getX() <= getLocation().getX()-10 && campeao.getLocation().getX()+ 85 >= getLocation().getX()+10)
					&& (campeao.getLocation().getY() <= getLocation().getY()-10 && campeao.getLocation().getY()+ 130 >= getLocation().getY()+10)){
					campeao.setVidaAtual(campeao.getVidaAtual()-dano);
					setVisible(false);
					break;
				}
				else{
				setLocation(
					(int) getLocation().getX()-5, 
					(int) getLocation().getY());
				}
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null, "Erro: Thead não pode prosseguir");
			}
		}
	}
	
	public Campeao getCampeao() {
		return campeao;
	}

	public void setCampeao(Campeao campeao) {
		this.campeao = campeao;
	}
}
