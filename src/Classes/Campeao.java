package Classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Campeao extends JLabel implements Runnable, KeyListener{
	private static final long serialVersionUID = 1L;
	JFrame chao;
	int altTela;
	int larTela;
	int andando = 0;
	int exp = 0;
	ImageIcon icon;
	
	int[][] chaoBinario;
	int xPersonagemBinario;
	int yPersonagemBinario;
	
	Monstro[] monstros;
	
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
	Integer level = 1;
		
	List<Item> itens;
	
	public Campeao() {
	}
	
	public void newLevel(){
	}
	
	@Override
	public void run() {
	}
	
	public void falaDeAbertura(){
	}

	public void usarQ() throws InterruptedException{
	}
	
	public void usarW() throws InterruptedException{
	}
	
	public void usarE() throws InterruptedException{
	}
	
	public void usarR() throws InterruptedException{
	}
	
	public void atacar() throws InterruptedException{
	}
	
	public void pular() throws InterruptedException{
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
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

	public int getAndando() {
		return andando;
	}

	public void setAndando(int andando) {
		this.andando = andando;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
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
}
