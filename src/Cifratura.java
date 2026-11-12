/**
 * Classe che implementa il cifrario di Cesare con uno spostamento fisso di 3 posizioni.
 * Permette di cifrare e decifrare parole o frasi mantenendo invariati i caratteri non alfabetici.
 *
 * @author IlTuoNome
 * @version 1.0
 */
public class Cifratura {

    /**
     * Spostamento fisso previsto dal cifrario di Cesare.
     */
    private static final int SHIFT = 3;

    /**
     * Costruttore predefinito della classe Cifratura.
     */
    public Cifratura() {
        // Costruttore vuoto
    }

    /**
     * Cifra una parola trasponendo le lettere dell'alfabeto di 3 posizioni in avanti.
     * Gestisce il ritorno all'inizio dell'alfabeto (es. 'x' diventa 'a') e mantiene
     * la distinzione tra maiuscole e minuscole.
     *
     * @param parola La stringa di testo in chiaro da cifrare.
     * @return Una nuova {@code String} contenente il testo cifrato, oppure {@code null} se l'input è nullo.
     */
    public String cifra(String parola) {
        if (parola == null) {
            return null;
        }
        return trasponi(parola, SHIFT);
    }

    /**
     * Decifra una parola precedentemente cifrata con il cifrario di Cesare,
     * trasponendo le lettere di 3 posizioni all'indietro.
     *
     * @param parolaCifrata La stringa cifrata da riportare in chiaro.
     * @return Una nuova {@code String} contenente il testo originale decifrato, oppure {@code null} se l'input è nullo.
     */
    public String decifra(String parolaCifrata) {
        if (parolaCifrata == null) {
            return null;
        }
        return trasponi(parolaCifrata, -SHIFT);
    }

    /**
     * Metodo di utilità privato che esegue lo spostamento effettivo dei caratteri.
     * Evita la duplicazione del codice tra i metodi {@code cifra} e {@code decifra}.
     *
     * @param testo La stringa su cui applicare lo spostamento.
     * @param chiave Il numero di posizioni di cui spostare le lettere (positivo o negativo).
     * @return La stringa risultante dopo lo spostamento dei caratteri.
     */
    private String trasponi(String testo, int chiave) {
        StringBuilder risultato = new StringBuilder();

        for (int i = 0; i < testo.length(); i++) {
            char carattere = testo.charAt(i);

            if (Character.isLetter(carattere)) {
                // Determina il punto di partenza ('A' per le maiuscole, 'a' per le minuscole)
                char base = Character.isUpperCase(carattere) ? 'A' : 'a';

                // Calcola la nuova posizione gestendo il ciclo dell'alfabeto (26 lettere).
                // L'aggiunta di + 26 prima del modulo evita risultati negativi durante la decifratura.
                int nuovaPosizione = (carattere - base + chiave + 26) % 26;
                risultato.append((char) (base + nuovaPosizione));
            } else {
                // Se non è una lettera (es. numeri, spazi, simboli), la lascia invariata
                risultato.append(carattere);
            }
        }

        return risultato.toString();
    }
}