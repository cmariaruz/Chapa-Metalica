import java.nio.file.LinkPermission;
import java.util.Scanner;

public class ExercicioTres {
    final static double ERRO_MAXIMO = 0;
    final static int ITERACOES_MAXIMAS = 100;
    static int iteracoes = 0;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int qtdLinhas;
        int qtdColunas;
        double primeiraLinha;
        double ultimaLinha;
        double primeiraColuna;
        double ultimaColuna;
        System.out.println("Qual o tamanho da chapa?");
        System.out.println("Quantidade de linhas:");
        qtdLinhas = input.nextInt();
        System.out.println("Quantidade de colunas:");
        qtdColunas = input.nextInt();

        System.out.println("Qual a temperatura de cada lado da chapa?");
        System.out.print("Primeira linha:");
        primeiraLinha = input.nextDouble();
        System.out.print("Primeira coluna:");
        primeiraColuna = input.nextDouble();
        System.out.print("Ultima linha:");
        ultimaLinha = input.nextDouble();
        System.out.print("Ultima coluna:");
        ultimaColuna = input.nextDouble();

        ChapaMetalica primeiroQuadrante = new ChapaMetalica(qtdLinhas, qtdColunas, primeiraLinha,ultimaLinha,primeiraColuna,ultimaColuna);

        double tempAbsoluta;

        do {
            double tempMedia1 = primeiroQuadrante.getTemperaturaMedia(primeiroQuadrante);
            ChapaMetalica segundoQuadrante = primeiroQuadrante.getProximoPonto(tempMedia1, primeiroQuadrante);
            double tempMedia2 = segundoQuadrante.getTemperaturaMedia(segundoQuadrante);
            tempAbsoluta = getErro(tempMedia1, tempMedia2);
            primeiroQuadrante = segundoQuadrante;
            iteracoes = iteracoes+1;
            System.out.println("numero de iteracoes: " + iteracoes);
        }while (tempAbsoluta>ERRO_MAXIMO);
    }

    public static double getErro(double tempMediaPrimeiroQuadrante, double tempMediaSegundoQuadrante){
        double tempAbsoluta = Math.abs(tempMediaPrimeiroQuadrante-tempMediaSegundoQuadrante);
        System.out.println("Temp absoluta: "+tempAbsoluta);
        return tempAbsoluta;
    }
}
