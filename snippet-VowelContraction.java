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
	public static void main(String[] args){
		Scanner inputIPA = new Scanner(System.in);
		String stringIPA = "";
		System.out.println("Input a P.I.E. word that survived into P.Gmc.\nUse IPA as closely as possible:\nFor Palato-velars, use c and ɟ\nFor Syllabic consonants, precede the consonant with U\nFor Laryngeals, use 1, 2, and 3 when known, H when unknown\nFor Labialized consonants or aspirated consonants, follow the consonant with w then h, when applicable\nFor long vowels or accented vowels, use macrons and acutes as perscribed\nFor accented syllables, precede the vowel in question with S\nFor long vowels, double the vowel such that ō is written oo");
		stringIPA = inputIPA.nextLine();
		char[] arrayIPA = stringIPA.toCharArray();
		arrayIPA = doubVowelContraction(arrayIPA);
		stringIPA = String.valueOf(arrayIPA);
		System.out.println(stringIPA);
	}
}