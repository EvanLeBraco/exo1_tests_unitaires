public class CarteCreditManager {
    public boolean verifyCard(String cardNumber, String cvv) {
    	//V�rifie le nombre de num�ros de carte, sans espace et la taille du CVV
        if (cardNumber.length() == 16 && cvv.length() == 3) {
            return true;
        }
        //False si diff�rent
        return false;
    }
}