package projectInter.com.entites;
import java.util.Random;


public class ManipArray  // classe de manipulação de matriz
{
	private int[][] Array;  // matriz
	private Position Pos;
	private boolean Present = false;  // atributo para checar valor presente na matriz
	
	
	// construtor da classe (quando instânciada recebe a quantidade de linhas e colunas que a matriz terá, e logo em seguida, cria uma matriz)
	public ManipArray(Position position)
	{
		this.Pos = new Position(position.getLine(), position.getColumn());
		this.Array = new int[position.getLine()][position.getColumn()];
	}
	
	
	// método responsável por preencher a matriz com valores aletórios
	public void insertValueRandomArray() 
	{
		// instanciando a classe para gerar número aleatórios
		Random generator = new Random();
		// percorre as linhas da matriz
		for (int l = 0; l < this.Pos.getLine(); l++) 
		{
			// percorre as colunas da matriz
			for (int c = 0; c < this.Pos.getColumn(); c++) 
			{
				// insira em Array[linha][coluna] = um valor aleatório entre 0 e 100
				this.Array[l][c] = generator.nextInt(0, 100);
			}
		}
	}
	
	
	// método de inserir valor na matriz MANUALMENTE (recebe uma Posição (linha e coluna) na posição que será inserida e o valor que será inserido)
	public void insertValueArrayManual(Position position, int value) 
	{
		// insira em Array[linha][coluna] = o devido valor
		this.Array[position.getLine()][position.getColumn()] = value;
	}
	
	
	// método de impressão da matriz para que o usuário possa visualizar
	public void printArray() 
	{
		// percorre linhas da matriz
		for (int l = 0; l < this.Pos.getLine(); l ++)
		{
			// percorre colunas da matriz
			for (int c = 0; c < this.Pos.getColumn(); c++)
			{
				// se a coluna for igual a quantidade de colunas - 1
				if (!(c == this.Pos.getColumn() - 1)) {
					// imprima na mesma linha e com espaço
					System.out.print(this.Array[l][c] + " ");
				}
				else // caso contrário
				{
					// imprima e pula linha
					System.out.println(this.Array[l][c]);
				}
			}
		}
	}
	
	
	// método que checa se o valor digitado pelo usuário está presente na matriz
	public void findValueArray(int wantedValue) 
	{
		// variáveis que armazena a posição que o valor estará
		Position position = new Position();
		// percorre linhas da matriz
		for (int l = 0; l < this.Pos.getLine(); l++) 
		{
			// percorre colunas da matriz
			for (int c = 0; c < this.Pos.getColumn(); c++) 
			{
				// se o valor que estiver na posição array[linha][coluna] for igual ao valor digitado pelo usuário
				if (this.Array[l][c] == wantedValue) 
				{
					Present = true;  // modifica o atributo para true
					position.setLine(l+1);;  // guarda linha que o valor estiver
					position.setColumn(c+1);;  // guarda coluna que o valor estiver
					break;  // termina o laço
				}
			}
		}
		
		this.getMessage(wantedValue, position);
	}
	
	
	// método privado (utilizando no método "findValueArray") de exibição de valor presente na matriz (recebe como parâmetro o valor, a linha e a coluna)
	private void getMessage(int value, Position position) 
	{
		if (!Present)  // se o atributo NÃO for verdadeiro
		{
			// mostre a seguinte mensagem
			System.out.println("O número " + value + " NÃO está presente na matriz.");
		}
		else  // caso contrário
		{
			// mostre a seguinte mensagem
			System.out.println("O número " + value + " ESTÁ presente na matriz. Posição: LINHA " + position.getLine() + " COLUNA " + position.getColumn() + ". ");
		}
	}
}
