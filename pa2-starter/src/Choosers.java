
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

} 

class evenNumChooser implements MyChooser<Integer> {
	
	@Override
	public boolean chooseElement(Integer n) {
		if (n % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
			
}

class vowelChooser implements MyChooser<String> {
	
	@Override
	public boolean chooseElement(String s) {
		String[] vowels = {"a", "e", "i", "o", "u"};
		for (String i : vowels) {
			if (s.contains(i)) {
				return true;
			}
		}
		return false;
	}
}

// Add your choosers here