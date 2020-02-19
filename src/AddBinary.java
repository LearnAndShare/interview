public class AddBinary {
    public String addBinary(String a, String b) {
            char [] aChar = a.toCharArray();
            char [] bChar = b.toCharArray();
            int idx1 = aChar.length-1;
            int idx2 = bChar.length-1;
            int carry = 0;
            String sum = "";
            while(idx1 >=0 || idx2>=0){
                int x = idx1 <0?0:aChar[idx1--] - '0';
                int y = idx2<0?0:bChar[idx2--] - '0';
                sum = (x^y^carry )+ sum;
                carry = (x &y) |x&carry|y&carry;
            }

            if(carry == 1){
                sum = "1"+ sum;
            }
            return sum;
    }

    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("1010","1011"));
    }
}
