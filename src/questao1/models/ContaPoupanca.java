package questao1.models;

public class ContaPoupanca extends Conta{


    public ContaPoupanca(String nomeTitular, double saldo) {
        super(nomeTitular, saldo);
    }

    public void reajustar(double percentual){
        double saldoAtual = this.getSaldo();
        double reajuste = saldoAtual * percentual;
        this.depositar(reajuste);
    }
}
