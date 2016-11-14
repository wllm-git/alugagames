package alugagames.core.shared;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaDES {
	
	private static final String chave = "alugagameschave1";
	
	public static String encriptar(String textoNormal){
		try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] mensagem = textoNormal.getBytes();

            byte[] chaveBytes = chave.getBytes();

            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chaveBytes, "AES"));
            byte[] encrypted = cipher.doFinal(mensagem);
            
            return new String(encrypted);

        } catch (Exception e) {
           throw new RuntimeException("Falha ao encriptar." + e.getMessage()); 
        }
	}
	
	public static String decriptar(String textoEncriptado){
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        byte[] encrypted = textoEncriptado.getBytes();
	
	        byte[] chaveBytes = chave.getBytes();
			
	        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(chaveBytes, "AES"));
	        byte[] decrypted = cipher.doFinal(encrypted);
	        
	        return new String(decrypted);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao decriptar." + e.getMessage());
        }
	}
	
}
