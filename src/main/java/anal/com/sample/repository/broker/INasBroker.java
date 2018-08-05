package anal.com.sample.repository.broker;

import anal.com.sample.model.Nas;

import java.util.List;

public interface INasBroker {
    public abstract void saveOrUpdate(Nas nas);
    public abstract List<Nas> getAllNas();
    public abstract Nas getNasByNasname(String nasName);


}
