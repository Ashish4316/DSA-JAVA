class Solution {
    public String decodeCiphertext(String encodedText, int rows){
        if(rows == 1){
            return encodedText;
        } 
        int n = encodedText.length();
        int cols = n / rows;
        char[] encoded = encodedText.toCharArray();  
        char[] result = new char[n];                 
        int pos = 0;
        for(int c = 0; c < cols; c++){
            for(int dest = c; dest < n; dest += cols + 1){
                result[pos++] = encoded[dest];       
            }
        }
        while(pos > 0 && result[pos - 1] == ' ')pos--;
        return new String(result, 0, pos);
    }
}