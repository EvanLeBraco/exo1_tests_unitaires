public class PaymentProcessor {
    public boolean processPayment(double montant, String numCart, String cvv) {
        // Instanciation de la classe de passerelle de paiment
        PaymentGateway gateway = new PaymentGateway();

        // Instanciation de la classe de CC Manager pour cr�er une CC
        CarteCreditManager carteManager = new CarteCreditManager();
        
        // Cr�ation d'un bool permettant de r�cup�rer la valeur de la fonction verifycard de la CC
        boolean carteValide = carteManager.verifyCard(numCart, cvv);

        // V�rifie la validit� de la carte par rapport � la fonction contenue dans le manager de CC
        if (carteValide) {
            String transactionId = gateway.makePayment(montant);

            // Faux test pour local --> Peu utile apr�s les tests (sauf prompt), mais je laisse
            if (transactionId != null) {
                System.out.println("Paiement r�ussi. ID de transacction : " + transactionId);
                return true;
            } else {
                System.out.println("�chec du paiement. CHEH");
                return false;
            }
        } else {
            System.out.println("Informations de carte de cr�dit invalides.");
            return false;
        }
    }
}
