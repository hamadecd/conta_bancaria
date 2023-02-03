package service;

import model.Conta;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 *
 *  Deve ser possível criar uma conta
 *  Novas contas iniciam com o saldo ZERO
 *  Deve ser possível depositar
 *  Caso haja saldo deve ser possível sacar
 *  Caso haja saldo deve ser possível transferir entre contas
 *  Contas com mesmo numero e mesma agencia são iguais
 *
 *  Assert.assertTrue(true);
 *  Assert.assertFalse(false);
 *  Assert.assertEquals(1, 1);
 *  Assert.assertNotEquals(2 , 10);
 *
 *  Assert equals comparando duas contas
 *  Assert.assertSame
 */

public class ContaServiceTest {

    ContaService contaService;

    @Before
    public void setup() {
        contaService = new ContaService();
    }

    @Test
    public void deveSerPossivelCriarUmaConta() {
        Conta conta = contaService.cadastrar("Robert C. Martin");

        Assert.assertEquals((Integer) 1, conta.getAgencia());
        Assert.assertEquals((Integer) 1, conta.getNumero());
        Assert.assertEquals("Robert C. Martin", conta.getNomeDoCliente());

        Assert.assertTrue(conta != null);
        Assert.assertNotNull(conta);
    }

    @Test
    public void novasContasDevemIniciarComSaldoIgualAZero() {
        Conta conta = contaService.cadastrar("James Gosling");

        Assert.assertEquals(0.01, conta.getSaldo(), 0.1);
        Assert.assertFalse(conta.getSaldo() != 0);
    }

    @Test
    public void deveSerPossivelDepositar() {
        Conta conta = contaService.cadastrar("Linus Torvalds");
        contaService.depositar(conta,  100.05);
        contaService.depositar(conta, 0.1);

        Assert.assertEquals(100.15, conta.getSaldo(), 0.1);
    }

    @Test
    public void deveSerPossivelSacarSeTiverSaldo() {
        Conta conta = contaService.cadastrar("Alan Turing");
        contaService.depositar(conta,  100.0);
        contaService.sacar(conta, 50.0);

        Assert.assertEquals(50.0, conta.getSaldo(), 0);
        Assert.assertNotEquals(100.0, conta.getSaldo());
    }

    @Test
    public void deveSerPossivelTransferirEntreContasCasoHajaSaldo() {
        Conta conta = contaService.cadastrar("Ada Lovelace");
        Conta conta1 = contaService.cadastrar("Charles Babbage");
        contaService.depositar(conta,  1000.0);
        contaService.transferir(conta, conta1, 10.0);

        Assert.assertEquals(990.0, conta.getSaldo(), 0);
        Assert.assertEquals(10.0, conta1.getSaldo(), 0);
    }

    // Não gera uma conta com numero a agencia igual outra, então comparamos assim
    @Test
    public void contasComMesmoNumeroEAgenciaDevemSerIguais() {
        Conta conta = contaService.cadastrar("Bill Gates");
        Conta conta1 = contaService.cadastrar("Steve Jobs");

        Assert.assertNotEquals(conta.getNumero(), conta1.getNumero());
        Assert.assertNotEquals(conta.getAgencia(), conta1.getAgencia());
    }

    // Falha - tem que rever parte da aula sobre o Equals
    @Test
    public void comparaDuasContasComOAssertEquals() {
        Conta conta = contaService.cadastrar("Bill Gates");
        Conta conta1 = contaService.cadastrar("Steve Jobs");

        Assert.assertEquals(conta, conta1);
    }

    @Test
    public void testaAssertSame() {
        Conta conta = contaService.cadastrar("Igor Mascarenhas");
        Conta conta1 = conta;

        Assert.assertSame(conta, conta1);
    }
}
