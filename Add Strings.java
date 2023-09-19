class Solution {
  public String addStrings(String num1, String num2) {
		int carry = 0;
		StringBuilder res = new StringBuilder();
		for (int i=num1.length()-1,j=num2.length()-1;i>=0||j>=0;i--,j--) {
			int a = i < 0 ? 0 : num1.charAt(i) - '0';
			int b = j < 0 ? 0 : num2.charAt(j) - '0';
			int sum=(a + b + carry);
			res.append(sum % 10);
			carry = sum / 10;
		}
		return (carry == 1 ? res.append('1') : res).reverse().toString();
	}
}
