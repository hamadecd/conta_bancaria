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
        Conta conta = contaService.cadastrar("Fulano");

        Assert.assertEquals((Integer) 1, conta.getAgencia());
        Assert.assertEquals((Integer) 1, conta.getNumero());
        Assert.assertEquals("Fulano", conta.getNomeDoCliente());

        Assert.assertTrue(conta != null);
        Assert.assertNotNull(conta);
    }

    @Test
    public void novasContasDevemIniciarComSaldoIgualAZero() {
        Conta conta = contaService.cadastrar("Fulano");

        Assert.assertEquals(0, conta.getSaldo(), 0);
        Assert.assertFalse(conta.getSaldo() != 0);
    }

    @Test
    public void deveSerPossivelDepositar() {
        Conta conta = contaService.cadastrar("Fulano");
        contaService.depositar(conta,  100.05);

        Assert.assertEquals(100.05, conta.getSaldo(), 0.01);
    }

    @Test
    public void deveSerPossivelSacarSeTiverSaldo() {
        Conta conta = contaService.cadastrar("Fulano");
        contaService.depositar(conta,  100.0);
        contaService.sacar(conta, 50.0);

        Assert.assertEquals(50.0, conta.getSaldo(), 0);
    }

    @Test
    public void deveSerPossivelTransferirEntreContasCasoHajaSaldo() {
        Conta conta = contaService.cadastrar("Fulano");
        Conta conta1 = contaService.cadastrar("Beltrano");
        contaService.depositar(conta,  100.0);
        contaService.transferir(conta, conta1, 10.0);

        Assert.assertEquals(90.0, conta.getSaldo(), 0);
        Assert.assertEquals(10.0, conta1.getSaldo(), 0);
    }

    // Contas com mesmo numero e mesma agencia são iguais
    @Test
    public void contasComMesmoNumeroEAgenciaDevemSerIguais() {
        Conta conta = contaService.cadastrar("Fulano");
        Conta conta1 = contaService.cadastrar("Beltrano");

        Assert.assertNotEquals(conta.getNumero(), conta1.getNumero());
        Assert.assertNotEquals(conta.getAgencia(), conta1.getAgencia());
    }

    @Test
    public void testaAssertSame() {
        Conta conta = contaService.cadastrar("Fulano");
        Conta conta1 = conta;

        Assert.assertSame(conta, conta1);
    }
}
