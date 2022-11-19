import java.util.ArrayList;

public class ChapaMetalica {

    double valorLinha1;
    double valorLinhaN;
    double valorColuna1;
    double valorColunaN;


    public double getValorLinha1() {
        return valorLinha1;
    }

    public void setValorLinha1(double valorLinha1) {
        this.valorLinha1 = valorLinha1;
    }

    public double getValorLinhaN() {
        return valorLinhaN;
    }

    public void setValorLinhaN(double valorLinhaN) {
        this.valorLinhaN = valorLinhaN;
    }

    public double getValorColuna1() {
        return valorColuna1;
    }

    public void setValorColuna1(double valorColuna1) {
        this.valorColuna1 = valorColuna1;
    }

    public double getValorColunaN() {
        return valorColunaN;
    }

    public void setValorColunaN(double valorColunaN) {
        this.valorColunaN = valorColunaN;
    }

    public ChapaMetalica(double valorLinha1, double valorLinhaN, double valorColuna1, double valorColunaN){

        ArrayList<Double> quadrante =new ArrayList<>();
        this.valorLinha1 = valorLinha1;
        this.valorLinhaN = valorLinhaN;
        this.valorColuna1 = valorColuna1;
        this.valorColunaN = valorColunaN;
        quadrante.add(this.valorLinha1);
        quadrante.add(this.valorLinhaN);
        quadrante.add(this.valorColuna1);
        quadrante.add(this.valorColunaN);

    }

    public ChapaMetalica(int qtdLinhas, int qtdColunas,double valorLinha1, double valorLinhaN, double valorColuna1, double valorColunaN){
        double [][] chapa = new double[qtdLinhas][qtdColunas];
        this.valorLinha1 = valorLinha1;
        this.valorLinhaN = valorLinhaN;
        this.valorColuna1 = valorColuna1;
        this.valorColunaN = valorColunaN;

    }
    public double getTemperaturaMedia(ChapaMetalica quadrante){
        double ponto1 = quadrante.valorLinha1;
        double ponto2 = quadrante.valorLinhaN;
        double ponto3 = quadrante.valorColuna1;
        double ponto4 = quadrante.valorColunaN;
        double tempMedia = (ponto1+ponto2+ponto3+ponto4)/4;
        return tempMedia;
    }

    public ChapaMetalica getProximoPonto(double tempMedia, ChapaMetalica primeiroQuadrante){
        double linha1 = Math.abs(tempMedia-primeiroQuadrante.getValorLinha1());
        double linhaN = Math.abs(tempMedia-primeiroQuadrante.getValorLinhaN());
        double coluna1 = Math.abs(tempMedia-primeiroQuadrante.getValorColuna1());
        double colunaN = Math.abs(tempMedia-primeiroQuadrante.getValorColunaN());

        ChapaMetalica segundoQuadrante = new ChapaMetalica(linha1,linhaN,coluna1,colunaN);
        return segundoQuadrante;
    }


}
