package model;

import java.util.Objects;

public class Conta {
    private Integer agencia, numero;
    private double saldo;
    private String nomeDoCliente;

    public Conta(Integer agencia, Integer numero, String nomeDoCliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0.0;
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta conta = (Conta) o;
        return agencia.equals(conta.agencia) && numero.equals(conta.numero);
    }

}
