package ueb02;

public class StringSetImpl implements StringSet {
    class Element {
        String value;
        Element right, left;

        Element (String v, Element r, Element l){
            this.left = l;
            this.right = r;
            this.value = v;
        }
    }
    public boolean addElement(Element e){
        Element root = null;
        if(e == null){
            return false;
        }

        if(root == null){
            root = e;
        }

        Element it = null;

        while(it != null){
            int c = e.value.compareTo(it.value);

            if(c==0){
                return false;
            }

            if(c<0){
                if(it.left == null) {
                    it.left = e;
                    return true;
                }
                else {
                    it = it.left;
                }

            }

            if(c>0){
                if(it.right == null){
                    it.right = e;
                    return true;
                }
                else {
                    it = it.right;
                }
            }
        } return false;
    }

    @Override
    public boolean add(String s) {
        return addElement(new Element(s, null, null));
    }
    @Override
    public boolean contains(String s) {
        Element root = null;

        if (root == null){
            return false;
        }

        Element it = root;
        int c = s.compareTo(it.value);

        if (c == 0){
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

    }

    @Override
    public int size() {
        return 0;
    }
}
