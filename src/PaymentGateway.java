public class PaymentGateway {
    public String makePayment(double amount) {
    	
    	// Rajout après test 3 pour gérer les montants négatifs
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant du paiement doit être supérieur à zéro.");
        }
        
    	//Création d'un string pour accueilir l'ID de transaction
        String transactionId = generateTransactionId();
        
        //Retourne l'ID de transaction
        return transactionId;
    }
    
    
    //Repris de CHAT GPT pour accélerer le développement de la création d'ID
    private String generateTransactionId() {
    	//Choix des caractères voulus
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        //Création d'un nouvel ID
        StringBuilder transactionIdBuilder = new StringBuilder();
        
        
        //Boucle for sur les caractères pour avoir une longueur de 10 éléments
        for (int i = 0; i < 10; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            char randomCharacter = characters.charAt(randomIndex);
            transactionIdBuilder.append(randomCharacter);
        }
        
        //Retourne la chaîne de caractères
        return transactionIdBuilder.toString();
    }
}