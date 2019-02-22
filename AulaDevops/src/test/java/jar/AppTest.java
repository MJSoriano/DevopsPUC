package jar;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import jar.App;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void ValidarSequenciaErrada()
    {
        List<Carta> maoTeste = new ArrayList<Carta>();
        maoTeste.add(new Carta(8,"10","H"));
        maoTeste.add(new Carta(9,"Vale","H"));
        maoTeste.add(new Carta(11,"Data","H"));
        maoTeste.add(new Carta(10,"Rei","H"));
        maoTeste.add(new Carta(12,"As","H"));

        boolean resultado = App.verificaSequenciaENaipe(maoTeste);
		Assert.assertFalse("Fora da sequencia: ", resultado);        
    }

    @Test
    public void ValidarNaipeErrado()
    {
        List<Carta> maoTeste = new ArrayList<Carta>();
        maoTeste.add(new Carta(8,"10","H"));
        maoTeste.add(new Carta(9,"Vale","H"));
        maoTeste.add(new Carta(10,"Data","J"));
        maoTeste.add(new Carta(11,"Rei","H"));
        maoTeste.add(new Carta(12,"As","H"));        

        boolean resultado = App.verificaSequenciaENaipe(maoTeste);
		Assert.assertFalse("Naipe diferente: ", resultado);        
    }

    @Test
    public void ValidarSequenciaNaipeCorretos()
    {
        List<Carta> maoTeste = new ArrayList<Carta>();
        maoTeste.add(new Carta(8,"10","H"));
        maoTeste.add(new Carta(9,"Vale","H"));
        maoTeste.add(new Carta(10,"Data","H"));
        maoTeste.add(new Carta(11,"Rei","H"));
        maoTeste.add(new Carta(12,"As","H"));

        boolean resultado = App.verificaSequenciaENaipe(maoTeste);
		Assert.assertTrue("OK: ", resultado);        
    }

    @Test
    public void ValidarStraightFlushErrado() {
        
        List<Carta> maoTeste = new ArrayList<Carta>();
        maoTeste.add(new Carta(8,"10","H"));
        maoTeste.add(new Carta(9,"Vale","J"));
        maoTeste.add(new Carta(10,"Data","H"));
        maoTeste.add(new Carta(12,"Rei","H"));
        maoTeste.add(new Carta(11,"As","H"));
        
        boolean resultado = App.verificaStraightFlush(maoTeste);
		Assert.assertFalse("NÃO: ", resultado);            
    }

    @Test
    public void ValidarStraightFlushCorreto() {
        
        List<Carta> maoTeste = new ArrayList<Carta>();
        maoTeste.add(new Carta(8,"10","H"));
        maoTeste.add(new Carta(9,"Vale","H"));
        maoTeste.add(new Carta(10,"Data","H"));
        maoTeste.add(new Carta(11,"Rei","H"));
        maoTeste.add(new Carta(12,"As","H"));
        
        boolean resultado = App.verificaStraightFlush(maoTeste);
		Assert.assertTrue("SIM: ", resultado);            
    }    

    @Test
    public void ValidarRoyalFlushErrado() {
        
        List<Carta> maoTeste = new ArrayList<Carta>();
        maoTeste.add(new Carta(7,"10","H"));
        maoTeste.add(new Carta(9,"Vale","J"));
        maoTeste.add(new Carta(10,"Data","H"));
        maoTeste.add(new Carta(12,"Rei","H"));
        maoTeste.add(new Carta(11,"As","H"));
        
        boolean resultado = App.verificaRoyalFlush(maoTeste);
		Assert.assertFalse("NÃO: ", resultado);            
    }

    @Test
    public void ValidarRoyalFlushCorreto() {
        
        List<Carta> maoTeste = new ArrayList<Carta>();
        maoTeste.add(new Carta(8,"10","H"));
        maoTeste.add(new Carta(9,"Vale","H"));
        maoTeste.add(new Carta(10,"Data","H"));
        maoTeste.add(new Carta(11,"Rei","H"));
        maoTeste.add(new Carta(12,"As","H"));
        
        boolean resultado = App.verificaRoyalFlush(maoTeste);
		Assert.assertTrue("SIM: ", resultado);            
    }

    @Test
    public void Quebrar() {
        
        List<Carta> maoTeste = new ArrayList<Carta>();
        maoTeste.add(new Carta(8,"10","H"));
        maoTeste.add(new Carta(9,"Vale","M"));
        maoTeste.add(new Carta(10,"Data","H"));
        maoTeste.add(new Carta(11,"Rei","H"));
        maoTeste.add(new Carta(13,"As","H"));
        
        boolean resultado = App.verificaRoyalFlush(maoTeste);
		Assert.assertFalse("Peso e Nipe errado: ", resultado);            
    }
}
