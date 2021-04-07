import java.util.Scanner;
public class Main{
	public static char[] centumization(char[] preCentum, int counter){
		while (counter != preCentum.length){
			if(preCentum[counter] == 'c'){
				preCentum[counter] = 'k';
			}
			else if(preCentum[counter] == 'ɟ'){
				preCentum[counter] = 'g';
			}
			else{
				counter++;
			}
		}
		return preCentum;
	}
	public static char[] deSyllabis(char[] preEpenth, int counter){
		while (counter != preEpenth.length){
			if(preEpenth[counter] == 'U'){
				preEpenth[counter] = 'u';
			}
			else{
				counter++;
			}
		}
		return preEpenth;
	}
	public static char[] deDental(char[] preSimple, int counter){
		while (counter +1 != preSimple.length){
			if((preSimple[counter] == 'd' || preSimple[counter] == 't') & (preSimple[counter + 1] == 'd' || preSimple[counter + 1] == 't')){
				preSimple[counter] = 's';
				preSimple[counter + 1] = 's';
			}
			else{
				counter++;
			}
		}
		return preSimple;
	}
	public static char[] deGeminA(char[] carWithDup, int indexOfDup){
		char[] copy = new char[carWithDup.length - 1];
		for(int i = 0, j = 0; i < carWithDup.length; i++){
			if(i != indexOfDup){
				copy[j++] = carWithDup[i];
			}
		}
		return copy;
	}
	public static int deGeminB(char[] carWithDup){
		int caunter = 0;
		int indexOfDup = 0;
		while (caunter + 1 != carWithDup.length){
			if(carWithDup[caunter] == carWithDup[caunter + 1]){
				indexOfDup = caunter +1;
				break;
			}
			else{
				caunter++;
			}
		}
		return indexOfDup;
	}
	public static char[] canDeGemin(char[] questionMark, int counter){
		boolean deGeminPossible = false;
		while (counter + 2 != questionMark.length){
			if((questionMark[counter + 1] == questionMark[counter + 2]) & (questionMark[counter] != 'a' || questionMark[counter] != 'e' || questionMark[counter] != 'i' || questionMark[counter] != 'o' || questionMark[counter] != 'u')){
				deGeminPossible = true;
				break;
			}
			else{
				counter++;
			}
		}
		if (deGeminPossible == true){
			counter = deGeminB(questionMark);
			questionMark = deGeminA(questionMark, counter);
			return questionMark;
		}
		else{
			return questionMark;
		}
	}
	public static void main(String[] args){
		Scanner inputIPA = new Scanner(System.in);
		String stringIPA = "";
		System.out.println("Input a P.I.E. word that survived into P.Gmc.\nUse IPA as closely as possible:\nFor Palato-velars, use c and ɟ\nFor Syllabic consonants, precede the consonant with U\nFor Laryngeals, use 1, 2, and 3 when known, H when unknown\nFor Labialized consonants or aspirated consonants, follow the consonant with w then h, when applicable\nFor long vowels or accented vowels, use macrons and acutes as perscribed\nFor accented syllables, precede the vowel in question with S");
		stringIPA = inputIPA.nextLine();
		char[] arrayIPA = stringIPA.toCharArray();
		arrayIPA = centumization(arrayIPA, 0);
		arrayIPA = deSyllabis(arrayIPA, 0);
		arrayIPA = deDental(arrayIPA, 0);
		arrayIPA = canDeGemin(arrayIPA, 0);
		stringIPA = String.valueOf(arrayIPA);
		System.out.println(stringIPA);
	}
}