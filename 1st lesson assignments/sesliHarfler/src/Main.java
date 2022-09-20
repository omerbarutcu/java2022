public class Main {
    public static void main(String[] args) {
        char harf = 'e';
        switch (harf) {
            case 'a':
            case 'A':
            case 'ı':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                System.out.println(harf + " : Kalın sesli harftir.");
                break;
            case 'e':
            case 'E':
            case 'i':
            case 'İ':
            case 'ö':
            case 'Ö':
            case 'ü':
            case 'Ü':
                System.out.println(harf + " : İnce sesli harftir.");
                break;
            default:
                System.out.println("Geçersiz harf girdiniz.");
        }
    }
}