package model;
/**
 * Se lanzará esta excepcion cuando el tamaño del arhivo o del arreglo sean diferentes uno del otro.
 * @author osscar
 *
 */
public class DifferentSizesException extends Exception{
	public DifferentSizesException(String mensaje) {
		super(mensaje);
	}
}
