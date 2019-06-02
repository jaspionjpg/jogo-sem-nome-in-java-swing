package Classes;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Monstro extends JLabel implements Runnable{
	private static final long serialVersionUID = 1L;
	
	int altTela;
	int larTela;
	int vivo = 1;
	
	JFrame chao;
	
	Campeao campeao;
	
	Double vidaAtual;
	Double manaAtual; 
			
	Double vida;
	Double mana;
	Double regeneracaoVida;
	Double regeneracaoMana;
	
	Double dano;
	Double danoMagico;
	Double armadura;
	Double resistenciaMagica;
	Double velocidadeAtaque;

	Integer critico;
	Integer expMonstro;
	Integer level = 1;
		
	List<Item> itens;
	
	public void sofrerDano(Double dano){
	}
	
	@Override
	public void run() {
	}

	public int getAltTela() {
		return altTela;
	}


	public void setAltTela(int altTela) {
		this.altTela = altTela;
	}


	public int getLarTela() {
		return larTela;
	}


	public void setLarTela(int larTela) {
		this.larTela = larTela;
	}


	public int getVivo() {
		return vivo;
	}


	public void setVivo(int vivo) {
		this.vivo = vivo;
	}


	public Campeao getCampeao() {
		return campeao;
	}


	public void setCampeao(Campeao campeao) {
		this.campeao = campeao;
	}


	public Double getVidaAtual() {
		return vidaAtual;
	}


	public void setVidaAtual(Double vidaAtual) {
		this.vidaAtual = vidaAtual;
	}


	public Double getManaAtual() {
		return manaAtual;
	}


	public void setManaAtual(Double manaAtual) {
		this.manaAtual = manaAtual;
	}


	public Double getVida() {
		return vida;
	}


	public void setVida(Double vida) {
		this.vida = vida;
	}


	public Double getMana() {
		return mana;
	}


	public void setMana(Double mana) {
		this.mana = mana;
	}


	public Double getRegeneracaoVida() {
		return regeneracaoVida;
	}


	public void setRegeneracaoVida(Double regeneracaoVida) {
		this.regeneracaoVida = regeneracaoVida;
	}


	public Double getRegeneracaoMana() {
		return regeneracaoMana;
	}


	public void setRegeneracaoMana(Double regeneracaoMana) {
		this.regeneracaoMana = regeneracaoMana;
	}


	public Double getDano() {
		return dano;
	}


	public void setDano(Double dano) {
		this.dano = dano;
	}


	public Double getDanoMagico() {
		return danoMagico;
	}


	public void setDanoMagico(Double danoMagico) {
		this.danoMagico = danoMagico;
	}


	public Double getArmadura() {
		return armadura;
	}


	public void setArmadura(Double armadura) {
		this.armadura = armadura;
	}


	public Double getResistenciaMagica() {
		return resistenciaMagica;
	}


	public void setResistenciaMagica(Double resistenciaMagica) {
		this.resistenciaMagica = resistenciaMagica;
	}


	public Double getVelocidadeAtaque() {
		return velocidadeAtaque;
	}


	public void setVelocidadeAtaque(Double velocidadeAtaque) {
		this.velocidadeAtaque = velocidadeAtaque;
	}


	public Integer getCritico() {
		return critico;
	}


	public void setCritico(Integer critico) {
		this.critico = critico;
	}


	public Integer getLevel() {
		return level;
	}


	public void setLevel(Integer level) {
		this.level = level;
	}


	public List<Item> getItens() {
		return itens;
	}


	public void setItens(List<Item> itens) {
		this.itens = itens;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getExpMonstro() {
		return expMonstro;
	}

	public void setExpMonstro(Integer expMonstro) {
		this.expMonstro = expMonstro;
	}
}
