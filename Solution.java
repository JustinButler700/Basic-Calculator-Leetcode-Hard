class Solution {
    int index = 0;
    public int calculate(String s) {
        //Init a DFS to evaluate our string.
        return dfs(s.toCharArray());
    }
    public int dfs(char[] s){
        int sum = 0;
        int sign = 1; // keep track of the sign (either + or -)
        int num = 0; // Holder of the current char digit.
        while(index < s.length){
            if(s[index]==')'){
                break;
            }
            //Every time we see a (, we parse the problem down into a sub problem using DFS
            else if(s[index]=='('){
                index++;
                sum += dfs(s) * sign;
            }
            else if(s[index]=='+'){
                sign = 1;
            }
            else if(s[index]=='-'){
                sign = -1;
            }
            else if(Character.isDigit(s[index])){
                //Parse the integers we are operating on.
                num = num * 10 + (s[index] - '0');
                //When we encounter the end of a number, we add it to the sum.
                if(index == s.length - 1 || !Character.isDigit(s[index + 1])){
                    sum += num * sign;
                    num = 0;
                }
            }
            index++;
        }
        return sum;
    }
}
