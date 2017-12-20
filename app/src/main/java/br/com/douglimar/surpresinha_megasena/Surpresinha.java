package br.com.douglimar.surpresinha_megasena;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Douglimar Moraes on 02/12/17.
 *
 *
 */

class Surpresinha {

    public String generateMegasenaGame() {

        /* Regra do Jogo:
	    * O apostador pode escolher 6 numeros entre 60 numeros disponiveis
	    */

        int numsMegaSena[] = new int[6];

        int indice;
        Random random = new Random();
        StringBuilder Retorno = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            indice = random.nextInt(61);

            for (int k = 0; k <= 60; k++) {
                if (consisteJogo(numsMegaSena, indice) || indice == 0) {
                    indice = random.nextInt(61);
                }
            }
            numsMegaSena[i] = indice;
        }

        Arrays.sort(numsMegaSena);

        for (int i = 0; i < 6; i++) {

            if (numsMegaSena[i] < 10)
                Retorno.append(" 0").append(numsMegaSena[i]);
            else
                Retorno.append(" ").append(numsMegaSena[i]);
        }

        return Retorno.toString();

    }

    private boolean consisteJogo(int pArray[], int PNumero) {

        boolean Retorno = false;

        for (int aPArray : pArray) {
            if (aPArray == PNumero) {
                Retorno = true;
                break;
            }
        }

        return Retorno;
    }

}
