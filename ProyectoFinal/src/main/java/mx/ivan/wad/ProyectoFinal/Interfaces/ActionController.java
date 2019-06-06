package mx.ivan.wad.ProyectoFinal.Interfaces;

public interface ActionController<T> {
	Service<T> getService();
	void setService(Service<T> service);
}
