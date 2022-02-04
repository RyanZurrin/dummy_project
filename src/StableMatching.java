/**
 * implementation of the stable matching using the Gale-Shapley algorithm
 */
import java.util.*;

public class StableMatching {
	private int N, positionFilledCount;
	private final String[][] HospitalPref;
	private final String[][] StudentPref;
	private final String[] Hospitals;
	private final String[] Students;
	private final String[] StudentAccepted;
	private final boolean[] HospitalOffered;
	/** Constructor **/

	public StableMatching(String[] m, String[] w, String[][] mp, String[][] wp)	{
		N = mp.length;
		positionFilledCount = 0;
		Hospitals = m;
		Students = w;
		HospitalPref = mp;
		StudentPref = wp;
		HospitalOffered = new boolean[N];
		StudentAccepted = new String[N];
		calcMatches();
	}
	/** function to calculate all matches **/
	private void calcMatches(){
		while (positionFilledCount < N){
			int free;
			for (free = 0; free < N; free++)
				if (!HospitalOffered[free])
					break;
			for (int i = 0; i < N && !HospitalOffered[free]; i++){
				int index = womenIndexOf(HospitalPref[free][i]);
				if (StudentAccepted[index] == null){
					StudentAccepted[index] = Hospitals[free];
					HospitalOffered[free] = true;
					positionFilledCount++;
				} else {
					String currentPartner = StudentAccepted[index];
					if (morePreference(currentPartner, Hospitals[free], index)) {
						StudentAccepted[index] = Hospitals[free];
						HospitalOffered[free] = true;
						HospitalOffered[menIndexOf(currentPartner)] = false;
					}
				}
			}
		}
		printCouples();
	}
	/** function to check if women prefers new partner over old assigned partner **/
	private boolean morePreference(String curPartner, String newPartner, int index)	{
		for (int i = 0; i < N; i++) {
			if (StudentPref[index][i].equals(newPartner))
				return true;
			if (StudentPref[index][i].equals(curPartner))
				return false;
		}
		return false;
	}
	/** get men index **/
	private int menIndexOf(String str) {
		for (int i = 0; i < N; i++)
			if (Hospitals[i].equals(str))
				return i;
		return -1;
	}
	/** get women index **/
	private int womenIndexOf(String str) {
		for (int i = 0; i < N; i++)
			if (Students[i].equals(str))
				return i;
		return -1;
	}
	/** print couples **/
	public void printCouples() {
		System.out.println("Matches are : ");
		for (int i = 0; i < N; i++)	{
			System.out.println(StudentAccepted[i] +" "+ Students[i]);
		}
	}
	/** main function **/
	public static void main(String[] args)	{
		System.out.println("Gale Shapley Stable  Matches Algorithm\n");
		/** list of Hospitals **/
		String[] h = {"Atlanta", "Boston", "Chicago", "Denver", "El Paso"};
		/** list of students **/
		String[] s = {"Vanessa", "Wyatt", "Xena", "Yousef", "Zelda"};
		/** Hospital preference **/
		String[][] hp = {{"Wyatt", "Xena", "Yousef", "Zelda", "Vanessa"},
				{"Xena", "Yousef", "Zelda", "Vanessa", "Wyatt"},
				{"Zelda", "Vanessa", "Yousef", "Wyatt", "Xena"},
				{"Xena", "Vanessa", "Wyatt", "Yousef", "Zelda"},
				{"Vanessa", "Zelda", "Wyatt", "Xena", "Yousef"}};
		/** student preference **/
		String[][] sp = {{"Chicago", "Denver", "Atlanta", "Boston", "El Paso"},
				{"Boston", "Atlanta", "Denver", "El Paso", "Chicago"},
				{"Chicago", "Boston", "El Paso", "Atlanta", "Denver"},
				{"Denver", "El Paso", "Atlanta", "Boston", "Chicago"},
				{"El Paso", "Atlanta", "Boston", "Chicago", "Denver"}};
		StableMatching gs = new StableMatching(h, s, hp, sp);
	}
}