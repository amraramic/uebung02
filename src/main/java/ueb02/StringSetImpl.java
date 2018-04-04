package ueb02;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import javax.xml.bind.Element;
import java.util.NoSuchElementException;

public class StringSetImpl implements StringSet {
    class Element {
        String s;
        Element left;
        Element right;

        Element(String s, Element left, Element right) {
            this.s = s;
            this.left = left;
            this.right = right;
        }

        public int size() {
            Element it = root;
            int s = 1;
            while (it != null) {
                if (it.left != null) {
                    s += it.left.size();
                }
                if (it.right != null) {
                    s += it.right.size();
                }
            }
            return it.size();
        }

        public String removeRoot() {
            Element it = root;
            if (it.left == null && it.right == null) {
                root = null;
            }
            if ((it.left != null) && (it.right == null)) {
                root = it.left;
            } else {
                if ((it.left == null) && (it.right != null)) {
                    root = it.right;
                }
            }
        }
    }

    Element root;


    @Override
    public boolean add(String s) {

        if (root == null) {
            root = new Element(s, null, null);
            return true;
        }
        Element it = root;
        while (it != null) {
            if (s.compareTo(it.s) < 0) {
                it = new Element(s, null, null);
                it.left = it;
                return true;
            } else {
                if (s.compareTo(it.s) > 0) {
                    it = new Element(s, null, null);
                    it.right = it;
                    return true;

                }
            }
        } return false;
    }

    @Override
    public boolean contains(String s) {
        if (root == null) {
            return false;
        }
        Element it = root;
        while (it != null) {
            if (s.equals(it.s)) {
                return true;
            } else {
                if (s.compareTo(it.s) < 0) {
                    it = it.left;
                } else {
                    it = it.right;
                }
            }
        }  return false;
    }
    @Override
    public String remove(String s) {
        Element it = root;
        if (root == null){
            throw new NoSuchElementException();
        }
        if (it.left.s.equals(s)){
            it.left.removeElement();
        }
        return null;
    }

    @Override
    public int size() {
            if (root == null){
                return 0;
            }
            return root.size();
    }
}
