class Trie {
    TrieNode root;
    public class TrieNode{
        TrieNode[] arr;
        boolean end;
        TrieNode (){
            arr=new TrieNode[26];
            this.end=false;
        }
    }
    public Trie() {
    this.root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur=root;
        int c;
        for(int i=0;i<word.length();i++)
        {
            c=word.charAt(i)-'a';
            if(cur.arr[c]==null)
            {
                cur.arr[c]=new TrieNode();
            }
            cur=cur.arr[c];
        }
        cur.end=true;
    }
    
    public boolean search(String word) {
        TrieNode cur=root;
        int c;
        for(int i=0;i<word.length();i++)
        {
            c=word.charAt(i)-'a';
            if(cur.arr[c]==null)
            {
                return false;
            }
            cur=cur.arr[c];
        }
        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
         TrieNode cur=root;
        int c;
        for(int i=0;i<prefix.length();i++)
        {
            c=prefix.charAt(i)-'a';
            if(cur.arr[c]==null)
            {
                return false;
            }
            cur=cur.arr[c];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */