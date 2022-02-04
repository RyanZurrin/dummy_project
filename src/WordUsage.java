public class WordUsage {
	private final String word;
	private int count;
	// constructor with word and setting count to 1
	public WordUsage(String word) {
		this.word = word;
		count = 1;
	}
	// constructor with word and count
	public WordUsage(String word, int count) {
		this.word = word;
		this.count = count;
	}
	// getter for word
	public String getWord() {
		return word;
	}
	// getter for count
	public int getCount() {
		return count;
	}
	// mutator for count add 1
	public void increment() {
		count++;
	}
	// setter for count
	public void setCount(int count) {
		this.count = count;
	}
	// toString method
	public String toString() {
		return word + ": " + count;
	}
}