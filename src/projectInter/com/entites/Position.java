package projectInter.com.entites;


public class Position  // classe auxiliar para gerenciar posição da matriz (linha e coluna)
{
	private int Line;  // atributo linha
	private int Column;  // atributo coluna
	
	
	// construtor que pode ser instânciado vazio
	public Position() {}
	
	
	// construtor (quando a classe instânciada recebe a linha e coluna)
	public Position(int line, int column) 
	{
		this.Line = line;
		this.Column = column;
	}
	
	
	// método de obter linha
	public int getLine() 
	{
		// retorne a linha
		return this.Line;
	}
	
	
	// método de obter coluna
	public int getColumn() 
	{
		// retorne a coluna
		return this.Column;
	}
	
	
	// método de inserir linha
	public void setLine(int value) 
	{
		// o atributo linha recebe o valor
		this.Line = value;
	}
	
	
	// método de inserir coluna
	public void setColumn(int value) 
	{
		// o atributo coluna recebe o valor
		this.Column = value;
	}
}
