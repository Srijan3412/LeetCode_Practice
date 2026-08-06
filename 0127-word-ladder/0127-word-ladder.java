class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> que=new LinkedList<>();
        Set<String> wl=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            wl.add(wordList.get(i));
        }
        que.add(beginWord);
        wl.remove(beginWord);
        int count=1;
        if(!wl.contains(endWord))return 0; 

        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                String word=que.poll();
                for(int j=0;j<word.length();j++){
                    char[] letters=word.toCharArray();
                    char ori=letters[j];
                    for(char ch='a';ch<='z';ch++){
                        if(ch==ori) continue;
                        letters[j]=ch;
                        String str=new String(letters);

                        if(wl.contains(str)){
                            if(str.equals(endWord))
                                return count+1;
                            que.add(str);
                            wl.remove(str);
                        }
                    }
                }
              
            }count++; 
        }
        return 0;
    }
}