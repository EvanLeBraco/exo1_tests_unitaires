public class CarteCreditManager {
    public boolean verifyCard(String cardNumber, String cvv) {
    	//Vérifie le nombre de numéros de carte, sans espace et la taille du CVV
        if (cardNumber.length() == 16 && cvv.length() == 3) {
            return true;
        }
        //False si différent
        return false;
    }
}