import java.util.Scanner;
public class Main{
	public static char[] doubVowelContraction(char[] carWithDup){
		int caunter = 0;
		int indexOfDup = 0;
		boolean vowelReturn = false;
		char[] copy = new char[carWithDup.length - 1];
		while (caunter + 1 != carWithDup.length){
			if(carWithDup[caunter] == carWithDup[caunter + 1]){
				indexOfDup = caunter +1;
				break;
			}
			else{
				caunter++;
			}
		}
		for(int i = 0, j = 0; i < carWithDup.length; i++){
			if(i != indexOfDup){
				copy[j++] = carWithDup[i];
			}
			else if(i - 1 != -1){
				if(carWithDup[i - 1] == 'a' || carWithDup[i - 1] == 'e' || carWithDup[i - 1] == 'i' || carWithDup[i - 1] == 'o' || carWithDup[i - 1] == 'u'){
					if(carWithDup[i - 1] == 'a'){
						carWithDup[i - 1] = 'ā';
						i = i - 2;
						vowelReturn = true;
					}
					else if(carWithDup[i - 1] == 'e'){
						carWithDup[i - 1] = 'ē';
						i = i - 2;
						vowelReturn = true;
					}
					else if(carWithDup[i - 1] == 'i'){
						carWithDup[i - 1] = 'ī';
						i = i - 2;
						vowelReturn = true;
					}
					else if(carWithDup[i - 1] == 'o'){
						carWithDup[i - 1] = 'ō';
						i = i - 2;
						vowelReturn = true;
					}
					else{
						carWithDup[i - 1] = 'ū';
						i = i - 2;
						vowelReturn = true;
					}
				}
			}
		}
		if(vowelReturn = true){
			return copy;
		}
		else{
			return carWithDup;
		}
	}
/*	public static char[] centumization(char[] preCentum, int counter){
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
	public static char[] deGeminate(char[] carWithDup){
		int caunter = 0;
		int indexOfDup = 0;
		char[] copy = new char[carWithDup.length - 1];
		while (caunter + 1 != carWithDup.length){
			if(carWithDup[caunter] == carWithDup[caunter + 1]){
				indexOfDup = caunter +1;
				break;
			}
			else{
				caunter++;
			}
		}
		for(int i = 0, j = 0; i < carWithDup.length; i++){
			if(i != indexOfDup){
				copy[j++] = carWithDup[i];
			}
		}
		return copy;
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
			questionMark = deGeminate(questionMark);
			return questionMark;
		}
		else{
			return questionMark;
		}
	}
	public static char[] wordFinVowelLengthener(char[] preLonger){
		int indexFin = preLonger.length -1;
		if(preLonger[indexFin] == 'ā' || preLonger[indexFin] == 'ē' || preLonger[indexFin] == 'ī' || preLonger[indexFin] == 'ō' || preLonger[indexFin] == 'ū'){
			if(preLonger[indexFin] == 'ā'){
				preLonger[indexFin] = 'â';
			}
			else if(preLonger[indexFin] == 'ē'){
				preLonger[indexFin] = 'ê';
			}
			else if(preLonger[indexFin] == 'ī'){
				preLonger[indexFin] = 'î';
			}
			else if(preLonger[indexFin] == 'ō'){
				preLonger[indexFin] = 'ô';
			}
			else{
				preLonger[indexFin] = 'û';
			}
			return preLonger;
		}
		else{
			return preLonger;
		}
	}*/
	public static void main(String[] args){
		Scanner inputIPA = new Scanner(System.in);
		String stringIPA = "";
		System.out.println("Input a P.I.E. word that survived into P.Gmc.\nUse IPA as closely as possible:\nFor Palato-velars, use c and ɟ\nFor Syllabic consonants, precede the consonant with U\nFor Laryngeals, use 1, 2, and 3 when known, H when unknown\nFor Labialized consonants or aspirated consonants, follow the consonant with w then h, when applicable\nFor long vowels or accented vowels, use macrons and acutes as perscribed\nFor accented syllables, precede the vowel in question with S\nFor long vowels, double the vowel such that ō is written oo");
		stringIPA = inputIPA.nextLine();
		char[] arrayIPA = stringIPA.toCharArray();
		arrayIPA = doubVowelContraction(arrayIPA);
/*		arrayIPA = centumization(arrayIPA, 0);
		arrayIPA = deSyllabis(arrayIPA, 0);
		arrayIPA = deDental(arrayIPA, 0);
		arrayIPA = canDeGemin(arrayIPA, 0);
		arrayIPA = wordFinVowelLengthener(arrayIPA);*/
		stringIPA = String.valueOf(arrayIPA);
		System.out.println(stringIPA);
	}
}