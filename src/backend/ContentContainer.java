package backend;
/**
 * Inteface to make sure classes that have some sort of a collection that stores contents implement the nececcary methods
 * to allow for contents to be deleted and added. 
 * @author batu
 *
 */
public interface ContentContainer {
	boolean removeContent(Content content);
	boolean addContent(Content content);
}
