import org.junit.Assert;
import org.junit.Test;

public class PaymentIntegrationTest {

	
    @Test
    //Sc�nario 1 --> Validit� du test de paiement
    public void testProcessPayment_SuccessfulPayment() {
        // Instanciation de la classe PaymentProcessor
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Appel � la m�thode de paiement, renseignement valide des infos
        boolean result = paymentProcessor.processPayment(100.0, "1234567890123456", "123");

        // Utilisation des asserts pour valider le resultat 
        Assert.assertTrue(result);
    }
    

    
    @Test
    public void testProcessPayment_InvalidCreditCard() {
    	// Instanciation de la classe PaymentProcessor
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Appel de la m�thode de paiement avec moins de 16 car
        boolean result = paymentProcessor.processPayment(50.0, "123", "123");

        // Utilisations des asserts pour v�rifier la mauvaise entr�e
        Assert.assertFalse(result);
    }
    
    @Test
    public void testProcessPayment_InvalidAmount() {
        // Cr�ation de l'objet PaymentProcessor
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Appel � la m�thode processPayment avec un montant invalide (n�gatif)
        boolean result = paymentProcessor.processPayment(-10.0, "1234567890123456", "123");

        // V�rification que le paiement a �chou� en raison d'un montant invalide
        Assert.assertFalse(result);
    }
    
    @Test
    public void testProcessPayment_InvalidCVV() {
        // Cr�ation de l'objet PaymentProcessor
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Appel � la m�thode processPayment avec un CVV invalide
        boolean result = paymentProcessor.processPayment(75.0, "1234567890123456", "12");

        // V�rification que le paiement a �chou� en raison d'un CVV invalide
        Assert.assertFalse(result);
    }
    
    @Test
    public void testProcessPayment_InvalidCardNumber() {
        // Cr�ation de l'objet PaymentProcessor
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Appel � la m�thode processPayment avec un num�ro de carte de cr�dit invalide
        boolean result = paymentProcessor.processPayment(60.0, "1234", "123");

        // V�rification que le paiement a �chou� en raison d'un num�ro de carte de cr�dit invalide
        Assert.assertFalse(result);
    }
    
}





