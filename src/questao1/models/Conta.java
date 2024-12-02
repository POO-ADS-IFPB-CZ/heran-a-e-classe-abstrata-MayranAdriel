package questao1.models;

public class Conta {
    private static int contador = 1;
    private final int numero;
    private String nomeTitular;
    private double saldo;

    public Conta(String nomeTitular, double saldo) {
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        this.numero = contador++;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public boolean sacar(double valorParaSacar){
        if(valorParaSacar > this.saldo) return false;

        this.saldo -= valorParaSacar;
        return true;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }
}
