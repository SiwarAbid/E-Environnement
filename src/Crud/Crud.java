package Crud;

import javafx.collections.ObservableList;

public interface Crud<Objet> {

	public ObservableList<Objet> getAll();
	public int add(Objet o);
	public int delete(Objet o);
	public int update(Objet o);
	public ObservableList<Objet> get(int id);
}
