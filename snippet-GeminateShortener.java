import java.util.Scanner;
public class Main{
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
		arrayIPA = canDeGemin(arrayIPA, 0);
		stringIPA = String.valueOf(arrayIPA);
		System.out.println(stringIPA);
	}
}