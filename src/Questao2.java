import questao1.models.Conta;
import questao1.models.ContaEspecial;
import questao1.models.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        List<Conta> contaList = new ArrayList<>();
        boolean continuar = true;

        while(continuar) {
            imprimeMenu();
            int opcao = scanner.nextInt();
            switch(opcao){
                case 1 -> criaConta(scanner, contaList);
                case 2 -> verSaldo(scanner, contaList);
                case 3 -> sacar(scanner, contaList);
                case 4 -> depositar(scanner, contaList);
                case 0 -> continuar = false;
                default -> throw new RuntimeException("Valor incorreto!");
            }
        }
        imprimirContas(contaList);
    }

    private static void imprimeMenu(){
        System.out.println("=== MENU ===");
        System.out.println("Selecione a ação: " +
                "(1)Criar Conta " +
                "(2)Ver saldo da conta " +
                "(3)sacar " +
                "(4)depositar " +
                "(0)sair");
    }

    private static void verSaldo(Scanner scanner, List<Conta> contaList){
        Conta conta = encontraConta(scanner, contaList);
        System.out.println(conta.getSaldo());
    }

    private static void sacar(Scanner scanner, List<Conta> contaList){
        System.out.println("Informe o valor a sacar:");
        double valorSaque = scanner.nextDouble();
        Conta conta = encontraConta(scanner, contaList);
        System.out.println((conta.sacar(valorSaque)) ? "Valor sacado com Sucesso!" : "Valor acima do saldo disponível");
    }

    private static void depositar(Scanner scanner, List<Conta> contaList){
        System.out.println("Informe o valor do deposito");
        double valorDeposito = scanner.nextDouble();
        Conta conta = encontraConta(scanner, contaList);
        conta.depositar(valorDeposito);
    }

    private static Conta encontraConta(Scanner scanner, List<Conta> contaList){
        System.out.println("Informe o numero da conta:");
        int numeroConta = scanner.nextInt();
        for (Conta conta : contaList){
            if(conta.getNumero() == numeroConta) return conta;
        }
        return null;
    }

    private static void criaConta(Scanner scanner, List<Conta> contaList) {
        System.out.println("Selecione o tipo de conta: " +
                "(1)Conta " +
                "(2)Conta Poupança " +
                "(3)Conta Especial");
        int opcaoConta = scanner.nextInt();
        System.out.println("Informe o nome do titular:");
        String nomeTitular = scanner.next();
        System.out.println("Informe o saldo inicial:");
        double saldoInicial = scanner.nextDouble();
        switch(opcaoConta){
            case 1 -> {
                Conta conta = new Conta(nomeTitular, saldoInicial);
                System.out.println("Conta criada, numero: " + conta.getNumero());
                contaList.add(conta);
            }
            case 2 -> {
                ContaPoupanca contaPoupanca = new ContaPoupanca(nomeTitular, saldoInicial);
                System.out.println("Conta Poupança criada, numero: " + contaPoupanca.getNumero());
                contaList.add(contaPoupanca);
            }
            case 3 -> {
                System.out.println("Informe o limite da conta");
                double limiteConta = scanner.nextDouble();
                ContaEspecial contaEspecial = new ContaEspecial( nomeTitular, saldoInicial, limiteConta);
                System.out.println("Conta Poupança criada, numero: " + contaEspecial.getNumero());
                contaList.add(contaEspecial);
            }
        }
    }

    private static void imprimirContas(List<Conta> contaList){
        for (Conta conta : contaList){
            System.out.println(conta.getNomeTitular() + " " + conta.getSaldo());
        }
    }
}