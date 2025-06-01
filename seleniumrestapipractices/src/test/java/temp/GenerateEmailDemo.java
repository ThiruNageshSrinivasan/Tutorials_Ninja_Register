package temp;

import java.util.Date;

public class GenerateEmailDemo {
	public static void main(String[] args) {
		Date date = new Date();
        String dateString=date.toString();
		String removeallspace=dateString.replaceAll("[\\s:]", "");
		//System.out.println(removeallspace);
		String genericemail=removeallspace+"@thiru.com";
		System.out.println(genericemail);
	}



}
