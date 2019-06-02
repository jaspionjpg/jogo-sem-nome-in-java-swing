package Classes;

public class Item {
	
	private Long codItem;
	private String nomeItem;
	private String descricaoItem;
	private String imagemItem;
	private Double precoItem;

	public Long getCodItem() {
		return codItem;
	}

	public void setCodItem(Long codItem) {
		this.codItem = codItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	public Double getPrecoItem() {
		return precoItem;
	}

	public void setPrecoItem(Double precoItem) {
		this.precoItem = precoItem;
	}

	public String getImagemItem() {
		return imagemItem;
	}

	public void setImagemItem(String imagemItem) {
		this.imagemItem = imagemItem;
	}
}
