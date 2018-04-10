package ueb02;

interface StringSet {
	/**
	 * Fügt das übergebene Element in das Set ein.
	 * @param s
	 * @return true, wenn `s` neu eingefügt wurde, false wenn es bereits enthalten war
	 */
	boolean add(String s);

	/**
	 * Prüft, ob ein Element im Set enthalten ist.
	 */
	boolean contains(String s);

	/**
	 * Entfernt ein Element aus dem Set; wirft eine NoSuchElementException
	 * wenn das Element nicht enthalten war.
	 *
	 * @return Das entfernte Element
	 * @throws java.util.NoSuchElementException Wenn das Element nicht vorhanden war.
	 */
	void remove(String s);

	/**
	 * Gibt die Größe des Sets zurück
	 */
	int size();
}
