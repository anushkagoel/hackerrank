package main.problems;

public class XOR {
        class Node{
            Node links[] = new Node[2];
            Node(){

            }
            boolean containsKey(int n){
                return links[n] != null;
            }
            void put(int n , Node node){
                links[n] = node;
            }
            Node get(int n){
                return links[n];
            }
        }
        class Trie{
            Node root;
            Trie(){
                root = new Node();
            }
            void insert(int n){
                Node node = root;
                for(int i = 31; i >= 0; i--){
                    int bit = (n & (1 << i)) == 0 ? 0 : 1;
                    if(!node.containsKey(bit)){
                        node.put(bit , new Node());
                    }
                    node = node.get(bit);
                }
            }
            int getMax(int n){
                Node node = root;
                int res = 0;
                for(int i =  31; i >= 0; i--){
                    int reqBit = (n & (1 << i)) == 0 ? 1 : 0;
                    if(node.containsKey(reqBit)){
                        res |= (1 << i);
                        node = node.get(reqBit);
                    }
                    else{
                        node = node.get(1 - reqBit);
                    }
                }
                return res;
            }
        }
        public int findMaximumXOR(int[] a) {
            Trie t = new Trie();
            for(int i = 0; i < a.length; i++){
                t.insert(a[i]);
            }
            int max = 0;
            for(int i = 0; i < a.length; i++){
                max = Math.max(max , t.getMax(a[i]));
            }
            return max;
        }
    }
