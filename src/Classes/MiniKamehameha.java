package Classes;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MiniKamehameha  extends JLabel implements Runnable{
private static final long serialVersionUID = 1L;
	Monstro[] monstros;
	Double dano;
	Campeao campeao;

	public MiniKamehameha(Monstro[] monstros,int x,int y, Double dano, Campeao campeao) {
		this.monstros  = monstros;
		this.dano = dano;
		this.campeao = campeao;
		setBounds(x, y, 51, 28);
		ImageIcon icone = new ImageIcon(getClass().getResource("../Imagens/Goku/minikamehameha/rajada.png"));
		setIcon(new ImageIcon(icone.getImage().getScaledInstance(51, 28, Image.SCALE_DEFAULT)));
	}
	
	@Override
	public void run() {
		while(true){
			try {
				new Thread();
				Thread.sleep(20);
				Boolean pegouNoMostro = false;
				
				for(int i = 0 ; i < monstros.length ; i ++){
					if((monstros[i].getLocation().getX() <= getLocation().getX()+51 && monstros[i].getLocation().getX()+ 45 >= getLocation().getX()+51)
					 && (monstros[i].getLocation().getY() <= getLocation().getY()+28 && monstros[i].getLocation().getY()+ 75 >= getLocation().getY()+28)){
						if(monstros[i].getVivo() == 1){
							monstros[i].sofrerDano(dano);
							pegouNoMostro = true;
							if(monstros[i].getVivo() == 0){
								campeao.exp += monstros[i].getExpMonstro();
								if(campeao.exp >= 100){
									campeao.newLevel();
									campeao.level++;
								}
							}
							break;
						}
					}
				}

				if(pegouNoMostro){
					setVisible(false);
					break;
				} else {
					setLocation(
						(int) getLocation().getX()+5, 
						(int) getLocation().getY());
				}
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null, "Erro: Thead não pode prosseguir");
			}
		}
	}
}
