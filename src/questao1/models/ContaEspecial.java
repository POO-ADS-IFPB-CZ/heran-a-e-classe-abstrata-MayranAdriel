package questao1.models;

public class ContaEspecial extends Conta{
    private double limite;

    public ContaEspecial(String nomeTitular, double saldo, double limite) {
        super(nomeTitular, saldo);
        this.limite = limite;
    }


    @Override
    public boolean sacar(double valorParaSacar) {
        return super.sacar(valorParaSacar);
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
