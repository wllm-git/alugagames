package alugagames.core.shared;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuncoesGerais {
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static boolean emailValido(String email){
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
	}
	
	public static boolean cpfValido(String cpf){
		if (cpf.length() > 11)
            return false;

        while (cpf.length() != 11)
            cpf = '0' + cpf;

        boolean igual = true;
        for (int i = 1; i < 11 && igual; i++)
            if (cpf.charAt(i) != cpf.charAt(0))
                igual = false;

        if (igual || cpf == "12345678909")
            return false;

        int[] numeros = new int[11];

        for (int i = 0; i < 11; i++)
            numeros[i] = Character.getNumericValue(cpf.charAt(i));

        int soma = 0;
        for (int i = 0; i < 9; i++)
            soma += (10 - i) * numeros[i];

        int resultado = soma % 11;

        if (resultado == 1 || resultado == 0)
        {
            if (numeros[9] != 0)
                return false;
        }
        else if (numeros[9] != 11 - resultado)
            return false;

        soma = 0;
        for (int i = 0; i < 10; i++)
            soma += (11 - i) * numeros[i];

        resultado = soma % 11;

        if (resultado == 1 || resultado == 0)
        {
            if (numeros[10] != 0)
                return false;
        }
        else
            if (numeros[10] != 11 - resultado)
                return false;

        return true;
	}
}
