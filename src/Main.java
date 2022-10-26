import java.util.ArrayList;

public class Main {


    //CONSIDERACOES
    /*A temperatura no interior da chapa,  seja a média dos seus quatro vizinhos
    O "erro" a cada iteração será o maior valor absoluto da diferença das temperaturas da chapa entre
    duas etapas consecutivas.

    "erro máximo aceitável" é o maior "erro" (entre etapas consecutivas) que o programa aceita como equilíbrio térmico
    (erros maiores que esse indicam que a chapa ainda não entrou em equilíbrio térmico).

     "erro máximo aceitável", pode-se usar valores double do tipo 1e-n, onde n é um número inteiro.
     */

    final static int ERRO_MAXIMO = 2;
    static int iteracoes = 0;

    public static void main(String[] args) {


        ArrayList<Double> primeiroQuadrante = new ArrayList<>();
        primeiroQuadrante.add(100.00);
        primeiroQuadrante.add(-3.00);
        primeiroQuadrante.add(20.00);
        primeiroQuadrante.add(20.00);
        int tempAbsoluta;
        double tempMedia1 = getTemperaturaMedia(primeiroQuadrante);
        System.out.println(tempMedia1);
        do {
            ArrayList<Double> segundoQuadrante = getProximoPonto(tempMedia1, primeiroQuadrante);
            double tempMedia2 = getTemperaturaMedia(segundoQuadrante);

            System.out.println(segundoQuadrante);

            tempAbsoluta = getErro(tempMedia1, tempMedia2);
            primeiroQuadrante = segundoQuadrante;
            iteracoes = iteracoes+1;
            System.out.println("numero de iteracoes: " + iteracoes);
        }while (tempAbsoluta>ERRO_MAXIMO);
    }

    public static double getTemperaturaMedia(ArrayList<Double> quadrante){
        double ponto1 = quadrante.get(0);
        double ponto2 = quadrante.get(1);
        double ponto3 = quadrante.get(2);
        double ponto4 = quadrante.get(3);
        double tempMedia = (ponto1+ponto2+ponto3+ponto4)/4;
        return tempMedia;
    }

    public static ArrayList<Double> getProximoPonto(double tempMedia, ArrayList<Double> primeiroQuadrante){
        ArrayList<Double> segundoQuadrante = new ArrayList<>();
        segundoQuadrante.add(Math.abs(tempMedia-primeiroQuadrante.get(0)));
        segundoQuadrante.add(Math.abs(tempMedia-primeiroQuadrante.get(1)));
        segundoQuadrante.add(Math.abs(tempMedia-primeiroQuadrante.get(2)));
        segundoQuadrante.add(Math.abs(tempMedia-primeiroQuadrante.get(3)));
        return segundoQuadrante;
    }

    public static int getErro(double tempMediaPrimeiroQuadrante, double tempMediaSegundoQuadrante){
        int tempAbsoluta = (int) Math.abs(tempMediaPrimeiroQuadrante-tempMediaSegundoQuadrante);
        System.out.println("Temp absoluta: "+tempAbsoluta);
        return tempAbsoluta;
    }
}