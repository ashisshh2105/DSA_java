class Solution {
    public boolean buddyStrings(String s, String goal) {

if (s.length () != goal.length()){
    return false;
}

if (s.equals(goal)){

    for(int i=0;i<s.length();i++){
        for (int j=i+1;j<s.length();j++){
            if (s.charAt(i)==s.charAt(j)){
                return true;
            }
        }
    }

return false;

}

int count =0;
int first=-1;
int second =-1;


        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != goal.charAt(i)) {

                count++;

                if (first == -1) {
                    first = i;
                } else {
                    second = i;
                }
            }
        }

        // Must have exactly 2 differences
        if (count != 2) {
            return false;
        }

        // Check swap
        return s.charAt(first) == goal.charAt(second)
                && s.charAt(second) == goal.charAt(first);
    }
}