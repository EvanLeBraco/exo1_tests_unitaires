import org.junit.Assert;
import org.junit.Test;

public class PaymentIntegrationTest {

	
    @Test
    //Scénario 1 --> Validité du test de paiement
    public void testProcessPayment_SuccessfulPayment() {
        // Instanciation de la classe PaymentProcessor
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Appel à la méthode de paiement, renseignement valide des infos
        boolean result = paymentProcessor.processPayment(100.0, "1234567890123456", "123");

        // Utilisation des asserts pour valider le resultat 
        Assert.assertTrue(result);
    }
    

    
    @Test
    public void testProcessPayment_InvalidCreditCard() {
    	// Instanciation de la classe PaymentProcessor
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Appel de la méthode de paiement avec moins de 16 car
        boolean result = paymentProcessor.processPayment(50.0, "123", "123");

        // Utilisations des asserts pour vérifier la mauvaise entrée
        Assert.assertFalse(result);
    }
    
    @Test
    public void testProcessPayment_InvalidAmount() {
        // Création de l'objet PaymentProcessor
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Appel à la méthode processPayment avec un montant invalide (négatif)
        boolean result = paymentProcessor.processPayment(-10.0, "1234567890123456", "123");

        // Vérification que le paiement a échoué en raison d'un montant invalide
        Assert.assertFalse(result);
    }
    
    @Test
    public void testProcessPayment_InvalidCVV() {
        // Création de l'objet PaymentProcessor
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Appel à la méthode processPayment avec un CVV invalide
        boolean result = paymentProcessor.processPayment(75.0, "1234567890123456", "12");

        // Vérification que le paiement a échoué en raison d'un CVV invalide
        Assert.assertFalse(result);
    }
    
    @Test
    public void testProcessPayment_InvalidCardNumber() {
        // Création de l'objet PaymentProcessor
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Appel à la méthode processPayment avec un numéro de carte de crédit invalide
        boolean result = paymentProcessor.processPayment(60.0, "1234", "123");

        // Vérification que le paiement a échoué en raison d'un numéro de carte de crédit invalide
        Assert.assertFalse(result);
    }
    
}





