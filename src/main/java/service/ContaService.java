package service;

import model.Conta;

public class ContaService {

    private static Integer numeroConta = 1;
    private static Integer numeroAgencia = 1;

    public Conta cadastrar(String nome) {
        Conta conta = new Conta(numeroConta, numeroAgencia, nome);
        numeroConta++;
        numeroAgencia++;
        return conta;
    }

    public void depositar(Conta conta, Double valor) {
        if (valor > 0) {
            conta.setSaldo(conta.getSaldo() + valor);
            return;
        }
        System.err.println("Não foi possível depositar, valor deve ser maior do que zero");
    }

    public void sacar(Conta conta, Double valor) {
        if (conta.getSaldo() >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
            return;
        }
        System.err.println("Saldo insuficiente!");
    }

    public void transferir(Conta contaTransferindo, Conta contaRecebendo, Double valor) {
        if (contaTransferindo.getSaldo() >= valor) {
            contaTransferindo.setSaldo(contaTransferindo.getSaldo() - valor);
            contaRecebendo.setSaldo(contaRecebendo.getSaldo() + valor);
        }
    }
}
