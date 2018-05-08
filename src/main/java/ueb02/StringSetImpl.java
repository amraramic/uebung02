package ueb02;

import java.util.NoSuchElementException;

public class StringSetImpl implements StringSet {
    class Element {
        String value;
        Element right, left;

        Element(String v, Element r, Element l) {
            this.left = l;
            this.right = r;
            this.value = v;
        }

        public int size() {
            int len = 1;

            if (left != null) {
                len += left.size();
            }
            if (right != null) {
                len += right.size();
            }
            return len;
        }
    }

    Element root = null;

    public String removeRoot (){
        Element it = root;

        if (it.left == null && it.right==null){
            root = null;
        }
        if (it.right == null){
            root = it.left;
        }

        if (it.left == null){
            root = it.right;
        }

        else {
            root = it.right;
            addElement(it.left);
        }
        return it.value;
    }

    public String removeElement(Element p, Element it) {

        if (it == p.left) {
            p.left = null;
        } else {
            p.right = null;
        }
        addElement(it.left);
        addElement(it.right);

        return it.value;
    }

    public boolean addElement(Element e) {

        if (e == null) {
            return false;
        }

        if (root == null) {
            root = e;
        }

        Element it = null;

        while (it != null) {
            int c = e.value.compareTo(it.value);

            if (c == 0) {
                return false;
            }

            if (c < 0) {
                if (it.left == null) {
                    it.left = e;
                    return true;
                } else {
                    it = it.left;
                }

            }

            if (c > 0) {
                if (it.right == null) {
                    it.right = e;
                    return true;
                } else {
                    it = it.right;
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(String s) {
        return addElement(new Element(s, null, null));
    }

    @Override
    public boolean contains(String s) {

        if (root == null) {
            return false;
        }

        Element it = root;
        int c = s.compareTo(it.value);

        if (c == 0) {
            return true;
        } else {
            if (c < 0) {
                it = it.left;
            } else {
                it = it.right;
            }
        }
        return false;
    }

    @Override
    public void remove(String s) {
        Element it = root;

        if (root == null) {
            throw new NoSuchElementException();
        }
        if (s.equals(root.value)){
            removeRoot();
        }
        while (it != null){
            if (it.left != null && s.equals(it.left.value)){
                removeElement(it, it.left);
                it = it.left;
            }
            if (it.right != null && s.equals(it.right.value)){
                removeElement(it, it.right);
                it = it.right;
            }

        }
        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        } else {
            return root.size();
        }
    }
}
