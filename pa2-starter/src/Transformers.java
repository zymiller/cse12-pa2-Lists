
class UpperCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		return s.toUpperCase();
	}

}

class multiplyBy10 implements MyTransformer<Integer> {
	
	public Integer transformElement(Integer n) {
		return n * 10;
	}
}

class ASCIITransformer implements MyTransformer<String> {
	
	public String transformElement(String s) {
		byte[] bytes = s.getBytes();
		return new String(bytes);
	}
}

// Add your transformers here