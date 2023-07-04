public class PaymentProcessor {
    public boolean processPayment(double montant, String numCart, String cvv) {
        // Instanciation de la classe de passerelle de paiment
        PaymentGateway gateway = new PaymentGateway();

        // Instanciation de la classe de CC Manager pour créer une CC
        CarteCreditManager carteManager = new CarteCreditManager();
        
        // Création d'un bool permettant de récupérer la valeur de la fonction verifycard de la CC
        boolean carteValide = carteManager.verifyCard(numCart, cvv);

        // Vérifie la validité de la carte par rapport à la fonction contenue dans le manager de CC
        if (carteValide) {
            String transactionId = gateway.makePayment(montant);

            // Faux test pour local --> Peu utile après les tests (sauf prompt), mais je laisse
            if (transactionId != null) {
                System.out.println("Paiement réussi. ID de transacction : " + transactionId);
                return true;
            } else {
                System.out.println("Échec du paiement. CHEH");
                return false;
            }
        } else {
            System.out.println("Informations de carte de crédit invalides.");
            return false;
        }
    }
}
