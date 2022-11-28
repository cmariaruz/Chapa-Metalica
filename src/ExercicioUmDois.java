
public class ExercicioUmDois {


    //CONSIDERACOES
    /*A temperatura no interior da chapa,  seja a média dos seus quatro vizinhos
    O "erro" a cada iteração será o maior valor absoluto da diferença das temperaturas da chapa entre
    duas etapas consecutivas.

    "erro máximo aceitável" é o maior "erro" (entre etapas consecutivas) que o programa aceita como equilíbrio térmico
    (erros maiores que esse indicam que a chapa ainda não entrou em equilíbrio térmico).

     "erro máximo aceitável", pode-se usar valores double do tipo 1e-n, onde n é um número inteiro.
     */

    final static double ERRO_MAXIMO = 0.25;
    final static int ITERACOES_MAXIMAS = 10;
    static int iteracoes = 0;

    public static void main(String[] args) {

        ChapaMetalica primeiroQuadrante = new ChapaMetalica(20,20,100,-3);


        double tempAbsoluta;

        do {
            double tempMedia1 = primeiroQuadrante.getTemperaturaMedia(primeiroQuadrante);
            ChapaMetalica segundoQuadrante = primeiroQuadrante.getProximoPonto(tempMedia1, primeiroQuadrante);
            double tempMedia2 = segundoQuadrante.getTemperaturaMedia(segundoQuadrante);
            tempAbsoluta = getErro(tempMedia1, tempMedia2);
            primeiroQuadrante = segundoQuadrante;
            iteracoes = iteracoes+1;
           System.out.println("numero de iteracoes: " + iteracoes);
        }while (tempAbsoluta>ERRO_MAXIMO && iteracoes<ITERACOES_MAXIMAS);
    }

    public static double getErro(double tempMediaPrimeiroQuadrante, double tempMediaSegundoQuadrante){
        double tempAbsoluta = Math.abs(tempMediaPrimeiroQuadrante-tempMediaSegundoQuadrante);
        System.out.println("Temp absoluta: "+tempAbsoluta);
        return tempAbsoluta;
    }




}