package FileParser;

public class WordData implements Comparable<WordData> {
	private String word;
	int count;
	//Constructor
	public WordData(String word) {
		this.word = word;
		this.count = 1;
	}
	
	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordData other = (WordData) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} 
		else if (!word.equals(other.word))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "WordData [word=" + word + ", count=" + count + "]";
	}

	@Override
	public int compareTo(WordData o) {
		//this.word is alphabetically greater.
		if(this.word.compareTo(o.word) > 0) {
			return 1;
		}
		//this.word is alphabetically lower.
		else {
			return -1;
		}
	}

	
}
