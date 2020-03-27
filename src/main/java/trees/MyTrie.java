package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyTrie {
    Character _character;
    private List<Integer> _locations;
    private Map<Character, MyTrie> _nodes = new HashMap<>();

    public List<Integer> findAll(String prefix, Trie trie, int position) {
        //if (trie.search(prefix))
        return null;
    }

    public MyTrie(){

    }

    public MyTrie(Character character) {
        _character = character;
        _locations = new LinkedList<>();
    }

    // record a substring location.
    public void add(String chars, Integer location) {
        if (_character != null)
            // note: this trie variant records at each node, not just leaf nodes (simpler, less space efficient).
            _locations.add(location);
        if (chars.length() > 0) {
            char c = chars.charAt(0);
            _nodes.putIfAbsent(c, new MyTrie(c));
            _nodes.get(c).add(chars.substring(1), location);
        }
    }

    // retrieve locations for substring
    public List<Integer> search(String prefix) {
        if (prefix.length() > 0) {
            char c = prefix.charAt(0);
            if (_nodes.containsKey(c))
                return _nodes.get(c).search(prefix.substring(1));
            else
                return new LinkedList<>();
        } else {
            return _locations;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] pattern = {"same", "family", "different", "family", "separate", "existence", "members", "of", "the","league"};

        String txt = "Lan The European publishing languages are members of the same family. l Their separate existence is a myth pub";
        String[] strings = txt.split(" ");
        MyTrie myTrie = new MyTrie();
        for(int i =0;i<strings.length;i++) {
            myTrie.add(strings[i].toLowerCase(), i+1);
        }

        System.out.println(myTrie);

        List<Integer> locs =  myTrie.search("la");
        System.out.println(locs);
    }

}
