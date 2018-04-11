package ueb02;

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
            int s = 1;

                if (left != null) {
                    s += left.size();
                }
                if (right != null) {
                    s += right.size();
                }

            return s;
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
                } else {
                    root = it.left;
                    addElement(it.right);
                }
            }
            return root.s;
        }

        public void addElement(Element e) {
            Element it = root;
            if (root == null) {
                root = e;
            }
            while (it != null) {
                if (e.s.compareTo(it.s) < 0) {
                    if (it.left == null) {
                        it = e;
                    } else {
                        it = it.left;
                    }
                } else {
                    if (e.s.compareTo(it.s) > 0) {
                        if (it.right == null) {
                            it = e;
                        } else {
                            it = it.right;
                        }
                    }
                }
            }
        }

        public void removeElement(Element p, Element e) {
            if (e == p.left) {
                p.left = null;
            } else {
                p.right = null;
            }
            addElement(e.left);
            addElement(e.right);
        }
    }

    Element root;


    @Override
    public boolean add(String s) {

        if (root == null) {
            root = new Element(s, null, null);
            return true;
        }
        Element it=root;
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
        }
        return false;
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
        }
        return false;
    }

    @Override
    public void remove(String s) {
        Element it = root;
        if (root == null) {
            throw new NoSuchElementException();
        }
        if (it.s.equals(s)) {
            it.removeRoot();
        }
                while (it != null) {
                    if (it.s.compareTo(s) < 0) {
                        if (it.left != null && it.left.s.equals(s))
                            it.removeElement(it, it.left);
                        it = it.left;
                    } else {
                        if (it.right != null && it.right.s.equals(s))
                            it.removeElement(it, it.right);
                        it = it.right;
                    }
                }
                throw new NoSuchElementException();
            }
    public int size (){
        return root.size();
    }
}


