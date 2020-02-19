public class AddStrings {

    public String addStrings(String num1, String num2) {
        if(num1 == null && num2 == null)
            return null;
        if(num1.length()<=0 && num2.length() <=0)
            return null;
        if(num1 == null || num1.length() == 0)
            return num2;
        if(num2 == null || num2.length() ==0)
            return num1;
        char[] ch = num1.toCharArray();
        char [] ch2 = num2.toCharArray();
        char[] largeArray = null;
        char [] smallArray = null;
              if(ch.length != ch2.length)  {
                  largeArray =  ch.length>ch2.length?ch:ch2;
                  smallArray =   ch.length<ch2.length?ch:ch2;
              } else {
                  largeArray = ch;
                  smallArray = ch2;
              }



        String sum = "";
        int carry = 0;
        int idx2 = largeArray.length-1;
        for(int i=smallArray.length-1;i>=0;i--){
            int i1 = smallArray[i] -'0';
            int i2 = largeArray[idx2--] - '0';
            int i3 = i1+i2+carry;
            if(i3 >9){
                carry = 1;
            } else {
                carry = 0;
            }
            sum = (i3%10) + sum;

        }
        while(idx2 >= 0){
            int i = (largeArray[idx2--] - '0') + carry;
            carry = i>9?1:0;
            sum = (i%10) +sum ;
        }

        if(carry > 0){
            sum = carry + sum;
        }
        /*for (char c : ch) {
            System.out.println("char::"+c);
            System.out.println("char::"+(c+0));
        }*/

        return sum.toString();
    }

    public static void main(String[] args) {
        AddStrings a = new AddStrings();
        System.out.println( a.addStringLessMemory("0","9"));
    }

    public String addStringLessMemory(String num1,String num2){
        if(num1 == null && num2 == null)
            return null;
        if(num1.length()<=0 && num2.length() <=0)
            return null;
        if(num1 == null || num1.length() == 0)
            return num2;
        if(num2 == null || num2.length() ==0)
            return num1;

        int idx = num1.length()-1;
        int idx2 = num2.length()-1;

        String sum = "";
        int carry = 0;
        while(idx>=0 && idx2>=0){
            int i1 = num1.charAt(idx--) -'0';
            int i2 = num2.charAt(idx2--)- '0';
            int i3 = i1+i2+carry;
            if(i3 >9){
                carry = 1;
            } else {
                carry = 0;
            }
            sum = (i3%10) + sum;

        }

        while(idx >= 0){
            int i = num1.charAt(idx--) -'0'+ carry;
            carry = i>9?1:0;
            sum = (i%10) +sum ;
        }

        while(idx2 >= 0){
            int i = num2.charAt(idx2--) -'0' + carry;
            carry = i>9?1:0;
            sum = (i%10) +sum ;
        }

        if(carry > 0){
            sum = carry + sum;
        }
        /*for (char c : ch) {
            System.out.println("char::"+c);
            System.out.println("char::"+(c+0));
        }*/

        return sum.toString();

    }
}
