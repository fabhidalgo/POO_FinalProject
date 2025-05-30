package DataAccesObject;
import java.util.List;
public interface IBaseDAO<T> {
    public int Create(T input);
    public T Read(String id);
    public List<T>ReadAll();
    public int Update(T input);
    public int Delete(String id);
    
}
