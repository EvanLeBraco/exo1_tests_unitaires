public class PaymentGateway {
    public String makePayment(double amount) {
    	
    	// Rajout apr�s test 3 pour g�rer les montants n�gatifs
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant du paiement doit �tre sup�rieur � z�ro.");
        }
        
    	//Cr�ation d'un string pour accueilir l'ID de transaction
        String transactionId = generateTransactionId();
        
        //Retourne l'ID de transaction
        return transactionId;
    }
    
    
    //Repris de CHAT GPT pour acc�lerer le d�veloppement de la cr�ation d'ID
    private String generateTransactionId() {
    	//Choix des caract�res voulus
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        //Cr�ation d'un nouvel ID
        StringBuilder transactionIdBuilder = new StringBuilder();
        
        
        //Boucle for sur les caract�res pour avoir une longueur de 10 �l�ments
        for (int i = 0; i < 10; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            char randomCharacter = characters.charAt(randomIndex);
            transactionIdBuilder.append(randomCharacter);
        }
        
        //Retourne la cha�ne de caract�res
        return transactionIdBuilder.toString();
    }
}