package projectInter.com.main;
import projectInter.com.entites.ManipArray;
import projectInter.com.entites.Position;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main  // classe de execução
{

	public static void main(String[] args)  // método que deixa a classe executável
	{
		Position position;
		// instanciando a classe scanner
		Scanner objS = new Scanner(System.in);
		
		// tente executar
		try 
		{
			System.out.print("Digite a quantidade de linhas da matriz: ");
			int line = objS.nextInt();  // ler a quantidade de linhas
			System.out.print("Digite a quantidade de colunas da matriz: ");
			int column = objS.nextInt();  // ler a quantidade de colunas
			System.out.println();
			// instânciando a classe de gerenciamento da matriz e passando a quantidade de linhas e colunas
			ManipArray objArray = new ManipArray(new Position(line, column));
			
			System.out.println("Deseja preencher a matriz manualmente ou automáticamente(valores aleatórios)? ");
			System.out.print("Digite 'M' para preencher manualmente ou 'A' para preencher automáticamente: ");
			String option = objS.next().toUpperCase();  // opção desejada pelo usuário
			
			
			switch (option) {
			// caso option seja "M"
			case "M":
				// percorre as linhas
				for (int l = 0; l < line; l ++) 
				{
					// percorre as colunas
					for (int c = 0; c < column; c ++) 
					{
						System.out.print("Digite o valor que será inserido, linha " + (l+1) + " coluna " + (c+1) + ": ");
						int value = objS.nextInt();  // lendo o valor que será inserido
						
						// chama o método de inserir valor manualmente (recebe uma posição(linha e coluna) e o valor que será inserido)
						objArray.insertValueArrayManual(new Position(l, c), value);
					}
				}
				break;
			
			// caso option seja "A"
			case "A":
				// chama o método que preenche a matriz automaticamente com valores aleatórios
				objArray.insertValueRandomArray();
				break;
			
			// caso não seja nenhuma das duas
			default:
				// levante uma exceção
				throw new InputMismatchException("Necessário digitar 'M' para manual ou 'A' para automático. Tente novamente.");
			}
			
			System.out.println();
			// chamando o método de impressão da matriz
			objArray.printArray();
			System.out.println();
			
			System.out.print("Digite o valor para saber se está presente na matriz: ");
			// lendo um valor para saber se está presente na matriz
			int value = objS.nextInt();
			
			System.out.println();
			// chamando o método para saber se o valor está presente na matriz
			objArray.findValueArray(value);
		}
		catch (InputMismatchException erro)  // caso encontre um erro de entrada
		{
			System.out.println();
			// informe a mensagem
			System.out.println("Error: Necessário digitar um número inteiro. Tente novamente.");
		}

	}

}
